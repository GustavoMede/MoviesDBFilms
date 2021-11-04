package com.example.moviesdbfilm.ui

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.moviesdbfilm.R
import com.example.moviesdbfilm.databinding.ActivityMainBinding
import android.R.menu
import android.annotation.SuppressLint

import androidx.appcompat.view.menu.MenuBuilder




class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    private lateinit var drawerLayout: DrawerLayout

    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout = bind.drawer
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(bind.navView, navController)
        navController.addOnDestinationChangedListener{_, destination, _ ->
            title = destination.label
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }
}