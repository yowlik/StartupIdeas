package com.barabaraberi.whitecurency

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.utils.widget.MotionButton
import androidx.navigation.fragment.findNavController
import com.barabaraberi.whitecurency.Menu.Companion.country1
import com.barabaraberi.whitecurency.Menu.Companion.country2
import com.barabaraberi.whitecurency.Menu.Companion.digit1
import com.barabaraberi.whitecurency.Menu.Companion.digit2
import com.barabaraberi.whitecurency.databinding.FragmentDetailsBinding


class Details : Fragment() {
    private var inputNumber: String = ""
    lateinit var binding:FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstcount.setBackgroundResource(country1)
        binding.secondcount.setBackgroundResource(country2)
        for (i in 0 until binding.gridLayout.childCount) {
            val child = binding.gridLayout.getChildAt(i)
            if (child is MotionButton) {
                child.setOnClickListener { handleButtonClick(it) }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_details_to_menu)
                }
            })
    }

    private fun handleButtonClick(view: View) {
        when (view.id) {
            R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eigh, R.id.nine -> {
                val number = view.tag.toString()
                inputNumber += number
                updateTopTextView()
            }
            R.id.back -> {
                if (inputNumber.isNotEmpty()) {
                    inputNumber = inputNumber.substring(0, inputNumber.length - 1)
                    updateTopTextView()
                }
            }
        }

        if (inputNumber.isNotEmpty()) {
            val inputValue = inputNumber.toInt()
            val divider=digit1.toInt()/digit2.toInt()
            if(divider==0){
                val result=inputValue*(digit2.toInt()/digit1.toInt())
                binding.secDig.text = result.toString()
            }
            else{
                val result = inputValue / divider
                binding.secDig.text = result.toString()
            }
        } else {
            binding.secDig.text = "0"
        }
    }

    private fun updateTopTextView() {
        binding.firstDig.text = inputNumber
    }


}