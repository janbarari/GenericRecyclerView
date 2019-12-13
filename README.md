# GenericRecyclerView
[![](https://jitpack.io/v/janbarari/GenericRecyclerView.svg)](https://jitpack.io/#janbarari/GenericRecyclerView)

GenericRecyclerView is a smart light-weight recyclerview and adapter to simplify working with multiple view's in list and load more feature

  - Lazy load feature
  - multiple viewholder support
  - less code more flexibility

### Installation
```gradle
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

```gradle
dependencies {
    implementation 'com.github.janbarari:GenericRecyclerView:1.0.0-alpha'
}
```

### Setup
Create your viewHolders that extends GenericViewHolder
```kotlin
class ImageViewHolder(private val itemView: View,
private val listener: GenericUriListener): GenericViewHolder(itemView, listener) {
    override fun bind(dataModel: GenericViewModel) {
        val data: ImageViewModel = dataModel as ImageViewModel
        //for invoke event use the listener
        //listener.onClick(Any?)
    }
}
```

Create your viewModels that extends GenericViewModel
```kotlin
class ImageViewModel: GenericViewModel() {}
```

Create your layouts
```xml
<ImageView xmlns:android="http://schemas.android.com/apk/res/android"
   android:id="@+id/imageView"
   android:layout_width="match_parent"
   android:layout_height="250dp"
   android:background="@drawable/ic_launcher_background"/>
```

Create your data list + instance of GenericAdapter and initialize them
```kotlin
val content: ArrayList<GenericViewModel> = arrayListOf()
content.add(ImageViewModel())

val adapter = GenericAdapter(context, content, object: GenericUriListener{
    override fun onClick(event: Any) {}
})
```

Add your ViewHolder, ViewModel, LayoutId to GenericAdapter
```kotlin
adapter.addView(ImageViewHolder::class.java, ImageViewModel::class.java, R.layout.grv_image_item)
```

Set your Recyclerview adapter to GenericAdapter
```kotlin
recyclerview.adapter = adapter
```


### Also you can use GenericRecyclerView which have lazy load feature (Simplified LoadMore Function)
```kotlin
genericRecyclerView.setLoadMoreListener(object: GenericRecyclerView.GenericRecyclerViewListener {
    override fun onLoadMore() {}
})
```


### If you like it, please tap the Star(⭐️) button 


