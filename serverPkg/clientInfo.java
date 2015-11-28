package serverPkg;

//import java.awt.*;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.control.Button;
import networkUtil.*;


/**
 * Created by USER on 11/22/2015.
 */
public class clientInfo {
    private SimpleStringProperty name;
    private Button btn;
    serverController sControl;
    private NetworkUtil nUtil;
    clientInfo(String name,serverController sc,NetworkUtil nc)
    {
        this.name = new SimpleStringProperty(name);
        btn=new Button("Send");
        sControl=sc;
        nUtil=nc;
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String nameOfClient=(String)serverMain.mapping.get(e.getSource());
                System.out.println("clicked on: "+nameOfClient);
                String s=sControl.msgBoxServer.getText();
                System.out.println("text typed: "+s);
                //serverMain.clientList.removeAll();
                clientInfo toBeRemoved=(clientInfo)serverMain.buttonClientInfoMap.get(e.getSource());
                nUtil.write(s);
                serverMain.clientList.removeAll(toBeRemoved);
            }
        });

    }
    public String getName() {
        return name.get();
    }

    public void setName(String Name) {
        name.set(Name);
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn() {
        new Button("Send");
    }




}
