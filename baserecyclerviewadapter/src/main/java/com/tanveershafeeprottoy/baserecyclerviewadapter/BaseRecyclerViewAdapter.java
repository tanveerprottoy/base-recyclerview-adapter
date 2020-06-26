package com.tanveershafeeprottoy.baserecyclerviewadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseRecyclerViewAdapter<T extends BaseItemModel>
    extends RecyclerView.Adapter<BaseRecyclerViewHolder<T>> {
    private int resourceId;
    private int variableId;
    private ListItemOnClickListener listItemOnClickListener;
    @NonNull private AsyncListDiffer<T> asyncListDiffer;

    public BaseRecyclerViewAdapter(
        int resourceId,
        int variableId,
        BaseDiffUtilItemCallback<T> baseDiffUtilItemCallback,
        ListItemOnClickListener listItemOnClickListener
    ) {
        this.resourceId = resourceId;
        this.variableId = variableId;
        this.listItemOnClickListener = listItemOnClickListener;
        asyncListDiffer = new AsyncListDiffer<>(this, baseDiffUtilItemCallback);
    }

    @Override
    @NonNull
    public BaseRecyclerViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseRecyclerViewHolder<>(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                resourceId,
                parent,
                false
            ),
            variableId,
            listItemOnClickListener
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder<T> holder, int position) {
        holder.bind(asyncListDiffer.getCurrentList().get(position));
    }

    @Override
    public int getItemCount() {
        return asyncListDiffer.getCurrentList().size();
    }

    @NonNull
    public List<T> getData() {
        return asyncListDiffer.getCurrentList();
    }

    public void submitList(@NonNull List<T> objList) {
        asyncListDiffer.submitList(objList);
    }
}
