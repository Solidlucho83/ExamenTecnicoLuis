package com.luiscastaneriaDemo.prueba1.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.luiscastaneriaDemo.prueba1.R
import com.luiscastaneriaDemo.prueba1.databinding.DetailPhoneBinding
import com.luiscastaneriaDemo.prueba1.databinding.PhoneListBinding
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import com.luiscastaneriaDemo.prueba1.model.deviceModel
import com.squareup.picasso.Picasso

class NewDetailAdapter (private val context: Context,
                        private val phoneList: List<deviceModel>

):
    RecyclerView.Adapter<BaseViewHolder<*>>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_phone, parent, false))
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){ is NewDetailAdapter.MainViewHolder -> holder.bind(phoneList[position],position)}
    }
    inner class MainViewHolder(itemview: View): BaseViewHolder<deviceModel>(itemview){
        private val binding = DetailPhoneBinding.bind(itemview)

        override fun bind(item: deviceModel, position: Int) {



           var lista = item.images.get(position).url
            var lista3 = item.images.get(2).url


            try {

                Picasso.get()
                    .load(lista)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imCoverPhone)
                Picasso.get()
                    .load(lista3)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imCoverPhone3)

                binding.tvlegales.text = item.legal
                binding.tvNamePhone.text = item.name
            }catch (e: Exception){
                e.printStackTrace()
                binding.imCoverPhone.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    }
    }