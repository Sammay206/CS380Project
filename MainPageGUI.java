package project380;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

public class MainPageGUI {

	private User currentUser;
	private JFrame frame;
	private JLabel Expense1;
	private JLabel Expense2; 
	private JLabel Expense3; 
	private JLabel Expense4;
	private JLabel Expense5; 
	private JLabel Expense6; 

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

		//Adding squares (max 6) with their labels according to how many nodes are in array
		ExpenseType[] temp = new ExpenseType[currentUser.getNodes().length];
		for(int i=0; i < temp.length; i++) {
			temp[i].toString();
			switch(i) {
				case 0:
					//square 1
					squareGUI s1 = new squareGUI(temp[i].evaluateGoal(), 100, 100);
					frame.getContentPane().add(s1);
					Expense1 = new JLabel("Node 1");
					Expense1.setBounds(75, 95, 100, 16);
					Expense1.setText(currentUser.getNodes()[i].toString());
					frame.getContentPane().add(Expense1);
					
					break;
				case 1:
					//square 2 
					frame.getContentPane().add(new squareGUI(temp[i].evaluateGoal(), 310, 100));
					Expense2 = new JLabel("Node 2");
					Expense2.setBounds(75, 95, 100, 16);
					Expense2.setText(currentUser.getNodes()[i].toString());
					break;
				case 2:
					//square 3
					frame.getContentPane().add(new squareGUI(temp[i].evaluateGoal(), 510, 100));
					Expense3 = new JLabel("Node 3");
					Expense3.setBounds(75, 95, 100, 16);
					Expense3.setText(currentUser.getNodes()[i].toString());
					break;
				case 3:
					//square 4
					frame.getContentPane().add(new squareGUI(temp[i].evaluateGoal(), 100, 310));
					Expense4 = new JLabel("Node 4");
					Expense4.setBounds(75, 95, 100, 16);
					Expense4.setText(currentUser.getNodes()[i].toString());
					break;
				case 4:
					//square 5
					frame.getContentPane().add(new squareGUI(temp[i].evaluateGoal(), 310, 310));
					Expense5 = new JLabel("Node 5");
					Expense5.setBounds(75, 95, 100, 16);
					Expense5.setText(currentUser.getNodes()[i].toString());
					
					break;
				case 5:
					//square 6
					frame.getContentPane().add(new squareGUI(temp[i].evaluateGoal(), 510, 310));
					Expense6 = new JLabel("Node 6");
					Expense6.setBounds(75, 95, 100, 16);
					Expense6.setText(currentUser.getNodes()[i].toString());
					break;
			}
		}

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
}
