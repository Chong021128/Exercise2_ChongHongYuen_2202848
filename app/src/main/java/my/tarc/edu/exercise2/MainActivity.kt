package my.tarc.edu.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import my.tarc.edu.exercise2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            val weight = binding.weight.text.toString().toFloat()
            val height = binding.height.text.toString().toFloat()
            val total : Float = weight/(height*height)


            if(total <18.5){
                binding.total.text = String.format("%.2f", total)
                binding.bmi.text = "Underweight"
                binding.value.text = "Below 18.5"
                binding.imageViewResult.setImageResource(R.drawable.under)
            }else if(total >= 18.5 && total <= 24.9){
                binding.total.text = String.format("%.2f", total)
                binding.bmi.text = "Normal"
                binding.value.text = "18.5 - 24.9"
                binding.imageViewResult.setImageResource(R.drawable.normal)
            }else if(total > 25){
                binding.total.text = String.format("%.2f", total)
                binding.bmi.text = "Overweight"
                binding.value.text = "More than 25"
                binding.imageViewResult.setImageResource(R.drawable.over)
            }

        }

        binding.buttonReset.setOnClickListener{
            binding.weight.text.clear()
            binding.height.text.clear()
            binding.total.text = ""
            binding.bmi.text = ""
            binding.value.text = ""
            binding.imageViewResult.setImageResource(R.drawable.empty)

        }

    }
}