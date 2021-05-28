package com.lire.baseappearance

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

class LoginFragment:Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private lateinit var bgmViewModel : BgmDataViewModel
    private var usernameStr : String? = null
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
        bgmViewModel = ViewModelProvider(requireActivity(), BgmDataViewModelFactory(
            BgmRepositoryImpl(BgmAPI.service)
        )
        ).get(BgmDataViewModel::class.java)
        binding.profileCardView.setOnClickListener {
            showDialog()
            if (usernameStr == null || usernameStr == "") {
                Snackbar.make(binding.profileCardView, "用户名不能为空！", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                bgmViewModel.loadUserInfoAsync(usernameStr!!)
            }
        }
        bgmViewModel.userInfo.observe(this, Observer {
            userInfo = UserInfoJsonParser(it!!).parseJson()
            if (userInfo == null) {
                Snackbar.make(binding.profileCardView, "未找到用户名，请检查是否正确", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                binding.profileImageView.load(userInfo!!.profile)
                binding.userHitokotoTextView.text = userInfo!!.hitokoto
                binding.usernameTextView.text = userInfo!!.name
            }
        })
    }

    fun showDialog() {
        val inputArea = requireActivity().layoutInflater.inflate(R.layout.login_plaintext, null)
        val area = inputArea.findViewById<TextInputLayout>(R.id.inputPlainText)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("login")
            .setView(inputArea)
            .setNeutralButton("取消") {_,_ ->}
            .setPositiveButton("确定") {dialog, which ->
                usernameStr = area.editText?.text?.toString()
            }
            .show()

    }

}