package Implementation;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import UI.adminUserLogin;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * This class initiates the server status to active while
 * allocating connections.
 * @author Kasun Abeywardana.
 *
 */
public class adminLoginServer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String []args) {
		
		try {
			
			Registry reg = LocateRegistry.createRegistry(1099);
			adminLoginImplement lp = new adminLoginImplement();
			reg.bind("login", lp);
			System.out.println("Server is ready");
			System.out.println("Up and running");
			JOptionPane.showMessageDialog(null, "Server is ready, up and running");		
			
			try {
				adminUserLogin.main(null);	
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
						
				
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
}
