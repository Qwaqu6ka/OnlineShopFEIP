package com.example.onlineshopfeip.ui.screens.productprewiew

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.onlineshopfeip.R
import com.example.onlineshopfeip.models.PendingResult
import com.example.onlineshopfeip.ui.components.RenderSimpleResult
import com.example.onlineshopfeip.ui.components.SlidingCarousel
import com.example.onlineshopfeip.ui.components.TagList
import com.example.onlineshopfeip.ui.theme.ColorFavorite

@Composable
fun ProductPreviewScreen(
    viewModel: ProductPreviewViewModel
) {
    val productResultState by viewModel.product.observeAsState(PendingResult())

    RenderSimpleResult(result = productResultState, onTryAgain = viewModel::onTryAgain) { product ->
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            ImagePart(product.isProductNew, emptyList())
            Spacer(modifier = Modifier.height(30.dp))
            TagList(
                tags = listOf(
                    "fdjsalkfsd",
                    "kdfjsldfkj",
                    "jfdslkfjs",
                    "fjsdlkfjdsjfslkf",
                    "fjslkdfjskdflksd",
                    "slkdjflskdjflksjdf"
                )
            )
            Text(
                text = product.title,
                Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun ImagePart(
    isProductNew: Boolean,
    imagesUrlList: List<String>?
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {
            if (!imagesUrlList.isNullOrEmpty()) {
                SlidingCarousel(
                    itemsCount = imagesUrlList.size,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        // todo: Glide
                        bitmap = ImageBitmap.imageResource(id = R.drawable.product_placeholder),
                        contentDescription = context.getString(R.string.image_of_product),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            } else {
                Image(
                    bitmap = ImageBitmap.imageResource(id = R.drawable.product_placeholder),
                    contentDescription = context.getString(R.string.image_of_product),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = context.getString(R.string.go_back_button)
            )
        }

        var isFavorite by remember { mutableStateOf(false) }
        IconToggleButton(
            checked = isFavorite,
            onCheckedChange = { isFavorite = it },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if (isFavorite) ColorFavorite else MaterialTheme.colorScheme.primary,
                contentDescription = context.getString(R.string.add_to_favorite_button)
            )
        }

        if (isProductNew)
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_new_patch),
                contentDescription = context.getString(R.string.new_product_patch),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            )
    }
}