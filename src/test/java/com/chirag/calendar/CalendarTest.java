package com.chirag.calendar;

import static org.junit.Assert.*;
import static junitparams.JUnitParamsRunner.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Unit test for Calendar.
 */
@RunWith(JUnitParamsRunner.class)
public class CalendarTest 
{
	private JavaCalendar javaCalendarObj;
	
	@SuppressWarnings("unused")
	private static final Object[] parametersToTestNumberofDays() {
		return new Object[]{
				//Parameters are: (1,2)
				//1=expectedDay, 2=day, 3=month, 4=year
				//Test case 1
				new Object[]{2,1,5,2018},
				//Test case 2
				new Object[]{3,2,5,2018},
				//Test case 3
				new Object[]{5,1,6,2018}
		};}

	@Test
	@Parameters(method="parametersToTestNumberofDays")
	public void shouldGiveNumberofDays(int expectedDay, int day, int month, int year)
	{
		assertEquals(expectedDay,javaCalendarObj.day(month, day, year));
	}
	
	@SuppressWarnings("unused")
	private static final Object[] parametersToTestValidLeapYear() {
		return new Object[]{
				//Parameters are: (1,2)
				//1=isLeapYear, 2=year
				//Test case 1
				new Object[]{true,2000},
				//Test case 2
				new Object[]{false,2018},
				// Test case 3
				new Object[]{false,2019},
				// Test case 4
				new Object[]{true,2020},
				// Test case 5
				new Object[]{false,3000}
		};}

	@Test
	@Parameters(method="parametersToTestValidLeapYear")
	public void shouldGiveValidLeapYear(boolean expectedResult,int year)
	{
		assertEquals(expectedResult,javaCalendarObj.isLeapYear(year));
	}
	
	@SuppressWarnings("unused")
	private static final Object[] parametersToTestValidTimeSlot() {
		return new Object[]{
				//Parameters are: (1,2,3)
				//1=userTimeZone, 2=timeZoneChoice, 3=actualtimeslotnumber, 4=expectedtimeslotnumber
				//Test case 1
				new Object[]{"Central Standard Time","CST", 12,12},
				// Test case 2		
				new Object[]{"Central Standard Time","EST", 12,11},
				// Test case 3		
				new Object[]{"Central Standard Time","MST", 12,13},
				// Test case 4		
				new Object[]{"Central Standard Time","PST", 12,14},
				// Test case 5		
				new Object[]{"Central Standard Time","EST", 1,1},
				// Test case 6		
				new Object[]{"Central Standard Time","MST", 23,23},
				// Test case 7		
				new Object[]{"Central Standard Time","PST", 23,23},
				// Test case 8
				new Object[]{"Central Standard Time","", 23,23},
				// Test case 9
				new Object[]{"Eastern Standard Time","CST", 23,23},
				// Test case 10		
				new Object[]{"Eastern Standard Time","EST", 23,23},
				// Test case 11		
				new Object[]{"Eastern Standard Time","MST", 23,23},
				// Test case 12		
				new Object[]{"Eastern Standard Time","PST", 23,23},
				// Test case 13	
				new Object[]{"Eastern Standard Time","CST", 22,23},
				// Test case 14		
				new Object[]{"Eastern Standard Time","MST", 21,23},
				// Test case 15		
				new Object[]{"Eastern Standard Time","PST", 20,23},
				// Test case 16		
				new Object[]{"Eastern Standard Time","", 20,20},
				// Test case 17
				new Object[]{"Mountain Standard Time","CST", 1,1},
				// Test case 18		
				new Object[]{"Mountain Standard Time","EST", 2,2},
				// Test case 19		
				new Object[]{"Mountain Standard Time","MST", 23,23},
				// Test case 20		
				new Object[]{"Mountain Standard Time","PST", 23,23},
				// Test case 21	
				new Object[]{"Mountain Standard Time","CST", 23,22},
				// Test case 22		
				new Object[]{"Mountain Standard Time","EST", 23,21},
				// Test case 23		
				new Object[]{"Mountain Standard Time","PST", 22,23},
				// Test case 24		
				new Object[]{"Mountain Standard Time","", 22,22},
				// Test case 25
				new Object[]{"Pacific Standard Time","CST", 1,1},
				// Test case 26		
				new Object[]{"Pacific Standard Time","EST", 1,1},
				// Test case 27		
				new Object[]{"Pacific Standard Time","MST", 1,1},
				// Test case 28		
				new Object[]{"Pacific Standard Time","PST", 1,1},
				// Test case 29	
				new Object[]{"Pacific Standard Time","CST", 23,21},
				// Test case 30		
				new Object[]{"Pacific Standard Time","EST", 23,20},
				// Test case 31		
				new Object[]{"Pacific Standard Time","MST", 23,22},
				// Test case 32		
				new Object[]{"Pacific Standard Time","", 23,23},
				// Test case 33
				new Object[]{"","", 23,23}
				
				};}
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