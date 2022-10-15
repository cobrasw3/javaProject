import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerThree implements Initializable {

    @FXML
    private TableColumn<matches, Integer> court;

    @FXML
    private TableColumn<matches, String> date;

    @FXML
    private Button homepage;

    @FXML
    private TableColumn<matches, Integer> match;

    @FXML
    private TableColumn<matches, Integer> pOne;

    @FXML
    private TableColumn<matches, Integer> pTwo;

    @FXML
    private TableColumn<matches, String> res;

    @FXML
    private TableView<matches> table;

    private Stage stage;
    private Scene scene;

    java.sql.Statement stmt = Controller.getStatement();

    @FXML
    void onClickHP(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ControllerBis.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickPlan(ActionEvent event) {

    }

    @FXML
    void onClickPlayers(ActionEvent event) {
        try {
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    ObservableList<matches> getMatchesList() {

        ObservableList<matches> list = FXCollections.observableArrayList();
        String query = "Select * from javaprojet.matches";
        try {
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                matches match = new matches(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4),
                        res.getString(5), res.getString(6));
                list.add(match);
            }
            return list;
        } catch (SQLException e) {
            e.toString();
            return null;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        match.setCellValueFactory(new PropertyValueFactory<matches, Integer>("match"));
        pOne.setCellValueFactory(new PropertyValueFactory<matches, Integer>("pOne"));
        pTwo.setCellValueFactory(new PropertyValueFactory<matches, Integer>("pTwo"));
        court.setCellValueFactory(new PropertyValueFactory<matches, Integer>("court"));
        date.setCellValueFactory(new PropertyValueFactory<matches, String>("date"));
        res.setCellValueFactory(new PropertyValueFactory<matches, String>("res"));
        table.setItems(getMatchesList());
        table.getColumns().setAll(match, pOne, pTwo, court, date, res);
    }

}
