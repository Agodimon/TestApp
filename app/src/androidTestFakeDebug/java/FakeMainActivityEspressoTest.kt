import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testapp.R
import com.example.testapp.TEST_ALGOL
import com.example.testapp.TEST_NUMBER_OF_RESULTS_42
import com.example.testapp.view.search.FakeMainActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FakeMainActivityEspressoTest {
    private lateinit var scenario: ActivityScenario<FakeMainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(FakeMainActivity::class.java)
    }

    @Test
    fun activitySearch_IsWorking() {
        onView(withId(R.id.searchEditText)).perform(click())
        onView(withId(R.id.searchEditText)).perform(replaceText(TEST_ALGOL), closeSoftKeyboard())
        onView(withId(R.id.searchEditText)).perform(pressImeActionButton())
        onView(withId(R.id.totalCountTextView)).check(matches(withText(TEST_NUMBER_OF_RESULTS_42)))
    }


    @After
    fun close() {
        scenario.close()
    }
}