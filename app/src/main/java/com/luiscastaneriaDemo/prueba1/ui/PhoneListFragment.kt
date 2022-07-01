package com.luiscastaneriaDemo.prueba1.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.luiscastaneriaDemo.prueba1.R
import com.luiscastaneriaDemo.prueba1.adapter.DetailPhoneAdapter
import com.luiscastaneriaDemo.prueba1.adapter.MainAdapter
import com.luiscastaneriaDemo.prueba1.adapter.NewDetailAdapter
import com.luiscastaneriaDemo.prueba1.data.RepoImplement
import com.luiscastaneriaDemo.prueba1.core.VMFactoy
import com.luiscastaneriaDemo.prueba1.databinding.FragmentPhoneListBinding
import com.luiscastaneriaDemo.prueba1.data.DataSource
import com.luiscastaneriaDemo.prueba1.data.WebService
import com.luiscastaneriaDemo.prueba1.databinding.DetailPhoneBinding
import com.luiscastaneriaDemo.prueba1.model.ImageX
import com.luiscastaneriaDemo.prueba1.model.PhoneListModelItem
import com.luiscastaneriaDemo.prueba1.model.deviceModel
import com.luiscastaneriaDemo.prueba1.ui.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PhoneListFragment : Fragment(R.layout.fragment_phone_list), MainAdapter.OnPhoneClickListener {

    private var _binding: FragmentPhoneListBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: DetailPhoneAdapter
    private var phoneImg = mutableListOf<deviceModel>()
    private val viewModel by viewModels<MainViewModel> { VMFactoy(RepoImplement(DataSource())) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhoneListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRw()
        viewModel.fecthListPhone.observe(viewLifecycleOwner, Observer { result ->
            binding.rvPhoneList.adapter = MainAdapter(requireContext(), result, this)
            binding.rvPhoneDetail.adapter = MainAdapter(requireContext(), result, this)
        })


    }

    private fun initRw() {
        binding.rvPhoneList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPhoneList.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.rvPhoneDetail.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL, false
        )

        binding.rvPhoneDetail.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.HORIZONTAL
            )
        )


    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://61967289af46280017e7e0c0.mockapi.io/devices/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private suspend fun searchByName(query: String) {

        var call = getRetrofit().create(WebService::class.java).getPhoneDetail(query)
        var phone = call
        if(phone != null) {
            var images = phone

            phoneImg.clear()
            phoneImg.addAll(listOf(images))
            binding.rvPhoneDetail.adapter = NewDetailAdapter(requireContext(), phoneImg)
            binding.rvPhoneDetail.visibility = View.VISIBLE
        }

    }


    override fun onPhoneClick(phone: String) {
        runBlocking {
            searchByName(phone)
        }
    }


}




