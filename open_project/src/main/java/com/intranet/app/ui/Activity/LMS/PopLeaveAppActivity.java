package com.intranet.app.ui.Activity.LMS;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;

import butterknife.ButterKnife;

/**
 * This is activity class for LoginFragment
 */
public class PopLeaveAppActivity extends MainFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, PopLeaveAppFragment.newInstance(bundle)).commit();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.11),(int)(height*11));

    }




    @Override
    public void onResume() {
        super.onResume();
    }


}
