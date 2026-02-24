package com.example.project4_ng

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Person(
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String?,
    @SerializedName("known_for_department")
    val knownForDepartment: String,
    @SerializedName("popularity")
    val popularity: Double,
    @SerializedName("known_for")
    val knownFor: List<KnownFor>
) : Serializable

data class KnownFor(
    @SerializedName("title")
    val title: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("media_type")
    val mediaType: String
) : Serializable {
    val displayTitle: String
        get() = title ?: name ?: "Unknown"
}

data class PopularPersonsResponse(
    @SerializedName("results")
    val results: List<Person>
)