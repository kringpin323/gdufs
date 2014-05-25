package com.fro.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;



public class HttpUtils {

	public static int getStatus(String url){
		URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
            connection.connect();
 
            InputStream fin = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            StringBuffer buffer = new StringBuffer();
            String temp = null;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
            }
            	System.out.println((buffer.toString()));
                JSONObject jo = new JSONObject(buffer.toString());
                int status= (Integer) jo.get("status");
                return status;
            	
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return 0;
		
	}
	
	public static void main(String[] args) {
		getStatus("http://passport.mygdufs.com/Api/checkIsRight?studentNumber=20111003632&password=yincd520");
	}
	
	
}
