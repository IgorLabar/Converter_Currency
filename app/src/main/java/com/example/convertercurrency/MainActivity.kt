package com.example.convertercurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convertercurrency.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*
import kotlin.math.ceil

//Курсы валют по отношению к рублю
const val RATE_EUR = 70.00
const val RATE_USD = 64.00
const val RATE_JPY = 0.40

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculatedButton.setOnClickListener { convertCurrency() }
    }

    // Функиция для конвертированию в валюту
    private fun convertCurrency() {
        val editText = binding.EnterMoneyEditText.text.toString()
        val sum = editText.toDoubleOrNull() ?: return
        val currencyRate = when (binding.currencySelected.checkedRadioButtonId) {
            R.id.rate_eur -> RATE_EUR
            R.id.rate_jpy -> RATE_JPY
            else -> RATE_USD
        }

        //Расчет валюты
        var convert = sum / currencyRate
        val roundUp = binding.roundUpConvert.isChecked
        // Округление в большую строну
        if (roundUp) {
            convert = ceil(convert)
        }

        // Присваивание к каждой валюте знака
        val resultConvert = when (binding.currencySelected.checkedRadioButtonId) {
            R.id.rate_eur -> NumberFormat.getCurrencyInstance(Locale.GERMANY).format(convert)
            R.id.rate_jpy -> NumberFormat.getCurrencyInstance(Locale.JAPAN).format(convert)
            else -> NumberFormat.getCurrencyInstance().format(convert)
        }

        // Текст с итогами конвертации
        binding.resultConvert.text = getString(R.string.conversion_result_s, resultConvert)
    }
}