package project380;
import javax.swing.JFrame; 
import java.awt.color.*;
import java.awt.Color;
import java.awt.Graphics;

public class squareGUI extends JFrame{
	
	String squareColor; 
	int xPos = 0;
	int yPos =0;
	squareGUI(String color, int x, int y){
		squareColor = color;
		xPos = x;
		yPos = y;
		setSize(1000,1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		
	switch(squareColor) {
		case "red": g.setColor(Color.red);
			          break; 
		case "green": g.setColor(Color.green);
		          	break; 
		case "yellow": g.setColor(Color.yellow);
			          break;
	}
		g.fillRect(xPos,yPos,200,200);
	} 

}
