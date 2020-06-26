# base-recyclerview-adapter-library
A general purpose RecyclerView adapter library which can be used with any data model (sort of) and any item row view (with the help of DataBinding)

To add this in your library please add these code below.

project level build.gradle

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

app level build.gradle
```
implementation 'com.github.tanveerprottoy:base-recyclerview-adapter:1.1'
```

Usage

row_main_list.xml
```
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">

    <data>
        <variable
            name="rowMainListObj"
            type="com.tanveershafeeprottoy.baserecyclerviewadapter.sample.ItemModel" />
    </data>

    <TextView
        android:id="@+id/rowCategoryListTextViewTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="?attr/selectableItemBackground"
        android:padding="8dp"
        android:text="@{rowMainListObj.name}"
        android:textAppearance="@style/TextAppearance.MaterialComponents.Headline5" />
</layout>
```

MainActivity.kt
```
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
```
