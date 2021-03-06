package io.github.janbarari.genericrecyclerviewsample.viewholder

import android.view.View
import io.github.janbarari.genericrecyclerview.listener.GenericUriListener
import io.github.janbarari.genericrecyclerview.model.GenericViewModel
import io.github.janbarari.genericrecyclerview.viewholder.GenericViewHolder
import io.github.janbarari.genericrecyclerviewsample.viewmodel.ImageViewModel

class ImageViewHolder(private val itemView: View, private val listener: GenericUriListener): GenericViewHolder(itemView, listener) {

    override fun bind(dataModel: GenericViewModel) {
        val data: ImageViewModel = dataModel as ImageViewModel
        //for invoke event use the listener
        //listener.onClick(Any?)
    }
}