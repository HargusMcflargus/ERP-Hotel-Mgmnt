import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame{

	private JTextField userField;
	private JPasswordField passwordField;
	private Database database;

	public login() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		try {
			database = new Database();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		getContentPane().setBackground(new Color(0, 255, 255));
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(100, 100, 710, 376);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 72));
		lblNewLabel.setBounds(10, 11, 396, 313);
		lblNewLabel.setIcon(new ImageIcon("D:\\C O D E\\Github\\ERP\\Condo Management\\res\\logo_erp.png"));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME: ");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(416, 68, 121, 31);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(416, 149, 121, 31);
		getContentPane().add(lblNewLabel_1_1);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userField.setBounds(416, 99, 254, 39);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(416, 177, 254, 40);
		getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("LOG-IN");
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		loginButton.setBounds(539, 244, 131, 39);
		getContentPane().add(loginButton);
		loginButton.addActionListener(e->{
			try {
				if(database.verifyuser(userField.getText(), passwordField.getPassword())) {
					//Login User
					logon(userField.getText());
				}
				else {
					userField.setText(null);
					passwordField.setText(null);
				}
			} catch (SQLException error) {
				error.printStackTrace();
			}
		});
	}
	
	public void logon(String username) {
		JOptionPane.showMessageDialog(this, "Welcome " + username);
		userField.setText(null);
		passwordField.setText(null);
		index.dashboard.setVisible(true);
		setVisible(false);
		//Condition kung si admin o user
	}
}
