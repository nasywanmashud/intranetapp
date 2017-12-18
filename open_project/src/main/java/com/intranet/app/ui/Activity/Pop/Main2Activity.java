package com.intranet.app.ui.Activity.Pop;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.intranet.app.R;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {

    TextView tv;
    Calendar mCurrentDate;
    int day , month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.date);

        mCurrentDate = Calendar.getInstance();

        day = mCurrentDate.get((Calendar.DAY_OF_MONTH));
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        month = month+1;

        tv.setText(day + "/" + month + "/" + year);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    monthOfYear = monthOfYear+1;
                        tv.setText(dayOfMonth+ "/" + monthOfYear+ "/" + year);
                    }
                } , year , month , day);
                datePickerDialog.show();
            }
        });
    }
}
