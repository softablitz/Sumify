package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MenuBarController {

    @FXML
    private Label selectedOptionLabel; // Label to display the selected option

    @FXML
    public void handleMenuSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource(); // Get the selected menu item
        String selectedText = selectedItem.getText(); // Get the text of the selected menu item

        // Update the label with the selected option
        selectedOptionLabel.setText(selectedText);

        // Here you can add logic to switch modes or update the calculator functionality
        switch (selectedText) {
            case "Scientific Mode":
                loadScientificCalculator();
                break;
            case "Graphing Mode":
                // Placeholder for graphing mode
                System.out.println("Switched to Graphing Mode");
                break;
            case "Programmer Mode":
                // Placeholder for programmer mode
                System.out.println("Switched to Programmer Mode");
                break;
            case "Date Calculation":
                // Placeholder for date calculation
                System.out.println("Switched to Date Calculation");
                break;
            case "Currency":
                // Placeholder for currency conversion
                System.out.println("Switched to Currency Converter");
                break;
            case "Volume":
                // Placeholder for volume conversion
                System.out.println("Switched to Volume Converter");
                break;
            case "Length":
                // Placeholder for length conversion
                System.out.println("Switched to Length Converter");
                break;
            default:
                break;
        }
    }

    private void loadScientificCalculator() {
        try {
            // Retrieve the current stage from the selectedOptionLabel's scene
            Stage currentStage = (Stage) selectedOptionLabel.getScene().getWindow();
            Main main = new Main(); // Create a new instance of Main
            main.loadScientificCalculator(currentStage); // Pass the current stage to load the scientific calculator
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
