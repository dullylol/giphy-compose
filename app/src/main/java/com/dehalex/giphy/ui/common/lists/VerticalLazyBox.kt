package com.dehalex.giphy.ui.common.lists

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <E> VerticalLazyBox(
    modifier: Modifier = Modifier,
    rows: Int,
    items: List<E>,
    itemContent: @Composable (E) -> Unit,
) {

    LazyColumn(
        modifier = modifier,
    ) {

        for (indexWithStep in items.indices step rows) {

            item {

                Row {

                    for (index in indexWithStep until indexWithStep + rows) {

                        items.getOrNull(index)?.let { itemContent(it) }
                    }
                }
            }
        }
    }
}