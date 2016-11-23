package monthcalendar;
/**
 *
 * @author Андрей
 */
import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class calendar  {
 static final int daysinweek=7;
 static final int weekdays=5;
 static final int firsttwosimbolsnumber=10;
 public calendar() 
 {
 }
 static LocalDate now  ()
    {    LocalDate datenow=LocalDate.now();
    	return datenow;
    }
public   void ShowCalendar(int year,int month)
 {
  printer Printer = new printer();   
  YearMonth calendaryearmonth=YearMonth.of(year, month);
  int numberofday=1;
  int daycount =1;
     LocalDate today =now();
     
  LocalDate date= LocalDate.of(calendaryearmonth.getYear(),calendaryearmonth.getMonth(),1);
  while ( (date.getDayOfWeek() !=DayOfWeek.of(numberofday)  ))
    {
      Printer.print(' '); 
      Printer.print(' ');
      Printer.print(' ');
      Printer.print(' ');
      numberofday++;
    }   
  while (daycount<=calendaryearmonth.lengthOfMonth()) 
    {
     if (numberofday<=daysinweek)
      {  
        Printer.print(' ');
	if (daycount<firsttwosimbolsnumber)
	  Printer.print(' ');
        if (numberofday>weekdays )
        { Printer.print ("\033[31m"+ daycount+ "\u001B[0m" );}
	 else
            if ( (today.getYear()==date.getYear())&&(today.getMonthValue()==date.getMonthValue())&&(today.getDayOfMonth()==daycount) )
            {Printer.print( "\033[32m"+ daycount+ "\u001B[0m"  );}
             else
               {Printer.print( daycount );} 
        Printer.print(' ');
	numberofday++;
      }
     if (numberofday>daysinweek)
      {
	Printer.println (' ');
	numberofday=1;
      }
     daycount++;
    }
   Printer.println(' ');
  }
}
