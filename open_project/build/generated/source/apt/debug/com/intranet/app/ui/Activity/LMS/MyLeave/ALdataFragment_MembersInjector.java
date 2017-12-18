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
public final class ALdataFragment_MembersInjector implements MembersInjector<ALdataFragment> {
  private final Provider<Bus> busProvider;

  private final Provider<ClockPresenter> presenterProvider;

  public ALdataFragment_MembersInjector(
      Provider<Bus> busProvider, Provider<ClockPresenter> presenterProvider) {
    assert busProvider != null;
    this.busProvider = busProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<ALdataFragment> create(
      Provider<Bus> busProvider, Provider<ClockPresenter> presenterProvider) {
    return new ALdataFragment_MembersInjector(busProvider, presenterProvider);
  }

  @Override
  public void injectMembers(ALdataFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.bus = busProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(ALdataFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      ALdataFragment instance, Provider<ClockPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
