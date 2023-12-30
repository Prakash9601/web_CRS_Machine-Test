package com.softland.machinetest.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.softland.machinetest.R
import com.softland.machinetest.model.ItemsItem
import com.softland.machinetest.navigation.AllDestinations.itemsId
import com.softland.machinetest.navigation.AllDestinations.navController
import com.softland.machinetest.navigation.ArcRotationWithAlpha
import com.softland.machinetest.navigation.Route
import com.softland.machinetest.utils.ConnectionState
import com.softland.machinetest.utils.Const
import com.softland.machinetest.utils.connectivityState
import com.softland.machinetest.viewModel.MyViewModel


@Preview
@Composable
fun ListingPage(myViewModel: MyViewModel = hiltViewModel()){
   val dpItems = myViewModel.fetchProduct?.observeAsState()
    var loadingProgressBar by remember { mutableStateOf(true) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopBar()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colorResource(id = R.color.Header))
                .padding(top = 5.dp),
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 20.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                )
            ) {
                LazyVerticalGrid(modifier = Modifier.padding(10.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(5.dp)
                ) {
                    items(dpItems?.value?.size?:0){

                            loadingProgressBar = false

                        ItemsList(dpItems?.value?.get(it))
                    }
                }
            }
            }
        }

    ArcRotationWithAlpha(loadingProgressBar = loadingProgressBar)
}




@Composable
fun ItemsList(products: ItemsItem?) {
    val image = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = products?.image).apply(block = fun ImageRequest.Builder.() {
            crossfade(true)
        }).build()
    )
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(8.dp)
            .clickable {
                itemsId?.value = products?.id ?: 0
                navController.navigate(Route.ListingDetails.route)
            }
            .background(Color.White),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(8.dp)
            )

            Space(10.dp)
            Text(
                text = products?.title.toString(),
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                softWrap = false
            )
            Space(10.dp)
            Card(
                modifier = Modifier
                    .wrapContentWidth()
                    .background(Color(R.color.Green)),
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier
                        .background(Color(R.color.Green))
                        .padding(start = 3.dp)
                ) {
                    // You can replace the Image with your star image

                    Text(
                        text = products?.rating?.rate.toString(), // Assuming rating is a Float or Int
                        fontSize = 12.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow, // Set the color of the star icon
                        modifier = Modifier.size(16.dp)
                    )

                }

            }
            Space(10.dp)
            Text(
                text = "₹" + products?.price,
                fontSize = 10.sp,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }

    }



}
