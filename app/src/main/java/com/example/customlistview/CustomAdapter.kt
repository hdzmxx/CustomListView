package com.example.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class CustomAdapter(var context: Context, var logo: ArrayList<Logo>): BaseAdapter() {

    private class ViewHolder(row: View?){
        var txtName: TextView
        var Image: ImageView
        var isi: TextView

        init {
            this.txtName = row?.findViewById(R.id.textname) as TextView
            this.Image = row?.findViewById(R.id.ivimage) as ImageView
            this.isi = row?.findViewById(R.id.isi) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.logo_item_list, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var logo: Logo = getItem(position) as Logo
        viewHolder.txtName.text = logo.name
        viewHolder.isi.text =logo.desc
        viewHolder.Image.setImageResource(logo.image)
        return view as View
    }

    override fun getItem(position: Int): Any {
        return logo.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return logo.count()
    }

}