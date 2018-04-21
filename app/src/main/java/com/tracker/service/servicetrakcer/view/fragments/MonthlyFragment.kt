package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.view.adapters.EventAdapter
import kotlinx.android.synthetic.main.monthly_fragment.*

class MonthlyFragment : BaseFragment() {

    companion object {
        fun newInstance(): MonthlyFragment = MonthlyFragment()
    }

    val eventAdapter by lazy { EventAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.monthly_fragment, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        eventsRv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = eventAdapter
        }

        eventAdapter.setData(listOf())
    }
}