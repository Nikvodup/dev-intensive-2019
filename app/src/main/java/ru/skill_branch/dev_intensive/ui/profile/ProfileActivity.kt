package ru.skill_branch.dev_intensive.ui.profile


import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_profile.*
import ru.skill_branch.dev_intensive.R
import ru.skill_branch.dev_intensive.model.Profile
import ru.skill_branch.dev_intensive.viewmodels.ProfileViewModel

class ProfileActivity : AppCompatActivity() {
    companion object {
        const val IS_EDIT_MODE = "IS_EDIT_MODE"
    }

    private lateinit var viewModel:ProfileViewModel
    var isEditMode = false
    lateinit var viewFields : Map<String,TextView>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViewModel()
        initViews(savedInstanceState)

    }

    override fun onSaveInstanceState(outState:Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putBoolean(IS_EDIT_MODE, isEditMode)
    }


    private fun initViewModel(){
         viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        viewModel.getProfileData().observe(this, Observer{updateUI(it)})
        viewModel.getTheme().observe(this, Observer{updateTheme(it)})
    }

    private fun updateUI(profile: Profile){
        profile.toMap().also {
            for((k,v) in viewFields){
                v.text = it[k].toString()
            }
        }

    }


private fun updateTheme(mode:Int){
    delegate.setLocalNightMode(mode)
}


    private fun initViews(savedInstanceState:Bundle?){

        viewFields=mapOf(
            "nickName"   to tv_name,
             "rank"      to tv_rank,
            "firstName"   to et_firstname,
            "lastName"    to et_lastname,
            "about"       to et_about,
            "repository"   to et_repository,
            "rating"      to tv_rating,
            "respect"    to tv_respect

        )
        isEditMode = savedInstanceState?.getBoolean(IS_EDIT_MODE, false) ?:true
        showCurrentMode(isEditMode)


   btn_edit.setOnClickListener{
       if(isEditMode) saveProfileInfo()
         isEditMode = !isEditMode
        showCurrentMode(isEditMode)
    }

        btn_switch_day.setOnClickListener(View.OnClickListener{
            viewModel.switchTheme()

        })

}

    private fun showCurrentMode(isEdit:Boolean) {
        val info = viewFields.filter {
            setOf(
                "firstname",
                "lastname",
                "about",
                "repository"
            ).contains(it.key)
        }
        for ((_, v) in info) {
            v as EditText
            v.isFocusable = isEdit
            v.isFocusableInTouchMode = isEdit
            v.isEnabled = isEdit
            v.background.alpha = if (isEdit) 255 else 0
        }

        ic_eye.visibility = if (isEdit) View.GONE else View.VISIBLE
        // et_about.isCounterEnabled = isEdit

        with(btn_edit) {
            val filter: ColorFilter? = if (isEdit) {
                PorterDuffColorFilter(
                    resources.getColor(R.color.color_accent, theme),
                    PorterDuff.Mode.SRC_IN
                )

            } else {
                null
            }
        }

        val icon = if (isEdit) {
            resources.getDrawable(R.drawable.ic_save_black_24, theme)
        } else {
            resources.getDrawable(R.drawable.btn_edit, theme)
        }


        btn_edit.background.colorFilter
        btn_edit.setImageDrawable(icon)
    }

    private fun saveProfileInfo(){
        Profile(
            firstName = et_firstname.text.toString(),
            lastName = et_lastname.text.toString(),
            about = et_about.text.toString(),
            repository = et_repository.text.toString()
        ).apply {
            viewModel.saveProfileData(this)
        }
    }



}
