package com.intranet.app.ui.Activity.LMS;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.TabLMS.TabLms;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
import com.intranet.app.ui.Model.Receive.Records;
import com.intranet.app.ui.Model.Receive.UpdateStatusReceive;
import com.intranet.app.ui.Model.Request.LeaveAppListRequest;
import com.intranet.app.ui.Model.Request.UpdateStatusRequest;
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
 * This class allow user to log in the app
 */
public class LeaveAppListFragment extends BaseFragment  {

    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

    ArrayList<Records> leaveapps = new ArrayList<>();
    ArrayList<String>appStatus = new ArrayList<String>();

    LeaveAppListAdapter adapter;

    @Bind(R.id.listview)
    ListView listView;


//
//    @Bind(R.id.update)
//    Button btnupdate;

    String nama,al , cr  , datefrom ,dateto ,selectedApprover;

    private SharedPrefManager pref;

    public static LeaveAppListFragment newInstance(Bundle bundle) {

        LeaveAppListFragment fragment = new LeaveAppListFragment();
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

        View view = inflater.inflate(R.layout.activity_leaveapplist, container, false);
        ButterKnife.bind(this, view);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar100);
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

        HashMap<String, String> username = pref.getUsername();
        final String  name = username.get(SharedPrefManager.USERNAME);
        Gson gson = new Gson();
        LeaveAppListReceive obj = gson.fromJson(sobject , LeaveAppListReceive.class);

        HashMap<String, String> refno1 = pref.getRefno();
        final String  refno = refno1.get(SharedPrefManager.REFNO);

        HashMap<String, String> aa = pref.getApproverRemarks();
        final String  approverremarks = aa.get(SharedPrefManager.APPROVERREMARKS);

        HashMap<String, String> aaa = pref.getUpdateStatus();
        final String  updatestatuss = aaa.get(SharedPrefManager.UPDATESTATUS);

        nama = bundle.getString("name");
        al = bundle.getString("al");
        cr = bundle.getString("cr");
        datefrom = bundle.getString("datefrom");
        dateto = bundle.getString("dateto");
        selectedApprover = bundle.getString("selectedApprover");

        appStatus.add(obj.getStatus4());
        appStatus.add(obj.getStatus1());
        appStatus.add(obj.getStatus3());

            for (int v = 0; v < obj.getRecords().size(); v++) {

                Records detail = new Records();
                detail.setDateTo(obj.getRecords().get(v).getDateTo());
                detail.setAppliedDate(obj.getRecords().get(v).getAppliedDate());
                detail.setApprovalStatus(obj.getRecords().get(v).getApprovalStatus());
                detail.setApproverRemarks(obj.getRecords().get(v).getApproverRemarks());
                detail.setDays(obj.getRecords().get(v).getDays());
                detail.setDateFrom(obj.getRecords().get(v).getDateFrom());
                detail.setLeaveType(obj.getRecords().get(v).getLeaveType());
                detail.setRefNo(obj.getRecords().get(v).getRefNo());
                detail.setStaff(obj.getRecords().get(v).getStaff());
                detail.setSVName(obj.getRecords().get(v).getSVName());
                detail.setUserRemarks(obj.getRecords().get(v).getUserRemarks());
                leaveapps.add(detail);

                adapter = new LeaveAppListAdapter(getActivity(), obj, appStatus, this);
                listView.setAdapter(adapter);

            }

        return view;

    }

    public void updatestatus(String name , String RefNo, String upstatus, String approverremarks) {
        //request api
        initiateLoading(getActivity());

        UpdateStatusRequest updatestatusdata = new UpdateStatusRequest();
        updatestatusdata.setUsername(name);
        updatestatusdata.setRefNo(RefNo);
        updatestatusdata.setUpdateAppStatus(upstatus);
        updatestatusdata.setApproverRemarks(approverremarks);
        presenter.onUpdateStatus(updatestatusdata);

    }

    @Subscribe
    public void updatestatusSuccess(UpdateStatusReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("True") ) {

            leaveapplistfromfragment(nama, al , cr  , datefrom ,dateto ,selectedApprover ) ;

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


            for (int v = 0 ; v < obj.getRecords().size(); v++) {

                    Records detail = new Records();
                    detail.setDateTo(obj.getRecords().get(v).getDateTo());
                    detail.setAppliedDate(obj.getRecords().get(v).getAppliedDate());
                    detail.setApprovalStatus(obj.getRecords().get(v).getApprovalStatus());
                    detail.setApproverRemarks(obj.getRecords().get(v).getApproverRemarks());
                    detail.setDays(obj.getRecords().get(v).getDays());
                    detail.setDateFrom(obj.getRecords().get(v).getDateFrom());
                    detail.setLeaveType(obj.getRecords().get(v).getLeaveType());
                    detail.setRefNo(obj.getRecords().get(v).getRefNo());
                    detail.setStaff(obj.getRecords().get(v).getStaff());
                    detail.setSVName(obj.getRecords().get(v).getSVName());
                    detail.setUserRemarks(obj.getRecords().get(v).getUserRemarks());
                    leaveapps.add(detail);

                    adapter = new LeaveAppListAdapter(getActivity(), obj, appStatus, this);
                    listView.setAdapter(adapter);


                }
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
