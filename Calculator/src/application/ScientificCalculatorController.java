package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ScientificCalculatorController {
    @FXML
    private Label result;

    private float number1 = 0;
    private float number2 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    public void processNumber(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processBinaryOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Float.parseFloat(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty())
                return;

            number2 = Float.parseFloat(result.getText());
            float output = calculateBinaryNumber(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
        }
    }

    @FXML
    public void processUnaryOperator(ActionEvent event) {
	
		String value=((Button)event.getSource()).getText();
		if(!operator.isEmpty())
			return;
		
		operator = value;
		number1=Float.parseFloat(result.getText());	
		result.setText("");
		
		float output=calculateUnaryNumber(number1,operator);
		result.setText(String.valueOf(output));
		operator="";
	}

    @FXML
    public void ClearFunction(ActionEvent event) {
        operator = "";
        start = true;
        result.setText("");
    }

    private float calculateUnaryNumber(float number1, String operator) {
        switch (operator) {
            case "√":
                return (float) Math.sqrt(number1);
            case "Sin":
                return (float) Math.sin(Math.toRadians(number1)); 
            case "Cos":
                return (float) Math.cos(Math.toRadians(number1));
            case "Tan":
                return (float) Math.tan(Math.toRadians(number1));
            case "e^x":
                return (float) Math.exp(number1);
            case "x^2":
                return number1 * number1;
            case "x^3":
                return number1 * number1 * number1;
            case "Log":
                return (float) Math.log10(number1);
            case "ln":
                return (float) Math.log(number1);
            case "x!":
                return factorial((int) number1); 
            default:
                break;
        }
        return 0;
    }

    private float calculateBinaryNumber(float number1, float number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return (number2 == 0) ? 0 : number1 / number2; 
            case "Mod":
                return number1 % number2;
            case "x^y":
                return (float) Math.pow(number1, number2);
            default:
                break;
        }
        return 0;
    }

   
    private int factorial(int number) {
        if (number < 0) return 0; 
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
