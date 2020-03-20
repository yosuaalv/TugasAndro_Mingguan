package com.example.tugasmingguan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    private int tabs;

    public PageAdapter(@NonNull FragmentManager frag, int noTabs) {
        super(frag);
        this.tabs = noTabs;
    }

    public PageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return new tab1();
            case 1:
                return new tab2();
            case 2:
                return new tab3();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabs;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
