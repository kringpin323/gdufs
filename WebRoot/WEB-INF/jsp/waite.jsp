<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <title>waite.html</title>
    <script src="ckeditor/ckeditor.js"></script>
	<link href="css/wu.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link href="style.css" rel="stylesheet" type="text/css"/>
	<link href="css/mystyle0522.css" rel="stylesheet" type="text/css" />
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
  </head>
  
  <body>
  <form action="announce!addAnnounce" method="post" id="formA">
    <table id="msg">
      <tr><th colspan="2"><p>发布通知</p></th></tr>
      <tr>
      	<td style="text-align:right; padding-left:30px;">标题：</td>
      	<td style="width:90%;"><input id="msg_title" type="text" name="announce.headline"/></td>
      </tr>
      <tr>
        <td style="text-align:right; padding-left:30px;">内容：</td>
        <td><div style="width:95%;"><textarea id="ckeditor"></textarea><script type="text/javascript">CKEDITOR.replace('ckeditor',{
					// Defines a custom toolbar to be used.
					toolbar : [ [ 'TextColor', 'BGColor', '-',
								 'Bold', 'Italic', 'Underline', 'Strike','-',
								 'NumberedList', 'BulletedList', 'Outdent', 'Indent', 'Blockquote', '-',
								 'JustifyLeft', 'JustifyCenter', 'JustifyRight', '-',
								 'Subscript', 'Superscript', 'SpecialChar', '-',
								 'Source', '-' ],
								 ['Styles', 'Font', 'FontSize', 'Table', 'Image', 'Flash', 'Link', 'Unlink', '-', 'MyButton']],
					resize_enabled  : false,
					height : 330
				});</script></div></td>
      </tr>
      <tr><td colspan="2" style="text-align:right; padding-right:50px;"><input type="submit" value="提交"/ name="announce.context"></td></tr>
    </table>
    </form>
  </body>
</html>
