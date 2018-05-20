package com.chirag.calendar;

import static org.junit.Assert.*;
import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Test;


/**
 * Unit test for Calendar.
 */
@RunWith(JUnitParamsRunner.class)
public class CalendarTest 
{
	private JavaCalendar javaCalendarObj;
	
	@SuppressWarnings("unused")
	private static final Object[] parametersToTestNumberofDays() {
		return $(
				//Parameters are: (1,2)
				//1=expectedDay, 2=day, 3=month, 4=year
				//Test case 1
				$(2,1,5,2018),
				//Test case 2
				$(3,2,5,2018),
				//Test case 3
				$(5,1,6,2018)
				);}

	@Test
	@Parameters(method="parametersToTestNumberofDays")
	public void shouldGiveNumberofDays(int expectedDay, int day, int month, int year)
	{
		assertEquals(expectedDay,javaCalendarObj.day(month, day, year));
	}
	
	@SuppressWarnings("unused")
	private static final Object[] parametersToTestValidLeapYear() {
		return $(
				//Parameters are: (1,2)
				//1=isLeapYear, 2=year
				//Test case 1
				$(true,2000),
				//Test case 2
				$(false,2018),
				// Test case 3
				$(false,2019),
				// Test case 4
				$(true,2020),
				// Test case 5
				$(false,3000)
				);}

	@Test
	@Parameters(method="parametersToTestValidLeapYear")
	public void shouldGiveValidLeapYear(boolean expectedResult,int year)
	{
		assertEquals(expectedResult,javaCalendarObj.isLeapYear(year));
	}

	@SuppressWarnings("unused")
	private static final Object[] parametersToTestValidTimeSlot() {
		return $(
				//Parameters are: (1,2,3)
				//1=userTimeZone, 2=timeZoneChoice, 3=actualtimeslotnumber, 4=expectedtimeslotnumber
				//Test case 1
				$("Central Standard Time","CST", 12,12),
				// Test case 2		
				$("Central Standard Time","EST", 12,11),
				// Test case 3		
				$("Central Standard Time","MST", 12,13),
				// Test case 4		
				$("Central Standard Time","PST", 12,14),
				// Test case 5		
				$("Central Standard Time","EST", 1,1),
				// Test case 6		
				$("Central Standard Time","MST", 23,23),
				// Test case 7		
				$("Central Standard Time","PST", 23,23),
				// Test case 8
				$("Central Standard Time","", 23,23),
				// Test case 9
				$("Eastern Standard Time","CST", 23,23),
				// Test case 10		
				$("Eastern Standard Time","EST", 23,23),
				// Test case 11		
				$("Eastern Standard Time","MST", 23,23),
				// Test case 12		
				$("Eastern Standard Time","PST", 23,23),
				// Test case 13	
				$("Eastern Standard Time","CST", 22,23),
				// Test case 14		
				$("Eastern Standard Time","MST", 21,23),
				// Test case 15		
				$("Eastern Standard Time","PST", 20,23),
				// Test case 16		
				$("Eastern Standard Time","", 20,20),
				// Test case 17
				$("Mountain Standard Time","CST", 1,1),
				// Test case 18		
				$("Mountain Standard Time","EST", 2,2),
				// Test case 19		
				$("Mountain Standard Time","MST", 23,23),
				// Test case 20		
				$("Mountain Standard Time","PST", 23,23),
				// Test case 21	
				$("Mountain Standard Time","CST", 23,22),
				// Test case 22		
				$("Mountain Standard Time","EST", 23,21),
				// Test case 23		
				$("Mountain Standard Time","PST", 22,23),
				// Test case 24		
				$("Mountain Standard Time","", 22,22),
				// Test case 25
				$("Pacific Standard Time","CST", 1,1),
				// Test case 26		
				$("Pacific Standard Time","EST", 1,1),
				// Test case 27		
				$("Pacific Standard Time","MST", 1,1),
				// Test case 28		
				$("Pacific Standard Time","PST", 1,1),
				// Test case 29	
				$("Pacific Standard Time","CST", 23,21),
				// Test case 30		
				$("Pacific Standard Time","EST", 23,20),
				// Test case 31		
				$("Pacific Standard Time","MST", 23,22),
				// Test case 32		
				$("Pacific Standard Time","", 23,23),
				// Test case 33
				$("","", 23,23)
				
				);}
	@Before
	public void setUp() throws Exception {
		javaCalendarObj= new JavaCalendar();
	}
	
	@Test
	@Parameters(method="parametersToTestValidTimeSlot")
	public void shouldGiveValidTimeSlot(String userTimeZone,String timeZoneChoice, int timeslot, int expectedTimeSlot)
	{
		assertEquals(expectedTimeSlot,javaCalendarObj.checkCurrentTimeZone(userTimeZone, timeZoneChoice, timeslot));
	}

}





//if (year == 1582 && month ==10 && day>=5 && day <= 14)
//return true;
//else
//return false;