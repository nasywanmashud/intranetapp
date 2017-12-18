package com.intranet.app.ui.Activity.Login;

import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Presenter.LoginPresenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LoginFragment_MembersInjector implements MembersInjector<LoginFragment> {
  private final Provider<LoginPresenter> presenterProvider;

  private final Provider<ClockPresenter> presentersProvider;

  private final Provider<Bus> busProvider;

  public LoginFragment_MembersInjector(
      Provider<LoginPresenter> presenterProvider,
      Provider<ClockPresenter> presentersProvider,
      Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert presentersProvider != null;
    this.presentersProvider = presentersProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<LoginFragment> create(
      Provider<LoginPresenter> presenterProvider,
      Provider<ClockPresenter> presentersProvider,
      Provider<Bus> busProvider) {
    return new LoginFragment_MembersInjector(presenterProvider, presentersProvider, busProvider);
  }

  @Override
  public void injectMembers(LoginFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.presenters = presentersProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      LoginFragment instance, Provider<LoginPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenters(
      LoginFragment instance, Provider<ClockPresenter> presentersProvider) {
    instance.presenters = presentersProvider.get();
  }

  public static void injectBus(LoginFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
