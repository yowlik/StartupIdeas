package com.antrazzitstssss.whitestartupid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.antrazzitstssss.whitestartupid.databinding.FragmentScreenMenuBinding


class ScreenMenu : Fragment() {


    companion object{
        var theme=0
    }
    lateinit var binding:FragmentScreenMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentScreenMenuBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickText()
        backPressed()
        onClick()

    }



    private fun backPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //blocked
                }
            })
    }
    private fun onClickText(){
        binding.apply {
            text1.setOnClickListener {
                theme=1
                findNavController().navigate(R.id.action_screenMenu_to_screenDetails)
            }
            text2.setOnClickListener {
                theme=2
                findNavController().navigate(R.id.action_screenMenu_to_screenDetails)
            }
            text3.setOnClickListener {
                theme=3
                findNavController().navigate(R.id.action_screenMenu_to_screenDetails)
            }
        }
    }

    private fun onClick(){
        binding.apply {
            view1.setOnClickListener {
                theme=1
                findNavController().navigate(R.id.action_screenMenu_to_screenDetails)
            }
            view2.setOnClickListener {
                theme=2
                findNavController().navigate(R.id.action_screenMenu_to_screenDetails)
            }
            view3.setOnClickListener {
                theme=3
                findNavController().navigate(R.id.action_screenMenu_to_screenDetails)
            }
        }
    }


}