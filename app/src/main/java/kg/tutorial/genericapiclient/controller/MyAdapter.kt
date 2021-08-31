package kg.tutorial.genericapiclient.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import kg.tutorial.genericapiclient.R
import kg.tutorial.genericapiclient.databinding.ItemRvBinding
import kg.tutorial.genericapiclient.models.data.MyDataItem


class MyAdapter(val context: Context, val userList: List<MyDataItem>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {
        val binding = ItemRvBinding.bind(itemView)
        fun bind(items: MyDataItem)= with(binding){
            tvId.text = items.id.toString()
            tvPunchline.text = items.punchline
            tvSetup.text = items.setup
            tvType.text = items.type
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.cardView.startAnimation(AnimationUtils.loadAnimation(context,
            R.anim.rv_animation
        ))
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int = userList.size

}