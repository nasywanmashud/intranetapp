package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.AnnualLeave;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.LeaveType;
import com.intranet.app.ui.Model.Receive.MedicalLeave;
import com.intranet.app.ui.Model.Receive.MyLeaveReceive;
import com.intranet.app.ui.Model.Receive.UnpaidLeave;
import com.intranet.app.ui.Model.Request.MyLeaveRequest;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Me-Tech on 9/28/2017.
 */

public class MyLeaveFragment extends BaseFragment{

    @Inject
    Bus bus;

    @Inject
    ClockPresenter presenter;

    private SharedPrefManager pref;

    ArrayList<LeaveType> type = new ArrayList<>();
    ArrayList<AnnualLeave> al = new ArrayList<>();
    ArrayList<MedicalLeave> ml = new ArrayList<>();
    ArrayList<UnpaidLeave> ul = new ArrayList<>();

    MyLeaveListAdapter adapter;
    AnnualLeaveListAdapter adapteral;
    MedicalLeaveListAdapter adapterml;
    UnpaidLeaveListAdapter adapterul;

//    @Bind(R.id.list)
//    ListView list;

//    @Bind(R.id.listannualleave)
//    ListView listal;
//
//    @Bind(R.id.listmedicalleave)
//    ListView listml;
//
//    @Bind(R.id.listunoaidleave)
    ListView listul;

    @Bind(R.id.lms)
    Button btnlms;

    @Bind(R.id.al)
    Button btnal;

    @Bind(R.id.ml)
    Button btnml;

    @Bind(R.id.ul)
    Button btnul;

//    @Bind(R.id.dateFrom)
//    TextView tvdatefrom;
//
//    @Bind(R.id.imgfrom)
//    ImageView imgfrom;
//
//    @Bind(R.id.imgto)
//    ImageView imgto;
//
//    @Bind(R.id.dateTo)
//    TextView tvdateto;
//
//    @Bind(R.id.search)
//    Button btnsearch;
//
//    String selectedapplicationtype , selectedApplicationstatus  , datefrom ,dateto ;
//
//
//    Calendar mCurrentDate ;
//    int day , month , year ;
//
//    String [] applicationstatus={"All" , "Pending" , "Endorsed" , "Rejected" } ;
//    String [] applicationtype={"All" , "leave" , "credit"} ;
//
//
//    @Bind(R.id.applicationstatus)
//    Spinner spinapplicationstatus;
//
//    @Bind(R.id.applicationtype)
//    Spinner spinapplicationtype;
//
//    DatePickerDialog datePickerDialogfrom ;
    String year = "2017";

    String btn ;

