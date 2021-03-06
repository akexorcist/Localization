package com.akexorcist.localizationapp.runner

import android.os.Build
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.internal.util.AndroidRunnerParams
import com.akexorcist.localizationapp.annotation.TargetApiLevel
import org.junit.runner.notification.RunNotifier
import org.junit.runners.model.FrameworkMethod

class AndroidSdkLevel29TestRunner: AndroidJUnit4ClassRunner {
    constructor(klass: Class<*>?, runnerParams: AndroidRunnerParams?) : super(klass, runnerParams)
    constructor(klass: Class<*>?) : super(klass)

    override fun runChild(method: FrameworkMethod, notifier: RunNotifier) {
        val condition: TargetApiLevel = method.getAnnotation(TargetApiLevel::class.java)
        if (condition.value < Build.VERSION_CODES.Q) {
            notifier.fireTestIgnored(describeChild(method))
        } else {
            super.runChild(method, notifier)
        }
    }
}
