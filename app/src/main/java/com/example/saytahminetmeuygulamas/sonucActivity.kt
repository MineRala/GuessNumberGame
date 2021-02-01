package com.example.saytahminetmeuygulamas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sonuc.*


class sonucActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc)

        val sonuc = intent.getBooleanExtra("result",false)

        if(sonuc){
          result.text="YOU WİN!!"
            imageFace.setImageResource(R.drawable.mutlu_resim)
        }else{
           result.text="YOU LOST!!"
            imageFace.setImageResource(R.drawable.uzgun_resim)
        }


        playAgain.setOnClickListener {

            val intent = Intent(this@sonucActivity,tahminActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}