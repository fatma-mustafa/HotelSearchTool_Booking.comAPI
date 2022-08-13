package com.example.hotelsearchtool

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVA(val ctx: Context, val dataset:List<hotel>, val onRVclickedItem: onRVclickedItem): RecyclerView.Adapter<RVA.VH>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):VH {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.search_result_rc,parent,false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.address.text=dataset[position].address
        Glide.with(ctx).load(dataset[position].main_photo_url).into(holder.image)
        holder.name.text=dataset[position].hotel_name
        holder.price.text=dataset[position].price_breakdown?.all_inclusive_price.toString()
        holder.score.text=dataset[position].review_score.toString()
        holder.scorenr.text=dataset[position].review_nr.toString()
        holder.curr.text=dataset[position].price_breakdown?.currency.toString()

        holder.itemView.setOnClickListener { onRVclickedItem.getHotelID(dataset[position].hotel_id)
        Toast.makeText(ctx,dataset[position].hotel_id, Toast.LENGTH_LONG)
        }

            if (dataset[position].review_score?.toFloat() >= 8.5) {
                holder.scoreClass.text = "Excellent"
                holder.score.setBackgroundColor(Color.parseColor("#3AAE0C"))
            } else if (dataset[position].review_score?.toFloat() >= 6.0) {
                holder.scoreClass.text = "Very Good"
                holder.score.setBackgroundColor(Color.parseColor("#FFEA00"))
            } else if (dataset[position].review_score?.toFloat() < 6.0 && dataset[position].review_nr?.toFloat()!=null) {
                holder.scoreClass.text = "Good"
                holder.score.setBackgroundColor(Color.parseColor("#FF0000"))
            }
         else {
                holder.scoreClass.text = "No Reviews provided"
                holder.scorenr.text = "0"
            }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

     class VH(ItemView:View):RecyclerView.ViewHolder(ItemView)
    {
         var image=itemView.findViewById<ImageView>(R.id.ImgVw)
         var name= itemView.findViewById<TextView>(R.id.eleName)
         var address= itemView.findViewById<TextView>(R.id.address)
         var scoreClass= itemView.findViewById<TextView>(R.id.scoreClass)
         var scorenr= itemView.findViewById<TextView>(R.id.rvwNr)
         var score= itemView.findViewById<TextView>(R.id.rvwScore)
         var price= itemView.findViewById<TextView>(R.id.price)
         var curr=itemView.findViewById<TextView>(R.id.curr)
    }
}