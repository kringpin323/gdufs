<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'spControl.jsp' starting page</title>
    <link href="css/bar.css" rel="stylesheet" type="text/css" />
    <link href="css/wu.css" rel="stylesheet" type="text/css" />
    <script  src="js/bar.js"></script>
    <script  src="js/jquery-1.4.min.js"></script>
    <script type="text/javascript">
  
    
    
       $(function(){     
       $("A").click(function () {
              
                 $("A").css("color","white").css("font-weight","normal");
                $(this).css("color","blue").css("font-weight","bold"); 
            });
});
    
    </script>
  </head>
  
  <body>
   
   <DIV class="nav">
  <UL>
  <s:iterator value="spss" var="v_sp">
    <LI ><A href="http://${v_sp.sessionParameterPK.sessionValue}" style="color:white" target="mainFrame">${v_sp.labId}${v_sp.sessionName}</A></LI>
  </s:iterator>
  </UL>
</DIV>
   <div style="margin-top: 200px;margin-left:200px">温馨提示：<br/>首次使用，请允许安装插件，否则不能正常使用！</div>
   
  </body>
</html>
