package com.intranet.app.dagger.module.component;

import android.content.Context;
import com.intranet.app.AppModule;
import com.intranet.app.AppModule_ProvideContextFactory;
import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.api.ApiRequestHandler_MembersInjector;
import com.intranet.app.api.ApiService;
import com.intranet.app.dagger.module.NetModule;
import com.intranet.app.dagger.module.NetModule_ApiRequestHandlerFactory;
import com.intranet.app.dagger.module.NetModule_ProvideApiServiceFactory;
import com.intranet.app.dagger.module.NetModule_ProvideBusFactory;
import com.intranet.app.dagger.module.NetModule_ProvideEndpointFactory;
import com.intranet.app.dagger.module.NetModule_ProvideRequestInterceptorFactory;
import com.intranet.app.dagger.module.PresenterModule;
import com.intranet.app.dagger.module.PresenterModule_ProvideClockPresenterFactory;
import com.intranet.app.dagger.module.PresenterModule_ProvideLoginPresenterFactory;
import com.intranet.app.ui.Activity.HomePage.DataNewsFragment;
import com.intranet.app.ui.Activity.HomePage.DataNewsFragment_MembersInjector;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment_MembersInjector;
import com.intranet.app.ui.Activity.HomePage.StaffAttendanceFragment;
import com.intranet.app.ui.Activity.HomePage.StaffAttendanceFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.LeaveAppListFragment;
import com.intranet.app.ui.Activity.LMS.LeaveAppListFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalSearch.LeaveApprovalSearchFragment;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalSearch.LeaveApprovalSearchFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment2;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment2_MembersInjector;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.LmsFragment;
import com.intranet.app.ui.Activity.LMS.LmsFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.MyLeave.ALdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.ALdataFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.MyLeave.LMSdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.LMSdataFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.MyLeave.MLdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.MLdataFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.MyLeave.MyLeaveFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.MyLeaveFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.MyLeave.ULdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.ULdataFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.PopLeaveAppFragment;
import com.intranet.app.ui.Activity.LMS.PopLeaveAppFragment_MembersInjector;
import com.intranet.app.ui.Activity.LMS.PopLeaveCalendarFragment;
import com.intranet.app.ui.Activity.LMS.PopLeaveCalendarFragment_MembersInjector;
import com.intranet.app.ui.Activity.Login.LoginFragment;
import com.intranet.app.ui.Activity.Login.LoginFragment_MembersInjector;
import com.intranet.app.ui.Activity.Profile.ProfileFragment;
import com.intranet.app.ui.Activity.Profile.ProfileFragment_MembersInjector;
import com.intranet.app.ui.Activity.SplashScreen.SplashScreenFragment;
import com.intranet.app.ui.Activity.SplashScreen.SplashScreenFragment_MembersInjector;
import com.intranet.app.ui.Activity.Timesheet.ApplyTimesheetFragment;
import com.intranet.app.ui.Activity.Timesheet.ApplyTimesheetFragment_MembersInjector;
import com.intranet.app.ui.Activity.Timesheet.TimesheetFragment;
import com.intranet.app.ui.Activity.Timesheet.TimesheetFragment_MembersInjector;
import com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalFragment;
import com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalFragment_MembersInjector;
import com.intranet.app.ui.Activity.TimesheetApprovalSearch.TimesheetApprovalSearchFragment;
import com.intranet.app.ui.Activity.TimesheetApprovalSearch.TimesheetApprovalSearchFragment_MembersInjector;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchFragment;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchFragment_MembersInjector;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Presenter.ClockPresenter_MembersInjector;
import com.intranet.app.ui.Presenter.LoginPresenter;
import com.intranet.app.ui.Presenter.LoginPresenter_MembersInjector;
import com.squareup.otto.Bus;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit.Endpoint;
import retrofit.RequestInterceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Bus> provideBusProvider;

  private Provider<RequestInterceptor> provideRequestInterceptorProvider;

  private Provider<Endpoint> provideEndpointProvider;

  private Provider<ApiService> provideApiServiceProvider;

  private Provider<Context> provideContextProvider;

  private Provider<LoginPresenter> provideLoginPresenterProvider;

  private Provider<ClockPresenter> provideClockPresenterProvider;

  private MembersInjector<LoginFragment> loginFragmentMembersInjector;

  private MembersInjector<ApiRequestHandler> apiRequestHandlerMembersInjector;

  private Provider<ApiRequestHandler> apiRequestHandlerProvider;

  private MembersInjector<LoginPresenter> loginPresenterMembersInjector;

  private MembersInjector<ClockPresenter> clockPresenterMembersInjector;

  private MembersInjector<HomePageFragment> homePageFragmentMembersInjector;

  private MembersInjector<LmsFragment> lmsFragmentMembersInjector;

  private MembersInjector<ProfileFragment> profileFragmentMembersInjector;

  private MembersInjector<TimesheetFragment> timesheetFragmentMembersInjector;

  private MembersInjector<DataNewsFragment> dataNewsFragmentMembersInjector;

  private MembersInjector<LeaveApprovalFragment> leaveApprovalFragmentMembersInjector;

  private MembersInjector<LeaveAppListFragment> leaveAppListFragmentMembersInjector;

  private MembersInjector<ApplyTimesheetFragment> applyTimesheetFragmentMembersInjector;

  private MembersInjector<TimesheetApprovalFragment> timesheetApprovalFragmentMembersInjector;

  private MembersInjector<LeaveCalendarFragment> leaveCalendarFragmentMembersInjector;

  private MembersInjector<PopLeaveCalendarFragment> popLeaveCalendarFragmentMembersInjector;

  private MembersInjector<MyLeaveFragment> myLeaveFragmentMembersInjector;

  private MembersInjector<PopLeaveAppFragment> popLeaveAppFragmentMembersInjector;

  private MembersInjector<SplashScreenFragment> splashScreenFragmentMembersInjector;

  private MembersInjector<LMSdataFragment> lMSdataFragmentMembersInjector;

  private MembersInjector<ALdataFragment> aLdataFragmentMembersInjector;

  private MembersInjector<MLdataFragment> mLdataFragmentMembersInjector;

  private MembersInjector<ULdataFragment> uLdataFragmentMembersInjector;

  private MembersInjector<StaffAttendanceFragment> staffAttendanceFragmentMembersInjector;

  private MembersInjector<LeaveCalendarFragment2> leaveCalendarFragment2MembersInjector;

  private MembersInjector<TimesheetSearchFragment> timesheetSearchFragmentMembersInjector;

  private MembersInjector<LeaveApprovalSearchFragment> leaveApprovalSearchFragmentMembersInjector;

  private MembersInjector<TimesheetApprovalSearchFragment>
      timesheetApprovalSearchFragmentMembersInjector;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.provideBusProvider =
        DoubleCheck.provider(NetModule_ProvideBusFactory.create(builder.netModule));

    this.provideRequestInterceptorProvider =
        DoubleCheck.provider(NetModule_ProvideRequestInterceptorFactory.create(builder.netModule));

    this.provideEndpointProvider =
        DoubleCheck.provider(NetModule_ProvideEndpointFactory.create(builder.netModule));

    this.provideApiServiceProvider =
        DoubleCheck.provider(
            NetModule_ProvideApiServiceFactory.create(
                builder.netModule, provideRequestInterceptorProvider, provideEndpointProvider));

    this.provideContextProvider = AppModule_ProvideContextFactory.create(builder.appModule);

    this.provideLoginPresenterProvider =
        DoubleCheck.provider(
            PresenterModule_ProvideLoginPresenterFactory.create(
                builder.presenterModule, provideContextProvider));

    this.provideClockPresenterProvider =
        DoubleCheck.provider(
            PresenterModule_ProvideClockPresenterFactory.create(
                builder.presenterModule, provideContextProvider));

    this.loginFragmentMembersInjector =
        LoginFragment_MembersInjector.create(
            provideLoginPresenterProvider, provideClockPresenterProvider, provideBusProvider);

    this.apiRequestHandlerMembersInjector =
        ApiRequestHandler_MembersInjector.create(provideApiServiceProvider, provideBusProvider);

    this.apiRequestHandlerProvider =
        DoubleCheck.provider(
            NetModule_ApiRequestHandlerFactory.create(builder.netModule, provideContextProvider));

    this.loginPresenterMembersInjector =
        LoginPresenter_MembersInjector.create(apiRequestHandlerProvider, provideBusProvider);

    this.clockPresenterMembersInjector =
        ClockPresenter_MembersInjector.create(apiRequestHandlerProvider, provideBusProvider);

    this.homePageFragmentMembersInjector =
        HomePageFragment_MembersInjector.create(provideClockPresenterProvider, provideBusProvider);

    this.lmsFragmentMembersInjector =
        LmsFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.profileFragmentMembersInjector =
        ProfileFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.timesheetFragmentMembersInjector =
        TimesheetFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.dataNewsFragmentMembersInjector =
        DataNewsFragment_MembersInjector.create(provideClockPresenterProvider, provideBusProvider);

    this.leaveApprovalFragmentMembersInjector =
        LeaveApprovalFragment_MembersInjector.create(
            provideBusProvider, provideClockPresenterProvider);

    this.leaveAppListFragmentMembersInjector =
        LeaveAppListFragment_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.applyTimesheetFragmentMembersInjector =
        ApplyTimesheetFragment_MembersInjector.create(
            provideBusProvider, provideClockPresenterProvider);

    this.timesheetApprovalFragmentMembersInjector =
        TimesheetApprovalFragment_MembersInjector.create(
            provideBusProvider, provideClockPresenterProvider);

    this.leaveCalendarFragmentMembersInjector =
        LeaveCalendarFragment_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.popLeaveCalendarFragmentMembersInjector =
        PopLeaveCalendarFragment_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.myLeaveFragmentMembersInjector =
        MyLeaveFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.popLeaveAppFragmentMembersInjector =
        PopLeaveAppFragment_MembersInjector.create(
            provideLoginPresenterProvider, provideBusProvider);

    this.splashScreenFragmentMembersInjector =
        SplashScreenFragment_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.lMSdataFragmentMembersInjector =
        LMSdataFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.aLdataFragmentMembersInjector =
        ALdataFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.mLdataFragmentMembersInjector =
        MLdataFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.uLdataFragmentMembersInjector =
        ULdataFragment_MembersInjector.create(provideBusProvider, provideClockPresenterProvider);

    this.staffAttendanceFragmentMembersInjector =
        StaffAttendanceFragment_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.leaveCalendarFragment2MembersInjector =
        LeaveCalendarFragment2_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.timesheetSearchFragmentMembersInjector =
        TimesheetSearchFragment_MembersInjector.create(
            provideClockPresenterProvider, provideBusProvider);

    this.leaveApprovalSearchFragmentMembersInjector =
        LeaveApprovalSearchFragment_MembersInjector.create(
            provideBusProvider, provideClockPresenterProvider);

    this.timesheetApprovalSearchFragmentMembersInjector =
        TimesheetApprovalSearchFragment_MembersInjector.create(
            provideBusProvider, provideClockPresenterProvider);
  }

  @Override
  public Bus bus() {
    return provideBusProvider.get();
  }

  @Override
  public ApiService apiService() {
    return provideApiServiceProvider.get();
  }

  @Override
  public void inject(LoginFragment loginFragment) {
    loginFragmentMembersInjector.injectMembers(loginFragment);
  }

  @Override
  public void inject(ApiRequestHandler frag) {
    apiRequestHandlerMembersInjector.injectMembers(frag);
  }

  @Override
  public void inject(LoginPresenter loginPresenter) {
    loginPresenterMembersInjector.injectMembers(loginPresenter);
  }

  @Override
  public void inject(ClockPresenter clockPresenter) {
    clockPresenterMembersInjector.injectMembers(clockPresenter);
  }

  @Override
  public void inject(HomePageFragment homePageFragment) {
    homePageFragmentMembersInjector.injectMembers(homePageFragment);
  }

  @Override
  public void inject(LmsFragment lmsFragment) {
    lmsFragmentMembersInjector.injectMembers(lmsFragment);
  }

  @Override
  public void inject(ProfileFragment profileFragment) {
    profileFragmentMembersInjector.injectMembers(profileFragment);
  }

  @Override
  public void inject(TimesheetFragment timesheetFragment) {
    timesheetFragmentMembersInjector.injectMembers(timesheetFragment);
  }

  @Override
  public void inject(DataNewsFragment dataNewsFragment) {
    dataNewsFragmentMembersInjector.injectMembers(dataNewsFragment);
  }

  @Override
  public void inject(LeaveApprovalFragment leaveApprovalFragment) {
    leaveApprovalFragmentMembersInjector.injectMembers(leaveApprovalFragment);
  }

  @Override
  public void inject(LeaveAppListFragment leaveAppListFragment) {
    leaveAppListFragmentMembersInjector.injectMembers(leaveAppListFragment);
  }

  @Override
  public void inject(ApplyTimesheetFragment applyTimesheetFragment) {
    applyTimesheetFragmentMembersInjector.injectMembers(applyTimesheetFragment);
  }

  @Override
  public void inject(TimesheetApprovalFragment timesheetApprovalFragment) {
    timesheetApprovalFragmentMembersInjector.injectMembers(timesheetApprovalFragment);
  }

  @Override
  public void inject(LeaveCalendarFragment leaveCalendarFragment) {
    leaveCalendarFragmentMembersInjector.injectMembers(leaveCalendarFragment);
  }

  @Override
  public void inject(PopLeaveCalendarFragment popLeaveCalendarFragment) {
    popLeaveCalendarFragmentMembersInjector.injectMembers(popLeaveCalendarFragment);
  }

  @Override
  public void inject(MyLeaveFragment myLeaveFragment) {
    myLeaveFragmentMembersInjector.injectMembers(myLeaveFragment);
  }

  @Override
  public void inject(PopLeaveAppFragment popLeaveAppFragment) {
    popLeaveAppFragmentMembersInjector.injectMembers(popLeaveAppFragment);
  }

  @Override
  public void inject(SplashScreenFragment splashScreenFragment) {
    splashScreenFragmentMembersInjector.injectMembers(splashScreenFragment);
  }

  @Override
  public void inject(LMSdataFragment lmSdataFragment) {
    lMSdataFragmentMembersInjector.injectMembers(lmSdataFragment);
  }

  @Override
  public void inject(ALdataFragment aLdataFragment) {
    aLdataFragmentMembersInjector.injectMembers(aLdataFragment);
  }

  @Override
  public void inject(MLdataFragment mLdataFragment) {
    mLdataFragmentMembersInjector.injectMembers(mLdataFragment);
  }

  @Override
  public void inject(ULdataFragment uLdataFragment) {
    uLdataFragmentMembersInjector.injectMembers(uLdataFragment);
  }

  @Override
  public void inject(StaffAttendanceFragment staffAttendanceFragment) {
    staffAttendanceFragmentMembersInjector.injectMembers(staffAttendanceFragment);
  }

  @Override
  public void inject(LeaveCalendarFragment2 leaveCalendarFragment2) {
    leaveCalendarFragment2MembersInjector.injectMembers(leaveCalendarFragment2);
  }

  @Override
  public void inject(TimesheetSearchFragment timesheetSearchFragment) {
    timesheetSearchFragmentMembersInjector.injectMembers(timesheetSearchFragment);
  }

  @Override
  public void inject(LeaveApprovalSearchFragment leaveApprovalSearchFragment) {
    leaveApprovalSearchFragmentMembersInjector.injectMembers(leaveApprovalSearchFragment);
  }

  @Override
  public void inject(TimesheetApprovalSearchFragment timesheetApprovalSearchFragment) {
    timesheetApprovalSearchFragmentMembersInjector.injectMembers(timesheetApprovalSearchFragment);
  }

  public static final class Builder {
    private NetModule netModule;

    private AppModule appModule;

    private PresenterModule presenterModule;

    private Builder() {}

    public AppComponent build() {
      if (netModule == null) {
        this.netModule = new NetModule();
      }
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (presenterModule == null) {
        this.presenterModule = new PresenterModule();
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder netModule(NetModule netModule) {
      this.netModule = Preconditions.checkNotNull(netModule);
      return this;
    }

    public Builder presenterModule(PresenterModule presenterModule) {
      this.presenterModule = Preconditions.checkNotNull(presenterModule);
      return this;
    }
  }
}
