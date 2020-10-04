package com.china.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateFormaty {
 
	
	public  static Date stringToDate(String str){
		Date date=null;
      DateFormat df = DateFormat.getDateTimeInstance();	
      try {
		date=df.parse(str);//就是这里的问题
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return date;
	}

	
}
