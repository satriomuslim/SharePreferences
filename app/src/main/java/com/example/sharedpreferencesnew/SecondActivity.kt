package com.example.sharedpreferencesnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sharedpreferencesnew.databinding.ActivitySecondBinding
import com.example.sharedpreferencesnew.pref.ModelPref
import com.example.sharedpreferencesnew.pref.ProfilePref

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private lateinit var profilePref: ProfilePref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profilePref = ProfilePref(this)

        if (profilePref.preference.contains(ProfilePref.NAME)) {
            val profile = profilePref.getProfile()
            binding.etNama.setText(profile.name)
            profile.age?.let { binding.etAge.setText(it.toString()) }
            binding.etGender.setText(profile.gender)
        }

        binding.btnSave.setOnClickListener {
            val name = binding.etNama.text.toString().trim()
            val age = binding.etAge.text.toString().trim()
            val gender = binding.etGender.text.toString().trim()

            val model = ModelPref(
                name,
                age.toInt(),
                gender
            )

            saveToPref(model)
        }

    }

    private fun saveToPref(model: ModelPref) {
        Log.e("STR", "saveToPref: ${model.name} ${model.age} ${model.gender}", )
        profilePref.setProfile(model)
        Toast.makeText(this, "Data Save Success", Toast.LENGTH_SHORT).show()
        Intent(this, MainActivity::class.java).also {
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(it)
        }


    }
}