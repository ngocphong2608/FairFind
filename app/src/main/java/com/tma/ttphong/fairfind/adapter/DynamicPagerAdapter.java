package com.tma.ttphong.fairfind.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by ttphong on 9/1/2016.
 */
public class DynamicPagerAdapter
        extends android.support.v4.app.FragmentPagerAdapter {

    private List<Class> mFragmentTypes;
    private List<String> mPageTitles;

    public DynamicPagerAdapter(
            AppCompatActivity activity,
            List<String> pageTitles,
            List<Class> fragmentTypes) {
        super(activity.getSupportFragmentManager());
        this.mPageTitles = pageTitles;
        this.mFragmentTypes = fragmentTypes;
    }

    @Override
    public int getCount() {

        if (mFragmentTypes != null) {
            return mFragmentTypes.size();
        }

        return 0;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        android.support.v4.app.Fragment fragment = null;

        if (mFragmentTypes != null &&
                position >= 0 &&
                position < mFragmentTypes.size()) {

            Class c = mFragmentTypes.get(position);

            try {
                fragment = (Fragment)Class.forName(c.getName()).newInstance();
            }
            catch (Exception ex) {
                // TODO: log the error
            }
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        if (mPageTitles != null &&
                position >= 0 &&
                position < mPageTitles.size()) {
            return mPageTitles.get(position);
        }

        return null;
    }

    public interface OnFragmentInteraction {

    }
}
