package com.anil.weatherapp.view;


import android.content.Context;


import com.anil.weatherapp.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

@LargeTest
@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void testTextView() {
        onView(withId(R.id.address)).check(matches((isDisplayed())));


    }

    @Test
    public void view_isCorrect() {
        onView(withText("Bengaluru, IN")).check(matches(isDisplayed()));

    }

    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.anil.weatherapp", appContext.getPackageName());
    }

    @Test
    public void recyclerViewScrollToPositionTest() {
        RecyclerView recyclerView = mActivityTestRule.getActivity().findViewById(R.id.recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(itemCount));
    }

    @Test
    public void recyclerViewScrollToPositionHaveContentTest() {
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(0)).check(matches(hasDescendant(withText("Wednesday"))));
    }
}
