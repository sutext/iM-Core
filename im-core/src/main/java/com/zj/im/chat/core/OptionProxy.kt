@file:Suppress("unused")

package com.zj.im.chat.core

import android.app.Application
import android.app.Notification
import com.zj.im.chat.enums.RuntimeEfficiency
import com.zj.im.utils.Constance

/**
 * created by ZJJ
 *
 * build as a proxy to init SDK, {@see }
 * */

class OptionProxy internal constructor(private val context: Application) {

    private var notification: Notification? = null
    private var sessionId: Int = 0
    private var debugEnable = false
    private var logsCollectionAble: () -> Boolean = { false }
    private var logsMaxRetain: Long = Constance.MAX_RETAIN_TCP_LOG
    private var logsFilePath: String = Constance.FOLDER_NAME
    private var runtimeEfficiency = RuntimeEfficiency.HIGH

    fun setNotify(notification: Notification?): OptionProxy {
        this.notification = notification
        return this
    }

    fun setSessionId(sessionId: Int): OptionProxy {
        this.sessionId = sessionId
        return this
    }

    fun setLevel(efficiency: RuntimeEfficiency): OptionProxy {
        this.runtimeEfficiency = efficiency
        return this
    }

    fun debug(): OptionProxy {
        debugEnable = true
        return this
    }

    fun setLogsMaxRetain(maxRetain: Long): OptionProxy {
        this.logsMaxRetain = maxRetain
        return this
    }

    fun logsCollectionAble(logsCollectionAble: () -> Boolean): OptionProxy {
        this.logsCollectionAble = logsCollectionAble
        return this
    }

    fun logsFilePath(path: String): OptionProxy {
        this.logsFilePath = path
        return this
    }

    fun build(): IMOption {
        return IMOption(context, notification, sessionId, runtimeEfficiency, logsCollectionAble, logsFilePath, logsMaxRetain, debugEnable)
    }
}
