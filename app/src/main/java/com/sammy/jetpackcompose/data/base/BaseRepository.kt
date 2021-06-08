package com.sammy.jetpackcompose.data.base

import com.sammy.jetpackcompose.utils.ApiResponse
import com.sammy.jetpackcompose.utils.ErrorHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseRepository {
    suspend fun <T> apiCall(
        apiCall: suspend () -> T
    ): ApiResponse<T> {
        return withContext(Dispatchers.IO) {
            try {

                ApiResponse.Success(apiCall.invoke())

            } catch (e: Exception) {
                e.printStackTrace()
                Timber.e("cause ${e.localizedMessage}")
                when (e) {
                    is IOException -> ApiResponse.Failure(
                        ErrorHolder(
                            "Unable to connect, check your connection",
                            1
                        )
                    )

                    is HttpException -> ApiResponse.Failure(extractHttpExceptions(e))

                    is UnknownHostException -> ApiResponse.Failure(
                        ErrorHolder(
                            "Unable to connect, check your connection",
                            1
                        )
                    )
                    is SocketTimeoutException -> ApiResponse.Failure(
                        ErrorHolder(
                            "Unable to connect, check your connection",
                            1
                        )
                    )
                    else -> ApiResponse.Failure(ErrorHolder(e.message.toString(), 1))
                }
            }
        }
    }

    private fun extractHttpExceptions(e: HttpException): ErrorHolder {
        val body = e.response()?.errorBody()
        val jsonString = body?.string()
        Timber.e("body ${e.response()?.body().toString()}")
        Timber.e("json string $jsonString")


        val message = try {
            val jsonObject = JSONObject(jsonString)
            jsonObject.getString("message")
        } catch (e: JSONException) {
            "Unable to complete request your request, try again later"
        }

        val errorCode = e.response()?.code()
        return ErrorHolder(message, errorCode)
    }

}