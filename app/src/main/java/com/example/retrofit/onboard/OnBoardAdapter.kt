package com.example.retrofit.onboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.databinding.ItemBoardBinding

class OnBoardAdapter(private val onStartClick: () -> Unit): RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val arrayList = arrayListOf(
        OnBoard(R.drawable.heart.toString(),"Have a good time", ""),
        OnBoard(R.drawable.heart.toString(),"Have a good time", ""),
        OnBoard(R.drawable.heart.toString(),"Have a good time", ""),
        OnBoard(R.drawable.heart.toString(),"Have a good time", "")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemBoardBinding.inflate
                (LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

    inner class OnBoardViewHolder(private val binding: ItemBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(onBoard: OnBoard) {
            binding.btnStart.setOnClickListener {
                onStartClick()
            }
            with(binding) {
                //imgBoarding = onBoard.image.toString()
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
                btnStart.isVisible = adapterPosition==arrayList.lastIndex
            }
        }
    }
}
