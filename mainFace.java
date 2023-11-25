package project380;
import java.awt.Font;

import javax.swing.*;

public class mainFace {
	private String[] colors = new String[6];
	private  ExpenseType[] temp = new ExpenseType[6];
	private User currentUser;
	
	mainFace(String[] color, ExpenseType[] tempEx, User currUser){
		this.colors = color;
		this.temp = tempEx;
		this.currentUser = currUser;
		main();
		
	}

	public void main() {
		int w = 800;
		int h = 700;
		JFrame frame = new JFrame();
		//adding the squareGUI object into the frame
		squareGUI squares = new squareGUI(colors, temp, currentUser);
		frame.setSize(w,h);
		frame.setTitle("Dashboard");
		//adding the squareGUI squares into the frame
		frame.add(squares);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
