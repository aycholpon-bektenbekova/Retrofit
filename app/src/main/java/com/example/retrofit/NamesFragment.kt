package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.retrofit.databinding.FragmentNamesBinding
import com.example.retrofit.model.LoveModel
import com.example.retrofit.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NamesFragment : Fragment() {

    private lateinit var binding: FragmentNamesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNamesBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            calcBtn.setOnClickListener {
                RetrofitService().getLoveApi().getResultLove(
                    firstName = firstNameEt.text.toString(),
                    secondName = secondNameEt.text.toString()).enqueue(object: Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val arguments = LoveModel (
                         response.body()?.firstName.toString(),
                         response.body()?.secondName.toString(),
                         response.body()?.percentage.toString(),
                         response.body()?.result.toString())

                        findNavController().navigate(R.id.resultFragment, bundleOf("key" to arguments))
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    }

                })
                }
            }
        }
    }
