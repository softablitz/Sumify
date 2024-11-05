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
    @FXML
    public void handleMenuSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText(); 
        selectedOptionLabel.setText(selectedText);

        switch (selectedText) {
            case "Scientific Mode":
                main.loadCalculator("scientificCalculator.fxml");
                break;
            case "Standard Mode":
                main.loadCalculator("scientificCalculator.fxml");
                break;
            case "Graphing Mode":
                main.loadCalculator("graphingCalculator.fxml");
                break;
            case "Programmer Mode":
                main.loadCalculator("programmerCalculator.fxml");
                break;
            case "Date Calculation":
                main.loadCalculator("dateCalculator.fxml");
                break;
            case "Currency":
                main.loadCalculator("currencyConverter.fxml");
                break;
            case "Volume":
                main.loadCalculator("volumeConverter.fxml");
                break;
            case "Length":
                main.loadCalculator("lengthConverter.fxml");
                break;
            default:
                break;
        }
    }
}
