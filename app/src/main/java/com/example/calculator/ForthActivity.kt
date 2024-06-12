@file:Suppress("kt lint:standard:filename")

package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityForthBinding

class ForthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForthBinding
    private var firstInput: String = ""
    private var secondInput: String = ""
    private var isFirstInputFocuse: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("log404", "onCreate: ")
        binding = ActivityForthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.inputLayoutId.firstInput.setOnClickListener {
            isFirstInputFocuse = true

            Toast.makeText(this, "input your first value", Toast.LENGTH_SHORT).show()
        }

        binding.inputLayoutId.secondInput.setOnClickListener {
            isFirstInputFocuse = false
            Toast.makeText(this, "input your second value", Toast.LENGTH_SHORT).show()
        }

        binding.parentButtonLayout.circularSevenButton.setOnClickListener {
            setValueInputField("7", isFirstInputFocuse)
        }

        binding.parentButtonLayout.circularEightButton.setOnClickListener {
            setValueInputField("8", isFirstInputFocuse)
        }

        binding.parentButtonLayout.circularNineButton.setOnClickListener {
            setValueInputField("9", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularFourButton.setOnClickListener {
            setValueInputField("4", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularFiveButton.setOnClickListener {
            setValueInputField("5", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularSixButton.setOnClickListener {
            setValueInputField("6", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularOneButton.setOnClickListener {
            setValueInputField("1", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularTwoButton.setOnClickListener {
            setValueInputField("2", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularThreeButton.setOnClickListener {
            setValueInputField("3", isFirstInputFocuse)
        }
        binding.parentButtonLayout.circularZeroButton.setOnClickListener {
            setValueInputField("0", isFirstInputFocuse)
        }

        binding.parentButtonLayout.circularPlusButton.setOnClickListener {
            plusButton()
        }
        binding.parentButtonLayout.circularMinusButton.setOnClickListener {
            minusButton()
        }
        binding.parentButtonLayout.circularMultiplyButton.setOnClickListener {
            multiplyButton()
        }
        binding.parentButtonLayout.circularClearButton.setOnClickListener {
            clearInputs()
        }
        binding.parentButtonLayout.circularDivideButton.setOnClickListener {
            divideButton()
        }
        binding.parentButtonLayout.circularPercentButton.setOnClickListener {
            percentButton()
        }
    }

    private fun setValueInputField(
        value: String,
        firstInputFocuse: Boolean,
    ) {
        Toast.makeText(this, firstInputFocuse.toString(), Toast.LENGTH_SHORT).show()
        if (firstInputFocuse) {
            firstInput = firstInput.plus(value)
            binding.inputLayoutId.firstInput.text = firstInput
        } else {
            secondInput = secondInput.plus(value)
            binding.inputLayoutId.secondInput.text = secondInput
        }
    }

    private fun clearInputs() {
        firstInput = ""
        secondInput = ""
        binding.inputLayoutId.firstInput.text = ""
        binding.inputLayoutId.secondInput.text = ""
        binding.result.text = ""
    }

    fun plusButton() {
        val firstNumber = firstInput.toDouble()
        val secondNumber = secondInput.toDouble()
        val result = firstNumber + secondNumber
        binding.result.text = result.toString()
    }

    fun minusButton() {
        val firstNumber = firstInput.toDouble()
        val secondNumber = secondInput.toDouble()
        val result = firstNumber - secondNumber
        binding.result.text = result.toString()
    }

    fun multiplyButton() {
        val firstNumber = firstInput.toDouble()
        val secondNumber = secondInput.toDouble()
        val result = firstNumber * secondNumber
        binding.result.text = result.toString()
    }

    fun divideButton() {
        val firstNumber = firstInput.toDouble()
        val secondNumber = secondInput.toDouble()
        val result = firstNumber / secondNumber
        binding.result.text = result.toString()
    }

    fun percentButton() {
        val firstNumber = firstInput.toDouble()
        val secondNumber = secondInput.toDouble()
        val result = firstNumber % secondNumber
        binding.result.text = result.toString()
    }

    override fun onStart() {
        super.onStart()
        Log.d("log404", "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Open the screen", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("log404", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("log404", "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("log404", "onRestart: ")
    }

    override fun onDestroy() {
        Toast.makeText(this, "Close the screen", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}
