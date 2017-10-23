package ch.hsr.mge.gadgeothek.ui;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;


public class LoginActivityRobolectricTest {

    @Test
    public void testV1() {
        LoginActivity activity = Robolectric.setupActivity(LoginActivity.class);
        activity.attemptLogin();

    }

    @Test
    public void testV2() {

        ActivityController<LoginActivity> controller = Robolectric.buildActivity(LoginActivity.class).create().start();
        LoginActivity activity = controller.get();


        activity.attemptLogin();

    }


}
