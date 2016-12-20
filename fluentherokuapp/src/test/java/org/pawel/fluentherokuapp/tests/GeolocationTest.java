package org.pawel.fluentherokuapp.tests;

import org.junit.Before;
import org.junit.Test;
import org.pawel.fluentherokuapp.pages.GeolocationPage;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pawel on 2016-12-20.
 */
public class GeolocationTest extends BaseTest {
    private GeolocationPage geolocationPage;

    @Before
    public void setUp() {
        geolocationPage = goTo(herokuappMainPage).clickGeolocationLink();
        geolocationPage.isAt();
    }

    @Test
    public void testGeolocation() throws Exception {
        geolocationPage.clickWhereIAm();

        assertThat(geolocationPage.getLatitude()).isStrictlyBetween(50.00, 50.02);
        assertThat(geolocationPage.getLongitude()).isStrictlyBetween(19.87, 19.89);
    }
}
