<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script language="javascript">
function changesel()
{
 frm.tjid.value = "1";
 frm.submit();
}
 
function jump()
{
 frm.tjid.value = "2";
 frm.submit();
}
function fun(id)
{
	alert(id);
	if(confirm("您确定要删除本条通告吗？"))
	{
		$.post(
			'announcedelAnnounce',
			{
				'announce_id':id
			},
			function(msg)
				{
					alert("删除成功!");
					window.location.reload(true);
				}
		);
	}
}
</script>
<body>
	<p id="index-quote">通知列表</p>
	<div id="msg-list-border">
				<s:form name="frm">
					<s:iterator value="AnnounceList" var="list">
						<li><p>
								<span class="first-span-forie"> <a href="announcecheckAnnounce?announce_id=<s:property value="#list.announce_id" />">
										<s:property value="#list.headline" /> </a> 
								</span>	
								<span class="msg-list-date">
										<s:property value="#list.time" /> 
								</span>
								<span class="first-span-forie"> 
								<input type="button"  id="del"   value="删除"   onclick="fun(<s:property value="#list.announce_id" />)"/>
								</span>
						</p></li>
					</s:iterator>
				</s:form>
			
		<p id="msg-list-bottom">

			<span><a href="announcedelNextPageAnnounce">首页&nbsp;&nbsp;|&nbsp;</a></span>
			<s:if test="Page.currentPage > 1">
            <span><a href="announcedelNextPageAnnounce?Page.currentPage=<s:property value="Page.currentPage-1"/>">上一页&nbsp;&nbsp;|&nbsp;</a> </span> 
            </s:if>
            <s:if test="Page.currentPage < Page.totallPages">
            <span><a href="announcedelNextPageAnnounce?Page.currentPage=<s:property value="Page.currentPage+1"/>">下一页&nbsp;&nbsp;|&nbsp;</a> </span> 
            </s:if>
            <span><a href="announcedelNextPageAnnounce?Page.currentPage=<s:property value="Page.totallPages"/>">尾页&nbsp;&nbsp;|</a></span> 
            <span>当前页：<s:property value="Page.currentPage"/></span>
            <span>总页数：<s:property value="Page.totallPages"/></span>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;跳转：</span>
            <s:form action="announcereadAnnounce">
                <s:textfield name="Page.currentPage" id="msg-list-jump" type="text" maxLength="3"/>
                <s:submit type="button" value="确定"/>
            </s:form>
				 
		</p>
        
	</div>
</body>
</html>