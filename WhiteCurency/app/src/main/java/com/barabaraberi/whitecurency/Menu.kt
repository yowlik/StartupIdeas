package com.barabaraberi.whitecurency

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.barabaraberi.whitecurency.databinding.FragmentMenuBinding


class Menu : Fragment() {

    companion object{
        var country1=R.drawable.usa
        var country2=R.drawable.russia
        var digit1="1"
        var digit2="70"
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
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //blocked
                }
            })
        val customItems = listOf(
            CustomItem("70", "1", R.drawable.russia, R.drawable.usa),
            CustomItem("1", "70", R.drawable.usa, R.drawable.russia),
            CustomItem("1", "23", R.drawable.australia, R.drawable.russia),
            CustomItem("23", "1", R.drawable.russia, R.drawable.australia),
            CustomItem("1", "3", R.drawable.usa, R.drawable.australia),
            CustomItem("3", "1", R.drawable.australia, R.drawable.usa),
            CustomItem("1", "85", R.drawable.germany, R.drawable.russia),
            CustomItem("85", "1", R.drawable.russia, R.drawable.germany),
        )
        val adapter = CustomAdapter(requireContext(), customItems)
        binding.listView.adapter = adapter
        binding.listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val selectedItem = customItems[position]
                country1=selectedItem.im1
                country2=selectedItem.im2
                digit1=selectedItem.num1
                digit2=selectedItem.num2
                findNavController().navigate(R.id.action_menu_to_details)
            }
    }


}