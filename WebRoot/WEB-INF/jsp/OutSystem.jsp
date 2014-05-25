<%@ page language="java" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

<title></title>
 <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	 
</head>

<body>
<script  src="js/jquery-1.4.min.js"></script>
	<script type="text/javascript">
		function a(){
		var IP=$('#IP').val();
			window.top.location = "http://"+IP+"/<%=request.getContextPath()%>";
		}
		setTimeout(a,1);
	</script>
	
	<input value="${IP}" type="hidden" id="IP"/>
</body>
</html>
