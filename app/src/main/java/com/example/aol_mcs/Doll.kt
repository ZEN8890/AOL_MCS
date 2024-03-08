package com.example.aol_mcs

import android.os.Parcel
import android.os.Parcelable

data class Doll(
    val name: String,
    val coverUrl: Int, // Assuming coverUrl is an image resource ID
    val size: String,
    val rating: Float,
    val price: Double,
    val description: String
) : Parcelable {

    // Implementing Parcelable methods
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(coverUrl)
        dest.writeString(size)
        dest.writeFloat(rating)
        dest.writeDouble(price)
        dest.writeString(description)
    }

    // Companion object to create the parcelable from a Parcel
    companion object CREATOR : Parcelable.Creator<Doll> {
        override fun createFromParcel(parcel: Parcel): Doll {
            return Doll(
                parcel.readString()!!,
                parcel.readInt(),
                parcel.readString()!!,
                parcel.readFloat(),
                parcel.readDouble(),
                parcel.readString()!!
            )
        }

        override fun newArray(size: Int): Array<Doll?> {
            return arrayOfNulls(size)
        }
    }
}


