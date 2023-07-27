package com.smassleseees.whitemorph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.smassleseees.whitemorph.Fragment1.Companion.valut1
import com.smassleseees.whitemorph.Fragment1.Companion.valut2
import com.smassleseees.whitemorph.databinding.Fragment1Binding
import com.smassleseees.whitemorph.databinding.Fragment2Binding
import java.text.NumberFormat
import java.util.Locale


class Fragment2 : Fragment() {


    lateinit var binding: Fragment2Binding
    var div=0
    var div2=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= Fragment2Binding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //blocked
                }
            })
        binding.firstval.text=valut1
        binding.secondval.text=valut2
        div=(1..20).random()
        div2=(1..20).random()
        binding.convert.setOnClickListener {
            calculateSum()
        }
        binding.view.setOnClickListener { findNavController().navigate(R.id.action_fragment2_to_fragment1) }

    }

    private fun calculateSum() {
        val billAmount = binding.enternum.text.toString().toDoubleOrNull()
        if (billAmount == null || billAmount <= 0) {
            binding.resultnum.text = "Введите правильную сумму"
            return
        }
        val tipAmount = (billAmount *div)/div2
        val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
        val formattedTipAmount = numberFormat.format(tipAmount)

        binding.resultnum.text = "$formattedTipAmount"
    }


}