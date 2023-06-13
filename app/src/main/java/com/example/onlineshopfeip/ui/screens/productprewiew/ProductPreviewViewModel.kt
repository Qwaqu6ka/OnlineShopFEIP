package com.example.onlineshopfeip.ui.screens.productprewiew

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.onlineshopfeip.models.LiveResult
import com.example.onlineshopfeip.models.MutableLiveResult
import com.example.onlineshopfeip.models.PendingResult
import com.example.onlineshopfeip.models.SuccessResult
import kotlinx.coroutines.launch

class ProductPreviewViewModel(
    val productId: Long,
//    val repository: Repository,
    val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _listOfImages: MutableLiveResult<List<String>> = MutableLiveResult(PendingResult())
    val listOfImages: LiveResult<List<String>> = _listOfImages

    init {
        getImages()
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

    companion object {

        fun getFactory(productId: Long): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return ProductPreviewViewModel(
                    productId,
//                    (application as App).myRepository,
                    savedStateHandle
                ) as T
            }
        }
    }
}