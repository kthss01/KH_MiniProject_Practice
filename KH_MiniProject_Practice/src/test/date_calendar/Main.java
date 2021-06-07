package test.date_calendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		Date date = new Date();
		System.out.println(date);

//		cal.setTime(date);
		cal.set(2012, 5, 30);

		System.out.println(cal.getTime());

		Calendar cal2 = Calendar.getInstance();

		cal2.setTime(new Date());

		System.out.println("cal : " + cal.getTime());
		System.out.println("cal2 : " + cal2.getTime());

		// localdatetime
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime start = LocalDateTime.of(1, 1, 1, 0, 0);
		// 참고 LocalDate는 Duration 지원 x
		// 시작일 제외 계산임
		System.out.println("총 날짜 수 : " + Duration.between(start, today).toDays());
	}

}
