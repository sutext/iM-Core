package com.zj.im.sender


interface OnStatus<T> {

    /**
     * After completing the execution of the additional task,
     * this callback needs to be called manually to complete the current task.
     * @param data The message data will be based on the result returned here.
     * */
    fun success(data: T)

    /**
     * @param payloadInfo is the custom information attached to the error type,
     * which can be obtained through [com.zj.im.chat.enums.SendMsgState.getSpecialBody].
     * */
    fun error(data: T? = null, e: Throwable?, payloadInfo: Any? = null)

    /**
     * @param progress Task execution progress.
     * */
    fun onProgress(progress: Int)

}