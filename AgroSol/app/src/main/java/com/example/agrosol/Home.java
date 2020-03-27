package com.example.agrosol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.agrosol.utils.Constants.extraValueName;
import static com.example.agrosol.utils.Constants.extraValuePhNo;

public class Home extends AppCompatActivity {
    public static final String TAG = "Home.class";
    //TODO name all these variables properly. ie, Button continueButton. Textview userName etc.
    private Button button2;
    private TextView txt;
    private TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_home);

            Intent intent2 = getIntent();
            //Avoid hard coding values. Create a separate class for strings
            String userName = intent2.getStringExtra(extraValueName);
            String phoneNumber = intent2.getStringExtra(extraValuePhNo);
            Log.i(TAG, "Received values from the intent : " + userName + " " +
                    phoneNumber);

            //Give meaningful names to your view elements so you don't get confused when writing more
            //code.
            txt = (TextView) findViewById(R.id.name);
            txt.setText(userName);
            String phoneNo = phoneNumber;
            txt2 = (TextView) findViewById(R.id.phone);
            txt2.setText(phoneNo);

            button2 = (Button) findViewById(R.id.backButton);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goback();
                }
            });
        } catch(Exception ex) {
            Log.wtf(TAG, "Exception caught ", ex);
        }
    }
    public void goback()
    {
        Log.i(TAG, "Moving to the previous class");
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
        finish();
    }
}
