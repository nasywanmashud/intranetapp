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
public final class PopLeaveCalendarFragment_MembersInjector
    implements MembersInjector<PopLeaveCalendarFragment> {
  private final Provider<ClockPresenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public PopLeaveCalendarFragment_MembersInjector(
      Provider<ClockPresenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<PopLeaveCalendarFragment> create(
      Provider<ClockPresenter> presenterProvider, Provider<Bus> busProvider) {
    return new PopLeaveCalendarFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(PopLeaveCalendarFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      PopLeaveCalendarFragment instance, Provider<ClockPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(PopLeaveCalendarFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
