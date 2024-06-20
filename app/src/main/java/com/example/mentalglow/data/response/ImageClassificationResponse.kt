package com.example.mentalglow.data.response

import com.google.gson.annotations.SerializedName

data class ImageClassificationResponse(

	@field:SerializedName("probability")
	val probability: Double? = null,

	@field:SerializedName("class")
	val classLabel: String? = null
)
