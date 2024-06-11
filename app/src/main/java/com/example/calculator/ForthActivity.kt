@file:Suppress("kt lint:standard:filename")

package com.example.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityForthBinding

class ForthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityForthBinding
    private var firstInput: String = ""
    private var secondInput: String = ""
    private var result: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//       firstInput
        binding.inputLayoutId.firstInput.setOnClickListener {
            Toast.makeText(this, "input your first value", Toast.LENGTH_SHORT).show()
        }

        binding.parentButtonLayout.circularSevenButton.setOnClickListener {
            firstInput = firstInput.plus("7")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularEightButton.setOnClickListener {
            firstInput = firstInput.plus("8")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularNineButton.setOnClickListener {
            firstInput = firstInput.plus("9")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularFourButton.setOnClickListener {
            firstInput = firstInput.plus("4")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularFiveButton.setOnClickListener {
            firstInput = firstInput.plus("5")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularSixButton.setOnClickListener {
            firstInput = firstInput.plus("6")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularOneButton.setOnClickListener {
            firstInput = firstInput.plus("1")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularTwoButton.setOnClickListener {
            firstInput = firstInput.plus("2")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularThreeButton.setOnClickListener {
            firstInput = firstInput.plus("3")
            binding.inputLayoutId.firstInput.text = firstInput
        }
        binding.parentButtonLayout.circularZeroButton.setOnClickListener {
            firstInput = firstInput.plus("0")
            binding.inputLayoutId.firstInput.text = firstInput
        }

//        secondInput
    }
}
