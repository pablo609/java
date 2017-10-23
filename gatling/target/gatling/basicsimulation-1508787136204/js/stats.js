var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "20",
        "ok": "20",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "29",
        "ok": "29",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "76",
        "ok": "76",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "50",
        "ok": "50",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "18",
        "ok": "18",
        "ko": "-"
    },
    "percentiles1": {
        "total": "49",
        "ok": "49",
        "ko": "-"
    },
    "percentiles2": {
        "total": "68",
        "ok": "68",
        "ko": "-"
    },
    "percentiles3": {
        "total": "72",
        "ok": "72",
        "ko": "-"
    },
    "percentiles4": {
        "total": "75",
        "ok": "75",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 20,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1.333",
        "ok": "1.333",
        "ko": "-"
    }
},
contents: {
"req_request-1-46da4": {
        type: "REQUEST",
        name: "request_1",
path: "request_1",
pathFormatted: "req_request-1-46da4",
stats: {
    "name": "request_1",
    "numberOfRequests": {
        "total": "10",
        "ok": "10",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "62",
        "ok": "62",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "76",
        "ok": "76",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "68",
        "ok": "68",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "4",
        "ok": "4",
        "ko": "-"
    },
    "percentiles1": {
        "total": "68",
        "ok": "68",
        "ko": "-"
    },
    "percentiles2": {
        "total": "72",
        "ok": "72",
        "ko": "-"
    },
    "percentiles3": {
        "total": "74",
        "ok": "74",
        "ko": "-"
    },
    "percentiles4": {
        "total": "76",
        "ok": "76",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 10,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.667",
        "ok": "0.667",
        "ko": "-"
    }
}
    },"req_request-1-redir-7e85b": {
        type: "REQUEST",
        name: "request_1 Redirect 1",
path: "request_1 Redirect 1",
pathFormatted: "req_request-1-redir-7e85b",
stats: {
    "name": "request_1 Redirect 1",
    "numberOfRequests": {
        "total": "10",
        "ok": "10",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "29",
        "ok": "29",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "36",
        "ok": "36",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "32",
        "ok": "32",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "percentiles1": {
        "total": "32",
        "ok": "32",
        "ko": "-"
    },
    "percentiles2": {
        "total": "33",
        "ok": "33",
        "ko": "-"
    },
    "percentiles3": {
        "total": "36",
        "ok": "36",
        "ko": "-"
    },
    "percentiles4": {
        "total": "36",
        "ok": "36",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 10,
        "percentage": 100
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.667",
        "ok": "0.667",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
