package com.akexorcist.localizationapp.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class TargetApiLevel(val value: Int)
