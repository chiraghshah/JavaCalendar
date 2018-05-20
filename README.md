# JavaCalendar
Author: Chirag Shah
Programming Language : Java

Code Structure:
1. The code is split in to two classes named JavaCalendar and Event and a Test class CalendarTest.
2. All the classes are in the format of .java file extensions.
3. The class Event is a constructor class which returns Event Day, Month, Year, Time Slot, Appoiment Name and Description.
This class does not require run time arguments.
4. The class JavaCalendar is a class with main method and consists of methods to find current Calendar, add new Calendar, add new Events,
remove Events and show Event calendars. This class requires run time arguments.

Run Code:
Please follow below steps to run the code:
1. The code is kept in folder in the fashion: ..\calendar\src\main\java\com\chirag\calendar\JavaCalendar.java
2. Import the files in your Eclipse as a maven project.
3. To run the program, exceute JavaCalendar.java and you will see output of following kind : 
Eg.

                Current Time Zone: Central Standard Time

                   May 2018
                 S  M Tu  W Th  F  S
                       1  2  3  4  5 
                 6  7  8  9 10 11 12 
                13 14 15 16 17 18 19 
                20 21 22 23 24 25 26 
                27 28 29 30 31 

                Select one of the options: 
                 1. To add events.
                 2. To remove events.
                 3. To show events.
                 4. To change Calendar.
                 0. To exit.
                 
4. Using the menu options you can either add events/remove/show/ events or change Calendar for a particular day at time. 
5. The add events prompts you with options to select time slot and time zones for user convinience. 
Eg.
				
				Enter for which day you want to set Events! 
				
				25
				
				1. 00:00 - 01:00	 2. 01:00 - 02:00	 3. 02:00 - 03:00	 4. 03:00 - 04:00	 5. 04:00 - 05:00	 
				6. 05:00 - 06:00	 7. 06:00 - 07:00	 8. 07:00 - 08:00	 9. 08:00 - 09:00	 10. 09:00 - 10:00	 
				11. 10:00 - 11:00	 12. 11:00 - 12:00	 13. 12:00 - 13:00	 14. 13:00 - 14:00	 15. 14:00 - 15:00	 
				16. 15:00 - 16:00	 17. 16:00 - 17:00	 18. 17:00 - 18:00	 19. 18:00 - 19:00	 20. 19:00 - 20:00	 
				21. 20:00 - 21:00	 22. 21:00 - 22:00	 23. 22:00 - 23:00	 24. 23:00 - 00:00	
				
				For 25 May ,enter a Time Slot number to set an Event for ! 
				
				12
				
				Do you want to change Time Zone for this Event - Y/N?
				
				y
				
				Event time zone:
				 1. CST	 2. EST	 3. MST	 4.PST
				 
				1

				Add Appointment Title ! 

				Chirag Shah Birthday

				Add Appointment Decription ! 

				Wish him a Happy Birthday!
     
6. You can see set events by selecting option to see events from the menu.
Eg.


        Enter the day for which you want to see Events! 

        25

        Events for :25 May 2018

        1. 00:00 - 01:00 :  	 2. 01:00 - 02:00 :  	 3. 02:00 - 03:00 :  	 4. 03:00 - 04:00 :  	 5. 04:00 - 05:00 :  	 
        6. 05:00 - 06:00 :  	 7. 06:00 - 07:00 :  	 8. 07:00 - 08:00 :  	 9. 08:00 - 09:00 :  	 10. 09:00 - 10:00 :  	 
        11. 10:00 - 11:00 :  	 12. 11:00 - 12:00 : Chirag Shah Birthday
         13. 12:00 - 13:00 :  	 14. 13:00 - 14:00 :  	 15. 14:00 - 15:00 :  	 
        16. 15:00 - 16:00 :  	 17. 16:00 - 17:00 :  	 18. 17:00 - 18:00 :  	 19. 18:00 - 19:00 :  	 20. 19:00 - 20:00 :  	 
        21. 20:00 - 21:00 :  	 22. 21:00 - 22:00 :  	 23. 22:00 - 23:00 :  	 24. 23:00 - 00:00 :  
               
