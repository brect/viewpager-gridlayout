package com.blimas.visaolista;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePageFragment extends Fragment  {

    private List<Book>mFrags = new ArrayList<>();
    private Context mContext ;
    private ItemTouchHelper touchHelper;
    private  Integer qtdColunas;

    public ScreenSlidePageFragment(Context context, List<Book> mFrags, int qtdColunas) {
        this.mContext = context;
        this.mFrags = mFrags;
        this.qtdColunas = qtdColunas;
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

        ItemTouchHelper.Callback callback =
                new ItemCallBackToMove(adapter);
        touchHelper  = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new GridLayoutManager(mContext,this.qtdColunas));

        return view;

    }

}
