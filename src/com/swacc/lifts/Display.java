package com.swacc.lifts;

import java.awt.Color;
import java.awt.FlowLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Display extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String TITLE = "Lifts";

    private JPanel panel;
    private JLabel label;
    private JFrame frame;
    
    public Display() throws Exception{
    
    	panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(Color.YELLOW);

        URL url = new URL("http://www.tomhopkins.com/blog/wp-content/uploads/2013/07/350px-Elevator-official.jpg");
        ImageIcon icon1 = new ImageIcon(url);

        label = new JLabel(icon1);
        
        panel.add(label);
        pack();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(panel);
        setSize(WIDTH, HEIGHT);
        setLocationByPlatform(true);
        setLocation(300,300);
        boolean flag = isLocationByPlatform();
        setVisible(true);
        //setLocationRelativeTo(null);
    
    }

    
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Display();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}