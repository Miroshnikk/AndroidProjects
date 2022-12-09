package com.project10

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.project10.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSavePrefs.setOnClickListener {
            val sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE
            )
            with(sharedPref.edit()) {
                putInt(
                    getString(R.string.seekbar_pref),
                    binding.seekBarRateService.progress
                )
                putBoolean(
                    getString(R.string.swith_pref),
                    binding.switchUseRoom.isChecked
                )
                apply()
                Toast.makeText(
                    applicationContext,
                    "Settings saved to preference",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        binding.buttonReadPrefs.setOnClickListener {
            val sharedPref = getSharedPreferences(
                getString(R.string.preference_file_key),
                MODE_PRIVATE
            ) ?: return@setOnClickListener
            val seekBarValue = sharedPref.getInt(getString(R.string.seekbar_pref), 0)
            val switchValue = sharedPref.getBoolean(getString(R.string.swith_pref), false)
            binding.textViewPrefsResult.text =
                "SeekBar value: $seekBarValue; Switch value: $switchValue"
        }

        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java, "database-name"
        ).build()
        val userDao = db.userDao()
        binding.buttonSaveUser.setOnClickListener {
            val data = binding.editTextTextPersonName.text
            val userInfo = data.split(' ')
            val user =
                User(firstName = userInfo[0], lastName = userInfo[1], age = userInfo[2].toInt())
            lifecycleScope.launch(Dispatchers.IO) {
                userDao.insertAll(user)
            }
            Toast.makeText(
                applicationContext,
                "User inserted",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.buttonRead.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val users = userDao.getAll()
                var usersInfo = ""
                users.forEach {
                    usersInfo += "${it.firstName} ${it.lastName} ${it.age} \n"
                }
                runOnUiThread {
                    binding.textViewDbResult.text = usersInfo
                }
            }
        }
    }
}