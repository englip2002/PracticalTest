package my.edu.tarc.practicaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import my.edu.tarc.practicaltest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener{
            val totalTax: Double
            val carRegNum = binding.editRegNum.text.toString()
            val engineCap = Integer.parseInt(binding.editEngineCap.text.toString())
            val state = binding.StateSpinner.selectedItemPosition

            if(state == 0){
                totalTax = if(engineCap <= 1000){
                    20.0
                } else if(engineCap<=1200){
                    55.0
                } else if(engineCap<=1400){
                    70.0
                } else if(engineCap<=1600){
                    90.0
                } else{
                    200.0
                }
            }
            else{
                totalTax = if(engineCap <= 1000){
                    20.0
                } else if(engineCap<=1200){
                    44.0
                } else if(engineCap<=1400){
                    56.0
                } else if(engineCap<=1600){
                    72.0
                } else{
                    160.0
                }
            }

            binding.myCar = Car(state, totalTax)
        }

        binding.resetButton.setOnClickListener{
            binding.editEngineCap.setText("")
            binding.editRegNum.setText("")
            binding.myCar=Car(0,0.0)
        }

        binding.ContactButton.setOnClickListener{
            if(binding.emailTextView.visibility==View.INVISIBLE){
                binding.emailTextView.visibility= View.VISIBLE
                binding.phoneTextView.visibility=View.VISIBLE
            }
            else{
                binding.emailTextView.visibility= View.INVISIBLE
                binding.phoneTextView.visibility=View.INVISIBLE
            }

        }
    }
}