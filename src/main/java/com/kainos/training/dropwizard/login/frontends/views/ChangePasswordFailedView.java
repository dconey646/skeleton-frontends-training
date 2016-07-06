package com.kainos.training.dropwizard.login.frontends.views;

import io.dropwizard.views.View;

/**
 * Created by thomasf on 05/07/2016.
 */
public class ChangePasswordFailedView extends View {

    public ChangePasswordFailedView() {
        super("/passwordchanged_failed.ftl");
    }
}
