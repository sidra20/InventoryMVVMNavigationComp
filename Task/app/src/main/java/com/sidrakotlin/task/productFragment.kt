package com.sidrakotlin.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sidrakotlin.task.databinding.FragmentProductBinding


class productFragment : Fragment() {

    private lateinit var viewModel: ViewModel
    private lateinit var binding: FragmentProductBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

//        if(getArguments() != null) {
//            var name = args.productname
//            var price = args.price
//            var qty = args.qty
//
//            binding.prodNameEt.setText(name)
//            binding.prodPriceEt.setText(price)
//            binding.prodQtyEt.setText(qty)
//        }

        binding.viewModel=viewModel
        binding.lifecycleOwner=this


//        if(viewModel.isUpdate==true)
//        {
//            viewModel.editData()
//            binding.prodNameEt.setText(viewModel.proName.value)
//            binding.prodPriceEt.setText(viewModel.price.value)
//            binding.prodQtyEt.setText(viewModel.qty.value)
//        }




        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_productFragment_to_listFragment)
        }
        return binding.root
    }

}