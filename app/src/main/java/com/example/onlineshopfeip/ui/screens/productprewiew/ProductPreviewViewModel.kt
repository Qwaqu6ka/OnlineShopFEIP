package com.example.onlineshopfeip.ui.screens.productprewiew

import com.example.onlineshopfeip.models.BaseViewModel
import com.example.onlineshopfeip.models.LiveResult
import com.example.onlineshopfeip.models.MutableLiveResult
import com.example.onlineshopfeip.models.PendingResult
import com.example.onlineshopfeip.models.Product
import com.example.onlineshopfeip.models.SuccessResult
import com.example.onlineshopfeip.models.repository.ShopRepository
import kotlinx.coroutines.launch

class ProductPreviewViewModel(
    private val productId: Long,
    private val repository: ShopRepository
) : BaseViewModel() {

    private val _product: MutableLiveResult<Product> = MutableLiveResult(PendingResult())
    val product: LiveResult<Product> = _product

    private val _listOfImages: MutableLiveResult<List<String>> = MutableLiveResult(PendingResult())
    val listOfImages: LiveResult<List<String>> = _listOfImages

    init {
        loadProduct()
    }

    fun onTryAgain() {
        _product.value = PendingResult()
        loadProduct()
    }

    private fun getImages() = viewModelScope.launch {
        _listOfImages.value = SuccessResult(listOf(
            "sdkjf",
            "fdsjf",
            "sdkjf",
            "fdsjf",
            "sdkjf",
            "fdsjf",
            "sdkjf",
            "fdsjf",
        ))
    }

    private fun loadProduct() {
        into(_product) { repository.getProductById(productId) }
    }
}