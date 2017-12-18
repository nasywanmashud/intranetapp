package com.intranet.app.ui.Activity.TimesheetSearch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.LMS.LeaveAppListAdapter;
import com.intranet.app.ui.Activity.TabLMS.TabLms;
import com.intranet.app.ui.Activity.TimesheetApproval.TimesheetApprovalActivity;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
import com.intranet.app.ui.Model.Receive.Records;
import com.intranet.app.ui.Model.Receive.TimesheetAppRecord;
import com.intranet.app.ui.Model.Receive.TimesheetSearchReceive;
import com.intranet.app.ui.Model.Receive.TimesheetstatusReceive;
import com.intranet.app.ui.Model.Receive.UpdateStatusReceive;
import com.intranet.app.ui.Model.Request.LeaveAppListRequest;
import com.intranet.app.ui.Model.Request.TimesheetstatusRequest;
import com.intranet.app.ui.Model.Request.UpdateStatusRequest;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * This class allow user to log in the app
 */
public class TimesheetSearchFragment extends BaseFragment  {

    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

    ArrayList<TimesheetAppRecord> app = new ArrayList<>();
    ArrayList<String>Status = new ArrayList<String>();
    ArrayList<String>Statuss = new ArrayList<String>();


    @Bind(R.id.listview)
    ListView listView;

    @Bind(R.id.statusall)
    Spinner spinappstatusall;

    @Bind(R.id.status1)
    Spinner spinstatus1;

    @Bind(R.id.status2)
    Spinner spinstatus2;
//
//    @Bind(R.id.update)
//    Button btnupdate;
 TimesheetSearchAdapter.ViewHolder vh;

    String nama,al , cr  , datefrom ,dateto ,selectedApprover , updatestatusall, a1,a2 , spin;
    String [] appStatus1={"Submitted" , "Approved" , "Rejected"} ;
    String [] appStatus2={ "Approved" ,"Submitted" , "Rejected"} ;
    String [] appStatus3={"Rejected", "Submitted" , "Approved" } ;
    ArrayAdapter<CharSequence> countryCodesAdapter;
    private SharedPrefManager pref;
    TimesheetSearchAdapter adapter;
    ArrayList<String>appStatus = new ArrayList<String>();

    public static TimesheetSearchFragment newInstance(Bundle bundle) {

        TimesheetSearchFragment fragment = new TimesheetSearchFragment();
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

        View view = inflater.inflate(R.layout.activity_timesheetsearch, container, false);
        ButterKnife.bind(this, view);




        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Result Page");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              getActivity().finish();
            }
        });
        pref = new SharedPrefManager(getActivity());

        Bundle bundle = getArguments();
        Bundle bundleObject = getActivity().getIntent().getExtras();
        HashMap<String, String> stringObject = pref.getstringObject();
        final String sobject = stringObject.get(SharedPrefManager.STRINGOBJECT);

        HashMap<String, String> status1 = pref.getUpdateStatus();
        final String  status = status1.get(SharedPrefManager.UPDATESTATUS);
        String sta = "Submitted";

        pref.setUpdateStatus(sta);
        Log.e("lalala2" , status);

        Gson gson = new Gson();
        TimesheetSearchReceive obj = gson.fromJson(sobject , TimesheetSearchReceive.class);

        HashMap<String, String> refno1 = pref.getRefno();
        final String  refno = refno1.get(SharedPrefManager.REFNO);

        HashMap<String, String> aa = pref.getApproverRemarks();
        final String  approverremarks = aa.get(SharedPrefManager.APPROVERREMARKS);

        HashMap<String, String> aaa = pref.getUpdateStatus();
        final String  updatestatuss = aaa.get(SharedPrefManager.UPDATESTATUS);

//        nama = bundle.getString("name");
//        al = bundle.getString("al");
//        cr = bundle.getString("cr");
//        datefrom = bundle.getString("datefrom");
//        dateto = bundle.getString("dateto");
//        selectedApprover = bundle.getString("selectedApprover");
        if( status.equals("Submitted")) {
            ArrayAdapter<String> arrayAdapter123 = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_dropdown_item_1line, appStatus1);
            spinappstatusall.setAdapter(arrayAdapter123);

