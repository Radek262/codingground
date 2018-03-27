
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Animation extends JComponent implements ActionListener {
	private int x;
	private int y;


	
	/*public Animation(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}*/
	private int speed = 15;
	
	public Dimension getPreferredSize() {
		return new Dimension (800,600);
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(0, 0, 50, 20);

		g.setColor(Color.green);
		g.fillRect(60, 0, 50, 20);

		g.setColor(Color.green);
		g.fillRect(120, 0, 100, 20);

		g.setColor(Color.green);
		g.fillRect(230, 0, 100, 20);

		g.setColor(Color.black);
		g.fillRect(0, 320, 330, 100);
		
		paintOval(g);
	}
	
	
	public void paintOval(Graphics g) {
		for(int i = 0; i<20;i++) {
			for(x=0;x<300;x++) {
				g.setColor(Color.red);
				g.fillOval(x,y,10,10);

				x+=15;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
	
		if(y < 0 || y > 300) {
			speed = -speed;
		}
		y = y + speed;
		repaint();
	}
	
} 