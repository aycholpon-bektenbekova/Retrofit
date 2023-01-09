package com.example.retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.retrofit.databinding.FragmentNamesBinding
import com.example.retrofit.viewmodel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NamesFragment : Fragment() {

    private lateinit var binding: FragmentNamesBinding

    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNamesBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initClicker() {
        with(binding) {
            calcBtn.setOnClickListener {
                viewModel.getLiveLoveModel(firstNameEt.text.toString(), secondNameEt.text.toString())
                    .observe(this@NamesFragment, Observer{
                        Log.e("aic", "initClicker: ${it.percentage}")
                    })

            }
        }
    }
}