//            asd(getActivity());

        } else if( status.equals("Approved")){
                ArrayAdapter<String> arrayAdapter123 = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line, appStatus2);
                spinappstatusall.setAdapter(arrayAdapter123);
//            asd(getActivity());

        } else if( status.equals("Rejected")) {
            ArrayAdapter<String> arrayAdapter123 = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_dropdown_item_1line, appStatus3);
            spinappstatusall.setAdapter(arrayAdapter123);
//            asd(getActivity());

        }

        spinappstatusall.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                //selectedAppType[arg2] =vh.spinappstatus.getSelectedItem().toString();
                updatestatusall = spinappstatusall.getSelectedItem().toString();

                pref.setUpdateStatus(updatestatusall);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                //pref.setUpdateStatus(vh.spinappstatus.getSelectedItem().toString());
            }

        });


        if (status.equals("Submitted")) {
            Status.add(obj.getStatus4());
            Status.add(obj.getStatus1());
            Status.add(obj.getStatus3());
        } else if (status.equals("Approved")) {
            Status.add(obj.getStatus1());
            Status.add(obj.getStatus4());
            Status.add(obj.getStatus3());
        }
        else if (status.equals("Rejected")) {
            Status.add(obj.getStatus3());
            Status.add(obj.getStatus4());
            Status.add(obj.getStatus1());

        }
        else{
            Status.add(obj.getStatus4());
            Status.add(obj.getStatus1());
            Status.add(obj.getStatus3());
        }
            for (int v = 0; v < obj.getTimesheetAppRecord().size(); v++) {

                TimesheetAppRecord detail = new TimesheetAppRecord();
                detail.setProject(obj.getTimesheetAppRecord().get(v).getProject());
                detail.setTask(obj.getTimesheetAppRecord().get(v).getTask());
                detail.setDate(obj.getTimesheetAppRecord().get(v).getDate());
                detail.setHours(obj.getTimesheetAppRecord().get(v).getHours());
                detail.setNotes(obj.getTimesheetAppRecord().get(v).getNotes());
                detail.setCreated(obj.getTimesheetAppRecord().get(v).getCreated());
                detail.setSubmitted(obj.getTimesheetAppRecord().get(v).getSubmitted());
                detail.setApproverNotes(obj.getTimesheetAppRecord().get(v).getApproverNotes());

                app.add(detail);

                adapter = new TimesheetSearchAdapter(getActivity(), obj, Status, Statuss, this);
                listView.setAdapter(adapter);

            }

        ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(getActivity(),
                                                    R.array.first_spinner, android.R.layout.simple_spinner_item) ;
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter = new TimesheetSearchAdapter(getActivity(), obj, appStatus,Statuss, this);

        ArrayAdapter<CharSequence> countryCodesAdapter = ArrayAdapter.createFromResource(getActivity(),
                                                    R.array.first_spinner, android.R.layout.simple_spinner_item);
        countryCodesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinstatus1.setAdapter(countryAdapter);
        spin = spinstatus1.getSelectedItem().toString();
        pref.setUpdateStatus(spin);

        spinstatus1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    spinstatus2.setSelection(position);
//                    vh.spinappstatus.setSelection(position);

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //vh.spinappstatus.setAdapter(countryCodesAdapter);
        spinstatus2.setAdapter(countryCodesAdapter);

//

        return view;

    }

//    public void timesheetstatusfragment(String status) {
//        //request api
//        initiateLoading(getActivity());
//        TimesheetstatusRequest leaveappdata = new TimesheetstatusRequest();
//        leaveappdata.setStatus(status);
//
//        presenter.onTimesheetstatus(leaveappdata);
//
//    }
//
//    @Subscribe
//    public void onLeaveAppSuccess(TimesheetstatusReceive obj) {
//        dismissLoading();
//        // Statuss.clear();
//
//        if (obj.getStatus().equals("True") ) {
//
//            Statuss.add(obj.getStatus4());
//            Statuss.add(obj.getStatus1());
//            Statuss.add(obj.getStatus3());
//
//            String stringObject = new Gson().toJson(obj);
//            pref.setstringObject(stringObject);
//            }
//
//        }


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
                    // onClockSuccess(obj);

//                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
//                    Log.e("CachedData", result.get(0).getCachedResult().toString());
//
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
