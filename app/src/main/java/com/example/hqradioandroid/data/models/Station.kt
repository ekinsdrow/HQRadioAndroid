package com.example.hqradioandroid.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


@Serializable
data class Station(
    val id: String,
    val title: String,
    val name: String,
    val style: String,
    @SerializedName("style_name")
    val styleName: String,
    val genre: String,
    @SerializedName("genre_name")
    val genreName: String,
    val network: String,
    @SerializedName("network_name")
    val networkName: String,
) {
    fun getImage(mainUrl: String): String {
        return "${mainUrl}data/logos/$id.jpg"
    }
}

@Serializable
data class Stations(val list: ArrayList<Station>) {

    fun getStationsListByStationIdList(stationIdList: StationIdList): Stations {
        val resList = arrayListOf<Station>()

        for (i in list) {
            if (stationIdList.list.contains(StationId(i.id))) {
                resList.add(i)
            }
        }

        return Stations(list = resList)
    }

    fun getStationByString(string: String): Stations {
        val resList = arrayListOf<Station>()
        for (i in list) {
            if (i.title.lowercase().contains(string)) {
                resList.add(i)
            }
        }

        return Stations(list = resList)

    }
}