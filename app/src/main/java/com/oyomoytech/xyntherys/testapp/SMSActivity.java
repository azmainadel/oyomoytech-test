package com.oyomoytech.xyntherys.testapp;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ASUS on 28-Oct-16.
 */

public class SMSActivity extends MainActivity {

    Button SendButton;
    EditText SMSBody;
    EditText SMSNumber;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        SendButton = (Button) findViewById(R.id.send_button);
        SMSBody = (EditText) findViewById(R.id.sms_body);
        SMSNumber = (EditText) findViewById(R.id.sms_number);

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendSMS();
            }
        });
    }

    protected void sendSMS() {
        Log.i("Send SMS", "");

        String phoneNo = SMSNumber.getText().toString();
        String message = SMSBody.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, message, null, null);

            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

}
