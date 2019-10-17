package com.example.mvvmsample.activities

import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    lateinit var mainActivity: MainActivity

    @Rule @JvmField
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    //@get:Rule var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        mainActivity = activityTestRule.activity
    }

    @Test
    fun testAct() {
        assertEquals("hello", mainActivity.txt.text.toString())
    }

    @After
    fun tearDown() {
    }
}