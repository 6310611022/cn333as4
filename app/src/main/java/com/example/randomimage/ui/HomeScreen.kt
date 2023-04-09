package com.example.randomimage.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.randomimage.R

@Composable
fun SetValueScreen(navController: NavController){
    var heightValue by remember { mutableStateOf("") }
    var widthValue by remember { mutableStateOf("") }
    var categoryValue by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(36.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        Text(
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 27.sp,
            fontFamily = Montserrat,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(30.dp))

        heightBox(
            value = heightValue,
            onValueChange = { heightValue = it })

        Spacer(modifier = Modifier.height(10.dp))

        widthBox(value = widthValue,
            onValueChange = { widthValue = it })

        Spacer(modifier = Modifier.height(30.dp))


        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "kitten"},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFD98481)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category1),
                color = Color(0xFFEDCA7F),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "dog"},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE9B9AA)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category2),
                color = Color(0xFF7892B5),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "bunny"},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEDCA7F)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category3),
                color = Color(0xFF91B5A9),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "books"},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF8CB9C0)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category4),
                color = Color(0xFF7892B5),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "cars"},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF91B5A9)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category5),
                color = Color(0xFFEDCA7F),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = {categoryValue = "flowers"},
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFBC9BE)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category6),
                color = Color(0xFFD98481),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 8.dp),
            onClick = { navController.navigate("Show Image/$widthValue/$heightValue/$categoryValue") },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF7892B5)),
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.view_image),
                color = Color(0xFFE9B9AA),
                fontSize = 18.sp,
                fontFamily = Montserrat,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
fun heightBox(value: String,
              onValueChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.height),
            fontFamily = Montserrat,
            fontSize = 16.sp) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus()})

    )
}

@Composable
fun widthBox(value: String,
             onValueChange: (String) -> Unit,
             ) {
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(R.string.width),
            fontFamily = Montserrat,
            fontSize = 16.sp) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus()})
        )
}


