package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import com.intranet.app.ui.Activity.TabLMS.TabLms;
import com.intranet.app.ui.Model.Receive.AnnualLeave;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.LeaveAppListReceive;
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

public class LMSdataFragment extends BaseFragment{

    @Inject
    Bus bus;

    @Inject
    ClockPresenter presenter;

    private SharedPrefManager pref;

    ArrayList<LeaveType> type = new ArrayList<>();

    MyLeaveListAdapter adapter;

    @Bind(R.id.list)
    ListView list;


    public static LMSdataFragment newInstance(Bundle bundle) {

        LMSdataFragment fragment = new LMSdataFragment();
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

        View view = inflater.inflate(R.layout.layout_lmslist, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();


        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarlms);
        toolbar.setTitle("Leave Balance");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        pref = new SharedPrefManager(getActivity());

        HashMap<String, String> stringObject = pref.getLMS();
        final String sobject = stringObject.get(SharedPrefManager.LMS);

        Gson gson = new Gson();
        MyLeaveReceive obj = gson.fromJson(sobject , MyLeaveReceive.class);

        for (int v = 0 ; v < obj.getLeaveType().size(); v++) {

            //Log.e("jayee", obj.getDetails().get(v).getTitle());

            LeaveType detail = new LeaveType();
            detail.setLeaveType(obj.getLeaveType().get(v).getLeaveType());
            detail.setYear(obj.getLeaveType().get(v).getYear());
            detail.setBroughtForward(obj.getLeaveType().get(v).getLeaveType());
            detail.setAnnualEntitlement(obj.getLeaveType().get(v).getAnnualEntitlement());
            detail.setAdhocEntitlement(obj.getLeaveType().get(v).getAdhocEntitlement());
            detail.setTotal(obj.getLeaveType().get(v).getTotal());
            detail.setLeaveTaken(obj.getLeaveType().get(v).getLeaveTaken());
            detail.setCreditApproved(obj.getLeaveType().get(v).getCreditApproved());
            detail.setBalance(obj.getLeaveType().get(v).getBalance());
            type.add(detail);

            adapter = new MyLeaveListAdapter(getActivity(), obj);

            list.setAdapter(adapter);

        }
        return view;
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

