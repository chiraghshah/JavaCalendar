package com.chirag.calendar;
import java.util.*;

public class JavaCalendar { 

	// days[i] = number of days in month i
	static int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	// months[i] = name of month i and  leaving first empty so that months[1] = "January"
	static String[] months = { "",  "January", "February", "March","April", "May", "June","July", "August", "September","October", "November", "December"};
	//timeSlots[i] = hourly time slots starting midnight and ending midnight..
	static String [] timeSlots = {"", "00:00 - 01:00", "01:00 - 02:00", "02:00 - 03:00", "03:00 - 04:00", "04:00 - 05:00","05:00 - 06:00",
		"06:00 - 07:00", "07:00 - 08:00", "08:00 - 09:00","09:00 - 10:00","10:00 - 11:00","11:00 - 12:00","12:00 - 13:00","13:00 - 14:00","14:00 - 15:00",
		"15:00 - 16:00","16:00 - 17:00", "17:00 - 18:00", "18:00 - 19:00","19:00 - 20:00", "20:00 - 21:00","21:00 - 22:00","22:00 - 23:00","23:00 - 00:00"};

	static ArrayList<Event> eventListG = new ArrayList<Event>();

	static int userMonth=0;
	static int userYear=0;
	static String userTimeZone="";

	public static int day(int M, int D, int Y) {
		try {
			int y = Y - (14 - M) / 12;
			int x = y + y/4 - y/100 + y/400;
			int m = M + 12 * ((14 - M) / 12) - 2;
			int d = (D + x + (31*m)/12) % 7;
			return d;
		} catch (Exception e) {
			System.out.println("Exception inside day() :"+e.getMessage());
			return 0;
		}
	}

	// return true if the given year is a leap year
	public static boolean isLeapYear(int year) {
		try {
			if  ((year % 4 == 0) && (year % 100 != 0)) return true;
			if  (year % 400 == 0) return true;
			return false;
		} catch (Exception e) {
			System.out.println("Exception inside isLeapYear() :"+e.getMessage());
			return false;
		}
	}

