package com.ssthaeasoo.gumangr.whiteinsight

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.ssthaeasoo.gumangr.whiteinsight.MainFragment.Companion.fullnamer
import com.ssthaeasoo.gumangr.whiteinsight.MainFragment.Companion.fullpricer
import com.ssthaeasoo.gumangr.whiteinsight.MainFragment.Companion.namer
import com.ssthaeasoo.gumangr.whiteinsight.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

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
        setPrice()
        setName()
        setImage()
        setOnClick()
    }

    private fun setOnClick() {
        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_mainFragment)
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //blocked
                }
            })
    }

    private fun setImage() {
        val graph= arrayListOf<Int>(R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.fourth,R.drawable.five,R.drawable.nine)
        binding.graphic.setBackgroundResource(graph.random())
    }

    private fun setName() {
        binding.apply {
            companyname.text=namer
            comanyfullname.text=fullnamer
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setPrice() {
        val cena= fullpricer.toFloat()
        binding.apply {
            price.text=fullpricer
            lowprice.text="${cena-10}"
            highprice.text="${cena+20}"
            openprice.text="${cena-2}"
            wolprice.text="${cena-11}B"
        }
    }


}