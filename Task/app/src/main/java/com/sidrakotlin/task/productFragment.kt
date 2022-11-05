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

        binding.viewModel = viewModel
        binding.lifecycleOwner=this

//        if(viewModel.isUpdate==true)
//        {
//            viewModel.editData()
//            binding.prodNameEt.setText(viewModel.proName.value)
//            binding.prodPriceEt.setText(viewModel.price.value)
//            binding.prodQtyEt.setText(viewModel.qty.value)
//        }
        return binding.root
    }

}