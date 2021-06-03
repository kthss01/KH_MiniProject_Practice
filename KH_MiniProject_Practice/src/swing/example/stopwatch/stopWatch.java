package swing.example.stopwatch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stopWatch extends stopwatch_GUI implements ActionListener, Runnable {
	
	
	int s_hour, s_min, s_sec;
	int e_hour, e_min, e_sec;
	int f_hour, f_min, f_sec;
	int start_time, stop_time, for_time;
	String save_time;
	boolean flag;
	int ms = 0;
	int s = 0;
	int m = 0;
	int h = 0;
	long start;
	long end;
	long actTime; // 동작한 시간을 저장하기 위한 변수
	Thread thread;

	public stopWatch() {
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public static void main(String[] args) {
		new stopWatch();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("start")) {
			if (!flag) {
				start = System.currentTimeMillis();
				if (actTime > 0) {
					start = (start - actTime);
				}
				flag = true;
				thread = new Thread(this);
				thread.start();
			}
			// else{
			// // thread.resume();
			//
			// }
		} else if (str.equals("stop")) {
			flag = false;
			// try {
			// thread.suspend();
			// } catch (Exception e2) {
			// // TODO: handle exception
// } 
// }else if (str.equals("reset")) { 
			flag = false;
//lbl1.setText("00"); 
//lbl2.setText("00"); 
//lbl3.setText("00"); 
//lbl4.setText("00"); 
		} else if (str.equals("quit")) {
			System.exit(0);
		}
	}

	public void ABC() {
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			end = System.currentTimeMillis();
			ms = (int) ((end - start) / 10);
			h = (ms / (3600 * 100));
			m = ((ms - h * 3600 * 100) / (60 * 100));
			s = ((ms - h * 3600 * 100 - m * 60 * 100) / 100);
			ms = (ms - h * 3600 * 100 - m * 60 * 100 - s * 100);
			lbl1.setText(ms < 10 ? "0" + ms : "" + ms);
			lbl2.setText(s < 10 ? "0" + s : "" + s);
			lbl3.setText(m < 10 ? "0" + m : "" + m);
			lbl4.setText(h < 10 ? "0" + h : "" + h);
		}
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actTime = end - start;
	}

	
}
