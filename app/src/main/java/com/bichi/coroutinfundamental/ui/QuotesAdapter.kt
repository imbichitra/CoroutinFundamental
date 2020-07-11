package com.bichi.coroutinfundamental.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bichi.coroutinfundamental.R
import com.bichi.coroutinfundamental.data.models.Quote
import com.bichi.coroutinfundamental.databinding.ItemQuoteBinding
import kotlinx.android.synthetic.main.item_quote.view.*

class QuotesAdapter : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {

    var quotesList:List<Quote>?=null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= QuoteViewHolder (
       /*val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote,parent,false)
        return QuoteViewHolder(view)*/
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_quote,
            parent,
            false
        )
    )

    override fun getItemCount(): Int {
        return quotesList?.size ?:0
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        //holder.bindItems(quotesList[position])
        holder.binding.quote = quotesList!![position]
    }

    inner class QuoteViewHolder(val binding: ItemQuoteBinding):RecyclerView.ViewHolder(binding.root)

}