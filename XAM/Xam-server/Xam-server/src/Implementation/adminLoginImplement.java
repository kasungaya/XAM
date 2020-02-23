package Implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Interface.adminLoginInterface;
/**
 * Implementation of the connecting to admin panel user login and check authentication.
 * This collects the username and password to check that it is equal to the data and continue the process of login.
 * @author Kasun Abeywardana
 */

public class adminLoginImplement extends UnicastRemoteObject implements adminLoginInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected adminLoginImplement() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean getLoginAndAuthentication (String user, String pass) throws RemoteException {
		
		{

			if ((user != null && !user.isEmpty())
					&& (pass != null && !pass.isEmpty())) {

				if((user.equalsIgnoreCase("admin")) 
						&& (pass.equalsIgnoreCase("123"))) {
					
					return true;
				}
			}
			return false;
		}
	}
}
