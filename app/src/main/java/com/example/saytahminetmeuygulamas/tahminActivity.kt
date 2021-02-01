package com.example.saytahminetmeuygulamas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sonuc.*
import kotlinx.android.synthetic.main.activity_tahmin.*
import kotlin.random.Random

class tahminActivity : AppCompatActivity() {
    private var randomNumber = 0
    private var temp =5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tahmin)

        randomNumber = Random.nextInt(101)
        Log.e("Rastgele sayı: ",randomNumber.toString() )

        enter.setOnClickListener {
            temp = temp-1
            val guess = editTextGirdi.text.toString().toInt()

            if(guess == randomNumber){

                val intent = Intent(this@tahminActivity,sonucActivity::class.java)
                intent.putExtra("result",true)

                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(temp == 0){
                val intent = Intent(this@tahminActivity,sonucActivity::class.java)
                intent.putExtra("result",false)
                finish()
                startActivity(intent)
            }
            if(guess < randomNumber){
                increaseDecrease.text = "İncrease"
                remainderNumber.text = "Remainder Due:$temp"

                if(randomNumber-guess<=10)
                    textViewAralık.text="You are so close "
                else if (randomNumber-guess<=20)
                    textViewAralık.text="You're close, come a little closer"
                else if(randomNumber-guess<=50)
                    textViewAralık.text="You are far we need to approach"
                else
                    textViewAralık.text="You are too far come closer"
            }
            if(guess > randomNumber){
                increaseDecrease.text ="Decrease"
                remainderNumber.text = "Remainder Due:$temp"

                if(guess-randomNumber<=10)
                    textViewAralık.text="You are so close "
                else if (guess-randomNumber<=20)
                    textViewAralık.text="You're close, come a little closer"
                else if(guess-randomNumber<=50)
                    textViewAralık.text="You are far we need to approach"
                else
                    textViewAralık.text="You are too far come closer"
            }
            editTextGirdi.setText("")


       }
    }
}