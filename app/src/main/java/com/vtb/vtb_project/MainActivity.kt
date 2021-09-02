package com.vtb.vtb_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.vtb.vtb_project.ui.create_account_and_visa_card.ShowAuthorizationActivity
import com.vtb.vtb_project.databinding.ActivityMainBinding
import com.vtb.vtb_project.sign_in.SignIn


class MainActivity : AppCompatActivity() {
    private var bindingMain: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingMain?.root)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_back)
        }


        val intentShowAuthorization = Intent(this, ShowAuthorizationActivity::class.java)
        bindingMain?.headLineEmail?.setOnClickListener {
            startActivity(intentShowAuthorization)
        }


        //Enter Sign in ......temporary
        bindingMain?.singInApple?.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        bindingMain = null
    }
}