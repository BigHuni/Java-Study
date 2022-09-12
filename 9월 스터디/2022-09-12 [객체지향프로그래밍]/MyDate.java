package object;

public class MyDate {

	int day;
	int month;
	int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate date = (MyDate)obj;
			if(this.day == date.day && this.month == this.month && this.year == this.year)
				return true;
			
			return false;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return day * 11 + month * 101 + year * 1001;
	}
}
