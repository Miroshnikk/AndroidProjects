package com.project5

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.View.OnLongClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnAttach
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.lifecycle.viewmodel.CreationExtras
import com.project5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var COUNT = 0

        binding.textCount.text="Count: $COUNT"

        binding.buttonPlusOne.setOnClickListener(){
            COUNT++
            binding.textCount.text="Count: $COUNT"
            binding.root.focusable
        }

        binding.buttonPlusTen.setOnLongClickListener(){
            COUNT+=10
            binding.textCount.text="Count: $COUNT"
            binding.root.focusable
            true
        }


        binding.switchDisable.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){

                binding.buttonPlusOne.visibility = View.INVISIBLE
                binding.buttonPlusTen.visibility = View.INVISIBLE


            }else{

                binding.buttonPlusOne.visibility = View.VISIBLE
                binding.buttonPlusTen.visibility = View.VISIBLE

            }
            true
        }


        binding.editTextNumberDecimal.doAfterTextChanged {
            if(binding.editTextNumberDecimal.text.length>0) {
                COUNT = Integer.parseInt(binding.editTextNumberDecimal.text.toString());
            }else {COUNT=0}
                binding.textCount.text="Count: $COUNT"

        }

        binding.editTextNumberDecimal.doBeforeTextChanged { text, start, count, after ->

            if (text != null) {
                if(text.isEmpty())
                {
                    false
                }

            }
        }


    }
    
}