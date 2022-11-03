package com.linegame.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.linegame.R
import java.util.*

class Gamb : AppCompatActivity(), View.OnClickListener  {
    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button

    lateinit var ins : String

    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gamb)

        button1 = findViewById(R.id.Oyes)
        button2 = findViewById(R.id.Ono)
        button3 = findViewById(R.id.Byes)
        button4 = findViewById(R.id.Bno)
        button5 = findViewById(R.id.Yyes)
        button6 = findViewById(R.id.Yno)

        val inst : TextView = findViewById(R.id.randInst)
        ins = inst()
        inst.text = ins

        randPos(button1,800)
        randPos(button2,800)
        randPos(button3,900)
        randPos(button4,900)
        randPos(button5,1000)
        randPos(button6,1000)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)

        val running : TextView = findViewById(R.id.running)
        val timeRan : TextView = findViewById(R.id.timeRan)



        val intent = intent
        val str = intent.getStringExtra("message_key")
        running.text = "$str s"
        val s : Long = 10 * 1000

        object : CountDownTimer( s , 1000) {

            override fun onTick(millisUntilFinished: Long) {
                running.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                timeRan.text = "Time's Over!"
                MaterialAlertDialogBuilder(this@Gamb)
                    .setTitle("Time's Over")
                    .setMessage("Your score is : $score")
                    .setCancelable(false)
                    .setPositiveButton("Play again"){dialog, _ ->
                        startActivity(Intent(applicationContext, Gamb::class.java))
                        finish()
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }.start()
    }

    override fun onBackPressed() {
        Toast.makeText(this@Gamb, "Back Functionality Disabled till Timer Ends", Toast.LENGTH_SHORT).show()
    }

    private fun randPos(Btn: Button, Time:Long) {
        val time: Long = Time
        val btn: Button = Btn
        val screenWidth = this.resources.displayMetrics.widthPixels
        val screenHeight = this.resources.displayMetrics.heightPixels
        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * screenWidth
                    val dy: Float = rand.nextFloat() * screenHeight
                    btn.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(0)
                        .start()
                }
            }
        }, 0, time)
    }

    private fun inst(): String{
        val color = arrayOf("Yellow","Blue","Orange")
        val text = arrayOf("Yes","No")
        return "${color.random()} color with ${text.random()} text"
    }

    override fun onClick(view: View) {
        val (s1, s2, s3) = arrayOf("Yellow color with Yes text", "Yellow color with No text", "Blue color with Yes text")
        val (s4, s5, s6) = arrayOf("Blue color with No text", "Orange color with Yes text", "Orange color with No text")

        val inc = 5
        val dec = 10

        when(ins){
            s1 ->{
                when (view.id) {
                    R.id.Oyes -> {
                        score-=dec
                        //       scoring.text = score.toString()
                    }
                    R.id.Ono -> {
                        score-=dec
                        //      scoring.text = score.toString()
                    }
                    R.id.Byes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Bno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yyes -> {
                        score+=inc
//                        scoring.text = score.toString()
                    }
                    R.id.Yno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    else -> { }
                }
            }
            s2 ->{
                when (view.id) {
                    R.id.Oyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Ono -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Byes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Bno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yno -> {
                        score+=inc
//                        scoring.text = score.toString()
                    }
                    else -> { }
                }
            }
            s3 ->{
                when (view.id) {
                    R.id.Oyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Ono -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Byes -> {
                        score+=inc
//                        scoring.text = score.toString()
                    }
                    R.id.Bno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    else -> { }
                }
            }
            s4 ->{
                when (view.id) {
                    R.id.Oyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Ono -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Byes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Bno -> {
                        score+=inc
//                        scoring.text = score.toString()
                    }
                    R.id.Yyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    else -> { }
                }
            }
            s5 ->{
                when (view.id) {
                    R.id.Oyes -> {
                        score+=inc
//                        scoring.text = score.toString()
                    }
                    R.id.Ono -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Byes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Bno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    else -> { }
                }
            }
            s6 ->{
                when (view.id) {
                    R.id.Oyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Ono -> {
                        score+=inc
//                        scoring.text = score.toString()
                    }
                    R.id.Byes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Bno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yyes -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    R.id.Yno -> {
                        score-=dec
//                        scoring.text = score.toString()
                    }
                    else -> { }
                }
            }
        }

    }

}