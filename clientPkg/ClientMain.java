package clientPkg;/**
 * Created by USER on 11/21/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import networkUtil.*;

public class ClientMain extends Application {

    ClientController cc;
    static Stage stg;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("ClientView.fxml"));
        Parent root = loader.load();
        cc=loader.getController();
        cc.setMain(this);
        primaryStage.setTitle("Hello Client");
        //ClientController.setMain(this);
        primaryStage.setScene(new Scene(root, 500, 305));
        primaryStage.show();
        stg=primaryStage;
    }
}
