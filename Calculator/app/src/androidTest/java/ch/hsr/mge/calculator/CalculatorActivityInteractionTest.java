package ch.hsr.mge.calculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivityInteractionTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private Button _1;
    private Button _0;
    private Button _2;
    private Button _3;
    private Button _4;
    private Button _5;
    private Button _6;
    private Button _7;
    private Button _8;
    private Button _9;
    private Button plus;
    private Button multiply;
    private Button minus;
    private Button divide;
    private Button result;
    private Button reset;
    private Button decimal;

    private TextView display;

    public CalculatorActivityInteractionTest() {
        super(CalculatorActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        CalculatorActivity activity = getActivity();

        _0 = (Button) activity.findViewById(R.id.zeroButton);
        _1 = (Button) activity.findViewById(R.id.oneButton);
        _2 = (Button) activity.findViewById(R.id.twoButton);
        _3 = (Button) activity.findViewById(R.id.threeButton);
        _4 = (Button) activity.findViewById(R.id.fourButton);
        _5 = (Button) activity.findViewById(R.id.fiveButton);
        _6 = (Button) activity.findViewById(R.id.sixButton);
        _7 = (Button) activity.findViewById(R.id.sevenButton);
        _8 = (Button) activity.findViewById(R.id.eightButton);
        _9 = (Button) activity.findViewById(R.id.nineButton);

        plus = (Button) activity.findViewById(R.id.plusButton);
        minus = (Button) activity.findViewById(R.id.minusButton);
        multiply = (Button) activity.findViewById(R.id.multiplyButton);
        divide = (Button) activity.findViewById(R.id.divideButton);

        result = (Button) activity.findViewById(R.id.resultButton);
        reset = (Button) activity.findViewById(R.id.resetButton);
        decimal = (Button) activity.findViewById(R.id.decimalButton);

        display = (TextView) activity.findViewById(R.id.display);
    }

    public void testSimpleAddition() {
        TouchUtils.clickView(this, _1);
        TouchUtils.clickView(this, plus);
        TouchUtils.clickView(this, _2);
        TouchUtils.clickView(this, result);
        assertEquals("3", display.getText().toString());
    }

    public void testLongerAddition() {
        assertEquals("6", calculate(_1, plus, _2, plus, _3));
    }

    public void testDivisionByZero() {
        assertEquals("inf", calculate(_1, divide, _0));
    }

    public void testInvalidSequence() {
        assertEquals("1++2-", calculate(_1, plus, plus, _2, minus));
    }

    private String calculate(Button... buttons) {
        for (Button b : buttons) {
            TouchUtils.clickView(this, b);
        }
        TouchUtils.clickView(this, result);
        return display.getText().toString();
    }
}
