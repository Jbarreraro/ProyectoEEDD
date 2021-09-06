package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Splash extends JFrame {

	
	public Splash() throws InterruptedException {
		
		this.setTitle("Iniciando..."); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setResizable(false); 
		this.setSize(450, 450);
		this.getContentPane().setBackground(new Color(0xffffff));
		
		// Adds icon in the top left of the frame
		ImageIcon imageFrame = new ImageIcon("res/vetanimal.png");
		this.setIconImage(imageFrame.getImage());
		
		ImageIcon imageInit = new ImageIcon("res/vetanimaldata.jpeg");
		
		//Create JLabel
		JLabel label = new JLabel(); 
		label.setIcon(imageInit); 
		label.setForeground(new Color(0x92c5fc)); 
		label.setFont(new Font("MV Boli",Font.PLAIN,20));
		label.setIconTextGap(-10); 
		label.setBackground(new Color(0x15588c));
		label.setOpaque(true); 
		label.setVerticalAlignment(JLabel.CENTER); 
		label.setHorizontalAlignment(JLabel.CENTER);
		
		//Adds components to the JFrame
		this.add(label);
		
		// Put the Frame in the center of the screen a make this visible
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		Thread.sleep(3000);
		
		this.dispose();
		new MenuPrincipal();
	}
	
}
