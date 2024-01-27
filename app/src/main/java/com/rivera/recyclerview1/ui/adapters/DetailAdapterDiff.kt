package com.rivera.recyclerview1.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rivera.recyclerview1.R
import com.rivera.recyclerview1.databinding.ItemDetailBinding
import com.rivera.recyclerview1.logic.entities.FullInfoAnimeLG

class DetailAdapterDiff : ListAdapter<FullInfoAnimeLG, DetailAdapterDiff.DetailVH>(DiffUtilDetailsCallback) {
    class DetailVH(view: View): RecyclerView.ViewHolder(view){
        private var binding: ItemDetailBinding = ItemDetailBinding.bind(view)
        fun render(item: FullInfoAnimeLG){
            binding.txtNombreAnime .text = item.name
            binding.infoAnime.text = item.synapsis
            binding.imgAnime.load(item.big_image)

            binding.btnReturn.setOnClickListener {
                // implementar regreso
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailVH {
        val inflater = LayoutInflater.from(parent.context)
        return DetailVH(inflater.inflate(R.layout.item_detail, parent, false))
    }
    override fun onBindViewHolder(holder: DetailVH, position: Int) {
        holder.render(getItem(position))
    }
}


private object DiffUtilDetailsCallback : DiffUtil.ItemCallback<FullInfoAnimeLG>() {
    override fun areItemsTheSame(oldItem: FullInfoAnimeLG, newItem: FullInfoAnimeLG): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FullInfoAnimeLG, newItem: FullInfoAnimeLG): Boolean {
        return oldItem == newItem
    }

}