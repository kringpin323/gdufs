<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
20:32:13
羽东 2014/5/27 20:32:13
 <script type="text/javascript" src="js/jquery-1.4.min.js"></script> 
 <script type="text/javascript">
    function fun()
{
	var announce_id = $('#announce_id').val();
	$.post(
		'announcecheckAnnounce',
		{
			'announce_id':announce_id
		},
				function(msg)
				{
				if(msg==1)
				{
					alert("发布成功!");
						CKEDITOR.instances.ckeditor.setData("");
						$('#headline').val("");
						$('#department').val("");
				}
				else
					alert(msg);
		}
	);
}
 </script>

  <head>
  	<base href="<%=basePath%>">
    <title>msg_List.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link href="../../css/reset.css" rel="stylesheet" type="text/css" />
    <link href="../../css/mystyle0522.css" rel="stylesheet" type="text/css" />
    
    <link rel="stylesheet" type="text/css" href="./styles.css">

  </head>
  
  <body>
  	<p id="index-quote">通知列表	</p>
    <div id="msg-list-border">
    	<ul>
    		<li>
    			<p>
    				<span class="first-span-forie">
    				<s:form action="announcecheckAnnounce" method="post">
    				<s:url action="announcecheckAnnounce" var="url">
    					<input type="hidden" id=><s:param name="announce_id" value="AnnounceList[0].announce_id" /></input>
    				</s:url>
    				<s:a href="%{url}">
    				<s:property value="AnnounceList[0].headline" /></s:a> </span>
    				<span class="msg-list-date"><s:property value="AnnounceList[0].time"/></span>
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
