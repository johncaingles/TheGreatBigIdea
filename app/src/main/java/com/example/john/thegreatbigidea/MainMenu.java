package com.example.john.thegreatbigidea;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;


public class MainMenu extends ActionBarActivity {

    private ImageButton kickOffBtn;
    private ImageButton theoriesBtn;
    private ImageButton conceptBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        kickOffBtn = (ImageButton) findViewById(R.id.kickOffBtn);
        theoriesBtn = (ImageButton) findViewById(R.id.theoriesBtn);
        conceptBtn = (ImageButton) findViewById(R.id.conceptBtn);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        kickOffBtn.setOnClickListener (new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenu.this, ScreenSlidePagerActivity.class);
                startActivity(i);
                finish();
            }
        });

        theoriesBtn.setOnClickListener (new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenu.this, ScreenSlidePagerActivity.class);
                startActivity(i);
                finish();
            }
        });

        conceptBtn.setOnClickListener (new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainMenu.this, ScreenSlidePagerActivity.class);
                startActivity(i);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
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
