package test.swing_list.practice2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListBasicExample {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListBasicExample window = new ListBasicExample();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListBasicExample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultListModel model = new DefaultListModel();
		MyRendererCell renderer = new MyRendererCell();
		
		JList list = new JList();
		
		list.setCellRenderer(renderer);
		list.setModel(model);
		
		model.addElement("hello");
		model.addElement("world");
		model.addElement("list");
		model.addElement("rendererCell");
		
		frame.getContentPane().add(list, BorderLayout.CENTER);
	}
	
	private class MyRendererCell extends JLabel implements ListCellRenderer {

		public MyRendererCell() {
//			setOpaque(true);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			setText((String)value);
//			setBackground(Color.green);
//			setForeground(Color.white);
			setForeground(Color.cyan);
			
			return this;
		}
		
	}

}
