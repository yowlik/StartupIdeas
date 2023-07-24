package com.antrazzitstssss.whitestartupid

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.antrazzitstssss.whitestartupid.databinding.FragmentFirstScreenBinding


class FirstScreen : Fragment() {
    lateinit var binding:FragmentFirstScreenBinding
    var agr=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        pressed()
        binding=FragmentFirstScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick(){
        val sharedPref=requireContext().getSharedPreferences("Fragment", Context.MODE_PRIVATE)
        val open=sharedPref.getString("OPEN","false")
        if(open=="true"){
            findNavController().navigate(R.id.action_firstScreen_to_screenMenu)
        }
        binding.apply {
            agree.setOnClickListener {
                if(agr==1){
                    agree.setImageResource(0)
                    agr=0
                }
                else{
                    agr=1
                    agree.setImageResource(R.drawable.baseline_check_24)
                }
            }
            motionButton.setOnClickListener {
                if(agr==1){
                    val editor=sharedPref.edit()
                    editor.putString("OPEN","true")
                    editor.apply()
                    findNavController().navigate(R.id.action_firstScreen_to_screenMenu)
                }
            }
            textView.setOnClickListener {
                //Тут политика, добавишь редирект в браузер или переход вебвью
            }
        }
    }
    private fun pressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //blocked
                }
            })
    }


}