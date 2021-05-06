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
    SimpleDialogTest::class,
    DialogWebViewTest::class,
    ViewPagerTest::class,
    ListPreferencesTest::class,
    HiltDependencyInjectionTest::class,
    BroadcastReceiverTest::class,
//    DarkThemeTest::class,
)
class AllTest
