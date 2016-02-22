package com.ebookfrenzy.locationchoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ted Jacobi on 2/21/2016.
 * This application lists pizza location options in a spinner and displays the address in a second activity
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    Spinner spinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Spinner element
        spinner = (Spinner) findViewById(R.id.spinner_location);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.location_array, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView mytext= (TextView) view;
        String selected = parent.getItemAtPosition(position).toString();
        Double spinnerValue = Double.parseDouble(selected.replaceAll("[\\D]", ""));

        // Showing selected spinner item
        Toast.makeText(this, "You Selected " +mytext.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void sendNewActivity(View view) {
        String location = spinner.getSelectedItem().toString();
        String address = " ";

        if (location.equals("1701 Woodland Ave")) {
            address = ("STORE #1986\n1701 Woodland Ave\nDuluth, MN 55803\nPhone Number: (218) 728-3627");
        } else if (location.equals("309 E Central Entrance")) {
            address = ("STORE #1985\n309 E Central Entrance\nDuluth, MN 55811\n(218) 722-3030");
        } else if (location.equals("1204 Bellknap Street")) {
            address = ("STORE #2000\n1204 Bellknap Street\nSuperior, WI 54880\n(715) 394-7777");
        } else if (location.equals("4960 Miller Trunk Hwy")) {
            address = ("STORE #7387\n4960 Miller Trunk Hwy\nDuluth, MN 55811\n" +
                    "On the corner of Sugar Maple Crossing and Miller Trunk Hwy.\n(218) 729-7979");
        } else {
            address = ("STORE #7368\n309 N. Central Ave\nDuluth, MN 55807\n(218) 628-3030");
        }

        //Starts new Intent
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        //Sends data to another Activity
        intent.putExtra("location", address);
        startActivity(intent);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
