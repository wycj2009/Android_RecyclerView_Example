package com.example.android_recyclerview_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android_recyclerview_example.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personList = listOf(
                Person(R.drawable.ic_profile_1, "AAA"),
                Person(R.drawable.ic_profile_2, "BBB"),
                Person(R.drawable.ic_profile_3, "CCC"),
                Person(R.drawable.ic_profile_4, "DDD"),
                Person(R.drawable.ic_profile_5, "EEE"),
                Person(R.drawable.ic_profile_6, "FFF"),
                Person(R.drawable.ic_profile_7, "GGG"),
                Person(R.drawable.ic_profile_8, "HHH"),
                Person(R.drawable.ic_profile_9, "III"),
                Person(R.drawable.ic_profile_10, "JJJ")
        )

        binding.personList.adapter = PersonAdapter(
                personList,
                clickCallback = { name ->
                    Snackbar.make(binding.root, name, Snackbar.LENGTH_SHORT).show()
                }
        )
    }

}