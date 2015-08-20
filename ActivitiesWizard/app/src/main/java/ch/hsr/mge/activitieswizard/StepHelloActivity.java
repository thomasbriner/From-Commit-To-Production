package ch.hsr.mge.activitieswizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StepHelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_hello);
    }

    public void onRegister(View view) {
        Intent intent = new Intent(this, StepNameActivity.class);
        intent.putExtra(Constants.REGISTRATION_DATA, new UserRegistrationData());
        startActivity(intent);
    }
}
