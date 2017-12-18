package com.intranet.app.api;

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

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface  ApiService {

    //LOGIN
    @POST("/login")
    void onRequestToLogin(@Body LoginRequest task, Callback<LoginReceive> callback);

    //CLOCK
    @POST("/attendance")
    void onRequestToClock(@Body ClockRequest task, Callback<ClockReceive> callback);

    //NEWS
    @POST("/news")
    void onRequestToNews(@Body NewsRequest task, Callback<NewsReceive> callback);

    //DATANEWS
    @POST("/data")
    void onRequestToDataNews(@Body DataNewsRequest task, Callback<DataNewsReceive> callback);

    //DATANEWS
    @POST("/leaveapp")
    void onRequestToLeaveApp(@Body LeaveAppRequest task, Callback<LeaveAppReceive> callback);

    //LEAVEAPPLIST
    @POST("/searchapp")
    void onRequestToSearchApp(@Body LeaveAppListRequest task, Callback<LeaveAppListReceive> callback);

    //LEAVECALENDAR
    @POST("/lmscalendar")
    void onRequestToLeaveCalendar(@Body LeaveCalendarRequest task, Callback<LeaveCalendarReceive> callback);

    //UPDATESTATUS
    @POST("/updatestatus")
    void onRequestToUpdateStatus(@Body UpdateStatusRequest task, Callback<UpdateStatusReceive> callback);

        //TIMESHEETAPPROVAL
    @POST("/timesheetapp")
    void onRequestToTimesheetApproval(@Body TimesheetApprovalRequest task, Callback<TimesheetApprovalReceive> callback);

        //TASK
    @POST("/timesheettask")
    void onRequestToTask(@Body TaskRequest task, Callback<TaskReceive> callback);

    //MYLEAVE
    @POST("/myleave")
    void onRequestToMyLeave(@Body MyLeaveRequest task, Callback<MyLeaveReceive> callback);

    //ATTENDANCEHISTORY
    @POST("/AttendanceHistory")
    void onRequestToAttendanceHistory(@Body AttendanceHistoryRequest task, Callback<AttendanceHistoryReceive> callback);

    //ATTENDANCEHISTORY
    @POST("/timesheetsearch")
    void onRequestTotimesheetsearch(@Body TimesheetSearchRequest task, Callback<TimesheetSearchReceive> callback);

    //TIMESHEETSTATUS
    @POST("/timesheetstatus")
    void onRequestTotimesheetstatus(@Body TimesheetstatusRequest task, Callback<TimesheetstatusReceive> callback);

    //LEAVEAPPLIST
    @POST("/lmslist")
    void onRequestTolmslist(@Body LmslistRequest task, Callback<LmsListReceive> callback);


    //    //ATTENDANCEHISTORY
    @POST("/timesheetlist")
    void onRequestTotimesheetlist(@Body TimesheetListRequest task, Callback<TimesheetListReceive> callback);

    //UPDATETIMESHEET
    @POST("/updatetimesheetstatus")
    void onRequestToupdatetimesheet(@Body UpdateTimesheetRequest task, Callback<UpdateTimesheetReceive> callback);


//    //LOGIN
//    @POST("/Laravel/public/login")
//    void onRequestToLogin(@Body LoginRequest task, Callback<LoginReceive> callback);
//
//    //CLOCK
//    @POST("/Laravel/public/attendance")
//    void onRequestToClock(@Body ClockRequest task, Callback<ClockReceive> callback);
//
//    //NEWS
//    @POST("/Laravel/public/news")
//    void onRequestToNews(@Body NewsRequest task, Callback<NewsReceive> callback);
//
//    //DATANEWS
//    @POST("/Laravel/public/data")
//    void onRequestToDataNews(@Body DataNewsRequest task, Callback<DataNewsReceive> callback);
//
//    //DATANEWS
//    @POST("/Laravel/public/leaveapp")
//    void onRequestToLeaveApp(@Body LeaveAppRequest task, Callback<LeaveAppReceive> callback);
//
//    //LEAVEAPPLIST
//    @POST("/Laravel/public/searchapp")
//    void onRequestToSearchApp(@Body LeaveAppListRequest task, Callback<LeaveAppListReceive> callback);
//
//    //LEAVECALENDAR
//    @POST("/Laravel/public/lmscalendar")
//    void onRequestToLeaveCalendar(@Body LeaveCalendarRequest task, Callback<LeaveCalendarReceive> callback);
//
//    //UPDATESTATUS
//    @POST("/Laravel/public/updatestatus")
//    void onRequestToUpdateStatus(@Body UpdateStatusRequest task, Callback<UpdateStatusReceive> callback);
//
//    //TIMESHEETAPPROVAL
//    @POST("/Laravel/public/timesheetapp")
//    void onRequestToTimesheetApproval(@Body TimesheetApprovalRequest task, Callback<TimesheetApprovalReceive> callback);
//
//    //TASK
//    @POST("/Laravel/public/timesheettask")
//    void onRequestToTask(@Body TaskRequest task, Callback<TaskReceive> callback);
//
//    //MYLEAVE
//    @POST("//Laravel/publicmyleave")
//    void onRequestToMyLeave(@Body MyLeaveRequest task, Callback<MyLeaveReceive> callback);
//
//    //ATTENDANCEHISTORY
//    @POST("/Laravel/public/AttendanceHistory")
//    void onRequestToAttendanceHistory(@Body AttendanceHistoryRequest task, Callback<AttendanceHistoryReceive> callback);
//
//    //ATTENDANCEHISTORY
//    @POST("/Laravel/public/timesheetsearch")
//    void onRequestTotimesheetsearch(@Body TimesheetSearchRequest task, Callback<TimesheetSearchReceive> callback);
//
//        //TIMESHEETSTATUS
//    @POST("/Laravel/public/timesheetstatus")
//    void onRequestTotimesheetstatus(@Body TimesheetstatusRequest task, Callback<TimesheetstatusReceive> callback);
//
//
//    //LEAVEAPPLIST
//    @POST("/Laravel/public/lmslist")
//    void onRequestTolmslist(@Body LmslistRequest task, Callback<LmsListReceive> callback);
//    //ATTENDANCEHISTORY
//
//    @POST("/Laravel/public/timesheetlist")
//    void onRequestTotimesheetlist(@Body TimesheetListRequest task, Callback<TimesheetListReceive> callback);
//
//    //UPDATETIMESHEET
//    @POST("/Laravel/public/updatetimesheetstatus")
//    void onRequestToupdatetimesheet(@Body UpdateTimesheetRequest task, Callback<UpdateTimesheetReceive> callback);

}


