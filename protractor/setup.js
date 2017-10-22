import LoginPage from "../pages/LoginPage";
import {isDevEnv, isLocalEnv, isSitEnv} from "./environment";
import {waitForUrlIs, waitForUrlContains} from "./protractorFacade";
import getConfig from '../config/configuration';
import RouteDownloadsPage from "../pages/RouteDownloadsPage";

export function loginTestUser() {
    const loginPage = new LoginPage();

    loginPage.get();
    if (isDevEnv() || isLocalEnv()) {
        loginPage.clickAdmin()
    }
    loginPage
        .setUserName(getConfig().testUserName)
        .setPassword(getConfig().testUserPassword)
        .clickLogIn();
    if(isSitEnv()) {
        loginPage.clickAdmin();
    }

    waitForUrlIs(getConfig().baseUrl);
}

export function logoutTestUser() {
    const routeDownloadsPage = new RouteDownloadsPage();

    routeDownloadsPage
        .get()
        .waitTillSpinnerIsGone()
        .clickUserIcon()
        .clickSignOut();

    waitForUrlContains('logoutSuccess');
}