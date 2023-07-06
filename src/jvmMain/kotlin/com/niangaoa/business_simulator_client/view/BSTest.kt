package com.niangaoa.business_simulator_client.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.niangaoa.business_simulator_client.i18n.I18nMain

class BSTest {
    @Composable
    fun testView() {
        Column {
            var text by remember { mutableStateOf(I18nMain.i18nData.single_player) }
            Button(onClick = { println(text)}) {
                Text(text)
            }
            Button(onClick = { println(I18nMain.i18nData.multiplayer)}) {
                Text(I18nMain.i18nData.multiplayer)
            }
            Button(onClick = {
                I18nMain.i18nRead("BSSetting/lang/en_US.json")
                text = I18nMain.i18nData.single_player
                println(I18nMain.i18nData.single_player)
            }) {
                Text("切换语言")
            }
        }
    }
}