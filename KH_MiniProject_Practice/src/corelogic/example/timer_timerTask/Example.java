package corelogic.example.timer_timerTask;

import java.util.Timer;
import java.util.TimerTask;

public class Example {

	/*
	 * 자바 타이머 (Timer, TimerTask) - 모프
	 * http://blog.naver.com/PostView.nhn?blogId=highkrs&logNo=220283709171
	 * 
	 * 타이머는 일종의 thread 클래스
	 * 
	 * 아래 프로그램은 5초 뒤에 "Morph"라는 문자를 한번 찍어줌
	 * 
	 * Timer 클래스
	 * 	실제 타임머의 기능을 수행하는 클래스
	 * 
	 * TimerTask 클래스
	 * 	Timer 클래스가 수행되어야 할 내용을 작성하는 클래스
	 * 	TimerTask 클래스의 run 메소드에 오버라이드(메소드 재정의)를 통하여 작성
	 */
	
	public static int count;
	
	private static void singleCount() {
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {

			@Override
			public void run() {
				System.out.println("Morph");
			}
		};
		
		// schedule(TimerTask task, long delay)
		m_timer.schedule(m_task, 5000); // 밀리초라 5초하려면 곱하기 1000	
	}
	
	private static void multiCount() {
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {

			@Override
			public void run() {
				if (count < 5) {
					System.out.println("Morph");
					count++;
				} else {
					m_timer.cancel();
				}
			}
		};
		
		// schedule(TimerTask task, long delay, long period)
		m_timer.schedule(m_task, 5000, 2000); // 5초 후 시작 2초마다 반복
	}
	
	public static void main(String[] args) {


		// 단발성 실행
		// 특정 시간 (delay) 이후 run 메소드 실행
//		singleCount();
		
		
		// 연발성 실행
		// 특정 시간 (delay) 이후 run 메소드 실행
		// 이후 period 마다 run 메소드 실행
		// cancel() 로 종료
		multiCount();
		
		// delay 최초 시작 딜레이. 즉, 타이머가 시작되기전에 대기하는 시간
		// ex) delay 1000값을 넘긴다면 타이머는 1초 뒤에 실행 (단위 밀리세컨드[ms])
		// period 반복 주기
		// ex) period 2000이면 2초마다 반복
		// cancel 메소드를 사용하여 중단 시켜야함!!
 	}

}
