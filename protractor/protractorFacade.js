const DEFAULT_WAIT_TIMEOUT = 30000;
const DEFAULT_CONTINUE_AFTER_TIMEOUT = 3000;

export function waitForPresenceOf(elementFinder, timeout = DEFAULT_WAIT_TIMEOUT) {
    browser.wait(protractor.ExpectedConditions.presenceOf(elementFinder), timeout);
}

export function waitForStalenessOf(elementFinder, timeout = DEFAULT_WAIT_TIMEOUT) {
    browser.wait(protractor.ExpectedConditions.stalenessOf(elementFinder), timeout)
}

export function waitForVisibilityOf(elementFinder, timeout = DEFAULT_WAIT_TIMEOUT) {
    browser.wait(protractor.ExpectedConditions.visibilityOf(elementFinder), timeout);
}

export function waitForUrlIs(url, timeout = DEFAULT_WAIT_TIMEOUT) {
    browser.wait(protractor.ExpectedConditions.urlIs(url), timeout);
}

export function waitForUrlContains(url, timeout = DEFAULT_WAIT_TIMEOUT) {
    browser.wait(protractor.ExpectedConditions.urlContains(url), timeout);
}

export function continueAfterWaitingForPresenceOf(elementFinder, timeout = DEFAULT_CONTINUE_AFTER_TIMEOUT) {
    browser.wait(protractor.ExpectedConditions.presenceOf(elementFinder), timeout)
        .catch(() => {});
}