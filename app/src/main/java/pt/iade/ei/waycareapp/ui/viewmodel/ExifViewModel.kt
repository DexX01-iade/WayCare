package pt.iade.ei.waycareapp.ui.viewmodel

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import pt.iade.ei.waycareapp.data.remote.RetrofitInstance

class ExifViewModel : ViewModel() {

    var latitude by mutableStateOf<Double?>(null)
    var longitude by mutableStateOf<Double?>(null)
    var data by mutableStateOf<String?>(null)
    var isLoading by mutableStateOf(false)
    var erro by mutableStateOf<String?>(null)

    fun enviarImagem(uri: Uri, context: Context) {
        viewModelScope.launch {
            try {
                isLoading = true
                erro = null

                val inputStream = context.contentResolver.openInputStream(uri)!!
                val bytes = inputStream.readBytes()

                val requestBody = bytes.toRequestBody("image/*".toMediaType())
                val part = MultipartBody.Part.createFormData(
                    "imagem",
                    "foto.jpg",
                    requestBody
                )

                val resposta = RetrofitInstance.api.enviarImagem(part)

                latitude = resposta.latitude
                longitude = resposta.longitude
                data = resposta.data

            } catch (e: Exception) {
                erro = "Erro: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }
}
