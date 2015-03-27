package com.example.john.thegreatbigidea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;


public class Settings extends Activity {

    private CheckBox peopleCb;
    private CheckBox everydayCb;
    private CheckBox entertainmentCb;
    private CheckBox educationCb;
    private CheckBox alronCb;
    private Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        peopleCb = (CheckBox) findViewById(R.id.peopleCb);
        everydayCb = (CheckBox) findViewById(R.id.everydayCb);
        entertainmentCb = (CheckBox) findViewById(R.id.entertainmentCb);
        educationCb = (CheckBox) findViewById(R.id.educationCb);
        alronCb = (CheckBox) findViewById(R.id.alronCb);
        backBtn = (Button) findViewById(R.id.button);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Settings.this, MainMenu.class);
                startActivity(i);
                finish();
            }
        });

        SharedPreferences settings = getSharedPreferences("Preferences", 0);
        boolean setting;

        setting = settings.getBoolean("peopleFilter", true);
        peopleCb.setChecked(setting);

        setting = settings.getBoolean("everydayFilter", true);
        everydayCb.setChecked(setting);

        setting = settings.getBoolean("entertainmentFilter", true);
        entertainmentCb.setChecked(setting);

        setting = settings.getBoolean("educationFilter", true);
        educationCb.setChecked(setting);

        setting = settings.getBoolean("alronFilter", true);
        alronCb.setChecked(setting);

        peopleCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                SharedPreferences settings = getSharedPreferences("Preferences", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("peopleFilter", isChecked);
                editor.commit();
            }
        }
        );

        everydayCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                    SharedPreferences settings = getSharedPreferences("Preferences", 0);
                                                    SharedPreferences.Editor editor = settings.edit();
                                                    editor.putBoolean("everydayFilter", isChecked);
                                                    editor.commit();
                                                }
                                            }
        );

        entertainmentCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                    SharedPreferences settings = getSharedPreferences("Preferences", 0);
                                                    SharedPreferences.Editor editor = settings.edit();
                                                    editor.putBoolean("entertainmentFilter", isChecked);
                                                    editor.commit();
                                                }
                                            }
        );

        educationCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                    SharedPreferences settings = getSharedPreferences("Preferences", 0);
                                                    SharedPreferences.Editor editor = settings.edit();
                                                    editor.putBoolean("educationFilter", isChecked);
                                                    editor.commit();
                                                }
                                            }
        );

        alronCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                    SharedPreferences settings = getSharedPreferences("Preferences", 0);
                                                    SharedPreferences.Editor editor = settings.edit();
                                                    editor.putBoolean("alronFilter", isChecked);
                                                    editor.commit();
                                                }
                                            }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
