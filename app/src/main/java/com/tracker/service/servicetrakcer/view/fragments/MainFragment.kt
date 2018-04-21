package com.tracker.service.servicetrakcer.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.view.adapters.MainPagerAdapter
import com.urbamap.urbamap.extensions.onClick
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    val eventFragment by lazy { EventFragment.newInstance() }
    val notificationFragment by lazy { NotificationFragment.newInstance() }
    val messageFragment by lazy { MessageFragment.newInstance() }
    val userFragment by lazy { UserFragment.newInstance() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()

        initViewClickListeners()
    }

    private fun initViewClickListeners() {
        listOf<View>(eventBox, notificationBox, messageBox, userBox).onClick {
            when (it.id) {
                eventBox.id -> {
                    setViewPagerPage(0)
                }
                notificationBox.id -> {
                    setViewPagerPage(1)
                }
                messageBox.id -> {
                    setViewPagerPage(2)
                }
                userBox.id -> {
                    setViewPagerPage(3)
                }
            }
        }
    }

    private fun setupView() {
        activity?.let { act ->
            mainViewPager.adapter = MainPagerAdapter(act.supportFragmentManager, listOf(eventFragment, notificationFragment, messageFragment, userFragment))
            setViewPagerPage(0)
            mainViewPager.offscreenPageLimit = 3
        }
    }

    private fun setViewPagerPage(page: Int) {
        mainViewPager.currentItem = page

        eventBox.isSelected = page == 0
        notificationBox.isSelected = page == 1
        messageBox.isSelected = page == 2
        userBox.isSelected = page == 3
    }
}