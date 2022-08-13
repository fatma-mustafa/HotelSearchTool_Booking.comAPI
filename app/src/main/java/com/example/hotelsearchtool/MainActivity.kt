package com.example.hotelsearchtool

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


@SuppressLint("ServiceCast")
private fun checkForInternet(context: Context): Boolean {

    // register activity with the connectivity manager service
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    // if the android version is equal to M
    // or greater we need to use the
    // NetworkCapabilities to check what type of
    // network has the internet connection
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        // Returns a Network object corresponding to
        // the currently active default data network.
        val network = connectivityManager.activeNetwork ?: return false

        // Representation of the capabilities of an active network.
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false


            // Indicates this network uses a Wi-Fi transport,
            // or WiFi has network connectivity
           if( activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))return true

            // Indicates this network uses a Cellular transport. or
            // Cellular has network connectivity
          if(activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))return true

            // else return false
            else{
                Toast.makeText(context,"Check your Internet Connection",Toast.LENGTH_LONG)
               return false
            }
        }
     else {
        // if the android version is below M
        @Suppress("DEPRECATION") val networkInfo =
            connectivityManager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
}
object onRVclickedItem
{
    fun getHotelID(ID:Int){}

}




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv=findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager=LinearLayoutManager(this)
        val cardV=findViewById<CardView>(R.id.cardView)
        var src:SearchView=findViewById(R.id.src)
        var chout_date=findViewById<TextView>(R.id.chout)
        var chin_date=findViewById<TextView>(R.id.chin)
        var curr=findViewById<Spinner>(R.id.curr)
        var units=findViewById<Spinner>(R.id.units)
        var ordrby=findViewById<Spinner>(R.id.odrby)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }


//        cardV.setOnLongClickListener {object: View.OnClickListener {
//            override fun onClick(p0: View?) {
//                  RequestManger
//            }
//
//        }}



            src.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    RequestManger.userFilteration( chout_date.text.toString(),chin_date.text.toString(),
                        units.selectedItem.toString(),1,ordrby.selectedItem.toString(),
                        curr.selectedItem.toString(),1 )
                    if(checkForInternet(this@MainActivity)){
                    val hotelList = RequestManger.QueryHotels(query)
                    val Adapter=RVA(this@MainActivity,hotelList, onRVclickedItem )
                    rv.adapter=Adapter}

                    return true
                }

                override fun onQueryTextChange(p0: String): Boolean {
//                    QueryHotelsbylocation(p0)
                    return true
                }
            })








    }
}
