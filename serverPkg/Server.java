package serverPkg;

import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import networkUtil.*;
import serverPkg.serverController;

public class Server {

	private ServerSocket ServSock;
    serverController sControl;
	
	Server(serverController sc) {
        System.out.println("inside Server class constructor");
        sControl=sc;
        if(sControl==null) System.out.println("sc is null");
        try {
			ServSock = new ServerSocket(55555);
			while (true) {
				ServerThread m = new ServerThread(ServSock.accept(),sControl);   //wait for accepting connection from client
				System.out.println("connection accepted");
			}
		}catch(Exception e) {
			System.out.println("Server starts:"+e);
		}
	}
	
	/*
    public static void main(String args[]) {
		Server objServer = new Server();
	}
	*/
}

class ServerThread implements Runnable {
	private Socket ClientSock;
	private Thread thr;
	private NetworkUtil nc;
    serverController sc;

	ServerThread(Socket client,serverController sc) {
		this.ClientSock = client;
		this.thr = new Thread(this);
		this.sc=sc;
		thr.start();
	}
    /*
	public static void setController(serverController sc)
	{
        ServControl=sc;
	}
*/
	public void run() {
		this.nc=new NetworkUtil(ClientSock);
        String s=(String)nc.read();
		System.out.println("read from the client");
		System.out.println(s);
		clientInfo c=new clientInfo(s,sc,nc);
		serverMain.clientList.add(c);
        if(sc==null) System.out.println("sc is null");

        //sc.updateTable();
        sc.tableView.setItems(serverMain.clientList);
        serverMain.mapping.put(c.getBtn(),c.getName());
        serverMain.buttonClientInfoMap.put(c.getBtn(),c);

        /*
        sc.nameColumn.setCellValueFactory(new PropertyValueFactory<clientInfo, String>("name"));
        sc.sendButtonColumn.setCellValueFactory(new PropertyValueFactory<clientInfo, Button>("btn"));
        sc.tableView.setEditable(false);
        sc.nameColumn.setStyle("-fx-alignment: CENTER;");
        sc.sendButtonColumn.setStyle("-fx-alignment: CENTER;");
        sc.getTable().setItems(serverMain.clientList);
        */

        //ServControl.updateTable(this);
		//new ReadThread(this.nc);
		//new WriteThread(this.nc,"Server");
        //Platform.runLater();
	}
}

