package com.rivera.recyclerview1.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rivera.recyclerview1.R
import com.rivera.recyclerview1.databinding.ItemsUsersBinding
import com.rivera.recyclerview1.logic.entities.FullInfoAnimeLG

class UsersAdapterDiffUtil(
    private var onDeleteItem: (Int) -> Unit,
    private var onSelectItem: (FullInfoAnimeLG) -> Unit
) : ListAdapter<FullInfoAnimeLG, UsersAdapterDiffUtil.UsersVH>(DiffUtilUserCallback) {

    class UsersVH(view: View): RecyclerView.ViewHolder(view){
        private var binding: ItemsUsersBinding = ItemsUsersBinding.bind(view)
        fun render(
            item: FullInfoAnimeLG,
            onDeleteItem: (Int) -> Unit,
            onSelectItem: (FullInfoAnimeLG) -> Unit){
            binding.txtUserName.text = item.name
            binding.txtUserDesc.text = item.synapsis
            binding.imgUser.load(item.big_image)

            binding.btnBorrar.setOnClickListener {
                onDeleteItem(adapterPosition)
            }
            binding.imgUser.setOnClickListener {
                onSelectItem(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersVH {
        val inflater = LayoutInflater.from(parent.context)
        return UsersVH(inflater.inflate(R.layout.items_users, parent, false))
    }
    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        holder.render(getItem(position), onDeleteItem, onSelectItem)
    }
}


private object DiffUtilUserCallback : DiffUtil.ItemCallback<FullInfoAnimeLG>() {
    override fun areItemsTheSame(oldItem: FullInfoAnimeLG, newItem: FullInfoAnimeLG): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FullInfoAnimeLG, newItem: FullInfoAnimeLG): Boolean {
        return oldItem == newItem
    }

}
