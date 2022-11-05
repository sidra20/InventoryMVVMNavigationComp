package com.sidrakotlin.task

class Repository(private val dao:ProductDao) {

    val products = dao.getAllProduct()

    suspend fun insert(product: Product)
    {
        dao.insertProduct(product)
    }

    suspend fun delete(product: Product)
    {
        dao.deleteProduct(product)
    }

    suspend fun update(product: Product)
    {
        dao.updateProduct(product)
    }


}