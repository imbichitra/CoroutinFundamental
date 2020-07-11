package com.bichi.coroutinfundamental.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bichi.coroutinfundamental.R
import com.bichi.coroutinfundamental.data.models.Quote
import kotlinx.android.synthetic.main.item_quote.view.*

class QuotesAdapter(val quotesList:ArrayList<Quote>) : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote,parent,false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bindItems(quotesList[position])
    }

    class QuoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItems(quote: Quote) {
            itemView.text_view_author.text = quote.author
            itemView.text_view_quote.text = quote.quote
        }

    }

}