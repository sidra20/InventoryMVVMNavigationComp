package com.sidrakotlin.task
import android.app.Application
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import kotlinx.coroutines.launch

class ViewModel(app:Application) : AndroidViewModel(app) {


    val dao = AppDatabase.getInstance(app).productDao()

    private val repository = Repository(dao)
    val products = repository.products  //livedata

    var proName = MutableLiveData<String>()
    var price = MutableLiveData<String>()
    var qty = MutableLiveData<String>()
    
    var isUpdate = false

    fun insert(product: Product) = viewModelScope.launch {
        repository.insert(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        repository.delete(product)
    }

    fun update(product: Product) = viewModelScope.launch {
        repository.update(product)
    }

    fun editData(product: Product)
    {
        isUpdate=true
        proName.value = product.name!!
        price.value = ""+product.price
        qty.value=""+product.qty

    }
    fun saveData()
    {

        if(proName.value!!.isNotEmpty() && price.value!!.isNotEmpty() && qty.value!!.isNotEmpty())
        {
            val name = proName.value!!.toString()
            val proprice = price.value!!.toDouble()
            val proqty = qty.value!!.toInt()
            val obj = Product(0,name,proprice,proqty)
            insert(obj)

            Toast.makeText(getApplication(),"Product added", Toast.LENGTH_SHORT).show()

            proName.value=""
            price.value=""
            qty.value=""


        }
        else{
            Toast.makeText(getApplication(),"Required!", Toast.LENGTH_SHORT).show()

        }



    }

}