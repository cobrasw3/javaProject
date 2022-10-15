import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button submit;

    @FXML
    private Button submit1;

    @FXML
    private TextField textField;

    @FXML
    private TextField textField1;

    private Stage stage;
    private Scene scene;

    static java.sql.Statement stmt;

    public static java.sql.Statement getStatement() {
        return stmt;
    }

    @FXML
    void onLoginClick(ActionEvent event) throws IOException {
        try {
            String Username = textField1.getText();
            String Password = textField.getText();

            String jdbcURL = "jdbc:mysql://localhost:3306/javaprojet";
            String username = "root";
            String password = "tennis92";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            // JOptionPane.showMessageDialog(null, "Driver Connected");
            stmt = con.createStatement();
            // JOptionPane.showMessageDialog(null, "Database connected");
            String queryString = "select * from javaprojet.connexion where Username = '" + Username
                    + "' and Password = '" + Password + "'";
            if (stmt.executeQuery(queryString).next()) {
                // JOptionPane.showMessageDialog(null, "User already registered");
                JOptionPane.showMessageDialog(null, "Welcome : " + Username + " !");
                Parent root = FXMLLoader.load(getClass().getResource("controllerBis.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                JOptionPane.showMessageDialog(null, "You are not registered :(");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    @FXML
    void onSignUpClick(ActionEvent event) {
        try {
            String Username = textField1.getText();
            String Password = textField.getText();

            String jdbcURL = "jdbc:mysql://localhost:3306/javaprojet";
            String username = "root";
            String password = "tennis92";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            // JOptionPane.showMessageDialog(null, "Driver Connected");
            stmt = con.createStatement();
            // JOptionPane.showMessageDialog(null, "Database connected");
            String queryString = "select * from javaprojet.connexion where Username = '" + Username + "'";
            if (stmt.executeQuery(queryString).next()) {
                JOptionPane.showMessageDialog(null, "User already registered");
            } else {
                queryString = "insert into javaprojet.connexion values ('" + Username + "', '" + Password + "')";
                stmt.executeUpdate(queryString);
                JOptionPane.showMessageDialog(null, "Welcome : " + Username + " !");
                Parent root = FXMLLoader.load(getClass().getResource("ControllerBis.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

}
