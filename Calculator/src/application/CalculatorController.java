package application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class CalculatorController {

    @FXML
    private Label displayField;
    @FXML
    private Label selectedOptionLabel; 
    private StringBuilder currentInput = new StringBuilder();
    private String operator;
    private double firstOperand;
    private boolean resetInput = false;

    @FXML
    private void handleNumberClick(ActionEvent event) {
        if (resetInput) {
            currentInput.setLength(0); 
            resetInput = false;
        }

        Button clickedButton = (Button) event.getSource();
        currentInput.append(clickedButton.getText());
        displayField.setText(currentInput.toString());
    }
    @FXML
    private void handleOperatorClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        operator = clickedButton.getText();
        firstOperand = Double.parseDouble(currentInput.toString());
        currentInput.setLength(0); 
    }
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
        resetInput = true; 
    }

    @FXML
    private void handleClearClick() {
        currentInput.setLength(0);
        displayField.setText("0");
        firstOperand = 0;
        operator = "";
        resetInput = false;
    }

    @FXML
    private void handleDecimalClick() {
        if (!currentInput.toString().contains(".")) {
            if (currentInput.length() == 0) {
                currentInput.append("0");
            }
            currentInput.append(".");
            displayField.setText(currentInput.toString());
        }
    }

    @FXML
    private void handleToggleSignClick() {
        if (currentInput.length() > 0) {
            double currentValue = Double.parseDouble(currentInput.toString());
            currentValue *= -1;
            currentInput.setLength(0); 
            currentInput.append(currentValue);
            displayField.setText(currentInput.toString());
        }
    }
    @FXML
private void switchToScientificMode() {
   
}

@FXML
private void switchToGraphingMode() {
    
}

@FXML
private void switchToProgrammerMode() {
    
}

@FXML
private void switchToDateCalculation() {
   
}

@FXML
private void openCurrencyConverter() {
    
}

@FXML
private void openVolumeConverter() {
    
}

@FXML
private void openLengthConverter() {
    // Code to open a length converter
}
@FXML
private void handleMenuSelection(ActionEvent event) {
    MenuItem selectedItem = (MenuItem) event.getSource();
    String option = selectedItem.getText();
    
    // Debugging output
    System.out.println("Selected option: " + option);
    
    if (selectedOptionLabel != null) {
        selectedOptionLabel.setText(option);
    } else {
        System.err.println("selectedOptionLabel is null");
    }
}


}
