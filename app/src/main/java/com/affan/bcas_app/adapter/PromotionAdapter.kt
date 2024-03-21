package com.affan.bcas_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.affan.bcas_app.databinding.ItemAccountNumberBinding
import com.affan.bcas_app.databinding.ItemPromotionBinding
import com.affan.bcas_app.model.PromotionModel

class PromotionAdapter (private val data: List<PromotionModel>) :
    RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder>() {

    inner class PromotionViewHolder(
        val binding: ItemPromotionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PromotionModel) {
            binding.ivPromoBcas.setImageResource(item.imagePromotion)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PromotionAdapter.PromotionViewHolder {
        return PromotionViewHolder(
            ItemPromotionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(
        holder: PromotionAdapter.PromotionViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}