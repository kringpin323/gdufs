<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updDoorPwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link href="css/wu.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.4.min.js"></script>
<script type="text/javascript">
	function updDoorPwd(){
	var pwd=$('#pwd').val();
	var pwd2=$('#pwd2').val();
	if(pwd!=pwd2){
	alert("两次密码不相同！ ");
	return;
	}
	var labId=$('#updLabId').val();
	if(confirm("确认修改"+labId+" 密码！ ")){
	}else{
	return;
	}
	
	
	$.ajax({
	type:"post",
	data:{'labId':labId,'pwd':pwd},
	url:"lab_updDoorPwd.action",
	beforeSend: function(XMLHttpRequest){
	},
	success: function(data, textStatus){		
		alert("密码修改成功 ！");
		}, 

	complete: function(XMLHttpRequest, textStatus){
	},
	error: function(){
		alert("修改失败，请稍后重试……");
	}

	});

	}

function initializeDoor(){

	var labId=$('#setLabId').val();
	if(confirm("确认初始化"+labId+" 门襟 ！ ")){
	}else{
	return;
	}
	
	
	$.ajax({
	type:"post",
	data:{'labId':labId},
	url:"lab_initializeDoor.action",
	beforeSend: function(XMLHttpRequest){
	},
	success: function(data, textStatus){		
		alert("门襟初始化成功！  ");
		}, 

	complete: function(XMLHttpRequest, textStatus){
	},
	error: function(){
		alert("初始化失败，请稍后重试……");
	}

	});

}

function reBoot(){

var labId=$('#setLabId').val();

var labId=$('#setLabId').val();
	if(confirm("确认重启"+labId+" 门襟 ！ ")){
	}else{
	return;
	}

	$.ajax({
	type:"post",
	data:{'labId':labId},
	url:"lab_reBoot.action",
	beforeSend: function(XMLHttpRequest){
	},
	success: function(data, textStatus){		
		alert("门襟重启成功！  ");
		}, 

	complete: function(XMLHttpRequest, textStatus){
	},
	error: function(){
		alert("重启失败，请稍后重试……");
	}

	});




}









</script>
  </head>
  
  <body>
    
   <div align="center" style="margin-top: 30px;" >
   门襟密码修改
   <fieldset >
    	实验室 ：<select id="updLabId">
    					<option value="select">请选择……</option>
    					<s:iterator value="labInfos" var="v_lab">
    						<option value="${v_lab.labId }">${v_lab.labDesc }</option>
    					</s:iterator>
    				</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<br>
    	新密码  ： <input id="pwd" type="password" > <br/>
    	密码确认： <input id="pwd2" type="password" > <br/>
    	<input type="button" value="修改密码" onclick="updDoorPwd()">  
    </fieldset>
   </div>
    
    
      <div align="center" style="margin-top: 30px;" >
   门襟设置
   <fieldset >
    	实验室 ：<select id="setLabId">
    					<option value="select">请选择……</option>
    					<s:iterator value="labInfos" var="v_lab">
    						<option value="${v_lab.labId }">${v_lab.labDesc }</option>
    					</s:iterator>
    				</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<br>
    	<input type="button" value="初始化" onclick="initializeDoor()" > &nbsp&nbsp&nbsp&nbsp <input type="button" value="重启"  onclick="reBoot()">
    </fieldset>
   </div>
    
    
    
    
    
  </body>
</html>
