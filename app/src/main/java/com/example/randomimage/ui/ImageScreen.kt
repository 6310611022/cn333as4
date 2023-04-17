package com.example.randomimage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.randomimage.ui.theme.Montserrat


@Composable
fun ImageScreen(navController: NavController,
                width : String,
                height: String,
                category: String){
    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(36.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        Text(
            text = stringResource(R.string.Image),
            textAlign = TextAlign.Center,
            fontSize = 27.sp,
            fontFamily = Montserrat,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color(0xFF925946),
            style = TextStyle(
                shadow = Shadow(
                    color = Color(0xFFDB9F95),
                    offset = Offset(3f, 3f),
                    blurRadius = 4f))
        )

        Spacer(modifier = Modifier.height(20.dp))

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://loremflickr.com/$width/$height/$category")
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.None,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF695356)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.home),
                color = Color(0xFFECB865),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}