package com.example.convertercurrency

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.hamcrest.Matchers.containsString

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun rete_usd() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText("100"))

        onView(withId(R.id.calculatedButton))
            .perform(click())

        onView(withId(R.id.resultConvert))
            .check(matches(withText(containsString("$1.56"))))
    }

    @Test
    fun rate_eur() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText("100"))

        onView(withId(R.id.rate_eur))
            .perform(click())

        onView(withId(R.id.calculatedButton))
            .perform(click())

        onView(withId(R.id.resultConvert))
            .check(matches(withText(containsString("1,43"))))
    }

    @Test
    fun rate_jpy() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText("100"))

        onView(withId(R.id.rate_jpy)).perform(click())

        onView(withId(R.id.calculatedButton)).perform(click())

        onView(withId(R.id.resultConvert))
            .check(matches(withText(containsString("250"))))
    }

    @Test
    fun roundUpUsd() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText("100"))

        onView(withId(R.id.roundUpConvert)).perform(click())

        onView(withId(R.id.calculatedButton)).perform(click())

        onView(withId(R.id.resultConvert))
            .check(matches(withText(containsString("$2.00"))))
    }

    @Test
    fun roundUpEur() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText("100"))

        onView(withId(R.id.rate_eur)).perform(click())

        onView(withId(R.id.roundUpConvert)).perform(click())

        onView(withId(R.id.calculatedButton)).perform(click())

        onView(withId(R.id.resultConvert))
            .check(matches(withText(containsString("2,00"))))
    }

    @Test
    fun roundUpJpy() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText("100"))

        onView(withId(R.id.rate_jpy)).perform(click())

        onView(withId(R.id.roundUpConvert)).perform(click())

        onView(withId(R.id.calculatedButton)).perform(click())

        onView(withId(R.id.resultConvert))
            .check(matches(withText(containsString("250"))))
    }

    @Test
    fun isEmpty() {
        onView(withId(R.id.EnterMoneyEditText))
            .perform(typeText(""))

        onView(withId(R.id.calculatedButton)).perform(click())

        onView(withId( R.id.resultConvert))
            .check(matches(withText(containsString(""))))
    }
}