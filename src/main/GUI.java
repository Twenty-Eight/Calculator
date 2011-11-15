package main;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI {
	
	private JFrame f = new JFrame( "Calculator" );
	private JLabel number = new JLabel("Input: ");
	private JTextField input = new JTextField(); //Number Input
	private JButton plus = new JButton("+");
	private JButton subtract = new JButton("-");
	private JButton multiplicate = new JButton("x");
	private JButton divide = new JButton("/");
	private JButton handle = new JButton("=");
	private JButton open = new JButton("(");
	private JButton close = new JButton(")");
	private JLabel solution = new JLabel("Solution: ");		
	private GridBagLayout gbl = new GridBagLayout();
	private Container c = f.getContentPane();
	
	
	static void addComponent( Container cont, GridBagLayout gbl, Component comp, int x, int y, int width, int height){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x; gbc.gridy = y;
		gbc.gridwidth = width; gbc.gridheight = height;
		gbl.setConstraints( comp, gbc );
		cont.add( comp );
	}
	
	//Constructor
	public GUI() {
		f.setSize(250,150);
		c.setLayout(gbl);
		
		addComponent(c, gbl, number, 		1,2,1,1);
		addComponent(c, gbl, input, 		3,2,2,1);
		
		addComponent(c, gbl, plus,			1,3,1,1);
		addComponent(c, gbl, subtract,		2,3,1,1);
		addComponent(c, gbl, multiplicate,	3,3,1,1);
		addComponent(c, gbl, divide,		4,3,1,1);
	
		addComponent(c, gbl, open, 			1,4,2,1);
		addComponent(c, gbl, close, 		3,4,2,1);
		
		addComponent(c, gbl, handle,		1,5,4,1);
		
		addComponent(c, gbl, solution, 		1,6,4,1);
		
		f.setVisible(true);
	}
	
	public abstract class KeyAdapter implements KeyListener {
		public void KeyTyped( KeyEvent e ) {
			
		}
	}
}
