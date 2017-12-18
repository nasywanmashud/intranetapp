package com.intranet.app.api;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchFragment;
import com.intranet.app.ui.Model.Receive.AttendanceHistoryReceive;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.DataNewsReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppReceive;
import com.intranet.app.ui.Model.Receive.LeaveCalendarReceive;
import com.intranet.app.ui.Model.Receive.LmsListReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Receive.MyLeaveReceive;
import com.intranet.app.ui.Model.Receive.NewsReceive;
import com.intranet.app.ui.Model.Receive.TaskReceive;
import com.intranet.app.ui.Model.Receive.TimesheetApprovalReceive;
import com.intranet.app.ui.Model.Receive.TimesheetListReceive;
import com.intranet.app.ui.Model.Receive.TimesheetSearchReceive;
import com.intranet.app.ui.Model.Receive.TimesheetstatusReceive;
import com.intranet.app.ui.Model.Receive.UpdateStatusReceive;
import com.intranet.app.ui.Model.Receive.UpdateTimesheetReceive;
import com.intranet.app.ui.Model.Request.AttendanceHistoryRequest;
import com.intranet.app.ui.Model.Request.ClockRequest;
import com.intranet.app.ui.Model.Request.DataNewsRequest;
import com.intranet.app.ui.Model.Request.LeaveAppListRequest;
import com.intranet.app.ui.Model.Request.LeaveAppRequest;
import com.intranet.app.ui.Model.Request.LeaveCalendarRequest;
import com.intranet.app.ui.Model.Request.LmslistRequest;
import com.intranet.app.ui.Model.Request.LoginRequest;
import com.intranet.app.ui.Model.Request.MyLeaveRequest;
import com.intranet.app.ui.Model.Request.NewsRequest;
import com.intranet.app.ui.Model.Request.TaskRequest;
import com.intranet.app.ui.Model.Request.TimesheetApprovalRequest;
import com.intranet.app.ui.Model.Request.TimesheetListRequest;
import com.intranet.app.ui.Model.Request.TimesheetSearchRequest;
import com.intranet.app.ui.Model.Request.TimesheetstatusRequest;
import com.intranet.app.ui.Model.Request.UpdateStatusRequest;
import com.intranet.app.ui.Model.Request.UpdateTimesheetRequest;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ApiRequestHandler {

    @Inject
    ApiService apiService;

    @Inject
    Bus bus;

    public ApiRequestHandler(Context context) {
        MainApplication.get(context).getNetComponent().inject(this);
    }


    @Subscribe
    public void onLoginRequest(final LoginRequest event) {

        apiService.onRequestToLogin(event, new Callback<LoginReceive>() {

            @Override
            public void success(LoginReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new LoginReceive(rhymesResponse));
                    //RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "UserLogin");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                Log.e("error", "pape2");

            }

        });
    }

        @Subscribe
        public void onClockRequest ( final ClockRequest event){

            apiService.onRequestToClock(event, new Callback<ClockReceive>() {

                @Override
                public void success(ClockReceive rhymesResponse, Response response) {

                    if (rhymesResponse != null) {
                        bus.post(new ClockReceive(rhymesResponse));
                        Log.e("11","aaa");
                       // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                    } else {
                        BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                        Log.e("error", "pape");
                    }
                }

                @Override
                public void failure(RetrofitError error) {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape2");

                }

            });
        }

    @Subscribe
    public void onNewsRequest ( final NewsRequest event){

        apiService.onRequestToNews(event, new Callback<NewsReceive>() {

            @Override
            public void success(NewsReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new NewsReceive(rhymesResponse));
                    Log.e("11","aaa");
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                Log.e("error", "pape2");

            }

        });
    }

    @Subscribe
    public void onDataNewsRequest ( final DataNewsRequest event){

        apiService.onRequestToDataNews(event, new Callback<DataNewsReceive>() {

            @Override
            public void success(DataNewsReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new DataNewsReceive(rhymesResponse));
                    Log.e("11","aaa");
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                    Log.e("error", "pape");
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                Log.e("error", "pape2");

            }

        });
    }

    @Subscribe
    public void onLeaveAppRequest ( final LeaveAppRequest event){

        apiService.onRequestToLeaveApp(event, new Callback<LeaveAppReceive>() {

            @Override
            public void success(LeaveAppReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new LeaveAppReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onLeaveAppListRequest ( final LeaveAppListRequest event){

        apiService.onRequestToSearchApp(event, new Callback<LeaveAppListReceive>() {

            @Override
            public void success(LeaveAppListReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new LeaveAppListReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }

            @Override
            public void failure(RetrofitError error) {
//                Toast.makeText(MainFragmentActivity.getContext(), "No Records Found", Toast.LENGTH_LONG).show();
//                BaseFragment.dismissLoading();
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onLeaveCalendarRequest ( final LeaveCalendarRequest event){

        apiService.onRequestToLeaveCalendar(event, new Callback<LeaveCalendarReceive>() {

            @Override
            public void success(LeaveCalendarReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new LeaveCalendarReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }


    @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }



    @Subscribe
    public void onUpdateStatusRequest ( final UpdateStatusRequest event){

        apiService.onRequestToUpdateStatus(event, new Callback<UpdateStatusReceive>() {

            @Override
            public void success(UpdateStatusReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new UpdateStatusReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }


    @Subscribe
    public void onTimesheetApprovalRequest ( final TimesheetApprovalRequest event){

        apiService.onRequestToTimesheetApproval(event, new Callback<TimesheetApprovalReceive>() {

            @Override
            public void success(TimesheetApprovalReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new TimesheetApprovalReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {

                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onMyLeaveRequest ( final MyLeaveRequest event){

        apiService.onRequestToMyLeave(event, new Callback<MyLeaveReceive>() {

            @Override
            public void success(MyLeaveReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new MyLeaveReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onAttendanceHistoryRequest ( final AttendanceHistoryRequest event){

        apiService.onRequestToAttendanceHistory(event, new Callback<AttendanceHistoryReceive>() {

            @Override
            public void success(AttendanceHistoryReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new AttendanceHistoryReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }


    @Subscribe
    public void onTaskRequest ( final TaskRequest event){

        apiService.onRequestToTask(event, new Callback<TaskReceive>() {

            @Override
            public void success(TaskReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new TaskReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onTimesheetSearchRequest ( final TimesheetSearchRequest event){

        apiService.onRequestTotimesheetsearch(event, new Callback<TimesheetSearchReceive>() {

            @Override
            public void success(TimesheetSearchReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new TimesheetSearchReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onTimesheetStatusRequest ( final TimesheetstatusRequest event){

        apiService.onRequestTotimesheetstatus(event, new Callback<TimesheetstatusReceive>() {

            @Override
            public void success(TimesheetstatusReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new TimesheetstatusReceive(rhymesResponse));

                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    @Subscribe
    public void onlmslistRequest ( final LmslistRequest event){

        apiService.onRequestTolmslist(event, new Callback<LmsListReceive>() {

            @Override
            public void success(LmsListReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new LmsListReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }

            @Override
            public void failure(RetrofitError error) {
//                Toast.makeText(MainFragmentActivity.getContext(), "No Records Found", Toast.LENGTH_LONG).show();
//                BaseFragment.dismissLoading();

                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    public void onTimesheetListRequest ( final TimesheetListRequest event){

        apiService.onRequestTotimesheetlist(event, new Callback<TimesheetListReceive>() {

            @Override
            public void success(TimesheetListReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new TimesheetListReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }


    public void onUpdateTimesheetRequest ( final UpdateTimesheetRequest event){

        apiService.onRequestToupdatetimesheet(event, new Callback<UpdateTimesheetReceive>() {

            @Override
            public void success(UpdateTimesheetReceive rhymesResponse, Response response) {

                if (rhymesResponse != null) {
                    bus.post(new UpdateTimesheetReceive(rhymesResponse));
                    // RealmObjectController.cachedResult(MainFragmentActivity.getContext(), (new Gson()).toJson(rhymesResponse), "Clock");
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }



            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());

            }

        });
    }

    /*------------------------------------------------------------------------------*/
    /*This method is to check Force Update status*/

   /* @Subscribe
    public void onLoginInfoRequest(final LoginInfoRequest event) {

        apiService.onLoginInfoRequest(event, new Callback<LoginInfoReceive>() {

            @Override
            public void success(LoginInfoReceive retroResponse, Response response) {

                if (retroResponse != null) {
                    bus.post(new LoginInfoReceive(retroResponse));
                } else {
                    BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                BaseFragment.setAlertNotification(MainFragmentActivity.getContext());
            }
        });
    }*/


    }

