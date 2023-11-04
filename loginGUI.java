package project380;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class loginGUI {

	private JFrame frame;
	private JTextField uName;
	private JTextField password;
	private JPasswordField passwordField;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Budget App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 60);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		
		JLabel title = DefaultComponentFactory.getInstance().createTitle("Welcome!");
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
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 106, 130, 26);
		frame.getContentPane().add(passwordField);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New User");
		rdbtnNewRadioButton.setBounds(239, 144, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Returning User");
		rdbtnNewRadioButton_1.setBounds(107, 144, 141, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
	}
}
