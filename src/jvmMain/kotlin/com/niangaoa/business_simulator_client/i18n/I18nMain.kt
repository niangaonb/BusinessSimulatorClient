package com.niangaoa.business_simulator_client.i18n

import com.alibaba.fastjson2.JSON
import java.io.*
/**
 * 负责所有I18n的操作，利用单例设计模式实现
 * @author niangaoa
 * */
object I18nMain {
    private val i18nFolder = File("BSSetting/lang")
    private val i18nInit = File("BSSetting/lang/zh_CH.json")
    private val i18nEn = File("BSSetting/lang/en_US.json")
    private var i18nFile = ""
    lateinit var i18nData : I18nTemplate

    /**
     * 读取文件内容并更新i18nData
     * @param path 文件位置
     * */
    fun i18nRead(path : String) {
        i18nFile = path
        val i18nIpS = FileInputStream(File(i18nFile))
        val i18nIpSReader = InputStreamReader(i18nIpS, "UTF-8")
        val sb = StringBuffer()
        while (i18nIpSReader.ready()) {
            sb.append(i18nIpSReader.read().toChar())
        }
        i18nIpSReader.close()
        i18nIpS.close()
        //更新
        i18nData = JSON.parseObject(sb.toString(), I18nTemplate::class.java)
    }

    /**
     * 初始化i18n文件
     * @param file 文件，要输出文本
     * @param template 选择需要的模板
     * */
    private fun i18nWrite(file: File, template : I18nTemplate) {
        file.createNewFile()
        val i18nInitOpS = FileOutputStream(file)
        val i18nInitOpSWriter = OutputStreamWriter(i18nInitOpS, "UTF-8")
        i18nInitOpSWriter.write(JSON.toJSONString(template))
        i18nInitOpSWriter.close()
        i18nInitOpS.close()
    }

    //初始化i18n
    init{
        //如果没有语言文件就新建并且写入
        if (!(i18nInit.isFile && i18nEn.isFile)) {
            i18nFolder.mkdirs()
            i18nWrite(i18nInit, ZHCNTemplate())
            i18nWrite(i18nEn, ENUSTemplate())
        }
        //写入后读取(默认为中文)
        i18nRead("BSSetting/lang/zh_CH.json")
    }
}
