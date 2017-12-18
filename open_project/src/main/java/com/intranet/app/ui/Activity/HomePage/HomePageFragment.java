package com.intranet.app.ui.Activity.HomePage;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.application.MainApplication;
import com.intranet.app.base.BaseFragment;
import com.intranet.app.ui.Activity.Pop.PopActivity;
import com.intranet.app.ui.Model.Receive.ClockReceive;

import com.intranet.app.ui.Model.Receive.Details;
import com.intranet.app.ui.Model.Receive.NewsReceive;
import com.intranet.app.ui.Model.Request.ClockRequest;
import com.intranet.app.ui.Model.Request.NewsRequest;
import com.intranet.app.ui.Presenter.ClockPresenter;
import com.intranet.app.ui.Realm.Cached.CachedResult;
import com.intranet.app.ui.Realm.RealmObjectController;
import com.intranet.app.utils.ExpandAbleGridView;
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
public class HomePageFragment extends BaseFragment  {

    @Bind(R.id.btnAttendance)
    Button btnAttendance;

    @Inject
    ClockPresenter presenter;

    @Inject
    Bus bus;

//    @Bind(R.id.imageView)
//    ImageView imgprofilepicture;
//
//    @Bind(R.id.Username)
//    TextView txtusername;

    ArrayList<Details> news = new ArrayList<>();

     NewsListAdapter adapter;

    @Bind(R.id.listview_news)
    ListView lvNews;

    Dialog dialog;

//    @Bind(R.id.img)
//    ImageView img;

    private SharedPrefManager pref;

    public static HomePageFragment newInstance(Bundle bundle) {

        HomePageFragment fragment = new HomePageFragment();
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

        View view = inflater.inflate(R.layout.activity_home_page, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        setDialog();

        //String username1 = bundle.getString("username");
        //String image1 = bundle.getString("image");
        //txtusername.setText(username1);
        newsfromfragment();

        pref = new SharedPrefManager(getActivity());

//        HashMap<String, String> image = pref.getImage();
//        final String img = image.get(SharedPrefManager.IMAGE);

        //Glide.with(this).load("https://intranet.me-tech.com.my/thumb/thumb.php?src=/userphoto/751_IMG_mvlta3.jpg").into(imgprofilepicture);
//        Glide.with(this).load("https://intranet.me-tech.com.my/thumb/thumb.php?src=/userphoto/751_IMG_mvlta3.jpg" + img).into(imgprofilepicture);
        //Glide.with(this).load("https://intranet.me-tech.com.my" + img).into(imgprofilepicture);


        HashMap<String, String> username = pref.getUsername();
         final String  name = username.get(SharedPrefManager.USERNAME);

        //txtusername.setText(name);

        btnAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clockfromfragment(name);
            }
        });
//
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            Intent intent = new Intent(getActivity(),TestActivity.class);
//            startActivity(intent);}
//        });


        return view;
    }


    public void setDialog() {
        dialog = new Dialog(getActivity(), R.style.MaterialDialogSheet);
        dialog.requestWindowFeature(Window.FEATURE_ACTION_BAR);
    }

    public void clockfromfragment(String username) {

        //request api
        initiateLoading(getActivity());
        ClockRequest clockData = new ClockRequest();
        clockData.setUsername(username);

        presenter.onClock(clockData);

    }

    @Subscribe
    public void onClockSuccess(ClockReceive obj) {
        dismissLoading();

        if (obj.getStatus().equals("Successful") ) {

//            date = obj.getDate();
//            clock_in1 = obj.getClockIn();
//            clock_out1 = obj.getClockOut();
//            clock_in2 = obj.getClockIn2();
//            clock_out2 = obj.getClockOut2();
//            total_hours = obj.getTotalHours();
//            names = obj.getName();
            showBottomFlipper(obj);
        }

    }

    public void showBottomFlipper(ClockReceive obj) {

        LayoutInflater li = LayoutInflater.from(getActivity());
        View myView = li.inflate(R.layout.namelist_profile_popup, null);

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

    public void appendView(View view ,ClockReceive obj) {


        TextView txtDate = (TextView) view.findViewById(R.id.Date);
        TextView txtClock_in1 = (TextView) view.findViewById(R.id.clockIn);
        TextView txtClock_out1 = (TextView) view.findViewById(R.id.clockOut);
        TextView txtClock_in2 = (TextView) view.findViewById(R.id.clockIn2);
        TextView txtClock_out2 = (TextView) view.findViewById(R.id.clockOut2);
        TextView txtTotal_hours = (TextView) view.findViewById(R.id.totalHours);
        TextView txtName = (TextView) view.findViewById(R.id.Name);
        Button btnClose = (Button) view.findViewById(R.id.btnClose);

        txtName.setText(obj.getName());
        txtDate.setText(obj.getDate());
        txtClock_in1.setText(obj.getClockIn());
        txtClock_out1.setText(obj.getClockOut());
        txtClock_in2.setText(obj.getClockIn2());
        txtClock_out2.setText(obj.getClockOut2());
        txtTotal_hours.setText(obj.getTotalHours());

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            dialog.dismiss();
            }
        });
    }



    public void newsfromfragment() {

        //request api
        initiateLoading(getActivity());
        NewsRequest newsData = new NewsRequest();
        presenter.onNews(newsData);

    }

    @Subscribe
    public void onNewsSuccess(final NewsReceive obj) {
        dismissLoading();
       // Log.e("size" , "___" + obj.getDetails().size());

        if (obj.getStatus().equals("True") ) {

            for (int v = 0 ; v < obj.getDetails().size(); v++) {

                //Log.e("jayee", obj.getDetails().get(v).getTitle());

                Details detail = new Details();
                detail.setTitle(obj.getDetails().get(v).getTitle());
                detail.setAbstract(obj.getDetails().get(v).getAbstract());
                detail.setContentRefId(obj.getDetails().get(v).getContentRefId());
                news.add(detail);


                adapter = new NewsListAdapter(getActivity(), obj);

                lvNews.setAdapter(adapter);

                lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                        pref.setContentrefid(obj.getDetails().get(position).getContentRefId());
                        Intent in = new Intent(getActivity(), DataNewsActivity.class);

                        startActivity(in);

                    }
                });
            }
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
