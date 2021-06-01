package corelogic.answer;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 타이머에 추가로
 * 일시정지까지 구현해보기
 */

public class Practice2Plus {

	private JFrame frame;
	private JTextField hourTextField;
	private JTextField minTextField;
	private JTextField secTextField;
	private JLabel timeLabel;

	private Timer timer;
	private TimerTask task;

	private static int timerCount = 0;
	private static int status = -1; // 상태 변경을 저장하기 위한 변수
	// 0 일시정지, 1 시작 , -1 종료

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Practice2Plus window = new Practice2Plus();
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
	public Practice2Plus() {
		initialize();

		timer = new Timer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 724, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton startButton = new JButton("시작");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isStart = false;
				// 상태 변경
				if (status == 0) {
					status = 1;
					startButton.setText("일시정지");
				} else if (status == 1) {
					status = 0;
					startButton.setText("시작");
				} else {
					status = 1;
					startButton.setText("일시정지");
					isStart = true;
				}

				int hour = Integer.valueOf(hourTextField.getText());
				int min = Integer.valueOf(minTextField.getText());
				int sec = Integer.valueOf(secTextField.getText());

				int secs = hour * 3600 + min * 60 + sec;
//				System.out.println(secs);

				task = new TimerTask() {

					@Override
					public void run() {
						int result = secs - timerCount;
						if (result == 0)
							status = -1;

						// 상태에 따라 진행
						switch (status) {
						case -1: // 종료
							secToHHMMSS(result);
							System.out.println("타이머 종료");
							timer.cancel(); // 종료
							break;
						case 0: // 일시정지
							System.out.println("타이머 일시정지 중");
							break;
						case 1: // 시작
							System.out.println("타이머 진행 중");
							timerCount++;
							secToHHMMSS(result);
							break;
						default:
							break;
						}
					}

					private void secToHHMMSS(int secs) {
						int sec = secs % 60; // 초
						int min = secs / 60 % 60; // 분
						int hour = secs / 3600; // 시

						timeLabel.setText(String.format("%02d:%02d:%02d", hour, min, sec));
					}
				};

				if (isStart) {
					timer = new Timer(); // 재사용하려면 timer도 다시만들면 된다고함
					timer.scheduleAtFixedRate(task, 0, 1000);
				}
			}
		});
		startButton.setBounds(308, 281, 97, 23);
		frame.getContentPane().add(startButton);

		JButton cancelButton = new JButton("종료");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				status = -1; // 상태 변경
			}
		});
		cancelButton.setBounds(308, 336, 97, 23);
		frame.getContentPane().add(cancelButton);

		hourTextField = new JTextField();
		hourTextField.setText("0");
		hourTextField.setBounds(154, 107, 116, 21);
		frame.getContentPane().add(hourTextField);
		hourTextField.setColumns(10);

		minTextField = new JTextField();
		minTextField.setText("0");
		minTextField.setBounds(289, 107, 116, 21);
		frame.getContentPane().add(minTextField);
		minTextField.setColumns(10);

		secTextField = new JTextField();
		secTextField.setText("0");
		secTextField.setBounds(417, 107, 116, 21);
		frame.getContentPane().add(secTextField);
		secTextField.setColumns(10);

		JLabel lblNewLabel = new JLabel("시");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(178, 82, 57, 15);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("분");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(318, 82, 57, 15);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("초");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(447, 82, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);

		timeLabel = new JLabel("00:00:00");
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		timeLabel.setBounds(226, 176, 245, 73);
		frame.getContentPane().add(timeLabel);
	}

}
