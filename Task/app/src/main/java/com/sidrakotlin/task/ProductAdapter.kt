package com.sidrakotlin.task

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.sidrakotlin.task.databinding.ProductItemBinding

class ProductAdapter(val listener:updateClick, private val context: Context):
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

     var productList = ArrayList<Product>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater,parent,false)
        val obj = MyViewHolder(binding, listener)
        return obj
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val products = productList[position]
        holder.binding.prodName.text = products.name
        holder.binding.prodPrice.text = "$ " + products.price
        holder.binding.prodQty.text = products.qty.toString()

        holder.itemView.setOnClickListener {
            val dialog = AlertDialog.Builder(context)
            dialog.setTitle("Update/Delete")
                .setCancelable(true)
                .setMessage("Do you want to update or delete that product?")
                .setPositiveButton("Update", { dialogInterface, i ->

                    listener.update(products)


                })
                .setNegativeButton("Delete", {
                        dialogInterface, i->
                    listener.delete(products)
                    Toast.makeText(context,"Product deleted!", Toast.LENGTH_SHORT).show()
                })
                .setNeutralButton("Close", {dialogInterface, i->
                    dialogInterface.cancel()
                }).show()


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

    class MyViewHolder(val binding: ProductItemBinding,  val listener: updateClick):RecyclerView.ViewHolder(binding.root)
    {

    }

    interface updateClick{
        fun update(product: Product)
        fun delete(product: Product)
    }
}