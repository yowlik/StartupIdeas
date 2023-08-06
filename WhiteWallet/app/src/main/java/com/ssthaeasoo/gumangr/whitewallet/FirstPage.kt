package com.ssthaeasoo.gumangr.whitewallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ssthaeasoo.gumangr.whitewallet.databinding.FragmentFirstPageBinding


class FirstPage : Fragment() {
    companion object {
        var namer=""
        var fullnamer=""
        var perc=""
        var fullpricer=""
        var imas=1
    }

    lateinit var binding:FragmentFirstPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentFirstPageBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBack()
        val items = listOf(
            Item(R.drawable.graph1,"Adas","ADA","+2%","134"),
            Item(R.drawable.graph2,"Bina","BN","+5%","1391"),
            Item(R.drawable.graph3,"Famo","FAM","+4.2%","37"),
            Item(R.drawable.graph4,"Mira","MRS","+5.3%","197"),
            Item(R.drawable.graph5,"Salo","SAL","+1.5%","325"),
            Item(R.drawable.graph6,"Kror","KRO","+14.2%","136"),
            Item(R.drawable.graph7,"Ethe","EET","+3.2%","1049"),
            Item(R.drawable.graph8,"Masa","MAS","+0.98%","1154"),
            Item(R.drawable.graph9,"Emir","EMR","+2.9%","19"),
        )
        val adapter = WalletAdapter(requireContext(), items)
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = items[position]
                namer=selectedItem.name
                fullnamer=selectedItem.fullname
                perc=selectedItem.pers
                fullpricer=selectedItem.price
                imas=selectedItem.gras
                findNavController().navigate(R.id.action_firstPage_to_secondPage)
            }
    }

    private fun onBack(){
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    requireActivity().finishAffinity()
                }
            })
    }


}