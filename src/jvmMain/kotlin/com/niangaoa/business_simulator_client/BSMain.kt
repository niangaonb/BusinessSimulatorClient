package com.niangaoa.business_simulator_client

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.niangaoa.business_simulator_client.i18n.I18nMain

var i18nMain = I18nMain()
@Composable
@Preview
fun BSMain() {
    MaterialTheme {
        Column {
            Button(onClick = { println(i18nMain.i18nData.single_player)}) {
                Text(i18nMain.i18nData.single_player)
            }
            Button(onClick = { println(i18nMain.i18nData.multiplayer)}) {
                Text(i18nMain.i18nData.multiplayer)
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = i18nMain.i18nData.app_title) {
        BSMain()
    }
}
