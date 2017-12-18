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
public final class MLdataFragment_MembersInjector implements MembersInjector<MLdataFragment> {
  private final Provider<Bus> busProvider;

  private final Provider<ClockPresenter> presenterProvider;

  public MLdataFragment_MembersInjector(
      Provider<Bus> busProvider, Provider<ClockPresenter> presenterProvider) {
    assert busProvider != null;
    this.busProvider = busProvider;
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<MLdataFragment> create(
      Provider<Bus> busProvider, Provider<ClockPresenter> presenterProvider) {
    return new MLdataFragment_MembersInjector(busProvider, presenterProvider);
  }

  @Override
  public void injectMembers(MLdataFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.bus = busProvider.get();
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(MLdataFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      MLdataFragment instance, Provider<ClockPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
