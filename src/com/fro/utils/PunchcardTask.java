package com.fro.utils;

import java.util.List;

import com.fro.entity.DeviceInfo;
import com.fro.order.GuardControl;
import com.fro.service.LabService;
import com.fro.service.impl.LabServiceImpl;

/**
 * 启动所有实验室门襟记录数的不停查询
 * 
 * @author Administrator
 * 
 */
public class PunchcardTask extends Thread {

	@Override
	public void run() {
		System.out.println("启动门襟数监听");
		startCard();
	}

	/**
	 * 获取所有实验室的门襟信息 进行启动
	 */
	LabService impl = new LabServiceImpl();

	private void startCard() {

		
		
		
		List<DeviceInfo> deviceInfos = impl.getDeviceInfo("门襟");
		for (final DeviceInfo deviceInfo : deviceInfos) {
			new Thread(new Runnable() {
				public void run() {
					doMainByDeviceInfo(deviceInfo);
				}
			}).start();
		}

	}
 
	/**
	 * 根据比较门襟记录来判断是否需要进行打开设备操作
	 * 
	 * @param deviceInfo
	 */

	private void doMainByDeviceInfo(DeviceInfo deviceInfo) {

		while (true) {
			boolean flag = false;
			GuardControl doorC = GetCuardControl.getGuardControl(deviceInfo
					.getLabId());
			
			// 将得到的卡号与此时此个实验室  正在上课的 申请人的rfid进行比较
			String rfid=impl.getRfidByLabId(deviceInfo.getLabId());
			if(rfid!=null){
				
				//获取最后一条记录进行分析   得到刷卡人的卡号    
				String doorNum=impl.getDoorNumByLabId(deviceInfo.getLabId());
				String[] str=doorC.getCardNo(doorNum);
				if(str.length!=1&&str[0].equals(rfid)&&str[1].equals("8")){
					flag=true; 
				}

				if (flag) {
					doWork(deviceInfo.getLabId(), "OPEN");
				} else {
					System.out.println("刷卡人记录无效或无人刷卡！");
				}
				
			}

			
			// 休眠
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
			}

		}

	}

	/**
	 * 打卡信息有效时 进行设备操作
	 */
	private void doWork(String labID, String operate) {
		LabParameter lp = new LabParameter();
		lp.labID = labID;
		lp.operate = operate;
		lp.AutoNavigation();

	}

}