    public static MyLeaveFragment newInstance(Bundle bundle) {

        MyLeaveFragment fragment = new MyLeaveFragment();
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

        View view = inflater.inflate(R.layout.activity_my_leave, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        pref = new SharedPrefManager(getActivity());

        HashMap<String, String> username = pref.getUsername();
        final String  name = username.get(SharedPrefManager.USERNAME);
        //myleavefromfragment( name ,  year);
//        mCurrentDate = Calendar.getInstance();
//        day =mCurrentDate.get(Calendar.DAY_OF_MONTH);
//        month=mCurrentDate.get(Calendar.MONTH);
//        year = mCurrentDate.get(Calendar.YEAR);
//
//        month= month+1;
//
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
//
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
//
//        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_dropdown_item_1line, applicationtype);
//        spinapplicationtype.setAdapter(arrayAdapter1);
//
//        spinapplicationtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
//
//                selectedapplicationtype=spinapplicationtype.getSelectedItem().toString();
//               // pref.setApplicationType(selectedapplicationtype);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_dropdown_item_1line, applicationtype);
//        spinapplicationstatus.setAdapter(arrayAdapter2);
//
//        spinapplicationstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {
//
//                selectedApplicationstatus=spinapplicationstatus.getSelectedItem().toString();
//                //pref.setLeavetype(selectedApplicationstatus);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> arg0) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//        btnsearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               // leaveapplistfromfragment(name, selectedleavetype , selectedAppType  , datefrom ,dateto ,selectedApprover ) ;
//
////                Intent next = new Intent(getActivity(), LeaveAppListActivity.class);
////                next.putExtra("selectedleavetype" ,selectedleavetype);
////                next.putExtra("selectedAppType" ,selectedAppType);
////                next.putExtra("datefrom" ,datefrom);
////                next.putExtra("dateto" ,dateto);
////                next.putExtra("selectedApprover" ,selectedApprover);
////
////                startActivity(next);



//            }
//        });

        btnlms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn = "LMS";
                myleavefromfragment( name ,  year);
            }
        });

        btnal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn = "AL";

                myleavefromfragment( name ,  year);
            }
        });

        btnml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn = "ML";

                myleavefromfragment( name ,  year);
            }
        });

        btnul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn = "UL";

                myleavefromfragment( name ,  year);
            }
        });

        return view;
    }

    public void myleavefromfragment(String username , String year) {

        //request api
        initiateLoading(getActivity());
        MyLeaveRequest clockData = new MyLeaveRequest();
        clockData.setUsername(username);
        clockData.setYear(year);

        presenter.onMyLeave(clockData);

    }

    @Subscribe
    public void onNewsSuccess(final MyLeaveReceive obj) {
        dismissLoading();
        // Log.e("size" , "___" + obj.getDetails().size());

        if (obj.getStatus().equals("True") ) {

            if( btn.equals("LMS")) {

                Intent in = new Intent(getActivity(), LMSdataActivity.class);
                String stringObject = new Gson().toJson(obj);
                pref.setLms(stringObject);

                startActivity(in);

            }

            else if ( btn.equals("AL")) {

                Intent in = new Intent(getActivity(), ALdataActivity.class);
                String stringObject = new Gson().toJson(obj);
                pref.setAl(stringObject);

                startActivity(in);

            }

            else if ( btn.equals("ML")) {

                Intent in = new Intent(getActivity(), MLdataActivity.class);
                String stringObject = new Gson().toJson(obj);
                pref.setMl(stringObject);

                startActivity(in);

            }

            else if ( btn.equals("UL")) {

                Intent in = new Intent(getActivity(), ULdataActivity.class);
                String stringObject = new Gson().toJson(obj);
                pref.setUl(stringObject);

                startActivity(in);

            }


//            for (int v = 0 ; v < obj.getLeaveType().size(); v++) {
//
//                //Log.e("jayee", obj.getDetails().get(v).getTitle());
//
//                LeaveType detail = new LeaveType();
//                detail.setLeaveType(obj.getLeaveType().get(v).getLeaveType());
//                detail.setYear(obj.getLeaveType().get(v).getYear());
//                detail.setBroughtForward(obj.getLeaveType().get(v).getLeaveType());
//                detail.setAnnualEntitlement(obj.getLeaveType().get(v).getAnnualEntitlement());
//                detail.setAdhocEntitlement(obj.getLeaveType().get(v).getAdhocEntitlement());
//                detail.setTotal(obj.getLeaveType().get(v).getTotal());
//                detail.setLeaveTaken(obj.getLeaveType().get(v).getLeaveTaken());
//                detail.setCreditApproved(obj.getLeaveType().get(v).getCreditApproved());
//                detail.setBalance(obj.getLeaveType().get(v).getBalance());
//                type.add(detail);
//
//                adapter = new MyLeaveListAdapter(getActivity(), obj);
//
//                list.setAdapter(adapter);
//
//            }
//
//            for (int v = 0 ; v < obj.getAnnualLeave().size(); v++) {
//
//                //Log.e("jayee", obj.getDetails().get(v).getTitle());
//
//                AnnualLeave detail = new AnnualLeave();
//                detail.setRefNo(obj.getAnnualLeave().get(v).getRefNo());
//                detail.setAppliedDate(obj.getAnnualLeave().get(v).getAppliedDate());
//                detail.setLeaveType(obj.getAnnualLeave().get(v).getLeaveType());
//                detail.setDateFrom(obj.getAnnualLeave().get(v).getDateFrom());
//                detail.setDateTo(obj.getAnnualLeave().get(v).getDateTo());
//                detail.setDays(obj.getAnnualLeave().get(v).getDays());
//                detail.setReliefStaff(obj.getAnnualLeave().get(v).getReliefStaff());
//                detail.setStatus(obj.getAnnualLeave().get(v).getStatus());
//                detail.setStaffRemarks(obj.getAnnualLeave().get(v).getStaffRemarks());
//                detail.setApproverRemarks(obj.getAnnualLeave().get(v).getApproverRemarks());
//
//                al.add(detail);
//
//                adapteral = new AnnualLeaveListAdapter(getActivity(), obj);
//
//                listal.setAdapter(adapteral);
//            }
//
//            for (int v = 0 ; v < obj.getMedicalLeave().size(); v++) {
//
//                //Log.e("jayee", obj.getDetails().get(v).getTitle());
//
//                MedicalLeave detail = new MedicalLeave();
//                detail.setRefNo(obj.getMedicalLeave().get(v).getRefNo());
//                detail.setAppliedDate(obj.getMedicalLeave().get(v).getAppliedDate());
//                detail.setLeaveType(obj.getMedicalLeave().get(v).getLeaveType());
//                detail.setDateFrom(obj.getMedicalLeave().get(v).getDateFrom());
//                detail.setDateTo(obj.getMedicalLeave().get(v).getDateTo());
//                detail.setDays(obj.getMedicalLeave().get(v).getDays());
//                detail.setReliefStaff(obj.getMedicalLeave().get(v).getReliefStaff());
//                detail.setStatus(obj.getMedicalLeave().get(v).getStatus());
//                detail.setStaffRemarks(obj.getMedicalLeave().get(v).getStaffRemarks());
//                detail.setApproverRemarks(obj.getMedicalLeave().get(v).getApproverRemarks());
//
//                ml.add(detail);
//
//                adapterml = new MedicalLeaveListAdapter(getActivity(), obj);
//
//                listml.setAdapter(adapterml);
//            }
//
//            for (int v = 0 ; v < obj.getUnpaidLeave().size(); v++) {
//
//                //Log.e("jayee", obj.getDetails().get(v).getTitle());
//
//                UnpaidLeave detail = new UnpaidLeave();
//                detail.setRefNo(obj.getUnpaidLeave().get(v).getRefNo());
//                detail.setAppliedDate(obj.getUnpaidLeave().get(v).getAppliedDate());
//                detail.setLeaveType(obj.getUnpaidLeave().get(v).getLeaveType());
//                detail.setDateFrom(obj.getUnpaidLeave().get(v).getDateFrom());
//                detail.setDateTo(obj.getUnpaidLeave().get(v).getDateTo());
//                detail.setDays(obj.getUnpaidLeave().get(v).getDays());
//                detail.setReliefStaff(obj.getUnpaidLeave().get(v).getReliefStaff());
//                detail.setStatus(obj.getUnpaidLeave().get(v).getStatus());
//                detail.setStaffRemarks(obj.getUnpaidLeave().get(v).getStaffRemarks());
//                detail.setApproverRemarks(obj.getUnpaidLeave().get(v).getApproverRemarks());
//
//                ul.add(detail);
//
//                adapterul = new UnpaidLeaveListAdapter(getActivity(), obj);
//
//                listul.setAdapter(adapterul);
//            }
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

