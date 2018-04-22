package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.urbamap.urbamap.extensions.onClick
import kotlinx.android.synthetic.main.map_fragment.*

class MapFragment : BaseFragment() {

    companion object {
        fun newInstance(): MapFragment = MapFragment()
    }

    private var onItemStartAction: (() -> Unit)? = null
    fun onItemStartActionFun(onItemStartActionFun: (() -> Unit)?) {
        onItemStartAction = onItemStartActionFun
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.map_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickViewListeners()
    }

    private fun initClickViewListeners() {
        listOf<View>(startBtn).onClick {
            when (it.id) {
                startBtn.id -> {
                    onItemStartAction?.invoke()
                }
            }
        }
    }

}