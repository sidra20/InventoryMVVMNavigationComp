package com.sidrakotlin.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.sidrakotlin.task.databinding.LayoutMainBinding

class MainProductActivity:AppCompatActivity() {

    private lateinit var binding: LayoutMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navHost.navController
        setupActionBarWithNavController(navController)
    }
}