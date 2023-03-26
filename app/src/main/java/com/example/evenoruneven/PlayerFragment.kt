package com.example.evenoruneven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.evenoruneven.databinding.FragmentComputerBinding
import com.example.evenoruneven.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {
    lateinit var binding: FragmentPlayerBinding
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
        }
        binding.radioPLayerUneven.setOnClickListener{
            dataModel.txtUnevenCheckForPlayerFragment.value = true
        }

    }
    companion object {
        @JvmStatic
        fun newInstance() = PlayerFragment()
    }

}