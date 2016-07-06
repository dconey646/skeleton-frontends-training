package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.training.dropwizard.login.frontends.views.*;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewsResourceTest {
	//Tests go here....
    ViewsResource viewsResource;
    LoginClient loginClient;

    @Before
    public void setup() {
        loginClient = mock(LoginClient.class);
        viewsResource = new ViewsResource(loginClient);
        viewsResource.loginDetails("admin", "password");
    }

    @Test
    public void viewResourceReturnTest() {
        Assert.assertEquals(viewsResource.login().getClass().getSimpleName(), "Index");
    }

    @Test
    public void correctLoginDetailsTest() {
        when(loginClient.getLogin("admin", "password")).thenReturn(true);
        Assert.assertThat(viewsResource.loginDetails("admin", "password"), instanceOf(LoginSuccessView.class));
    }

    @Test
    public void incorrectLoginDetailsTest() {
        when(loginClient.getLogin("falseUser", "password")).thenReturn(false);
        Assert.assertThat(viewsResource.loginDetails("falseUser", "password"), instanceOf(LoginFailureView.class));
    }

    @Test
    public void nullLoginDetailsTest() {
        when(loginClient.getLogin(null, null)).thenReturn(false);
        Assert.assertThat(viewsResource.loginDetails(null, null), instanceOf(LoginFailureView.class));
    }

    @Test
    public void successfulRegistrationTest() {
        when(loginClient.register("Thomas", "password")).thenReturn(true);
        Assert.assertThat(viewsResource.registerDetails("Thomas", "password"), instanceOf(RegisterSuccessView.class));
    }

    @Test
    public void successfulChangePasswordTest() {
        when(loginClient.changePassword("admin", "password", "pass")).thenReturn(true);
        Assert.assertThat(viewsResource.changePasswordDetails("admin", "password", "pass"),
                instanceOf(ChangePasswordSuccessView.class));
    }

    @Test
    public void failureToChangePasswordTest() {
        when(loginClient.changePassword("admin", "pass", "password")).thenReturn(false);
        Assert.assertThat(viewsResource.changePasswordDetails("admin", "pass", "password"),
                instanceOf(ChangePasswordFailedView.class));
    }

}
