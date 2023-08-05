package com.ssthaeasoo.gumangr.whiteinsight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ssthaeasoo.gumangr.whiteinsight.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    lateinit var binding:FragmentWelcomeBinding

    companion object{
        var yourname="Gasd"
        var yourpol=true
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentWelcomeBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBack()
        binding.mans.setOnClickListener {
            binding.mans.isChecked=true
            binding.womans.isChecked=false
            yourpol=true
        }
        binding.womans.setOnClickListener {
            binding.mans.isChecked=false
            binding.womans.isChecked=true
            yourpol=false
        }
        binding.contins.setOnClickListener {
            if(binding.entername.text.toString()=="null"||binding.entername.text.toString()==""){
                Snackbar.make(it, "Вы не записали имя!", Snackbar.LENGTH_SHORT).show()
            }
            else{
                yourname=binding.entername.text.toString()
                findNavController().navigate(R.id.action_welcomeFragment_to_mainFragment)
            }
        }
    }
    private fun onBack(){
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //blocked
                }
            })
    }


}