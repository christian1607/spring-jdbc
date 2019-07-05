package pvt.auna.solben.util;

import java.util.Calendar;
import java.util.Date;

public class DateToLetter {
	
	public static String dateMonth(Date date){
		 String result="";
		 Calendar calendar=Calendar.getInstance();
		 calendar.setTime(date);
		 int month=0;
		 
		 try{
		   month=calendar.get(Calendar.MONTH);
		 }catch(Exception ex){}
		 switch(month){
		  case 0:
		    {
		      result="Enero";
		      break;
		    }
		  case 1:
		    {
		      result="Febrero";
		      break;
		    }
		  case 2:
		    {
		      result="Marzo";
		      break;
		    }
		  case 3:
		    {
		      result="Abril";
		      break;
		    }
		  case 4:
		    {
		      result="Mayo";
		      break;
		    }
		  case 5:
		    {
		      result="Junio";
		      break;
		    }
		  case 6:
		    {
		      result="Julio";
		      break;
		    }
		  case 7:
		    {
		      result="Agosto";
		      break;
		    }
		  case 8:
		    {
		      result="Septiembre";
		      break;
		    }
		  case 9:
		    {
		      result="Octubre";
		      break;
		    }
		  case 10:
		    {
		      result="Noviembre";
		      break;
		    }
		  case 11:
		    {
		      result="Diciembre";
		      break;
		    }
		  default:
		    {
		      result="Error";
		      break;
		    }
		 }
		 return result;
		}
}
