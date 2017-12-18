package com.intranet.app.ui.Activity.HomePage;

import com.intranet.app.ui.Presenter.ClockPresenter;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataNewsFragment_MembersInjector implements MembersInjector<DataNewsFragment> {
  private final Provider<ClockPresenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public DataNewsFragment_MembersInjector(
      Provider<ClockPresenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<DataNewsFragment> create(
      Provider<ClockPresenter> presenterProvider, Provider<Bus> busProvider) {
    return new DataNewsFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(DataNewsFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      DataNewsFragment instance, Provider<ClockPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(DataNewsFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
