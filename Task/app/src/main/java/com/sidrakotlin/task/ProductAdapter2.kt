package com.sidrakotlin.task

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sidrakotlin.task.databinding.ProductItemBinding
import com.sidrakotlin.task.generated.callback.OnClickListener.Listener

class ProductAdapter2(var listener:Listener, private val context:Context):RecyclerView.Adapter<ProductAdapter2.MyViewHolder>() {

    var productList = ArrayList<Product>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater,parent,false)
        val obj = MyViewHolder(binding, listener)
        return obj
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val products = productList[position]
        holder.binding.prodName.text=products.name
        holder.binding.prodPrice.text="$" + products.price
        holder.binding.prodQty.text=products.qty.toString()
        holder.itemView.setOnClickListener {
            listener.itemClick(products)
        }
    }

    override fun getItemCount(): Int {

        return productList.size
    }


    fun updateList(newList : List<Product>)
    {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }
    class MyViewHolder(val binding: ProductItemBinding, val listener: Listener):RecyclerView.ViewHolder(binding.root)
    {

    }

    interface Listener{
        fun itemClick(product: Product)
    }
}