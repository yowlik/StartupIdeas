package com.lsot.fthesolarsystem.whiteupspark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.lsot.fthesolarsystem.whiteupspark.FragmentMenu.Companion.stateStart
import com.lsot.fthesolarsystem.whiteupspark.databinding.FragmentStartupBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class FragmentStartup : Fragment() {

    lateinit var binding:FragmentStartupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentStartupBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    //do nothing
                }
            })
        when(stateStart){
            "cafe"->cafeStat()
            "you"->youStat()
            "music"->musicStat()
        }
        binding.apply {
            menu.setOnClickListener{
                findNavController().navigate(R.id.action_fragmentStartup_to_fragmentMenu)
            }
            menu1.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentStartup_to_fragmentMenu)
            }
            read.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentStartup_to_fragmentDetails)
            }
        }
    }

    private fun musicStat() {
        binding.apply {
            back.setBackgroundResource(R.drawable.music)
            tagstart.text="Музыка"
            startup.text="Студия записи"
            aboutstart.text="Профессиональная студия записи для аудио и музыки. Отличное оборудование, звукорежиссеры и услуги по записи, микшированию и мастерингу."
            date.text="${getTodayDate()}"
        }
    }

    private fun youStat() {
        binding.apply {
            back.setBackgroundResource(R.drawable.you)
            tagstart.text="Ты"
            startup.text="Саморазвитие"
            aboutstart.text="Сила саморазвития - ключ к личному росту. Постоянное стремление учиться, развиваться и преодолевать себя для достижения потенциала."
            date.text="${getTodayDate()}"
        }
    }

    private fun cafeStat() {
        binding.apply {
            back.setBackgroundResource(R.drawable.cafe)
            tagstart.text="Кафе"
            startup.text="Кейтеринговое агенство"
            aboutstart.text="Кейтеринговое агентство - компания, предоставляющая услуги организации и обеспечения питания на мероприятиях, включая свадьбы, корпоративные вечеринки и конференции."
            date.text="${getTodayDate()}"
        }
    }

    private fun getTodayDate(): String {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return dateFormat.format(currentDate)
    }


}