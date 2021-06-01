package corelogic.answer;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class Practice2 {

	/*
	 * Timer, TimerTask 연습해보기
	 * 
	 * 문제 저희 팀프로젝트에 핵심 로직인 운동을 시작하고 종료하는 부분을 구현해보기
	 * 
	 * 설명 운동 시간을 입력 받은 후 운동을 시작을 출력 운동 시간이 종료 되면 운동이 종료 되었음을 출력
	 * 
	 * 예시 1 - 1초 입력 운동 시간 입력(00:00:00 형식으로 입력) : 00:00:01 운동 시작 운동 종료 운동 시간 :
	 * 00:00:01
	 * 
	 * 예시 2 - 1분 입력 운동 시간 입력(00:00:00 형식으로 입력) : 00:01:00 운동 시작 운동 종료 운동 시간 :
	 * 00:00:01
	 * 
	 * main 메소드에 모두 작성하여도 상관없고 메소드 등을 추가하여 작성하여도 무방 콘솔창에 원하는 출력이 나오는 것을 목표로 한다.
	 * Timer_TimerTask Example 참고!
	 */

	private static int count; // count를 다른 스레드에서 접근해야되서 static으로

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("운동 시간 입력 (00:00:00 형식으로 입력) : ");
		String time = sc.nextLine();

		String[] times = time.split(":"); // : 으로 split
		int hour = Integer.valueOf(times[0]);
		int minute = Integer.valueOf(times[1]);
		int second = Integer.valueOf(times[2]);

		int secs = hour * 3600 + minute * 60 + second; // 운동시간을 모두 초로 변경
		int millisec = secs * 1000; // 아예 초를 밀리초로 변경

		count = 0;

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				int result = secs - count++;

				if (result != 0) {
					System.out.println(secToHHMMSS(result));
				} else {
					System.out.println(secToHHMMSS(result));
					System.out.println("운동 종료");
					System.out.println("운동 시간 : " + time);
					timer.cancel();
				}

			}

		};

		// 선행작업 지연 여부 상관없이 지정된 시간에 작업 진행
		timer.scheduleAtFixedRate(task, 0, 1000); // 1초마다 실행
		// 더 세부적으로 설정도 가능!
//		timer.scheduleAtFixedRate(task, 0, 10); // 0.001초마다 실행 (출력도 바꿔줘야함)
		System.out.println("운동 시작");
		
//		CountDownLatch countDownLatch = new CountDownLatch(1);
//		
//		Timer timer = new Timer();
//		TimerTask task = new TimerTask() {
//
//			@Override
//			public void run() {
//				countDownLatch.countDown();
//				System.out.println("운동 시작");				
//			}			
//		};
//		
//		timer.schedule(task, millisec);
//		
//		try {
//			countDownLatch.await();
//			System.out.println("운동 종료");
//			System.out.println("운동 시간 : " + time);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

	}

	private static String secToHHMMSS(long secs) {
		long hour, min, sec;

		sec = secs % 60; // 초
		min = secs / 60 % 60; // 분
		hour = secs / 3600; // 시

		return String.format("%02d:%02d:%02d", hour, min, sec);
	}
}
