package com.intranet.app.ui.Activity.LMS;

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
import com.intranet.app.ui.Model.Receive.Data;
import com.intranet.app.ui.Model.Receive.LeaveCalendarReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
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
 * This class allow user to log in the app
 */
public class PopLeaveCalendarFragment extends BaseFragment  {


    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

    @Bind(R.id.btn_close)
    Button close;

    ArrayList<Data> Dataleaveapp = new ArrayList<>();

    ArrayList<LeaveCalendarReceive> LeaveCalendar = new ArrayList<>();


    LeaveCalendarAdapter adapter;

    @Bind(R.id.listview_leavecalendar)
    ListView listView;

    private SharedPrefManager pref;

    public static PopLeaveCalendarFragment newInstance(Bundle bundle) {

        PopLeaveCalendarFragment fragment = new PopLeaveCalendarFragment();
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

        View view = inflater.inflate(R.layout.activity_popleavecalendar, container, false);
        ButterKnife.bind(this, view);

        pref = new SharedPrefManager(getActivity());

        Bundle bundle = getArguments();
        Bundle bundleObject = getActivity().getIntent().getExtras();

        HashMap<String, String> datefrom = pref.getDateFrom();
        final String datefrom1 = datefrom.get(SharedPrefManager.DATEFROM);

        Gson gson = new Gson();
        LeaveCalendarReceive obj = gson.fromJson(datefrom1 , LeaveCalendarReceive.class);


        if(obj.getStatus().equals("True")) {
            for (int v = 0; v < obj.getData().size(); v++) {

                Data data = new Data();
                data.setDate(obj.getData().get(v).getDate());
                data.setType(obj.getData().get(v).getType());
                data.setType(obj.getData().get(v).getLeaveType());
                data.setType(obj.getData().get(v).getDayType());
                data.setName(obj.getData().get(v).getName());
                data.setHoliday(obj.getData().get(v).getHoliday());
                data.setReliefStaff(obj.getData().get(v).getReliefStaff());
                data.setStatus(obj.getData().get(v).getStatus());
//                Log.e("DayType" , obj.getData().get(v).getDayType());

                Dataleaveapp.add(data);

                adapter = new LeaveCalendarAdapter(getActivity(), obj);

                listView.setAdapter(adapter);


            }
            }
//            else if (obj.getStatus().equals("Truee")){
//
//            LeaveCalendarReceive data = new LeaveCalendarReceive();
//            data.setHoliday(obj.getHoliday());
//            LeaveCalendar.add(data);
//            adapter =  new LeaveCalendarAdapter(getActivity(), obj);
//            listView.setAdapter(adapter);
//            Log.e("holiday" , "holiday");
//
//
//        }
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
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
                if (result.get(0).getCachedAPI().equals("UserLogin")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());
                    LoginReceive obj = gson.fromJson(result.get(0).getCachedResult(), LoginReceive.class);

                }   else if (result.get(0).getCachedAPI().equals("GetAllData")) {
                    Log.e("CachedData", result.get(0).getCachedResult().toString());


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
