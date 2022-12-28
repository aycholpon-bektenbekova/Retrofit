package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.retrofit.databinding.FragmentLoveBinding
import com.example.retrofit.model.LoveModel
import com.example.retrofit.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding){
            incNames.calcBtn.setOnClickListener {
                RetrofitService().getLoveApi().getResultLove(
                    firstName = incNames.firstNameEt.text.toString(),
                    secondName = incNames.secondNameEt.text.toString()).enqueue(object: Callback<LoveModel>{
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        incResult.percentage.text = response.body()?.percentage
                        incResult.name1.text = response.body()?.firstName
                        incResult.name2.text = response.body()?.secondName
                        incResult.result.text = response.body()?.result
                        include1.isVisible = false
                        include2.isVisible = true
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                    }

                })
                }
            }
        }
    }
