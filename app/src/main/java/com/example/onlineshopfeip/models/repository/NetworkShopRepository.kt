package com.example.onlineshopfeip.models.repository

import com.example.onlineshopfeip.models.Product
import com.example.onlineshopfeip.models.coroutines.IoDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class NetworkShopRepository(private val ioDispatcher: IoDispatcher) : ShopRepository {

    override suspend fun getProductById(productId: Long): Product =
        withContext(ioDispatcher.value) {
            delay(2000)

            Product(
                id = 1,
                title = "AMOGUS",
                isProductNew = true
            )
        }
}