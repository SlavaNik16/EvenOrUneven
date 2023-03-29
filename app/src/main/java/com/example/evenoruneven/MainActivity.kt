package com.example.evenoruneven

import android.app.Instrumentation.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.evenoruneven.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butStart.isEnabled = false
        dataModel.butStartClickFragment.value = false
        openFrag(ComputerFragment.newInstance(), R.id.frameComputer);
        openFrag(PlayerFragment.newInstance(), R.id.framePlayer);

        dataModel.txtEvenCheckForPlayerFragment.observe(this,{
            binding.butStart.isEnabled = it
        })
        dataModel.txtUnevenCheckForPlayerFragment.observe(this,{
            binding.butStart.isEnabled = it
        })
    }

    private fun openFrag(f:Fragment, idHolder:Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }

    fun butStart(view: View){

        if(binding.butStart.text == "Играть") {
            dataModel.butStartClickFragment.value = true
            binding.butStart.text = "Продолжить"
        }else{
            dataModel.butStartClickFragment.value = false
            binding.butStart.text = "Играть"
        }
    }
}