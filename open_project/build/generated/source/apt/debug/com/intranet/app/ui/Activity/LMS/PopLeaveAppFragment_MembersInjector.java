package com.intranet.app.ui.Activity.LMS;

import com.intranet.app.ui.Presenter.LoginPresenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PopLeaveAppFragment_MembersInjector
    implements MembersInjector<PopLeaveAppFragment> {
  private final Provider<LoginPresenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public PopLeaveAppFragment_MembersInjector(
      Provider<LoginPresenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<PopLeaveAppFragment> create(
      Provider<LoginPresenter> presenterProvider, Provider<Bus> busProvider) {
    return new PopLeaveAppFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(PopLeaveAppFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      PopLeaveAppFragment instance, Provider<LoginPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(PopLeaveAppFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
