package com.affan.bcas_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TranscationModel(
    val transferType: String,
    val transferDestination: String,
    val date: String,
    val transferStatus: String,
    val amount: Double

) : Parcelable