package com.niangaoa.business_simulator_client.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.niangaoa.business_simulator_client.i18n.I18nMain

class BSTest {
    @Composable
    fun testView() {
        var test by remember { mutableStateOf(I18nMain.i18nData) }
        var b = 0
        Column {
            Button(onClick = { println(test.single_player)}) {
                Text(test.single_player)
            }
            Button(onClick = { println(test.multiply_player)}) {
                Text(test.multiply_player)
            }
            Button(onClick = {
                if (b == 0) {
                    I18nMain.i18nRead("BSSetting/lang/en_US.json")
                    b = 1
                }else if (b == 1) {
                    I18nMain.i18nRead("BSSetting/lang/zh_CH.json")
                    b = 0
                }
                test = I18nMain.i18nData
                println(test.single_player)
            }) {
                Text("切换语言")
            }
        }
    }
}