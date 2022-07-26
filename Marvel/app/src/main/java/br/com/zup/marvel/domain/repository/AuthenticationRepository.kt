package br.com.zup.marvel.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthenticationRepository {
    private val auth: FirebaseAuth = Firebase.auth

    fun registerUser(email: String, pass: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, pass)
    }

    fun updateUserProfile(name: String): Task<Void>? {
        val profile = UserProfileChangeRequest.Builder().setDisplayName(name).build()
        return auth.currentUser?.updateProfile(profile)
    }

    fun loginUser(email: String, pass: String) = auth.signInWithEmailAndPassword(email, pass)

    fun getNameUser(): String = auth.currentUser?.displayName.toString()

    fun logoutUser() {
        auth.signOut()
    }
}