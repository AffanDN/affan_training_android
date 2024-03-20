package com.affan.bcas_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.affan.bcas_app.databinding.ItemAccountNumberBinding

import com.affan.bcas_app.model.AccountNumberModel
import com.affan.bcas_app.model.TranscationModel

class AccountNumberAdapter (private val data: List<AccountNumberModel>):
    RecyclerView.Adapter<AccountNumberAdapter.AccountNumberViewHolder> (

) {

    // Hasil inflating, buat terjemahin, buat isi anak tangganya
    inner class AccountNumberViewHolder(
        val binding: ItemAccountNumberBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AccountNumberModel) {
            binding.tvSavingType.text = item.savingType
            binding.tvAccountNumber.text = item.noRek.toString()
            binding.tvAccBalance.text = item.balanceAmount

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        return AccountNumberViewHolder(
            ItemAccountNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(data[position])
    }
}