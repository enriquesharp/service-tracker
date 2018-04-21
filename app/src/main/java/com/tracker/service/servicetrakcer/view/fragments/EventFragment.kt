package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.view.adapters.MainPagerAdapter
import com.urbamap.urbamap.extensions.onClick
import kotlinx.android.synthetic.main.event_fragment.*

class EventFragment : BaseFragment() {

    companion object {
        fun newInstance(): EventFragment = EventFragment()
    }

    val dailyFragment by lazy { DailyFragment.newInstance() }
    val monthlyFragment by lazy { MonthlyFragment.newInstance() }
    val undefinedFragment by lazy { UndefinedFragment.newInstance() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.event_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()

        initViewClickListeners()
    }

    private fun initViewClickListeners() {
        listOf<View>(dailyBox, monthlyBox, undefinedBox).onClick {
            when (it.id) {
                dailyBox.id -> {
                    setViewPagerPage(0)
                }
                monthlyBox.id -> {
                    setViewPagerPage(1)
                }
                undefinedBox.id -> {
                    setViewPagerPage(2)
                }
            }
        }
    }

    private fun setupView() {
        activity?.let { act ->
            scheduleViewPager.adapter = MainPagerAdapter(act.supportFragmentManager, listOf(dailyFragment, monthlyFragment, undefinedFragment))
            setViewPagerPage(1)
        }
    }

    private fun setViewPagerPage(page: Int) {
        scheduleViewPager.currentItem = page
        dailyBox.setBackgroundColor(resources.getColor(if(page == 0) android.R.color.white else android.R.color.transparent))
        monthlyBox.setBackgroundColor(resources.getColor(if(page == 1) android.R.color.white else android.R.color.transparent))
        undefinedBox.setBackgroundColor(resources.getColor(if(page == 2) android.R.color.white else android.R.color.transparent))
    }
}