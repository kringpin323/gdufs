<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
 <script type="text/javascript" src="js/jquery-1.4.min.js"></script> 
 

  <head>
  	<base href="<%=basePath%>">
    <title>msg_List.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link href="./css/reset.css" rel="stylesheet" type="text/css" />
    <link href="./css/mystyle0522.css" rel="stylesheet" type="text/css" />
    
    <link rel="stylesheet" type="text/css" href="./styles.css">

  </head>
  
  <body>
  	<p id="index-quote">通知列表	</p>
    <div id="msg-list-border">
    	<ul>
    		<li>
    			<p>
    			<s:form>
    				<a href="announcecheckAnnounce?announce_id=<s:property value="AnnounceList[1].announce_id" />">
    				<s:property value="AnnounceList[0].headline" /></span> 
    				</a>
    				<span class="first-span-forie">
    				
    				<!--  <s:url action="announcecheckAnnounce" var="url">
    					<s:property value="AnnounceList[0].headline" /></span>
    					<s:param name="announce_id" value="AnnounceList[0].announce_id"></s:param>
    				</s:url>-->
    				
    				<span class="msg-list-date">dd<s:property value="AnnounceList[0].time"/></span>
    				</s:form>
    			</p>
    			<hr /> 
    		</li>
    		<li><p><span class="first-span-forie"><s:property value="AnnounceList[1].headline"/></span> <span class="msg-list-date"><s:property value="AnnounceList[1].time"/></span></p><hr /> </li>
    		<li><p><span class="first-span-forie"><s:property value="AnnounceList[2].headline"/></span> <span class="msg-list-date"><s:property value="AnnounceList[2].time"/></span></p><hr /> </li>
    		<li><p><span class="first-span-forie"><s:property value="AnnounceList[3].headline"/></span> <span class="msg-list-date"><s:property value="AnnounceList[3].time"/></span></p><hr /> </li>
    		<li><p><span class="first-span-forie"><s:property value="AnnounceList[4].headline"/></span> <span class="msg-list-date"><s:property value="AnnounceList[4].time"/></span></p><hr /> </li>
    		
    	</ul>
    	
    	<p id="msg-list-bottom">
    		<span><a href="#">首页&nbsp;&nbsp;|&nbsp;</a></span>
    		<span><a href="#">上一页&nbsp;&nbsp;|&nbsp;</a></span>
    		<span><a href="#">下一页&nbsp;&nbsp;|&nbsp;</a></span>
    		<span><a href="#">尾页&nbsp;&nbsp;|</a></span>
    		<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;跳转：</span>
    		<input id="msg-list-jump" type="text" maxLength="3" />
    		<input type="button" value="确定" />
    	</p>
    </div>
  </body>
</html>
