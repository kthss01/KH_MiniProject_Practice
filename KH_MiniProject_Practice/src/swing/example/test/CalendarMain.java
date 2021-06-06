package swing.example.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CalendarMain extends JFrame implements ActionListener {
	private JFrame frame;
	// ------------외형구현---------------
	Calendar cal; // 캘린더
	int year, month, date;
	JPanel pane = new JPanel();

	// 위에 버튼 추가
	JButton btn1 = new JButton("◀"); // 이전버튼
	JButton btn2 = new JButton("▶"); // 다음버튼
	JButton btn3 = new JButton("뒤로가기"); // 뒤로가기 버튼

	// 위에 라벨추가
	JLabel yearlb = new JLabel("년");
	JLabel monthlb = new JLabel("월");
	JLabel ss = new JLabel("<html>총 거리 :  <br>총 시간 : <br>소모한 칼로리 : </html>"); // 여기에 + 해서 변수(총 거리,시간,칼로리 넣기)
	JLabel dateex = new JLabel("<html>달린 거리 : <br>달린 시간 : <br>소모한 칼로리 : <br>별점 : </html>");

	// 년월 추가
	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
	JComboBox<Integer> monthCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

	// 패널추가
	JPanel pane3 = new JPanel(new BorderLayout());
	JPanel pane2 = new JPanel(new BorderLayout());
	JPanel title = new JPanel(new GridLayout(1, 7));
	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };
	JPanel datePane = new JPanel(new GridLayout(0, 7));
	JPanel pane4 = new JPanel();

	public CalendarMain() {

		JScrollPane scrollPane = new JScrollPane();// 디자인으로 생성댐
		getContentPane().add(scrollPane, BorderLayout.WEST);
		JPanel pane = new JPanel();

		// 위에 버튼 추가
		JButton btn1 = new JButton("◀"); // 이전버튼
		JButton btn2 = new JButton("▶"); // 다음버튼
		JButton btn3 = new JButton("뒤로가기"); // 뒤로가기 버튼

		// 위에 라벨추가
		JLabel yearlb = new JLabel("년");
		JLabel monthlb = new JLabel("월");
		JLabel ss = new JLabel("<html>총 거리 :  <br>총 시간 : <br>소모한 칼로리 : </html>"); // 여기에 + 해서 변수(총 거리,시간,칼로리 넣기)
		JLabel dateex = new JLabel("<html>달린 거리 : <br>달린 시간 : <br>소모한 칼로리 : <br>별점 : </html>");
		
		makeCalendar();
	}

	// 화면디자인
	public void makeCalendar() {

		// ------년도 월 구하기------------
		cal = Calendar.getInstance(); // 현재날짜
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		date = cal.get(Calendar.DATE);

		// 년
		for (int i = year - 100; i <= year + 50; i++) {
			yearModel.addElement(i);
		}

		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(year);

		// 월
		for (int i = 1; i <= 12; i++) {
			monthModel.addElement(i);
		}
		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(month);

		// 월화수목금토일
		for (int i = 0; i < titleStr.length; i++) {
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			if (i == 0) {
				lbl.setForeground(Color.red);
			} else if (i == 6) {
				lbl.setForeground(Color.blue);
			}
			title.add(lbl);
		}
		// 날짜 출력
		day(year, month);

		// ----------------------------
		setTitle("운동기록 확인");

		pane.add(btn1);
		pane.add(yearCombo);
		pane.add(yearlb);
		pane.add(monthCombo);
		pane.add(monthlb);
		pane.add(btn2);
		getContentPane().add(BorderLayout.CENTER, pane);

		pane2.add(title, "North");
		pane2.add(datePane);
		getContentPane().add(BorderLayout.SOUTH, pane2);

		pane3.add(ss);
		ss.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		getContentPane().add(BorderLayout.NORTH, pane3);

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		dateex.setBounds(0, 82, 434, 96);
		dateex.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		frame.getContentPane().add(dateex);

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pane.setVisible(true);
				pane2.setVisible(true);
				pane3.setVisible(true);
				pane4.setVisible(false);
				frame.setVisible(false);
			}
		});
		btn3.setBounds(0, 0, 87, 23);
		frame.getContentPane().add(btn3);
		frame.setVisible(false);

		// 각종 명령어
		setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setResizable(false);
		setSize(400, 330);
		pane4.setVisible(false);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ----------기능구현----------
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
	}

	// 기능구현
	public void actionPerformed(ActionEvent e) {
		Object eventObj = e.getSource();
		if (eventObj instanceof JComboBox) {
			datePane.setVisible(false); // 보여지는 패널을 숨킨다.
			datePane.removeAll(); // 라벨 지우기
			day((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());
			datePane.setVisible(true); // 패널 재출력
		} else if (eventObj instanceof JButton) {
			JButton eventBtn = (JButton) eventObj;
			int yy = (Integer) yearCombo.getSelectedItem();
			int mm = (Integer) monthCombo.getSelectedItem();
			if (eventBtn.equals(btn1)) { // 전달
				if (mm == 1) {
					yy--;
					mm = 12;
				} else {
					mm--;
				}
			} else if (eventBtn.equals(btn2)) { // 다음달
				if (mm == 12) {
					yy++;
					mm = 1;
				} else {
					mm++;
				}
			}
			yearCombo.setSelectedItem(yy);
			monthCombo.setSelectedItem(mm);
		}
	}

	// 날짜출력
	public void day(int year, int month) {
		Calendar date = Calendar.getInstance();// 오늘날짜 + 시간
		date.set(year, month - 1, 1);
		int week = date.get(Calendar.DAY_OF_WEEK);

		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 공백출력
		for (int space = 1; space < week; space++) {
			datePane.add(new JLabel("\t"));
		}

		// 날짜 출력
		for (int day = 1; day <= lastDay; day++) {
			JButton jbt = new JButton(String.valueOf(day));
			jbt.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					super.mousePressed(e);
					pane.setVisible(false);
					pane2.setVisible(false);
					pane3.setVisible(false);
					pane4.setVisible(true);
					frame.setVisible(true);

				}

			});
			cal.set(year, month - 1, day);
			int Week = cal.get(Calendar.DAY_OF_WEEK);
			if (Week == 1) {
				jbt.setForeground(Color.red);
			} else if (Week == 7) {
				jbt.setForeground(Color.BLUE);
			}
			datePane.add(jbt);
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalendarMain frame = new CalendarMain();
//					frame.makeCalendar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}