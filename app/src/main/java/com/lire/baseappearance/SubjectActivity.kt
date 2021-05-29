package com.lire.baseappearance

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.lire.baseappearance.databinding.ActivitySubjectBinding
import com.lire.netdatahandler.SubjectJsonParser
import com.lire.restful.BgmAPI
import com.lire.restful.BgmDataViewModel
import com.lire.restful.BgmDataViewModelFactory
import com.lire.restful.BgmRepositoryImpl
import com.lire.subject.Chara
import com.lire.subject.SubjectViewModel

class SubjectActivity : AppCompatActivity() {

    // 视图绑定
    private lateinit var binding : ActivitySubjectBinding
    // 节目信息的view model
    private lateinit var viewModel: SubjectViewModel
    // 数据的view model
    private lateinit var bgmViewModel : BgmDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)
        setSupportActionBar(findViewById(R.id.subjectToolbar))

        // 从加载信息获取subject ID
        val targetID = intent.getStringExtra("targetID")

        // 设置数据绑定
        binding = DataBindingUtil.setContentView(this,R.layout.activity_subject)
        binding.lifecycleOwner = this

        // 初始化viewModel
        viewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)
        binding.subject = viewModel

        bgmViewModel = ViewModelProvider(this, BgmDataViewModelFactory(
            BgmRepositoryImpl(BgmAPI.service))).get(BgmDataViewModel::class.java)

        bgmViewModel.subjectInfo.observe(this, {
            setBgmViewModelObserve(it)
//            Log.d("TAG", it.trimIndent())
        })

        // 悬浮Button事件监听
        binding.subjectFab.setOnClickListener {
            updateModelStatus()
        }

        // 设置模态框的事件监听
        initializeModel()

        // 加载信息

        if (targetID != null) {
            bgmViewModel.loadSubjectInfoAsync(id = targetID)
        }
        binding.subjectToolbar.title = ""

        // 设置action bar

        setSupportActionBar(binding.subjectToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.subjectFab.load(R.drawable.ic_baseline_add_24)

    }

    /**
     * 模态框事件监听
     *
     */
    private fun initializeModel() {
        // 确认时
        binding.submitStatusButton.setOnClickListener {
            Snackbar.make(it, "本应用暂时不支持", Snackbar.LENGTH_LONG)
                    .show()
            updateModelStatus()
        }

        // 确认模态框的seekBar事件监听
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
        // 注册上下文菜单
        registerForContextMenu(binding.updateStatusButton)
    }

    /**
     * 上下文菜单的初始化
     *
     */
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        Log.d("TAG", "MENU")
        menuInflater.inflate(R.menu.fragment_status_menu, menu)
    }

    /**
     * 上下文菜单的事件处理
     *
     * @param item
     * @return
     */

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

    /**
     * 返回键事件
     *
     */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> {
//                NavUtils.navigateUpFromSameTask(this)
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    /**
     * 设置背景
     *
     */

    private fun updateModelStatus() {
        viewModel.isClickToolBar.value = !viewModel.isClickToolBar.value!!
        if (viewModel.isClickToolBar.value!! == true) {
            binding.SubjectScrollView.setBackgroundColor(Color.argb(0.3f, 0.0f, 0.0f, 0.0f))
        } else {
            binding.SubjectScrollView.setBackgroundColor(Color.argb(1.0f, 1.0f, 1.0f, 1.0f))
        }
    }

    /**
     * 设置viewmodel的事件响应
     *
     * @param it 返回的JSON字符串
     */

    private fun setBgmViewModelObserve(it: String) {
        viewModel.subjectInfo.value = SubjectJsonParser(it).parseJson()
        binding.subjectMainImage.load(viewModel.subjectInfo.value?.imageURL)
        binding.subjectToolbar.title = viewModel.subjectInfo.value?.jpName
        viewModel.subjectInfo.value?.character
                ?.filterIndexed { index, chara -> index % 2 == 0 }
                ?.forEach { chara ->
                    inflateCharacterViewEven(chara)
                }
        viewModel.subjectInfo.value?.character
                ?.filterIndexed { index, chara -> index % 2 == 1 }
                ?.forEach { chara ->
                    inflateCharacterViewOdd(chara)
                }
        viewModel.subjectInfo.value?.staff?.forEach {
            val view = TextView(this)
            view.text = "${it.name} : ${it.role}"
            binding.staffList.addView(view)
        }
    }

    /**
     * 设置奇数列的值
     *
     * @param character 角色
     */
    private fun inflateCharacterViewOdd(character: Chara) {
        val view = layoutInflater.inflate(R.layout.character_view, null)
        view.findViewById<TextView>(R.id.tvCharacterName).text = character.name
        view.findViewById<TextView>(R.id.tvCharacterType).text = character.type
        view.findViewById<ImageView>(R.id.imageCharacter).load(character.img)
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 200)
        params.circleRadius = 10
        params.topMargin = 8
        params.leftMargin = 8
        view.layoutParams = params
        binding.characterOdd.addView(view)
    }

    /**
     * 设置偶数列的值
     *
     * @param character 角色
     */

    private fun inflateCharacterViewEven(character: Chara) {
        val view = layoutInflater.inflate(R.layout.character_view, null)
        view.findViewById<TextView>(R.id.tvCharacterName).text = character.name
        view.findViewById<TextView>(R.id.tvCharacterType).text = character.type
        view.findViewById<ImageView>(R.id.imageCharacter).load(character.img)
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 200)
        params.circleRadius = 10
        params.topMargin = 8
        params.rightMargin = 8
        view.layoutParams = params
        binding.characterEven.addView(view)
    }
}