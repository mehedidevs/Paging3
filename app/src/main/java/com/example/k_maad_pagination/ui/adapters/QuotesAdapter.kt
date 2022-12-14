package com.example.k_maad_pagination.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.k_maad_pagination.databinding.ItemQuoteBinding
import com.example.k_maad_pagination.model.Result

class QuotesAdapter :
    PagingDataAdapter<com.example.k_maad_pagination.model.Result,
            QuotesAdapter.QuotesViewHolder>(Comparator) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {

        return QuotesViewHolder(
            ItemQuoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
//        var quotes: com.example.k_maad_pagination.model.Result = getItem(position)!!
//        holder.itemQuoteBinding.quoteTv.text = quotes.content

        getItem(position).let {
            holder.itemQuoteBinding.quoteTv.text = it?.content
        }


    }


    class QuotesViewHolder(public val itemQuoteBinding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(itemQuoteBinding.root)

    companion object {
        private val Comparator =
            object : DiffUtil.ItemCallback<com.example.k_maad_pagination.model.Result>() {
                override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {

                    return oldItem._id == newItem._id
                }

                override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                    return oldItem == newItem
                }

            }


    }


}