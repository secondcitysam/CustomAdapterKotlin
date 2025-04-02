package com.example.customadapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class CustomAdapter(private val context : Context, private val items : List<Item>) : BaseAdapter() {

    override fun getCount(): Int {
      return  items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val holder : ViewHolder

        if(convertView == null)
        {
            view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
            holder = ViewHolder(view)
            view.tag = holder
        }
        else{
            view = convertView
            holder = view.tag as ViewHolder

        }

        val item = items[position]

        item?.let {       Glide.with(context)
            .load(item.imageResID)
            .override(100,100)
            .into(holder.image)
            //  holder.image.setImageResource(item.imageResID)
            holder.title.text = item.title
            holder.description.text = item.description  }



        if(position%2==0){
            view.setBackgroundResource(R.color.secondary)
        }else{
            view.setBackgroundResource(R.color.tertiary)
        }
        return view

    }

    private class ViewHolder(view : View)
    {
        val image : ImageView = view.findViewById(R.id.item_image)
        val title : TextView = view.findViewById(R.id.item_title)
        val description : TextView = view.findViewById(R.id.item_description)

    }

}