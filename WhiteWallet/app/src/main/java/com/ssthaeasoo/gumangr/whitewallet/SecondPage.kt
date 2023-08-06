package com.ssthaeasoo.gumangr.whitewallet

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ssthaeasoo.gumangr.whitewallet.FirstPage.Companion.fullnamer
import com.ssthaeasoo.gumangr.whitewallet.FirstPage.Companion.fullpricer
import com.ssthaeasoo.gumangr.whitewallet.FirstPage.Companion.imas
import com.ssthaeasoo.gumangr.whitewallet.FirstPage.Companion.namer
import com.ssthaeasoo.gumangr.whitewallet.FirstPage.Companion.perc
import com.ssthaeasoo.gumangr.whitewallet.databinding.FragmentSecondPageBinding


class SecondPage : Fragment() {


    lateinit var binding:FragmentSecondPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSecondPageBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAllVariable()
        onBack()
    }

    @SuppressLint("SetTextI18n")
    private fun setAllVariable() {
        binding.apply {
            minvalue.text="мин. цена ${fullpricer.toInt()-15}"
            maxvalue.text="макс. цена ${fullpricer.toInt()+13}"
            namemonet.text="$namer/$fullnamer"
            percent.text=perc
            scheme.setBackgroundResource(imas)
            popularity.text="#${(1..100).random()}"
            capital.text="${(10..32).random()}B"

        }
    }
    private fun onBack(){
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_secondPage_to_firstPage)
                }
            })
    }


}