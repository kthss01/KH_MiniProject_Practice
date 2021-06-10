package test.swing_list.practice1;

import javax.swing.JPanel;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;

public class ListItemPanel extends JPanel {

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextArea textArea;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public ListItemPanel() {
		setBounds(0,0, 348, 341);
		setBackground(Color.ORANGE);
		setLayout(null);
		
		lblNewLabel = new JLabel("userId");
		lblNewLabel.setBounds(39, 10, 142, 50);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("date");
		lblNewLabel_1.setBounds(34, 70, 280, 35);
		add(lblNewLabel_1);
		
		textArea = new JTextArea();
		textArea.setText("오늘도 런데이!");
		textArea.setBounds(34, 115, 280, 103);
		add(textArea);
		
		lblNewLabel_2 = new JLabel("like Count");
		lblNewLabel_2.setBounds(39, 256, 81, 15);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("feed Count");
		lblNewLabel_3.setBounds(193, 256, 109, 15);
		add(lblNewLabel_3);

	}
	
	public void setItem(ArrayList<String> value) {
		lblNewLabel.setText(lblNewLabel.getText() + " : " + value.get(0));
		lblNewLabel_1.setText(lblNewLabel_1.getText() + " : " + value.get(1));
		textArea.setText(textArea.getText() + " : " + value.get(2));
		lblNewLabel_2.setText(lblNewLabel_2.getText() + " : " + value.get(3));
		lblNewLabel_3.setText(lblNewLabel_3.getText() + " : " + value.get(4));
	}

	public ListItemPanel(ArrayList<String> value) {
		this();
		lblNewLabel.setText(lblNewLabel.getText() + " : " + value.get(0));
		lblNewLabel_1.setText(lblNewLabel_1.getText() + " : " + value.get(1));
		textArea.setText(textArea.getText() + " : " + value.get(2));
		lblNewLabel_2.setText(lblNewLabel_2.getText() + " : " + value.get(3));
		lblNewLabel_3.setText(lblNewLabel_3.getText() + " : " + value.get(4));
	}

}
