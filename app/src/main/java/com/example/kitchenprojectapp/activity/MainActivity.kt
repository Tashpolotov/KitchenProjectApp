package com.example.kitchenprojectapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kitchenprojectapp.R
import com.example.kitchenprojectapp.databinding.ActivityMainBinding
import com.example.kitchenprojectapp.fragment.homefragment.HomeFragment
import com.example.kitchenprojectapp.fragment.MainFragment
import com.example.kitchenprojectapp.utils.SharedPref
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPreferences: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        sharedPreferences = SharedPref(this)
        if (!sharedPreferences.isShow()) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, MainFragment())
                .commit()

            sharedPreferences.setShow(true)
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, HomeFragment())
                .commit()
        }
    }

    override fun onBackPressed() {
        finish()

    }
}