package com.example.myapplication

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Logo (
    var brand_name: String,
    var brand_description: String,
    var brand_logo: String
        ): Parcelable