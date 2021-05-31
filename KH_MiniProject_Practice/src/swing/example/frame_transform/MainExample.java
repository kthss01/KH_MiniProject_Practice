package swing.example.frame_transform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainExample {

	private JFrame frame;
	
	private SubExample ex2;
	private JFrame subFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainExample window = new MainExample();
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
	public MainExample() {
		initialize();
		
		ex2 = new SubExample(frame);
		
		frame.setTitle("MainFrame");
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("프레임 전환 예시");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 28, 132, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Space 키를 눌러 전환");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 64, 132, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("프레임 전환");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("프레임 전환 -> SubFrame");
				frame.setVisible(false);
				subFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(149, 145, 132, 42);
		frame.getContentPane().add(btnNewButton);
		
		subFrame = ex2.getFrame();
		subFrame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setFocusable(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("프레임 전환 -> SubFrame");
					frame.setVisible(false);
					subFrame.setVisible(true);
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
