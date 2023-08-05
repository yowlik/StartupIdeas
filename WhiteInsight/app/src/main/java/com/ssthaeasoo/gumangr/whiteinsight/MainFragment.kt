package com.ssthaeasoo.gumangr.whiteinsight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import com.ssthaeasoo.gumangr.whiteinsight.WelcomeFragment.Companion.yourname
import com.ssthaeasoo.gumangr.whiteinsight.WelcomeFragment.Companion.yourpol
import com.ssthaeasoo.gumangr.whiteinsight.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        var namer="Nike"
        var fullnamer="Nike"
        var percent="+1.5%"
        var fullpricer="1900"
    }
    lateinit var binding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
        onBack()
        val customItems = listOf(
            Item("Nike","Nike inc","+2%","170"),
            Item("Adidas","Adidas inc","+5%","194"),
            Item("BitSar","Bitici","-4.2%","40213"),
            Item("Malib","MaliSali","+5.3%","97"),
            Item("Corons","Corens inc","-1.5%","25"),
            Item("Eldorado","Elo city","+14.2%","36"),
            Item("Itherum","Ithe rum","+3.2%","1549"),
            Item("SounCla","Soundmus","+0.9%","11.4"),
            Item("Emiratori","Emir inc","-7.9%","190.2"),
            Item("Ambula","Amber umbr","+15%","316")
        )
        val adapter = ItemAdapter(requireContext(), customItems)
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = customItems[position]
                namer=selectedItem.name
                fullnamer=selectedItem.fullname
                percent=selectedItem.pers
                fullpricer=selectedItem.price
                findNavController().navigate(R.id.action_mainFragment_to_detailsFragment)
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

    private fun setView() {
        if(yourpol){
            binding.malefe.setBackgroundResource(R.drawable.man)
        }
        else{
            binding.malefe.setBackgroundResource(R.drawable.woman)
        }
        binding.namehello.text="$yourname, у нас есть несколько интересных наблюдений для вас"
    }

}