package project380;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class addExpenseGUI {

	private JFrame frame;
	private User currentUser;

	public addExpenseGUI(User currentUser) {
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
		
		JLabel greetingLabel = new JLabel("Add your expense:");
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		greetingLabel.setBounds(100, 20, 200, 20);
		frame.getContentPane().add(greetingLabel);
		
		JLabel lblExpense = new JLabel("Expense");
		lblExpense.setBounds(130, 150, 60, 20);
		frame.getContentPane().add(lblExpense);
		
		final JTextField textFieldExpense = new JTextField();
		textFieldExpense.setBounds(225, 150, 80, 20);
		frame.getContentPane().add(textFieldExpense);
		
		JLabel lblNodes = new JLabel("Expense Type");
		lblNodes.setBounds(130, 110, 100, 20);
		frame.getContentPane().add(lblNodes);
		
		String[] names = new String[currentUser.getNodes().length];
		for(int i = 0; i < currentUser.getNodes().length; i++) {
			names[i] = currentUser.getNodes()[i].getName();
		}
		final JComboBox cbExpenseTypes = new JComboBox(names);
		cbExpenseTypes.setBounds(225, 110, 80, 20);
		frame.getContentPane().add(cbExpenseTypes);
		
		JButton btnEnter = new JButton("Confirm");
		btnEnter.setBounds(185, 200, 80, 20);
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				currentUser.getNodes()[cbExpenseTypes.getSelectedIndex()].newExpense(Double.valueOf(textFieldExpense.getText()));
				
				mainFace.frame.dispose();
				mainFace m = new mainFace(currentUser);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnEnter);
	}

}
