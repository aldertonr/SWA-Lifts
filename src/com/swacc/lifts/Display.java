package com.swacc.lifts;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Display extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String TITLE = "Lifts";

	private JPanel panel;
	private JLabel label;
	private JFrame frame;
	private int Keys;

	private File lift = new File("/res/lift.png"); 
	
	private int x = 0;
	private int y = 0;

	public Display() throws Exception {

		//try catching in case of a ArrayIndexOutOfBounds
		try {
			addKeyListener(new KeyListener() {

				public void keyTyped(KeyEvent e) {
				}

				public void keyPressed(KeyEvent e) {
					Keys = e.getKeyCode();
					System.out.println("KEY: " + Keys);

					//key a or <-
					if (Keys == 65 || Keys == 37) {
						x--;
						System.out.println("Moving Left, X: " + x);
						label.setLocation(x, y);
					}
					
					//Key d or ->
					if (Keys == 68 || Keys == 39) {
						x++;
						System.out.println("Moving Right, X: " + x);
						label.setLocation(x, y);
					}

					//Key s or down
					if (Keys == 38 || Keys == 87) {
						y--;
						label.setLocation(x, y);
					}
					
					//key w or ^
					if (Keys == 40 || Keys == 83) {
						y++;
						label.setLocation(x, y);
					}
					
				}

				public void keyReleased(KeyEvent e) {
					// Keys = e.getKeyCode();
					// System.out.println("KEY: " + Keys);
				}

			});
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.GRAY);

		URL url = new URL("http://www.tomhopkins.com/blog/wp-content/uploads/2013/07/350px-Elevator-official.jpg");
		
		ImageIcon lift = new ImageIcon(url);
		label = new JLabel(lift);

		panel.add(label);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(TITLE + " | By Ryan Alderton");
		getContentPane().add(panel);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);

		panel.setLayout(null);

		label.setLocation(x, y);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new Display();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}