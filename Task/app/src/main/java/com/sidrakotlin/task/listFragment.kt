package com.sidrakotlin.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sidrakotlin.task.databinding.FragmentListBinding


class listFragment : Fragment(),ProductAdapter.updateClick {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ViewModel
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentListBinding.inflate(layoutInflater,container,false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_productFragment)


        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = ProductAdapter(this@listFragment,requireContext())
        binding.recyclerView.adapter = adapter



        viewModel.products.observe(requireActivity(), Observer {
            adapter.updateList(it)


        })

        return binding.root


    }

    override fun update(product: Product) {

        viewModel.editData(product)
        findNavController().navigate(R.id.action_listFragment_to_productFragment)
    }

    override fun delete(product: Product) {

        viewModel.delete(product)

    }

}