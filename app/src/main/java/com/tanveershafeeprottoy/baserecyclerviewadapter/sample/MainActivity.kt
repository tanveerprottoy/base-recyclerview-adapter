package com.tanveershafeeprottoy.baserecyclerviewadapter.sample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.tanveershafeeprottoy.baserecyclerviewadapter.BaseDiffUtilItemCallback
import com.tanveershafeeprottoy.baserecyclerviewadapter.BaseRecyclerViewAdapter
import com.tanveershafeeprottoy.baserecyclerviewadapter.ListItemOnClickListener
import com.tanveershafeeprottoy.baserecyclerviewadapter.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
                     ListItemOnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val itemModelList = mutableListOf<ItemModel>()
        for(i in 0..29) {
            val itemModel = ItemModel(
                itemId = i.toString()
            )
            itemModel.name = i.toString()
            itemModelList.add(itemModel)
        }
        val baseRecyclerViewAdapter = BaseRecyclerViewAdapter<ItemModel>(
            R.layout.row_main_list,
            BR.rowMainListObj,
            BaseDiffUtilItemCallback(),
            this
        )
        activityMainBinding.activityMainRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = baseRecyclerViewAdapter
        }
        baseRecyclerViewAdapter.submitList(itemModelList)
    }

    override fun onItemClick(adapterPosition: Int, view: View?) {
        Toast.makeText(
            this,
            "onItemClick $adapterPosition",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onItemLongClick(adapterPosition: Int, view: View?): Boolean {
        Toast.makeText(
            this,
            "onItemLongClick $adapterPosition",
            Toast.LENGTH_SHORT
        ).show()
        return true
    }
}
