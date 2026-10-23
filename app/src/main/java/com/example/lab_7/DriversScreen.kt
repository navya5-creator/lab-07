package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("driversBackButton")
        ) { Text("Back") }

        Text("FormulaZero Drivers")

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Driver Name") },
            modifier = Modifier.testTag("driverInput")
        )

        Button(
            onClick = {
                if (name.isNotBlank()) {
                    drivers.add(name)
                    name = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton")
        ) { Text("Add") }

        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearDriversButton")
        ) { Text("Clear All") }

        LazyColumn {
            items(drivers) { driver ->
                Text(driver)
            }
        }
    }
}
