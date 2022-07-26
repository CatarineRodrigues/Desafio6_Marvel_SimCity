package br.com.zup.marvel.ui.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository
import br.com.zup.marvel.utils.INSERT_EMAIL
import br.com.zup.marvel.utils.INSERT_PASSWORD
import br.com.zup.marvel.utils.LOGIN_ERROR
import br.com.zup.marvel.utils.PASSWORD_SMALL_ERROR

class LoginViewModel : ViewModel() {
    private val repository = AuthenticationRepository()

    private var _loginResponse = MutableLiveData<User>()
    val loginResponse: LiveData<User> = _loginResponse

    private var _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun validateDataUser(user: User) {
        when {
            user.email.isEmpty() -> _errorResponse.value = INSERT_EMAIL

            user.password.isEmpty() -> _errorResponse.value = INSERT_PASSWORD

            user.password.length < 8 -> _errorResponse.value = PASSWORD_SMALL_ERROR

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
                _errorResponse.value = LOGIN_ERROR + it.message
            }
        } catch (ex: Exception) {
            _errorResponse.value = ex.message
        }
    }
}