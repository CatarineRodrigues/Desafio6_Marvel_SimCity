package br.com.zup.marvel.ui.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.marvel.R
import br.com.zup.marvel.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}