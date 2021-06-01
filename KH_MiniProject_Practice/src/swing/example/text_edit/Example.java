package swing.example.text_edit;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Example extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel textLabel;
	private JTextArea logTextArea;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example frame = new Example();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Example() {
		setTitle("텍스트 변경 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton textInputBtn = new JButton("입력");
		textInputBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				textLabel.setText(str);
				logTextArea.append("textField : " + str + "\n");
			}
		});
		textInputBtn.setBounds(166, 28, 72, 23);
		contentPane.add(textInputBtn);

		textField = new JTextField();
		textField.setBounds(28, 28, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		logTextArea = new JTextArea();
		logTextArea.setBounds(260, 10, 162, 241);
		contentPane.add(logTextArea);

		textLabel = new JLabel("텍스트");
		textLabel.setBounds(28, 126, 116, 39);
		contentPane.add(textLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(28, 74, 116, 21);
		contentPane.add(passwordField);

		JButton pwdTextInputBtn = new JButton("입력");
		pwdTextInputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char[] ch = passwordField.getPassword();
				textLabel.setText(String.valueOf(ch));
				logTextArea.append("PasswordField : " + String.valueOf(ch) + "\n");
			}
		});
		pwdTextInputBtn.setBounds(166, 74, 72, 23);
		contentPane.add(pwdTextInputBtn);
		
		btnNewButton = new JButton("초기화");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logTextArea.setText("");
			}
		});
		btnNewButton.setBounds(166, 213, 72, 23);
		contentPane.add(btnNewButton);
	}
}
