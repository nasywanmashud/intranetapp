package com.intranet.app.ui.Activity.LMS;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.TabLMS.TabLms;
import com.intranet.app.ui.Model.Receive.Data;
import com.intranet.app.ui.Model.Receive.LeaveCalendarReceive;
import com.intranet.app.ui.Model.Receive.LoginReceive;
import com.intranet.app.ui.Model.Request.LeaveCalendarRequest;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.SharedPrefManager;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * This class allow user to log in the app
 */
public class LeaveCalendarFragment2 extends BaseFragment {

    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

    LeaveCalendarAdapter adapter;
    ArrayList<Data> Dataleaveapp = new ArrayList<>();

    @Bind(R.id.list)
    ListView listView;

//    @Bind(R.id.list)
//    ScrollView listView;

    @Bind(R.id.staffonleave)
    TextView txtstaff;

    Calendar mCurrentDate ;

    @Bind(R.id.calendarView)
    CalendarView materialCalendarView;

    String myDate = "2014/10/29 18:10:45";
    //creates a formatter that parses the date in the given format
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    int day , month , year ;

    @Bind(R.id.test)
    Button btn;

    @Bind(R.id.legend)
    Button btnlegen;


    String date, a;
    long b;
    String m, n,t;
    //private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("YYYY MM dd", Locale.getDefault());
    Dialog dialog;

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    private SharedPrefManager pref;

    public static LeaveCalendarFragment2 newInstance(Bundle bundle) {

        LeaveCalendarFragment2 fragment = new LeaveCalendarFragment2();
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

        View view = inflater.inflate(R.layout.activity_leave_calendar, container, false);
        ButterKnife.bind(this, view);

        pref = new SharedPrefManager(getActivity());
        Bundle bundle = getArguments();
        txtstaff.setVisibility(View.GONE);
        listView.setVisibility(View.GONE);
        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        t = year + "-" + (month + 1) + "-" + day;
        Log.e("aaaa", t);
        setDialog();

        SimpleDateFormat currentDate = new SimpleDateFormat("yyyy-MM-dd");
//        Date todayDate = new Date();
//        String thisDate = currentDate.format(todayDate);
//        Log.e("datedate" , thisDate);
        leavecalendarfromfragment(t);

        materialCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

                String hull = "";
                //n = i1;


//                if (i1 >8) {
//                    a.equals();
//                }
//                else {
//                    m = 0;
//                }
                //   String dates =    i +  m  +(i1 +1) + "-" + i2;


                if (i1 < 9) {

                    m = "0";

                } else {
                    m = hull;
                }

                if (i2 < 9) {

                    n = "0";

                } else {
                    n = hull;
                }
                String dates = i + "-" + m + (i1 + 1) + "-" + n + i2;

                //String dates =    i + "-"  + (i1 +1) + "-" + i2;

                //Log.d(TAG , "onSelectedDayChange: mm/dd/yyyy:" + date);
                date = dates;
//                Log.e("111111",dates);
                leavecalendarfromfragment(date);
                //  Toast.makeText(getActivity(), date, Toast.LENGTH_SHORT).show();
                //pref.setDate(date);


            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TabLms.class);
                startActivity(intent);
            }
        });

        btnlegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showBottomFlipper();
            }
        });

        return view;
    }

        public void setDialog() {
            dialog = new Dialog(getActivity(), R.style.MaterialDialogSheet);
            dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);
        }

        public void showBottomFlipper() {

            LayoutInflater li = LayoutInflater.from(getActivity());
            View myView = li.inflate(R.layout.legend_popup, null);

            dialog.setContentView(myView);
            //dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#40000000")));
            //append view for added baggage ssr
            appendView(myView);

            dialog.setCancelable(true);
            dialog.getWindow().setGravity(Gravity.CENTER);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(dialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.gravity = Gravity.CENTER;
            dialog.getWindow().setAttributes(lp);
            dialog.show();

        }

        public void appendView(View view ) {

            Button btnClose = (Button) view.findViewById(R.id.btnClose);
            btnClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }



    public void leavecalendarfromfragment(String date) {


        //request api
        initiateLoading(getActivity());
        LeaveCalendarRequest lcalendarData = new LeaveCalendarRequest();
        lcalendarData.setDateFrom(date);
        presenter.onLeaveCalendar(lcalendarData);

    }

    @Subscribe
    public void onLeaveCalendarSuccess(LeaveCalendarReceive obj) {
        dismissLoading();
        listView.setVisibility(View.VISIBLE);
        txtstaff.setVisibility(View.GONE);

        if (obj.getStatus().equals("True")) {
            txtstaff.setVisibility(View.VISIBLE);

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

                Dataleaveapp.add(data);
                adapter = new LeaveCalendarAdapter(getActivity(), obj);
                listView.setAdapter (adapter);

            }
        }
        else if (obj.getStatus().equals("False")) {
            listView.setVisibility(View.GONE);
            txtstaff.setVisibility(View.GONE);

            Toast.makeText(getActivity(), "No Staff On Leave Today" , Toast.LENGTH_SHORT).show();

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
