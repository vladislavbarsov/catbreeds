package com.example.catbreeds.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class BreedProperty(
    val name: String,
    val description: String,
    val id: String,
    val temperament: String,
    @Json(name = "life_span")val lifeSpan: String,
    @field:Json(name = "image") val image: @RawValue ObjImage
) : Parcelable

data class ObjImage(
    @Json(name = "url")
    val ulr: String
)
