<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery-1.4.min.js"></script>
	<script type="text/javascript">
		
		
		function toAction(){
		
		$.post('lab_addData',{'newsID':$('#newsID').val(),'news':$('#news').val(),'color':$('#color').val()},function(data){
		});
		}
		
	</script>
	</head>
  
  <body>
    <table>
    	<tr>
    	<td>newsID:<input type="text" id="newsID"/></td>
    	<td>news:<input type="text" id="news"/></td>
    	<td>color:<input type="text" id="color"/></td>
    	<td><input type="button" value="提交到数据库" onclick="toAction()"/></td>
    	</tr>
    </table>
  </body>
</html>
