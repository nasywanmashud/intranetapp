package com.intranet.app.ui.Activity.Pop;

import com.intranet.app.ui.Presenter.LoginPresenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PopFragment_MembersInjector implements MembersInjector<PopFragment> {
  private final Provider<LoginPresenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public PopFragment_MembersInjector(
      Provider<LoginPresenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<PopFragment> create(
      Provider<LoginPresenter> presenterProvider, Provider<Bus> busProvider) {
    return new PopFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(PopFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      PopFragment instance, Provider<LoginPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(PopFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
