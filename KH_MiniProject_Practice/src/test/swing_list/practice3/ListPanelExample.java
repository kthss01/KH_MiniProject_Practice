package test.swing_list.practice3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

public class ListPanelExample {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPanelExample window = new ListPanelExample();
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
	public ListPanelExample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 442);
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

	private class MyRendererCell extends JPanel implements ListCellRenderer {

		private JPanel panel;
		private JLabel label;
		
		public MyRendererCell() {
//			setOpaque(true);
			
//			setLayout(new BorderLayout());
			
			
			panel = new JPanel();
			label = new JLabel();
			
			panel.setLayout(new BorderLayout());
			panel.setBackground(Color.blue);
			
			panel.add(label, BorderLayout.CENTER);
			
			System.out.println(getLayout().toString());
			
			this.add(panel);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {

//			JPanel panel = new JPanel();
//			panel.setBounds(0,0, 300, 300);
			
			
//			JLabel lbl = new JLabel((String)value);
			
//			panel.add(lbl, BorderLayout.CENTER);
			
//			this.add(panel);
			
			label.setText((String)value);
			
			return this;
		}
		
	}
}
