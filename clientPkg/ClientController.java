package clientPkg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import networkUtil.*;

public class ClientController {

    @FXML
    private Label lblName;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnConnect;

    @FXML
    private Label lblMsgServer;

    @FXML
    TextArea msgBox;

    //private NetworkUtil nc;

    @FXML
    void connectServer(ActionEvent event) {

        String NAME=txtName.getText();

        txtName.clear();
        txtName.setVisible(false);
        btnConnect.setVisible(false);
        lblName.setVisible(false);
        msgBox.setVisible(true);

        lblMsgServer.setVisible(true);
        new Client(NAME,this);
        ClientMain.stg.setTitle("Hello "+NAME);

        //nc.write(NAME);
    }

    public static ClientMain main;

    public static void setMain(ClientMain m) {main = m;}

}
