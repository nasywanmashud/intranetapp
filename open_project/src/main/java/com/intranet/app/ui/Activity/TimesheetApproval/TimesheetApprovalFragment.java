package com.intranet.app.ui.Activity.TimesheetApproval;

/**
 * Created by akarumbi on 10/25/2017.
 */


import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.LMS.MyLeave.LmslistAdapter;
import com.intranet.app.ui.Activity.TimesheetApprovalSearch.TimesheetApprovalSearchActivity;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchActivity;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppReceive;
import com.intranet.app.ui.Model.Receive.LmsListReceive;
import com.intranet.app.ui.Model.Receive.RecordList;
import com.intranet.app.ui.Model.Receive.TaskReceive;
import com.intranet.app.ui.Model.Receive.TimesheetAppRecord;
import com.intranet.app.ui.Model.Receive.TimesheetApprovalReceive;
import com.intranet.app.ui.Model.Receive.TimesheetListReceive;
import com.intranet.app.ui.Model.Receive.TimesheetSearchReceive;
import com.intranet.app.ui.Model.Receive.UpdateTimesheetReceive;
import com.intranet.app.ui.Model.Request.LeaveAppRequest;
import com.intranet.app.ui.Model.Request.TaskRequest;
import com.intranet.app.ui.Model.Request.TimesheetApprovalRequest;
import com.intranet.app.ui.Model.Request.TimesheetListRequest;
import com.intranet.app.ui.Model.Request.TimesheetSearchRequest;
import com.intranet.app.ui.Model.Request.UpdateTimesheetRequest;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Me-Tech on 9/28/2017.
 */

public class TimesheetApprovalFragment extends BaseFragment{

    @Inject
    Bus bus;

    @Inject
    ClockPresenter presenter;

    @Bind(R.id.dateFrom)
    TextView tvdatefrom;

    @Bind(R.id.imgfrom)
    ImageView imgfrom;

    @Bind(R.id.imgto)
    ImageView imgto;

    @Bind(R.id.dateTo)
    TextView tvdateto;

    @Bind(R.id.search)
    Button btnsearch;

    @Bind(R.id.btnSearch)
    Button btnsearch1;
    @Bind(R.id.project)
    Spinner spinproject;

    @Bind(R.id.task)
    Spinner spintask;

    @Bind(R.id.approver)
    TextView txtapprover;

    @Bind(R.id.status)
    Spinner spinstatus;

    @Bind(R.id.OT)
    Spinner spinot;

    @Bind(R.id.staff)
    Spinner spinstaff;

    @Bind(R.id.listviewtimesheetapplist)
    ListView listView;

    @Bind(R.id.statusall)
    Spinner spinappstatusall;

    @Bind(R.id.status2)
    Spinner spinstatus2;
    String selectedproject , ott ,selectedstatus , selectedot ,selectedstaff ,selectedtask  , datefrom ,dateto , name;

    ArrayList<String> Staff = new ArrayList<String>();
    ArrayList<String> Task = new ArrayList<String>();
    ArrayList<String> Project = new ArrayList<String>();
    ArrayList<String> appStatus = new ArrayList<String>();

    ArrayList<TimesheetAppRecord> timesheetlist = new ArrayList<TimesheetAppRecord>();
    TimesheetApprovalAdapter adapter;

    DatePickerDialog datePickerDialogfrom ;

    String [] status={"Submitted" , "Approved" , "Rejected"} ;
    String [] ot={"All" , "Yes" , "No"} ;

    ArrayList<String>leaveapplist = new ArrayList<String>();

    Spinner spinapprover;

    Calendar mCurrentDate ;
    int day , month , year ;
     TimesheetApprovalAdapter.ViewHolder vh;

    private SharedPrefManager pref;


    public static TimesheetApprovalFragment newInstance(Bundle bundle) {

        TimesheetApprovalFragment fragment = new TimesheetApprovalFragment();
        Bundle args = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.component(getActivity()).inject(this);
        RealmObjectController.clearCachedResult(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_timesheet_approval, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        pref = new SharedPrefManager(getActivity());

        spinapprover = (Spinner) view.findViewById(R.id.staff);

        //id = "Firefly Non-Billable (Kiosk, SMS, Mobile, Enrich)";

        final HashMap<String, String> username = pref.getUsername();
        name = username.get(SharedPrefManager.USERNAME);

//        final HashMap<String, String> projectname1 = pref.getProjectName();
//        final String projectname = projectname1.get(SharedPrefManager.PROJECTNAME);

//        timesheetappfromfragment(name);
        timesheetapplistfromfragment(name);
        //adapter.test();

        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.first_spinner, android.R.layout.simple_spinner_item) ;
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter = new TimesheetSearchAdapter(getActivity(), obj, appStatus,Statuss, this);
        spinappstatusall.setAdapter(countryAdapter);

        ArrayAdapter<CharSequence> countryCodesAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.first_spinner, android.R.layout.simple_spinner_item);
        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spin = spinstatus1.getSelectedItem().toString();
       // pref.setUpdateStatus(spin);

        spinappstatusall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                vh.spinappstatus.setSelection(position);
//                vh.spinappstatus.setAdapter(countryCodesAdapter);

