package com.intranet.app.ui.Activity.TimesheetApprovalSearch;

/**
 * Created by akarumbi on 10/25/2017.
 */


import android.app.DatePickerDialog;
import android.content.Intent;
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

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalAdapter;
import com.intranet.app.ui.Activity.TimesheetSearch.TimesheetSearchActivity;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.TaskReceive;
import com.intranet.app.ui.Model.Receive.TimesheetAppRecord;
import com.intranet.app.ui.Model.Receive.TimesheetApprovalReceive;
import com.intranet.app.ui.Model.Receive.TimesheetListReceive;
import com.intranet.app.ui.Model.Receive.TimesheetSearchReceive;
import com.intranet.app.ui.Model.Request.TaskRequest;
import com.intranet.app.ui.Model.Request.TimesheetApprovalRequest;
import com.intranet.app.ui.Model.Request.TimesheetListRequest;
import com.intranet.app.ui.Model.Request.TimesheetSearchRequest;
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

public class TimesheetApprovalSearchFragment extends BaseFragment{

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

    private SharedPrefManager pref;


    public static TimesheetApprovalSearchFragment newInstance(Bundle bundle) {

        TimesheetApprovalSearchFragment fragment = new TimesheetApprovalSearchFragment();
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

        View view = inflater.inflate(R.layout.activity_timesheet_approval_search, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        pref = new SharedPrefManager(getActivity());

        spinapprover = (Spinner) view.findViewById(R.id.staff);

        //id = "Firefly Non-Billable (Kiosk, SMS, Mobile, Enrich)";

        final HashMap<String, String> username = pref.getUsername();
        name = username.get(SharedPrefManager.USERNAME);

//        final HashMap<String, String> projectname1 = pref.getProjectName();
//        final String projectname = projectname1.get(SharedPrefManager.PROJECTNAME);

        timesheetappfromfragment(name);
        //timesheetapplistfromfragment(name);

        mCurrentDate = Calendar.getInstance();
        day =mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month=mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);



        tvdatefrom.setText( year + "-" + month + "-" +day);

        imgfrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialogfrom = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;

                        tvdatefrom.setText(year+ "-" + monthOfYear + "-" + dayOfMonth );

                        datefrom = tvdatefrom.getText().toString();
                        //pref.setDateFrom(datefrom);

                    }
                }, year,month,day);
                datePickerDialogfrom.show();


            }
        });

        tvdateto.setText(year + "-" + month + "-" + day);


        imgto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialogto = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;

                        tvdateto.setText(year + "-" + monthOfYear + "-" + dayOfMonth);

                        dateto = tvdateto.getText().toString();
                        //pref.setDateTo(dateto);

                    }
                }, year,month,day);
                datePickerDialogto.show();

            }
        });

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, status);
        spinstatus.setAdapter(arrayAdapter1);

        spinstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedstatus=spinstatus.getSelectedItem().toString();
                Log.e("testtest",selectedstatus);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });



        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, ot);
        spinot.setAdapter(arrayAdapter2);

        spinot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedot=spinot.getSelectedItem().toString();

                if (selectedot.equals("Yes")){
                    ott = "1";

                } else  if (selectedot.equals("No")){
                    ott = "0";

                } else {
                    ott = "All";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        searchsuccess( name , selectedproject , selectedtask,  selectedstaff,  selectedstatus ,  ott);

            }
        });

        return view;

    }





    private void timesheetappfromfragment(String username) {
        //request api
        initiateLoading(getActivity());
        TimesheetApprovalRequest leaveappdata = new TimesheetApprovalRequest();
        leaveappdata.setUsername(username);

        presenter.onTimesheetApproval(leaveappdata);

    }



    @Subscribe
    public void onLeaveAppSuccess(TimesheetApprovalReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True")) {


                for (int v = 0; v < obj.getStaff().size(); v++) {

                    Staff.add(obj.getStaff().get(v).getName());

                }

                ArrayAdapter<String> arrayAdapterxx = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line, Staff);
                spinstaff.setAdapter(arrayAdapterxx);

                spinstaff.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {

                        selectedstaff=spinstaff.getSelectedItem().toString();


//                        pref.setApprover(selectedApprover);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }
                });


                for (int v = 0; v < obj.getProject().size(); v++) {

//                    Project.add(obj.getProject().get(v).getProjectId());
                //Project.add(obj.getStatus1());
                Project.add(obj.getProject().get(v).getProjectName());

                }

                ArrayAdapter<String> arrayAdapterxxxxx = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line, Project);
                spinproject.setAdapter(arrayAdapterxxxxx);

                spinproject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {


                      selectedproject=spinproject.getSelectedItem().toString();

                        Log.e("projectproject", selectedproject);
                        pref.setProjectName(selectedproject);
                        //spintask.setAdapter(null);

                        task (selectedproject);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub


                    }

                });



                txtapprover.setText(obj.getApprover());

            }


            else {

            }
        }


    private void task(String projectname) {
        //request api
        initiateLoading(getActivity());
        TaskRequest leaveappdata = new TaskRequest();
        leaveappdata.setProject(projectname);
        presenter.onTask(leaveappdata);

    }

    @Subscribe
    public void onLeaveAppSuccess(TaskReceive obj) {
        dismissLoading();
        if (obj.getStatus().equals("True")) {
            Task.clear();
            Task.add(obj.getStatus1());

            for (int v = 0; v < obj.getTask().size(); v++) {

//                                 Project.add(obj.getStatus1());
                Task.add(obj.getTask().get(v).getTaskName());

            }

            ArrayAdapter<String> arrayAdapterxxxxxx = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_dropdown_item_1line, Task);
            spintask.setAdapter(arrayAdapterxxxxxx);

            spintask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {


                    selectedtask=spintask.getSelectedItem().toString();

                    //Log.e("projectproject", selectedproject);
                    //pref.setProjectName(selectedproject);
                    //task (selectedproject);

                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }

            });

        }

        else {

        }
    }


    private void  searchsuccess(String name ,String project , String task, String staff, String status , String ot) {
        //request api
        initiateLoading(getActivity());
        TimesheetSearchRequest leaveapplistdata = new TimesheetSearchRequest();
        leaveapplistdata.setUsername(name);
        leaveapplistdata.setProject(project);
        leaveapplistdata.setTask(task);
        leaveapplistdata.setStaff(staff);
        leaveapplistdata.setStatus(status);
        leaveapplistdata.setOT(ot);
        presenter.onTimesheetSearch(leaveapplistdata);

    }

    @Subscribe
    public void onLeaveAppListSuccess(TimesheetSearchReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True") ) {

            Intent in = new Intent(getActivity(),TimesheetSearchActivity.class);

//            in.putExtra("name", name);
//            in.putExtra("project", selectedleavetype);
//            in.putExtra("task", selectedAppType);
//            in.putExtra("staff", datefrom);
//            in.putExtra("status", dateto);
//            in.putExtra("ot", selectedApprover);

            String stringObject = new Gson().toJson(obj);
            pref.setstringObject(stringObject);

            startActivity(in);

        } else {

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

