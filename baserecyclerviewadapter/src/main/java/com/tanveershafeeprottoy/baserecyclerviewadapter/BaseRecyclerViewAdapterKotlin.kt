package com.tanveershafeeprottoy.baserecyclerviewadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView

open class BaseRecyclerViewAdapterKotlin<T : BaseItemModelKotlin>(
    private val resourceId: Int,
    private val variableId: Int,
    baseDiffUtilItemCallbackKotlin: BaseDiffUtilItemCallbackKotlin<T>,
    private val listItemOnClickListener: ListItemOnClickListener?
) : RecyclerView.Adapter<BaseRecyclerViewHolder<T>>() {
    private var asyncListDiffer: AsyncListDiffer<T> = AsyncListDiffer(this, baseDiffUtilItemCallbackKotlin)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerViewHolder<T> {
        return BaseRecyclerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                resourceId,
                parent,
                false
            ),
            variableId,
            listItemOnClickListener
        )
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder<T>, position: Int) {
        holder.bind(asyncListDiffer.currentList[position])
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    fun getData(): List<T> {
        return asyncListDiffer.currentList
    }

    fun submitList(objList: List<T>) {
        asyncListDiffer.submitList(objList)
    }
}