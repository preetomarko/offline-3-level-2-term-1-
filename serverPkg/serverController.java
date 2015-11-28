package serverPkg;

import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;


public class serverController{

    @FXML
    Label lblClientListServ;

    @FXML
    Label lblMessageBoxServ;

    @FXML
    TableView <clientInfo> tableView;


    @FXML
    TextArea msgBoxServer;


    @FXML
    TableColumn<clientInfo, String> nameColumn;

    @FXML
    TableColumn<clientInfo, Button> sendButtonColumn;

    /*
    void updateTable()
    {
        //WriteThreadServer.setController(this);
        nameColumn.setCellValueFactory(new PropertyValueFactory<clientInfo, String>("name"));
        sendButtonColumn.setCellValueFactory(new PropertyValueFactory<clientInfo, Button>("btn"));
        tableView.setEditable(false);
        nameColumn.setStyle("-fx-alignment: CENTER;");
        sendButtonColumn.setStyle("-fx-alignment: CENTER;");
        tableView.setItems(main.clientList);

    }
*/

    public static serverMain main;

    public TableView getTable()
    {
        return tableView;
    }

    public static void setMain(serverMain m) {main = m;}




}