	public static void printCalendar(){
		try {
			// check for leap year and change the number of days..
			if (userMonth == 2 && isLeapYear(userYear))
			{
				days[userMonth] = 29;
			}
			// print calendar head..
			System.out.println("\n"+"   " + months[userMonth] + " " + userYear);
			System.out.println(" S  M Tu  W Th  F  S");

			// get the starting day
			int d = day(userMonth, 1, userYear);
			// print the calendar
			for (int i = 0; i < d; i++)
				System.out.print("   ");
			for (int i = 1; i <= days[userMonth]; i++) {
				System.out.printf("%2d ", i);
				if (((i + d) % 7 == 0) || (i == days[userMonth])) System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Exception inside printCalendar() :"+e.getMessage());
		}
	}

	public static void addEvents(){
		try {
			System.out.println();
			//System.out.println("1. 00:00 - 01:00\t6. 05:00 - 06:00\t11. 10:00 - 11:00\t16. 15:00 - 16:00\t21. 20:00 - 21:00\n2. 01:00 - 02:00\t7. 06:00 - 07:00\t12. 11:00 - 12:00\t17. 16:00 - 17:00\t22. 21:00 - 22:00\n3. 02:00 - 03:00\t8. 07:00 - 08:00\t13. 12:00 - 13:00\t18. 17:00 - 18:00\t23. 22:00 - 23:00\n4. 03:00 - 04:00\t9. 08:00 - 09:00\t14. 13:00 - 14:00\t19. 18:00 - 19:00\t24. 23:00 - 00:00\n5. 04:00 - 05:00\t10.09:00 - 10:00\t15. 14:00 - 15:00\t20. 19:00 - 20:00");
			System.out.println("\nEnter for which day you want to set Events! ");
			int userDay = new Scanner(System.in).nextInt();
			for(int k=1;k<timeSlots.length;k++)
			{
				System.out.printf(k+". "+"%s ", timeSlots[k] +"\t");
				if(k%5==0)System.out.println();
			}
			System.out.println("\nFor "+ userDay +" "+ months[userMonth]+ " ,enter a Time Slot number to set an Event for ! \n");
			int timeslot = new Scanner(System.in).nextInt();
			char choiceTz =(char) 0;
			while(true){
				System.out.println("Do you want to change Time Zone for this Event - Y/N?\n");
				choiceTz= new Scanner(System.in).next().charAt(0);
				if(choiceTz == 'y' || choiceTz == 'Y'){ 
					try {
						int temp_timeslot=showTimeZones(timeslot);
						if(temp_timeslot!=0)timeslot=temp_timeslot;
						else System.out.println("\nCan not validate timeslot..continuing with selected time.\n");
					} catch (Exception e) {
						System.out.println("Exception inside addEvents() while getting TimeZones :"+e.getMessage());
					}
					break;
				}
				else{
					System.out.println("Enter correct choices..");
				}
			}

			if(eventListG.size()!=0)
			{
				for(int i=0;i<eventListG.size();i++){
					if(eventListG.get(i).getDay() == userDay && eventListG.get(i).getMonth() == userMonth && eventListG.get(i).getYear() == userYear){
						if(eventListG.get(i).getTimeSlot().isEmpty() || eventListG.get(i).getTimeSlot()== ""){

							System.out.println("\nAdd Appointment Title ! \n");
							String apptTitle = new Scanner(System.in).nextLine();
							System.out.println("\nAdd Appointment Decription ! \n");
							String apptDesc = new Scanner(System.in).nextLine();
							eventListG.add(new Event(userDay,userMonth,userYear,timeSlots[timeslot],apptTitle,apptDesc));
						}
						else{
							System.out.println("Hello, you have already added Event : "+ eventListG.get(i).getAppointmentHeader()+"  for time slot -> "+ eventListG.get(i).getTimeSlot());
						}
					}
					else
					{
						System.out.println("\nAdd Appointment Title ! \n");
						String apptTitle = new Scanner(System.in).nextLine();
						System.out.println("\nAdd Appointment Decription ! \n");
						String apptDesc = new Scanner(System.in).nextLine();
						eventListG.add(new Event(userDay,userMonth,userYear,timeSlots[timeslot],apptTitle,apptDesc));
					}
				}//end of for..
			}
			else
			{
				System.out.println("\nAdd Appointment Title ! \n");
				String apptTitle = new Scanner(System.in).nextLine();
				System.out.println("\nAdd Appointment Decription ! \n");
				String apptDesc = new Scanner(System.in).nextLine();
				eventListG.add(new Event(userDay,userMonth,userYear,timeSlots[timeslot],apptTitle,apptDesc));
			}
		} catch (Exception e) {
			System.out.println("Exception inside addEvents() :"+e.getMessage());
		}

	}

	public static void removeEvents(){
		try {
			System.out.println("\nEnter the day for which you want to remove Events! ");
			int userDay = new Scanner(System.in).nextInt();
			if(eventListG.size()!=0)
			{
				for(int i=0;i<eventListG.size();i++){
					if(eventListG.get(i).getDay() == userDay && eventListG.get(i).getMonth() == userMonth && eventListG.get(i).getYear() == userYear){
						System.out.println("\nEvents for :"+eventListG.get(i).getDay() +" "+months[eventListG.get(i).getMonth()] +" "+ eventListG.get(i).getYear()+"\n");
						for(int j=1; j<timeSlots.length;j++)
						{
							if(timeSlots[j].equals(eventListG.get(i).getTimeSlot())){
								System.out.printf(j+". "+"%s ", timeSlots[j] +" : " +eventListG.get(i).getAppointmentHeader()+"\n");
							}
							else
							{
								System.out.printf(j+". "+"%s ", timeSlots[j] +" : " +" \t");
							}
							if(j%5==0)System.out.println();
						}
					}
				}
			}
			System.out.println("\nFor "+ userDay +" "+ months[userMonth]+ " ,enter a Time Slot number to remove an Event for ! \n");
			int timeslot = new Scanner(System.in).nextInt();
			for(int i=0;i<eventListG.size();i++){
				if(eventListG.get(i).getDay() == userDay && eventListG.get(i).getMonth() == userMonth && eventListG.get(i).getYear() == userYear){
					try {
						eventListG.remove(i);
					} catch (Exception e) {
						System.out.println("Exception inside removeEvents() while removing :"+e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception inside removeEvents() :"+e.getMessage());
		}
	}

	public static void showEvents(){
		try {
			System.out.println("\nEnter the day for which you want to see Events! ");
			int userDay = new Scanner(System.in).nextInt();
			if(eventListG.size()!=0)
			{
				for(int i=0;i<eventListG.size();i++){
					if(eventListG.get(i).getDay() == userDay && eventListG.get(i).getMonth() == userMonth && eventListG.get(i).getYear() == userYear){
						System.out.println("\nEvents for :"+eventListG.get(i).getDay() +" "+months[eventListG.get(i).getMonth()] +" "+ eventListG.get(i).getYear()+"\n");
						for(int j=1; j<timeSlots.length;j++)
						{
							if(timeSlots[j].equals(eventListG.get(i).getTimeSlot())){
								System.out.printf(j+". "+"%s ", timeSlots[j] +" : " +eventListG.get(i).getAppointmentHeader()+"\n");
							}
							else
							{
								System.out.printf(j+". "+"%s ", timeSlots[j] +" : " +" \t");
							}
							if(j%5==0)System.out.println();
						}
					}
					else{
						System.out.println("\nSorry you don't have any events for this day..");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception inside showEvents() :"+e.getMessage());
		}
	}

	public static void addCalendar(){
		try {
			System.out.println("\nEnter month (Eg. 1=Jan,3=March,10=Oct) \n");
			userMonth = new Scanner(System.in).nextInt();
			System.out.println("\nEnter year (Eg. 2018/2020)\n ");
			userYear = new Scanner(System.in).nextInt();
		} catch (Exception e) {
			System.out.println("Exception inside addCalendar() :"+e.getMessage());
		}
	}


	public static int showTimeZones(int timeslot){
		//Here I am considering just 4 timezones.. but it can be improved to add up more.
		int newTimeSlot=0;
		try {
			System.out.println("\nEvent time zone:\n 1. CST\t 2. EST\t 3. MST\t 4.PST\n ");
			int caseTimeZone=0;
			caseTimeZone = new Scanner(System.in).nextInt();
			//check with current time-zone and return appropriate time slot.

			while (true) {
				switch (caseTimeZone) {
				case 1:
					newTimeSlot = checkCurrentTimeZone(userTimeZone, "CST",timeslot);
					break;
				case 2:
					newTimeSlot = checkCurrentTimeZone(userTimeZone, "EST",timeslot);
					break;
				case 3:
					newTimeSlot = checkCurrentTimeZone(userTimeZone, "MST",timeslot);
					break;
				case 4:
					newTimeSlot = checkCurrentTimeZone(userTimeZone, "PST",timeslot);
					break;
				default: System.out.println("\nPlease enter valid choices.\n");

				}
				return newTimeSlot;
			}
		} catch (Exception e) {
			System.out.println("Exception inside showTimeZones():"+e.getMessage());
			return newTimeSlot;
		}
	}

	public static int checkCurrentTimeZone(String userTimeZone,String timeZoneChoice, int timeslot){
		// I am not considering day changes so keeping time-zone options limited only

		try {
			if(userTimeZone == "Central Standard Time")
			{
				if(timeZoneChoice == "CST"){return timeslot;}
				else if(timeZoneChoice == "EST"){
					int temp_timeslot = timeslot-1;
					if(temp_timeslot<=0){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "MST"){
					int temp_timeslot = timeslot+1;
					if(temp_timeslot>=24){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}

				else if(timeZoneChoice == "PST"){
					int temp_timeslot = timeslot+2;
					if(temp_timeslot>=24){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else{
					System.out.println("\nSorry, no valid choice found.\n");
				}
			}
			else if(userTimeZone == "Eastern Standard Time")
			{
				if(timeZoneChoice == "CST"){
					int temp_timeslot = timeslot+1;
					if(temp_timeslot>=24){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "EST"){return timeslot;}
				else if(timeZoneChoice == "MST"){
					int temp_timeslot = timeslot+2;
					if(temp_timeslot>=24){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "PST"){
					int temp_timeslot = timeslot+3;
					if(temp_timeslot>=24){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else{
					System.out.println("\nSorry, no valid choice found.\n");
				}
			}
			else if(userTimeZone == "Mountain Standard Time")
			{
				if(timeZoneChoice == "CST"){
					int temp_timeslot = timeslot-1;
					if(temp_timeslot<=0){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "EST"){
					int temp_timeslot = timeslot-2;
					if(temp_timeslot<=0){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "MST"){return timeslot;}
				else if(timeZoneChoice == "PST"){
					int temp_timeslot = timeslot+1;
					if(temp_timeslot>=24){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else{
					System.out.println("\nSorry, no valid choice found.\n");
				}
			}
			else if(userTimeZone == "Pacific Standard Time"){
				if(timeZoneChoice == "CST"){
					int temp_timeslot = timeslot-2;
					if(temp_timeslot<=0){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "EST"){
					int temp_timeslot = timeslot-3;
					if(temp_timeslot<=0){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "MST"){
					int temp_timeslot = timeslot-1;
					if(temp_timeslot<=0){
						System.out.println("\nSorry, day changes for this timeslot, setting event to current timeslot.\n");
						return timeslot;
					}
					else return temp_timeslot;
				}
				else if(timeZoneChoice == "PST"){return timeslot;}
				else{
					System.out.println("\nSorry, no valid choice found.\n");
				}
			}
			else{
				return timeslot;
			}
			return timeslot;
		} catch (Exception e) {
			System.out.println("Exception inside checkCurrentTimeZone():"+e.getMessage());
			return timeslot;
		}
	}

	public static void main(String[] args) {
		try {
			Calendar now=null;
			TimeZone tz=null;
			
			try {
				now= Calendar.getInstance();
				tz= now.getTimeZone();
				userTimeZone = tz.getDisplayName();
				userYear = now.get(Calendar.YEAR);
				userMonth = now.get(Calendar.MONTH) + 1;
			} catch (Exception e) {
				System.out.println("Exception while getting TimeZone and current Calendar details:"+e.getMessage());
				//setting defaults..
				userTimeZone="";
				userYear = 5;
				userMonth = 2018;
			} 
			
			int caseIndex = 0;
			while(true){

				System.out.println("\nCurrent Time Zone: "+tz.getDisplayName());
				printCalendar();// by default passing the current month and year..
				System.out.println("\nSelect one of the options:" +
						" \n 1. To add events.\n 2. To remove events.\n 3. To show events.\n 4. To change Calendar.\n 0. To exit.\n");
				caseIndex = new Scanner(System.in).nextInt();
				switch(caseIndex){
				case 0: System.exit(1);
				break;
				case 1:	addEvents();
				break;
				case 2:	removeEvents();
				break;
				case 3: showEvents();
				break;
				case 4: addCalendar();
				break;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception inside main_class():"+e.getMessage());
		}
	}//end of main class

}//end of class
