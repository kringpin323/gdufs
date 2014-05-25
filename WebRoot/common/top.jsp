<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">
<title>物联网智能管理实验室</title>
<link href="css/styletop.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.4.min.js"></script>


<script type="text/javascript">
$(function(){
	
	setInterval(function scopText(){
	$.post('lab_getTemp',function(data){


	$('#scopText').text(data);
	
	},'text')
	},1*60*1000);
	});
	
	
	
</script>
</head>
<body>
<center>
<div id="container">
 <div class="clearfloat"></div>
  
 <div id="banner"></div>
 <div class="clearfloat"></div>
 <div id="nav2">
    

 <table style="margin-top:4px; margin-left:18px; color: #FFF; font-size: 14px">
  <tr >
  <td width="30%">欢迎使用，物联网智能管理实验室</td><td width="5%"></td><td width="30%">
  <marquee behavior="scroll" direction="left" scrollamount="5" style="cursor: auto;" loop="-1" onMouseOver="this.stop()" onMouseOut="this.start()" id="scopText"></marquee>
  
  </td><td width="4%"></td><td  align="right" id="Clock"></td>
  </tr></table> 


 </div>
<div class="clearfloat"></div>
<div id="maincontent">



</div>
</div>
</center>
<script type="text/javascript">

function tick() {
var today=new Date();
var month=today.getMonth()+1; //<!--getMonth显示当前月份-1，所以要+1才能显示当前月份-->
var year, date, hours, minutes, seconds;
var intHours, intMinutes, intSeconds;
var week=new Array() //<!--显示几天为星期几-->
    week[0]="星期日 ";
    week[1]="星期一 ";
    week[2]="星期二 ";
    week[3]="星期三 ";
    week[4]="星期四 ";
    week[5]="星期五 ";
    week[6]="星期六 ";
intHours = today.getHours();
intMinutes = today.getMinutes();
intSeconds = today.getSeconds();
year=today.getFullYear();
date=today.getDate();
var time;
if (intHours == 0) {
 hours = "00:";
} 
else if (intHours < 10) { 
 hours = "0" + intHours+":";
} 
else {
 hours = intHours + ":";
}
if (intMinutes < 10) {
 minutes = "0"+intMinutes+":";
} 
else {
 minutes = intMinutes+":";
}
if (intSeconds < 10) {
 seconds = "0"+intSeconds+" ";
} 
else {
 seconds = intSeconds+" ";
} 
//根据不同的时间显示不同的问候。
//下面采用自己总结的测试纠正法对time进行赋值
time="午夜好";
if(today.getHours()<=22)  time="晚上好!";
if(today.getHours()<=19)  time="傍晚好!";
if(today.getHours()<=17)  time="下午好!";
if(today.getHours()<=14)  time="中午好!";
if(today.getHours()<=12)  time="上午好!";
if(today.getHours()<=8)   time="早上好!";
if(today.getHours()<=5)   time="凌晨好";
timeString=""+year+"年"+month+"月"+date+"日  "+hours+minutes+seconds+week[today.getDay()]+time;
Clock.innerHTML = timeString;
window.setTimeout("tick();", 1000);
}
window.onload = tick;


</script>
</body>
</html>
