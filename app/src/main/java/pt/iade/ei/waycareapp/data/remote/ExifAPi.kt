import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ExifApi {

    @Multipart
    @POST("/exif")
    suspend fun enviarImagem(
        @Part imagem: MultipartBody.Part
    ): ExifResponse
}
