package com.intranet.app.ui.Activity.LMS;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.intranet.app.R;

/**
 * Created by Me-Tech on 10/16/2017.
 */

public class MyDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_popleaveapp , null);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("TAG" , "You click the dialog button");
            }
        };

        return  new AlertDialog.Builder(getActivity())
                .setTitle("Error")
                .setView(view)
                .setPositiveButton(android.R.string.ok ,listener)
                .create();
    }
}
