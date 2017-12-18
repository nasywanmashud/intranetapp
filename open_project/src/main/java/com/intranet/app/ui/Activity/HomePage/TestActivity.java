package com.intranet.app.ui.Activity.HomePage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.ScrollView;

import com.intranet.app.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ListView scrollable_contents = (ListView) findViewById(R.id.scrollablecontents);
        getLayoutInflater().inflate(R.layout.content,scrollable_contents);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
}
