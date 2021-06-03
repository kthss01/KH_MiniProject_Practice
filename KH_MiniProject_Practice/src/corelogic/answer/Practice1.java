package corelogic.answer;

import java.util.Scanner;

public class Practice1 {
	/*
	 * currentTimeMills 연습해보기
	 * 
	 * 문제
	 * 저희 팀프로젝트에 핵심 로직인 운동을 시작하고 종료하는 부분을 구현해보기
	 * 
	 * 설명
	 * 운동 시간을 입력 받은 후  
	 * 운동을 시작을 출력
	 * 운동 시간이 종료 되면 운동이 종료 되었음을 출력
	 * 
	 * 예시 1 - 1초 입력
	 * 운동 시간 입력(00:00:00 형식으로 입력) : 00:00:01
	 * 운동 시작
	 * 운동 종료
	 * 운동 시간 : 00:00:01
	 * 
	 * 예시 2 - 1분 입력
	 * 운동 시간 입력(00:00:00 형식으로 입력) : 00:01:00
	 * 운동 시작
	 * 운동 종료
	 * 운동 시간 : 00:01:00
	 * 
	 * main 메소드에 모두 작성하여도 상관없고 메소드 등을 추가하여 작성하여도 무방
	 * 콘솔창에 원하는 출력이 나오는 것을 목표로 한다.
	 * currentTimeMills Example 참고!
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("운동 시간 입력 (00:00:00 형식으로 입력) : ");
		String time = sc.nextLine();
		
		String[] times = time.split(":"); // : 으로 split
		int hour = Integer.valueOf(times[0]);
		int minute = Integer.valueOf(times[1]);
		int second = Integer.valueOf(times[2]);
		
		int secs = hour * 3600 + minute * 60 + second; // 운동시간을 모두 초로 변경
		
		long startTime = System.currentTimeMillis(); // 현재 시간 저장
		long endTime = startTime + secs * 1000; // 종료 시간을 현재 시간에 운동시간을 더하여 저장
		// 밀리세컨이므로 곱하기 1000
		
//		System.out.println(startTime);
//		System.out.println(endTime);
		
		int count = 0;
		
		System.out.println("운동 시작");
		long curTime = startTime;
		while (curTime != endTime) {
			curTime = System.currentTimeMillis();

			// 좀더 생각해보기
			// 진행 시간 표시하기
			// 경과 형태
			// 현재 시간 == 시작 시간 + count 초 * 1000인 경우에 출력방식 사용
//			if (curTime == startTime + count * 1000) {
//				System.out.println(count + "초 경과");
//				count++;
//			}
			// 남은 시간 형태
			if (curTime == startTime + count * 1000) {
//				System.out.println(secs - count + "초 남음");
				System.out.println(secToHHMMSS(secs - count));
				count++;
			}
			
		}
		System.out.println("운동 종료");
		System.out.println("운동 시간 : " + time);
	}

	private static String secToHHMMSS(long secs) {
		long hour, min, sec;

		sec = secs % 60; // 초
		min = secs / 60 % 60; // 분
		hour = secs / 3600; // 시
		
		return String.format("%02d:%02d:%02d", hour, min, sec);
	}
}
