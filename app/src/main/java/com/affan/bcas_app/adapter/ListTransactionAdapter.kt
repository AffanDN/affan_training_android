package com.affan.bcas_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.affan.bcas_app.databinding.ItemListTransactionBinding
import com.affan.bcas_app.model.TranscationModel

class ListTransactionAdapter :
    RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>() {
//        underscore pada variabel sebagai penanda bahwa variable tersebut merupakan mutable
//        kalo buat parameter gausah menggunakan underscore
        private var _data: MutableList<TranscationModel> = mutableListOf()

        private var _onClickTransaction: (TranscationModel) -> Unit = {}

        fun setData(newData: MutableList<TranscationModel>){
            _data = newData
            notifyDataSetChanged()
        }

    fun setOnClickTransaction(listener: (TranscationModel) -> Unit) {
        _onClickTransaction = listener
    }

        inner class TransactionViewHolder(private val binding: ItemListTransactionBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(item: TranscationModel, onClickTransaction: (TranscationModel) -> Unit) {
                binding.TransferType.text = item.transferType
                binding.tvStatusTransaction.text = item.transferStatus
                binding.tvAmount.text = item.amount.toString()
                binding.TransferDestination.text = item.transferDestination
                binding.TransferDate.text = item.date

                binding.root.setOnClickListener{onClickTransaction.invoke(item)}
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            ItemListTransactionBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

//    Sama aja kayak return ini penyajian yang berbeda
    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position], _onClickTransaction)
    }
}