package br.com.zup.marvel.ui.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.marvel.domain.model.User
import br.com.zup.marvel.domain.repository.AuthenticationRepository

class RegisterViewModel {
    private val authenticationRepository = AuthenticationRepository()

    private var _registerResponse = MutableLiveData<User>()
    val registerResponse: LiveData<User> = _registerResponse

    private var _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun validateDataUser(user: User) {
        when {
            user.name.isEmpty() -> _errorResponse.value = "Preencha seu nome"

            user.name.length < 3 -> _errorResponse.value = "Insira um nome com mais caracteres"

            user.email.isEmpty() -> _errorResponse.value = "Insira seu email"

            (user.email.contains("@", false)) -> _errorResponse.value = "Tipo de email inválido"

            user.password.isEmpty() -> _errorResponse.value = "Insira qual será sua senha"

            user.password.length < 8 -> _errorResponse.value = "SENHA INVÁLIDA! Senha deve ter no mínimo 8 caracteres"

            else -> registerUser(user)
        }
    }

    private fun registerUser(user: User) {
        try {
            authenticationRepository.registerUser(user.email, user.password).addOnSuccessListener {
                authenticationRepository.updateUserProfile(user.name)?.addOnSuccessListener {
                    _registerResponse.value = user
                }
            }.addOnFailureListener {
                _errorResponse.value = "Ops! Ocorreu um erro ao criar o usuário!" + it.message
            }
        } catch (ex: Exception) {
            _errorResponse.value = ex.message
        }
    }
}