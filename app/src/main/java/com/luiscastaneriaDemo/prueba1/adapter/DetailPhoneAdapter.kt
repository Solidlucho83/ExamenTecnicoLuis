package com.luiscastaneriaDemo.prueba1.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.luiscastaneriaDemo.prueba1.R
import com.luiscastaneriaDemo.prueba1.databinding.DetailPhoneBinding
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import com.luiscastaneriaDemo.prueba1.model.deviceModel
import com.squareup.picasso.Picasso
import retrofit2.Response


class DetailPhoneAdapter(private val context: Context,
                         private val phoneList: List<deviceModel>
):
    RecyclerView.Adapter<BaseViewHolder<*>>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainDetailViewHolder(LayoutInflater.from(context).inflate(R.layout.detail_phone, parent, false))
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){ is MainDetailViewHolder-> holder.bind(phoneList[position],position)}
    }
    inner class MainDetailViewHolder(itemview: View): BaseViewHolder<deviceModel>(itemview){
        private val binding = DetailPhoneBinding.bind(itemview)



        override fun bind(item: deviceModel, position: Int) {


            try {

                Picasso.get()
                    .load(item.images!![position].url)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imCoverPhone)
            }catch (e: Exception){
                e.printStackTrace()
                binding.imCoverPhone.setImageResource(R.drawable.ic_launcher_background);
            }

        }


    }
}