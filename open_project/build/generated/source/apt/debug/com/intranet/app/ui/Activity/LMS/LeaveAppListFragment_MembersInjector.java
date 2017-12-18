package com.intranet.app.ui.Activity.LMS;

import com.intranet.app.ui.Presenter.ClockPresenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class LeaveAppListFragment_MembersInjector
    implements MembersInjector<LeaveAppListFragment> {
  private final Provider<ClockPresenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public LeaveAppListFragment_MembersInjector(
      Provider<ClockPresenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<LeaveAppListFragment> create(
      Provider<ClockPresenter> presenterProvider, Provider<Bus> busProvider) {
    return new LeaveAppListFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(LeaveAppListFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      LeaveAppListFragment instance, Provider<ClockPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(LeaveAppListFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
