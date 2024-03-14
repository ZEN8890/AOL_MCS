package com.example.aol_mcs

import android.os.Parcel
import android.os.Parcelable

data class Doll(
    val ids: String,
    val name: String,
    val imageUrl: String,
    val size: String,
    val rating: Float,
    val price: Double,
    val description: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readDouble(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ids)
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeString(size)
        parcel.writeFloat(rating)
        parcel.writeDouble(price)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Doll> {
        override fun createFromParcel(parcel: Parcel): Doll {
            return Doll(parcel)
        }

        override fun newArray(size: Int): Array<Doll?> {
            return arrayOfNulls(size)
        }
    }
}


