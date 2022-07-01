package com.luiscastaneriaDemo.prueba1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.luiscastaneriaDemo.prueba1.R
import com.luiscastaneriaDemo.prueba1.core.Resource
import com.luiscastaneriaDemo.prueba1.databinding.PhoneListBinding

import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem


class MainAdapter(private val context: Context,
                  private val phoneList: List<PhoneListModelItem>,
                  private val itemClickListener: OnPhoneClickListener
):
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnPhoneClickListener{
        fun onPhoneClick(phone: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
       return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.phone_list, parent, false))
    }

    override fun getItemCount(): Int {
           return phoneList.size
    }
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
       when(holder){ is MainViewHolder-> holder.bind(phoneList[position],position)}
    }
    inner class MainViewHolder(itemview: View): BaseViewHolder<PhoneListModelItem>(itemview){
        private val binding = PhoneListBinding.bind(itemview)

        override fun bind(item: PhoneListModelItem, position: Int) {


            Glide.with(binding.imCoverPhone)
                .load(item.mainImage?.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imCoverPhone)
            binding.tvNamePhone.text = item.name
            binding.tvinstallmentTag.text = item.installmentsTag
            binding.tvTopTag.text = item.topTag
            binding.cardView.setOnClickListener{
                itemClickListener.onPhoneClick(item.id.toString())
            }
        }


}
}