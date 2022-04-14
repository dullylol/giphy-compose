package com.dehalex.giphy.data.utils.network.interceptors

import com.dehalex.giphy.data.entities.network.base.ErrorResponse
import com.dehalex.giphy.exceptions.NetworkException
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ErrorHandlingInterceptor : Interceptor {

    private val gson by lazy { Gson() }

    override fun intercept(chain: Interceptor.Chain): Response {
        try {
            return proceedResponse(chain)
        } catch (exception: IOException) {
            throw exception
        }
    }

    @Throws(NetworkException::class)
    private fun proceedResponse(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        if (!response.isSuccessful) {
            val errorResponse = gson.fromJson(response.body?.string(), ErrorResponse::class.java)

            throw NetworkException(
                message = errorResponse.meta?.message.orEmpty(),
                code = errorResponse.meta?.status ?: response.code,
            )
        }

        return response
    }
}
