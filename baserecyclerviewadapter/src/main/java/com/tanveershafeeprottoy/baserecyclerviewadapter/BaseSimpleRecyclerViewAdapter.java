package com.tanveershafeeprottoy.baserecyclerviewadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Tanveer Shafee Prottoy
 */
public class BaseSimpleRecyclerViewAdapter<T>
    extends RecyclerView.Adapter<BaseRecyclerViewHolder<T>> {
    private int resourceId;
    private int variableId;
    private ListItemOnClickListener listItemOnClickListener;
    @Nullable private List<T> objList;

    public BaseSimpleRecyclerViewAdapter(
        int resourceId,
        int variableId,
        ListItemOnClickListener listItemOnClickListener
    ) {
        this.resourceId = resourceId;
        this.variableId = variableId;
        this.listItemOnClickListener = listItemOnClickListener;
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
        if(objList != null) {
            holder.bind(objList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return objList != null ? objList.size() : 0;
    }

    @Nullable
    public List<T> getData() {
        return objList;
    }

    public void submitList(@Nullable List<T> objList) {
        this.objList = objList;
        notifyDataSetChanged();
    }
}
