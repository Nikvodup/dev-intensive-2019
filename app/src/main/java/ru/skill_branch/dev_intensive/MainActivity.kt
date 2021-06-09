package ru.skill_branch.dev_intensive


import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.skill_branch.dev_intensive.model.Bender

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var benderImage:ImageView
    lateinit var textTxt:TextView
    lateinit var messageET:EditText
    lateinit var sendBtn:ImageView
    lateinit var benderObj:Bender


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("M_MainActivity","onCreate")

       //  benderImage = findViewById(R.id.iv_bender) as ImageView
           benderImage = iv_bender
       textTxt = tv_text
        messageET = et_message
        sendBtn = iv_sender

        benderObj = Bender()

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

    override fun onClick(v: View?) {
        if(v?.id==R.id.iv_sender){
          val (phrase,color)= benderObj.listenAnswer(messageET.text.toString().toLowerCase())
            messageET.setText("")
            val (r,g,b) = color
            textTxt.text=phrase
            benderImage.setColorFilter(Color.rgb(r,g,b), PorterDuff.Mode.MULTIPLY)
        }
    }
}