package com.lire.baseappearance

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
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

        binding = DataBindingUtil.setContentView(this,R.layout.activity_subject)
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        viewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)
        binding.subject = viewModel

        bgmViewModel = ViewModelProvider(this, BgmDataViewModelFactory(
            BgmRepositoryImpl(BgmAPI.service))).get(BgmDataViewModel::class.java)

        bgmViewModel.subjectInfo.observe(this, {
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
//            Log.d("TAG", it.trimIndent())
        })

        bgmViewModel.loadSubjectInfoAsync("233")

        setSupportActionBar(binding.subjectToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}