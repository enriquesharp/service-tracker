package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.domain.EventModel
import com.tracker.service.servicetrakcer.view.adapters.EventAdapter
import com.urbamap.urbamap.extensions.onClick
import kotlinx.android.synthetic.main.event_detail_fragment.*
import kotlinx.android.synthetic.main.monthly_fragment.*

class EventDetailFragment : BaseFragment() {

    enum class CURRENT_VIEW { MAP, EVENT_LIFE_CYCLE }

    var currentView = CURRENT_VIEW.MAP

    companion object {
        fun newInstance(): EventDetailFragment = EventDetailFragment()
    }

    val eventLifeCycleFragment by lazy {
        EventLifeCycleFragment.newInstance()
    }
    val mapFragment by lazy {
        MapFragment.newInstance().apply {
            onItemStartActionFun {
                currentView = CURRENT_VIEW.EVENT_LIFE_CYCLE
                setupView()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.event_detail_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewClickListeners()
        setupView()
    }

    override fun onBackPressed(): Boolean {
        if (currentView == CURRENT_VIEW.EVENT_LIFE_CYCLE) {
            if (eventLifeCycleFragment.onBackPressed()) {
                currentView = CURRENT_VIEW.MAP
                setupView()
            }
            return false
        }
        return mapFragment.onBackPressed()
    }

    private fun setupView() {
        activity?.let { act ->
            val ft = childFragmentManager.beginTransaction()
            ft.replace(eventDetailContentBox.id, if (currentView == CURRENT_VIEW.MAP) mapFragment else eventLifeCycleFragment)
            ft.commit()
        }

    }

    fun initViewClickListeners() {

    }

    fun setData(model: EventModel) {

    }
}