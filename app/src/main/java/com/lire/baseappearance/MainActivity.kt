package com.lire.baseappearance

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.datepicker.MaterialDatePicker
import com.lire.baseappearance.databinding.ActivityMainBinding
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import com.lire.utils.NAME_FIELD
import com.lire.utils.PREF_FILE_NAME
import java.text.SimpleDateFormat
import java.util.*



class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var bgmViewModel : BgmDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 创建ViewModel
        bgmViewModel = ViewModelProvider(this, BgmDataViewModelFactory(
                BgmRepositoryImpl(BgmAPI.service))).get(BgmDataViewModel::class.java)

        if (loadUsername() != "") {
            val usernameStr = loadUsername()
            bgmViewModel.setUserName(usernameStr)
            bgmViewModel.loadUserInfoAsync(usernameStr)
        }

        // 启用导航栏
        with(binding) {
            toolbar.title = "bgm514"
            setSupportActionBar(toolbar)
            bottomNavigation.setupWithNavController(findNavController(R.id.navHost))
        }

    }

    /**
     * 从存储中读取username，并加载到viewmodel中
     *
     * @return String
     */

    private fun loadUsername() : String {
        val pref = getSharedPreferences(
            PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )
        val name = pref.getString(NAME_FIELD, "")
        return name?:""
    }
}