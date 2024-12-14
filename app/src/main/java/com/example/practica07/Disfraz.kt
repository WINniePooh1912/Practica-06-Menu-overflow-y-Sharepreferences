package com.example.practica07

import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.INotificationSideChannel._Parcel


class Disfraz() : Parcelable {

    var nombre : String = "none"
    var domicilio : String = "none"
    var producto : String = "none"
    var talla : String = "none"
    var telefono : String = "none"

    constructor(parcel: Parcel) : this() {
        nombre = parcel.readString()!!
        domicilio = parcel.readString()!!
        producto = parcel.readString()!!
        talla = parcel.readString()!!
        telefono = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(domicilio)
        parcel.writeString(producto)
        parcel.writeString(talla)
        parcel.writeString(telefono)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Disfraz> {
        override fun createFromParcel(parcel: Parcel): Disfraz {
            return Disfraz(parcel)
        }

        override fun newArray(size: Int): Array<Disfraz?> {
            return arrayOfNulls(size)
        }
    }

}//clase