package com.niangaoa.business_simulator_client

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.niangaoa.business_simulator_client.i18n.I18nMain
import com.niangaoa.business_simulator_client.view.BSTest


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = I18nMain.i18nData.app_title) {
        BSTest().testView()
    }
}
