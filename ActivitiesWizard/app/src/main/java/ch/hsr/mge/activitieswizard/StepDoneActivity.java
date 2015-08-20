package ch.hsr.mge.activitieswizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class StepDoneActivity extends AppCompatActivity {

    private UserRegistrationData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_done);
        data = (UserRegistrationData) getIntent().getSerializableExtra(Constants.REGISTRATION_DATA);

        TextView thanks = (TextView) findViewById(R.id.thanksTextView);

        String text;
        if(data.isNewsletter()) {
            text = "Sie sind angemeldet, " + data.getName() + ", und werden unseren Newsletter bald erhalten!";
        } else {
            text = "Sie sind angemeldet, " + data.getName() + ", leider ohne Newsletter!";
        }
        thanks.setText(text);
    }

    public void onMore(View view) {
        Intent intent = new Intent(this, StepNameActivity.class);
        intent.putExtra(Constants.REGISTRATION_DATA, new UserRegistrationData());
        startActivity(intent);
    }
}
