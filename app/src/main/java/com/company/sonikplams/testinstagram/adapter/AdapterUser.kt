package com.company.sonikplams.testinstagram.adapter

import android.app.AlertDialog
import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.company.sonikplams.testinstagram.R
import com.company.sonikplams.testinstagram.pojo.User
import java.lang.String

class AdapterUser (var list: MutableList<User>) : RecyclerView.Adapter<AdapterUser.RecyclerViewHolder>() {


    lateinit var mClickListener: ClickListener

    fun setOnItemClickListener(aClickListener: ClickListener) {
        mClickListener = aClickListener
    }

    interface ClickListener {
        fun onClick(pos: Int, aView: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(inflater, parent)
    }
    fun refreshPlaceList(list: MutableList<User>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val user: User = list[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int = list.size

    inner class RecyclerViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.one_item_recycler, parent, false)), View.OnClickListener{

        override fun onClick(v: View) {
            mClickListener.onClick(adapterPosition, v)
        }

        private var name: TextView? = null
        private var location: TextView? = null
        private var photo: ImageView? = null
        private var like: TextView? = null
        private var comment: TextView? = null

        init {
            name = itemView.findViewById(R.id.name)
            location = itemView.findViewById(R.id.location)
            photo = itemView.findViewById(R.id.photo)
            like = itemView.findViewById(R.id.like)
            comment = itemView.findViewById(R.id.comment)
        }

        fun bind(user: User) {

           /* txtnameplace?.text = itemView.context.resources.getString(R.string.name_place) + " "  + place.name
            txtlatitude?.text = itemView.context.resources.getString(R.string.lat_c) + " "  + place.latitude.toString()
            txtlongitude?.text = itemView.context.resources.getString(R.string.lon_c) + " "  + place.longitude.toString()
            txtzoom?.text = itemView.context.resources.getString(R.string.zoom) + " "  +  place.zoom.toString()
*/



        }



    }
}
