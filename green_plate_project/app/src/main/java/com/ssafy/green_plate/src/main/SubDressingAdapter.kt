package com.ssafy.green_plate.src.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ssafy.green_plate.databinding.ListItemShoppingcartSubDressingBinding
import com.ssafy.green_plate.dto.AddedStuffInfo
import com.ssafy.green_plate.dto.Product
import com.ssafy.green_plate.models.OrderDetailResponse
import com.ssafy.green_plate.util.CommonUtils

private const val TAG = "SubDressingAdapter_싸피"
class SubDressingAdapter(val context: Context, private var items: List<Product>) : RecyclerView.Adapter<SubDressingAdapter.SubDressingViewHolder>() {

    inner class SubDressingViewHolder(private val binding: ListItemShoppingcartSubDressingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            // 자식 RecyclerView의 아이템 데이터를 바인딩
//            binding.subDressingNameTv.text = item.
//            Log.d(TAG, "bind: $item")
            binding.apply {
                subDressingNameTv.text = item.name
                subDressingPriceTv.text = CommonUtils.makeComma(item.price)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubDressingViewHolder {
        val binding = ListItemShoppingcartSubDressingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SubDressingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubDressingViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        Log.d(TAG, "onBindViewHolder: $items")
    }

    override fun getItemCount(): Int {
        return items.size
    }


}