package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R

class EventLifeCycleFragment : BaseFragment() {

    companion object {
        fun newInstance(): EventLifeCycleFragment = EventLifeCycleFragment()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.event_lifecycle_fragment, container, false)

}