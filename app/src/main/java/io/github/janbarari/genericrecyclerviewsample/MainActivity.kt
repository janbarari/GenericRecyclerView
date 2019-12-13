package io.github.janbarari.genericrecyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.janbarari.genericrecyclerview.adapter.GenericAdapter
import io.github.janbarari.genericrecyclerview.listener.GenericUriListener
import io.github.janbarari.genericrecyclerview.model.GenericViewModel
import io.github.janbarari.genericrecyclerview.view.GenericRecyclerView
import io.github.janbarari.genericrecyclerviewsample.viewholder.ButtonViewHolder
import io.github.janbarari.genericrecyclerviewsample.viewholder.ImageViewHolder
import io.github.janbarari.genericrecyclerviewsample.viewholder.TextViewHolder
import io.github.janbarari.genericrecyclerviewsample.viewmodel.ButtonViewModel
import io.github.janbarari.genericrecyclerviewsample.viewmodel.ImageViewModel
import io.github.janbarari.genericrecyclerviewsample.viewmodel.TextViewModel

class MainActivity : AppCompatActivity(), GenericUriListener, GenericRecyclerView.GenericRecyclerViewListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content: ArrayList<GenericViewModel> = arrayListOf()
        content.add(TextViewModel())
        content.add(ImageViewModel())
        content.add(TextViewModel())
        content.add(TextViewModel())
        content.add(ButtonViewModel())
        content.add(TextViewModel())
        content.add(TextViewModel())

        val gra = GenericAdapter(this, content, this)
        gra.addView(TextViewHolder::class.java, TextViewModel::class.java, R.layout.grv_text_item)
        gra.addView(ImageViewHolder::class.java, ImageViewModel::class.java, R.layout.grv_image_item)
        gra.addView(ButtonViewHolder::class.java, ButtonViewModel::class.java, R.layout.grv_button_item)

        val grv: GenericRecyclerView = findViewById(R.id.grv)
        grv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        grv.adapter = gra
        grv.setLoadMoreListener(this)

    }

    override fun onClick(event: Any) {

    }

    override fun onLoadMore() {

    }
}
