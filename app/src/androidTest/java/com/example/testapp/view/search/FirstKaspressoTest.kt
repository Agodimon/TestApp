package com.example.testapp.view.search

import android.Manifest
import androidx.compose.ui.test.hasText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.example.testapp.R
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
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
                    searchEditText{
                        replaceText("123123")
                        pressImeAction()
                        print("")
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