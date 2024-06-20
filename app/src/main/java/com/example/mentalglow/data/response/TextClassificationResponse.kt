package com.example.mentalglow.data.response

import com.google.gson.annotations.SerializedName

data class TextClassificationResponse(

	@field:SerializedName("result")
	val result: String? = null,

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("presentase")
	val presentase: String? = null
)
