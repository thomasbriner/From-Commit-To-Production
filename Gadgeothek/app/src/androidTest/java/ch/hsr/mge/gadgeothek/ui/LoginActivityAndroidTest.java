package ch.hsr.mge.gadgeothek.ui;

import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import junit.framework.Assert;

import org.junit.Assume;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import ch.hsr.mge.gadgeothek.R;
import ch.hsr.mge.gadgeothek.service.LibraryService;


public class LoginActivityAndroidTest {


    private static String EMAIL_VALID = "s@hsr.ch";
    private static String PASSWORD_VALID = "12345";

    @Rule
    public ActivityTestRule<LoginActivity> rule = new ActivityTestRule<>(LoginActivity.class);

    @Ignore
    @Test
    public void shouldBeLoggedInV1() throws Exception {
        final LoginActivity activity = rule.getActivity();

        final EditText emailView = (EditText) activity.findViewById(R.id.email);
        final EditText passwordView = (EditText) activity.findViewById(R.id.password);
        Assume.assumeFalse(LibraryService.isLoggedIn());

        emailView.setText(EMAIL_VALID);
        passwordView.setText(PASSWORD_VALID);
        activity.attemptLogin();
        Assert.assertTrue(LibraryService.isLoggedIn());
    }


    @Ignore
    @Test
    public void shouldBeLoggedInV2() throws Exception {
        final LoginActivity activity = rule.getActivity();

        final EditText emailView = (EditText) activity.findViewById(R.id.email);
        final EditText passwordView = (EditText) activity.findViewById(R.id.password);
        Assume.assumeFalse(LibraryService.isLoggedIn());

        activity.runOnUiThread(new Runnable() {
            public void run() {
                emailView.setText(EMAIL_VALID);
                passwordView.setText(PASSWORD_VALID);
                activity.attemptLogin();
            }
        });
        Assert.assertTrue(LibraryService.isLoggedIn());
    }



   @Ignore
    @Test
    public void shouldBeLoggedInV3() throws Exception {
        final LoginActivity activity = rule.getActivity();

        final EditText emailView = (EditText) activity.findViewById(R.id.email);
        final EditText passwordView = (EditText) activity.findViewById(R.id.password);
        Assume.assumeFalse(LibraryService.isLoggedIn());

        activity.runOnUiThread(new Runnable() {
            public void run() {
                emailView.setText(EMAIL_VALID);
                passwordView.setText(PASSWORD_VALID);
                activity.attemptLogin();

                Assert.assertTrue(LibraryService.isLoggedIn());

            }
        });
    }



    @Test
    public void shouldBeLoggedInVfinal() throws Exception {
        final LoginActivity activity = rule.getActivity();

        final EditText emailView = (EditText) activity.findViewById(R.id.email);
        final EditText passwordView = (EditText) activity.findViewById(R.id.password);
        Assume.assumeFalse(LibraryService.isLoggedIn());

        activity.runOnUiThread(new Runnable() {
            public void run() {
                emailView.setText(EMAIL_VALID);
                passwordView.setText(PASSWORD_VALID);
                activity.attemptLogin();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Assert.assertTrue(LibraryService.isLoggedIn());

            }
        });
    }

    @Test
    public void shouldRaiseErrorOnEmptyMail() throws Exception {
        final LoginActivity activity = rule.getActivity();

        final EditText emailView = (EditText) activity.findViewById(R.id.email);
        final EditText passwordView = (EditText) activity.findViewById(R.id.password);
        boolean loggedIn = LibraryService.isLoggedIn();
        Assert.assertFalse(loggedIn);

        activity.runOnUiThread(new Runnable() {
            public void run() {
                emailView.setText("");
                passwordView.setText(PASSWORD_VALID);
                activity.attemptLogin();
            }
        });
        Thread.sleep(2000);
        CharSequence error = emailView.getError();
        Assert.assertTrue(error.toString().equals("This field is required"));
    }
}
