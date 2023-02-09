package com.example.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var isplayer1 = true
    var endGame = false

    private lateinit var topCenter: ImageView
    private lateinit var topEnd: ImageView
    private lateinit var topStart: ImageView

    private lateinit var center: ImageView
    private lateinit var centerEnd: ImageView
    private lateinit var centerStart: ImageView

    private lateinit var bottomCenter: ImageView
    private lateinit var bottomEnd: ImageView
    private lateinit var bottomStart: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        topCenter = findViewById(R.id.topCenter)
        topEnd = findViewById(R.id.topEnd)
        topStart = findViewById(R.id.topStart)

        center = findViewById(R.id.center)
        centerEnd = findViewById(R.id.centerEnd)
        centerStart = findViewById(R.id.centerStart)

        bottomCenter = findViewById(R.id.bottomCenter)
        bottomEnd = findViewById(R.id.bottomEnd)
        bottomStart = findViewById(R.id.bottomStart)

        var reset = findViewById<Button>(R.id.reset)
            reset.setOnClickListener{
                resertBox(topCenter)
                resertBox(topEnd)
                resertBox(topStart)

                resertBox(center)
                resertBox(centerEnd)
                resertBox(centerStart)

                resertBox(bottomCenter)
                resertBox(bottomEnd)
                resertBox(bottomStart)
            }

        configureBox(topCenter)
        configureBox(topEnd)
        configureBox(topStart)

        configureBox(center)
        configureBox(centerEnd)
        configureBox(centerStart)

        configureBox(bottomCenter)
        configureBox(bottomEnd)
        configureBox(bottomStart)
    }

    private fun resertBox (box: ImageView) {
        box.setImageDrawable(null)
        box.tag = null
        isplayer1 = true
        endGame = false
    }


    private fun configureBox (box:ImageView) {
        box.setOnClickListener{
           if (box.tag == null && !endGame) {
               if (isplayer1) {
                   box.setImageResource(R.drawable.baseline_panorama_fish_eye_24)
                   isplayer1 = false
                   box.tag = 1
               } else {
                   box.setImageResource(R.drawable.baseline_close_24)
                   isplayer1 = true
                   box.tag = 2
               }
               if (playerWin(1)){
                   Toast.makeText(this@MainActivity, "Player 1 Won!", Toast.LENGTH_LONG).show()
                 endGame = true
               }else if (playerWin(2)){
                   Toast.makeText(this@MainActivity,"Player 2 Won!", Toast.LENGTH_LONG).show()
                   endGame = true
               }
           }
        }
    }

        private fun playerWin (value:Int): Boolean{
            if ((topCenter.tag == value && center.tag == value && bottomCenter.tag == value) ||
                (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||
                (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value) ||

                (topStart.tag == value && topCenter.tag == value && topEnd.tag == value) ||
                (centerStart.tag == value && center.tag == value && centerEnd.tag == value)||
                (bottomStart.tag == value && bottomCenter.tag == value && bottomEnd.tag == value)||

                (topStart.tag == value && center.tag == value && bottomEnd.tag == value)||
                (topEnd.tag == value && center.tag == value && bottomStart.tag == value)){

                return true
            }
            return false

        }

}


