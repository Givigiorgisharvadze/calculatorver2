package com.example.calculatori

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0

    private var operataion: String = ""

    private var operand1: Int = 0

    private var secOperand1: Int = 0

    private var operation1: String = ""

    private var resultText: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)


    }

    fun numberClick(clickedView: View) {

        if (clickedView is TextView) {

            val number: String = clickedView.text.toString()

            val resultText: String = resultTextView.text.toString()

            resultTextView.text = resultText + number

        }

    }

    fun operationClick(view: View) {

        if (view is TextView) {

            val result: String = resultTextView.text.toString()

            if (result.isNotEmpty()) {

                this.operand = result.toDouble()

            }

            resultTextView.text = ""

            this.operataion = view.text.toString()

        }

    }

    fun equalsClick(view: View) {

        val secOperandText: String = resultTextView.text.toString()

        var secOperand: Double = 0.0

        if (secOperandText.isNotEmpty()) {

            secOperand = secOperandText.toDouble()

        }

        when (this.operataion) {

            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "a^n" -> resultTextView.text = (Math.pow(operand, secOperand)).toString()
            "n√a" -> resultTextView.text = (Math.pow( secOperand, 1 / operand)).toString()
            "C" -> resultTextView.text = ""

        }

    }


}