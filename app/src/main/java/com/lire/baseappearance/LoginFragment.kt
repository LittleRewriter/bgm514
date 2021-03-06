package com.lire.baseappearance

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import com.lire.baseappearance.databinding.FragmentLoginBinding
import com.lire.baseappearance.databinding.FragmentSearchBinding
import com.lire.netdatahandler.UserInfoJsonParser
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import com.lire.userinfo.UserInfo
import com.lire.utils.NAME_FIELD
import com.lire.utils.PREF_FILE_NAME

class LoginFragment:Fragment() {
    // 视图绑定
    private lateinit var binding : FragmentLoginBinding
    // 加载数据的view model
    private lateinit var bgmViewModel : BgmDataViewModel
    // username
    private var usernameStr : String? = null
    //userinfo
    private var userInfo : UserInfo? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // initialize view model
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
            BgmRepositoryImpl(BgmAPI.service)
        )
        ).get(BgmDataViewModel::class.java)

        // 检查是否在viewmodel中存放过数据
        val str = bgmViewModel.usernameStr.value
        if (str != null && str != "") {
            usernameStr = str
            bgmViewModel.loadUserInfoAsync(usernameStr!!)
        }

        // 设置登录跳转
        binding.profileCardView.setOnClickListener {
            showDialog()
        }

        // 更新返回信息
        bgmViewModel.userInfo.observe(this, Observer {
            userInfo = UserInfoJsonParser(it!!).parseJson()
            if (userInfo == null) {
                Snackbar.make(binding.profileCardView, "未找到用户名，请检查是否正确", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                updateUserInfo()
                bgmViewModel.setUserName(usernameStr!!)
            }
        })
    }

    /**
     * 更新UserInfo
     *
     */

    private fun updateUserInfo() {
        binding.profileImageView.load(userInfo!!.profile)
        binding.userHitokotoTextView.text = userInfo!!.hitokoto
        binding.usernameTextView.text = userInfo!!.name
    }

    /**
     * 创建一个对话框并返回
     *
     */

    private fun showDialog() {
        val inputArea = requireActivity().layoutInflater.inflate(R.layout.login_plaintext, null)
        val area = inputArea.findViewById<TextInputLayout>(R.id.inputPlainText)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("login")
            .setView(inputArea)
            .setNeutralButton("取消") {_,_ ->}
            .setPositiveButton("确定") {dialog, which ->
                usernameStr = area.editText?.text?.toString()
                storeUsername(usernameStr?:"")
                if (usernameStr == null || usernameStr == "") {
                    Snackbar.make(binding.profileCardView, "用户名不能为空！", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
            .show()

    }

    /**
     * 使用SharedPreference进行存储
     *
     * @param name 用户名
     */

    private fun storeUsername(name : String) {
        val pref = requireActivity().getSharedPreferences(
            PREF_FILE_NAME,
            Context.MODE_PRIVATE
        )
        val editor = pref.edit()
        editor.putString(NAME_FIELD, name)
        editor.apply()
        if (name != "") {
            bgmViewModel.loadUserInfoAsync(name)
        }
    }

}