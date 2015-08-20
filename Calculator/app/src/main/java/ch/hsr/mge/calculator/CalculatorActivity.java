package ch.hsr.mge.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatorActivity extends AppCompatActivity {

    private Evaluator evaluator;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.display);

        evaluator = new Evaluator(this, new Evaluator.Callback<String>() {
            /**
             * @param s das Resultat der Berechnung als String
             */
            @Override
            public void apply(String s) {
                textView.setText(s);
            }
        });
    }

    public void onButtonPressed(View v) {
        if (v.getId() == R.id.resultButton) {
            evaluator.evaluate(textView.getText().toString());
        } else if (v.getId() == R.id.resetButton) {
            textView.setText("");
        } else if (v instanceof Button) {
            Button button = (Button) v;
            String operation = button.getText().toString();
            textView.setText(textView.getText() + operation);
        }
    }
}
