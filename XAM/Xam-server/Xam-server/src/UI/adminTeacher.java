package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*import org.apache.commons.dbutils.DbUtils;*/
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.proteanit.sql.DbUtils;
/**
 * This class implements the teacher data management.
 * This collect teacher data and do the functions of add,remove,edit and search.
 * This class will be updated each time when above function has been done and will be displayed on the Jtable.
 * This class is not presented to the client side because the management of teacher data cannot be done by the client side 
 * so it is in the server side.
 * @author Kasun Abeywardana
 */
public class adminTeacher extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField tid;
	private JTextField tfname;
	private JTextField tlname;
	private JTextField tphne;
	private JTextField temail;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
								
					adminTeacher window = new adminTeacher();
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
	public adminTeacher() {
		initialize();
		/**
		 * when the application initiate textfields will be set to blanks.
		 */
		tid.setText("");
		tfname.setText("");
		tlname.setText("");
		temail.setText("");
		tphne.setText("");
		
		/**
         * implements the database connection from the db.java class.
         * collect the teacher data from the teacher table to display on the jtable.
         */
		 try{            
	            Connection c = db.mycon();
	            Statement s = (Statement) c.createStatement();
	            String sql = "SELECT teacherID,firstname,lastname,email,phone FROM teacher";
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
		frame.setBounds(100, 100, 1309, 684);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(0, 0, 1301, 74);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 153, 204));
		frame.getContentPane().add(panel);
		
		JLabel label = new JLabel("   X-AM! - Admin Panel");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 32));
		label.setBackground(Color.WHITE);
		label.setBounds(447, 16, 418, 46);
		panel.add(label);
		
		JButton button = new JButton("Logout");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * this will logout from the adminpanel and adminlogin application will appear.
				 */
				adminUserLogin.main(null);
				frame.dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(Color.WHITE);
		button.setBounds(1182, 34, 97, 25);
		panel.add(button);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(556, 80, 730, 488);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"User ID", "First Name", "Last Name", "Email", "Phone"
			}
		));
		scrollPane.setViewportView(table);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 80, 530, 48);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 102, 153));
		frame.getContentPane().add(panel_1);
		
		JButton button_1 = new JButton("Teacher");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(85, 13, 125, 25);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Student");
		button_2.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * button click will goes to the adminpanel managemnet of students' data.
				 */
				try {
					adminStudent.main(null);	
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					frame.dispose();		
			}
		});
		button_2.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_2.setBackground(Color.LIGHT_GRAY);
		button_2.setBounds(330, 13, 125, 25);
		panel_1.add(button_2);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(10, 140, 530, 428);
		panel_2.setBackground(new Color(220, 220, 220));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("User ID");
		label_1.setBounds(50, 85, 56, 16);
		label_1.setFont(new Font("Calibri", Font.BOLD, 17));
		panel_2.add(label_1);
		
		tid = new JTextField();
		tid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				tfname.grabFocus();
			}
		});
		tid.setBounds(171, 76, 175, 35);
		tid.setColumns(10);
		panel_2.add(tid);
		
		JLabel label_2 = new JLabel("First Name");
		label_2.setBounds(50, 148, 99, 16);
		label_2.setFont(new Font("Calibri", Font.BOLD, 17));
		panel_2.add(label_2);
		
		tfname = new JTextField();
		tfname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				tlname.grabFocus();
			}
		});
		tfname.setBounds(171, 139, 325, 35);
		tfname.setColumns(10);
		panel_2.add(tfname);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setBounds(50, 216, 99, 25);
		label_3.setFont(new Font("Calibri", Font.BOLD, 17));
		panel_2.add(label_3);
		
		tlname = new JTextField();
		tlname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				temail.grabFocus();
			}
		});
		tlname.setBounds(171, 211, 325, 35);
		tlname.setColumns(10);
		panel_2.add(tlname);
		
		JLabel label_6 = new JLabel("Phone");
		label_6.setBounds(50, 372, 56, 16);
		label_6.setFont(new Font("Calibri", Font.BOLD, 17));
		panel_2.add(label_6);
		
		tphne = new JTextField();
		tphne.setBounds(171, 363, 200, 35);
		tphne.setColumns(10);
		panel_2.add(tphne);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(50, 299, 85, 16);
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 17));
		panel_2.add(lblEmail);
		
		temail = new JTextField();
		temail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * curser goes to the next line.
				 */
				tphne.grabFocus();
			}
		});
		temail.setBounds(171, 290, 250, 35);
		temail.setColumns(10);
		panel_2.add(temail);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 13, 508, 34);
		panel_3.setBackground(new Color(60, 179, 113));
		panel_2.add(panel_3);
		
		JLabel lblTeacher = new JLabel("Teacher");
		lblTeacher.setForeground(Color.WHITE);
		lblTeacher.setFont(new Font("Calibri Light", Font.BOLD, 20));
		panel_3.add(lblTeacher);
		
		JButton button_3 = new JButton("Clear");
		button_3.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * set the textfields to blanks.	
				 */
				tid.setText("");
				tfname.setText("");
				tlname.setText("");
				temail.setText("");
				tphne.setText("");
			}
		});
		button_3.setBounds(36, 593, 135, 30);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_3.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("Remove");
		button_4.addActionListener(new ActionListener() {
					
			public void actionPerformed(ActionEvent arg0) {
				/**
		            * implements the database connection 
		            * deletion of teacher data where teacher id is equal to the given id in the textfield.
		            * set the textfields to blanks.		           
		            * update jtable to display data of database after the deletion is done. 
		            */
				try {		
					
					Connection c = db.mycon();
		            Statement s = (Statement) c.createStatement();
		            s.executeUpdate("DELETE from teacher WHERE teacherID='" + tid.getText() + "'");
		          				
		            tid.setText("");
		    		tfname.setText("");
		    		tlname.setText("");
		    		temail.setText("");
		    		tphne.setText("");
					
		    		 JOptionPane.showMessageDialog(null, "Successfully Removed");    
		            	  
		    		 try{
		 	            	 	            
		 	            String sql = "SELECT teacherID,firstname,lastname,email,phone FROM teacher";
		 	            ResultSet rs = s.executeQuery(sql);
		 	            table.setModel(DbUtils.resultSetToTableModel(rs));
		 	            
		 	        }catch (Exception e){	 	            
		 	        }
				}catch(Exception e){				
				}
			}
		});
		button_4.setBounds(214, 593, 135, 30);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_4.setBackground(new Color(220, 20, 60));
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Edit");
		button_5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				/**
		            * implements the database connection 
		            * update of teacher data where teacher id is equal to the given id in the textfield.
		            * set the textfields to blanks.		           
		            * update jtable to display data of database after the update is done. 
		            */	
				try {
					
					Connection c = db.mycon();
		            Statement s = (Statement) c.createStatement();
		            if(isValidName(tfname.getText()) == !false && isValidName(tlname.getText()) == !false && isValidNumber(tphne.getText()) == !false){
		            s.executeUpdate("UPDATE teacher SET firstname = '" +tfname.getText()+ "',lastname = '" +tlname.getText()+ "',email = '" +temail.getText()+ "',phone = '" + tphne.getText() + "'WHERE teacherID = '" +tid.getText()+ "'");
		           			
		            tid.setText("");
		    		tfname.setText("");
		    		tlname.setText("");
		    		temail.setText("");
		    		tphne.setText("");
					
		    		 JOptionPane.showMessageDialog(null, "Successfully Updated");    
		            	
		            } try{
      	 	            
			 	            String sql = "SELECT teacherID,firstname,lastname,email,phone FROM teacher";
			 	            ResultSet rs = s.executeQuery(sql);
			 	            table.setModel(DbUtils.resultSetToTableModel(rs));
			 	            
			 	        }catch (Exception e){		 	            
			 	        }
				}catch(Exception e){				
				}				
			}
		});
		button_5.setBounds(389, 593, 135, 30);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_5.setBackground(new Color(70, 130, 180));
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("Search");
		button_6.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				/**
		            * implements the database connection 
		            * Search of teacher data where teacher id is equal to the given id in the textfield.
		            * set the textfields to data collected from the database.		           		          
		            */
				 try {
				        Connection c = db.mycon();
				        Statement s = (Statement) c.createStatement();
				        ResultSet rs = s.executeQuery("SELECT * FROM teacher WHERE teacherID='" + tid.getText() + "'");
				        while (rs.next()) {
				            
				            tfname.setText(rs.getString("firstname"));
				            tlname.setText(rs.getString("lastname"));
				            temail.setText(rs.getString("email"));
				            tphne.setText(rs.getString("phone"));		           
				           
				        }
				    } catch (Exception e) {
				        e.printStackTrace();
				    }						
			}
		});
		button_6.setBounds(568, 593, 135, 30);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_6.setBackground(new Color(0, 153, 255));
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("Add");
		button_7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {									
				/**
		            * implements the database connection 
		            * insertion of teacher data.
		            * set the textfields to blanks.		           
		            * update jtable to display data of database after the insertion is done. 
		            */						
				try {
					
					Connection c = db.mycon();
		            Statement s = (Statement) c.createStatement();
		            if(isValidName(tfname.getText()) == !false && isValidName(tlname.getText()) == !false && isValidNumber(tphne.getText()) == !false){
		            s.executeUpdate("INSERT INTO Teacher(teacherID,firstname,lastname,email,phone) VALUES('" +tid.getText()+ "','" +tfname.getText()+ "','" +tlname.getText()+ "', '" + temail.getText()+ "','" + tphne.getText()+ "')");
		           				
		            tid.setText("");
		    		tfname.setText("");
		    		tlname.setText("");
		    		temail.setText("");
		    		tphne.setText("");
					
		    		 JOptionPane.showMessageDialog(null, "Successfully Saved");    
		            }
		    		 try{
	      	 	            
			 	            String sql = "SELECT teacherID,firstname,lastname,email,phone FROM teacher";
			 	            ResultSet rs = s.executeQuery(sql);
			 	            table.setModel(DbUtils.resultSetToTableModel(rs));
			 	            
			 	        }catch (Exception e){		 	            
			 	        }
				}catch(Exception e){				
				}				
			}
		});
		button_7.setBounds(740, 593, 135, 30);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 17));
		button_7.setBackground(Color.GREEN);
		frame.getContentPane().add(button_7);
	
	}	
	
}
