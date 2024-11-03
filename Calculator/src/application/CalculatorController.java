package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class CalculatorController {

    @FXML
    private Label displayField; // Connects to the Label in FXML

    private StringBuilder currentInput = new StringBuilder();
    private String operator;
    private double firstOperand;
    private boolean resetInput = false;

    // Handle number button clicks
    @FXML
    private void handleNumberClick(ActionEvent event) {
        if (resetInput) {
            currentInput.setLength(0); // Clear previous result if needed
            resetInput = false;
        }

        Button clickedButton = (Button) event.getSource();
        currentInput.append(clickedButton.getText());
        displayField.setText(currentInput.toString());
    }

    // Handle operator button clicks
    @FXML
    private void handleOperatorClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        operator = clickedButton.getText();
        firstOperand = Double.parseDouble(currentInput.toString());
        currentInput.setLength(0); // Clear the current input for the next operand
    }

    // Handle equals button click
    @FXML
    private void handleEqualsClick() {
        double secondOperand;
        try {
            secondOperand = Double.parseDouble(currentInput.toString());
        } catch (NumberFormatException e) {
            displayField.setText("Error");
            return;
        }

        double result = 0;
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
                    displayField.setText("Error");
                    resetInput = true;
                    return;
                }
                break;
            case "%":
                result = firstOperand * (secondOperand / 100.0);
                break;
            default:
                displayField.setText("Error");
                resetInput = true;
                return;
        }

        displayField.setText(String.valueOf(result));
        currentInput.setLength(0);
        currentInput.append(result);
        resetInput = true; // Next input will reset
    }

    // Handle clear button click
    @FXML
    private void handleClearClick() {
        currentInput.setLength(0);
        displayField.setText("0");
        firstOperand = 0;
        operator = "";
        resetInput = false;
    }

    // Handle decimal button click
    @FXML
    private void handleDecimalClick() {
        if (!currentInput.toString().contains(".")) {
            if (currentInput.length() == 0) {
                currentInput.append("0"); // Start with "0" if no input yet
            }
            currentInput.append(".");
            displayField.setText(currentInput.toString());
        }
    }

    // Handle toggle sign button click
    @FXML
    private void handleToggleSignClick() {
        if (currentInput.length() > 0) {
            double currentValue = Double.parseDouble(currentInput.toString());
            currentValue *= -1; // Toggle the sign
            currentInput.setLength(0); // Clear current input
            currentInput.append(currentValue); // Append the toggled value
            displayField.setText(currentInput.toString());
        }
    }
}
