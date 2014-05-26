package com.fro.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class ComputeWeek {

	
	/** 
     * 计算两个日期间相隔的周数 
     *  
     * @param startDate 
     *            开始日期 
     * @param endDate 
     *            结束日期 
     * @return 
     */  
    public static int computeWeek(Date startDate, Date endDate) {  
  
        int weeks = 0;  
  
        Calendar beginCalendar = Calendar.getInstance();  
        beginCalendar.setTime(startDate);  
  
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.setTime(endDate);  
  
        while (beginCalendar.before(endCalendar)) {  
  
            // 如果开始日期和结束日期在同年、同月且当前月的同一周时结束循环  
            if (beginCalendar.get(Calendar.YEAR) == endCalendar  
                    .get(Calendar.YEAR)  
                    && beginCalendar.get(Calendar.MONTH) == endCalendar  
                            .get(Calendar.MONTH)  
                    && beginCalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) == endCalendar  
                            .get(Calendar.DAY_OF_WEEK_IN_MONTH)) {  
                break;  
  
            } else {  
  
                beginCalendar.add(Calendar.DAY_OF_YEAR, 7);  
                weeks += 1;  
            }  
        }  
  
        return weeks;  
    }  
	
    
    public static String getWeekDay( Date d){
        SimpleDateFormat formatD=new SimpleDateFormat("E");//"E"表示"day in week"
        String weekDay="";
        try{
           weekDay=formatD.format(d);
        }catch (Exception e){
           e.printStackTrace();
        }
        //System.out.println("日期:"+DateStr+" ： "+weekDay);
       return weekDay;
   }
    
    
   

    	
    	/** 
    	* 添加日期 
    	* @param d 现日期 
    	* @param day 添加的天数 
    	* @return 添加后的日期 
    	* @throws ParseException 
    	*/ 
    	public static Date addDate(Date d,long day)  { 

    	long time = d.getTime(); 
    	day = day*24*60*60*1000; 
    	time+=day; 
    	
    	return new Date(time); 

    	} 
    	
    
    
    
    public static void main(String[] args) throws Exception {
    	
//    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//    	
//    	
//    int week=computeWeek(sdf.parse("2013-04-07"),sdf.parse("2013-04-015"));
//    System.out.println(week);
    	
    //	System.out.println(getWeekDay("2013-06-03"));
    	
	}
}
