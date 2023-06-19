package com.example.onlineshopfeip.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.onlineshopfeip.R
import com.example.onlineshopfeip.models.ErrorResult
import com.example.onlineshopfeip.models.PendingResult
import com.example.onlineshopfeip.models.Result
import com.example.onlineshopfeip.models.SuccessResult

@Composable
fun <T> RenderSimpleResult(
    result: Result<T>,
    onTryAgain: () -> Unit,
    modifier: Modifier = Modifier,
    onSuccess: @Composable (T) -> Unit,
) {
    RenderResult(
        result = result,
        onSuccess = onSuccess,
        onPending = { CircularProgressIndicator() },
        onError = { ErrorMessage(e = it, onTryAgain = onTryAgain) },
        modifier = modifier
    )
}

@Composable
fun <T> RenderResult(
    result: Result<T>,
    onSuccess: @Composable (T) -> Unit,
    onPending: @Composable () -> Unit,
    onError: @Composable (Exception) -> Unit,
    modifier: Modifier = Modifier
) {
    val isResultAlignToCenter = result !is SuccessResult
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = if (isResultAlignToCenter) Alignment.Center else Alignment.TopStart
    ) {
        when (result) {
            is SuccessResult -> onSuccess(result.data)
            is PendingResult -> onPending()
            is ErrorResult -> onError(result.exception)
        }
    }
}

@Composable
private fun ErrorMessage(e: Exception, onTryAgain: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 20.dp)
    ) {
        val context = LocalContext.current
        Text(text = context.getString(R.string.loading_error_message))
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = onTryAgain) {
            Text(text = context.getString(R.string.try_again))
        }
    }
}