package com.example.mostosapp.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.mostosapp.R;

public class NoConection {
    private Activity activity;
    private AlertDialog dialog;
    public NoConection(Activity myActivity){
        activity = myActivity;
    }

    public void StartLoading(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.no_conection, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    void CloseDialog(){
        dialog.dismiss();
    }
}