package com.blimas.visaolista;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class ItemCallBackToMove extends ItemTouchHelper.Callback  {

    private final ItemTouchHelperInterface mAdapter;

    public ItemCallBackToMove(ItemTouchHelperInterface adapter) {
        mAdapter = adapter;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return super.isItemViewSwipeEnabled();
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN |
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        mAdapter.onItemRowMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            if (viewHolder instanceof MyAdapter.MyViewHolder) {
                MyAdapter.MyViewHolder myViewHolder=
                        (MyAdapter.MyViewHolder) viewHolder;
                mAdapter.onItemRowSelected(myViewHolder);
            }

        }

        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);

        if (viewHolder instanceof MyAdapter.MyViewHolder) {
            MyAdapter.MyViewHolder myViewHolder=
                    (MyAdapter.MyViewHolder) viewHolder;
            mAdapter.onItemRowClear(myViewHolder);
        }
    }

    public interface ItemTouchHelperInterface {

        void onItemRowMoved(int fromPosition, int toPosition);
        void onItemRowSelected(MyAdapter.MyViewHolder myViewHolder);
        void onItemRowClear(MyAdapter.MyViewHolder myViewHolder);


    }
}
