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

class ComputerFragment : Fragment() {
    lateinit var binding: FragmentComputerBinding
    var n = 3
    var radio = 0
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComputerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.butStartClickFragment.observe(activity as LifecycleOwner, {
            if(it == true)
                GameStart()
            else
                GameRestart()
        })
    }
    private fun GameStart(){
        radio = (1..2).random()

        var randomList: RandomList = RandomList()
        var listOrSum = randomList.RandomListOrSum(n)
        var result = ValidateImageChecked(listOrSum.second, binding)
        binding.txtCountComp.text =
            (binding.txtCountComp.text.toString().toInt() + result).toString()
        binding.txtListNumberCom.text = listOrSum.first
        binding.txtSumCom.text = listOrSum.second.toString()
    }

    private fun GameRestart(){
        binding.txtListNumberCom.text = "0 0 0"
        binding.txtSumCom.text = "0"
        binding.ImageComEven.isVisible = false
        binding.ImageComUneven.isVisible = false

        binding.radioComEven.isChecked = false
        binding.radioComUneven.isChecked = false
    }

    private fun ValidateImageChecked(sum: Int, binding: FragmentComputerBinding): Int{
        if(radio == 1){
            binding.ImageComEven.isVisible = true
            binding.radioComEven.isChecked = true
            if(sum % 2 == 0){
                binding.ImageComEven.setImageResource(R.drawable.okimage)
                return 1
            }else{
                binding.ImageComEven.setImageResource(R.drawable.notimage)
            }
        }else{
            binding.radioComUneven.isChecked = true
            binding.ImageComUneven.isVisible = true
            if(sum % 2 != 0){
                binding.ImageComUneven.setImageResource(R.drawable.okimage)
                return 1
            }else{
                binding.ImageComUneven.setImageResource(R.drawable.notimage)
            }
        }
        return 0
    }
    companion object {

        @JvmStatic
        fun newInstance() = ComputerFragment()
    }
}