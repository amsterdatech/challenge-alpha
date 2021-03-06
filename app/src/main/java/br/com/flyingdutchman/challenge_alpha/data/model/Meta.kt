package br.com.flyingdutchman.challenge_alpha.data.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("count")
    val count: Int,
    @SerializedName("countBustrip")
    val countBustrip: Int,
    @SerializedName("countDisney")
    val countDisney: Int,
    @SerializedName("countHotel")
    val countHotel: Int,
    @SerializedName("countPackage")
    val countPackage: Int,
    @SerializedName("countTicket")
    val countTicket: Int,
    @SerializedName("countWithAvailabilityInPage")
    val countWithAvailabilityInPage: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("query")
    val query: String,
    @SerializedName("warning")
    val warning: String
)