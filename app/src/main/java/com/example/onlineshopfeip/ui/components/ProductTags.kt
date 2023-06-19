package com.example.onlineshopfeip.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.onlineshopfeip.ui.theme.GrayDim

@Composable
fun TagList(tags: List<String>) {
    LazyRow(Modifier.padding(horizontal = 20.dp)) {
        items(tags.size) {
            TagItem(label = tags[it])
            if (it != tags.lastIndex)
                Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun TagItem(label: String) {
    Text(
        text = label,
        style = MaterialTheme.typography.labelSmall,
        modifier = Modifier
            .border(width = 1.dp, color = GrayDim, shape = RoundedCornerShape(100))
            .padding(vertical = 6.dp, horizontal = 12.dp)
    )
}