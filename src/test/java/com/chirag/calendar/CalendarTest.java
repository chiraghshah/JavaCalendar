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
    @Test
    public void shouldGiveNumberofDays()
    {
    	JavaCalendar jc = new JavaCalendar();
    	int outResult= jc.day(5, 1, 2018);
        assertEquals(2,outResult);
    }
    
    @Test
    public void shouldGiveValidLeapYear()
    {
    	JavaCalendar jc = new JavaCalendar();
    	boolean outResult= jc.isLeapYear(2018);
        assertEquals(false,outResult);
    }
    
    @SuppressWarnings("unused")
    private static final Object[] parametersToTestValidTimeSlot() {
    	return $(
//    				Parameters are: (1,2,3)
//     				1=userTimeZone, 2=timeZoneChoice, 3=actualtimeslotnumber, 4=expectedtimeslotnumber
//    				Test case 1
    			$("Central Standard Time","CST", 12,12),
    			//$("Central Standard Time","CST", 12,11),
//    				Test case 8			
    			$("Central Standard Time","EST", 12,11)
    	);}
    @Before
    public void setUp() throws Exception {
    	javaCalendarObj= new JavaCalendar();
    }
    @Test
    @Parameters(method="parametersToTestValidTimeSlot")
    public void shouldGiveValidTimeSlot(String userTimeZone,String timeZoneChoice, int timeslot, int expectedtimeslot)
    {
    	assertEquals(expectedtimeslot,javaCalendarObj.checkCurrentTimeZone(userTimeZone, timeZoneChoice, timeslot));
    }
    
}





//if (year == 1582 && month ==10 && day>=5 && day <= 14)
//return true;
//else
//return false;