package com.tracker.service.servicetrakcer.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tracker.service.servicetrakcer.R
import com.urbamap.urbamap.extensions.onClick
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViewClickListeners()
    }

    private fun initViewClickListeners() {
        listOf<View>(loginBtn).onClick {
            when (it.id) {
                loginBtn.id -> {
                    makeLogin()
                }
            }
        }
    }

    private fun makeLogin() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))

    }
}
