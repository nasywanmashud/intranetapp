package com.intranet.app.ui.Activity.HomePage;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarAdapter;
import com.intranet.app.ui.Model.Receive.AttendanceHistoryReceive;
import com.intranet.app.ui.Model.Receive.ClockReceive;
import com.intranet.app.ui.Model.Receive.Data;
import com.intranet.app.ui.Model.Receive.History;
import com.intranet.app.ui.Model.Receive.LeaveCalendarReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Request.AttendanceHistoryRequest;
import com.intranet.app.ui.Model.Request.ClockRequest;
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
public class StaffAttendanceFragment extends BaseFragment  {



    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

    @Bind(R.id.Date)
    TextView txtDate;

    @Bind(R.id.clockIn)
    TextView txtClock_in1;

    @Bind(R.id.clockOut)
    TextView txtClock_out1;

    @Bind(R.id.clockIn2)
    TextView txtClock_in2;

    @Bind(R.id.clockOut2)
    TextView txtClock_out2;

//    @Bind(R.id.totalHours)
//    TextView txtTotal_hours;

    @Bind(R.id.Name)
    TextView txtName;

    @Bind(R.id.date1)
    TextView txtd;

    @Bind(R.id.ci1)
    TextView txtc1;

    @Bind(R.id.co1)
    TextView txtco1;

    @Bind(R.id.ci2)
    TextView txtci2;

    @Bind(R.id.co2)
    TextView txtco2;

//    @Bind(R.id.th)
//    TextView txtth;

    @Bind(R.id.fn1)
    TextView txtfullname ;

    @Bind(R.id.btnAttendance)
    Button btnAttendance;

    @Bind(R.id.attendance)
    TextView attendance;


    Dialog dialog;

    private SharedPrefManager pref;

    public static StaffAttendanceFragment newInstance(Bundle bundle) {

        StaffAttendanceFragment fragment = new StaffAttendanceFragment();
       // Bundle args = new Bundle();
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

        View view = inflater.inflate(R.layout.activity_staff_attandance, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        setDialog();

        pref = new SharedPrefManager(getActivity());

        HashMap<String, String> username = pref.getUsername();
        final String name = username.get(SharedPrefManager.USERNAME);
        staffattandancerequest(name);

        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendancehistory(name);
            }
        });


        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attendancehistory(name);
            }
        });

        return view;

    }

    public void setDialog() {
        dialog = new Dialog(getActivity(), R.style.MaterialDialogSheet);
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);
    }

    public void attendancehistory(String username) {

        //request api
        initiateLoading(getActivity());
        AttendanceHistoryRequest lcalendarData = new AttendanceHistoryRequest();
        lcalendarData.setUsername(username);
        presenter.onAttendanceHistory(lcalendarData);

    }

    @Subscribe
    public void onLeaveCalendarSuccess(AttendanceHistoryReceive obj) {

        dismissLoading();
        if (obj.getStatus().equals("Successful")) {

            showBottomFlipper(obj);

        } else {
        }

    }
    public void showBottomFlipper(AttendanceHistoryReceive obj) {

        LayoutInflater li = LayoutInflater.from(getActivity());
        View myView = li.inflate(R.layout.pop_staff_attandance, null);

        dialog.setContentView(myView);
        //dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#40000000")));
        //append view for added baggage ssr
        appendView(myView, obj);

        dialog.setCancelable(true);
        dialog.getWindow().setGravity(Gravity.CENTER);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(lp);
        dialog.show();

    }

    public void appendView(View view ,AttendanceHistoryReceive obj) {

        AttandanceHistoryAdapter adapter;
        ArrayList<History> history = new ArrayList<>();

        ListView listView = (ListView) view.findViewById(R.id.list);


        TextView txtName = (TextView) view.findViewById(R.id.Name);

        txtName.setText(obj.getName());

        //TextView txtmyattendance = (TextView) view.findViewById(R.id.myattendance);

        for (int v = 0; v < obj.getHistory().size(); v++) {

            History data = new History();
            data.setDate(obj.getHistory().get(v).getDate());
            data.setClockIn1(obj.getHistory().get(v).getClockIn1());
            data.setClockIn2(obj.getHistory().get(v).getClockIn2());
            data.setClockOut1(obj.getHistory().get(v).getClockOut1());
            data.setClockOut2(obj.getHistory().get(v).getClockOut2());
            data.setTotalHours(obj.getHistory().get(v).getTotalHours());
            history.add(data);

            adapter = new AttandanceHistoryAdapter(getActivity(), obj);

            listView.setAdapter(adapter);


        }
        Button btnClose = (Button) view.findViewById(R.id.btn_close);



        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


    public void staffattandancerequest(String username) {

        //request api
        initiateLoading(getActivity());
        ClockRequest newsData = new ClockRequest();
        newsData.setUsername(username);

        presenter.onClock(newsData);

    }

    @Subscribe
    public void staffattandancesuccess(final ClockReceive obj) {
        dismissLoading();
        // Log.e("size" , "___" + obj.getDetails().size());

        if (obj.getStatus().equals("Successful") ) {

//            if(obj.getName().equals("-")){
//                txtName.setVisibility(View.GONE);
//                txtfullname.setVisibility(View.GONE);
//
//            } else if (obj.getClockIn().equals("-")){
//                txtClock_in1.setVisibility(View.GONE);
//                txtc1.setVisibility(View.GONE);
//
//            } else if (obj.getClockOut().equals("-")){
//                txtClock_out1.setVisibility(View.GONE);
//                txtco1.setVisibility(View.GONE);
//
//            } else if (obj.getClockIn2().equals("-")){
//                txtci2.setVisibility(View.GONE);
//                txtClock_in2.setVisibility(View.GONE);
//
//            } else if (obj.getClockOut2().equals("-")){
//                txtClock_out2.setVisibility(View.GONE);
//                txtco2.setVisibility(View.GONE);
//
//            }



            txtName.setText(obj.getName());
            txtDate.setText(obj.getDate());
            txtClock_in1.setText(obj.getClockIn());
            txtClock_out1.setText(obj.getClockOut());
            txtClock_in2.setText(obj.getClockIn2());
            txtClock_out2.setText(obj.getClockOut2());
            //txtTotal_hours.setText(obj.getTotalHours());


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
