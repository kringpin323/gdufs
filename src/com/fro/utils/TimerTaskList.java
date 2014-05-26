package  com.fro.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.Session;

import com.fro.dao.LabDao;
import com.fro.dao.impl.LabDaoImpl;


public class TimerTaskList extends Thread{
	public List<Timer> timer;
	public void updateTask(){
		cancelTask();
	}
	public static void main(String[] args) throws Exception 
	{
	TimerTaskList t = new TimerTaskList();
	t.start();
	}

	public void run(){
		ArrayList<LabParameter> labP = getLabParameter();
		getwork(labP);
		while(true){
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ArrayList<LabParameter> labP_now = getLabParameter();
			
			// 2  ���ڽ����޸�  ��Ҫ�鿴��ʵ���ҵ� ����ģʽ�Ƿ�Ϊ�Զ�����ģʽ
				if(labP_now.size() == labP.size()){
					for(int i=0;i<labP.size();i++){
						//�����ڸô����ж����������޸ģ������˶�operate�ж�
						if(!(labP_now.get(i).labID.equals(labP.get(i).labID)
								&& labP_now.get(i).operateTime.equals(labP.get(i).operateTime)
								&& labP_now.get(i).operate.equals(labP.get(i).operate))){
							try {
								Thread.sleep(20000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							labP=labP_now;
							cancelTask();
							getwork(labP);
						}
					}
				}else{
					labP = labP_now;
					cancelTask();
					getwork(labP);
				}
		}
			}
			
			
			
	
	
	public void getwork(ArrayList<LabParameter> labP)
	{
		timer = new ArrayList<Timer>();
		for(LabParameter lap : labP){
			Timer t = new Timer();
			timer.add(t);
			try {
				MyTask myTask = new MyTask(t,lap);
				System.out.println(lap.operateTime);
				t.schedule(myTask, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(lap.operateTime));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cancelTask(){
		for(int i=0;i<timer.size();i++){
			try{
			timer.get(i).cancel();
			}catch(Exception e){}
		}
	}
	
	public ArrayList<LabParameter> getLabParameter(){
		ArrayList<LabParameter> labP = new ArrayList<LabParameter>();
		Session session=HibernateUtils.getSession();
		Connection conn = session.connection(); 

		try{
	        CallableStatement cstmt = conn.prepareCall("exec dbo.upd_GetDayEntrGuardTime"); 
	        ResultSet rs= cstmt.executeQuery();
	        LabDao labDao = new LabDaoImpl();

	        while(rs.next()){
	        	LabParameter lp = new LabParameter();
	        	
	        	//�ж�һ���Ͽε�ģʽ����
	        	if(rs.getString("UseType").equals("1")){
	        		lp.labID = rs.getString("Lab");
		        	lp.NavigateMode = labDao.getLabInfosByID(rs.getString("Lab")).getNavigateMode();
		        	lp.operateTime = rs.getString("BeginTime");
		        	lp.endTime=rs.getString("Endtime");
		        	lp.operate = "TIMER";//����������  �ϴ�Ȩ��
		        	lp.rfid=rs.getString("UserID");//��Ӹ���ʹ��ʱ�Ŀ���
		        	labP.add(lp);
		        	System.out.println("TIMER"+"-----------------"+lp.operateTime);
		        	
		        	
		        	lp = new LabParameter();
		        	lp.labID = rs.getString("Lab");
		        	lp.NavigateMode = labDao.getLabInfosByID(rs.getString("Lab")).getNavigateMode();
		        	lp.operateTime = rs.getString("Endtime");
		        	lp.operate = "CTIMER";//����������   ɾ��Ȩ��
		        	lp.rfid=rs.getString("UserID");//��Ӹ���ʹ��ʱ�Ŀ���
		        	labP.add(lp);
		        	System.out.println("CTIMER--------------"+lp.operateTime);
		        	
	        	}else{
	        		lp.labID = rs.getString("Lab");
		        	lp.NavigateMode = labDao.getLabInfosByID(rs.getString("Lab")).getNavigateMode();
		        	lp.operateTime = rs.getString("BeginTime");
		        	lp.operate = "OPEN";//��
		        	labP.add(lp);
	        	}
	        	
//	        	int closeDoorDelay=5;
	        	lp = new LabParameter();
	        	lp.labID = rs.getString("Lab");
	        	lp.NavigateMode = labDao.getLabInfosByID(rs.getString("Lab")).getNavigateMode();
	        	lp.operateTime=rs.getString("OrEndTime");
	        	lp.operate = "WARM";//Ԥ��
	        	labP.add(lp);
//	        	java.util.Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString("Endtime"));
//				long nowTime=end.getTime()-closeDoorDelay*60*1000;
//	        	Date d=new Date(nowTime);
//	        	String nowStr=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
//	        	System.out.println(nowStr);
//	        	lp.operateTime=nowStr;
	        	
	        	

	        	lp = new LabParameter();
	        	lp.labID = rs.getString("Lab");
	        	lp.NavigateMode = labDao.getLabInfosByID(rs.getString("Lab")).getNavigateMode();
	        	lp.operateTime = rs.getString("Endtime");
	        	lp.operate = "CLOSE";//�ر�
	        	labP.add(lp);
	        }
	        System.out.println(labP.size()+"-------------------");
			}catch(Exception e){
				e.printStackTrace();
			}
        HibernateUtils.close();
        for(int i=0;i<labP.size()-1;i++){
			try {
				java.util.Date begin = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(labP.get(i).operateTime);
				java.util.Date now_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				java.util.Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(labP.get(i+1).operateTime);
				long between=(end.getTime()-begin.getTime())/60000;	
				//���ڶ��ж�ÿ�������޸ģ��ڸô������Ƿ��Զ������ж�  ***********--------------------**********�������һ���ж�  ��ȡ��operate = "CTIMER"  operate = "TIMER"������
	//			System.out.println(labP.get(i).labID);
				if(((labP.get(i).labID.equals(labP.get(i+1).labID) && between<=0&&!labP.get(i).operate.equals("CTIMER")&&!labP.get(i).operate.equals("TIMER"))
						|| begin.getTime()<now_time.getTime())
						||!labP.get(i).NavigateMode.equals("2")){
					labP.get(i).operate = "CANCEL";
				}
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		return labP;
	}
	class MyTask extends TimerTask
	{
		public Timer timer;
		public LabParameter lp;
		public MyTask(Timer timer ,LabParameter lp){
			this.timer = timer;
			this.lp = lp;
		}
	@Override
	public void run() 
	{
	lp.AutoNavigation();
	System.out.println("run...........719904878............."+lp.operate);
//	timer.cancel();
	}
	}
	}