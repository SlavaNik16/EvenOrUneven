package com.example.evenoruneven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.evenoruneven.databinding.FragmentComputerBinding
import com.example.evenoruneven.databinding.FragmentPlayerBinding
import kotlin.random.Random

class PlayerFragment : Fragment() {
    lateinit var binding: FragmentPlayerBinding

    var n = 3
    private var radio = 0;
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.radioPlayerEven.setOnClickListener{
            dataModel.txtEvenCheckForPlayerFragment.value = true
            radio = 1
        }
        binding.radioPLayerUneven.setOnClickListener{
            dataModel.txtUnevenCheckForPlayerFragment.value = true
            radio = 2
        }

        dataModel.butStartClickFragment.observe(activity as LifecycleOwner, {
            if(it == true)
                GameStart()
            else
                GameRestart()
        })

    }
    companion object {
        @JvmStatic
        fun newInstance() = PlayerFragment()
    }

    private fun GameStart(){
        binding.radioPlayerEven.isEnabled = false
        binding.radioPLayerUneven.isEnabled = false
        var randomList: RandomList = RandomList()
        var listOrSum: Pair<String,Int> = randomList.RandomListOrSum(n)
        var result = ValidateImage(listOrSum.second, binding)
        binding.txtCountPlayer.text =
            (binding.txtCountPlayer.text.toString().toInt() + result).toString()
        binding.txtListNumberPlayer.text = listOrSum.first
        binding.txtSumPlayer.text = listOrSum.second.toString()
    }

    private fun GameRestart(){
        binding.txtListNumberPlayer.text = "0 0 0"
        binding.txtSumPlayer.text = "0"
        binding.radioPlayerEven.isEnabled = true
        binding.radioPLayerUneven.isEnabled = true
        binding.ImagePlayerEven.isVisible = false
        binding.ImagePlayerUneven.isVisible = false
    }

    private fun ValidateImage(sum: Int, binding: FragmentPlayerBinding): Int{
        if(radio == 1){
            binding.ImagePlayerEven.isVisible = true
            if(sum % 2 == 0){
                binding.ImagePlayerEven.setImageResource(R.drawable.okimage)
                return 1
            }else{
                binding.ImagePlayerEven.setImageResource(R.drawable.notimage)
            }
        }else{
            binding.ImagePlayerUneven.isVisible = true
            if(sum % 2 != 0){
                binding.ImagePlayerUneven.setImageResource(R.drawable.okimage)
                return 1
            }else{
                binding.ImagePlayerUneven.setImageResource(R.drawable.notimage)
            }
        }
        return 0
    }
}