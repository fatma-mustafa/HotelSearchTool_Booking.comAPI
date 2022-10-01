package com.example.hotelsearchtool
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface{

    // Alternative key 65376447c6msh2ae343d7417c6a9p18d4c0jsn51a4803c95dd
@Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
@GET("locations?locale=en-gb")
   suspend fun DesSearch(@Query("name")RegionName:String?):List<dest>


    @Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
    @GET("search?locale=en-gb")
    suspend fun SearchbyDes(
                    @Query("checkout_date")check_out_date:String?,
                    @Query("checkin_date")check_in_date:String?,
                    @Query("units")units:String?,
                    @Query("dest_id")dest_id:Int?,
                    @Query("dest_type")dest_type:String?,
                    @Query("adults_number")adults_number:Int?,
                    @Query("order_by")order_by:String?,
                    @Query("filter_by_currency")curr:String?,
                    @Query("room_number")room_nr:Int?,
    ):res

@Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
@GET("photos?locale=en-gb")
 suspend fun HotelImages(@Query("hotel_id")hotel_id:Int):List<hotel_images>

 @Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
 @GET("description?locale=en-gb")
 suspend fun HotelDescription(@Query("hotel_id")hotel_id: Int):description
}

 object RequestManger {
//     var ctx: Context? = null
     var check_out_date: String? = null
     var check_in_date: String? = null
     var units: String? = null
     var adults_number: Int? = null
     var order_by: String? = null
     var curr: String? = null
     var room_nr: Int? = null
     var destinations: MutableList<dest> = mutableListOf()

     fun userFilteration(
//         ctx: Context,
         check_out_date: String?,
         check_in_date: String?,
         units: String?,
         adults_number: Int?,
         order_by: String?,
         curr: String?,
         room_nr: Int?
     ) {
//         this.ctx = ctx
         this.check_in_date = check_in_date
         this.check_out_date = check_out_date
         this.units = units
         this.adults_number = adults_number
         this.order_by = order_by?.replace(" ", "_")
         this.curr = curr
         this.room_nr = room_nr

     }

     val retro = Retrofit.Builder()
         .baseUrl("https://booking-com.p.rapidapi.com/v1/hotels/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()


     suspend fun QueryDestinationsIDs(query: String):List<dest> {
         val Ap: ApiInterface = retro.create(ApiInterface::class.java)
         try {
             destinations = Ap.DesSearch(query) as MutableList<dest>

         }
         catch(ex:Exception)
         {
            println("Exception in QueryDestinationsIDs : ${ex.message}")
         }
         return destinations
     }

     suspend fun QueryHotels(query: String): List<hotel> {
         var destinations = QueryDestinationsIDs(query)
         var Ap: ApiInterface = retro.create(ApiInterface::class.java)
         var hotels: MutableList<hotel> = mutableListOf()
        try {
            for (i in 0..destinations.size) {
                val body = Ap.SearchbyDes(check_out_date,
                    check_in_date,
                    units,
                    destinations[i].dest_id,
                    destinations[i].dest_type,
                    adults_number,
                    order_by,
                    curr,
                    room_nr)
                hotels.addAll(body.result)

            }
        }
        catch (ex:Exception)
        {println("Exception in QueryHotels : ${ex.message}")}
         return hotels
     }


     suspend  fun QueryHotelImages(hotel_id: Int): List<hotel_images> {
         val Ap: ApiInterface = retro.create(ApiInterface::class.java)
        var imgList= mutableListOf<hotel_images>()
        try {
            imgList = Ap.HotelImages(hotel_id) as MutableList
        }
        catch (ex:Exception)
        {println("Exception in QueryHotelImages : ${ex.message}")}

         return imgList
     }

     suspend fun QueryDescription(hotel_id: Int):String
     {
         val Ap:ApiInterface= retro.create(ApiInterface::class.java)
        return Ap.HotelDescription(hotel_id).description
     }
 }

data class dest(
    var image_url:String?=null,
    var country:String?=null,
    var dest_id:Int?=null,
    var city_name:String?=null,
    var dest_type:String?=null,
    var type:String?=null,
    var nr_hotels:Int?=null,
    var name:String?=null)
@Parcelize
data class hotel(
    var hotel_id:Int,
    var hotel_name:String?=null,
    var address:String?=null,
    var district_id:Int?=null,
    var max_photo_url:String?=null,
    var price_breakdown:hotel_price?=null,
    var review_score:Double,
    var review_nr:Int?=null,
    var hotelPrice: hotel_price?=null

):Parcelable

data class res(val result:List<hotel>)

@Parcelize
data class hotel_price(
    var all_inclusive_price:Double?=null,
    var currency:String?=null
            ):Parcelable

@Parcelize
data class hotel_images(val url_max:String):Parcelable

@Parcelize
data class hotel_component(val image:List<hotel_images>, val hotelData:hotel ):Parcelable

@Parcelize
data class description(val description:String):Parcelable


