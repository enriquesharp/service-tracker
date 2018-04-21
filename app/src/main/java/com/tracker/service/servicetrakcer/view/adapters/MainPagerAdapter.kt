package com.tracker.service.servicetrakcer.view.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Enrique on 12/25/2017.
 */
class MainPagerAdapter(fm: FragmentManager, frgList: List<Fragment>) : FragmentPagerAdapter(fm) {

    private val fragments: List<Fragment> = frgList

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size


}