package com.intranet.app.ui.Activity.SplashScreen;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.LMS.PopLeaveAppFragment;

import butterknife.ButterKnife;

/**
 * This is activity class for LoginFragment
 */
public class SplashScreenActivity extends MainFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, SplashScreenFragment.newInstance(bundle)).commit();

    }




    @Override
    public void onResume() {
        super.onResume();
    }


}
