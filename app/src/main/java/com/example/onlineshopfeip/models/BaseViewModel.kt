package com.example.onlineshopfeip.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

typealias LiveResult<T> = LiveData<Result<T>>
typealias MutableLiveResult<T> = MutableLiveData<Result<T>>