package ru.skill_branch.dev_intensive

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import ru.skill_branch.dev_intensive.repositories.PreferencesRepository

class App: Application() {

companion object{
    private var instance:App?=null
    fun applicationContext(): Context{
        return instance!!.applicationContext
    }
}

   init {
       instance=this
   }

  override fun  onCreate(){
        super.onCreate()
      PreferencesRepository.getAppTheme().also {
          AppCompatDelegate.setDefaultNightMode(it)
      }
    }
}