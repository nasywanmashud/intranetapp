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
public final class LeaveAppResultFragment_MembersInjector
    implements MembersInjector<LeaveAppResultFragment> {
  private final Provider<LoginPresenter> presenterProvider;

  private final Provider<Bus> busProvider;

  public LeaveAppResultFragment_MembersInjector(
      Provider<LoginPresenter> presenterProvider, Provider<Bus> busProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
    assert busProvider != null;
    this.busProvider = busProvider;
  }

  public static MembersInjector<LeaveAppResultFragment> create(
      Provider<LoginPresenter> presenterProvider, Provider<Bus> busProvider) {
    return new LeaveAppResultFragment_MembersInjector(presenterProvider, busProvider);
  }

  @Override
  public void injectMembers(LeaveAppResultFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
    instance.bus = busProvider.get();
  }

  public static void injectPresenter(
      LeaveAppResultFragment instance, Provider<LoginPresenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }

  public static void injectBus(LeaveAppResultFragment instance, Provider<Bus> busProvider) {
    instance.bus = busProvider.get();
  }
}
