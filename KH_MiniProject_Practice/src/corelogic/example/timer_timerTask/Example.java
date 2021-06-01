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
	 * 	실제 타이머의 기능을 수행하는 클래스
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

	/*
	 * Timer, TimerTask 클래스를 정리 
	 * https://sangwoo0727.github.io/java/JAVA-36_timertask/
	 * 
	 * java.util.Timer 클래스
	 * 
	 * Timer 클래스는 아래와 같이 3가지의 메소드를 제공한다.
	 * 	schedule
	 * 	scheduleAtFixedRate
	 * 	cancel
	 * 
	 * void schedule(TimerTask task, Date time) 
	 * 	- 설정한 time 시간에, 설정한 task 작업을 수행한다.
	 * void schedule(TimerTask task, Date firstTime, long period) 
	 * 	- firstTime 부터 period 간격으로 task 작업을 수행한다.
	 * 
	 * 위 두 메소드는 만약 지정한 시간이 현재 시간보다 이전일 경우 바로 task 작업을 수행 
	 * 
	 * void schedule(TimerTask task, long delay) 
	 *  - delay 시간이 지난 후에, task를 수행한다.
	 * void schedule(TimerTask task, long delay, long period)
	 *  - delay 시간이 지난 후에, period 간격으로 task를 수행한다.
	 *  
	 * 위 두 메소드는 fixed-delay 방식으로 작업을 진행,
	 * fixed-delay 방식은 선행 작업이 지연될 경우, 
	 * 다음에 수행되는 작업 역시 그 시간만큼 지연되는 방식 
	 * 
	 * void scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 
	 *  - 지정한 시간부터 일정한 간격으로 task를 수행한다.
	 * void scheduleAtFixedRate(TimerTask task, long delay, long period)
	 *  - 일정한 시간(delay)가 지난 후 일정한 간격으로 task를 수행한다.
	 *  
	 * 위 두 메소드는 fixed-rate 방식 이용 (선행 작업의 지연 유무에 상관없이 지정된 시간에 작업 실행)
	 * fixed-delay 방식이 아니므로, 정확하게 일정 시간 간격으로 작업을 실행해야 할 때 적합
	 * 
	 * cancel()
	 * Timer를 중지시키며, 실행 중인 task 작업을 제외한 예정된 작업들은 모두 취소된다.
	 * 
	 *************************************************
	 * 
	 * java.util.TimerTask 클래스
	 * 
	 * TimerTask 클래스는 Timer 클래스가 수행할 작업을 나타냄
	 * TimerTasks는 Runnable 인터페이스를 구현함
	 * 
	 * 	제공하는 메소드
	 * boolean cancel()
	 * 	- TimerTask 작업을 취소한다.
	 * 
	 * abstract void run()
	 *  - TimerTask가 실행할 작업
	 *  
	 * long scheduledExecutionTime()
	 *  - 가장 최근에 작업이 실행된 시간을 리턴 
	 */
}
