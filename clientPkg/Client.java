package clientPkg;
import networkUtil.*;
import sun.nio.ch.Net;

public class Client
{
	String name;
    public Client(String name,ClientController cc)
	{
		try {
            String serverAddress="127.0.0.1";
            int serverPort=55555;
			NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
            this.name=name;
            nc.write(name);
			new ReadThread(nc,cc);
			//new WriteThread(nc,"Client");
		} catch(Exception e) {
			System.out.println (e);
		}
	}
}

