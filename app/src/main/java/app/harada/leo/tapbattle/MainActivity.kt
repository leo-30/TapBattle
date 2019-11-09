package app.harada.leo.tapbattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    var number1: Int = 0
    var number2: Int = 0
    var timerCount: Int = 10
    val handler: Handler = Handler()
    var winner: String = "左の人"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1.text = "0"
        textView2.text = "0"

        winnerLabel.text = ""

        startButton.setVisibility(View.VISIBLE)
        restartButton.setVisibility(View.INVISIBLE)
        tapButton1.setEnabled(false)
        tapButton2.setEnabled(false)

        startButton.setOnClickListener {
            startButton.setVisibility(View.INVISIBLE)
            tapButton1.setEnabled(true)
            tapButton2.setEnabled(true)
            timer(period = 1000) {
                handler.post {
                    timerCount--

                    if (timerCount <= 0) {
                        timerCount = 0
                        textView3.text = timerCount.toString()
                        restartButton.setVisibility(View.VISIBLE)
                        tapButton1.setEnabled(false)
                        tapButton2.setEnabled(false)

                        if (number2 > number1) {
                            winner = "右の人"
                        } else if (number1 == number2) {
                            winner = "どっちも"
                        }

                        winnerLabel.text = "勝者は" + winner + "！"
                    }

                    textView3.text = timerCount.toString()

                }
            }
        }

        restartButton.setOnClickListener {
            tapButton1.setEnabled(true)
            tapButton2.setEnabled(true)
            number1 = 0
            number2 = 0
            timerCount = 10
            winner = "左の人"
            textView1.text = number1.toString()
            textView2.text = number2.toString()
            textView3.text = timerCount.toString()
            winnerLabel.text = ""
            startButton.setVisibility(View.INVISIBLE)
            restartButton.setVisibility(View.INVISIBLE)
        }

        tapButton1.setOnClickListener {
            number1 = number1 + 1
            textView1.text = number1.toString()
        }

        tapButton2.setOnClickListener {
            number2 = number2 + 1
            textView2.text = number2.toString()
        }

    }
}
