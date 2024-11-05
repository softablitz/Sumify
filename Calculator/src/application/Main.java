package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage currentStage;

    @Override
    public void start(Stage primaryStage) {
        this.currentStage = primaryStage;
        loadScene("Calculator.fxml", "Standard Mode"); // Load with default label
        primaryStage.show();
    }

    public void loadScene(String fxml, String selectedText) {
        try {
            // Load the menu bar
            FXMLLoader menuBarLoader = new FXMLLoader(getClass().getResource("MenuBar.fxml"));
            Parent menuBar = menuBarLoader.load();
            MenuBarController menuBarController = menuBarLoader.getController();
            menuBarController.setMain(this);
            menuBarController.updateLabel(selectedText); // Update the label with selected option
            
            // Load the calculator view
            FXMLLoader calculatorLoader = new FXMLLoader(getClass().getResource(fxml));
            Parent calculatorRoot = calculatorLoader.load();
            BorderPane root = new BorderPane();
            root.setTop(menuBar);
            root.setCenter(calculatorRoot);
            currentStage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCalculator(String fxml, String selectedText) {
        loadScene(fxml, selectedText); // Pass the selected text to update the label
    }

    public static void main(String[] args) {
        launch(args);
    }
}
