public class DateTime{

	private IDate date;
	private Time time;

	public DateTime(short day, short month, short year, DateUtils.DateType cal, short hour, short min, short sec) {
		switch (cal) {
		case GREGORIAN:
			date = new GregorianDate(day, month, year);
			break;
		case JEWISH:
			date = new GregorianDate(day, month, year);
			break;
		}

		time = new Time(hour, min, sec);
	}

	public DateTime(IDate date, Time time) {
		if (date instanceof GregorianDate)
			this.date = new GregorianDate((GregorianDate) date);
		else if (date instanceof JewishDate)
			this.date = new JewishDate((JewishDate) date);
		
		this.time = new Time(time);
	}
	
	public void setDate(IDate date) {
		this.date= date;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public void setDay(short day) {
		date.setDay(day);
	}

	public void setMonth(short month) {
		date.setMonth(month);
	}

	public void setYear(short year) {
		date.setYear(year);
	}

	public short getDay() {
		return date.getDay();
	}

	public short getMonth() {
		return date.getMonth();
	}

	public short getYear() {
		return date.getYear();
	}

	public void setHour(short hour) {
		time.setHour(hour);
	}

	public void setMinute(short min) {
		time.setMinute(min);
	}

	public void setSecond(short sec) {
		time.setSecond(sec);
	}

	public short getHour() {
		return time.getHour();
	}

	public short getMinute() {
		return time.getMinute();
	}

	public short getSecond() {
		return time.getSecond();
	}

	public DateUtils.DateType getDateCalendar() {
		return date.getDateCalendar();
	}

	public IDate getDate() {
		return date;
	}

	public Time getTime() {
		return time;
	}

	public boolean equals(DateTime dateTimeOther) {
		if (dateTimeOther==null)
			return false;
		return (date.equals(dateTimeOther.getDate()) && time.equals(dateTimeOther.getTime()));
	}

	public boolean before(DateTime dateTimeOther) {
		if (dateTimeOther==null)
			return false;
		return date.before(dateTimeOther.getDate())
				|| (date.equals(dateTimeOther.getDate()) && time.before(dateTimeOther.getTime()));
	}

	public boolean after(DateTime dateTimeOther) {
		if (dateTimeOther==null)
			return false;
		return date.after(dateTimeOther.getDate())
				|| (date.equals(dateTimeOther.getDate()) && time.after(dateTimeOther.getTime()));
	}

	@Override
	public String toString() {
		return date.toString() + ", " + time.toString();
	}

}
