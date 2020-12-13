package com.android.lookweather

import android.app.Application
import android.content.Context

/**
 * Created by midFang on 2020/8/28
 * Useful:
 */
class SunnyWeatherApplication : Application() {

    companion object {
        // 全局提供 context 方式
        lateinit var context: Context

        // todo 测试需要填写 token 值
        const val TOKEN = ""
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}