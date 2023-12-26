package com.turkoglu.composedeneme.presentation.detail.view

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.turkoglu.composedeneme.presentation.detail.DetailScreenViewModel

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable()
fun DetailScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: DetailScreenViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {

        Text(text = state.title)
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = state.overview)


    }

}