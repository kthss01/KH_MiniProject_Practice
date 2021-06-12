package test.swing_imgpanel;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollPane;

public class SwingImagePanelExample {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingImagePanelExample window = new SwingImagePanelExample();
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
	public SwingImagePanelExample() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String imagePath = "./image/crew_main_button.png";
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 51, 206, 126);
		frame.getContentPane().add(panel);
		
		panel.add(new ImagePanel(imagePath, panel.getSize()));
		panel.setLayout(null);
		
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(60, 65, 321, 173);
//		frame.getContentPane().add(scrollPane);
//		scrollPane.setViewportView(new JPanel() {
//			public void paintComponent(Graphics g) {
//				g.drawImage(new ImageIcon(imagePath).getImage(), 0, 0, null);
//				
//				setOpaque(false);
//				super.paintComponent(g);
//			}
//		});
		
		
	}
	
	class ImagePanel extends JPanel {
		
		String imagePath = "";
		Dimension dimension;
		
		public ImagePanel(String imagePath, Dimension dimension) {
			this.imagePath = imagePath;
			this.dimension = dimension;
			
			setLayout(null);
			setSize(dimension);
			
			System.out.println(dimension.width + " " + dimension.height);
		}
		
		
		public void paintComponent(Graphics g) {
			ImageIcon image = new ImageIcon(imagePath);
			g.drawImage(image.getImage(), 0, 0, dimension.width, dimension.height, null);

		}
	}
}
