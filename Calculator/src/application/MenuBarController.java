package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;

public class MenuBarController {
    @FXML
    private Label selectedOptionLabel;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void updateLabel(String text) {
        selectedOptionLabel.setText(text); // Update the label with the selected text
    }

    @FXML
    public void handleMenuSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText(); 
        System.out.println("Selected: " + selectedText); // Debug output
        
        // Update the label and load the appropriate calculator
        updateLabel(selectedText); // Update the label immediately

        switch (selectedText) {
            case "Scientific Mode":
                main.loadCalculator("scientificCalculator.fxml", selectedText);
                break;
            case "Standard Mode":
                main.loadCalculator("Calculator.fxml", selectedText);
                break;
            case "Graphing Mode":
                main.loadCalculator("graphingCalculator.fxml", selectedText);
                break;
            case "Programmer Mode":
                main.loadCalculator("programmerCalculator.fxml", selectedText);
                break;
            case "Date Calculation":
                main.loadCalculator("dateCalculator.fxml", selectedText);
                break;
            case "Currency":
                main.loadCalculator("currencyConverter.fxml", selectedText);
                break;
            case "Volume":
                main.loadCalculator("volumeConverter.fxml", selectedText);
                break;
            case "Length":
                main.loadCalculator("lengthConverter.fxml", selectedText);
                break;
            default:
                break;
        }
    }
}
