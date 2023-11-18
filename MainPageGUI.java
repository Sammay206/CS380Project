package project380;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

public class MainPageGUI {

	private User currentUser;
	private JFrame frame;

	/**
	 * Create the application.
	 */
	public MainPageGUI(User currentUser) {
		this.currentUser = new User(currentUser);
				
				//print the expense types stored for the user with the given username
				for(int i = 0; i < currentUser.getNodes().length; i++) {
					System.out.print(currentUser.getNodes()[i] + " ");
					System.out.print("\n");
				}
		
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
		frame.setBounds(100, 100, 900, 600);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHello = new JLabel("Hello, ");
		lblHello.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHello.setBounds(10, 10, 340, 35);
		lblHello.setText("Hello, " + currentUser.getUsername());
		frame.getContentPane().add(lblHello);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}