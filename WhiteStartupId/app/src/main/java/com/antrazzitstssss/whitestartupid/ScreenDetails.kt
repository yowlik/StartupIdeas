package com.antrazzitstssss.whitestartupid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.antrazzitstssss.whitestartupid.ScreenMenu.Companion.theme
import com.antrazzitstssss.whitestartupid.databinding.FragmentScreenDetailsBinding


class ScreenDetails : Fragment() {


    lateinit var binding:FragmentScreenDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentScreenDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkTheme(theme)
        pressed()
    }


    @SuppressLint("SetTextI18n")
    private fun checkTheme(i:Int){
        when(i){
            1->{
                binding.view.setBackgroundResource(R.drawable.obshepit)
                binding.motionButton2.text="Агенство Кейтеринга"
                binding.vlozh.text="100000"
                binding.dohod.text="300000"
                binding.opisanie.text="Для начала агентства кейтеринга вам понадобятся следующие шаги. Определите свою целевую аудиторию и услуги, которые вы будете предоставлять. Создайте уникальный бренд и логотип, отражающие ваш стиль и философию. Зарегистрируйте свое предприятие и получите все необходимые лицензии и разрешения. Найдите надежных поставщиков и партнеров, которые обеспечат качественные продукты и услуги. Разработайте эффективные стратегии маркетинга для привлечения клиентов. Важно также иметь хорошую команду профессионалов, которые помогут вам реализовать вашу визию и обеспечить высокий уровень обслуживания."
            }
            2->{
                binding.view.setBackgroundResource(R.drawable.remont)
                binding.motionButton2.text="Агенство по Ремонту"
                binding.vlozh.text="150000"
                binding.dohod.text="500000"
                binding.opisanie.text="Для открытия агентства по ремонту вам понадобятся следующие шаги. Сначала определите специализацию вашего агентства: ремонт жилых помещений, офисов, коммерческих объектов и т. д. Зарегистрируйте свое предприятие и получите все необходимые лицензии и разрешения. Создайте профессиональную команду специалистов с опытом в различных областях ремонта. Разработайте эффективные стратегии маркетинга для привлечения клиентов. Установите связи с поставщиками материалов и оборудования. Предоставьте клиентам качественные услуги, соблюдая сроки и бюджет. Обеспечьте высокий уровень обслуживания и стремитесь к удовлетворению потребностей клиентов."
            }
            3->{
                binding.view.setBackgroundResource(R.drawable.design)
                binding.motionButton2.text="Дизайнер сайтов"
                binding.vlozh.text="50000"
                binding.dohod.text="250000"
                binding.opisanie.text="Для становления дизайнером сайтов вам потребуется освоить несколько ключевых шагов. Вначале изучите основы веб-дизайна, включая языки HTML и CSS. Познакомьтесь с различными программами для дизайна, такими как Adobe Photoshop, Illustrator и Sketch. Освойте принципы пользовательского опыта (UX) и интерфейса (UI) дизайна. Создавайте портфолио с собственными проектами и работами, чтобы продемонстрировать свои навыки. Примите участие в онлайн-курсах и мастер-классах для дополнительного обучения. Не забывайте следить за последними тенденциями в веб-дизайне и постоянно совершенствуйтесь. Значительное понимание этих аспектов поможет вам успешно развиваться в качестве дизайнера сайтов."
            }
        }
    }
    private fun pressed() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_screenDetails_to_screenMenu)
                }
            })
    }



}