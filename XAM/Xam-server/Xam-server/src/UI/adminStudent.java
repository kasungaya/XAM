package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import net.proteanit.sql.DbUtils;
/**
 * This class implements the student data management.
 * This collect student data and do the functions of add,remove,edit and search.
 * This class will be updated each time when above function has been done and will be displayed on the Jtable.
 * This class is not presented to the client side because the management of student data cannot be done by the client side 
 * so it is in the server side.
 * @author Kasun Abeywardana
 */

public class adminStudent extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField sid;
	private JTextField sfname;
	private JTextField slname;
	private JTextField sphne;
	private JTable table;
	private JTextField semail;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					adminStudent window = new adminStudent();
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
	public adminStudent() {
		initialize();
	/**
	 * when the application initiate textfields will be set to blanks.
	 */
		sid.setText("");
		sfname.setText("");
		slname.setText("");
		semail.setText("");
		sphne.setText("");
			
		/**
         * implements the database connection from the db.java class.
         * collect the student data from the student table to display on the jtable.
         */
		 try{	           
	            Connection c = db.mycon();
	            Statement s = (Statement) c.createStatement();
	            String sql = "SELECT studentID,firstname,lastname,email,phone FROM student";
	            ResultSet rs = s.executeQuery(sql);
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	           
	        }catch (Exception e){            
	        }	
		 
	}

	
	 public boolean isValidName(String name) {
	       
	        char c;
	        for (int i = 0; i < name.length(); i++) {
	            c = name.charAt(i);
	            if (!Character.isLetter(c)) {
	                JOptionPane.showMessageDialog(rootPane,"Enter Charactors Only in the Name Field");
	                return false;	                
	            }
	        }
	        return true;
	    }
	    
	      public boolean isValidNumber(String name) {
	        
	        char c;
	        for (int i = 0; i < name.length(); i++) {
	            c = name.charAt(i);
	            if (!Character.isDigit(c)) {
	                JOptionPane.showMessageDialog(rootPane,"Enter Numbers Only in the Phone Field");
	                return false;                
	            }
	        }
	        return true;
	    }
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 1246, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				/**
		            * implements the database connection 
		            * deletion of student data where student id is equal to the given id in the textfield.
		            * set the textfields to blanks.		           
		            * update jtable to display data of database after the deletion is done. 
		            */	
				try {
					
					Connection c = db.mycon();
		            Statement s = (Statement) c.createStatement();
		            s.executeUpdate("DELETE from student WHERE studentID='" + sid.getText() + "'");
		          				
		            sid.setText("");
		    		sfname.setText("");
		    		slname.setText("");
		    		semail.setText("");
		    		sphne.setText("");
					
		    		 JOptionPane.showMessageDialog(null, "Successfully Removed"); 
		    		 
		    		 try{
		 	            		 	       
		 	            String sql = "SELECT studentID,firstname,lastname,email,phone FROM student";
		 	            ResultSet rs = s.executeQuery(sql);
		 	            table.setModel(DbUtils.resultSetToTableModel(rs));
		 	            
		 	        }catch (Exception e){		 	            
		 	        }	            	    		
				}catch(Exception e){					
				}			
			}
		});
		btnNewButton.setBounds(187, 587, 146, 30);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			 

			public void actionPerformed(ActionEvent arg0) {
				/**
		            * implements the database connection 
		            * update of student data where student id is equal to the given id in the textfield.
		            * set the textfields to blanks.		           
		            * update jtable to display data of database after the update is done. 
		            */					
				try {
					
					Connection c = db.mycon();
		            Statement s = (Statement) c.createStatement();
		            if(isValidName(sfname.getText()) == !false && isValidName(slname.getText()) == !false && isValidNumber(sphne.getText()) == !false){
		            s.executeUpdate("UPDATE student SET firstname = '" +sfname.getText()+ "',lastname = '" +slname.getText()+ "',email = '" +semail.getText()+ "',phone = '" + sphne.getText() + "'WHERE studentID = '" +sid.getText()+ "'");
		           			
		            sid.setText("");
		    		sfname.setText("");
		    		slname.setText("");
		    		semail.setText("");
		    		sphne.setText("");
					
		    		 JOptionPane.showMessageDialog(null, "Successfully Updated");  
		    		 
		            } try{    
			 	            String sql = "SELECT studentID,firstname,lastname,email,phone FROM student";
			 	            ResultSet rs = s.executeQuery(sql);
			 	            table.setModel(DbUtils.resultSetToTableModel(rs));
			 	            
			 	        }catch (Exception e){			 	            
			 	        }		            	    		
				}catch(Exception e){					
				}
			}
		});
		btnEdit.setBounds(373, 587, 135, 30);
		btnEdit.setForeground(new Color(255, 255, 255));
		btnEdit.setBackground(new Color(70, 130, 180));
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			 
			public void actionPerformed(ActionEvent arg0) {
				  /**
		            * implements the database connection 
		            * insertion of student data.
		            * set the textfields to blanks.		           
		            * update jtable to display data of database after the insertion is done. 
		            */		
				
				try {
					
					Connection c = db.mycon();
		            Statement s = (Statement) c.createStatement();
		            if(isValidName(sfname.getText()) == !false && isValidName(slname.getText()) == !false && isValidNumber(sphne.getText()) == !false){
		            s.executeUpdate("INSERT INTO student(studentID,firstname,lastname,email,phone) VALUES('" +sid.getText()+ "','" +sfname.getText()+ "','" +slname.getText()+ "', '" + semail.getText()+ "','" + sphne.getText()+ "')");
		           			
		            sid.setText("");
		    		sfname.setText("");
		    		slname.setText("");
		    		semail.setText("");
		    		sphne.setText("");
					
		    		 JOptionPane.showMessageDialog(null, "Successfully Saved");    
		            }
		    		 try{    
			 	            String sql = "SELECT studentID,firstname,lastname,email,phone FROM student";
			 	            ResultSet rs = s.executeQuery(sql);
			 	            table.setModel(DbUtils.resultSetToTableModel(rs));
			 	            
			 	        }catch (Exception e){		 	            
			 	        }
				}catch(Exception e){				
				}			
			}
		});
		btnAdd.setBounds(724, 587, 135, 30);
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(btnAdd);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1229, 73);
		panel.setBackground(new Color(0, 153, 204));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblXam = new JLabel("   X-AM! - Admin Panel");
		lblXam.setBounds(452, 16, 418, 46);
		panel.add(lblXam);
		lblXam.setForeground(new Color(255, 255, 255));
		lblXam.setBackground(new Color(255, 255, 255));
		lblXam.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * this will logout from the admin panel and admin login application will appear.
				 */
				adminUserLogin.main(null);
				frame.dispose();
			}
		});
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBounds(1119, 34, 97, 25);
		panel.add(btnLogout);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 139, 528, 427);
		panel_1.setBackground(new Color(220, 220, 220));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(50, 91, 56, 16);
		panel_1.add(lblUserId);
		lblUserId.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sid = new JTextField();
		sid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				sfname.grabFocus();
			}
		});
		sid.setBounds(171, 82, 175, 35);
		panel_1.add(sid);
		sid.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(50, 155, 99, 16);
		panel_1.add(lblFirstName);
		lblFirstName.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sfname = new JTextField();
		sfname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				slname.grabFocus();
			}
		});
		sfname.setBounds(171, 146, 325, 35);
		panel_1.add(sfname);
		sfname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(50, 224, 99, 25);
		panel_1.add(lblLastName);
		lblLastName.setFont(new Font("Calibri", Font.BOLD, 17));
		
		slname = new JTextField();
		slname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				semail.grabFocus();
			}
		});
		slname.setBounds(171, 219, 325, 35);
		panel_1.add(slname);
		slname.setColumns(10);
		
		JLabel lblGender = new JLabel("Email");
		lblGender.setBounds(50, 297, 56, 16);
		panel_1.add(lblGender);
		lblGender.setFont(new Font("Calibri", Font.BOLD, 17));
		
		JLabel lblNewLabel = new JLabel("Phone");
		lblNewLabel.setBounds(50, 369, 56, 16);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 17));
		
		sphne = new JTextField();
		sphne.setBounds(171, 360, 200, 35);
		panel_1.add(sphne);
		sphne.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(60, 179, 113));
		panel_4.setBounds(12, 13, 504, 34);
		panel_1.add(panel_4);
		
		JLabel lblIAmA = new JLabel("Student");
		lblIAmA.setForeground(Color.WHITE);
		panel_4.add(lblIAmA);
		lblIAmA.setFont(new Font("Calibri Light", Font.BOLD, 20));
		
		semail = new JTextField();
		semail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				sphne.grabFocus();
			}
		});
		semail.setBounds(171, 288, 258, 35);
		panel_1.add(semail);
		semail.setColumns(10);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 79, 528, 54);
		panel_2.setBackground(new Color(0, 102, 153));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * button click will goes to the adminpanel managemnet of teachers' data.
				 */
				try {
				adminTeacher.main(null);	
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				frame.dispose();
				
			}
		});
		btnTeacher.setForeground(Color.WHITE);
		btnTeacher.setBackground(Color.LIGHT_GRAY);
		btnTeacher.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnTeacher.setBounds(85, 13, 125, 25);
		panel_2.add(btnTeacher);
		
		JButton btnStudent = new JButton("Student");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStudent.setBackground(Color.LIGHT_GRAY);
		btnStudent.setForeground(Color.WHITE);
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnStudent.setBounds(330, 13, 125, 25);
		panel_2.add(btnStudent);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
		            * implements the database connection 
		            * Search of student data where student id is equal to the given id in the textfield.
		            * set the textfields to data collected from the database.		           		          
		            */
				 try {
				        Connection c = db.mycon();
				        Statement s = (Statement) c.createStatement();
				        ResultSet rs = s.executeQuery("SELECT * FROM student WHERE studentID='" + sid.getText() + "'");
				        while (rs.next()) {
				            
				            sfname.setText(rs.getString("firstname"));
				            slname.setText(rs.getString("lastname"));
				            semail.setText(rs.getString("email"));
				            sphne.setText(rs.getString("phone"));		           
				           
				        }
				    } catch (Exception e) {
				        e.printStackTrace();
				    }		
			}
		});
		btnNewButton_1.setBounds(552, 587, 135, 30);
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(20, 587, 135, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * set the textfields to blanks.
				 */
				sid.setText("");
				sfname.setText("");
				slname.setText("");
				semail.setText("");
				sphne.setText("");
			}
		});
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 17));
		frame.getContentPane().add(btnClear);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(552, 79, 664, 487);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
	/*	table.setModel(DbUtils.resultSetToTableModel(rs));*/
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 664, 487);
		panel_3.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User ID", "First Name", "Last Name", "Email", "Phone"
			}
		));
	}
}
