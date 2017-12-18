package com.intranet.app.ui.Activity.LMS.MyLeave;

import com.intranet.app.ui.Presenter.ClockPresenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MyLeaveFragment_MembersInjector implements MembersInjector<MyLeaveFragment> {
  private final Provider<Bus> busProvider;

  private final Provider<ClockPresenter> presenterProvider;

  public MyLeaveFragment_MembersInjector(
      Provider<Bus> busProvider, Provider<ClockPresenter> presenterProvider) {
    assert busProvider != null;
    this.busProvider = busProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<MyLeaveFragment> create(
      Provider<Bus> busProvider, Provider<ClockPresenter> presenterProvider) {
    return new MyLeaveFragment_MembersInjector(busProvider, presenterProvider);
  }

  @Override
  public void injectMembers(MyLeaveFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.bus = busProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(MyLeaveFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      MyLeaveFragment instance, Provider<ClockPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
