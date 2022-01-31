package com.example.hqradioandroid.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.hqradioandroid.R
import kotlinx.coroutines.launch


@Composable
fun Loader() {

    val currentRotation by remember { mutableStateOf(0f) }
    val rotation = remember { Animatable(currentRotation) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(scope) {
        rotation.animateTo(
            targetValue = currentRotation + 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(3000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier.size(width = 100.dp, height = 100.dp).rotate(rotation.value),
            contentAlignment = Alignment.Center,
            ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Loading"
            )
        }
    }
}