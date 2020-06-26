package com.tanveershafeeprottoy.baserecyclerviewadapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class BaseDiffUtilItemCallback<T extends BaseItemModel> extends DiffUtil.ItemCallback<T> {

    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.getUniqueId().equals(newItem.getUniqueId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }
}
