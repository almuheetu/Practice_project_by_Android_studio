package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var firstValue: Double = 0.0
    private var secondValue: Double = 0.0
    private var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.plusButton.setOnClickListener {
            if (checkInputIsValid()
            ) {
                result = firstValue + secondValue
            }
        }

        binding.minusButton.setOnClickListener {
            if (checkInputIsValid()
            ) {
                result = firstValue - secondValue
            }
        }

        binding.multiplyButton.setOnClickListener {
            if (
                checkInputIsValid()
            ) {
                result = firstValue * secondValue
            }
        }

        binding.divideButton.setOnClickListener {
            if (checkInputIsValid()
            ) {
                if (secondValue != 0.0) {
                    result = firstValue / secondValue
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.Cannot_divide_by_zero),
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        }

        binding.clearButton.setOnClickListener {
            binding.etTest.text.clear()
            binding.etSecondTest.text.clear()
            binding.etResult.text = ""
        }

        binding.equalBtn.setOnClickListener {
            binding.etResult.text = String.format(locale = Locale.US, "%.2f", result)
        }

        binding.secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkInputIsValid(): Boolean {
        return if (
            binding.etTest.text.toString().isNotEmpty() &&
            binding.etSecondTest.text.toString().isNotEmpty()
        ) {
            firstValue = binding.etTest.text.toString().toDouble()
            secondValue = binding.etSecondTest.text.toString().toDouble()
            true
        } else {
            Toast.makeText(this, getString(R.string.enter_input_value), Toast.LENGTH_SHORT).show()
            false
        }
    }
}
