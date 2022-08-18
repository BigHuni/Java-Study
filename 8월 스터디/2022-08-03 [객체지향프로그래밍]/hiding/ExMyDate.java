package hiding;

import java.util.Calendar;

public class ExMyDate {

	private int day;
	private int month;
	private int year;
	private boolean isValid = true;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if (day < 0 || day > 31) {
					isValid = false;
				}
				else {
					this.day = day;
				}
				break;
			case 4: case 6: case 9: case 11:
				if(day < 0 || day > 30) {
					isValid = false;
				}
				else {
					this.day = day;
				}
				break;
				
			case 2:
				if ( ( (year % 4 == 0) && (year % 100) != 0) || year % 400 == 0 ) {
					if (day < 0 || day > 29) {
						isValid = false;
					}
					else {
						this.day = day;
					}
				}
					
				else {
					if (day < 0 || day > 28) {
						isValid = false;
					}
					else {
						this.day = day;
					}
				}
				break;
				
				default: isValid = false;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month < 1 || month > 12) {
			isValid = false;
		}
		else {
		this.month = month;
		}
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > Calendar.getInstance().get(Calendar.YEAR)) {
			isValid = false;
		}
		this.year = year;
	}

	public void showDate() {
		if(isValid) {
			System.out.println(year + "년 " + month + "월 " + day + "일 입니다.");
		}
		else {
			System.out.println("유효하지 않은 날짜입니다.");
		}
	}
	
	
}
