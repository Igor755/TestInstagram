package com.company.sonikplams.testinstagram

import junit.framework.TestCase.assertNotNull
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    var mactivity : MainActivity? = null

    @Throws(Exception::class)
    @Before
    fun setup() {
        mactivity = Robolectric.buildActivity(MainActivity :: class.java).create().resume().get()
    }

    @Test
    fun activityShouldNotBeNull() {
        assertNotNull(mactivity)
    }
}