import java.awt.GridLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Wycinka {

	public static void main(String [] args) {
		
SwingUtilities.invokeLater(new Runnable() {         
	public void run() {   
		JTextArea textArea = new JTextArea (500,100);
		JFrame window = new JFrame("Wycinka");
		Animation animacja = new Animation();
		window.add(animacja);
		window.add(textArea);
		window.pack(); //responsywnoœæ
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);;
		window.setLayout(new GridLayout());
		

        JTextAreaOutputStream out = new JTextAreaOutputStream (textArea);
        System.setOut (new PrintStream (out));
		
		Timer t = new Timer(100,animacja);
		t.start();
		}        
	});
		new Ciezarowka().start();
		new AgentUnii().start();
		for(int i = 0; i<20;i++) {
			new Robotnik("Robotnik "+i,3).start();
			}
	
		}
	}


