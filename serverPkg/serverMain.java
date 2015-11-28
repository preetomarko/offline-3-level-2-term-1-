package serverPkg;/**
 * Created by USER on 11/21/2015.
 */

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

class newThread implements Runnable
{
    Thread t;
    serverController sControl;
    newThread(serverController sc)
    {
        t=new Thread(this);
        sControl=sc;
        if(sc==null) System.out.println("sc is null");
        t.start();
    }
    public void run()
    {
        new Server(sControl);
    }
}

public class serverMain extends Application {

    static ObservableList<clientInfo> clientList = FXCollections.observableArrayList();
    static Hashtable mapping=new Hashtable();
    static Hashtable buttonClientInfoMap=new Hashtable();
    serverController sc;   //must be static to use it within main()
    //public static Server serv;

    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("server.fxml"));
        Parent root = loader.load();
        sc=loader.getController();
        sc.setMain(this);   //not serverController.setMain(this)
        if(sc==null) System.out.println("sc is null inside start()");
        new newThread(sc);
        sc.nameColumn.setCellValueFactory(new PropertyValueFactory<clientInfo, String>("name"));
        sc.sendButtonColumn.setCellValueFactory(new PropertyValueFactory<clientInfo, Button>("btn"));
        sc.tableView.setEditable(false);
        sc.nameColumn.setStyle("-fx-alignment: CENTER;");
        sc.sendButtonColumn.setStyle("-fx-alignment: CENTER;");
        primaryStage.setTitle("Server Window");
        //new Server();
        //serverController.setMain(this);
        //clientList.removeAll("arko");

        primaryStage.setScene(new Scene(root, 600, 400));

        primaryStage.show();




    }

    public static void main(String[] args) {
        //new newThread(sc);
        //if(sc==null) System.out.println("sc is null inside main");

        launch(args);
        //new Server();
    }
}
