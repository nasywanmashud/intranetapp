package com.intranet.app.ui.Presenter;

import android.content.Context;

import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.application.MainApplication;

import com.intranet.app.ui.Model.Request.LoginRequest;
import com.squareup.otto.Bus;

import javax.inject.Inject;

public class LoginPresenter {

    @Inject
    ApiRequestHandler apiRequestHandler;

    @Inject
    Bus bus;

    public LoginPresenter(Context context) {
        MainApplication.component(context).inject(this);
    }

    public void onResume() {
        bus.register(this);
    }

    public void onPause() {
        bus.unregister(this);
    }

    public void onLogin(LoginRequest data) {
        apiRequestHandler.onLoginRequest(data);
    }




}
