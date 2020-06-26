package com.tanveershafeeprottoy.baserecyclerviewadapter

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtilItemCallbackKotlin<T : BaseItemModelKotlin> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.uniqueId == newItem.uniqueId
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}