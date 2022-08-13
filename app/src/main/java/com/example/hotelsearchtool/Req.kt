package com.example.hotelsearchtool
import android.content.Context
import android.widget.Toast
import retrofit2.Call

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface{
    @Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
    @GET("locations?locale=en-gb")
    fun DesSearch(@Query("name")RegionName:String?):Call<List<dest>>

//    @Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
//    @GET("search?dest_id=dest_id&dest_type=dest_type&locale=en-gb&adults_number=1&order_by=order_by&filter_by_currency=curr&checkin_date=check_in_date&room_number=1&children_number=2&page_number=3&children_ages=5%2C0&include_adjacency=false&checkout_date=check_out_date&units=units")
//    fun SearchbyDes(@Query("check_out_date")check_out_date:String?,
//                    @Query("check_in_date")check_in_date:String?,
//                    @Query("units")units:String?,
//                    @Query("dest_id")dest_id:Int?,
//                    @Query("dest_type")dest_type:String?,
//                    @Query("adults_number")adults_number:Int?,
//                    @Query("order_by")order_by:String?,
//                    @Query("curr")curr:String?,
//                    @Query("room_nr")room_nr:Int?,
//    ):Call<Any>

    @Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
    @GET("search?locale=en-gb")
    fun SearchbyDes(
                    @Query("checkout_date")check_out_date:String?,
                    @Query("checkin_date")check_in_date:String?,
                    @Query("units")units:String?,
                    @Query("dest_id")dest_id:Int?,
                    @Query("dest_type")dest_type:String?,
                    @Query("adults_number")adults_number:Int?,
                    @Query("order_by")order_by:String?,
                    @Query("filter_by_currency")curr:String?,
                    @Query("room_number")room_nr:Int?,
    ):Call<res>

@Headers("X-RapidAPI-Key:"+"c6d17f7720mshb9ad3b6e41b2d84p1a4a38jsn4d01fe046346")
@GET("photos?locale=en-gb")
fun HotelImages(@Query("hotel_id")hotel_id:Int):Call<List<hotel_images>>
}

 object RequestManger
{
//        var ctx: Context?=null
        var check_out_date: String? = null
        var check_in_date: String? = null
        var units: String? = null
        var adults_number: Int? = null
        var order_by: String? = null
        var curr: String? = null
        var room_nr: Int? = null
        var destinations: MutableList<dest> =  mutableListOf()

    fun userFilteration(
//        ctx: Context?,
        check_out_date: String?,
        check_in_date: String?,
        units: String?,
        adults_number: Int?,
        order_by: String?,
        curr: String?,
        room_nr: Int?
    ) {
        this.check_in_date=check_in_date
        this.check_out_date=check_out_date
        this.units=units
        this.adults_number=adults_number
        this.order_by =order_by?.replace(" ","_")
        this.curr=curr
        this.room_nr=room_nr

    }

        val retro = Retrofit.Builder()
            .baseUrl("https://booking-com.p.rapidapi.com/v1/hotels/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun QueryHotelImages(hotel_id: Int,ctx:Context): List<hotel_images> {
            val Ap: ApiInterface = retro.create(ApiInterface::class.java)
            val call = Ap.HotelImages(hotel_id)
            val imgList: MutableList<hotel_images> = mutableListOf()
            try {
                val response = call.execute()
                imgList.addAll(response.body())

            } catch (ex: Exception) {
                Toast.makeText(ctx, "Loading Images failed", Toast.LENGTH_LONG)
            }
            return imgList
        }

        fun QueryDestinationsIDs(query: String): List<dest> {
            val Ap: ApiInterface = retro.create(ApiInterface::class.java)
            val call: Call<List<dest>> = Ap.DesSearch(query)


            val response = call.execute()

            try {
                destinations.addAll(response.body())
                println(response.raw())
            } catch (ex: Exception) {
                println("Search Failed")
                println(response.raw())
            }
//        call.enqueue(object : Callback<List<dest>> {
//            override fun onFailure(call: Call<List<dest>>, t: Throwable) {
//                Toast.makeText(ctx, "Search failed", Toast.LENGTH_LONG).show()
//                println("failed")
//            }
//
//            override fun onResponse(call: Call<List<dest>>, response: Response<List<dest>>) {
//                println(response.body())
//                val temp=response.body()
//                destinations=temp
//            }
//
//
//        })
            return destinations

        }

        fun QueryHotels(query: String): List<hotel> {
            val destinations = QueryDestinationsIDs(query)
            val Ap: ApiInterface = retro.create(ApiInterface::class.java)
//
//    println(check_out_date)
//    println(check_in_date)
//    println(units)
//    println(adults_number)
//    println(order_by)
//    println(curr)
//    println(room_nr)
//    println(destinations[0].dest_id)
//    println(destinations[0].dest_type)
//
//
//

            val hotels: MutableList<hotel> = mutableListOf()

            for (i in 0..destinations.size) {
                val call = Ap.SearchbyDes(check_out_date,
                    check_in_date,
                    units,
                    destinations[0].dest_id,
                    destinations[0].dest_type,
                    adults_number,
                    order_by,
                    curr,
                    room_nr)
                val response = call.execute()
               println( response.raw())
                println(response.body())
                hotels.addAll(response.body().result)

            }



//           hotels.addAll(response.body())

//       }
//
//        call.enqueue(object:Callback<List<hotel>>{
//            override fun onResponse(call: Call<List<hotel>>?, response: Response<List<hotel>>?) {
//                println(response?.body())
//            }
//
//            override fun onFailure(call: Call<List<hotel>>?, t: Throwable?) {
//                TODO("Not yet implemented")
//            }
//        })

            return hotels
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

data class hotel(
    var hotel_id:Int,
    var hotel_name:String?=null,
    var address:String?=null,
    var district_id:Int?=null,
    var main_photo_url:String?=null,
    var price_breakdown:hotel_price?=null,
    var review_score:Double,
    var review_nr:Int?=null,
//    var hotelPrice: hotel_price?=null

)

data class res(val result:List<hotel>)

data class hotel_price(
    var all_inclusive_price:Double?=null,
    var currency:String?=null
            )

data class hotel_images(val url_max:String)

