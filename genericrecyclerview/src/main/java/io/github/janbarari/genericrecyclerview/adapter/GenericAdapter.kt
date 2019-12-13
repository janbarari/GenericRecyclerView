package io.github.janbarari.genericrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.janbarari.genericrecyclerview.listener.GenericUriListener
import io.github.janbarari.genericrecyclerview.model.GenericItemModel
import io.github.janbarari.genericrecyclerview.model.GenericViewModel
import io.github.janbarari.genericrecyclerview.viewholder.GenericViewHolder

open class GenericAdapter(private val context: Context,
                          private val contentList: ArrayList<GenericViewModel>,
                          private val uriListener: GenericUriListener) : RecyclerView.Adapter<GenericViewHolder>() {

    var genericItems: ArrayList<GenericItemModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        var viewHolder: Any? = null
        for (itemModel: GenericItemModel in genericItems) {
            if (itemModel.viewTypeId == viewType) {
                viewHolder = itemModel.viewHolderClass.getConstructor(View::class.java, GenericUriListener::class.java)
                    .newInstance(LayoutInflater.from(this.context).inflate(itemModel.layoutId, parent, false), uriListener)
            }
        }
        return (viewHolder as GenericViewHolder?)!!
    }

    override fun getItemViewType(position: Int): Int {
        for (itemModel: GenericItemModel in genericItems) {
            if (contentList[position]::class.java == itemModel.viewModelClass) {
                return itemModel.viewTypeId
            }
        }
        return -1
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        holder.bind(contentList[position])
    }

    fun addView(viewHolderClass: Class<out GenericViewHolder>, viewModelClass: Class<out GenericViewModel>, layoutId: Int) {
        val viewTypeId = genericItems.size
        genericItems.add(GenericItemModel(viewHolderClass, viewModelClass, layoutId, viewTypeId))
    }

}