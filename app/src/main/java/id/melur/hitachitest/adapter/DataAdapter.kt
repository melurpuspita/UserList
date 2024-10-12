package id.melur.hitachitest.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.melur.hitachitest.R
import id.melur.hitachitest.database.User
import id.melur.hitachitest.databinding.ItemDataBinding

class DataAdapter(private val navController: NavController
) : ListAdapter<User, DataAdapter.DataViewHolder>(DIFF_CALLBACK)  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class DataViewHolder(private val binding: ItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: User) {
            with(binding) {
                txtId.text = data.id.toString()
                txtUserName.text = data.login
                Glide.with(itemView.context)
                    .load(data.avatarUrl)
                    .fitCenter()
                    .into(imgUser)

                itemView.setOnClickListener {
                    val bundle = Bundle().apply {
                        putString("username", data.login)
                    }
                    navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
                }
            }
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }
        }
    }
}
