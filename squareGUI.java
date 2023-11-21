package project380;
import javax.swing.JComponent;

import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class squareGUI extends JComponent{
	
	String color; 
	String [] colors = new String[6];
	ExpenseType[] expenseString; 
	
	
	squareGUI(String[] arrColor, ExpenseType[] temp){
		colors = arrColor;
		expenseString = temp;
	}
	
	public void colorSwitch(Graphics g, String newColor) {
		switch(newColor) {
		case "red":
			g.setColor(Color.red);
			break; 
		case "green":
			g.setColor(Color.green);
			break; 
		case "yellow":
			g.setColor(Color.yellow);
			break;
	}
	}
	
	public void paint(Graphics g) {
		
	Graphics2D g2 = (Graphics2D) g;	
	
	for(int i =0; i < colors.length; i++) {
		//should draw the square with hard coded positions with labels of ExpenseType 
		switch(i) {
		case 0: 
			//Square 1 
			g2.drawString(expenseString[i].toString(), 115, 150);
			colorSwitch(g2,colors[i]);
			g2.fillRect(100, 100, 200, 200);
			break; 
		case 1:
			//Square 2
			g2.drawString(expenseString[i].toString(), 325, 150);
			colorSwitch(g2, colors[i]);
			g2.fillRect(310, 100, 200, 200);
			break;
		case 2:
			//Square 3
			g2.drawString(expenseString[i].toString(), 525, 150);
			colorSwitch(g2, colors[i]);
			g2.fillRect(510, 100, 200, 200);
			break;
		case 3:
			//Square 4
			g2.drawString(expenseString[i].toString(), 115, 410);
			colorSwitch(g2, colors[i]);
			g2.fillRect(100, 310, 200, 200);
			break;
		case 4:
			//Square 5
			g2.drawString(expenseString[i].toString(), 325, 410);
			colorSwitch(g2, colors[i]);
			g2.fillRect(310, 310, 200, 200);
			break;
		case 5:
			//Square 6
			g2.drawString(expenseString[i].toString(), 525, 410);
			colorSwitch(g2, colors[i]);
			g2.fillRect(510, 310, 200, 200);
			break;
		}
	}
	} 

}
