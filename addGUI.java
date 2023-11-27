package project380;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class addGUI {

	private JFrame frame;
	private User currentUser;


	public addGUI(User currentUser) {
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
		
		//Label to ask user what they want to add
		JLabel greetingLabel = new JLabel("What would you like to add?");
		greetingLabel.setBounds(85, 10, 251, 25);
		greetingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greetingLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(greetingLabel);
		
		//A button that pops up a window to add income.
		JButton incomeButton = new JButton("Income");
		incomeButton.setBounds(150, 90, 120, 25);
		frame.getContentPane().add(incomeButton);
		incomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addIncomeGUI addIncome = new addIncomeGUI(currentUser);
				frame.dispose();
			}
		});
		
		//A button that pops up a window to add an expense.
		JButton expenseButton = new JButton("Expense");
		expenseButton.setBounds(150, 122, 120, 25);
		frame.getContentPane().add(expenseButton);
		expenseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addExpenseGUI addExpense = new addExpenseGUI(currentUser);
				frame.dispose();
			}
		});
		
		//A button that pops up a window to add an expense type.
		JButton expenseTypeButton = new JButton("Expense Type");
		expenseTypeButton.setBounds(150, 158, 120, 25);
		frame.getContentPane().add(expenseTypeButton);
		expenseTypeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addExpenseType addET = new addExpenseType(currentUser);
				frame.dispose();

			}
		});
	}
}
