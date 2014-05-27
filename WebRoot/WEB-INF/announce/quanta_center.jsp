<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  	<base href="<%=basePath%>">
    <title>quanta_center.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link href="css/reset.css" rel="stylesheet" type="text/css" />
    <link href="css/mystyle0522.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
    <div id="wrap">
    	<div id="fix_main" class="clearfix">
    	
    	</div>
    </div>
    <div id="footer">
    	<div id="footer-content">
    		<h4 class="fl products_h">自主产品</h4>
    		<div class="links fl products">
                <a href="http://www.guangwaidaohang.com" target="_blank"><img src="images/small_logo_daohang.png"></a>
                <a href="http://www.suidaokou.com" target="_blank"><img src="images/small_logo_sdk.png"></a>
                <a href="http://www.watergw.cn" target="_blank"><img src="images/small_logo_dingshui.png"></a>
                <a href="http://www.quantacenter.org/library" target="_blank"><img src="images/small_logo_library.png"></a>
                <a href="http://share.quantacenter.org" target="_blank"><img src="images/small_logo_share.png"></a>
                <a href="http://blog.quantacenter.org" target="_blank"><img src="images/small_logo_blog.png"></a>
            </div>
            <h4 class="fl products_h">友情链接</h4>
            <div class="links fl">
                <a href="http://www.gdufs.edu.cn" target="_blank">广东外语外贸大学</a>
                <a href="http://jsjx.gdufs.edu.cn" target="_blank">思科信息学院</a>
                <a href="http://campus.gdufs.edu.cn" target="_blank">广外地带</a>
                <a href="http://www.i-wui.com" target="_blank">艾维工作室</a>
            </div>
            <p>Copyright © 2006-2012 <a href="http://www.quantacenter.org" target="_blank">Quanta（量子）信息技术服务中心</a></p>
    	</div>
    </div>
  </body>
</html>
