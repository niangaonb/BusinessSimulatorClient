package com.niangaoa.business_simulator_client.i18n

/**
 * 存储I18n模板的位置
 * @author niangaoa
 * */
open class I18nTemplate(
    open var app_title: String = "",
    open var single_player: String = "",
    open var multiply_player: String = ""
)

data class ZHCNTemplate(
    override var app_title: String = "营业模拟器",
    override var single_player: String = "单人游戏",
    override var multiply_player: String = "多人游戏"
) : I18nTemplate()

data class ENUSTemplate(
    override var app_title: String = "Business Simulator",
    override var single_player: String = "SinglePlayer",
    override var multiply_player: String = "MultiplyPlayer"
) : I18nTemplate()
