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
import com.sidrakotlin.task.databinding.FragmentUpdateBinding


class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private lateinit var viewModel: ViewModel
    val args:UpdateFragmentArgs by navArgs()
    var productid = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentUpdateBinding.inflate(layoutInflater,container,false)

        binding.cancel.setOnClickListener {
            findNavController().navigate(R.id.action_updateFragment_to_allproductsFragment)
        }

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        productid = args.id

        binding.prodNameUpdate.setText(args.pname)
        binding.prodPriceUpdate.setText(args.pprice)
        binding.prodQtyUpdate.setText(args.pqty)

        binding.submitUpdate.setOnClickListener {
            update()
        }

        return binding.root
    }


    private fun update()
    {
        val idCv = productid.toInt()

        val pname = binding.prodNameUpdate.text.toString()
        val pprice = binding.prodPriceUpdate.text.toString()
        val pqty = binding.prodQtyUpdate.text.toString()

        if(pname.isNotEmpty() && pprice.isNotEmpty() && pqty.isNotEmpty())
        {
            val priceCv = pprice.toDouble()
            val qtyCv = pqty.toInt()

            val product = Product(idCv,pname,priceCv,qtyCv)
            viewModel.update(product)
            Toast.makeText(context, "Product updated!", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_allproductsFragment)
        }
        else{
            Toast.makeText(context, "Required", Toast.LENGTH_SHORT).show()
        }
    }
}