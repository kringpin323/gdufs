package test;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fro.dao.impl.PaiKeDao;

public class TestPai {

	
	public static void main(String[] args) throws Exception {
		PaiKeDao p=new PaiKeDao();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d=sdf.parse("2013-04-13");
		java.sql.Date date=new java.sql.Date(d.getTime());
		String[][] str=p.getOpenDoor("C507", date);
		System.out.println(str.length);
	}
}
