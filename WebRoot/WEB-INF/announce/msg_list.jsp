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
    
    <link href="css/reset.css" rel="stylesheet" type="text/css" />
    <link href="css/mystyle0522.css" rel="stylesheet" type="text/css" />
    
    <link rel="stylesheet" type="text/css" href="./styles.css">

  </head>
  
  <body>
  	<p id="index-quote">通知列表</p>
    <div id="msg-list-border">
    	<ul>
    		<li>
    			<p>
    				<span class="first-span-forie"><a href="#">我校论文获省高校党建研究会征文一等奖我校论文获省高校党建研究会征文一等奖我校论文获省高校党建研究会征文一等奖我校论文获省高校党建研究会征文一等奖我校论文获省高校党建研究会征文一等奖</a> </span>
    				<span class="msg-list-date">2014-05-24</span>
    			</p>
    			<hr /> 
    		</li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><hr /> </li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><p><hr /> </li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><p><hr /> </li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><p><hr /> </li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><p><hr /> </li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><p><hr /> </li>
    		<li><p><span class="first-span-forie">我校论文获省高校党建研究会征文一等奖</span> <span class="msg-list-date">2014-05-24</span></p><p><hr /> </li>
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
