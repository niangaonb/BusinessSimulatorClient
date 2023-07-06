package com.niangaoa.business_simulator_client.i18n

import com.alibaba.fastjson2.JSON
import java.io.*
object I18nMain {
    var stringTest = "zh_CH"
    private val i18nFolder = File("BSSetting/lang")
    private val i18nFile1 = File("BSSetting/lang/zh_CH.json")
    private val i18nFile2 = File("BSSetting/lang/en_US.json")
    lateinit var i18nData : CHTemplate

    fun i18nRead(s : String) {
        val i18nIpS = FileInputStream(File(s))
        val i18nIpSReader = InputStreamReader(i18nIpS, "UTF-8")
        val sb = StringBuffer()
        while (i18nIpSReader.ready()) {
            sb.append(i18nIpSReader.read().toChar())
        }
        i18nIpSReader.close()
        i18nIpS.close()
        i18nData = JSON.parseObject(sb.toString(), CHTemplate::class.java)
    }

    init{
        if (true) {
            i18nFolder.mkdirs()
            i18nFile1.createNewFile()
            val i18nInitOpS = FileOutputStream(i18nFile1)
            val i18nInitOpSWriter = OutputStreamWriter(i18nInitOpS, "UTF-8")
            i18nInitOpSWriter.write(JSON.toJSONString(CHTemplate()))
            i18nInitOpSWriter.close()
            i18nInitOpS.close()


            i18nFile2.createNewFile()
            val i18nInitOpS1 = FileOutputStream(i18nFile2)
            val i18nInitOpSWriter1 = OutputStreamWriter(i18nInitOpS1, "UTF-8")
            i18nInitOpSWriter1.write(JSON.toJSONString(ENTemplate()))
            i18nInitOpSWriter1.close()
            i18nInitOpS1.close()
        }
        i18nRead("BSSetting/lang/zh_CH.json")
    }

    class CHTemplate {
        var app_title = "营业模拟器"
        var single_player = "单人游戏"
        var multiplayer = "多人游戏"
    }

    class ENTemplate {
        var app_title = "Business Simulator"
        var single_player = "SinglePlayer"
        var multiplayer = "MultiPlayer"
    }
}
