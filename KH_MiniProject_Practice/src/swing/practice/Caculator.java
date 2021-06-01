package swing.practice;

import java.awt.EventQueue;

import javax.swing.JFrame;

/*
 * 계산기 만들어보기
 * 
 * 참고 : 윈도우에 있는 계산기
 * 
 * 두 숫자를 TextField와 같은 방법으로 입력을 받고
 * 계산 버튼을 클릭하여 더하기 빼기 곱하기 나누기 등의 계산을 해보기 
 * 
 * 계산기로써의 기본적인 기능만 하면 문제가 없음
 */

public class Caculator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Caculator window = new Caculator();
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
	public Caculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
