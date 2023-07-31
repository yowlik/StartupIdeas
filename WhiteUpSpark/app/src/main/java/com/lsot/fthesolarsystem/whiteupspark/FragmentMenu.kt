package com.lsot.fthesolarsystem.whiteupspark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.lsot.fthesolarsystem.whiteupspark.databinding.FragmentMenuBinding


class FragmentMenu : Fragment() {


    companion object{
        var stateStart="cafe"
    }

    lateinit var binding:FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMenuBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stateStart="cafe"
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //do nothing
                }
            })
        binding.apply {
            kafe.setOnClickListener {
                cafeState()
            }
            music.setOnClickListener {
                musicState()
            }
            you.setOnClickListener {
                youState()
            }
            conts.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentMenu_to_fragmentStartup)
            }
        }
    }

    private fun youState() {
        binding.sphere.text="Ты"
        stateStart="you"
        binding.aboutsphere.text="Узнай главное, что лучшее вложение которые можно сделать это"
    }

    private fun musicState() {
        binding.sphere.text="Музыка"
        stateStart="music"
        binding.aboutsphere.text="Найди способ совмещать полезное с приятным, если твоя сфера"
    }

    private fun cafeState() {
        binding.sphere.text="Кафе"
        stateStart="cafe"
        binding.aboutsphere.text="Узнай все новые способы, как достичь хороших результатов в сфере"
    }


}