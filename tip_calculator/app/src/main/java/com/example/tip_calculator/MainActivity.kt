package com.example.tip_calculator

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.tip_calculator.databinding.ActivityMainBinding
import java.util.Calendar
import kotlin.math.ceil
import kotlin.math.cos
import kotlin.math.roundToInt

open class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.calculateBtn.setOnClickListener {
            if (binding.costEd.text.isNullOrEmpty()){
                binding.costEd.error = "cost is empty"
            }else{
                binding.timeTv.text = Calendar.getInstance().time.toString()
                binding.costResultTv.text = calculateTip(binding.costEd.text.toString().toDouble()).toString()
                binding.costEd.setText("")
                closeKeyboard(it)
            }
        }

    }

    private fun closeKeyboard(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun calculateTip(cost : Double) : Double {

        var result = 0.0

        result = when(binding.tipOptions.checkedRadioButtonId){
            R.id.amazing_20_rb ->{
                cost * 20 / 100
            }
            R.id.good_18_rb->{
                cost * 18 / 100
            }
            else->{
                cost * 15 / 100
            }

        }

        if (binding.roundUpSw.isChecked){
            result = result.roundToInt().toDouble()
        }

        return result

    }
}
