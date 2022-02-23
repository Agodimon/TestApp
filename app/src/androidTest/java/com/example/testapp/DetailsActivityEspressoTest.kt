package com.example.testapp

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testapp.view.details.DetailsActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DetailsActivityEspressoTest {
    private lateinit var scenario: ActivityScenario<DetailsActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(DetailsActivity::class.java)
    }

    @org.junit.Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }
    @org.junit.Test
    fun activityTextView_NotNull() {
        scenario.onActivity {
            val totalCountTextView = it.findViewById<TextView>(R.id.totalCountTextView)
            TestCase.assertNotNull(totalCountTextView)
        }
    }
    @Test
    fun activityTextView_HasText() {
        val assertion: ViewAssertion = matches(withText("Number of results: 0"))
        onView(withId(R.id.totalCountTextView)).check(assertion)
    }

    @After
    fun close() {
        scenario.close()
    }
}