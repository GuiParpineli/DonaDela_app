package com.example.donadela.model

import android.os.Parcel
import android.os.Parcelable

data class Lingerie(
    val image: Int,
    val name: String?,
    val description: String?,
    val price: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(image)
        dest.writeString(name)
        dest.writeString(description)
        dest.writeString(price)
    }

    companion object CREATOR : Parcelable.Creator<Lingerie> {
        override fun createFromParcel(parcel: Parcel): Lingerie {
            return Lingerie(parcel)
        }

        override fun newArray(size: Int): Array<Lingerie?> {
            return arrayOfNulls(size)
        }
    }

}
