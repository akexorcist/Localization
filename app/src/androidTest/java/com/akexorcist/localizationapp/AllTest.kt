package com.akexorcist.localizationapp

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    SimpleActivityTest::class,
    CustomActivityTest::class,
    StackedActivityTest::class,
    SimpleFragmentTest::class,
    NestedFragmentTest::class,
    ViewPagerTest::class
)
class AllTest
