package com.intranet.app.ui.Activity.LMS.LeaveApprovalSearch;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.LMS.LeaveAppListActivity;
import com.intranet.app.ui.Activity.LMS.MyLeave.LmslistAdapter;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppReceive;
import com.intranet.app.ui.Model.Receive.LmsListReceive;
import com.intranet.app.ui.Model.Receive.RecordList;
import com.intranet.app.ui.Model.Receive.Records;
import com.intranet.app.ui.Model.Receive.UpdateStatusReceive;
import com.intranet.app.ui.Model.Request.LeaveAppListRequest;
import com.intranet.app.ui.Model.Request.LeaveAppRequest;
import com.intranet.app.ui.Model.Request.LmslistRequest;
import com.intranet.app.ui.Model.Request.UpdateStatusRequest;
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

public class LeaveApprovalSearchFragment extends BaseFragment{

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

    LmslistAdapter adapter;


//    String al = "Annual Leave";
//    String cr = "Credit";
//    String datefrom = "2017-08-20";
//    String dateto = "2017-08-20";

    ArrayList<RecordList> lmslist = new ArrayList<RecordList>();

    ArrayList<Records> leaveapps = new ArrayList<Records>();
    ArrayList<String>appStatus = new ArrayList<String>();

    String selectedleavetype , selectedAppType ,selectedApprover , datefrom ,dateto ;
    //String selectedleavetype , selectedAppType ,selectedApprover  ;

    ArrayList<String>leaveapplist = new ArrayList<String>();

    Calendar mCurrentDate ;
    int day , month , year ;

    String [] leavetype={"All" , "Annual Leave" , "Medical Leave" , "Unpaid Leave" } ;
    String [] applicationtype={"All" , "leave" , "credit"} ;
    String [] appstatus={"All" , "leave" , "credit"} ;
    String [] statusall={"Submitted" , "Approved" , "Rejected"} ;

    Spinner spinapprover;
    Spinner spinapplicationtype;
    Spinner spinleavetype;
    Spinner spinappstatus;
    String m,n ;
    String name;

    DatePickerDialog datePickerDialogfrom ;

    private SharedPrefManager pref;

    public static LeaveApprovalSearchFragment newInstance(Bundle bundle) {

        LeaveApprovalSearchFragment fragment = new LeaveApprovalSearchFragment();
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

        View view = inflater.inflate(R.layout.activity_search_leave_approval, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        spinleavetype = (Spinner) view.findViewById(R.id.leavetype);
        spinapplicationtype = (Spinner) view.findViewById(R.id.applicationtype);
        spinapprover = (Spinner) view.findViewById(R.id.approver);
        spinappstatus = (Spinner) view.findViewById(R.id.appstatus);

        Bundle bundleObject = getActivity().getIntent().getExtras();
        //leaveapps =(ArrayList<Records>) bundleObject.getSerializable("test");

        pref = new SharedPrefManager(getActivity());

        final HashMap<String, String> username = pref.getUsername();
        name = username.get(SharedPrefManager.USERNAME);

        leaveappfromfragment(name);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle("Leave Approval");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });


        mCurrentDate = Calendar.getInstance();
        day =mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month=mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);
//
        //month= month+1;

        tvdatefrom.setText("01-01-2017");
        datefrom = tvdatefrom.getText().toString();
        Log.e("datefrom",datefrom);


        imgfrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialogfrom = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;
                        String hull = "";

                        if(monthOfYear<10){

                            m="0";

                        }
                        else {
                            m = hull;
                        }

                        if(dayOfMonth<10){

                            n="0";

                        }
                        else {
                            n = hull;
                        }
                        tvdatefrom.setText(n+dayOfMonth+ "-" + m + monthOfYear + "-"  + year );

                        datefrom = tvdatefrom.getText().toString();
                        pref.setDateFrom(datefrom);

                    }
                }, year,month,day);
                datePickerDialogfrom.show();


            }
        });

        tvdateto.setText("31-12-2018");
        dateto = tvdateto.getText().toString();
        Log.e("dateto",dateto);


        imgto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialogto = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        monthOfYear = monthOfYear+1;

                        String hull = "";

                        if(monthOfYear<10){

                            m="0";

                        }
                        else {
                            m = hull;
                        }

                        if(dayOfMonth<10){

                            n="0";

                        }
                        else {
                            n = hull;
                        }
                        tvdateto.setText(n+ dayOfMonth+ "-" + m + monthOfYear + "-"  +year  );

                        dateto = tvdateto.getText().toString();
                        pref.setDateTo(dateto);

                    }
                }, year,month,day);
                datePickerDialogto.show();

            }
        });

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, leavetype);
        spinleavetype.setAdapter(arrayAdapter1);

        spinleavetype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedleavetype=spinleavetype.getSelectedItem().toString();
                pref.setLeavetype(selectedleavetype);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, applicationtype);
        spinapplicationtype.setAdapter(arrayAdapter2);

        spinapplicationtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedAppType=spinapplicationtype.getSelectedItem().toString();
                pref.setApplicationType(selectedAppType);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  leaveapplistfromfragment(name, selectedleavetype , selectedAppType  , datefrom ,dateto ,selectedApprover ) ;

//                Intent next = new Intent(getActivity(), LeaveAppListActivity.class);
//                next.putExtra("selectedleavetype" ,selectedleavetype);
//                next.putExtra("selectedAppType" ,selectedAppType);
//                next.putExtra("datefrom" ,datefrom);
//                next.putExtra("dateto" ,dateto);
//                next.putExtra("selectedApprover" ,selectedApprover);
//
//                startActivity(next);

            }
        });

        return view;

    }

    private void leaveappfromfragment(String name) {
        //request api
        initiateLoading(getActivity());
        LeaveAppRequest leaveappdata = new LeaveAppRequest();
        leaveappdata.setUsername(name);

        presenter.onLeaveApp(leaveappdata);

    }

    @Subscribe
    public void onLeaveAppSuccess(LeaveAppReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True") ) {

            for (int v = 0; v < obj.getApprover().size(); v++) {

                leaveapplist.add(obj.getApprover().get(v).getName());

            }

            ArrayAdapter<String> arrayAdapterxx = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_dropdown_item_1line, leaveapplist);
            spinapprover.setAdapter(arrayAdapterxx);

            spinapprover.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                    selectedApprover=spinapprover.getSelectedItem().toString();
                    pref.setApprover(selectedApprover);

                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }
            });



        } else {

            Toast.makeText(getActivity(), "No Records Found", Toast.LENGTH_LONG).show();



        }
    }

    private void  leaveapplistfromfragment(String name ,String leaveapp , String apptype, String datefrom, String dateto, String approver) {
        //request api
        initiateLoading(getActivity());
        LeaveAppListRequest leaveapplistdata = new LeaveAppListRequest();
        leaveapplistdata.setUsername(name);
        leaveapplistdata.setLeaveType(leaveapp);
        leaveapplistdata.setApplicationType(apptype);
        leaveapplistdata.setDateFrom(datefrom);
        leaveapplistdata.setDateTo(dateto);
        leaveapplistdata.setApprover(approver);
        presenter.onLeaveAppList(leaveapplistdata);

    }

    @Subscribe
    public void onLeaveAppListSuccess(LeaveAppListReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True") ) {

            Intent in = new Intent(getActivity(),LeaveAppListActivity.class);

            in.putExtra("name", name);
            in.putExtra("al", selectedleavetype);
            in.putExtra("cr", selectedAppType);
            in.putExtra("datefrom", datefrom);
            in.putExtra("dateto", dateto);
            in.putExtra("selectedApprover", selectedApprover);

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

