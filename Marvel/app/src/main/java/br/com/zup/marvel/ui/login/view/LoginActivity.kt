package br.com.zup.marvel.ui.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.marvel.utils.LOGIN
import br.com.zup.marvel.databinding.ActivityLoginBinding
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.ui.home.view.HomeActivity
import br.com.zup.marvel.ui.login.viewmodel.LoginViewModel
import br.com.zup.marvel.ui.register.view.RegisterActivity
import br.com.zup.marvel.utils.USER_KEY

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this)[LoginViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = LOGIN
        setClickLogin()
        setClickNewRegister()
        initObservers()
    }

    private fun goToHomePage(user: User) {
        val intent = Intent(this, HomeActivity::class.java).apply {
            putExtra(USER_KEY, user)
        }
        startActivity(intent)
    }

    private fun initObservers() {
        viewModel.loginResponse.observe(this) {
            goToHomePage(it)
        }
        viewModel.errorResponse.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun goToRegistration() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun setClickNewRegister() {
        binding.tvNewRegister.setOnClickListener {
            goToRegistration()
        }
    }

    private fun setClickLogin() {
        binding.btnLogin.setOnClickListener {
            val user = getDataUser()
            viewModel.validateDataUser(user)
        }
    }

    private fun getDataUser(): User {
        return User(
            email = binding.etEmail.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }
}