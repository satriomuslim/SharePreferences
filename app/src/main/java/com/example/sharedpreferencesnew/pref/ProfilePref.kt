package com.example.sharedpreferencesnew.pref

import android.content.Context

class ProfilePref (context: Context) {

    companion object {
        const val SP_Name = "profile_pref"
        const val NAME = "name"
        const val AGE = "age"
        const val GENDER = "gender"
    }

    val preference = context.getSharedPreferences(SP_Name, Context.MODE_PRIVATE)!!

    fun setProfile(modelPref: ModelPref) {
        val prefEditor = preference.edit()
        prefEditor.putString(NAME, modelPref.name)
        modelPref.age?.let {
            prefEditor.putInt(AGE, it)
        }
        prefEditor.putString(GENDER, modelPref.gender)
        prefEditor.apply()
    }

    fun getProfile(): ModelPref {
        val modelPref = ModelPref()
        modelPref.name = preference.getString(NAME, "")
        modelPref.age = preference.getInt(AGE, 0)
        modelPref.gender = preference.getString(GENDER, "")
        return modelPref
    }



}