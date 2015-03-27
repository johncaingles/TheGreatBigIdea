package com.example.john.thegreatbigidea;
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
        numIdeas = 10;
        long seed = System.nanoTime();
        Collections.shuffle(ideasList, new Random(seed));
        filterIdeas();
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

    public void removeIdeas(String category){
        Iterator<Idea> itr = ideasList.iterator();
        while (itr.hasNext()) {
            Idea id = itr.next();
            if (id.getCategory().equals(category))
                itr.remove();
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
            Bundle b1 = new Bundle();
            b1.putString("image", ideasList.get(position).getImage());
            ScreenSlidePageFragment frag = new ScreenSlidePageFragment();
            frag.setArguments(b1);
            return frag;
        }

        @Override
        public int getCount() {
            return numIdeas;
        }
    }
}
