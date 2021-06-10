package ru.skill_branch.dev_intensive.ui.profile


import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import ru.skill_branch.dev_intensive.R
import ru.skill_branch.dev_intensive.model.Bender

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var benderImage:ImageView
    lateinit var textTxt:TextView
    lateinit var messageET:EditText
    lateinit var sendBtn:ImageView
    lateinit var benderObj:Bender


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //  benderImage = findViewById(R.id.iv_bender) as ImageView
        benderImage = iv_bender
        textTxt = tv_text
        messageET = et_message
        sendBtn = iv_sender


        val status = savedInstanceState?.getString("STATUS")?:Bender.Status.NORMAL.name
        val question=savedInstanceState?.getString("QUESTION")?:Bender.Question.NAME.name
        benderObj = Bender(Bender.Status.valueOf(status), Bender.Question.valueOf(question))

        Log.d("M_MainActivity","onCreate ${status} ${question}")

        val (r,g,b) = benderObj.status.color
        benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)

        textTxt.text = benderObj.askQuestion()

        sendBtn.setOnClickListener(this)

    }

    override fun onRestart(){
        super.onRestart()
        Log.d("M_MainActivity","onRestart")
    }

    override fun onStart(){
        super.onStart()
        Log.d("M_MainActivity","")
    }

    override fun onResume(){
        super.onResume()
        Log.d("M_MainActivity","onResume")
    }

    override fun onPause(){
        super.onPause()
        Log.d("M_MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("M_MainActivity","onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("M_MainActivity","onDestroy")
    }

    override fun onSaveInstanceState(outState:Bundle) {
        super.onSaveInstanceState(outState)

        outState?.putString("STATUS", benderObj.status.name)
        outState?.putString("QUESTION",benderObj.question.name)
        Log.d("M_MainActivity","onSaveInstanceState ${benderObj.question.name} ${benderObj.status.name}")
    }

    override fun onClick(v: View?) {
        if(v?.id== R.id.iv_sender){
            val (phrase,color)= benderObj.listenAnswer(messageET.text.toString().toLowerCase())
            messageET.setText("")
            val (r,g,b) = color
            textTxt.text=phrase
            benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
        }
    }
}