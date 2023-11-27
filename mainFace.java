package project380;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;

public class mainFace {
	protected static JFrame frame;
	private static String[] colors = new String[6];
	private static  ExpenseType[] temp = new ExpenseType[6];
	private static User currentUser;
	private JLabel lblHello;
	public static JLabel lblIncome;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnPlus;
	private squareGUI squares;
	
	mainFace(User currUser){
		mainFace.currentUser = currUser;
		main();
		
	}

	public void main() {
		int w = 800;
		int h = 700;
		frame = new JFrame();
		frame.setSize(w,h);
		frame.setTitle("Dashboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lblHello = new JLabel("Hello, " + currentUser.getUsername());
		lblHello.setFont(new Font("Helvetica", Font.PLAIN, 40));
		lblHello.setBounds(10, 10, 300, 60);
		frame.getContentPane().add(lblHello);
		
		//income label
		lblIncome = new JLabel();
		updateIncome();
		lblIncome.setFont(new Font("Helvetica", Font.PLAIN, 40));
		lblIncome.setBounds(650, 10, 300, 60);
		frame.getContentPane().add(lblIncome);
		
		JLabel incomeLabel = new JLabel("Income: ");
		incomeLabel.setFont(new Font("Helvetica", Font.PLAIN, 40));
		incomeLabel.setBounds(500, 10, 300, 60);
		frame.getContentPane().add(incomeLabel);
		
		//display nodes
		updateNodes();
		
		//Save button
		btnSave = new JButton("Save");
		btnSave.setBounds(10, 70, 85, 23);
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.removeUser(currentUser);
				Database.storeUser(currentUser);
				for (int i = 0; i < currentUser.getNodes().length; i++) {
					Database.storeExpenseType(currentUser.getNodes()[i], currentUser.getUsername());
				}
			}
		});
		frame.getContentPane().add(btnSave);
		
		btnPlus = new JButton("+");
		btnPlus.setBounds(720, 600, 50, 50);
		btnPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addGUI add = new addGUI(currentUser);
				
			}
		});
		frame.getContentPane().add(btnPlus);
	}
	
	public static void updateNodes() {
		colors = new String[currentUser.getNodes().length];
		temp = new ExpenseType[currentUser.getNodes().length];
		if(currentUser.getNodes().length > 6) {
			for(int i=0; i < 6; i++) {
				colors[i] = currentUser.getNodes()[i].evaluateGoal();
				temp[i] = currentUser.getNodes()[i];
			}
			
		} else {

			for(int i =0; i < currentUser.getNodes().length; i++) {
				colors[i] = currentUser.getNodes()[i].evaluateGoal();
				temp[i] = currentUser.getNodes()[i];
			}
		}
		squareGUI squares = new squareGUI(colors, temp, currentUser);
		squares.setBounds(-20, 0, 800, 700);
		frame.getContentPane().add(squares);
	}
	
	public static void updateIncome() {
		double income = Database.getUser(currentUser.getUsername(), currentUser.getPassword()).getIncome();
		double expenses = currentUser.calculateTotalExpenses();
		double netIncome = roundTwoDecimals(income - expenses);
		lblIncome.setText(netIncome+"");
	}
	
	public static double roundTwoDecimals(double d) {
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}
}
