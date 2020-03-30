package com.example.churchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.navigation.ui.AppBarConfiguration
import com.example.churchapp.views.EventsFragment
import com.example.churchapp.views.SermonFragment
import kotlinx.android.synthetic.main.navigation.*

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = supportActionBar!!

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem->
            when(menuItem.itemId){
                R.id.navigation_home-> {
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_events -> {
                    toolbar.title = "Events"
                    val eventFragment = EventsFragment()
                    loadFragment(eventFragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }
    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

