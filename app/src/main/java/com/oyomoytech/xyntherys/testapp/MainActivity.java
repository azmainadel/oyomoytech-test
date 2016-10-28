package com.oyomoytech.xyntherys.testapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button CallButton;
    Button SMSButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallButton = (Button) findViewById(R.id.call_button);
        SMSButton = (Button) findViewById(R.id.sms_button);

        //Call Button
        CallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }

        });


        //SMS Button
        SMSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms = new Intent(v.getContext(), SMSActivity.class);
                startActivityForResult(sms, 0);

            }
        });

    }

    protected void makeCall(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to call Ajoy Das?");

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01521487525"));
                try {
                    startActivity(call);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "Call Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"So you don't want to call him...",Toast.LENGTH_LONG).show();
            }

        });


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();


    }

 }


