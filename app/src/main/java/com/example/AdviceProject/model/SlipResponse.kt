package com.example.pratica.model

import com.squareup.moshi.Json

data class SlipResponse(

    @field:Json(name = "slip") val slip: AdviceData
)