package currencyconverter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        comboBox1.setOnAction();
        comboBox2.setOnAction();
        amountEntered.setOnAction();
        button.setOnAction();
        button2.setOnAction();



        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button2, comboBox1, comboBox2, button, amountEntered, result);

        scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();

    }
    private static String firstCurrency(String e1) {
        return e1;
    }

    private static String toCurrency(String e2) {
        return e2;
    }

    private static double amount(double e3) {
        return e3;
    }

    private static double getRateFromDB(String fromCode, String toCode) throws SQLException {
        Connection connection = null;
        Statement query = null;
        DataSource dataSource = DBConnection.connectToDB();
        double rate = 0.0;
        try {

            String s = fromCode + toCode;
            connection = dataSource.getConnection();
            query = connection.createStatement();
            String sql = "SELECT value FROM currencies WHERE code LIKE " + "'%" + s + "%'";
            ResultSet execute = query.executeQuery(sql);
            while (execute.next()) {
                rate = execute.getDouble("value");
                return rate;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            query.close();
        }

        return rate;
    }
}