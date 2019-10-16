package com.example.mvvmsample.activities

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.example.mvvmsample.R
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    var mActivityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)


    private var nName="ccvbnm"

    @Before
    fun setUp() {
    }


    @Test
    fun testUserInputScenario()
    {
        // input some text in edittext
        Espresso.onView(withId(R.id.edt)).perform(typeText(nName))
        // close keyboard
        Espresso.closeSoftKeyboard()
        // perform click
        Espresso.onView(withId(R.id.btn)).perform(click())
        // checking text in text view
        Espresso.onView(withId(R.id.txt)).check(matches(withText(nName)))
    }

    @After
    fun tearDown() {
    }
}