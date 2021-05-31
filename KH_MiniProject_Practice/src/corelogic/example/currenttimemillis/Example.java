package corelogic.example.currenttimemillis;

import java.io.IOException;

public class Example {

	/*
	 * Java 스톱워치 구현 https://maskkwon.tistory.com/82
	 */

	static String timerBuffer; // 04:11:15 등의 경과 시간 문자열이 저장될 버퍼 정의
	static int oldTime; // 타이머가 ON 되었을 대의 시각을 기억하고 있는 변수

	public static void main(String[] args) {
		stopwatch(1); // 1을 인수로 넣으면 타이머가 켜짐
		System.out.println("Timer ON! 엔터 키를 누르면 종료합니다.");

		pause(); // 유저가 Enter키를 누를 때까지 무한정 대기

		stopwatch(0); // 0을 넣으면 타이머가 꺼지고 시간 문자열을 버퍼에 설정
		System.out.format("Timer OFF! 경과시간 [%s]\n", timerBuffer); // 경과 시간 화면에 출력
	}

	private static void stopwatch(int onOff) {
		if (onOff == 1) {
			// 타이머 켜기
			oldTime = (int) System.currentTimeMillis() / 1000;
		}

		if (onOff == 0) {
			// 타이머 끄고, 시분초를 timerBuffer에 저장
			secToHHMMSS(((int) System.currentTimeMillis() / 1000) - oldTime);
		}
	}

	private static void secToHHMMSS(int secs) {
		// 정수로 된 시간을 초단위(sec)로 입력 받아, "04:11:15"등의 형식의 문자열로 시분초를 저장
		int hour, min, sec;

		sec = secs % 60;
		min = secs / 60 % 60;
		hour = secs / 3600;

		timerBuffer = String.format("%02d:%02d:%02d", hour, min, sec);
	}

	private static void pause() {
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
