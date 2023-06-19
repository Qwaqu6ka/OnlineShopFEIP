package com.example.onlineshopfeip.models.repository

import com.example.onlineshopfeip.models.Product

interface ShopRepository {

    suspend fun getProductById(productId: Long) : Product

}