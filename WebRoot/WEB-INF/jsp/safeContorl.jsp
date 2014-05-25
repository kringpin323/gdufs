<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>安防控制</title>
<link href="css/bar.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	background-image: url(image/safe1/background.png);background-repeat: no-repeat;
}
.STYLE1 {font-size: large}
-->
</style>
<script  src="js/jquery-1.4.min.js"></script>
<script type="text/javascript" src="js/Calendar2.js"></script> 
<script  src="js/bar.js"></script>
<script type="text/javascript">

function safeControl(o,d){
$('#alarm').text('');
  var url = "lab_startSafeControl?action="+o+"&deviceId="+d;
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
      var str = strResult.split('|');
     if(str!=''){
     setResult(str);
     }  
    } else { 
      alert('System Error!'); 
    } 
  } 
}
/*根据结果更改状态一列*/
function setResult(o){
 for(var i=0;i<o.length;i++){
   if(o[0]=='securitySystem'&&o[1]=='on'){
  	$('#open').attr('disabled','disabled');
  	$('#close').removeAttr('disabled');
  	$('#alarm').text('布防状态');
    }else if(o[0]=='securitySystem'&&o[1]=='off'){
    $('#close').attr('disabled','disabled');
  	$('#open').removeAttr('disabled');
  	$('#alarm').text('撤防状态');
    }
  }
}


function safeList(labId,deviceType){
	$('#prompt').hide();
	$.post('lab_safeList',{'labId':labId,'str':deviceType},function(date){
	
	$('#safeList').html(date);
	$("#chaxun").trigger("click");
	})
	
	}

   $(function(){     
       $("A").click(function () {
              
                 $("A").css("color","white").css("font-weight","normal");
                $(this).css("color","blue").css("font-weight","bold"); 
            });
});

function alarmControl(deviceId,currentPage){

	var alarmTime=$('#alarmTime').val();
	var alarmTimeEnd=$('#alarmTime2').val();
	var sessionN=$('#sessionN').val();


	$.post('lab_alarmList',{'deviceId':deviceId,"sessionN":sessionN,"alarmTime":alarmTime,'alarmTimeEnd':alarmTimeEnd,'currentPage':currentPage},function(date){
	
	$('#alarmList').html(date);
	
			var currentPage=parseInt($('#hid').val());
			if(currentPage==1){
			$('#prevPage').remove();
			}	
			
			var totalPage=parseInt($('#hid1').val());
			if((currentPage==totalPage)&&(totalPage!=1)){
			$('#nextPage').remove();
			}
			
			if((currentPage==1)&&(totalPage==1)){
			$('#prevPage').remove();
			$('#nextPage').remove();
			}

	})

}

function alarmControls(deviceId){
	var currentPage=1;
alarmControl(deviceId,currentPage);
}

	function firsPage(){
	var deviceId=$('#sPK').val();
	var	currentPage=1;
	alarmControl(deviceId,currentPage);
 }
	
	function nextPage(){
	var deviceId=$('#sPK').val();
	var currentPage=parseInt($('#hid').val());
	currentPage=currentPage+1;
	alarmControl(deviceId,currentPage);
	
}
	function prevPage(){
	var deviceId=$('#sPK').val();
	var currentPage=parseInt($('#hid').val());
	currentPage=currentPage-1;
	alarmControl(deviceId,currentPage);
}
	
	function lastPage(){
	var deviceId=$('#sPK').val();
	var currentPage=parseInt($('#hid1').val());
	alarmControl(deviceId,currentPage);
	
}



</script>
</head>
<body>
<div align="center">
<form id="form1" name="form1" method="post" action="">
<table width="785">
	<tr><td height="71" colspan="5"></td>
	</tr>
<tr>
  <td height="26" colspan="5" style="height: 33px;width: 750px;background:url(image/safe1/nav.png);margin: 0px;padding: 0px;"></td>
</tr>

<tr><td colspan="5"><DIV class="nav">
  <UL>
  <s:iterator value="labInfos" var="lab_Info">
    <LI><A href="javascript:safeList('${lab_Info.labId}','安防')" >${lab_Info.labDesc}</A></LI>
   </s:iterator>  
  </UL>
</DIV></td></tr>

<tr>
  <td width="95" rowspan="2">&nbsp;</td>
  <td width="787">
<div id="safeList" align="center"></div>



<div id="alarmList" align="center"></div>
</td>
<td width="100" rowspan="2">&nbsp;</td></tr>

<tr><td colspan="5" align="center"> <div id="prompt"><h4 style="color:purple;margin-top: 130px;">温馨提示：<br/>
请选择进入的实验室</h4></div></td></tr>

</table>
</form>
</div>
</body>
</html>
