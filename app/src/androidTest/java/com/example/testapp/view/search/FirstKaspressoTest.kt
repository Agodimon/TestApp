package com.example.testapp.view.search

import android.Manifest
import androidx.compose.ui.test.hasText
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.example.testapp.R
import com.example.testapp.view.details.DetailsActivity
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.junit.Rule
import org.junit.Test

class FirstKaspressoTest : TestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun test() =
        run {
            step("Open Simple Screen") {
                activityTestRule.launchActivity(null)
                testLogger.i("I am testLogger")
                //device.screenshots.take("Additional_screenshot")
                MainScreen {
                    searchEditText {
                        replaceText("123123")
                        pressImeAction()
                        print("")
                    }
                    totalCountTextView {
                        hasText("Number of results: 3331")
                    }
                    toDetailsActivityButton {
                        click()
                    }
                    totalCountTextView {
                        containsText("Number of results: ")
                    }
                }
                DetailsScreen {
                    incrementButton {
                        repeat(5, { click() })

                    }
                    totalCountTextView {
                        containsText("3336")
                    }

                    decrementButton {
                        repeat(5, { click() })

                    }
                    totalCountTextView {
                        containsText("3331")
                    }

                }
            }
        }
}


object MainScreen : KScreen<MainScreen>() {

    override val layoutId: Int = R.layout.activity_main
    override val viewClass: Class<*> = MainActivity::class.java

    val searchEditText = KEditText { withId(R.id.searchEditText) }

    val toDetailsActivityButton = KButton { withId(R.id.toDetailsActivityButton) }

    val totalCountTextView = KTextView { withId(R.id.totalCountTextView) }
}

object DetailsScreen : KScreen<DetailsScreen>() {
    override val layoutId: Int = R.layout.activity_details
    override val viewClass: Class<*> = DetailsActivity::class.java

    val decrementButton = KButton { withId(R.id.decrementButton) }

    val incrementButton = KButton { withId(R.id.incrementButton) }

    val totalCountTextView = KTextView { withId(R.id.totalCountTextView) }

}


