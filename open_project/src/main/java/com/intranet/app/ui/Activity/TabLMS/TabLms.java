package com.intranet.app.ui.Activity.TabLMS;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intranet.app.MainFragmentActivity;
import com.intranet.app.R;
import com.intranet.app.ui.Activity.LMS.LeaveApprovalFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment;
import com.intranet.app.ui.Activity.LMS.LeaveCalendarFragment2;
import com.intranet.app.ui.Activity.LMS.MyLeave.MyLeaveFragment;
import com.intranet.app.ui.Activity.NavTest.Main3Activity;
import com.intranet.app.utils.SharedPrefManager;

import java.util.HashMap;

public class TabLms extends MainFragmentActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private SharedPrefManager pref;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTab);
        toolbar.setTitle("Leave Management System ");
        toolbar.setTitleTextColor(Color.parseColor("#FBFCFC"));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(TabLms.this,Main3Activity.class);
                startActivity(in);
                finish();

            }
        });

        


        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        View root = tabLayout.getChildAt(0);
        if (root instanceof LinearLayout) {
            ((LinearLayout) root).setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setColor(getResources().getColor(R.color.calendar_header));
            drawable.setSize(2, 1);
            ((LinearLayout) root).setDividerPadding(10);
            ((LinearLayout) root).setDividerDrawable(drawable);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            pref = new SharedPrefManager(TabLms.this);
            HashMap<String, String> stafflevel = pref.getStaffLevel();
            final String  sl = stafflevel.get(SharedPrefManager.STAFFLEVEL);

            if(sl.equals("1") || sl.equals("2") || sl.equals("3")){

                switch (position) {



                    case 0:
                        LeaveCalendarFragment2 leaveCalendarFragment2 = new LeaveCalendarFragment2();
                        return leaveCalendarFragment2;

                    case 1:
                        MyLeaveFragment myLeaveFragment = new MyLeaveFragment();
                        return myLeaveFragment;
                    case 2:

                        LeaveApprovalFragment leaveApprovalFragment = new LeaveApprovalFragment();
                        return leaveApprovalFragment;
                }


                }

                else {

                    switch (position){



                        case 0:
                            LeaveCalendarFragment2 leaveCalendarFragment = new LeaveCalendarFragment2();
                            return leaveCalendarFragment;
                        case 1:
                            MyLeaveFragment myLeaveFragment= new MyLeaveFragment();
                            return myLeaveFragment;
                    }
            }

            return  null;
        }

        @Override
        public int getCount() {

            pref = new SharedPrefManager(TabLms.this);
            HashMap<String, String> stafflevel = pref.getStaffLevel();
            final String  sl = stafflevel.get(SharedPrefManager.STAFFLEVEL);
            // Show 3 total pages.
            if(sl.equals("1") || sl.equals("2") || sl.equals("3")){
                return 3;
            }

            else{
                return 2;
            }

        }

        @Override
        public CharSequence getPageTitle(int position) {

            pref = new SharedPrefManager(TabLms.this);
            HashMap<String, String> stafflevel = pref.getStaffLevel();
            final String  sl = stafflevel.get(SharedPrefManager.STAFFLEVEL);

            if(sl.equals("1") || sl.equals("2") || sl.equals("3")){

                switch (position) {
                    case 0:
                        return "Leave Calendar";
                    case 1:
                        return "My Leave";
                    case 2:
                        return "Leave Approval";
                }

            }

            else {

                switch (position) {
                    case 0:
                        return "Leave Calendar";
                    case 1:
                        return "My Leave";
                }
            }


            return null;
        }
    }
}
