package com.dehalex.giphy.exceptions

import java.io.IOException

data class NetworkException(
    override val message: String,
    val code: Int,
) : IOException()