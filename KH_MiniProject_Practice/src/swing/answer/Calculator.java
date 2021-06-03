package swing.answer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator {

	private JFrame frame;
	private JTextField operand1TextField;
	private JTextField operand2TextField;
	private JComboBox operatorComboBox;
	private JButton clearButton;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		operand1TextField = new JTextField();
		operand1TextField.setToolTipText("입력값1");
		operand1TextField.setBounds(12, 47, 97, 21);
		frame.getContentPane().add(operand1TextField);
		operand1TextField.setColumns(10);
		
		operand2TextField = new JTextField();
		operand2TextField.setToolTipText("입력값2");
		operand2TextField.setBounds(228, 47, 97, 21);
		frame.getContentPane().add(operand2TextField);
		operand2TextField.setColumns(10);
		
		JButton calcButton = new JButton("계산");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opStr = (String) operatorComboBox.getSelectedItem();
				char op = opStr.charAt(0);
				
				double x = Double.parseDouble(operand1TextField.getText());
				double y = Double.parseDouble(operand2TextField.getText());
				double result = 0;
				
				switch (op) {
				case '+':
					result = x + y;
					break;
				case '-':
					result = x - y;
					break;
				case '*':
					result = x * y;
					break;
				case '/':
					result = x / y;
					break;
				case '%':
					result = x % y;
					break;

				default:
					break;
				}
				
				textArea.append(String.format("%.2f %c %.2f = %.2f\n", x, op, y, result));
			}
		});
		calcButton.setBounds(384, 46, 97, 23);
		frame.getContentPane().add(calcButton);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 89, 361, 237);
		frame.getContentPane().add(textArea);
		
		clearButton = new JButton("초기화");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		clearButton.setBounds(384, 89, 97, 23);
		frame.getContentPane().add(clearButton);
		
		operatorComboBox = new JComboBox();
		operatorComboBox.setFont(new Font("굴림", Font.BOLD, 13));
		operatorComboBox.setModel(new DefaultComboBoxModel(new String[] {"+ (더하기)", "- (빼기)", "* (곱하기)", "/ (나누기)", "% (나머지)"}));
		operatorComboBox.setBounds(121, 45, 95, 21);
		frame.getContentPane().add(operatorComboBox);
	}
}
