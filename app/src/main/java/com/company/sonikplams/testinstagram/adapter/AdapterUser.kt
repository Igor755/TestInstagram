package com.company.sonikplams.testinstagram.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.company.sonikplams.testinstagram.R
import com.company.sonikplams.testinstagram.pojo.User
import kotlinx.android.synthetic.main.one_item_recycler.view.*

class AdapterUser (var list: MutableList<User>) : RecyclerView.Adapter<AdapterUser.RecyclerViewHolder>()  {


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
            name?.text = user.name
            location?.text = user.location
            Glide.with(itemView.context).load(user.photo).into(itemView.photo)
            like?.text = user.like
            comment?.text = user.comment

            itemView.iclike.setOnClickListener {
                Toast.makeText(itemView.context, "like", Toast.LENGTH_SHORT).show()
            }
            itemView.icmessage.setOnClickListener{
                Toast.makeText(itemView.context, "message", Toast.LENGTH_SHORT).show()

            }
            itemView.icsave.setOnClickListener{
                Toast.makeText(itemView.context, "save", Toast.LENGTH_SHORT).show()

            }
            itemView.icwrite.setOnClickListener{
                Toast.makeText(itemView.context, "write", Toast.LENGTH_SHORT).show()

            }
            itemView.menu.setOnClickListener {
                Toast.makeText(itemView.context, "menu", Toast.LENGTH_SHORT).show()

            }
        }

    }
}
