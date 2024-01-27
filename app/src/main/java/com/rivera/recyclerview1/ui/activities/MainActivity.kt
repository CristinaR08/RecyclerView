package com.rivera.recyclerview1.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.rivera.recyclerview1.databinding.ActivityMainBinding
import com.rivera.recyclerview1.logic.entities.FullInfoAnimeLG
import com.rivera.recyclerview1.logic.usercase.jikan.JikanTopAnimesUserCase
import com.rivera.recyclerview1.ui.adapters.UsersAdapterDiffUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

}