<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" pageEncoding="utf-8" %>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>主页</title>
<link href="css/bar.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-image: url(image/doorIMG/BGsafedoor.png);background-position:top;
}
.STYLE1 {font-size: large}
-->
</style>
<script  src="js/bar.js"></script>
<script  src="js/jquery-1.4.min.js"></script>
<script type="text/javascript">
$(function(){


});


function doorControl(o,l,d){
var labId=$('#labIdHidden').val();
  var url = "lab_startDoorControl?linkStr="+l+"&action="+o+"&deviceId="+d+"&labId='"+labId+"'";
  if (window.XMLHttpRequest) { 
    req = new XMLHttpRequest(); 
  }else if (window.ActiveXObject){ 
    req = new ActiveXObject("Microsoft.XMLHTTP"); 
  } 

  if(req){ 
     req.open("GET",url, true); 
     req.onreadystatechange = gotmessage; 
     req.send(null); 
}
}
function gotmessage(){
  if (req.readyState == 4) { 
    if (req.status == 200) { 
      var strResult = unescape(req.responseText);
      alert(strResult);
    } else { 
      alert('System Error!'); 
    } 
  } 
}

function doorList2(labId,deviceType){
	$('#labIdHidden').val(labId);

	$.post('lab_doorList2',{'labId':labId,'str':deviceType},function(date){
	
	$('#doorList').html(date);
	})
	
	}

   $(function(){     
       $("A").click(function () {
              
                 $("A").css("color","white").css("font-weight","normal");
                $(this).css("color","blue").css("font-weight","bold"); 
            });
});

</script>
</head>
<body>
<div align="center">
    <table>
      <tr>
        <td height="260" colspan="5">
        
        <DIV class="nav">
  <UL>
  <s:iterator value="labInfos" var="lab_Info">
    <LI><A href="javascript:doorList2('${lab_Info.labId}','门襟')" >${lab_Info.labDesc}</A></LI>
   </s:iterator>  
  </UL>
</DIV>
        </td>
      </tr>
      <tr>
        <td width="130" height="60">&nbsp;</td>
		
       
	<td align="left" width="190px"><div id="doorList" ></div></td>
		
		<td width="310">

		</td>
        <td width="40px">
        		<br /><br /><br /><br /><br/><br/><br/>
		<input name="stateD" type="button" id="stateD" style="height: 65px;width: 52px;background:url(image/doorIMG/gmzt.png);margin: 0px;padding: 0px;border: none;" align="bottom"/>
		</td>
		<td width="98">&nbsp</td>
      </tr>
      <tr>
        <td height="20" colspan="5">&nbsp;</td>
      </tr>
    </table>
</div>
<input type="hidden" id="labIdHidden"/>
</body>
</html>
