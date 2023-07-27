package com.smassleseees.whitemorph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.utils.widget.MotionButton
import androidx.navigation.fragment.findNavController
import com.smassleseees.whitemorph.databinding.Fragment1Binding


class Fragment1 : Fragment() {
    companion object{
        var valut1="sc"
        var valut2="sc"
    }

    lateinit var binding: Fragment1Binding
    var click=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= Fragment1Binding.inflate(layoutInflater,container,false)
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
        for (i in 0 until binding.gridLayout.childCount) {
            val child = binding.gridLayout.getChildAt(i)
            if (child is MotionButton) {
                child.setOnClickListener { handleButtonClick(it) }
            }
        }

    }

    private fun handleButtonClick(view: View) {
        if(click==0){
            click=1
            valut1=view.tag.toString()
            binding.numdeist.text="Выберите вторую валюту"
        }
        else{
            valut2=view.tag.toString()
            findNavController().navigate(R.id.action_fragment1_to_fragment2)
        }
    }


}