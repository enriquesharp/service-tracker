package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.domain.EventModel
import com.tracker.service.servicetrakcer.view.adapters.MainPagerAdapter
import com.urbamap.urbamap.extensions.onClick
import kotlinx.android.synthetic.main.event_fragment.*

class EventFragment : BaseFragment() {

    enum class CURRENT_VIEW { TABS, DETAIL }

    var currentView: CURRENT_VIEW = CURRENT_VIEW.TABS

    companion object {
        fun newInstance(): EventFragment = EventFragment()
    }

    val dailyFragment by lazy { DailyFragment.newInstance() }
    val monthlyFragment by lazy {
        MonthlyFragment.newInstance().apply {
            onItemSelectedFun { model ->
                goToEventDetail(model)
            }
        }
    }
    val undefinedFragment by lazy { UndefinedFragment.newInstance() }
    val eventDetailFragment by lazy { EventDetailFragment.newInstance() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.event_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        Log.e("onViewCreated", "EventFragment")
        initViewClickListeners()
        setupView()

    }

    override fun onBackPressed(): Boolean {
        return if (currentView == CURRENT_VIEW.DETAIL) {
            if (eventDetailFragment.onBackPressed()) {
                currentView = CURRENT_VIEW.TABS
                eventDetailContainer.visibility = View.GONE
                eventTabsContainer.visibility = View.VISIBLE
            }
            false
        } else
            dailyFragment.onBackPressed() && monthlyFragment.onBackPressed() && undefinedFragment.onBackPressed()
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
            eventViewPager.adapter = MainPagerAdapter(act.supportFragmentManager, listOf(dailyFragment, monthlyFragment, undefinedFragment))
            setViewPagerPage(1)

            val ft = act.supportFragmentManager.beginTransaction()
            ft.replace(eventDetailContainer.id, eventDetailFragment)
            ft.commit()
        }
    }

    private fun setViewPagerPage(page: Int) {
        eventViewPager.currentItem = page
        dailyBox.setBackgroundColor(resources.getColor(if (page == 0) android.R.color.white else android.R.color.transparent))
        monthlyBox.setBackgroundColor(resources.getColor(if (page == 1) android.R.color.white else android.R.color.transparent))
        undefinedBox.setBackgroundColor(resources.getColor(if (page == 2) android.R.color.white else android.R.color.transparent))
    }

    private fun goToEventDetail(model: EventModel) {
        activity?.let { act ->
            currentView = CURRENT_VIEW.DETAIL
            eventDetailContainer.visibility = View.VISIBLE
            eventTabsContainer.visibility = View.GONE

            eventDetailFragment.setData(model)
        }
    }
}