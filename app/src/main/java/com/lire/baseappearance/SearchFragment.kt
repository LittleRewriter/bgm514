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
    // 视图绑定
    private lateinit var binding : FragmentSearchBinding
    // 加载的view model
    private lateinit var bgmViewModel : BgmDataViewModel
    // 结果list
    private var resultList : MutableList<SearchResult> = mutableListOf()
    // list大小
    private var listSize = 0
    // 当前加载的消息编号，用来跨页
    private var currentAmount = 0
    // 搜索的字符串
    private var searchText : String? = null
    // 搜索的种类
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
        // 搜索结果recyclerView的设置
        binding.searchResultView.layoutManager = LinearLayoutManager(context)
        val adapter = SearchViewAdapter(resultList, requireContext())
        binding.searchResultView.adapter = adapter

        // 初始化viewModel
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
                BgmRepositoryImpl(BgmAPI.service)
        )).get(BgmDataViewModel::class.java)

        // 设置动态刷新
        bgmViewModel.searchResult.observe(this, {
            val parserResult = SearchJsonHandler(it).parseJson()
            resultList.addAll(parserResult)
            adapter.notifyItemInserted(listSize)
            listSize += parserResult.size
        })

        // 设置滑动到底部的时候动态获取
        binding.searchResultView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1)) {
                        currentAmount += 10
                        loadAsyncWithType()
                    }
                }
            }
        )

        // 设置搜索类别检测
        binding.typeToggleBtnGroup.check(R.id.typBtnAll)
        binding.typeToggleBtnGroup.addOnButtonCheckedListener { group, checkedId, _ ->

            val currType = getCurrType(checkedId)
            if (currType != searchType) {
                searchType = currType
                clearObserveList()
                adapter.notifyDataSetChanged()
                loadAsyncWithType()
            }

        }

        // 文字变化时自动搜索
        binding.searchTextField.editText?.doOnTextChanged { text, _, _, _->
            if (searchText == null || text.toString().trimIndent() != searchText) {
                clearObserveList()
                adapter.notifyDataSetChanged()
                searchText = text.toString().trimIndent()
                loadAsyncWithType()
            }
        }
    }

    /**
     * 清除观察的List
     *
     */

    private fun clearObserveList() {
        currentAmount = 0
        listSize = 0
        resultList.clear()
    }

    /**
     * 获取当前的种类
     *
     * @param checkedId 被选中的ID
     */

    private fun getCurrType(checkedId: Int) = when (checkedId) {
        R.id.typBtnAll -> 0
        R.id.typeBtnBook -> 1
        R.id.typeBtnAnime -> 2
        R.id.typeBtnMusic -> 3
        R.id.typeBtnGame -> 4
        R.id.typeBtnSanjigen -> 6
        else -> 0
    }

    /**
     * 通过种类加载结果
     *
     */

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