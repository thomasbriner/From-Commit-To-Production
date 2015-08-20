package ch.hsr.mge.activitieswizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class StepNameActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private UserRegistrationData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_name);
        name = (EditText) findViewById(R.id.nameEditText);
        data = (UserRegistrationData) getIntent().getSerializableExtra(Constants.REGISTRATION_DATA);
        findViewById(R.id.nextButton).setOnClickListener(this);
    }

    public void onClick(View view) {
        data.setName(name.getText().toString());

        Intent intent = new Intent(this, StepNewsletterActivity.class);
        intent.putExtra(Constants.REGISTRATION_DATA, data);
        startActivity(intent);
    }
}
