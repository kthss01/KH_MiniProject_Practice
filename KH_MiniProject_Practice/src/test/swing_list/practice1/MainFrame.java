package test.swing_list.practice1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.JScrollPane;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 817);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DefaultListModel model = new DefaultListModel<ArrayList<String>>();

		ArrayList<String> arr = new ArrayList<String>();

		arr.add("admin");
		arr.add("2021.06.10");
		arr.add("오늘도 런데이!");
		arr.add("10");
		arr.add("20");
		model.addElement(arr);
		
		arr = new ArrayList<String>();
		arr.add("admin1");
		arr.add("2021.06.10");
		arr.add("오늘도 런데이!");
		arr.add("10");
		arr.add("20");
		model.addElement(arr);

		arr = new ArrayList<String>();
		arr.add("admin2");
		arr.add("2021.06.10");
		arr.add("오늘도 런데이!");
		arr.add("10");
		arr.add("20");
		model.addElement(arr);
		
		arr = new ArrayList<String>();
		arr.add("admin3");
		arr.add("2021.06.10");
		arr.add("오늘도 런데이!");
		arr.add("10");
		arr.add("20");
		model.addElement(arr);
		
		frame.getContentPane().setLayout(null);
		
		MyRenderer renderer = new MyRenderer();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 512, 768);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setCellRenderer(renderer);
		list.setModel(model);
	}

	

	
	private class MyRenderer implements ListCellRenderer {

		private ListItemPanel panel;
		
		public MyRenderer() {
			panel = new ListItemPanel();
//			setBackground(Color.CYAN);
////			setBounds(0,0, 500, 300);
////			setLayout(new BorderLayout());
//			
//			panel.setBackground(Color.red);
//			panel.setPreferredSize(new Dimension(500, 300));
//			
//			this.add(panel);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			
//			panel.setItem((ArrayList<String>) value);
//			
//			return this;
			
			panel = new ListItemPanel((ArrayList<String>) value);
			panel.setPreferredSize(new Dimension(500, 300));
					
			return panel;
		}
		
	}
}
