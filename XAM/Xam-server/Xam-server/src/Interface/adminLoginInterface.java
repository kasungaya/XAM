package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * This interface retrieves details regarding the user of the admin panel
 * Methods in this RMI interface were obtained by studying the 
 * example code of Mr.Marc Conrad.
 * This interface is required to be present to the server sides for functionality. 
 * @author Kasun Abeywardana 
 */

public interface adminLoginInterface extends Remote {

	public boolean getLoginAndAuthentication(String user,String pass) throws RemoteException;
	
}
