package com.danielg7.cripto.data.remote.models

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2022 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */

data class Payload(

    @SerializedName("book") val book: String,
    @SerializedName("minimum_price") val minimum_price: Double,
    @SerializedName("maximum_price") val maximum_price: Double,
    @SerializedName("minimum_amount") val minimum_amount: Double,
    @SerializedName("maximum_amount") val maximum_amount: Double,
    @SerializedName("minimum_value") val minimum_value: Double,
    @SerializedName("maximum_value") val maximum_value: Double,
    @SerializedName("tick_size") val tick_size: Double,
    @SerializedName("default_chart") val default_chart: String,
    @SerializedName("fees") val fees: Fees
)
