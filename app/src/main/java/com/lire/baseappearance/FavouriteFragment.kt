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

class FavouriteFragment:Fragment() {
    private lateinit var binding : FragmentFavouriteBinding
    private lateinit var bgmViewModel : BgmDataViewModel
    private var collectionMap : MutableMap<Int, List<UserCollection>> = mutableMapOf()
    private var viewCollectionList : MutableList<UserCollection> = mutableListOf()
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
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
                BgmRepositoryImpl(BgmAPI.service)
        )
        ).get(BgmDataViewModel::class.java)

        binding.collectionView.layoutManager = LinearLayoutManager(context)
        val adapter = CollectionViewAdapter(viewCollectionList, requireContext())
        binding.collectionView.adapter = adapter

        if (bgmViewModel.usernameStr.value == null || bgmViewModel.usernameStr.value == "") {
            Snackbar.make(binding.root, "请先登录！", Snackbar.LENGTH_LONG)
                    .show()
        } else {
            bgmViewModel.loadUserWatchingAsync(bgmViewModel.usernameStr.value!!)
        }

        bgmViewModel.userWatching.observe(this, {
            if (it != null) {
                collectionMap.clear()
                collectionMap.putAll(CollectionJsonHandler(it).parseJson().groupBy { e -> e.type })
                viewCollectionList.clear()
                collectionMap[selectedTypeID]?.let { it1 -> viewCollectionList.addAll(it1) }
                adapter.notifyDataSetChanged()
            }
        })

        bgmViewModel.usernameStr.observe(this, {
            it?.let {bgmViewModel.loadUserWatchingAsync(it)}
        })

        binding.favToggleBtnGroup.check(R.id.favBtnAnime)
        binding.favToggleBtnGroup.addOnButtonCheckedListener { _, checkedId, _ ->
            var newCheckID = when(checkedId) {
                R.id.favBtnAnime ->  2
                R.id.favBtnBook -> 1
                R.id.favBtnSanjigenn ->  6
                else -> 0
            }
            if (newCheckID != selectedTypeID) {
                selectedTypeID = newCheckID
                viewCollectionList.clear()
                collectionMap[selectedTypeID]?.let { it1 -> viewCollectionList.addAll(it1) }
                adapter.notifyDataSetChanged()
            }
        }

    }
}