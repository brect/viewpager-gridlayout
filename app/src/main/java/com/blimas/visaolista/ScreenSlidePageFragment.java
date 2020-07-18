package com.blimas.visaolista;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends Fragment {

    private List<Book>mFrags = new ArrayList<>();
    private Context mContext ;

    public ScreenSlidePageFragment(Context context, List<Book> mFrags) {
        this.mContext = context;
        this.mFrags = mFrags;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        MyAdapter adapter = new MyAdapter(mContext, mFrags);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(mContext,1));

        return view;

    }

}
