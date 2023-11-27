package project380;
import javax.swing.JComponent;

import java.awt.color.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class squareGUI extends JComponent{
	
	String color; 
	String [] colors = new String[6];
	ExpenseType[] expenseString; 
	User currentU;
	Graphics2D g2;
	
	
	squareGUI( String[] arrColor, ExpenseType[] temp, User currU){
		colors = arrColor;
		expenseString = temp;
		this.currentU = currU;
	}
	/**
	 * colorSwitch() is the method that chooses the color for the square
	 * according to the color in the colors array
	 */
	public void colorSwitch(Graphics g, String newColor) {
		switch(newColor) {
		case "Red":
			g.setColor(new Color(240,72,50));
			break; 
		case "Green":
			g.setColor(new Color(158, 235, 63));
			break; 
		case "Yellow":
			g.setColor(new Color(247, 211, 2));
			break;
	}
	}
	
	protected void paintComponent(Graphics g) {
		
	Graphics2D g2 = (Graphics2D) g;	
	
	for(int i =0; i < colors.length; i++) {
		//should draw the square with hard coded positions with labels of ExpesneType 
		
		if(colors[i] == null) {
			break;
		}
		
		switch(i) {
		case 0: 
			//Square 1 
			colorSwitch(g2,colors[i]);
			g2.fillRect(100, 100, 200, 200);
			g2.setColor(Color.black);
			g2.setFont(new Font("Tahoma", Font.PLAIN, 35));
			g2.drawString(expenseString[i].getName(), 115, 150);
			
			g2.setFont(new Font("Tahoma", Font.ITALIC, 20));
			g2.drawString("Goal: " +expenseString[i].getGoal(), 115, 230);
			g2.drawString("Expense: "+ expenseString[i].getExpenses(),115, 250);
			break; 
		case 1:
			//Square 2
			colorSwitch(g2, colors[i]);
			g2.fillRect(310, 100, 200, 200);
			g2.setColor(Color.black);
			g2.setFont(new Font("Tahoma", Font.PLAIN, 35));
			g2.drawString(expenseString[i].getName(), 325, 150);
			
			g2.setFont(new Font("Tahoma", Font.ITALIC, 20));
			g2.drawString("Goal: " +expenseString[i].getGoal(), 325, 230);
			g2.drawString("Expense: "+ expenseString[i].getExpenses(),325, 250);
			break;
		case 2:
			//Square 3
			colorSwitch(g2, colors[i]);
			g2.fillRect(520, 100, 200, 200);
			g2.setColor(Color.black);
			g2.setFont(new Font("Tahoma", Font.PLAIN, 35));
			g2.drawString(expenseString[i].getName(), 535, 150);
			
			g2.setFont(new Font("Tahoma", Font.ITALIC, 20));
			g2.drawString("Goal: " +expenseString[i].getGoal(), 535, 230);
			g2.drawString("Expense: "+ expenseString[i].getExpenses(),535, 250);
			break;
		case 3:
			//Square 4
			colorSwitch(g2, colors[i]);
			g2.fillRect(100, 310, 200, 200);
			g2.setColor(Color.black);
			g2.setFont(new Font("Tahoma", Font.PLAIN, 35));
			g2.drawString(expenseString[i].getName(), 115, 360);
			
			g2.setFont(new Font("Tahoma", Font.ITALIC, 20));
			g2.drawString("Goal: " +expenseString[i].getGoal(), 115, 440);
			g2.drawString("Expense: "+ expenseString[i].getExpenses(),115, 460);
			break;
		case 4:
			//Square 5
			colorSwitch(g2, colors[i]);
			g2.fillRect(310, 310, 200, 200);
			g2.setColor(Color.black);
			g2.setFont(new Font("Tahoma", Font.PLAIN, 35));
			g2.drawString(expenseString[i].getName(), 325, 360);
			
			g2.setFont(new Font("Tahoma", Font.ITALIC, 20));
			g2.drawString("Goal: " +expenseString[i].getGoal(), 325, 440);
			g2.drawString("Expense: "+ expenseString[i].getExpenses(),325, 460);
			break;
		case 5:
			//Square 6
			colorSwitch(g2, colors[i]);
			g2.fillRect(520, 310, 200, 200);
			g2.setColor(Color.black);
			g2.setFont(new Font("Tahoma", Font.PLAIN, 35));
			g2.drawString(expenseString[i].getName(), 535, 360);
			
			g2.setFont(new Font("Tahoma", Font.ITALIC, 20));
			g2.drawString("Goal: " +expenseString[i].getGoal(), 535, 440);
			g2.drawString("Expense: "+ expenseString[i].getExpenses(),535, 460);
			break;
		}
	}} 

}
