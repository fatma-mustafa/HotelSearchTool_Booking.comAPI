package com.example.hotelsearchtool

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@SuppressLint("ServiceCast", "SuspiciousIndentation")
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
                Toast.makeText(context,"Check your Internet Connection",Toast.LENGTH_LONG).show()
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




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv=findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager=LinearLayoutManager(this)
        var src:SearchView=findViewById(R.id.src)
        var chout_date=findViewById<TextView>(R.id.chout)
        var chin_date=findViewById<TextView>(R.id.chin)
        var shimmer=findViewById<ShimmerFrameLayout>(R.id.shimmerLayout)
        shimmer.visibility=View.GONE
        shimmer.stopShimmer()
//        var curr=findViewById<Spinner>(R.id.curr)
//        var units=findViewById<Spinner>(R.id.units)
//        var ordrby=findViewById<Spinner>(R.id.odrby)
        if (Build.VERSION.SDK_INT > 9) {
            val policy = ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        chin_date.setOnClickListener {
            var dat:String?=null
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
           val datePicker=DatePickerDialog(this,
               { view, year, month, day ->
                   if ((month + 1) < 10 && day < 10)
                       dat = "$year-0${(month + 1)}-0$day"
                   else if ((month + 1) < 10 && day >= 10)
                       dat = "$year-0${(month + 1)}-$day"
                   else if ((month + 1) >= 10 && day >= 10)
                       dat = "$year-${(month + 1)}-$day"
                   else
                       dat =  "$year-${(month + 1)}-0$day"
                   chin_date.setText(dat)
               },

               year,
               month,
               day
           )

            datePicker.show()
        }

        chout_date.setOnClickListener {
            var dat:String?=null
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val datePicker=DatePickerDialog(this,
                { view, year, month, day ->
                    if ((month + 1) < 10 && day < 10)
                        dat = "$year-0${(month + 1)}-0$day"
                    else if ((month + 1) < 10 && day >= 10)
                        dat = "$year-0${(month + 1)}-$day"
                    else if ((month + 1) >= 10 && day >= 10)
                        dat = "$year-${(month + 1)}-$day"
                    else
                    dat =  "$year-${(month + 1)}-0$day"

                    chout_date.setText(dat)
                },

                year,
                month,
                day
            )
            datePicker.show()
        }




            src.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    shimmer.startShimmer()
                    shimmer.visibility=View.VISIBLE
                    if(checkForInternet(this@MainActivity))
                    {
                        lifecycleScope.launch (){

                            RequestManger.userFilteration( chout_date.text.toString(),chin_date.text.toString(),
                                    "metric",1,"popularity",
                                    "USD",1 )

                            var hotelList = RequestManger.QueryHotels(query)
                            if(hotelList.isNotEmpty()) {
                                shimmer.stopShimmer()
                                shimmer.visibility=View.GONE
                            }
                            var Adapter=RVA(this@MainActivity,Hotel_data::class.java,hotelList)
                            rv.adapter=Adapter
                        }
                    }
                    else
                        Toast.makeText(this@MainActivity,"Check your internet connection",Toast.LENGTH_LONG).show()

                    return true}


                override fun onQueryTextChange(p0: String): Boolean {
                    return true
                }
            })



    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}
