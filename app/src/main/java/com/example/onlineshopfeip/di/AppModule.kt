package com.example.onlineshopfeip.di

import com.example.onlineshopfeip.models.coroutines.IoDispatcher
import com.example.onlineshopfeip.models.repository.NetworkShopRepository
import com.example.onlineshopfeip.models.repository.ShopRepository
import com.example.onlineshopfeip.ui.screens.productprewiew.ProductPreviewViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val ioDispatcher = IoDispatcher(Dispatchers.IO)

val appModule = module {

    single<ShopRepository> { NetworkShopRepository(ioDispatcher) }
    viewModel { (productId: Long) -> ProductPreviewViewModel(productId, get()) }
}