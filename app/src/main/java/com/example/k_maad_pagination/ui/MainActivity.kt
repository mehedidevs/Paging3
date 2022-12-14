package com.example.k_maad_pagination.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.k_maad_pagination.R
import com.example.k_maad_pagination.databinding.ActivityMainBinding
import com.example.k_maad_pagination.ui.adapters.QuotesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: QuoteViewModel

    //var mViewModel : QuoteViewModel by viewModels()

    lateinit var adapter: QuotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = QuotesAdapter()
        binding.quotesRecyclerview.adapter = adapter

        viewModel = ViewModelProvider(this)[QuoteViewModel::class.java]
        viewModel.quoteList.observe(this) {
            adapter.submitData(lifecycle, it)

        }


    }
}