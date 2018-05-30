package currencyconverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CurrencyConverter extends Application {

    Stage window;
    Scene scene;
    Button button;
    Button button2;
    TextField amountEntered;
    TextField result;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Currency Calculator");
        button = new Button("Convert");
        button2 = new Button("Open Database Controller");
        amountEntered = new TextField();
        result = new TextField();
        result.setEditable(false);

        ComboBox comboBox1 = new ComboBox<>();
        ComboBox comboBox2 = new ComboBox<>();

        comboBox1.getItems().addAll(
                "EUR",
                "USD",
                "GBP");

        comboBox2.getItems().addAll(
                "EUR",
                "USD",
                "GBP");


        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button2, comboBox1, comboBox2, button, amountEntered, result);

        scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();

    }
}