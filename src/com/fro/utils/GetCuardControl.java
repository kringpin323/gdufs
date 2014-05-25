package com.fro.utils;

import com.fro.entity.DeviceInfo;
import com.fro.order.GuardControl;
import com.fro.service.LabService;
import com.fro.service.impl.LabServiceImpl;

public class GetCuardControl {

	public static  GuardControl getGuardControl(String labId){
		
		LabService lab=new LabServiceImpl();
		DeviceInfo deviceInfo=lab.getDeviceInfoByLabId("це╫С",labId);
		GuardControl doorC=new GuardControl(deviceInfo.getDeviceIp(),deviceInfo.getPort());
		
		return doorC;
	}
}
