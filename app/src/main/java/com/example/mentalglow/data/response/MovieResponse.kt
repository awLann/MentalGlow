package com.example.mentalglow.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class MovieResponse(

	@field:SerializedName("MovieResponse")
	val movieResponse: List<MovieResponseItem>
)

@Parcelize
data class MovieResponseItem(

	@field:SerializedName("genre")
	val genre: String,

	@field:SerializedName("title")
	val title: String
): Parcelable
