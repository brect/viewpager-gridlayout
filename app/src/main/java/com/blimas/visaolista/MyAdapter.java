package com.blimas.visaolista;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements ItemCallBackToMove.ItemTouchHelperInterface {


    private Context mContext ;
    private List<Book> mData ;


    public MyAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_book,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onItemRowMoved(int fromPosition, int toPosition) {

        if (fromPosition == toPosition){
            return;
        }

        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mData, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mData, i, i - 1);
            }
        }

        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemRowSelected(MyViewHolder myViewHolder) {
        myViewHolder.cardView.setBackgroundColor(Color.GRAY);
    }

    @Override
    public void onItemRowClear(MyViewHolder myViewHolder) {
        myViewHolder.cardView.setBackgroundColor(Color.WHITE);
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.book_title_id) ;
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }

}
