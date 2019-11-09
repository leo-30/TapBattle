package app.harada.leo.tapbattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    var number1: Int = 0
    var number2: Int = 0
    var timerCount: Int = 10
    val handler: Handler = Handler()
    var winner: String = "Player1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1.text = "0"
        textView2.text = "0"

        winnerLabel.text = ""

        startButton.setOnClickListener {
            timer(period = 1000) {
                handler.post {
                    timerCount--

                    if (timerCount <= 0) {
                        timerCount = 0
                        textView3.text = timerCount.toString()

                        if (number2 > number1) {
                            winner = "Player2"
                        } else if (number1 == number2) {
                            winner = "どっちも"
                        }

                        winnerLabel.text = "勝者は" + winner + "！"

                        winner = "Player1"
/*
                        AlertDialog.Builder(this)
                            .setTitle("Finish!")
                            .setMessage("勝者は")
                            .setPositiveButton("もう一度プレイ") { dialog, which ->
                                // もう一度プレイが押された時の挙動
                                number1 = 0
                                number2 = 0
                                timerCount = 10
                                winner = "Player1"
                            }
                            .setIcon(R.mipmap.ic_launcher)
                            .show()
                            */
                    }

                    textView3.text = timerCount.toString()

                }
            }
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
