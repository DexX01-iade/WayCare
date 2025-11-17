package pt.iade.ei.waycareapp.ui.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pt.iade.ei.waycareapp.data.remote.RetrofitInstance
import pt.iade.ei.waycareapp.data.model.Utilizador
import android.util.Log

class LoginViewModel : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var erro by mutableStateOf<String?>(null)
    var isLoading by mutableStateOf(false)
    var loginSucesso by mutableStateOf(false)

    fun validarLogin(): Boolean {
        if (email.isBlank() || password.isBlank()) {
            erro = "Preenche todos os campos"
            return false
        }
        if (!email.contains("@")) {
            erro = "Email inválido"
            return false
        }
        return true
    }

    fun fazerLogin() {
        if (!validarLogin()) return

        isLoading = true
        erro = null

        viewModelScope.launch {
            try {
                val response = RetrofitInstance.loginApi.login(
                    Utilizador(email = email, password = password)
                )
                isLoading = false

                if (response.isSuccessful && response.body() != null) {
                    loginSucesso = true
                    Log.d("LoginViewModel", "Login bem-sucedido: ${response.body()}")
                } else {
                    erro = "Credenciais inválidas"
                    Log.e("LoginViewModel", "Erro: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                isLoading = false
                erro = "Falha na ligação ao servidor"
                Log.e("LoginViewModel", "Exceção: ${e.message}")
            }
        }
    }
}

