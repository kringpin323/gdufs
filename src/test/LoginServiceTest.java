package test;


import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.fro.entity.RightInfo;
import com.fro.entity.UserInfo;
import com.fro.entity.UserRight;
import com.fro.service.LoginService;
import com.fro.service.impl.LoginServiceImpl;

public class LoginServiceTest {

	LoginService loginService=new LoginServiceImpl();
	@Test
	public  void testHiber() {
		
			
	Configuration c = new Configuration().configure("hibernate.cfg.xml");
	SchemaExport export=new SchemaExport(c);
	export.create(true, false);
	}
	
	@Test
	public void testfindByCondition(){
		
	
	}
}
