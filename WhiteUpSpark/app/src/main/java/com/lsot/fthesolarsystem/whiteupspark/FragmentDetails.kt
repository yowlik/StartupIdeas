package com.lsot.fthesolarsystem.whiteupspark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.lsot.fthesolarsystem.whiteupspark.FragmentMenu.Companion.stateStart
import com.lsot.fthesolarsystem.whiteupspark.databinding.FragmentDetailsBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class FragmentDetails : Fragment() {


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
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_fragmentDetails_to_fragmentStartup)
                }
            })
        when(stateStart){
            "cafe"->cafeStat()
            "you"->youStat()
            "music"->musicStat()
        }
        binding.apply {
            time.text="${getCurrentTime()}"
            date.text="${getTodayDate()}"
        }
    }

    private fun musicStat() {
        binding.apply {
            back.setBackgroundResource(R.drawable.music)
            tagstart.text="Музыка"
            startup.text="Студия записи"
            aboutstart.text="Определите целевую аудиторию: музыканты, подкастеры, рекламные агентства.Создайте профессионально оборудованное звукозаписывающее пространство. Наймите квалифицированных звукорежиссеров и инженеров.Разработайте гибкие ценовые пакеты и услуги. Продвигайте студию через социальные сети, мероприятия и рекламу.Уделяйте внимание качеству и удовлетворенности клиентов.Расширяйте свои услуги и стремитесь к профессиональному росту."
        }

    }

    private fun youStat() {
        binding.apply {
            back.setBackgroundResource(R.drawable.you)
            tagstart.text="Ты"
            startup.text="Саморазвитие"
            aboutstart.text="Для начала саморазвития, поставьте перед собой цели и определите интересующие области. Читайте книги, следите за новостями, изучайте онлайн-курсы. Практикуйте регулярно, участвуйте в семинарах и вебинарах. Задавайте вопросы и общайтесь с экспертами. Оценивайте свой прогресс и корректируйте план развития. Постоянно стремитесь к росту и самосовершенствованию."
        }
    }

    private fun cafeStat() {
        binding.apply {
            back.setBackgroundResource(R.drawable.cafe)
            tagstart.text="Кафе"
            startup.text="Кейтеринговое агенство"
            aboutstart.text="Для открытия кейтерингового агентства нужно провести исследование рынка, разработать уникальное меню, получить необходимые лицензии и разрешения. Затем, создать привлекательный бренд, наладить работу с поставщиками, арендовать подходящее оборудование и привлечь талантливых поваров и персонал. Важно продвигать свои услуги через маркетинг и социальные сети, а также уделять внимание высокому качеству обслуживания и удовлетворению потребностей клиентов."
        }
    }

    private fun getTodayDate(): String {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return dateFormat.format(currentDate)
    }
    private fun getCurrentTime(): String {
        val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val currentTime = Date()
        return dateFormat.format(currentTime)
    }



}