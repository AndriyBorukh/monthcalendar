package monthcalendar;
/**
 *
 * @author Андрей
 */
import java.time.Month;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class Monthcalendar {
    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
     printer console_printer = new printer();
     String command="something"; 
     String daysname=  " ПН  ВТ  СР  ЧТ  ПТ  \033[31mСБ  \033[31mНД \u001B[0m";
     calendar newcalendar = new calendar();
     while (!(command.contentEquals("end")))
	{	
	  console_printer.println("do you want to see current month type yes or no, or end for exit  ");
	  Scanner in = new Scanner(System.in);
	  command= in.next();
	  if (command.contentEquals("yes"))
	   {
             console_printer.println (daysname); 
	     YearMonth thisyearmonth =YearMonth.now(); 
	     int year = thisyearmonth.getYear();
	     int month = thisyearmonth.getMonthValue();
	     newcalendar.ShowCalendar(year, month);
             
	   }
          if (command.contentEquals("no"))
	   {
             try
              {
                console_printer.println("enter year and month");
                int year = in.nextInt();
                String monthname = in.next();
                monthname=monthname.toUpperCase();
                Month enteredmonth = Month.valueOf(monthname);
                int month = enteredmonth.getValue() ;
		console_printer.println (daysname);  
		newcalendar.ShowCalendar(year, month);   
              } catch (RuntimeException error)
                 {console_printer.println ("\033[31m  wrong year or month!  \u001B[0m");}	  
           }
	}
    } 
}
