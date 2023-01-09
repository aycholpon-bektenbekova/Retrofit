package com.example.retrofit.onboard

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentOnBoardBinding
import com.example.retrofit.viewmodel.OnBoardViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.prefs.Preferences
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment @Inject constructor(private val pref: SharedPreferences) : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var adapter: OnBoardAdapter
    private val viewModel: OnBoardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(layoutInflater)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter {
            viewModel.saveShowBoard(true)
            findNavController().navigate(R.id.namesFragment)
        }

        binding.viewPager.adapter = adapter



    }
}