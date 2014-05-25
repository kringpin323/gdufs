package com.fro.action;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert{
	public static Date DateConvert(){
		Date dt=null;
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		try {
			dt=ft.parse(ft.format(new Date()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
		
	}
	
}

