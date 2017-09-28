package com.example.admin.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    private TextView textView;
    private TextView info;

    private double firstValue = Double.NaN;
    private double secondValue;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvEquation);
        info = (TextView) findViewById(R.id.tvInfo);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //keeps the form form getting wiped when onDestroy gets called, such as when the phone is rotated.
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: ");
        outState.putString("textViewValue", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
        textView.setText( savedInstanceState.getString( "textViewValue" ));
    }

    public void buttonZero(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "0" );
        info.setText( info.getText().toString() + "0" );
    }

    public void buttonOne(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "1" );
        info.setText( info.getText().toString() + "1" );
    }

    public void buttonTwo(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            //info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "2" );
        //info.setText( info.getText().toString() + "2" );
    }

    public void buttonThree(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "3" );
        info.setText( info.getText().toString() + "3" );
    }

    public void buttonFour(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "4" );
        info.setText( info.getText().toString() + "4" );
    }

    public void buttonFive(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "5" );
        info.setText( info.getText().toString() + "5" );
    }

    public void buttonSix(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "6" );
        info.setText( info.getText().toString() + "6" );
    }

    public void buttonSeven(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "7" );
        info.setText( info.getText().toString() + "7" );
    }

    public void buttonEight(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "8" );
        info.setText( info.getText().toString() + "8" );
    }

    public void buttonNine(View view) {
        if( CURRENT_ACTION == '0' ) {
            textView.setText( "" );
            info.setText( "" );
        }

        textView.setText( textView.getText().toString() + "9" );
        info.setText( info.getText().toString() + "9" );
    }

    public void buttonDecimal(View view) {
        String s = textView.getText().toString();

        if( s.indexOf( '.' ) == -1 ) {
            textView.setText(textView.getText().toString() + ".");
            info.setText( info.getText().toString() + "." );
        }
    }

    public void buttonDivide(View view) {
        calculate();
        CURRENT_ACTION = DIVISION;
        textView.setText( "" );
        info.setText( info.getText().toString() + "/" );

    }

    public void buttonMultiply(View view) {
        calculate();
        CURRENT_ACTION = MULTIPLICATION;
        textView.setText( "" );
        info.setText( info.getText().toString() + "*" );
    }

    public void buttonSubtract(View view) {
        calculate();
        CURRENT_ACTION = SUBTRACTION;
        textView.setText( "" );
        info.setText( info.getText().toString() + "-" );
    }

    public void buttonAdd(View view) {
        //*
        calculate();
        CURRENT_ACTION = ADDITION;
        textView.setText( "" );
        info.setText( info.getText().toString() + "+" );
        //*/
    }

    public void buttonClear(View view) {
        textView.setText( "" );
        info.setText( "" );
        firstValue = Double.NaN;
        secondValue = Double.NaN;
    }

    public void buttonEquals(View view) {
        calculate();
        textView.setText( Double.isNaN( firstValue ) ? "" : String.valueOf( firstValue ));
        info.setText( "" );
        firstValue = Double.NaN;
        CURRENT_ACTION = '0';
    }

    private void calculate() {
        String s = textView.getText().toString();

        if( s.length() > 0 && !s.equals(".") ) {
            if (!Double.isNaN(firstValue)) {
                //True if the first value has been assigned.

                secondValue = Double.parseDouble(textView.getText().toString());
                textView.setText("");

                switch (CURRENT_ACTION) {
                    case ADDITION:
                        firstValue += secondValue;
                        break;
                    case SUBTRACTION:
                        firstValue -= secondValue;
                        break;
                    case DIVISION:
                        if( secondValue != 0)
                            firstValue /= secondValue;
                        break;
                    case MULTIPLICATION:
                        firstValue *= secondValue;
                        break;

                }
            } else {
                //the first value has not been assigned.
                firstValue = Double.parseDouble(textView.getText().toString());
                info.setText( info.getText().toString() + firstValue);
            }
        }
    }
}
