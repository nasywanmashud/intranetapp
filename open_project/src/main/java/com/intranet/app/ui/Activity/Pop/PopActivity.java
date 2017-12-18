package com.intranet.app.ui.Activity.Pop;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;

import butterknife.ButterKnife;

/**
 * This is activity class for LoginFragment
 */
public class PopActivity extends MainFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, PopFragment.newInstance(bundle)).commit();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.11),(int)(height*.11));


        //setActionbar_normal_title("Sample App");
    }

//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.exit, menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }
//
//    // Determines if Action bar item was selected. If true then do corresponding action.
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {

        //handle presses on the action bar items
//        switch (item.getItemId()) {
//
//            case android.R.id.ex:
//               // NavUtils.navigateUpFromSameTask(this);
//                Intent in = new Intent(PopActivity.this , HomePageFragment.class);
//                startActivity(in);
//                return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//


    @Override
    public void onResume() {
        super.onResume();
    }


    //@Override
    //public int getFragmentContainerId() {
    //return R.id.main_activity_fragment_container;
    //}
}
