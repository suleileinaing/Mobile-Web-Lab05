package com.cookandroid.androidcalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

        private EditText editNumber1;
        private EditText editNumber2;
        private TextView textResult;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            editNumber1 = findViewById(R.id.editNumber1);
            editNumber2 = findViewById(R.id.editNumber2);
            textResult = findViewById(R.id.textResult);

            Button buttonAdd = findViewById(R.id.buttonAdd);
            Button buttonSubtract = findViewById(R.id.buttonSubtract);
            Button buttonMultiply = findViewById(R.id.buttonMultiply);
            Button buttonDivide = findViewById(R.id.buttonDivide);

            buttonAdd.setOnClickListener(v -> calculate('+'));

            buttonSubtract.setOnClickListener(v -> calculate('-'));

            buttonMultiply.setOnClickListener(v -> calculate('*'));

            buttonDivide.setOnClickListener(v -> calculate('/'));
        }

        private void calculate(char operation) {

            String input1 = editNumber1.getText().toString();
            String input2 = editNumber2.getText().toString();

            if (input1.isEmpty() || input2.isEmpty()) {
                textResult.setText("Please enter two numbers");
                return;
            }

            double number1 = Double.parseDouble(input1);
            double number2 = Double.parseDouble(input2);

            double result = 0;

            switch (operation) {

                case '+':
                    result = number1 + number2;
                    break;

                case '-':
                    result = number1 - number2;
                    break;

                case '*':
                    result = number1 * number2;
                    break;

                case '/':
                    if (number2 == 0) {
                        textResult.setText("Cannot divide by zero");
                        return;
                    }

                    result = number1 / number2;
                    break;
            }

            textResult.setText("Result: " + number1 + " " + operation + " " +  number2 + " = " + result);
        }
    }