package com.example.john.thegreatbigidea;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class savedIdeas extends Activity {

    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_ideas);
        backBtn = (Button) findViewById(R.id.button);

        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(savedIdeas.this,MainMenu.class );
                startActivity(i);
                finish();
            }


            });

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new MyAdapter(this));
    }

    private class MyAdapter extends BaseAdapter
    {
        private List<Item> items = new ArrayList<Item>();
        private LayoutInflater inflater;

        public MyAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);

            IdeasDBHelper ideasDBHelper = new IdeasDBHelper(getApplicationContext());
            SQLiteDatabase db = ideasDBHelper.getReadableDatabase();

            String[] projection = {"IDEA_ID", "IDEA_NAME", "IDEA_CATEGORY", "IDEA_IMAGE", "IDEA_NOTE"};
            String sortOrder = "IDEA_ID ASC";

            Cursor c = db.query(
                   "SAVED_IDEAS",  // The table to query
                    projection,                               // The columns to return
                    null,                                // The columns for the WHERE clause
                    null,                            // The values for the WHERE clause
                    null,                                     // don't group the rows
                    null,                                     // don't filter by row groups
                    sortOrder                                 // The sort order
            );

            if (c.moveToFirst())
            {
                do {
                    Resources res = getResources();
                    items.add(new Item(c.getString(1), res.getIdentifier(c.getString(3), "drawable", "com.example.john.thegreatbigidea")));
                } while (c.moveToNext());
            }
            db.close();
            /*

            items.add(new Item("Image 1", R.drawable.a));
            items.add(new Item("Image 2", R.drawable.b));
            items.add(new Item("Image 3", R.drawable.c));
            items.add(new Item("Image 4", R.drawable.d));
            items.add(new Item("Image 5", R.drawable.e));*/
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i)
        {
            return items.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return items.get(i).drawableId;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            View v = view;
            ImageView picture;
            TextView name;

            if(v == null)
            {
                v = inflater.inflate(R.layout.gridview_item, viewGroup, false);
                v.setTag(R.id.picture, v.findViewById(R.id.picture));
                v.setTag(R.id.text, v.findViewById(R.id.text));
            }

            picture = (ImageView)v.getTag(R.id.picture);
            name = (TextView)v.getTag(R.id.text);

            Item item = (Item)getItem(i);

            picture.setImageResource(item.drawableId);
            name.setText(item.name);

            return v;
        }

        private class Item
        {
            final String name;
            final int drawableId;

            Item(String name, int drawableId)
            {
                this.name = name;
                this.drawableId = drawableId;
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_saved_ideas, menu);
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
