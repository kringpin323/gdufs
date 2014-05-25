<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
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
	<link href="css/wu.css" rel="stylesheet" type="text/css" />
<title>用户信息批量导入</title>
<script  src="js/jquery-1.4.min.js"></script>
<script type="text/javascript">

//判断导入文件
function checkFile() {
 //obj是你那个file框
 var obj = document.getElementById('file');
 if(obj.value==''){
  alert('请选择需要导入的excel文档');
}
 var suffix = obj.value.match(/^(.*)(\.)(.{1,8})$/)[3]; 
 if(suffix != 'xls'){
  alert('文件格式不正确！请使用excel文档');
 }else{
 var form= document.getElementById('form1');
 form.submit();
 }
}

</script>
</head>
<body>
<fieldset>用户信息导入：
	<form action="systemManger_importUserInfo" method="post" id="form1"
							enctype="multipart/form-data">
							上传文件:
							<input type="file" id="file"  name="file" />
							<input type="button" value="上传到数据库" onclick="checkFile()"/> &nbsp&nbsp&nbsp<span style="color: red">*上传文件类型必须为.xls(并按要求上传信息)</span>
						</form>
						<br>
						<div style="color:red" align="center">${msg_row}</div>
</fieldset>
  
  <br>
  <br>
  <div>
样表如下：<br>
<table width="100%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <th >用户编号</th>
    <th >密码</th>
    <th >性别</th>
    <th >姓名</th>
    <th >登录模式</th>
    <th >手机</th>
    <th >院系</th>
    <th >专业</th>
    <th >班级</th>
    <th >用户RFID</th>
    <th >状态</th>
    <th>创建日期</th>
    <th>创建人</th>
    <th>用户组</th>
  </tr>
  
  <tr align="center">
    <td>admin<span style="color:red">*</span></td>
    <td>admin</td>
    <td>男</td>
    <td>管理员<span style="color:red">*</span></td>
    <td>(1/2)</td>
    <td>13801380138</td>
    <td>广外信息学院</td>
    <td>网络工程</td>
    <td>1</td>
    <td>12345</td>
    <td>(1/2)<span style="color:red">*</span></td>
    <td>2013-01-15</td>
    <td>admin</td>
    <td>(admin/labAdmin/guest)</td>
  </tr>
  <tr align="center">
    <td colspan="14" style="color:red ">*代表必须填写,( )代表选择的值。</td>
    
  </tr>
   <tr align="center">
    <td colspan="14"><a href="excel/userInfo.xls" >样表下载</a></td> 
  </tr>
</table>  
  
  </div>
  
</body>
</html>


