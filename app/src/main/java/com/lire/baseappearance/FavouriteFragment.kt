package com.lire.baseappearance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lire.baseappearance.databinding.FragmentFavouriteBinding
import com.lire.baseappearance.databinding.FragmentLoginBinding
import com.lire.collectionview.CollectionViewAdapter
import com.lire.netdatahandler.CollectionJsonHandler
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import com.lire.userinfo.UserCollection

/**
 * 我的收藏的Fragment代码
 *
 */

class FavouriteFragment:Fragment() {
    // 视图绑定
    private lateinit var binding : FragmentFavouriteBinding
    // 加载repo的view model
    private lateinit var bgmViewModel : BgmDataViewModel
    // 数据类，用于更新
    private var collectionMap : MutableMap<Int, List<UserCollection>> = mutableMapOf()
    // 视图List
    private var viewCollectionList : MutableList<UserCollection> = mutableListOf()
    // 默认选择的类型
    private var selectedTypeID = 2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // generate viewmodel
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
                BgmRepositoryImpl(BgmAPI.service)
        )
        ).get(BgmDataViewModel::class.java)

        // 设置布局
        binding.collectionView.layoutManager = LinearLayoutManager(context)
        val adapter = CollectionViewAdapter(viewCollectionList, requireContext())
        binding.collectionView.adapter = adapter

        // 如果用户登录，则进行相关操作
        if (bgmViewModel.usernameStr.value == null || bgmViewModel.usernameStr.value == "") {
            Snackbar.make(binding.root, "请先登录！", Snackbar.LENGTH_LONG)
                    .show()
        } else {
            bgmViewModel.loadUserWatchingAsync(bgmViewModel.usernameStr.value!!)
        }

        bgmViewModel.userWatching.observe(this, {
            if (it != null) {
                resetCollectionByResponseData(it)
                adapter.notifyDataSetChanged()
            }
        })

        bgmViewModel.usernameStr.observe(this, {
            it?.let {bgmViewModel.loadUserWatchingAsync(it)}
        })

        binding.favToggleBtnGroup.check(R.id.favBtnAnime)
        binding.favToggleBtnGroup.addOnButtonCheckedListener { _, checkedId, _ ->
            val newCheckID = when(checkedId) {
                R.id.favBtnAnime ->  2
                R.id.favBtnBook -> 1
                R.id.favBtnSanjigenn ->  6
                else -> 0
            }
            if (newCheckID != selectedTypeID) {
                selectedTypeID = newCheckID
                resetCollectionListByTypeID()
                adapter.notifyDataSetChanged()
            }
        }

    }

    /**
     * 根据返回的数据对CollectionMap进行更新
     *
     * @param it 返回的数据
     */
    private fun resetCollectionByResponseData(it: String) {
        collectionMap.clear()
        collectionMap.putAll(CollectionJsonHandler(it).parseJson().groupBy { e -> e.type })
        resetCollectionListByTypeID()
    }

    /**
     * 根据selectedTypeID对CollectionMap进行更新
     *
     */

    private fun resetCollectionListByTypeID() {
        viewCollectionList.clear()
        collectionMap[selectedTypeID]?.let { it1 -> viewCollectionList.addAll(it1) }
    }
}