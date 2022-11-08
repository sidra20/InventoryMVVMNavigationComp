package com.sidrakotlin.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.sidrakotlin.task.databinding.FragmentAddBinding
import com.sidrakotlin.task.databinding.FragmentEditBinding


class editFragment : Fragment() {

    private lateinit var binding: FragmentEditBinding
    private lateinit var viewModel: ViewModel

    val args:editFragmentArgs by navArgs()
    var productid = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.viewModel=viewModel
        binding.lifecycleOwner=this


        productid = args.id

        binding.prodNameUpdate.setText(args.name)
        binding.prodPriceUpdate.setText(args.price)
        binding.prodQtyUpdate.setText(args.qty)

        return binding.root
    }



}