package io.github.janbarari.genericrecyclerviewsample.viewholder

import android.view.View
import io.github.janbarari.genericrecyclerview.listener.GenericUriListener
import io.github.janbarari.genericrecyclerview.model.GenericViewModel
import io.github.janbarari.genericrecyclerview.viewholder.GenericViewHolder
import io.github.janbarari.genericrecyclerviewsample.viewmodel.TextViewModel

class TextViewHolder(private val itemView: View, private val listener: GenericUriListener): GenericViewHolder(itemView, listener) {

    override fun bind(dataModel: GenericViewModel) {
        val data: TextViewModel = dataModel as TextViewModel
        //..
    }
}