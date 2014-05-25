<%@ page language="java" import="java.util.*" pageEncoding="GB18030" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="css/wu.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="js/jquery-1.4.min.js"></script> 
<script type="text/javascript">



function labStatusSet(labId){

if(confirm("确定切换 "+labId+" 运行模式吗？")){

}else{
return;
}

$.ajax({
type:'post',
data:$("#"+labId).serialize(),
url:'systemManger_labStauSet',
success:function(data, textStatus){

alert('实验室 '+labId+" 状态设置成功！");

},

error:function(){
alert('状态设置失败！');

}
});

}


$(function(){

	// 2  加载页面后  查询所有实验室的运行模式状态  遍历在页面  使用户打开页面 呈现出当前实验室的运行模式
	
	$.post('systemManger_labJson',function(data){
	
	for(var i=0;i<data.length;i++){
	//判断  运行模式如果为 1 则 为管理员模式   如果为 2 则为自动导航模式
	

		if(data[i].navigateMode=='1'){
	
	$('#admin'+data[i].labId).attr("checked",true);
	
	}else{

	$('#auto'+data[i].labId).attr("checked",true);
	}
	
	
	
	
	}
	
	
	
	
	},'json')




} );






</script>

</head>
<body style="margin-left: 15px;margin-top: 20px;"> 



<s:iterator value="labInfos" var="lab_lab" status="st">


<div style="display: block;float: left;border-color: #ccc;">
<fieldset style="width:220px;height:80px;"> 
<legend>实验室   <span style="font-weight:bold;color:red;">${lab_lab.labId}</span> 运行模式设定</legend>
<form  id="${lab_lab.labId}">
<input type="hidden" name="labId"   value="${lab_lab.labId}">
	<table border="0" cellpadding="0" cellspacing="0" >
		<tr><td><input type="radio" name="modelSet" id="admin${lab_lab.labId}"  value="1"> 管理员模式</td></tr>
		<tr><td><input type="radio" name="modelSet" id="auto${lab_lab.labId}" value="2"> 自动导航模式</td></tr>
		<tr><td ><input type="button" onclick="labStatusSet('${lab_lab.labId}')"  value="设置" ></td></tr>
	</table>
</form>
 </fieldset> 
</div>
 </s:iterator>

  
  
</body>
</html>


