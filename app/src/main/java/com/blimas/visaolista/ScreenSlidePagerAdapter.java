package com.blimas.visaolista;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {


    private Context mContext ;
    private List<Book> mFrags = new ArrayList<>();

    public ScreenSlidePagerAdapter(Context context, FragmentActivity fa, List<Book> lista) {
        super(fa);
        this.mContext = context;
        this.mFrags = lista;
    }

    @Override
    public Fragment createFragment(int position) {
        return new ScreenSlidePageFragment(mContext, mFrags);
    }

    @Override
    public int getItemCount() {
        return mFrags.size();
    }
}
