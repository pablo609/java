require('es6-promise').polyfill();
import fetch from "isomorphic-fetch";
import uuid from "uuid";

export function post(url, options) {
    return request(url, Object.assign({}, {method: 'post'}, options));
}

export function put(url, options) {
    return request(url, Object.assign({}, {method: 'put'}, options));
}

export function get(url, options) {
    return request(url, Object.assign({}, {method: 'get'}, options));
}

export function handleResponse(deferred) {
    return (response) => {
        console.log('===============================================');
        console.log(`Received response from ${response.url} - ${response.statusText}: ${response.status}`);
        console.log('===============================================');

        if (response.ok) {
            response.text()
                .then((text) => {
                    logPrettyOutputForJson(text);
                    return deferred.fulfill(text);
                })
        }
        else {
            const errorMessage = `Request to ${response.url} failed - ${response.statusText}: ${response.status}`;
            return deferred.reject(new Error(errorMessage));
        }
    }
}

function request(url, options) {
    process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';

    const requestId = `fulman-system-tests-${uuid.v4()}`;

    console.log('===============================================');
    console.log(`Sending request to ${url} with RequestId: ${requestId === undefined ? '' : requestId}`);
    console.log('===============================================');

    options.headers = Object.assign({}, {RequestId: requestId}, options.headers);

    return fetchWithRetries(url, Object.assign({}, {maxRetries: 5, retryDelay: 100}, options));
}

function fetchWithRetries(url, opt, maxRetries = 5, retryDelayMs = 500) {
    return new Promise((resolve, reject) => {
        let retryCount = 0;

        const doFetch = () => {
            fetch(url, opt)
                .then((response) => {
                    if (response.status >= 500) {
                        throw new Error(`${response.statusText}: ${response.status}`);
                    } else {
                        resolve(response);
                    }
                })
                .catch((err) => {
                    if (retryCount < maxRetries) {
                        retryCount++;

                        console.log('===============================================');
                        console.log(`Sending retry #${retryCount} to ${url} because of ${err.message}`);
                        console.log('===============================================');

                        setTimeout(doFetch, retryDelayMs);
                    } else {
                        err.message = `Reached max number of retries to ${url} because of ${err.message}`;
                        reject(err);
                    }
                });
        };

        doFetch();
    });
};

function logPrettyOutputForJson(text) {
    let output;
    try {
        output = JSON.stringify(JSON.parse(text), undefined, 2);
    }
    catch (e) {
        output = text;
    }
    console.log(output);
}