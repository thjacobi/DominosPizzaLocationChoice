package com.ebookfrenzy.locationchoice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Ted Jacobi on 2/21/2016.
 *
 */
public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtLoca = (TextView) findViewById(R.id.txtLoca);

        Intent intent = getIntent();
        String address = intent.getStringExtra("location");

        txtLoca.setText(address);
    }
}
