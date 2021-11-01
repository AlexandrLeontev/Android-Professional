package com.example.dictonary.model.datasource

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * Custom interceptor to intercept basic responses and to show basic errors to the user
 * (not fully implemented)
 */
class BaseInterceptor private constructor() : Interceptor {

    private var responseCode: Int = 0

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        responseCode = response.code
        return response
    }

    companion object {
        val interceptor: BaseInterceptor
            get() = BaseInterceptor()
    }
}
