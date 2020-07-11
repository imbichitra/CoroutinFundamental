package com.bichi.coroutinfundamental.ui

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bichi.coroutinfundamental.R
import com.bichi.coroutinfundamental.data.models.Quote
import com.bichi.coroutinfundamental.data.models.QuotesResponse
import com.bichi.coroutinfundamental.data.network.MyApi
import com.bichi.coroutinfundamental.databinding.FragmentQuotesBinding
import kotlinx.android.synthetic.main.fragment_quotes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuotesFragment : Fragment() {

    private val quotesAdapter by lazy { QuotesAdapter() }
    var quotesList:ArrayList<Quote>?= ArrayList()
    private lateinit var viewModel:QuotesViewModel

    private lateinit var binding : FragmentQuotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*val view =  inflater.inflate(R.layout.fragment_quotes, container, false)
        return view*/
        binding = FragmentQuotesBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*recyclerview_quotes?.let {
            it.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
            it.adapter = quotesAdapter
        }*/
        binding.recyclerviewQuotes.adapter =quotesAdapter

        viewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)

        viewModel.quotes?.observe(viewLifecycleOwner, Observer {
            //quotesList?.addAll(it)
            //quotesAdapter?.notifyDataSetChanged()
            quotesAdapter.quotesList = it
        })
    }

    /*private fun getQuotes(){
        MyApi().getMovies().enqueue(object :Callback<QuotesResponse>{
            override fun onFailure(call: Call<QuotesResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<QuotesResponse>,
                response: Response<QuotesResponse>
            ) {

                response.body()?.quotes?.let { quotesList?.addAll(it) }
                Log.d(TAG, "onResponse: "+quotesList)
                quotesAdapter?.notifyDataSetChanged()
            }

        })
    }*/
}