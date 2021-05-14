package com.lire.baseappearance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.datepicker.MaterialDatePicker
import com.lire.baseappearance.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*



class MainActivity : AppCompatActivity() {

    lateinit var tvInfo : TextView

    val tag : String = "LOG"

    private lateinit var binding : ActivityMainBinding

    private fun showLog(msg : Any) {
        Log.d(tag, msg.toString())
    }

    private fun showDatePicker() {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("请选择一个日期")
        builder.setSelection(Date().time)
        val picker = builder.build()
        picker.addOnPositiveButtonClickListener {
            tvInfo.text = formatDate(it)
        }
        picker.show(supportFragmentManager, null)
    }

    private fun formatDate(l: Long): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Date(l))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            toolbar.title = "bgm514"
            setSupportActionBar(toolbar)
            bottomNavigation.setupWithNavController(findNavController(R.id.navHost))

            

        }
    }
}