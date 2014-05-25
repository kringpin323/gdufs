<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>

	<div align="right" >
	
	<table border="1" cellpadding="0" cellspacing="2" width="100%" height="100%"  bgcolor="#D3E3F5">
		<tr align="center">
			<td width="100%" >
				<form action="">
					设备名称：<select>
							<option>PC机</option>
							<option>交换机</option>
							 </select>
					数量：<input type="text">	
					<br/>
					<br/>
					<input type="submit" value="提交">
					<input type="reset" value="取消">	 
				</form>	
			</td>
		</tr>
		
		<tr>
			<td align="center">
						<form action="" method="post"
							enctype="multipart/form-data">
							上传文件：
							<input type="file" name="file1" />
							<input type="submit" value="确认上传" />
						</form>
			</td>
		</tr>
	</table>

	
	</div>
	
</body>
</html>
