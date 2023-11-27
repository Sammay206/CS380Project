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

public class addIncomeGUI {

	private JFrame frame;
	private User currentUser;

	public addIncomeGUI(User currentUser) {
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
		
		JLabel greetingLabel = new JLabel("Add your income:");
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greetingLabel.setBounds(115, 10, 200, 20);
		frame.getContentPane().add(greetingLabel);
		
		JLabel lblNewIncome = new JLabel("New Income");
		lblNewIncome.setBounds(130, 110, 100, 20);
		frame.getContentPane().add(lblNewIncome);
		
		final JTextField txtFieldIncome = new JTextField();
		txtFieldIncome.setBounds(225, 110, 80, 20);
		frame.getContentPane().add(txtFieldIncome);
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.setBounds(185, 200, 80, 20);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double addition = Double.valueOf(txtFieldIncome.getText());
				currentUser.newIncome(addition);
				Database.removeUser(currentUser);
				Database.storeUser(currentUser);
				for (int i = 0; i < currentUser.getNodes().length; i++) {
					Database.storeExpenseType(currentUser.getNodes()[i], currentUser.getUsername());
				}
				mainFace.updateIncome();
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEnter);
	}

}
