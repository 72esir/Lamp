package com.example.lampochka.presenter

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.widget.Toast
import coil.load

import com.example.lampochka.R
import com.example.lampochka.databinding.FragmentMainBinding
import com.example.lampochka.di.DaggerAppComponent
import com.example.lampochka.di.viewModel.ViewModelFactory

import dev.androidbroadcast.vbpd.viewBinding
import javax.inject.Inject

class MainFragment: Fragment(R.layout.fragment_main) {
    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MainViewModel by viewModels{viewModelFactory}

    override fun onAttach(context: Context) {
        val component = DaggerAppComponent.create()
        component.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnTurnOn.setOnClickListener {
            viewModel.turnOn()
        }

        binding.btnTurnOff.setOnClickListener {
            viewModel.turnOff()
        }

        binding.btnGetBrightnessLevel.setOnClickListener{
            viewModel.getBrightness()
        }

        binding.btnGetCurrentBrightness.setOnClickListener {
            viewModel.getCurrentBrightness()
        }

        binding.btnGetColors.setOnClickListener {
            viewModel.getColors()
        }

        binding.btnGetCurrentColor.setOnClickListener {
            viewModel.getCurrentColor()
        }

        binding.btnGetColorNames.setOnClickListener {
            viewModel.getColorNames()
        }

        binding.btnSetColor.setOnClickListener {
            val colorName = binding.editColor.text.toString().trim()
            if (colorName.isNotEmpty()) {
                viewModel.setColor(colorName)
            } else {
                binding.statusText.text = "Введите название цвета"
            }
        }

        binding.btnSetBrightness.setOnClickListener {
            val input = binding.editBrightness.text.toString().toIntOrNull()
            if (input != null && input in 0..100) {
                viewModel.setBrightness(input)
            } else {
                binding.statusText.text = "Введите число от 0 до 100"
            }
        }



        viewModel.response.observe(viewLifecycleOwner) { message ->
            binding.statusText.text = message
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            binding.statusText.text = errorMsg
            Toast.makeText(requireContext(), errorMsg, Toast.LENGTH_LONG).show()
        }



        super.onViewCreated(view, savedInstanceState)
    }
}