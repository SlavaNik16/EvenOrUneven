package com.example.evenoruneven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.evenoruneven.databinding.FragmentComputerBinding

class ComputerFragment : Fragment() {
    lateinit var binding: FragmentComputerBinding
    private val dataModel: DataModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentComputerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.CountForCompFragment.observe(activity as LifecycleOwner){
            binding.txtCountComp.text = it
        }

        dataModel.txtEvenCheckForCompFragment.observe(activity as LifecycleOwner){
            binding.radioComEven.isChecked = it
        }
        dataModel.txtUnevenCheckForCompFragment.observe(activity as LifecycleOwner){
            binding.radioComUneven.isChecked = it
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = ComputerFragment()
    }
}