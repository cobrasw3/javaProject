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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerBis {

    @FXML
    private Button button;

    @FXML
    private ImageView raquette;

    private Stage stage;
    private Scene scene;

    java.sql.Statement stmt = Controller.getStatement();

    @FXML
    void onClickButton(ActionEvent event) throws IOException {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/javaprojet";
            String username = "root";
            String password = "tennis92";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(jdbcURL, username, password);
            // JOptionPane.showMessageDialog(null, "Driver Connected");
            stmt = con.createStatement();
            // JOptionPane.showMessageDialog(null, "Database connected");
            Parent root = FXMLLoader.load(getClass().getResource("ControllerThree.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }
}
