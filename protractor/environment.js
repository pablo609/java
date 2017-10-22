export function getTestUserPassword() {
    return process.env.TEST_USER_PASSWORD;
}

export function getTestUserName() {
    return process.env.TEST_USER_NAME;
}

export function isSitEnv() {
    return process.env.DTAP === 'sit';
}

export function isDevEnv() {
    return process.env.DTAP === 'dev';
}

export function isLocalEnv() {
    return !(isSitEnv() || isDevEnv());
}