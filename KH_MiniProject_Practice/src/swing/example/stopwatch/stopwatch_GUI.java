package swing.example.stopwatch;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class stopwatch_GUI {
	
	JFrame frame;
	// JTextField tf1 = new JTextField("00",2);
	// JTextField tf2 = new JTextField("00",2);
	// JTextField tf3 = new JTextField("00",2);
	// JTextField tf4 = new JTextField("00",2);
	JLabel lbl1 = new JLabel("00", 2);
	JLabel lbl2 = new JLabel("00", 2);
	JLabel lbl3 = new JLabel("00", 2);
	JLabel lbl4 = new JLabel("00", 2);
	// swing 변수들
	JButton b1, b2, b3, b4;
	JLabel lb1 = new JLabel(":");
	JLabel lb2 = new JLabel(":");
	JLabel lb3 = new JLabel(":");
	Choice menu_year, menu_mon, menu_day;
	Color c1 = new Color(165, 165, 165); // 회색
	Color c2 = new Color(237, 210, 0); // 골드

	public stopwatch_GUI() {
		frame = new JFrame();
		frame.setLocation(600, 400);
		frame.setSize(100, 100);
		Container contentPane = frame.getContentPane();
		GridLayout layout1 = new GridLayout(2, 1);
		contentPane.setLayout(layout1);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.add(lbl4);
		lbl4.setForeground(c2);
		lbl4.setFont(new Font("Agency FB", Font.BOLD, 30));
		p1.add(lb1);
		lb1.setForeground(c2);
		p1.add(lbl3);
		lbl3.setForeground(c2);
		lbl3.setFont(new Font("Agency FB", Font.BOLD, 30));
		p1.add(lb2);
		lb2.setForeground(c2);
		p1.add(lbl2);
		lbl2.setForeground(c2);
		lbl2.setFont(new Font("Agency FB", Font.BOLD, 30));
		p1.add(lb3);
		lb3.setForeground(c2);
		p1.add(lbl1);
		lbl1.setForeground(c2);
		lbl1.setFont(new Font("Agency FB", Font.BOLD, 30));
		p1.setBackground(c1);
		b1 = new JButton("start");
		b1.setBackground(c2);
		b1.setFont(new Font("Orbit-B BT", Font.BOLD, 20));
		b2 = new JButton("stop");
		b2.setBackground(c2);
		b2.setFont(new Font("Orbit-B BT", Font.BOLD, 20));
		b3 = new JButton("reset");
		b3.setBackground(c2);
		b3.setFont(new Font("Orbit-B BT", Font.BOLD, 20));
		b4 = new JButton("quit");
		b4.setBackground(c2);
		b4.setFont(new Font("Orbit-B BT", Font.BOLD, 20));
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.setBackground(c1);
		contentPane.add(p1);
		contentPane.add(p2);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}



