package com.example.agrosol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agrosol.utils.Constants;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity.class";

    private Button btn1;
    private EditText name;
    private EditText phNoString;
    private TextView namealert;
    private TextView phalert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });
    }
    public void phempty(int a){
        Context context = getApplicationContext();
        CharSequence string;
        if(a==1) {
            string="Name empty";
        }

        else string = "Phone number empty";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,string, duration);
        toast.show();

    }
    @SuppressLint("NewApi")
    public void openHome() {

        Intent intent1 = new Intent(this, Home.class);
        name = (EditText) findViewById(R.id.name);
        phalert = (TextView) findViewById(R.id.phalert);
        phNoString = (EditText) findViewById(R.id.text2);
        namealert = (TextView) findViewById(R.id.namealert);
        //TODO add null check and show popup to user
        String message = name.getText().toString();
        String message2 = phNoString.getText().toString();
        if (!message.isEmpty() && !message2.isEmpty() && message2.length()==10 ) {
            message2 = message2.trim();
            namealert.setText(" ");
            phalert.setText(" ");
            intent1.putExtra(Constants.extraValueName, message);
            intent1.putExtra(Constants.extraValuePhNo, message2);
            Log.i(TAG, "Starting home activity with extra values " + message + " " + message2);
            startActivity(intent1);
            finish();

        }
        else {
            if (message.isEmpty()) {

                namealert.setText("*Empty field");
                phempty(1);

            } else
                namealert.setText(" ");

        }

        if (message2.isEmpty()) {
            phalert.setText("*Empty field");
            phempty(2);
        } else {
            if (message2.length() != 10)
                phalert.setText("*Invalid number");
            else
                phalert.setText(" ");
        }
    }

    //TODO verify if the phone number entered is in India's format.
    //TODO rename your classes better
    /**
     * 1. Check if the phone number is 10 digits long.
     * 2. Add an extra textview and show +91 by default as the country code.
     */
}
