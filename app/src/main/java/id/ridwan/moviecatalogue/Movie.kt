package id.ridwan.moviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val photo: Int,
    val name: String,
    val description: String
) : Parcelable