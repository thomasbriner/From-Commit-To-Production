package ch.hsr.mge.drawerandtoolbar;

import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class NavigationDrawerTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public NavigationDrawerTests() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        getActivity();
    }

    public void testBookmarksMenuOpensBookmarksFragment() {
        openDrawer(R.id.drawer_layout);
        onView(withText("Bookmarks")).perform(click());
        onView(withText("Your Bookmarks")).check(matches(isDisplayed()));
    }

    public void testHomeMenuOpensHomeFragment() {
        openDrawer(R.id.drawer_layout);
        onView(allOf(isDescendantOfA(withId(R.id.navigation_view)), withText("Home"))).perform(click());
        onView(allOf(withText("Home"), withId(R.id.homeTextView))).check(matches(isDisplayed()));
    }
}
