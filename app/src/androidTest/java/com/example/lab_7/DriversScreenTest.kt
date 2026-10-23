package com.example.lab_7

import org.junit.Rule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Test
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput


@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_drivers_add_driver_and_return_home() {
        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify drivers screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Max Verstappen")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver appears
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        // clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // verify driver is removed
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}