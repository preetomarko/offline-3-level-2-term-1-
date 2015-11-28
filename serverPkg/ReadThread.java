// lagbe na

package serverPkg;
import networkUtil.*;

public class ReadThread implements Runnable {
	private Thread thr;
	private NetworkUtil nc;
    //static serverMain m;

	public ReadThread(NetworkUtil nc) {
		this.nc = nc;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() {
		try {
			//while(true) {
				String s=(String)nc.read();
				System.out.println(s);


			//}
		} catch(Exception e) {
			System.out.println (e);                        
		}
		//nc.closeConnection();
	}
}



