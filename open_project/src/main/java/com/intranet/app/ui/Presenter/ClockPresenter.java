package com.intranet.app.ui.Presenter;

import android.content.Context;

import com.intranet.app.api.ApiRequestHandler;
import com.intranet.app.application.MainApplication;
import com.intranet.app.ui.Model.Request.AttendanceHistoryRequest;
import com.intranet.app.ui.Model.Request.ClockRequest;
import com.intranet.app.ui.Model.Request.DataNewsRequest;
import com.intranet.app.ui.Model.Request.LeaveAppListRequest;
import com.intranet.app.ui.Model.Request.LeaveAppRequest;
import com.intranet.app.ui.Model.Request.LeaveCalendarRequest;
import com.intranet.app.ui.Model.Request.LmslistRequest;
import com.intranet.app.ui.Model.Request.MyLeaveRequest;
import com.intranet.app.ui.Model.Request.NewsRequest;
import com.intranet.app.ui.Model.Request.TaskRequest;
import com.intranet.app.ui.Model.Request.TimesheetApprovalRequest;
import com.intranet.app.ui.Model.Request.TimesheetListRequest;
import com.intranet.app.ui.Model.Request.TimesheetSearchRequest;
import com.intranet.app.ui.Model.Request.TimesheetstatusRequest;
import com.intranet.app.ui.Model.Request.UpdateStatusRequest;
import com.intranet.app.ui.Model.Request.UpdateTimesheetRequest;
import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by Me-Tech on 9/14/2017.
 */

public class ClockPresenter {


    @Inject
    ApiRequestHandler apiRequestHandler;

    @Inject
    Bus bus;

    public ClockPresenter(Context context) {
        MainApplication.component(context).inject(this);
    }

    public void onResume() {
        bus.register(this);
    }

    public void onPause() {
        bus.unregister(this);
    }

    public void onClock(ClockRequest data) {
        apiRequestHandler.onClockRequest(data);
    }

    public void onNews(NewsRequest data) {
        apiRequestHandler.onNewsRequest(data);
    }

    public void onDataNews(DataNewsRequest data) {
        apiRequestHandler.onDataNewsRequest(data);
    }

    public void onLeaveApp(LeaveAppRequest data) {
        apiRequestHandler.onLeaveAppRequest(data);
    }

    public void onLeaveAppList(LeaveAppListRequest data) {
        apiRequestHandler.onLeaveAppListRequest(data);
    }

    public void onLeaveCalendar(LeaveCalendarRequest data) {
        apiRequestHandler.onLeaveCalendarRequest(data);
    }

    public void onUpdateStatus(UpdateStatusRequest data) {
        apiRequestHandler.onUpdateStatusRequest(data);
    }

    public void onTimesheetApproval(TimesheetApprovalRequest data) {
        apiRequestHandler.onTimesheetApprovalRequest(data);
    }

    public void onMyLeave(MyLeaveRequest data) {
        apiRequestHandler.onMyLeaveRequest(data);
    }

    public void onAttendanceHistory(AttendanceHistoryRequest data) {
        apiRequestHandler.onAttendanceHistoryRequest(data);
    }

    public void onTask(TaskRequest data) {
        apiRequestHandler.onTaskRequest(data);
    }

    public void onTimesheetSearch(TimesheetSearchRequest data) {
        apiRequestHandler.onTimesheetSearchRequest(data);
    }

    public void onTimesheetstatus(TimesheetstatusRequest data) {
        apiRequestHandler.onTimesheetStatusRequest(data);
    }

    public void onLmslist(LmslistRequest data) {
        apiRequestHandler.onlmslistRequest(data);

    }

    public void onTimesheetList(TimesheetListRequest data) {
        apiRequestHandler.onTimesheetListRequest(data);
    }

    public void onUpdateTimesheet(UpdateTimesheetRequest data) {
        apiRequestHandler.onUpdateTimesheetRequest(data);
    }

}


