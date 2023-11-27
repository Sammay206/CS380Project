package project380;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class loginGUI {

	private JFrame frame;
	private JTextField uName;
	private JTextField passwordField;
	private boolean newU = false; 
	private User currentUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginGUI window = new loginGUI();
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
	public loginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.connection();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Budget App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 60);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		JLabel title = new JLabel("Welcome!");
		title.setBounds(150, 30, 80, 13);
		panel.add(title);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter a Username and Password ");
		lblNewLabel_1.setBounds(100, 50, 65, 50);
		
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Username: ");
		lblNewLabel.setBounds(97, 83, 80, 16);
		frame.getContentPane().add(lblNewLabel);
		
		uName = new JTextField();
		uName.setBounds(189, 78, 130, 26);
		frame.getContentPane().add(uName);
		uName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		lblNewLabel_2.setBounds(97, 111, 80, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		passwordField = new JTextField();
		passwordField.setBounds(189, 106, 130, 26);
		frame.getContentPane().add(passwordField);
		
		
		JRadioButton newUserRButton = new JRadioButton("New User");
		newUserRButton.setBounds(239, 144, 141, 23);
		frame.getContentPane().add(newUserRButton);
		newUserRButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newU = true;
			}
		});
		
		JRadioButton returnUser = new JRadioButton("Returning User");
		returnUser.setBounds(107, 144, 141, 23);
		frame.getContentPane().add(returnUser);
		returnUser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newU = false;
			}
		});
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBounds(158, 194, 117, 29);
		frame.getContentPane().add(enterButton);
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print(newU);
				if(newU == true){
					User tempUser = new User(uName.getText(), passwordField.getText(), 0);
					Database.storeUser(tempUser);
				}
				
				currentUser = new User(Database.getUser(uName.getText(), passwordField.getText()));
				
				//retrieve the expense types for this user from the database
				ArrayList<Double> expenses = new ArrayList<Double>();
				for(int i = 0; i < Database.getExpenseTypesForUser(currentUser).size(); i+=3) {
					String name = (String) Database.getExpenseTypesForUser(currentUser).get(i);
					double goal = (Double) Database.getExpenseTypesForUser(currentUser).get(i+1);
					expenses.add((Double) Database.getExpenseTypesForUser(currentUser).get(i+2));
					
					currentUser.newNode(name, goal);
				}
				
				for(int i = 0; i < currentUser.getNodes().length; i++) {
					currentUser.newExpense(i, expenses.get(i));
				}
			
				if(currentUser.getUsername() != null) {
					for(int i = 0; i < currentUser.getNodes().length; i++) {
						System.out.print(currentUser.getNodes()[i] + " ");
						System.out.print("\n");
					}
					
					//leads to the mainFace class to start the squares Dashboard
					@SuppressWarnings("unused")
					mainFace dash = new mainFace(currentUser);
					frame.dispose();
				}
			}

		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(newUserRButton);
		group.add(enterButton);
		group.add(returnUser);
		
	}
}
