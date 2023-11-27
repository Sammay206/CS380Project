package project380;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class addExpenseType {

	private JFrame frame;
	
	private User currentUser;

	public addExpenseType(User currentUser) {
		this.currentUser = currentUser;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JLabel greetingLabel = new JLabel("Add your expense type:");
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greetingLabel.setBounds(100, 10, 225, 20);
		frame.getContentPane().add(greetingLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(130, 110, 60, 20);
		frame.getContentPane().add(lblName);
		
		final JTextField textFieldName = new JTextField();
		textFieldName.setBounds(225, 110, 80, 20);
		frame.getContentPane().add(textFieldName);
		
		JLabel lblGoal = new JLabel("Goal");
		lblGoal.setBounds(130, 150, 60, 20);
		frame.getContentPane().add(lblGoal);
		
		final JTextField textFieldGoal = new JTextField();
		textFieldGoal.setBounds(225, 150, 80, 20);
		frame.getContentPane().add(textFieldGoal);
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.setBounds(185, 200, 80, 20);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				currentUser.newNode(textFieldName.getText(), Double.valueOf(textFieldGoal.getText()));
				
				Database.removeUser(currentUser);
				Database.storeUser(currentUser);
				for (int i = 0; i < currentUser.getNodes().length; i++) {
					Database.storeExpenseType(currentUser.getNodes()[i], currentUser.getUsername());
				}
				
				mainFace.frame.dispose();
				mainFace m = new mainFace(currentUser);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEnter);
	}

}
