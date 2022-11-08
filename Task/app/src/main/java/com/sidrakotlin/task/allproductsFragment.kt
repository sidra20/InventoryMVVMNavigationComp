package com.sidrakotlin.task

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidrakotlin.task.databinding.FragmentAllproductsBinding
import com.sidrakotlin.task.databinding.FragmentListBinding


class allproductsFragment : Fragment(), ProductAdapter2.Listener {


    private lateinit var binding: FragmentAllproductsBinding
    private lateinit var viewModel: ViewModel
    private lateinit var adapter: ProductAdapter2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllproductsBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.fabAdd2.setOnClickListener {
            findNavController().navigate(R.id.action_allproductsFragment_to_addFragment)
        }

        binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())

        adapter = ProductAdapter2(this@allproductsFragment,requireContext())
        binding.recyclerView2.adapter = adapter

        viewModel.products.observe(requireActivity(), Observer {
            adapter.updateList(it)
        })

        return binding.root
    }

    fun updateProduct(product: Product)
    {

        var action = allproductsFragmentDirections.actionAllproductsFragmentToUpdateFragment(product.id.toString(),product.name.toString(), product.price.toString(), product.qty.toString())
        findNavController().navigate(action)

    }
    override fun itemClick(product: Product) {
        val dialog = AlertDialog.Builder(context)
        dialog.setTitle("Update/Delete")
            .setCancelable(true)
            .setMessage("Do you want to update or delete that product?")
            .setPositiveButton("Update", { dialogInterface, i ->

                updateProduct(product)


            })
            .setNegativeButton("Delete", {
                    dialogInterface, i->
                viewModel.delete(product)
                Toast.makeText(context,"Product deleted!", Toast.LENGTH_SHORT).show()
            })
            .setNeutralButton("Close", {dialogInterface, i->
                dialogInterface.cancel()
            }).show()
    }


}