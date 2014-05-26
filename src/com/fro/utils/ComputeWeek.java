package com.fro.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class ComputeWeek {

	
	/** 
     * �����������ڼ���������� 
     *  
     * @param startDate 
     *            ��ʼ���� 
     * @param endDate 
     *            �������� 
     * @return 
     */  
    public static int computeWeek(Date startDate, Date endDate) {  
  
        int weeks = 0;  
  
        Calendar beginCalendar = Calendar.getInstance();  
        beginCalendar.setTime(startDate);  
  
        Calendar endCalendar = Calendar.getInstance();  
        endCalendar.setTime(endDate);  
  
        while (beginCalendar.before(endCalendar)) {  
  
            // �����ʼ���ںͽ���������ͬ�ꡢͬ���ҵ�ǰ�µ�ͬһ��ʱ����ѭ��  
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
        SimpleDateFormat formatD=new SimpleDateFormat("E");//"E"��ʾ"day in week"
        String weekDay="";
        try{
           weekDay=formatD.format(d);
        }catch (Exception e){
           e.printStackTrace();
        }
        //System.out.println("����:"+DateStr+" �� "+weekDay);
       return weekDay;
   }
    
    
   

    	
    	/** 
    	* ������� 
    	* @param d ������ 
    	* @param day ��ӵ����� 
    	* @return ��Ӻ������ 
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
