package io.github.janbarari.genericrecyclerview.model

import io.github.janbarari.genericrecyclerview.viewholder.GenericViewHolder


data class GenericItemModel(val viewHolderClass: Class<out GenericViewHolder>,
                            val viewModelClass: Class<out GenericViewModel>,
                            val layoutId: Int, val viewTypeId: Int)