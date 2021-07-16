//registration form
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 public class second_atm extends JFrame implements ActionListener{//1
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   
	   static final String DB_URL = "jdbc:mysql://localhost/kumon";  
	   //  Database credentials 
	   static final String USER = "root"; 
	   static final String PASS = ""; 
	
	public static void main(String[]args){//2
	second_atm panel = new second_atm();
	panel.setSize(400,440);
	panel.setVisible(true);
	panel.setResizable(false);
	panel.setLocation(400,250);
	}//3
	
	
	Font f1 = new Font("", Font.BOLD, 10);
	JLabel lblFName = new JLabel("First Name ",JLabel.RIGHT);	
	JLabel lblLName = new JLabel("Last Name ",JLabel.RIGHT);
	JLabel lblcdays = new JLabel("Class Days ",JLabel.RIGHT);
	JLabel lblmail = new JLabel("email ",JLabel.RIGHT);
	JLabel lblcontact = new JLabel("Contact No. ",JLabel.RIGHT);
	JLabel lblsubject = new JLabel("Subjects ",JLabel.RIGHT);
	JLabel lblBday = new JLabel("B-Day ",JLabel.RIGHT);
	JLabel lblCash = new JLabel("payment ",JLabel.RIGHT);
	JLabel lblday = new JLabel("Day");
	JLabel lblMonth = new JLabel("Month");
	JLabel lblyer = new JLabel("Year");
	
	JTextField txtFName = new JTextField(20);
	JTextField txtLName= new JTextField(20);
	JTextField txtmail = new JTextField(20);
	JTextField txtcontact= new JTextField(20);
	JTextField txtcdays = new JTextField(20);
	JTextField txtday = new JTextField(20);
	JTextField txtmonth = new JTextField(20);
	JTextField txtyear = new JTextField(20);
	JTextField txtCash = new JTextField(20);
	JTextField txtsubject = new JTextField(20);
	
	JButton btnCret = new JButton("register now");
	
	
	
	Connection cn;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;
	PreparedStatement ps1;


	
	public void clear(){//4
		
		txtFName.setText("");
		txtLName.setText("");
		txtcontact.setText("");
		txtmail.setText("");
		txtcdays.setText("");
		txtsubject.setText("");
	}//5
	
	public second_atm() {//6
		super("Kumon Student Registration");
	
		JPanel pane = new JPanel();
		pane.setLayout(null);
		
		lblyer.setFont(f1);
		lblday.setFont(f1);
		lblMonth.setFont(f1);
		lblFName.setBounds(5,50,120,25);
		pane.add(lblFName);
		txtFName.setBounds(125,50,150,25);
		pane.add(txtFName);
		
		lblLName.setBounds(5,85,120,25);
		pane.add(lblLName);
		txtLName.setBounds(125,85,150,25);
		pane.add(txtLName);
		
		lblmail.setBounds(5,120,120,25); 
		pane.add(lblmail);
		txtmail.setBounds(125,120,150,25); 
		pane.add(txtmail);
		
		lblcontact.setBounds(5,155,120,25);
		pane.add(lblcontact);
		txtcontact.setBounds(125,155,150,25);
		pane.add(txtcontact);
		
		lblcdays.setBounds(5,190,120,25);
		pane.add(lblcdays);
		txtcdays.setBounds(125,190,150,25); 
		pane.add(txtcdays);	
		
		lblsubject.setBounds(5,225,120,25);
		pane.add(lblsubject);
		txtsubject.setBounds(125,225,150,25); 
		pane.add(txtsubject);	
		
		lblBday.setBounds(5,260,120,25);
		pane.add(lblBday);	
		txtday.setBounds(125,260,50,25);
		pane.add(txtday);	
		txtmonth.setBounds(175,260,50,25);
		pane.add(txtmonth);
		txtyear.setBounds(225,260,50,25);
		pane.add(txtyear);
		lblday.setBounds(135,195,70,20);
		pane.add(lblday);
		lblMonth.setBounds(185,195,70,20);
		pane.add(lblMonth);
		lblyer.setBounds(235,195,70,20);
		pane.add(lblyer);
	
			
		lblCash.setBounds(5,310,120,25);
		pane.add(lblCash);
		txtCash.setBounds(125,310,100,25);
		pane.add(txtCash);
			
		btnCret.setBounds(129,345,120,35);
		pane.add(btnCret);
		btnCret.addActionListener(this);
	
	
		JLabel lbl = new JLabel();
		
		lbl.setBounds(0,0,400,440);
		pane.add(lbl);
		
		setContentPane(pane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane.setBorder(BorderFactory.createTitledBorder(
           BorderFactory.createEtchedBorder(), "Kumon Registration Form"));
		
		try{//7
			 Class.forName("com.mysql.jdbc.Driver"); 
			cn = DriverManager.getConnection(DB_URL,USER,PASS);
		}//8
		catch(ClassNotFoundException e)  {//9
 			System.err.println("Failed to load driver");
 			e.printStackTrace();
 		}//10
 		catch(SQLException e){//11
 			System.err.println("Unable to connect");
 			e.printStackTrace();
 		}//12
	}//13

			public void actionPerformed(ActionEvent e){//14

				Object source = e.getSource();
				if(source == btnCret){//15
	String suser = 	txtFName.getText();
	String sname =	txtLName.getText();
	String spass = 	txtcontact.getText();
	String slname =	txtmail.getText();
	String svpass = txtcdays.getText();
	String ssubject = txtsubject.getText();

			
		
	if((suser.length()==0 || sname.length()==0 || spass.length()==0 || slname.length()==0 || svpass.length()==0 ||ssubject.length()==0)){//16
    					JOptionPane.showMessageDialog(null,"Some Fields are empty","WARNING",JOptionPane.WARNING_MESSAGE);
    				}//17
    				
	else{
		
							try{

			st= cn.createStatement();
			
					
			ps=cn.prepareStatement("INSERT INTO tbl_list " + " (FirstName,LastName,Email,contact,cdays,subject,bday,bmonth,byear,payment) " + " VALUES(?,?,?,?,?,?,?,?,?,?)");		
			ps.setString(1,txtFName.getText());	
			ps.setString(2,txtLName.getText());
			ps.setString(3,txtmail.getText());
			ps.setString(4,txtcontact.getText());
			ps.setString(5,txtcdays.getText());
			ps.setString(6,txtsubject.getText());
			ps.setString(7,txtday.getText());
			ps.setString(8,txtmonth.getText());
			ps.setString(9,txtyear.getText());
			ps.setString(10,txtCash.getText());
			
			
			
				
				
			
			
			ps.executeUpdate();
			
		
			JOptionPane.showMessageDialog(null,"Your New Account has been successfully Created.","kumon",JOptionPane.INFORMATION_MESSAGE);
			txtFName.requestFocus(true);
			st.close();
			clear();
			
			
			}
			//}

			catch(SQLException sqlEx){
			JOptionPane.showMessageDialog(null,"General error","kumon",JOptionPane.INFORMATION_MESSAGE);
			}
					
				}
			}
			
			
			
									
			
			}
			
			
			
			
							

					}
					


				