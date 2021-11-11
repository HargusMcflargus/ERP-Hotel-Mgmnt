import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.border.BevelBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.JTable;

public class admindashboard extends JFrame{

	public static final String userLayout = "UserLayout", dashboardLayout = "DashboardLayout", historyLayout = "HistoryLayout", unitLayout = "unitLayout";
	
	//Variables
	public JPanel toppanel, overlappanel, carousel, dashboardpanel, availableunitspanel, soldunitspanel, reservedunitspanel, unitsPanel, usersPanel, historyPanel;
	public JLabel windowLabel, time;
	public JButton btnDashboard, btnUsers, btnHistory, btnLogout, btnUnits, updateUserButton, deleteUserButton, clearUserSelection;
	public CardLayout cardlayout;
	private JList userlist;
	private JPanel panel_1;
	private JTextField usernameField;
	private JTextField passwordField;
	private Database database;
	private JComboBox userType;
	private JButton addUserButton;
	private JTextField guestIDField;
	private JPanel panel_4_2;
	private JList availableUnits;
	private JPanel panel_5;
	private JComboBox owndershipStatus;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_4_1_2;
	private JPanel panel_4_3_2;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JTable userTable;
	/**
	 * Create the application.
	 */
	public admindashboard() throws Exception{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try {
			database = new Database();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setBounds(250, 50, 1001, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		toppanel = new JPanel();
		toppanel.setBackground(Color.BLACK);
		toppanel.setBounds(0, 0, 987, 62);
		getContentPane().add(toppanel);
		toppanel.setLayout(null);
		
		windowLabel = new JLabel("Dashboard");
		windowLabel.setBounds(332, 11, 336, 41);
		windowLabel.setForeground(Color.WHITE);
		windowLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 30));
		toppanel.add(windowLabel);
		
		overlappanel = new JPanel();
		overlappanel.setBorder(null);
		overlappanel.setForeground(Color.BLACK);
		overlappanel.setBackground(Color.LIGHT_GRAY);
		overlappanel.setBounds(0, 60, 202, 503);
		getContentPane().add(overlappanel);
		overlappanel.setLayout(null);
		
		btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnDashboard.setBackground(Color.DARK_GRAY);
				btnDashboard.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clearSelection();
				btnDashboard.setBackground(Color.DARK_GRAY);
				btnDashboard.setForeground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!windowLabel.getText().equals("Dashboard")) {
					btnDashboard.setBackground(Color.LIGHT_GRAY);
					btnDashboard.setForeground(Color.BLACK);
				}
			}
			
		});
		btnDashboard.setBounds(0, 11, 202, 45);
		overlappanel.add(btnDashboard);
		btnDashboard.setForeground(Color.BLACK);
		btnDashboard.setBackground(Color.LIGHT_GRAY);
		btnDashboard.addActionListener(e->{
			cardlayout.show(carousel, dashboardLayout);
			windowLabel.setText("Dashboard");
		});

		btnDashboard.setBorder(null);
		
		btnUnits = new JButton("UNITS");
		btnUnits.setBounds(0, 64, 202, 45);
		overlappanel.add(btnUnits);
		btnUnits.setForeground(Color.BLACK);
		btnUnits.setBackground(Color.LIGHT_GRAY);
		btnUnits.addActionListener(e->{
			cardlayout.show(carousel, unitLayout);
			windowLabel.setText("Available Units");
		});
		btnUnits.setBorder(null);
		btnUnits.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnUnits.setBackground(Color.DARK_GRAY);
				btnUnits.setForeground(Color.WHITE);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				clearSelection();
				btnUnits.setBackground(Color.DARK_GRAY);
				btnUnits.setForeground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!windowLabel.getText().equals("Available Units")) {
					btnUnits.setBackground(Color.LIGHT_GRAY);
					btnUnits.setForeground(Color.BLACK);
				}
			}
			
		});
		
		btnUsers = new JButton("USERS");
		btnUsers.setBounds(0, 120, 202, 45);
		overlappanel.add(btnUsers);
		btnUsers.setForeground(Color.BLACK);
		btnUsers.setBackground(Color.LIGHT_GRAY);
		btnUsers.addActionListener(e->{
			cardlayout.show(carousel, userLayout);
			windowLabel.setText("Users");
			userlist.clearSelection();
			addUserButton.setEnabled(true);
			updateUserButton.setEnabled(false);
			deleteUserButton.setEnabled(false);
			userType.setSelectedIndex(-1);
			clearUserSelection.setEnabled(false);
			usernameField.setText(null);
			passwordField.setText(null);
			try {
				loadUserList();
				loadUserTable();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		 btnUsers.setBorder(null);
		 btnUsers.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					btnUsers.setBackground(Color.DARK_GRAY);
					btnUsers.setForeground(Color.WHITE);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					clearSelection();
					btnUsers.setBackground(Color.DARK_GRAY);
					btnUsers.setForeground(Color.WHITE);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(!windowLabel.getText().equals("Users")) {
						btnUsers.setBackground(Color.LIGHT_GRAY);
						btnUsers.setForeground(Color.BLACK);
					}
				}
				
			});
		 
		 btnHistory = new JButton("HISTORY");
		 btnHistory.setBounds(0, 176, 202, 45);
		 overlappanel.add(btnHistory);
		 btnHistory.setForeground(Color.BLACK);
		 btnHistory.setBackground(Color.LIGHT_GRAY);
		 btnHistory.addActionListener(e->{
		 	cardlayout.show(carousel, historyLayout);
		 	windowLabel.setText("Past Transactions");
		 });
		 btnHistory.setBorder(null);
		 btnHistory.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					btnHistory.setBackground(Color.DARK_GRAY);
					btnHistory.setForeground(Color.WHITE);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					clearSelection();
					btnHistory.setBackground(Color.DARK_GRAY);
					btnHistory.setForeground(Color.WHITE);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					if(!windowLabel.getText().equals("Past Transactions")) {
						btnHistory.setBackground(Color.LIGHT_GRAY);
						btnHistory.setForeground(Color.BLACK);
					}
				}
				
			});
		 
		 btnLogout = new JButton("LOG-OUT");
		 btnLogout.setBounds(-34, 436, 226, 45);
		 overlappanel.add(btnLogout);
		 btnLogout.setForeground(Color.WHITE);
		 btnLogout.setBackground(Color.DARK_GRAY);
		 btnLogout.addActionListener(e->{
		 	int answer = JOptionPane.YES_NO_OPTION;
		 	JOptionPane.showConfirmDialog(null, "Are you sure you want ot logout?", "Confirm Exit", answer);
		 	if(answer == 0) {
		 		setVisible(false);
		 		index.Login.setVisible(true);
		 	}
		 });
		 btnLogout.setBorder(new RoundedCorners(10));

		 btnLogout.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					btnLogout.setBackground(Color.BLACK);
					btnLogout.setForeground(Color.WHITE);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					clearSelection();
					btnLogout.setBackground(Color.BLACK);
					btnLogout.setForeground(Color.WHITE);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					btnLogout.setBackground(Color.GRAY);
					btnLogout.setForeground(Color.BLACK);
				}
				
			});
		 
		 carousel = new JPanel();
		 cardlayout = new CardLayout();
		 carousel.setBounds(200, 60, 787, 503);
		 getContentPane().add(carousel);
		 carousel.setLayout(new CardLayout(0, 0));
		 carousel.setLayout(cardlayout);

		 //////////////////////////////////////////
		 
		 usersPanel = new JPanel();
		 usersPanel.setLayout(null);

		 dashboardpanel = new JPanel();
		 dashboardpanel.setLayout(null);
		 
		 unitsPanel = new JPanel();
		 unitsPanel.setLayout(null);
		 
		 historyPanel = new JPanel();
		 historyPanel.setLayout(null);

		 JPanel panel_4 = new JPanel();
		 panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Name", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		 panel_4.setBounds(36, 266, 223, 51);
		 unitsPanel.add(panel_4);
		 panel_4.setLayout(new BorderLayout(0, 0));
		 
		 JComboBox nameField = new JComboBox();
		 panel_4.add(nameField, BorderLayout.CENTER);
		 
		 JPanel panel_4_1 = new JPanel();
		 panel_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Guest ID", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		 panel_4_1.setBounds(200, 11, 430, 51);
		 unitsPanel.add(panel_4_1);
		 panel_4_1.setLayout(new BorderLayout(0, 0));
		 
		 guestIDField = new JTextField();
		 panel_4_1.add(guestIDField, BorderLayout.CENTER);
		 guestIDField.setColumns(10);
		 
		 JButton findButtonField = new JButton("Find");
		 panel_4_1.add(findButtonField, BorderLayout.EAST);
		 
		 panel_4_2 = new JPanel();
		 panel_4_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Owndership Status", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		 panel_4_2.setBounds(313, 266, 233, 51);
		 unitsPanel.add(panel_4_2);
		 panel_4_2.setLayout(new BorderLayout(0, 0));
		 
		 owndershipStatus = new JComboBox();
		 panel_4_2.add(owndershipStatus, BorderLayout.CENTER);
		 
		 JPanel panel_4_1_1 = new JPanel();
		 panel_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Unit Type", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		 panel_4_1_1.setBounds(313, 189, 233, 51);
		 unitsPanel.add(panel_4_1_1);
		 panel_4_1_1.setLayout(new BorderLayout(0, 0));
		 
		 JComboBox unitType = new JComboBox();
		 panel_4_1_1.add(unitType, BorderLayout.CENTER);
		 
		 panel_5 = new JPanel();
		 panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Available Units", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		 panel_5.setBounds(569, 73, 195, 396);
		 unitsPanel.add(panel_5);
		 panel_5.setLayout(new BorderLayout(0, 0));
		 
		 availableUnits = new JList();
		 panel_5.add(availableUnits); 

		 
		 JPanel panel_4_3 = new JPanel();
		 panel_4_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Contact Number", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		 panel_4_3.setBounds(36, 337, 223, 51);
		 unitsPanel.add(panel_4_3);
		 panel_4_3.setLayout(new BorderLayout(0, 0));
		 
		 textField = new JTextField();
		 panel_4_3.add(textField, BorderLayout.CENTER);
		 textField.setColumns(10);
		 
		 JPanel panel_4_3_1 = new JPanel();
		 panel_4_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email Address", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		 panel_4_3_1.setBounds(36, 418, 223, 51);
		 unitsPanel.add(panel_4_3_1);
		 panel_4_3_1.setLayout(new BorderLayout(0, 0));
		 
		 textField_1 = new JTextField();
		 panel_4_3_1.add(textField_1, BorderLayout.CENTER);
		 textField_1.setColumns(10);
		 
		 JPanel panel_4_2_1 = new JPanel();
		 panel_4_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Owndership Status", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		 panel_4_2_1.setBounds(313, 115, 233, 51);
		 unitsPanel.add(panel_4_2_1);
		 panel_4_2_1.setLayout(new BorderLayout(0, 0));
		 
		 panel_4_1_2 = new JPanel();
		 panel_4_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Price", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		 panel_4_1_2.setBounds(313, 337, 233, 51);
		 unitsPanel.add(panel_4_1_2);
		 panel_4_1_2.setLayout(new BorderLayout(0, 0));
		 
		 panel_4_3_2 = new JPanel();
		 panel_4_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email Address", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 255, 255)));
		 panel_4_3_2.setBounds(313, 418, 233, 51);
		 unitsPanel.add(panel_4_3_2);
		 panel_4_3_2.setLayout(new BorderLayout(0, 0));
		 
		 lblNewLabel_2 = new JLabel("Picture");
		 lblNewLabel_2.setBounds(116, 136, 55, 14);
		 unitsPanel.add(lblNewLabel_2);
		 
		 btnNewButton_1 = new JButton("New button");
		 btnNewButton_1.setBounds(108, 217, 89, 23);
		 unitsPanel.add(btnNewButton_1);
		 carousel.add(usersPanel, userLayout);
		 carousel.add(unitsPanel, unitLayout);
		 carousel.add(dashboardpanel, dashboardLayout);
		 carousel.add(historyPanel, historyLayout);
		 
		 /////////////////////////////////////////
		 
		 
		 availableunitspanel = new JPanel();
		 availableunitspanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), Color.DARK_GRAY, new Color(128, 128, 128), Color.LIGHT_GRAY));
		 availableunitspanel.setBackground(Color.ORANGE);
		 availableunitspanel.setBounds(89, 71, 199, 167);
		 dashboardpanel.add(availableunitspanel);
		 
		 soldunitspanel = new JPanel();
		 soldunitspanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 soldunitspanel.setBackground(Color.ORANGE);
		 soldunitspanel.setBounds(317, 71, 199, 167);
		 dashboardpanel.add(soldunitspanel);
		 
		 reservedunitspanel = new JPanel();
		 reservedunitspanel.setForeground(new Color(64, 64, 64));
		 reservedunitspanel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		 reservedunitspanel.setBackground(Color.ORANGE);
		 reservedunitspanel.setBounds(543, 71, 199, 167);
		 dashboardpanel.add(reservedunitspanel);
		 
		 
		 availableunitspanel.setBorder(new RoundedCorners(5)); //5 is the radius
		 availableunitspanel.setLayout(new BorderLayout(0, 0));
		 
		 JLabel availableCounter = new JLabel("0");
		 availableCounter.setForeground(Color.DARK_GRAY);
		 availableCounter.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 availableCounter.setHorizontalAlignment(SwingConstants.CENTER);
		 availableunitspanel.add(availableCounter, BorderLayout.CENTER);
		 
		 JLabel lblNewLabel_3 = new JLabel("Available Units");
		 lblNewLabel_3.setForeground(Color.DARK_GRAY);
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		 availableunitspanel.add(lblNewLabel_3, BorderLayout.NORTH);
		 soldunitspanel.setBorder(new RoundedCorners(5)); //5 is the radius
		 soldunitspanel.setLayout(new BorderLayout(0, 0));
		 
		 JLabel soldCounter = new JLabel("0");
		 soldCounter.setForeground(Color.DARK_GRAY);
		 soldCounter.setHorizontalAlignment(SwingConstants.CENTER);
		 soldCounter.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 soldunitspanel.add(soldCounter, BorderLayout.CENTER);
		 
		 JLabel lblNewLabel_3_1 = new JLabel("Sold Units");
		 lblNewLabel_3_1.setForeground(Color.DARK_GRAY);
		 lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 soldunitspanel.add(lblNewLabel_3_1, BorderLayout.NORTH);
		 reservedunitspanel.setBorder(new RoundedCorners(5)); //5 is the radius
		 reservedunitspanel.setLayout(new BorderLayout(0, 0));
		 
		 JLabel reservedCounter = new JLabel("0");
		 reservedCounter.setForeground(Color.DARK_GRAY);
		 reservedCounter.setHorizontalAlignment(SwingConstants.CENTER);
		 reservedCounter.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 reservedunitspanel.add(reservedCounter, BorderLayout.CENTER);
		 
		 JLabel lblNewLabel_3_2 = new JLabel("Reserved Units");
		 lblNewLabel_3_2.setForeground(Color.DARK_GRAY);
		 lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 reservedunitspanel.add(lblNewLabel_3_2, BorderLayout.NORTH);
		 
		 time = new JLabel("TIME: 69:00");
		 time.setForeground(Color.WHITE);
		 time.setHorizontalAlignment(SwingConstants.RIGHT);
		 time.setFont(new Font("Tahoma", Font.PLAIN, 30));
		 time.setBounds(516, 11, 246, 49);
		 updateDate();
		 dashboardpanel.add(time);
		 
		 JLabel lblNewLabel_1 = new JLabel("Available Unit Types");
		 lblNewLabel_1.setForeground(Color.WHITE);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_1.setBounds(69, 270, 150, 26);
		 dashboardpanel.add(lblNewLabel_1);
		 
		 
		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 /////USER TAB STUFF//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 
		 JPanel panel = new JPanel();
		 panel.setBorder(new TitledBorder(null, "User List", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		 panel.setBounds(31, 11, 723, 219);
		 usersPanel.add(panel);
		 panel.setLayout(null);
		 
		 userlist = new JList();
		 userlist.setBounds(23, 27, 118, 170);
		 userlist.addListSelectionListener(e->{
			 try {
				if(userlist.getSelectedIndex() > -1) {
					
					ResultSet resultSet = database.getData("user", "WHERE Username='" + userlist.getSelectedValue().toString() + "'");
					resultSet.next();
					usernameField.setText(resultSet.getString("Username"));
					passwordField.setText(resultSet.getString("Password"));
					if(resultSet.getString("Type").equals("Administrator")) 
						userType.setSelectedIndex(1);
					else
						userType.setSelectedIndex(0);
					deleteUserButton.setEnabled(true);
					updateUserButton.setEnabled(true);
					addUserButton.setEnabled(false);
					clearUserSelection.setEnabled(true);
				}else {
					deleteUserButton.setEnabled(false);
					updateUserButton.setEnabled(false);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 });
		 panel.add(userlist);
		 
		 panel_1 = new JPanel();
		 panel_1.setBorder(new TitledBorder(null, "Username", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		 panel_1.setBounds(317, 27, 223, 50);
		 panel.add(panel_1);
		 panel_1.setLayout(new BorderLayout(0, 0));
		 
		 usernameField = new JTextField();
		 panel_1.add(usernameField, BorderLayout.CENTER);
		 usernameField.setColumns(10);
		 
		 JPanel panel_1_1 = new JPanel();
		 panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Password", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 panel_1_1.setBounds(317, 88, 223, 49);
		 panel.add(panel_1_1);
		 panel_1_1.setLayout(new BorderLayout(0, 0));
		 
		 passwordField = new JTextField();
		 passwordField.setColumns(10);
		 panel_1_1.add(passwordField, BorderLayout.CENTER);
		 
		 JPanel panel_1_1_1 = new JPanel();
		 panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "User Type", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 panel_1_1_1.setBounds(317, 148, 223, 49);
		 panel.add(panel_1_1_1);
		 panel_1_1_1.setLayout(new BorderLayout(0, 0));
		 
		 userType = new JComboBox();
		 panel_1_1_1.add(userType, BorderLayout.CENTER);
		 
		 updateUserButton = new JButton("Save Changes");
		 updateUserButton.addActionListener(e->{
			 if(database.updateUser(new String[] {usernameField.getText(), passwordField.getText(), userType.getSelectedItem().toString()}, userlist.getSelectedValue().toString()) != -1) {
				 JOptionPane.showMessageDialog(null, "Update Successful");
				 try {
					loadUserList();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		 updateUserButton.setEnabled(false);
		 updateUserButton.setBounds(572, 148, 124, 23);
		 panel.add(updateUserButton);
		 
		 deleteUserButton = new JButton("Delete");
		 deleteUserButton.setEnabled(false);
		 deleteUserButton.setBounds(572, 80, 124, 23);
		 deleteUserButton.addActionListener(e->{
			 try {
				 if(database.deleteUser(userlist.getSelectedValue().toString())) {
					 JOptionPane.showMessageDialog(null, "User succcesfuly deleted");
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "User not Found");
				 }
			 }catch(Exception error) {
				 error.printStackTrace();
			 }
		 });
		 panel.add(deleteUserButton);
		 
		 addUserButton = new JButton("Add User");
		 addUserButton.setBounds(572, 46, 124, 23);
		 panel.add(addUserButton);
		 
		 clearUserSelection = new JButton("Clear Selection");
		 clearUserSelection.addActionListener(e->{
			 userlist.clearSelection();
			 addUserButton.setEnabled(true);
			 updateUserButton.setEnabled(false);
			 deleteUserButton.setEnabled(false);
			 userType.setSelectedIndex(-1);
			 clearUserSelection.setEnabled(false);
			 usernameField.setText(null);
			 passwordField.setText(null);
		 });
		 clearUserSelection.setEnabled(false);
		 clearUserSelection.setBounds(572, 114, 124, 23);
		 panel.add(clearUserSelection);
		 
		 JLabel lblNewLabel = new JLabel("Picture");
		 lblNewLabel.setBounds(208, 70, 55, 23);
		 panel.add(lblNewLabel);
		 
		 JButton btnBrowseUser = new JButton("Browse...");
		 btnBrowseUser.setBounds(186, 174, 89, 23);
		 panel.add(btnBrowseUser);
		 
		 JPanel panel_2 = new JPanel();
		 panel_2.setBorder(new TitledBorder(null, "Search User", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		 panel_2.setBounds(31, 251, 358, 41);
		 usersPanel.add(panel_2);
		 panel_2.setLayout(new BorderLayout(0, 0));
		 
		 textField_2 = new JTextField();
		 panel_2.add(textField_2, BorderLayout.CENTER);
		 textField_2.setColumns(10);
		 
		 JButton btnNewButton = new JButton("Filter");
		 panel_2.add(btnNewButton, BorderLayout.EAST);
		 
		 userTable = new JTable();
		 userTable.setBounds(31, 317, 723, 111);
		 usersPanel.add(userTable);
		 addUserButton.addActionListener(e->{
			 if(!usernameField.getText().equals(null) && !passwordField.getText().equals(null)) {
				 try {
					if(!database.verifyuser(usernameField.getText(), passwordField.getText().toCharArray())) {
						if(database.insertUser(usernameField.getText(), passwordField.getText(), userType.getSelectedItem().toString()) != -1) {
							JOptionPane.showMessageDialog(null, "User Added!)");
							usernameField.setText(null);
							passwordField.setText(null);
							userType.setSelectedIndex(-1);
							loadUserList();
						}
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		 
		 try {
			loadUserList();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
	
	public void updateDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd, yyyy");
		time.setText(sdf.format(date));
	}
	public void loadUserList() throws SQLException {
		userlist.clearSelection();
		usernameField.setText(null);
		passwordField.setText(null);
		userType.setModel(new DefaultComboBoxModel(new String[] {"User", "Administrator"}));
		userType.setSelectedIndex(-1);
		DefaultListModel listModel = new DefaultListModel();
		userlist.setModel(listModel);
		
		listModel.removeAllElements();
		
		ResultSet resultSet = database.getTable("user");
		while(resultSet.next()) {
			listModel.addElement(resultSet.getString("Username"));
		}
	}
	
	private void clearSelection() {
		btnDashboard.setBackground(Color.LIGHT_GRAY);
		btnDashboard.setForeground(Color.BLACK);
		
		btnUnits.setBackground(Color.LIGHT_GRAY);
		btnUnits.setForeground(Color.BLACK);
		
		btnUsers.setBackground(Color.LIGHT_GRAY);
		btnUsers.setForeground(Color.BLACK);
		
		btnHistory.setBackground(Color.LIGHT_GRAY);
		btnHistory.setForeground(Color.BLACK);
	}
	
	private void loadUserTable() {
		String columns[] = {
			"Username",
			"Password",
			"User Type"
		};
		String[][] data = new String[userlist.getModel().getSize()][3];
		try {
			ResultSet resultset = database.getTable("user");
			int i = 0;
			while(resultset.next()) {
				data[i] = new String[] {resultset.getString("Username"), resultset.getString("Password"), resultset.getString("Type")};
				i++;
			}
			userTable = new JTable(data, columns);
			userTable.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
