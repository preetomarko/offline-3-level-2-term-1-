package clientPkg;
import networkUtil.*;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
    ClientController cControl;

	public ReadThread(NetworkUtil nc,ClientController cc) {
		this.nc = nc;
        cControl=cc;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			while(true) {
				String s=(String)nc.read();
				if(s!=null)System.out.println(s);
				cControl.msgBox.setText(s);
			}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		nc.closeConnection();
	}
}



