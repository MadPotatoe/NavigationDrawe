package com.ieselcaminas.carlosmonfort.cardviewproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alu53789415m on 29/11/16.
 */

public class AdaptadorViewPager extends FragmentPagerAdapter {
    final  int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Tab 1", "Tab 2","Tab 3"};

    public  AdaptadorViewPager(FragmentManager fn){
        super(fn);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch(position) {
            case 0:
                f = new Fragment1();
                break;
            case 1:
                f = new Fragment2();
                break;
            case 2:
                f = new Fragment3();
                break;
        }

        return f;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
