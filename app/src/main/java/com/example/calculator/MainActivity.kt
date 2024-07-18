package com.example.calculator

// MainActivity.kt


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentInput: String = ""
    private var operator: String = ""
    private var firstOperand: Double = 1.0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        currentInput += button.text
        updateResultText()
    }

    fun onOperatorClick(view: View) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            operator = (view as Button).text.toString()
            currentInput = ""
        }
    }

    fun onEqualsClick(view: View) {
        if (currentInput.isNotEmpty()) {
            val secondOperand = currentInput.toDouble()
            val result = performOperation(firstOperand, secondOperand, operator)
            currentInput = result.toString()
            updateResultText()
        }
    }

    fun onClearClick(view: View) {
        currentInput = ""
        firstOperand = 0.0
        operator = ""
        updateResultText()
    }


    // Inside the MainActivity class
    private fun performOperation(firstOperand: Double, secondOperand: Double, operator: String): Double {
        return when (operator) {
            "+" -> firstOperand + secondOperand
            "-" -> firstOperand - secondOperand
            "*" -> firstOperand * secondOperand
            "/" -> firstOperand / secondOperand
            "%" -> firstOperand % secondOperand  // Add modulo operation
            else -> throw IllegalArgumentException("Invalid operator")
        }
    }

    private fun updateResultText() {
        resultTextView.text = currentInput
    }
}
