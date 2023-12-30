package com.softland.machinetest.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.softland.machinetest.R
import com.softland.machinetest.navigation.AllDestinations
import com.softland.machinetest.viewModel.MyViewModel


@Preview
@Composable
fun ItemDetails(myViewModel: MyViewModel = hiltViewModel()) {



    val list = myViewModel.appDatabase?.ProductDao()?.getCategory(AllDestinations.itemsId?.value ?: 0)?.observeAsState()

    val scrollState = rememberScrollState()
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
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .verticalScroll(scrollState)
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                    ) {
                        val image = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(data = list?.value?.get(0)?.image)
                                .apply(block = fun ImageRequest.Builder.() {
                                    crossfade(true)
                                }).build()
                        )

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(350.dp)
                                .padding(10.dp)
                                .background(Color.White),
                            elevation = CardDefaults.cardElevation(
                                defaultElevation = 10.dp
                            )
                        ) {
                            Image(
                                painter = image,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(), // Use fillMaxHeight to take the full height of the container
                                contentScale = ContentScale.Fit,
                                alignment = Alignment.Center
                            )

                        }

                        Card(
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                                list?.value?.get(0)?.let {
                                    SimpleButton(
                                        text = it.category ?: "",
                                        shape = CutCornerShape(
                                            topStartPercent = 50,
                                            bottomStartPercent = 50
                                        )
                                    )
                                }
                            }
                            // Top Column
                            Column(
                                modifier = Modifier
                                    .padding(10.dp)
                            ) {
                                // Add any content you want at the top of the card view here


                                Spacer(
                                    modifier = Modifier
                                        .height(5.dp) // You can adjust the height as needed
                                )


                                // Text Elements
                                Text(
                                    text = list?.value?.get(0)?.title ?: "",
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Start,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Serif
                                )

                                Spacer(
                                    modifier = Modifier
                                        .height(10.dp) // You can adjust the height as needed
                                )
                                Text(
                                    text = "Count: ${list?.value?.get(0)?.rating?.count}",
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(
                                    modifier = Modifier
                                        .height(10.dp) // You can adjust the height as needed
                                )

                                RatingBar(rating =list?.value?.get(0)?.rating?.rate?:0.0)



                                Spacer(
                                    modifier = Modifier
                                        .height(10.dp) // You can adjust the height as needed
                                )

                                Text(
                                    text = "₹" + list?.value?.get(0)?.price,
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily.Serif,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(
                                    modifier = Modifier
                                        .height(10.dp) // You can adjust the height as needed
                                )

                                Text(
                                    text = list?.value?.get(0)?.description ?: "",
                                    fontSize = 12.sp,
                                    textAlign = TextAlign.Start,
                                    fontFamily = FontFamily.Serif
                                )

                                Spacer(
                                    modifier = Modifier
                                        .height(40.dp) // You can adjust the height as needed
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
