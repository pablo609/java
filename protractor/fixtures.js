import {put, post, get, handleResponse} from "./wsClient";
import moment from "moment";
import URL from "url-parse";

export function createWorkflowExecution(pickRequest, workflowType) {
    const controlFlow = browser.controlFlow();

    console.log('dafa');

    controlFlow.execute(() => {
        return requestAccessTokenWithScope('fulman_order')
            .then(getClosedWorkflowExecutions(workflowType));
    }).then(verifyIfResponseContains(pickRequest.routes[0].routeId));

}

function requestAccessTokenWithScope(scope) {
    const clientId = 'aaaa';
    const clientSecret = 'bbbb';
    let deferred = protractor.promise.defer();

    get('https://jsonplaceholder.typicode.com/posts',
        {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        })
        .then(handleResponse(deferred))
        .catch((error) => {
            deferred.reject(error);
        });

    return deferred.promise;
}

function setDashboardWorkflowSources(value) {
    return (response) => {
        const accessToken = extractAccessToken(response);
        let deferred = protractor.promise.defer();

        put(`${getConfig().dashboardUrl}/settings/workflow-sources`,
            {
                headers: newBaseHeaders(accessToken),
                body: newSettingsBody('availableAppIds', value)
            })
            .then(handleResponse(deferred))
            .catch((error) => {
                deferred.reject(error);
            })

        return deferred.promise;
    };
}

function setDashboardWorkflowSourcesIndex(value) {
    return (response) => {
        const accessToken = extractAccessToken(response);
        let deferred = protractor.promise.defer();

        put(`${getConfig().dashboardUrl}/settings/workflow-sources.index`,
            {
                headers: newBaseHeaders(accessToken),
                body: newSettingsBody('implementation', value)
            })
            .then(handleResponse(deferred))
            .catch((error) => {
                deferred.reject(error);
            })

        return deferred.promise;
    };
}

function sendOrderPickRequest(pickRequest) {
    return (response) => {
        const accessToken = extractAccessToken(response);
        let deferred = protractor.promise.defer();

        post(`${getConfig().orderUrl}/v1/channel-api/delivery-types/BRANDED_VAN/pick`,
            {
                headers: newBaseHeaders(accessToken),
                body: JSON.stringify(pickRequest)
            })
            .then(handleResponse(deferred))
            .catch((error) => {
                deferred.reject(error);
            })

        return deferred.promise;
    };
}

function reindexWorkflowExecutions(customScope = 'PT3M') {
    return (response) => {
        const accessToken = extractAccessToken(response);
        let deferred = protractor.promise.defer();

        post(`${getConfig().dashboardUrl}/executions/index?customScope=${customScope}`,
            {
                headers: newBaseHeaders(accessToken)
            })
            .then(handleResponse(deferred))
            .catch((error) => {
                deferred.reject(error);
            })

        return deferred.promise;
    }
}

function getClosedWorkflowExecutions(workflowType, customScopeSec = 60) {
    return (response) => {
        const accessToken = extractAccessToken(response);
        let deferred = protractor.promise.defer();

        const url = new URL(`/workflows/${workflowType}/executions?executionStatus=CLOSED&oldestDate=2017-08-02T08%3A22%3A00Z&includeData=false&limit=50`, getConfig().orderUrl, true);
        url.query['oldestDate'] = moment.utc().subtract(customScopeSec, 's').toISOString();

        get(url.toString(),
            {
                headers: newBaseHeaders(accessToken)
            })
            .then(handleResponse(deferred))
            .catch((error) => {
                deferred.reject(error);
            })

        return deferred.promise;
    }
}

function verifyIfResponseContains(routeId) {
    return (response) => {
        let found = false;
        JSON.parse(response).executions.forEach((currentValue) => {
            currentValue.tagList.forEach((currentValue) => {
                if (currentValue === routeId) {
                    found = true;
                }
            })
        });

        if (!found) {
            fail(`Workflow execution for ${routeId} was not completed`);
        }
    }
}

function extractAccessToken(response) {
    return JSON.parse(response).access_token;
}

function newBaseHeaders(accessToken) {
    return {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${accessToken}`,
        'AccessPolicy': getConfig().authentication.accessPolicy,
        'AccessSignature': getConfig().authentication.accessSignature,
    };
}

function newSettingsBody(key, currentValue) {
    return `{
        "entries": [{
            "currentValue": "${currentValue}",
            "key": "${key}"
        }]
    }`;
}