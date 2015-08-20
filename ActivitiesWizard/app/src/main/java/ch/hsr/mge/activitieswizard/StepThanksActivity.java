package ch.hsr.mge.activitieswizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StepThanksActivity extends AppCompatActivity {

    private UserRegistrationData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_thanks);
        data = (UserRegistrationData) getIntent().getSerializableExtra(Constants.REGISTRATION_DATA);
    }

    public void onNext(View view) {
        Intent intent = new Intent(this, StepDoneActivity.class);
        intent.putExtra(Constants.REGISTRATION_DATA, data);
        startActivity(intent);
    }
}
