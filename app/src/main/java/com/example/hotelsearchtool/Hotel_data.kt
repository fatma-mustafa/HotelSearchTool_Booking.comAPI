package com.example.hotelsearchtool

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Hotel_data : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hotel_data)
        val imglist = intent.getParcelableExtra<Parcelable>("imglist") as hotel_component
        var ListOfURL = imglist.image
        var description=findViewById<TextView>(R.id.description)
        var review_score=findViewById<TextView>(R.id.rvwScore)
        var scoreClass=findViewById<TextView>(R.id.scoreClass)
        var curr=findViewById<TextView>(R.id.curr)
        var price=findViewById<TextView>(R.id.price)

        lifecycleScope.launch {description.text= RequestManger.QueryDescription(imglist.hotelData.hotel_id) }
        var hotelData=imglist.hotelData
        val VP: ViewPager = findViewById(R.id.idViewPager)
        val adapter:IVA=IVA(this,ListOfURL)
        VP.adapter=adapter
        var hotelName=findViewById<TextView>(R.id.hotel_name)
        hotelName.text=hotelData.hotel_name
        review_score.text=imglist.hotelData.review_score.toString()

        price.text=imglist.hotelData.price_breakdown?.all_inclusive_price.toString()
        curr.text= imglist.hotelData.price_breakdown?.currency.toString()


        if (imglist.hotelData.review_score?.toFloat() >= 8.5) {
           scoreClass.text = "Excellent"
            review_score.setBackgroundColor(Color.parseColor("#3AAE0C"))
        } else if (imglist.hotelData.review_score?.toFloat() >= 6.0) {
            scoreClass.text = "Very Good"
            review_score.setBackgroundColor(Color.parseColor("#FFEA00"))
        } else if (imglist.hotelData.review_score?.toFloat() < 6.0 && imglist.hotelData.review_nr?.toFloat()!=null) {
            scoreClass.text = "Good"
            review_score.setBackgroundColor(Color.parseColor("#FF0000"))
        }
        else {
            scoreClass.text = "No Reviews provided"
        }





    }
}