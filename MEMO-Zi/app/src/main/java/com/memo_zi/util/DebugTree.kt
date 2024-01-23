package com.memo_zi.util

import timber.log.Timber

class DebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "${element.fileName}:${element.lineNumber}#${element.methodName}"
}