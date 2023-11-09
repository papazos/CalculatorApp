package com.example.logbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView solutionTextView;
    TextView resultTextView;

    String currentInput = "";
    String operator = "";
    double firstOperand = 0;
    double secondOperand = 0;
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solutionTextView = findViewById(R.id.solution_tv);
        resultTextView = findViewById(R.id.result_tv);

        findViewById(R.id.button_0).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_1).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_2).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_3).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_4).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_5).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_6).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_7).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_8).setOnClickListener(this::onNumberClick);
        findViewById(R.id.button_9).setOnClickListener(this::onNumberClick);

        findViewById(R.id.button_plus).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.button_minus).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.button_multiply).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.button_divide).setOnClickListener(this::onOperatorClick);

        findViewById(R.id.button_C).setOnClickListener(this::onClearClick);
        findViewById(R.id.button_result).setOnClickListener(this::onResultClick);

    }
    public void onNumberClick(View view) {
        String buttonText = ((TextView) view).getText().toString();
        currentInput += buttonText;
        updateSolutionView();
    }

    public void onOperatorClick(View view) {
        if (!currentInput.isEmpty()) {
            if (operator.isEmpty()) {
                firstOperand = Double.parseDouble(currentInput);
                operator = ((TextView) view).getText().toString();
                currentInput = "";
                updateResultView();
            }
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        firstOperand = 0;
        secondOperand = 0;
        operator = "";
        result = 0;
        updateSolutionView();
        updateResultView();
    }

    public void onResultClick(View view) {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            secondOperand = Double.parseDouble(currentInput);
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        // Handle division by zero error
                    }
                    break;
            }
            currentInput = String.valueOf(result);
            firstOperand = result;
            operator = "";
            updateSolutionView();
            updateResultView();
        }
    }

    private void updateSolutionView() {
        solutionTextView.setText(currentInput);
    }

    private void updateResultView() {
        resultTextView.setText(operator.isEmpty() ? "" : String.valueOf(firstOperand));
    }

}