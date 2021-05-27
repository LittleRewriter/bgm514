package com.lire.baseappearance

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lire.baseappearance.databinding.ActivitySubjectBinding
import com.lire.netdatahandler.SubjectJsonParser
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import com.lire.subject.SubjectViewModel

class SubjectActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySubjectBinding
    private lateinit var viewModel: SubjectViewModel
    private lateinit var bgmViewModel : BgmDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)
        setSupportActionBar(findViewById(R.id.subjectToolbar))

        val targetID = intent.getStringExtra("targetID")

        binding = DataBindingUtil.setContentView(this,R.layout.activity_subject)
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)
        binding.subject = viewModel

        bgmViewModel = ViewModelProvider(this, BgmDataViewModelFactory(
            BgmRepositoryImpl(BgmAPI.service))).get(BgmDataViewModel::class.java)

        bgmViewModel.subjectInfo.observe(this, {
            setBgmViewModelObserve(it)
//            Log.d("TAG", it.trimIndent())
        })

        binding.subjectFab.setOnClickListener {
            updateModelStatus()
        }

        binding.submitStatusButton.setOnClickListener {
            Snackbar.make(it, "本应用暂时不支持", Snackbar.LENGTH_LONG)
                    .show()
            updateModelStatus()
        }

        binding.myScoreSeekBar.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        binding.myScoreUpdateTextView.text = (progress / 2.0).toString()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {

                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {

                    }
                }
        )

        registerForContextMenu(binding.updateStatusButton)

        if (targetID != null) {
            bgmViewModel.loadSubjectInfoAsync(id = targetID)
        }

        setSupportActionBar(binding.subjectToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        Log.d("TAG", "MENU")
        menuInflater.inflate(R.menu.fragment_status_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val str = when(item.itemId) {
            R.id.view_status_want -> "想看"
            R.id.view_status_watched -> "看过"
            R.id.view_status_watching -> "在看"
            R.id.view_status_placed -> "搁置"
            R.id.view_status_giveup -> "抛弃"
            else -> "点击选择状态"
        }
        binding.updateStatusButton.text = str
        return true
    }

    private fun updateModelStatus() {
        viewModel.isClickToolBar.value = !viewModel.isClickToolBar.value!!
        if (viewModel.isClickToolBar.value!! == true) {
            binding.SubjectScrollView.setBackgroundColor(Color.argb(0.3f, 0.0f, 0.0f, 0.0f))
        } else {
            binding.SubjectScrollView.setBackgroundColor(Color.argb(1.0f, 1.0f, 1.0f, 1.0f))
        }
    }

    private fun setBgmViewModelObserve(it: String) {
        viewModel.subjectInfo.value = SubjectJsonParser(it).parseJson()
        viewModel.subjectInfo.value?.character
                ?.filterIndexed { index, chara -> index % 2 == 0 }
                ?.forEach { it ->
                    val view = layoutInflater.inflate(R.layout.character_view, null)
                    view.findViewById<TextView>(R.id.tvCharacterName).text = it.name
                    view.findViewById<TextView>(R.id.tvCharacterType).text = it.type
                    val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 200)
                    params.circleRadius = 10
                    params.topMargin = 8
                    params.rightMargin = 8
                    view.layoutParams = params
                    binding.characterEven.addView(view)
                }
        viewModel.subjectInfo.value?.character
                ?.filterIndexed { index, chara -> index % 2 == 1 }
                ?.forEach { it ->
                    val view = layoutInflater.inflate(R.layout.character_view, null)
                    view.findViewById<TextView>(R.id.tvCharacterName).text = it.name
                    view.findViewById<TextView>(R.id.tvCharacterType).text = it.type
                    val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 200)
                    params.circleRadius = 10
                    params.topMargin = 8
                    params.leftMargin = 8
                    view.layoutParams = params
                    binding.characterOdd.addView(view)
                }
        viewModel.subjectInfo.value?.staff?.forEach {
            val view = TextView(this)
            view.text = "${it.name} : ${it.role}"
            binding.staffList.addView(view)
        }
    }
}