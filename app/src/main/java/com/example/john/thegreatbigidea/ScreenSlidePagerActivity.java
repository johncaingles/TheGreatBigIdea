package com.example.john.thegreatbigidea;
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
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public void getRandomIdeas() {
        ideasList = new ArrayList<Idea>();
        ideasList.add(new Idea("Teddy", "Everyday Things", "1.JPG"));
        ideasList.add(new Idea("Clock", "Everyday Things", "2.JPG"));
        ideasList.add(new Idea("Water", "Everyday Things", "3.JPG"));
        ideasList.add(new Idea("Sign", "Everyday Things", "4.JPG"));
        ideasList.add(new Idea("Coffee", "Everyday Things", "5.JPG"));
        ideasList.add(new Idea("Record Book", "Everyday Things", "6.JPG"));
        ideasList.add(new Idea("David", "Peoples", "7.JPG"));
        ideasList.add(new Idea("Angeline", "People", "8.JPG"));
        ideasList.add(new Idea("Seaver", "People", "9.JPG"));
        ideasList.add(new Idea("Electric Fan", "Everyday Things", "10.JPG"));
        numIdeas = 10;
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
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return numIdeas;
        }
    }
}
