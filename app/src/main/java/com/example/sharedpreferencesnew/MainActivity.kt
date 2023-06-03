package com.example.sharedpreferencesnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferencesnew.databinding.ActivityMainBinding
import com.example.sharedpreferencesnew.pref.ProfilePref

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var profilePref: ProfilePref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profilePref = ProfilePref(this)

        if (profilePref.preference.contains(ProfilePref.NAME)) {
            val model = profilePref.getProfile()
            binding.tvNama.text = model.name
            binding.tvAge.text = model.age.toString()
            binding.tvGender.text = model.gender
        }

        binding.btnEdit.setOnClickListener {
            Intent(this, SecondActivity::class.java).also {
                startActivity(it)
            }
        }

    }
}