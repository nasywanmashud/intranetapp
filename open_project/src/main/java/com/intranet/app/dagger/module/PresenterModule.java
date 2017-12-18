package com.intranet.app.dagger.module;

import android.content.Context;

import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Presenter.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    LoginPresenter provideLoginPresenter(Context context) {
        return new LoginPresenter(context);
    }

    @Provides
    @Singleton
    ClockPresenter provideClockPresenter (Context context) {
        return  new ClockPresenter(context);
    }



}

