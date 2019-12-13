package io.github.janbarari.genericrecyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import io.github.janbarari.genericrecyclerview.listener.GenericUriListener
import io.github.janbarari.genericrecyclerview.model.GenericViewModel

open class GenericViewHolder(private val itemView: View,
                             open val uriListener: GenericUriListener) : RecyclerView.ViewHolder(itemView) {
    open fun bind(dataModel: GenericViewModel){}
}