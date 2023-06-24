package com.niangaoa.business_simulator_client.i18n

import com.alibaba.fastjson2.JSON
import java.io.*

class I18nMain {
    private val i18nFolder = File("BSSetting")
    private val i18nFile = File("BSSetting/zh_ch.json")
    var i18nData : JsonTemplate
    init{
        if (!i18nFile.isFile) {
            i18nFolder.mkdirs()
            i18nFile.createNewFile()
            val i18nInitOpS = FileOutputStream(i18nFile)
            val i18nInitOpSWriter = OutputStreamWriter(i18nInitOpS, "UTF-8")
            i18nInitOpSWriter.write(JSON.toJSONString(JsonTemplate()))
            i18nInitOpSWriter.close()
            i18nInitOpS.close()
        }
        val i18nIpS = FileInputStream(i18nFile)
        val i18nIpSReader = InputStreamReader(i18nIpS, "UTF-8")
        val sb = StringBuffer()
        while (i18nIpSReader.ready()) {
            sb.append(i18nIpSReader.read().toChar())
        }
        i18nIpSReader.close()
        i18nIpS.close()
        i18nData = JSON.parseObject(sb.toString(), JsonTemplate::class.java)
    }

    class JsonTemplate {
        var app_title = "营业模拟器"
        var single_player = "单人游戏"
        var multiplayer = "多人游戏"
    }
}
