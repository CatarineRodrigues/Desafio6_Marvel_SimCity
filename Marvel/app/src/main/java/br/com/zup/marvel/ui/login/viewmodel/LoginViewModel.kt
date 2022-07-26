package br.com.zup.marvel.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository

class LoginViewModel : ViewModel() {
    private val repository = AuthenticationRepository()

    private var _loginResponse = MutableLiveData<User>()
    val loginResponse: LiveData<User> = _loginResponse

    private var _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun validateDataUser(user: User) {
        when {
            user.email.isEmpty() -> _errorResponse.value = "Insira seu email"

            user.password.isEmpty() -> _errorResponse.value = "Insira sua senha"

            user.password.length < 8 -> _errorResponse.value = "SENHA INVÁLIDA! Senha deve ter no mínimo 8 caracteres"

            else -> {
                loginUser(user)
            }
        }
    }

    private fun loginUser(user: User) {
        try {
            repository.loginUser(
                user.email,
                user.password
            ).addOnSuccessListener {
                _loginResponse.value = user
            }.addOnFailureListener {
                _errorResponse.value = "Ops! Ocorreu um erro ao logar o usuário!" + it.message
            }
        } catch (ex: Exception) {
            _errorResponse.value = ex.message
        }
    }
}