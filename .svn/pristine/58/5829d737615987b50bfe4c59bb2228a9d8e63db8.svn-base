<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>电源控制</title>
<link href="css/bar.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-image: url(image/switchIMG/bg.png);background-repeat: no-repeat;
}
.STYLE1 {font-size: large}
-->
</style>
<script  src="js/jquery-1.4.min.js"></script>
<script  src="js/bar.js"></script>
<script type="text/javascript">
function lightControl(o,l,d){
var labId=$('#labIdHidden').val();
  var url = "lab_startSwitchControl?link="+l+"&action="+o+"&deviceId="+d+"&labId="+labId;
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
/*接收返回消息，并分解为二组数据*/
function gotmessage(){
  if (req.readyState == 4) { 
    if (req.status == 200) { 
      var strResult = unescape(req.responseText);
      var str = strResult.split(',');
      var result = new Array();
      for(var i=0;i<str.length;i++){
        result[i] = new Array();
        result[i]=str[i].split('|');
      }
      setResult(result);
    } else { 
      alert('System Error!'); 
    } 
  } 
}
/*根据结果更改状态一列*/
function setResult(o){
  for(var i=0;i<o.length;i++){
  if(null!=(document.getElementById("light"+(o[i][0])))){
     if(o[i][1]=="off"){ document.getElementById("light"+(o[i][0])).innerText = "关闭";}
      else{document.getElementById("light"+(o[i][0])).innerText = "打开";}}
    }
}


function lightList(labId,deviceType){
	
	$('#labIdHidden').val(labId);	
	
	$.post('lab_lightList',{'labId':labId,'str':deviceType},function(date){
	$('#prompt').hide();
	$('#lightList').html(date);
	$("#chaxun").trigger("click");
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
<form id="form1" name="form1" method="post" action="">
<table width="785">
	<tr><td height="71" colspan="5"></td>
	</tr>
<tr>
  <td height="26" colspan="5" style="height: 33px;width: 750px;background:url(image/switchIMG/dh.png);margin: 0px;padding: 0px;"></td>
</tr>

<tr><td colspan="5"><DIV class="nav">
  <UL>
  <s:iterator value="labInfos" var="lab_Info">
    <LI><A href="javascript:lightList('${lab_Info.labId}','继电器')" >${lab_Info.labDesc}</A></LI>
   </s:iterator>  
  </UL>
</DIV></td></tr>

<tr>
  <td rowspan="2">&nbsp;</td>
  <td width="787">
<div id="lightList" align="center"></div>
</td>
<td width="100" rowspan="2">&nbsp;</td></tr>
<tr><td colspan="5" align="center"> <div id="prompt"><h4 style="color:purple;margin-top: 130px;">温馨提示：<br/>
请选择进入的实验室</h4></div></td></tr>
</table>
</form>
</div>
</body>
<input type="hidden" id="labIdHidden">
</html>
