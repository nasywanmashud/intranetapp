package com.intranet.app.ui.Presenter;

import com.intranet.app.api.ApiRequestHandler;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginPresenter_MembersInjector implements MembersInjector<LoginPresenter> {
  private final Provider<ApiRequestHandler> apiRequestHandlerProvider;

  private final Provider<Bus> busProvider;

  public LoginPresenter_MembersInjector(
      Provider<ApiRequestHandler> apiRequestHandlerProvider, Provider<Bus> busProvider) {
    assert apiRequestHandlerProvider != null;
    this.apiRequestHandlerProvider = apiRequestHandlerProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<LoginPresenter> create(
      Provider<ApiRequestHandler> apiRequestHandlerProvider, Provider<Bus> busProvider) {
    return new LoginPresenter_MembersInjector(apiRequestHandlerProvider, busProvider);
  }

  @Override
  public void injectMembers(LoginPresenter instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.apiRequestHandler = apiRequestHandlerProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectApiRequestHandler(
      LoginPresenter instance, Provider<ApiRequestHandler> apiRequestHandlerProvider) {
    instance.apiRequestHandler = apiRequestHandlerProvider.get();
  }

  public static void injectBus(LoginPresenter instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
