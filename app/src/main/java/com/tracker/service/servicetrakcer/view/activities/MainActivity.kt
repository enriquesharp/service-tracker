package com.tracker.service.servicetrakcer.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tracker.service.servicetrakcer.R
import com.tracker.service.servicetrakcer.view.fragments.MainFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mainFragment by lazy { MainFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ft = supportFragmentManager.beginTransaction()
        ft.replace(mainFragmentContainer.id, mainFragment)
        ft.commit()

        Log.e("onCreate", "MainActivity")

    }

    override fun onBackPressed() {
        if (mainFragment.onBackPressed())
            super.onBackPressed()
    }
}
