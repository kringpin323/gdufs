<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  	<base href="<%=basePath%>">
    <title>msg_List.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link href="../../css/reset.css" rel="stylesheet" type="text/css" />
    <link href="../../css/mystyle0522.css" rel="stylesheet" type="text/css" />
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>
  
  <body>
  	<p id="index-quote">通知列表</p>
    <div id="msg-detail-border">
    	<div id="msg-detail-top">
    	
    	<p><s:property value="announces.headline"/></p></div>
    	<div id="msg-detail-content"><s:property value="announces.context"/></div>
    	<div id="msg-detail-jump">
    		<p><a href="#">上一条：关于举办首届广外-香港理工多元识读论坛通知</a><p>
    		<p><a href="#">下一条：关于举办首届广外-香港理工多元识读论坛通知增长增长增长增长增长</a></p>
    	</div>
    </div>
  </body>
</html>
