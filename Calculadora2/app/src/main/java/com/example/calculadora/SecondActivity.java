package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private EditText display;
    private String currentNumber = "";
    private String operation = "";
    private double firstNumber = 0;
    private boolean isNewOperation = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); // Usando o layout que você forneceu

        display = findViewById(R.id.display);

        // Configurar botões numéricos (0-9)
        int[] numberButtons = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

        for (int buttonId : numberButtons) {
            findViewById(buttonId).setOnClickListener(this::onNumberClick);
        }

        // Configurar botões de operação
        findViewById(R.id.btnAdd).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btnSubtract).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btnMultiply).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btnDivide).setOnClickListener(this::onOperationClick);
        findViewById(R.id.btnPercent).setOnClickListener(this::onOperationClick);

        // Botão igual
        findViewById(R.id.btnEquals).setOnClickListener(v -> calculateResult());

        // Botões de controle
        findViewById(R.id.btnClear).setOnClickListener(v -> clearCalculator());
        findViewById(R.id.btnDelete).setOnClickListener(v -> deleteLastDigit());
        findViewById(R.id.btnDecimal).setOnClickListener(v -> addDecimalPoint());

        // Botão SAIR - Volta para MainActivity
        findViewById(R.id.btnExit).setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);

            startActivity(intent);
            finish(); // Finaliza a SecondActivity
        });
    }

    private void onNumberClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();

        if (isNewOperation) {
            currentNumber = number;
            isNewOperation = false;
        } else {
            currentNumber += number;
        }

        display.setText(currentNumber);
    }



    private void onOperationClick(View view) {
        Button button = (Button) view;
        String newOperation = button.getText().toString();

        if (!currentNumber.isEmpty()) {
            firstNumber = Double.parseDouble(currentNumber);
            operation = newOperation;
            currentNumber = "";
            display.setText("");
        } else if (!operation.isEmpty()) {
            operation = newOperation;
        }
    }

    private void calculateResult() {
        if (!operation.isEmpty() && !currentNumber.isEmpty()) {
            double secondNumber = Double.parseDouble(currentNumber);
            double result = 0;

            switch (operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "×":
                    result = firstNumber * secondNumber;
                    break;
                case "÷":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        display.setText("Erro");
                        return;
                    }
                    break;
                case "%":
                    result = firstNumber * (secondNumber / 100);
                    break;
            }

            // Formata o resultado para mostrar sem decimais quando for inteiro
            if (result == (long) result) {
                display.setText(String.format("%d", (long) result));
            } else {
                display.setText(String.format("%s", result));
            }

            currentNumber = display.getText().toString();
            isNewOperation = true;
            operation = "";
        }
    }

    private void clearCalculator() {
        currentNumber = "";
        firstNumber = 0;
        operation = "";
        display.setText("0");
        isNewOperation = true;
    }

    private void deleteLastDigit() {
        if (currentNumber.length() > 0) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            display.setText(currentNumber.isEmpty() ? "0" : currentNumber);
        }
    }

    private void addDecimalPoint() {
        if (isNewOperation) {
            currentNumber = "0.";
            isNewOperation = false;
        } else if (!currentNumber.contains(".")) {
            currentNumber += ".";
        }

        display.setText(currentNumber);
    }

}