                spinstatus2.setSelection(position);
//                    vh.spinappstatus.setSelection(position);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//        vh.spinappstatus.setAdapter(countryCodesAdapter);
        spinstatus2.setAdapter(countryCodesAdapter);

//        mCurrentDate = Calendar.getInstance();
//        day =mCurrentDate.get(Calendar.DAY_OF_MONTH);
//        month=mCurrentDate.get(Calendar.MONTH);
//        year = mCurrentDate.get(Calendar.YEAR);



//        tvdatefrom.setText( year + "-" + month + "-" +day);
//
//        imgfrom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                datePickerDialogfrom = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//                        monthOfYear = monthOfYear+1;
//
//                        tvdatefrom.setText(year+ "-" + monthOfYear + "-" + dayOfMonth );
//
//                        datefrom = tvdatefrom.getText().toString();
//                        //pref.setDateFrom(datefrom);
//
//                    }
//                }, year,month,day);
//                datePickerDialogfrom.show();
//
//
//            }
//        });

//        tvdateto.setText(year + "-" + month + "-" + day);
//
//
//        imgto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DatePickerDialog datePickerDialogto = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//                        monthOfYear = monthOfYear+1;
//
//                        tvdateto.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
//
//                        dateto = tvdateto.getText().toString();
//                        //pref.setDateTo(dateto);
//
//                    }
//                }, year,month,day);
//                datePickerDialogto.show();
//
//            }
//        });

//        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_dropdown_item_1line, status);
//        spinstatus.setAdapter(arrayAdapter1);
//
//        spinstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//            @Override
//            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
//
//                selectedstatus=spinstatus.getSelectedItem().toString();
//                Log.e("testtest",selectedstatus);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });



//        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_dropdown_item_1line, ot);
//        spinot.setAdapter(arrayAdapter2);
//
//        spinot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//
//
//            @Override
//            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
//
//                selectedot=spinot.getSelectedItem().toString();
//
//                if (selectedot.equals("Yes")){
//                    ott = "1";
//
//                } else  if (selectedot.equals("No")){
//                    ott = "0";
//
//                } else {
//                    ott = "All";
//                }
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });

//        btnsearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//        searchsuccess( name , selectedproject , selectedtask,  selectedstaff,  selectedstatus ,  ott);
//
//            }
//        });
        btnsearch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), TimesheetApprovalSearchActivity.class);
                startActivity(in);
            }
        });
            return view;
    }





//    private void timesheetappfromfragment(String username) {
//        //request api
//        initiateLoading(getActivity());
//        TimesheetApprovalRequest leaveappdata = new TimesheetApprovalRequest();
//        leaveappdata.setUsername(username);
//
//        presenter.onTimesheetApproval(leaveappdata);
//
//    }

    private void timesheetapplistfromfragment(String username) {
        //request api
        initiateLoading(getActivity());
        TimesheetListRequest timesheetappdata = new TimesheetListRequest();
        timesheetappdata.setUsername(username);
        presenter.onTimesheetList(timesheetappdata);

    }

    @Subscribe
    public void onTimesheetAppSuccess(TimesheetListReceive obj) {
        Log.e("kkkkk" , obj.getStatus());

        dismissLoading();
        if (obj.getStatus().equals("True") ) {

            for (int v = 0; v < obj.getTimesheetAppRecord().size(); v++) {

                TimesheetAppRecord detail = new TimesheetAppRecord();
                detail.setProject(obj.getTimesheetAppRecord().get(v).getProject());
                detail.setTask(obj.getTimesheetAppRecord().get(v).getTask());
                detail.setHours(obj.getTimesheetAppRecord().get(v).getHours());
                detail.setNotes(obj.getTimesheetAppRecord().get(v).getNotes());
                detail.setCreated(obj.getTimesheetAppRecord().get(v).getCreated());
                detail.setSubmitted(obj.getTimesheetAppRecord().get(v).getSubmitted());

                timesheetlist.add(detail);

                adapter = new TimesheetApprovalAdapter(getActivity(), obj, appStatus, this);
                listView.setAdapter(adapter);

            }
        }
    }

    public void updatestatus(String name , String entryid, String status, String approvernote , String project) {
        //request api
        initiateLoading(getActivity());

        UpdateTimesheetRequest updatestatusdata = new UpdateTimesheetRequest();
        updatestatusdata.setUsername(name);
        updatestatusdata.setEntryID(entryid);
        updatestatusdata.setStatus(status);
        updatestatusdata.setApproverNotes(approvernote);
        updatestatusdata.setProject(project);

        presenter.onUpdateTimesheet(updatestatusdata);

    }

    @Subscribe
    public void updatetimesheetsuccess(UpdateTimesheetReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True") ) {

            timesheetapplistfromfragment(name); ;

        }

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
        bus.register(this);

        RealmResults<CachedResult> result = RealmObjectController.getCachedResult(MainFragmentActivity.getContext());
        if (result.size() > 0) {

            Gson gson = new Gson();
            if (result.get(0).getCachedAPI() != null) {
                if (result.get(0).getCachedAPI().equals("Clock")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    ClockReceive obj = gson.fromJson(result.get(0).getCachedResult(), ClockReceive.class);
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        bus.unregister(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}

