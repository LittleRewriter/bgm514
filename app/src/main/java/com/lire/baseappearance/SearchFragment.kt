package com.lire.baseappearance

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lire.baseappearance.databinding.FragmentSearchBinding
import com.lire.netdatahandler.SearchJsonHandler
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import com.lire.searchview.SearchResult
import com.lire.searchview.SearchViewAdapter

class SearchFragment:Fragment() {
    private lateinit var binding : FragmentSearchBinding
    private lateinit var bgmViewModel : BgmDataViewModel
    private var resultList : MutableList<SearchResult> = mutableListOf()
    private var listSize = 0
    private var currentAmount = 0
    private var searchText : String? = null
    private var searchType : Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.searchResultView.layoutManager = LinearLayoutManager(context)
        val adapter = SearchViewAdapter(resultList, requireContext())
        binding.searchResultView.adapter = adapter
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
                BgmRepositoryImpl(BgmAPI.service)
        )).get(BgmDataViewModel::class.java)
        bgmViewModel.searchResult.observe(this, {
            val parserResult = SearchJsonHandler(it).parseJson()
            resultList.addAll(parserResult)
//            Log.d("here", resultList.map{it.toString()}.reduce { acc, s -> acc + " " + s })
            adapter.notifyItemInserted(listSize)
//            adapter.notifyDataSetChanged()
            listSize += parserResult.size
        })
//        bgmViewModel.loadSearchResultAsync("White", currentAmount)
        binding.searchResultView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1)) {
                        currentAmount += 10
                        loadAsyncWithType()
//                        if (searchText != null) {
//                            bgmViewModel.loadSearchResultAsync(searchText!!, currentAmount)
//
//                        }
                    }
                }
            }
        )
        binding.typeToggleBtnGroup.check(R.id.typBtnAll)
        binding.typeToggleBtnGroup.addOnButtonCheckedListener { group, checkedId, _ ->
            Log.d("TAG", checkedId.toString())
            when(checkedId) {
                R.id.typBtnAll -> searchType = 0
                R.id.typeBtnBook -> searchType = 1
                R.id.typeBtnAnime -> searchType = 2
                R.id.typeBtnMusic -> searchType = 3
                R.id.typeBtnGame -> searchType = 4
                R.id.typeBtnSanjigen -> searchType = 6
            }
        }
        binding.searchTextField.editText?.doOnTextChanged { text, _, _, _->
            if (searchText == null || text.toString().trimIndent() != searchText) {
                currentAmount = 0
                listSize = 0
                resultList.clear()
                adapter.notifyDataSetChanged()
                searchText = text.toString().trimIndent()
//                bgmViewModel.loadSearchResultAsync(searchText!!, currentAmount)
                loadAsyncWithType()
            }
        }
    }

    fun loadAsyncWithType() {
        if (searchText != null) {
            if (searchType == 0) {
                bgmViewModel.loadSearchResultAsync(searchText!!, currentAmount)
            } else {
                Log.d("TAG", searchType.toString())
                bgmViewModel.loadSearchResultWithTypeAsync(searchText!!, currentAmount, searchType)
            }
        }
    }

}