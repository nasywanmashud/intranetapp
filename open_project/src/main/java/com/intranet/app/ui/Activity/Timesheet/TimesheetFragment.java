package com.intranet.app.ui.Activity.Timesheet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.Profile.ProfileActivity;
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

public class TimesheetFragment extends BaseFragment{

    @Inject
    Bus bus;

    @Inject
    ClockPresenter presenter;

    @Bind(R.id.calendarView)
    CalendarView materialCalendarView;

    String date;

    private SharedPrefManager pref;

    public static TimesheetFragment newInstance(Bundle bundle) {

        TimesheetFragment fragment = new TimesheetFragment();
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

        View view = inflater.inflate(R.layout.activity_timesheet, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();




        materialCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                String date =  i2 + "-" + (i1 +1) + "-" + i;
                //Log.d(TAG , "onSelectedDayChange: mm/dd/yyyy:" + date);
                Intent in = new Intent(getActivity() , ApplyTimesheetActivity.class);
                in.putExtra("date", date);

                startActivity(in);
                Toast.makeText(getActivity(), date , Toast.LENGTH_SHORT).show();
                //pref.setDate(date);

            }
        });

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

