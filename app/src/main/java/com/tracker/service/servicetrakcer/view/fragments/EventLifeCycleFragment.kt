package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.domain.EVENT_LIFE_CYCLE_ACTION_TYPE
import com.tracker.service.servicetrakcer.domain.EventLifecycleModel
import com.tracker.service.servicetrakcer.view.activities.MainActivity
import com.tracker.service.servicetrakcer.view.adapters.MainPagerAdapter
import kotlinx.android.synthetic.main.event_lifecycle_fragment.*

class EventLifeCycleFragment : BaseFragment() {

    val goingTravelStartedFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.GOING_TRAVEL_STARTED
            onItemSelectedFun {
                setViewPagerPage(this@EventLifeCycleFragment.actionsViewPager.currentItem + 1)
            }

        }
    }
    val goingTravelEndedFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.GOING_TRAVEL_ENDED
            onItemSelectedFun {
                setViewPagerPage(this@EventLifeCycleFragment.actionsViewPager.currentItem + 1)
            }

        }
    }
    val inProcessTaskFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.IN_PROCESS_TASK
            onItemSelectedFun {
                setViewPagerPage(this@EventLifeCycleFragment.actionsViewPager.currentItem + 1)
            }
        }
    }
    val inPausedTaskFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.IN_PAUSED_TASK
            onItemSelectedFun {
                setViewPagerPage(this@EventLifeCycleFragment.actionsViewPager.currentItem + 1)
            }
        }
    }
    val endedTaskFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.ENDED_TASK
            onItemSelectedFun {
                setViewPagerPage(this@EventLifeCycleFragment.actionsViewPager.currentItem + 1)
            }
        }
    }
    val comingBackTravelStartedFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.COMING_BACK_TRAVEL_STARTED
            onItemSelectedFun {
                setViewPagerPage(this@EventLifeCycleFragment.actionsViewPager.currentItem + 1)
            }
        }
    }
    val endedTaskButFragment by lazy {
        LifecycleActionsFragment.newInstance().apply {
            lifeCycleStatus = LifecycleActionsFragment.LIFE_CYCLE.ENDED_TASK_BUT
            onItemSelectedFun {
                setViewPagerPage(0)
            }
        }
    }

    companion object {
        fun newInstance(): EventLifeCycleFragment = EventLifeCycleFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.event_lifecycle_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onBackPressed(): Boolean {
        if (actionsViewPager.currentItem > 0) {
            setViewPagerPage(actionsViewPager.currentItem - 1)
            return false
        }
        return super.onBackPressed()
    }

    private fun setupView() {
        activity?.let { act ->
            actionsViewPager.adapter = MainPagerAdapter(childFragmentManager, listOf(goingTravelStartedFragment, goingTravelEndedFragment, inProcessTaskFragment, inPausedTaskFragment, endedTaskFragment, comingBackTravelStartedFragment, endedTaskButFragment))
            actionsViewPager.offscreenPageLimit = 7
        }

    }

    private fun setViewPagerPage(page: Int) {
        actionsViewPager.currentItem = page
    }


}