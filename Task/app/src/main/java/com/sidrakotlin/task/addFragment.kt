package com.sidrakotlin.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sidrakotlin.task.databinding.FragmentAddBinding
import com.sidrakotlin.task.databinding.FragmentListBinding

class addFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentAddBinding.inflate(layoutInflater,container,false)

        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_addFragment_to_allproductsFragment)
        }

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)


        binding.submit2.setOnClickListener {
            insert()
        }



        return binding.root
    }



    private fun insert()
    {

        val pname = binding.prodNameEt2.text.toString()
        val pprice = binding.prodPriceEt2.text.toString()
        val pqty = binding.prodQtyEt2.text.toString()

        if(pname.isNotEmpty() && pprice.isNotEmpty() && pqty.isNotEmpty())
        {
            val priceCv = pprice.toDouble()
            val qtyCv = pqty.toInt()

            val product = Product(0,pname,priceCv,qtyCv)
            viewModel.insert(product)
            Toast.makeText(context, "Product added!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_allproductsFragment)
        }
        else{
            Toast.makeText(context, "Required", Toast.LENGTH_SHORT).show()
        }



    }



}