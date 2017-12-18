package com.intranet.app.ui.Activity.Timesheet;

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
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by Me-Tech on 9/28/2017.
 */

public class ApplyTimesheetFragment extends BaseFragment{

    @Inject
    Bus bus;

    @Inject
    ClockPresenter presenter;

    String selectedleavetype , selectedAppType ,selectedApprover , datefrom ,dateto ;

    String [] project={"All" , "Annual Leave" , "Medical Leave" , "Unpaid Leave" } ;
    String [] task={"All" , "leave" , "credit"} ;
    String [] status={"Pending" , "Submitted"} ;

    Spinner spinproject;
    Spinner spintask;
    Spinner spinstatus;

    private int count = 0;

    @Bind(R.id.newentry)
    Button btnnewentry;

    @Bind(R.id.date)
    TextView txtdate;

    private SharedPrefManager pref;

    public static ApplyTimesheetFragment newInstance(Bundle bundle) {

        ApplyTimesheetFragment fragment = new ApplyTimesheetFragment();
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

        View view = inflater.inflate(R.layout.activity_apply_timesheet, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();

        String date1 = bundle.getString("date");
        txtdate.setText(date1);

        spinproject = (Spinner) view.findViewById(R.id.project);
        spintask = (Spinner) view.findViewById(R.id.task);
        spinstatus = (Spinner) view.findViewById(R.id.status);


        pref = new SharedPrefManager(getActivity());

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar5);

//      toolbar.setLogo(R.drawable.logometech);
        toolbar.setTitle("Apply Timesheet");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().finish();
            }
        });

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, project);
        spinproject.setAdapter(arrayAdapter1);

        spinproject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedleavetype=spinproject.getSelectedItem().toString();
                pref.setLeavetype(selectedleavetype);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, task);
        spintask.setAdapter(arrayAdapter2);

        spintask.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedAppType=spintask.getSelectedItem().toString();
                pref.setApplicationType(selectedAppType);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, status);
        spinstatus.setAdapter(arrayAdapter3);

        spinstatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>arg0, View view, int arg2, long arg3) {

                selectedAppType=spinstatus.getSelectedItem().toString();
                pref.setApplicationType(selectedAppType);

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        btnnewentry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIncrease();
            }
        });

        return view;

    }


    private void doIncrease() {
        count++;
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

