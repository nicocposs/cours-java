package com.formation;

class MyDate {
    int _day;
    int _month;
    int _year;

    /**
     * Constructs a date. 
     *
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     */
    public MyDate(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
    }
    
    /**
     * Determines if a given (day, month, year) represents a valid date.
     * 
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return true if (day, month, year) represents a valid date, false else
     */
    public static boolean isValidDate(int day, int month, int year) {
        return checkData(day, month, year);
    }

    /**
     * Determines if a given (day, month, year) represents a valid date.
     * 
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return true if (day, month, year) represents a valid date, false else
     */
    private static boolean checkData(int day, int month, int year) {
        return checkDay(day) && checkMonth(month) && checkYear(year) 
            && checkDayLimits(day, month, year);
    }

    /**
     * Determines if this object represents a valid date.
     * 
     * @return true if this object represents a valid date, false else
     */
    public boolean checkData() {
        return checkData(_day, _month, _year);
    }

    /**
     * Get the last day given a month and a year.
     * 
     * @param      month   the month.
     * @param      year   the year.
     * @return the last day of (month, year), (should be 28, 29, 30 or 31)
     */
    public static int maxDayOfMonth(int month, int year) {
        int result = 31;
        if ( month == 2 )
            result = ( year%4 == 0 ) ? 29 : 28;
        if ( month == 4 || month == 6 || month == 9 || month == 11 )
            result = 30;
        return result;
    }

    /**
     * Updates the day, month and year) attributes of this object
     * to the next day (tomorrow).
     * 
     * @return this (my)date
     */
    public MyDate nextDay() {
    	//voir si changement d'ann?e
    	if(this._day == 31 && this._month == 12) {
    		this._day = 1;
    		this._month = 1;
    		this._year++;
    		return this;
    	}
    	
    	//voir si changement de mois
    	if(this._day == maxDayOfMonth(this._month, this._year)) {
    		this._day = 1;
    		this._month++;
    		return this;
    	}
    	
    	//Changement de jour
    	this._day++;
    	
        return this;
    }
    
    /**
     * Allocates a <code>MyDate</code> object and initializes it to represent 
     * the day (tomorrow) which follows the provided day, month and year.
     * 
     * @param      day   the day.
     * @param      month   the month.
     * @param      year   the year.
     * @return a (my)date object initialized to next day of (day, month, year)
     */
    public static MyDate nextDay(int day, int month, int year) {
        MyDate date = new MyDate(day, month, year);
        return date.nextDay();
    }
    
    private static boolean checkDayLimits(int day, int month, int year) {        
        int dayMax = maxDayOfMonth(month, year);
        return day > 0 && day <= dayMax;
    }

    private static boolean checkFebruaryDayLimits(int day, int year) {
        if(year % 4 == 0 && day <= 29) {
        	return true;
        }
        
        if(year % 4 != 0 && day <= 28) {
        	return true;
        }
    	
        return false;
    }

    private static boolean checkDay(int day) {
        return day > 0 && day < 32;
    }

    private static boolean checkMonth(int month) {
        return month > 0 && month < 13;
    }

    private static boolean checkYear(int year) {
        return year >= 1812 && year <= 2012;
    }

    public int getYear() {
        return _year;
    }

    private void setYear(int _year) {
        this._year = _year;
    }

    public int getDay() {
        return _day;
    }

    private void setDay(int _jour) {
        this._day = _jour;
    }

    public int getMonth() {
        return _month;
    }

    private void setMonth(int _month) {
        this._month = _month;
    }

}

