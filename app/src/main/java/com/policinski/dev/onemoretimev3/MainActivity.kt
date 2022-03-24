package com.policinski.dev.onemoretimev3

import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.compose.viewModel
import com.policinski.dev.onemoretimev3.ui.theme.OneMoreTimeV3Theme
import com.policinski.dev.onemoretimev3.ui.theme.room.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appViewModel by viewModels<AppViewModel>()
        setContent {
            OneMoreTimeV3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(appViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(appViewModel: AppViewModel) {


    var productList = appViewModel.allData

    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
        LazyColumn() {
            itemsIndexed(items = productList.value) { index, item ->
                Row() {
                    Text(text = item.name, modifier = Modifier.weight(1f))
                    Text(text = "${item.kcal}")
                }
            }
        }

        Row() {
            Button(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 4.dp),
                onClick = {
                    appViewModel.addNewProduct(
                        ProductEntity(
                            name = "sample",
                            favorite = true,
                            weight = 100.0,
                            kcal = 374.0,
                            pro = 14.0,
                            fat = 7.0,
                            car = 64.0
                        )
                    )
                }
            ) {
                Text(text = "Add")
            }
            Button(modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp, vertical = 4.dp),
                onClick = {
                    appViewModel.clearDataBase()
                }
            ) {
                Text(text = "Clear")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OneMoreTimeV3Theme {

    }
}