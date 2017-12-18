package com.intranet.app.ui.Activity.LMS.MyLeave;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.TabLMS.TabLms;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.MyLeaveReceive;
import com.intranet.app.ui.Model.Receive.UnpaidLeave;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Me-Tech on 9/28/2017.
 */

public class ULdataFragment extends BaseFragment{

    @Inject
    Bus bus;

    @Inject
    ClockPresenter presenter;

    private SharedPrefManager pref;

    ArrayList<UnpaidLeave> ul = new ArrayList<>();

    UnpaidLeaveListAdapter adapterul;

    @Bind(R.id.listul)
    ListView list;


    public static ULdataFragment newInstance(Bundle bundle) {

        ULdataFragment fragment = new ULdataFragment();
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

        View view = inflater.inflate(R.layout.layout_unpaidleavelist, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        pref = new SharedPrefManager(getActivity());

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbarul);
        toolbar.setTitle("Unpaid Leave");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(),TabLms.class);
                startActivity(in);
            }
        });

        HashMap<String, String> stringObject = pref.getUL();
        final String sobject = stringObject.get(SharedPrefManager.UL);

        Gson gson = new Gson();
        MyLeaveReceive obj = gson.fromJson(sobject , MyLeaveReceive.class);

        for (int v = 0 ; v < obj.getUnpaidLeave().size(); v++) {

            //Log.e("jayee", obj.getDetails().get(v).getTitle());

            UnpaidLeave detail = new UnpaidLeave();
            detail.setRefNo(obj.getAnnualLeave().get(v).getRefNo());
            detail.setAppliedDate(obj.getAnnualLeave().get(v).getAppliedDate());
            detail.setLeaveType(obj.getAnnualLeave().get(v).getLeaveType());
            detail.setDateFrom(obj.getAnnualLeave().get(v).getDateFrom());
            detail.setDateTo(obj.getAnnualLeave().get(v).getDateTo());
            detail.setDays(obj.getAnnualLeave().get(v).getDays());
            detail.setReliefStaff(obj.getAnnualLeave().get(v).getReliefStaff());
            detail.setStatus(obj.getAnnualLeave().get(v).getStatus());
            detail.setStaffRemarks(obj.getAnnualLeave().get(v).getStaffRemarks());
            detail.setApproverRemarks(obj.getAnnualLeave().get(v).getApproverRemarks());
            ul.add(detail);

            adapterul = new UnpaidLeaveListAdapter(getActivity(), obj);

            list.setAdapter(adapterul);

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

