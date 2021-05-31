package swing.example.frame_transform;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SubExample {

	private JFrame frame;
	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubExample window = new SubExample();
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
	public SubExample() {
		initialize();
	}

	public SubExample(JFrame frame2) {
		this();
		this.mainFrame = frame2;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setTitle("SubFrame");
		
		frame.setBounds(100, 100, 450, 300);
		// frame에 키입력 리스너 붙일 때
		// 프레임에 버튼이나 텍스트필드 등  다른 객체들이 배치되어 있다면
		// 프레임에 키입력이 캐치되지 않을 수 있음
		// 이럴땐 프레임의 포커스를 넣어줘야함
		frame.setFocusable(true);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					System.out.println("프레임 전환 -> MainFrame");
					frame.setVisible(false);
					mainFrame.setVisible(true);
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("프레임 전환 예시");
//		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(36, 28, 132, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Space 키를 눌러 전환");
//		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(36, 64, 132, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("프레임 전환");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("프레임 전환 -> MainFrame");
				frame.setVisible(false);
				mainFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(149, 145, 132, 42);
		frame.getContentPane().add(btnNewButton);
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
