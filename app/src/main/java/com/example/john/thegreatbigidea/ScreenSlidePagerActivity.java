package com.example.john.thegreatbigidea;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;


public class ScreenSlidePagerActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private int numIdeas;
    private static final int LOOPS_COUNT = 50;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    private ArrayList<Idea> ideasList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        getRandomIdeas();

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(numIdeas * getLoopCount() / 2); // set current item in the adapter to middle
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            mPager.setCurrentItem(numIdeas - 1);
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void getRandomIdeas() {
        ideasList = new ArrayList<Idea>();
        ideasList.add(new Idea("Teddy", "Everyday Things", "a"));
        ideasList.add(new Idea("Clock", "Everyday Things", "b"));
        ideasList.add(new Idea("Water", "Everyday Things", "c"));
        ideasList.add(new Idea("Sign", "Everyday Things", "d"));
        ideasList.add(new Idea("Coffee", "Everyday Things", "e"));
        ideasList.add(new Idea("Record Book", "Everyday Things", "f"));
        ideasList.add(new Idea("David", "People", "g"));
        ideasList.add(new Idea("Angeline", "People", "h"));
        ideasList.add(new Idea("Seaver", "People", "i"));
        ideasList.add(new Idea("Electric Fan", "Everyday Things", "j"));
        ideasList.add(new Idea("Jyra", "People", "k"));
        ideasList.add(new Idea("Janica", "People", "l"));
        ideasList.add(new Idea("Raisa", "People", "m"));
        ideasList.add(new Idea("Mountain Dew", "Everyday Things", "n"));
        ideasList.add(new Idea("Observe Silence", "Education", "o"));
        ideasList.add(new Idea("MS Poster", "Education", "p"));
        ideasList.add(new Idea("Gaming", "Entertainment", "q"));
        ideasList.add(new Idea("Playing CS", "Entertainment", "r"));
        ideasList.add(new Idea("More Games", "Entertainment", "s"));
        ideasList.add(new Idea("Bag", "Everyday Things", "t"));
        ideasList.add(new Idea("Bachini", "People", "u"));
        ideasList.add(new Idea("Computers", "Education", "v"));
        ideasList.add(new Idea("Microsoft Inno Center", "Education", "w"));
        ideasList.add(new Idea("Pizza", "Everyday Things", "x"));
        ideasList.add(new Idea("Seaver Again", "People", "y"));
        ideasList.add(new Idea("Hazel", "People", "z"));
        ideasList.add(new Idea("Alron", "Alron Senpai", "a1"));

        numIdeas = 27;
        long seed = System.nanoTime();
        Collections.shuffle(ideasList, new Random(seed));
        filterIdeas();
        if (numIdeas == 0)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Images to Display");
            builder.setMessage("There are no images to display. Add categories or check your network connection.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent i = new Intent(ScreenSlidePagerActivity.this, MainMenu.class);
                    startActivity(i);
                    finish();
                }
            });
            builder.show();

        }
    }

    public void filterIdeas() {
        SharedPreferences settings = getSharedPreferences("Preferences", 0);
        boolean setting;
        if (!settings.getBoolean("peopleFilter", true))
            removeIdeas("People");
        if (!settings.getBoolean("everydayFilter", true))
            removeIdeas("Everyday Things");
        if (!settings.getBoolean("entertainmentFilter", true))
            removeIdeas("Entertainment");
        if (!settings.getBoolean("educationFilter", true))
            removeIdeas("Education");
        if (!settings.getBoolean("alronFilter", true))
            removeIdeas("Alron Senpai");
    }

    public int getLoopCount()
    {
        return LOOPS_COUNT;
    }

    public void removeIdeas(String category){
        Iterator<Idea> itr = ideasList.iterator();
        while (itr.hasNext()) {
            Idea id = itr.next();
            if (id.getCategory().equals(category)) {
                itr.remove();
                numIdeas--;
            }
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if (ideasList != null && ideasList.size() > 0)
            {
                position = position % ideasList.size(); // use modulo for infinite cycling
                Bundle b1 = new Bundle();
                b1.putString("name", ideasList.get(position).getName());
                b1.putString("category", ideasList.get(position).getCategory());
                b1.putString("image", ideasList.get(position).getImage());
                ScreenSlidePageFragment frag = new ScreenSlidePageFragment();
                frag.setArguments(b1);
                return frag;
            }
            else
            {
                return null;
            }
        }

        @Override
        public int getCount() {

            if (ideasList != null && ideasList.size() > 0)
            {
                return ideasList.size()*LOOPS_COUNT; // simulate infinite by big number of products
            }
            else
            {
                return 1;
            }
        }

    }
}
