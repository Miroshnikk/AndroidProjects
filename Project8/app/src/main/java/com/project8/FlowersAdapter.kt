package com.project8

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.project8.databinding.RecyclerRowBinding
import com.bumptech.glide.Glide



class FlowersAdapter (
    private val itemList: List<Pair<String, String?>>,
    private val onItemClick: (position:Int) -> Unit
) :
        RecyclerView.Adapter<FlowersAdapter.FlowersHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FlowersHolder {
        val itemBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context))
        return FlowersHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: FlowersHolder, position: Int) {
        val flowersData = itemList[position]
        holder.bind(flowersData.first, flowersData.second)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class FlowersHolder(
        private val itemBinding: RecyclerRowBinding,
        private val onItemClick: (position: Int) -> Unit
    ):
            RecyclerView.ViewHolder(itemBinding.root){
                init {
                    itemView.setOnClickListener{
                        onItemClick(adapterPosition)
                    }
                }
        fun bind(flowersName: String, flowersPhotoUrl: String?){
            Glide.with(itemView)
                .load(flowersPhotoUrl)
                .centerCrop()
                .into(itemBinding.imageKindOfFlow)

            itemBinding.textKindOfFlow.text = flowersName
        }
     }
}