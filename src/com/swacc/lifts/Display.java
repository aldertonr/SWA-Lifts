package com.swacc.lifts;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final String TITLE = "Lifts";

	private JPanel panel;
	private JLabel label;
	private int Keys;

	private int x = 0;
	private int y = 0;

	public static boolean running = true;

	public Display() throws Exception {

		// try catching in case of a ArrayIndexOutOfBounds
		try {
			addKeyListener(new KeyListener() {

				public void keyTyped(KeyEvent e) {
				}

				public void keyPressed(KeyEvent e) {
					Keys = e.getKeyCode();
					System.out.println("KEY: " + Keys);

					// key a or <-
					if (Keys == 65 || Keys == 37) {
						if (x == 0) {
							System.out.println("Full Left");
						} else {
							x--;
							System.out.println("Moving Left, X: " + x);
							label.setLocation(x, y);
						}
					}

					// Key d or ->
					if (Keys == 68 || Keys == 39) {
						if (x == 448) {
							System.out.println("Full Right");
						} else {
							x++;
							System.out.println("Moving Right, X: " + x);
							label.setLocation(x, y);

						}
					}
					// Key s or down
					if (Keys == 83 || Keys == 40) {
						if (y == 308) {
							System.out.println("Full Down");
						} else {
							y++;
							System.out.println("Moving Down,Y: " + y);
							label.setLocation(x, y);

						}
					}

					// key w or ^
					if (Keys == 38 || Keys == 87) {
						// Stopping the image from leaving the
						if (y == 0) {
							System.out.println("Full Up");
						} else {
							y--;
							System.out.println("Moving Up, Y: " + y);
							label.setLocation(x, y);

						}

					}
				}

				public void keyReleased(KeyEvent e) {
				}

			});
			// Catching an AIOFB exception and calling it e
		} catch (ArrayIndexOutOfBoundsException e) {
			// printing the stack trace of e
			e.printStackTrace();
		}

		panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel.setBackground(Color.GRAY);
		// TODO: Make this a file, not sure how yet though
		URL url = new URL(
				"http://www.tomhopkins.com/blog/wp-content/uploads/2013/07/350px-Elevator-official.jpg");

		ImageIcon lift = new ImageIcon(url);
		label = new JLabel(lift);

		panel.add(label);
		// Frame information
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(TITLE + " | By Ryan Alderton");
		getContentPane().add(panel);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		// making the lift moveable and whatnot
		panel.setLayout(null);
		label.setLocation(x, y);

	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				running = true;
				try {
					new Display();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		/*
		 * while (System.currentTimeMillis() > 3000) {
		 * System.out.println("ABOVE 3K"); }
		 */

	}
}
