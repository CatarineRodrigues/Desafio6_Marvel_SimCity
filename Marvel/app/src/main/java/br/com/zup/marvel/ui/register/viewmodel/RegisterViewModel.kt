package br.com.zup.marvel.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository
import br.com.zup.marvel.utils.*

class RegisterViewModel : ViewModel() {
    private val authenticationRepository = AuthenticationRepository()

    private var _registerResponse = MutableLiveData<User>()
    val registerResponse: LiveData<User> = _registerResponse

    private var _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun validateDataUser(user: User) {
        when {
            user.name.isEmpty() -> _errorResponse.value = NAME_EMPTY_ERROR

            user.name.length < 3 -> _errorResponse.value = NAME_SMALL_ERROR

            user.email.isEmpty() -> _errorResponse.value = EMAIL_EMPTY_ERROR

            user.password.isEmpty() -> _errorResponse.value = PASSWORD_EMPTY_ERROR

            user.password.length < 8 -> _errorResponse.value = PASSWORD_SMALL_ERROR

            else ->
                if ((!user.email.contains("@") && !user.email.contains(".com"))) {
                    _errorResponse.value = "Tipo de email inválido"
                } else {
                    registerUser(user)
                }
        }
    }

    private fun registerUser(user: User) {
        try {
            authenticationRepository.registerUser(user.email, user.password).addOnSuccessListener {
                authenticationRepository.updateUserProfile(user.name)?.addOnSuccessListener {
                    _registerResponse.value = user
                }
            }.addOnFailureListener {
                _errorResponse.value = REGISTER_ERROR + it.message
            }
        } catch (ex: Exception) {
            _errorResponse.value = ex.message
        }
    }
}