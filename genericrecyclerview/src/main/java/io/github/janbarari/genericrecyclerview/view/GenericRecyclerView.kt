package io.github.janbarari.genericrecyclerview.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import io.github.janbarari.genericrecyclerview.listener.EndlessRecyclerViewScrollListener

class GenericRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
                                                    defStyleAttr: Int = 0) : RecyclerView(context, attrs, defStyleAttr) {

    fun setLoadMoreListener(genericRecyclerViewListener: GenericRecyclerViewListener?) {
        val loadMoreListener = object: EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                genericRecyclerViewListener?.onLoadMore()
            }
        }
        addOnScrollListener(loadMoreListener)
    }

    interface GenericRecyclerViewListener {
        fun onLoadMore();
    }
}