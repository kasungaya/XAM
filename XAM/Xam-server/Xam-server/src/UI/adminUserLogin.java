package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import Interface.adminLoginInterface;

import java.rmi.*;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import java.awt.Color;
/**
 * This class implements the login for the admin panel management.
 * This collect username and password and check with user credentials to complete the process of login.
 * This admin login is not presented to the client side so it is in the server side.
 * @author Kasun Abeywardana
 */
public class adminUserLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtusername;
	private JTextField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminUserLogin window = new adminUserLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminUserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 561, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(63, 103, 128, 31);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(63, 173, 84, 14);
		frame.getContentPane().add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setBounds(201, 105, 160, 30);
		frame.getContentPane().add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBounds(201, 167, 160, 30);
		frame.getContentPane().add(txtpassword);
		txtpassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				boolean f = false;
				try {
					
					adminLoginInterface i = (adminLoginInterface)Naming.lookup("rmi://localhost:1099/login");				
					f = i.getLoginAndAuthentication(txtusername.getText(), txtpassword.getText());
					
					if( f == true ) 
					{				
						try {
							adminTeacher.main(null);	
							}catch(Exception ex) {
								ex.printStackTrace();
							}
							frame.dispose();		
					}
					
					else
					{
						
						JOptionPane.showMessageDialog(null, "Please Check Credentials");
						
					}
										
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogin.setBounds(201, 240, 110, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtusername.setText("");
				txtpassword.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(345, 240, 110, 25);
		frame.getContentPane().add(btnNewButton);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(10, 10, 525, 73);
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("   X-AM! - Admin Panel Login");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 23));
		label.setBackground(Color.WHITE);
		label.setBounds(89, 11, 373, 46);
		panel.add(label);
		
		JButton button = new JButton("Logout");
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.WHITE);
		button.setBounds(1119, 34, 97, 25);
		panel.add(button);
	}
}
