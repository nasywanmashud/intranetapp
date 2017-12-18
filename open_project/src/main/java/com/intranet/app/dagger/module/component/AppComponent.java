package com.intranet.app.dagger.module.component;

import com.intranet.app.AppModule;
import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.api.ApiService;
import com.intranet.app.dagger.module.NetModule;
import com.intranet.app.dagger.module.PresenterModule;
import com.intranet.app.ui.Activity.HomePage.DataNewsFragment;
import com.intranet.app.ui.Activity.HomePage.HomePageFragment;
import com.intranet.app.ui.Activity.HomePage.StaffAttendanceFragment;
import com.intranet.app.ui.Activity.LMS.LeaveAppListFragment;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalSearch.LeaveApprovalSearchActivity;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalSearch.LeaveApprovalSearchFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment2;
import com.intranet.app.ui.Activity.LMS.LmsFragment;

import com.intranet.app.ui.Activity.LMS.MyLeave.ALdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.LMSdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.MLdataFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.ULdataFragment;
import com.intranet.app.ui.Activity.LMS.PopLeaveCalendarFragment;

import com.intranet.app.ui.Activity.LMS.MyLeave.MyLeaveFragment;

import com.intranet.app.ui.Activity.LMS.PopLeaveAppFragment;
import com.intranet.app.ui.Activity.Login.LoginFragment;
import com.intranet.app.ui.Activity.Profile.ProfileFragment;
import com.intranet.app.ui.Activity.SplashScreen.SplashScreenFragment;
import com.intranet.app.ui.Activity.Timesheet.ApplyTimesheetFragment;
import com.intranet.app.ui.Activity.Timesheet.TimesheetFragment;
import com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalFragment;
import com.intranet.app.ui.Activity.TimesheetApprovalSearch.TimesheetApprovalSearchFragment;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchFragment;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Presenter.LoginPresenter;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Component;

//import com.open.project.ui.Presenter.HomepagePresenter;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, PresenterModule.class})
public interface AppComponent {

    Bus bus();

    ApiService apiService();

    void inject(LoginFragment loginFragment);
    void inject(ApiRequestHandler frag);
    void inject(LoginPresenter loginPresenter);
    void inject(ClockPresenter clockPresenter);
    void inject(HomePageFragment homePageFragment);
    void inject(LmsFragment lmsFragment);
    void inject(ProfileFragment profileFragment);
    void inject(TimesheetFragment timesheetFragment);
    void inject(DataNewsFragment dataNewsFragment);
    void inject (LeaveApprovalFragment leaveApprovalFragment);
    void inject (LeaveAppListFragment leaveAppListFragment);
    void inject (ApplyTimesheetFragment applyTimesheetFragment);
    void inject (TimesheetApprovalFragment timesheetApprovalFragment);
    void inject (LeaveCalendarFragment leaveCalendarFragment);
    void inject (PopLeaveCalendarFragment popLeaveCalendarFragment);
    void inject (MyLeaveFragment myLeaveFragment);
    void inject (PopLeaveAppFragment popLeaveAppFragment);
    void inject (SplashScreenFragment splashScreenFragment);
    void inject (LMSdataFragment lmSdataFragment);
    void inject (ALdataFragment aLdataFragment);
    void inject (MLdataFragment mLdataFragment);
    void inject (ULdataFragment uLdataFragment);
    void inject (StaffAttendanceFragment staffAttendanceFragment);
    void inject (LeaveCalendarFragment2 leaveCalendarFragment2);
    void inject (TimesheetSearchFragment timesheetSearchFragment);
    void inject (LeaveApprovalSearchFragment leaveApprovalSearchFragment);
    void inject (TimesheetApprovalSearchFragment timesheetApprovalSearchFragment);


}



