package com.dehalex.giphy.ui.screens.trendgifs

import android.os.Build.VERSION.SDK_INT
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.ImageLoader
import coil.compose.SubcomposeAsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.dehalex.giphy.domain.entities.categories.Category
import com.dehalex.giphy.domain.entities.categories.Subcategory
import com.dehalex.giphy.ui.common.lists.VerticalLazyBox
import com.dehalex.giphy.ui.common.modifier.clickable.onClickWithRippleAnimation
import com.dehalex.giphy.ui.common.spacer.HeightSpacer
import com.dehalex.giphy.ui.common.toolbars.MainToolbar
import com.dehalex.giphy.values.colors.AppColors
import com.dehalex.giphy.values.strings.AppStrings

@Composable
fun TrendingGifsComponent(
    trendingGifsViewModel: TrendingGifsViewModel = viewModel(),
) {

    val context = LocalContext.current
    val configuration = LocalConfiguration.current

    val imageLoaderForGifs = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.DarkBlue),
    ) {

        MainToolbar(
            title = AppStrings().appName,
            onSearchClick = trendingGifsViewModel::onSearchButtonClicked,
            onSettingClick = trendingGifsViewModel::onSettingsButtonClicked,
        )

        HeightSpacer(8.dp)

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
        ) {

            trendingGifsViewModel.categories.forEach { category ->

                item {

                    CategoryItem(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        category = category,
                        selected = category.id == trendingGifsViewModel.selectedCategoryId,
                        onCategoryClicked = trendingGifsViewModel::onCategoryClicked,
                    )
                }
            }
        }

        trendingGifsViewModel
            .categories
            .find { it.id == trendingGifsViewModel.selectedCategoryId }
            ?.subcategories
            ?.let { subcategories ->

                HeightSpacer(8.dp)

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateContentSize(),
                ) {

                    subcategories.forEach { subcategory ->

                        item {

                            SubcategoryItem(
                                modifier = Modifier.padding(horizontal = 4.dp),
                                subcategory = subcategory,
                                selected = subcategory.id == trendingGifsViewModel.selectedSubcategoryId,
                                onSubcategoryClicked = trendingGifsViewModel::onSubcategoryClicked,
                            )
                        }
                    }
                }
            }

        HeightSpacer(8.dp)

        VerticalLazyBox(
            modifier = Modifier.fillMaxSize(),
            rows = 3,
            items = trendingGifsViewModel.gifs,
        ) { gif ->

            SubcomposeAsyncImage(
                modifier = Modifier
                    .size(configuration.screenWidthDp.dp / 3)
                    .onClickWithRippleAnimation { trendingGifsViewModel.onGifClicked(gif) },
                model = gif.previewUrl,
                contentDescription = null,
                imageLoader = imageLoaderForGifs,
            )
        }
    }
}

@Composable
private fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category,
    selected: Boolean,
    onCategoryClicked: (Category) -> Unit,
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(45.dp))
            .background(if (selected) AppColors.LightPurple else AppColors.GreyBlue)
            .onClickWithRippleAnimation { onCategoryClicked(category) },
    ) {

        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
            text = category.name,
            fontSize = 16.sp,
            color = AppColors.White,
        )
    }
}

@Composable
private fun SubcategoryItem(
    modifier: Modifier = Modifier,
    subcategory: Subcategory,
    selected: Boolean,
    onSubcategoryClicked: (Subcategory) -> Unit,
) {

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(45.dp))
            .background(if (selected) AppColors.LightPurple else AppColors.GreyBlue)
            .onClickWithRippleAnimation { onSubcategoryClicked(subcategory) },
    ) {

        Text(
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
            text = subcategory.name,
            fontSize = 16.sp,
            color = AppColors.White,
        )
    }
}