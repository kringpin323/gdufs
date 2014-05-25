<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/jpager.tld"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <script type="text/javascript" src="js/jquery-1.4.min.js"></script> 
 <link href="css/wu.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript">
 function fun2()
{
	var deviceId = $('#deviceId').val();
	var deviceName = $('#deviceName').val();
	if(deviceName==""){
	alert("设备名称不能为空!");
	return;
	}
	var deviceType = $('#deviceType').val();
	var deviceIp = $('#deviceIp').val();
	var port = $('#port').val();
	var labId = $('#labId').val();
	var position = $('#position').val();
	var status = $('#status').val();
	var createBy = $('#createBy').val();
	$.post(
		'shebei!addShebei.action',
		{
		'deviceInfo.deviceId':deviceId,
		'deviceInfo.deviceName':deviceName,
		'deviceInfo.deviceType':deviceType,
		'deviceInfo.deviceIp':deviceIp,
		'deviceInfo.port':port,
		'deviceInfo.labId':labId,
		'deviceInfo.position':position,
		'deviceInfo.status':status,
		'deviceInfo.createBy':createBy
		},
		function(msg)
		{
		if(msg==1)
		{
			alert("添加成功!");
				$('#deviceId').val("");
				$('#deviceName').val("");
				$('#deviceType').val("");
				$('#deviceIp').val("");
				$('#port').val("");
				$('#position').val("");
				$('#createBy').val("");
		}
		}
	);
}
	function fun1(deviceId)
	{
		$.post(
		
		'shebei!Delete.action',
			{'deviceId':deviceId},
			function(msg){
		
			$('#d1').html(msg);
			 
			}
		);
		
	}
	function fun4(td)
	{
		$.post(
			'shebei!select.action',
			{
			'deviceId':td
			},
			function(msg)
			{
				var a = msg.split(",");
				$('#deviceId').val(a[0]);
				$('#deviceName').val(a[1]);
				$('#deviceType').val(a[2]);
				$('#deviceIp').val(a[3]);
				$('#port').val(a[4]);
				$('#labId').val(a[5]);
				$('#position').val(a[6]);
				$('#status').val(a[7]);
				$('#createBy').val(a[8]);
		document.getElementById('xiugai').disabled=false;
		document.getElementById('insert').disabled=true;
			}
		);

	}
function fun5()
{
	var deviceId = $('#deviceId').val();
	var deviceName = $('#deviceName').val();
	var deviceType = $('#deviceType').val();
	var deviceIp = $('#deviceIp').val();
	var port = $('#port').val();
	var labId = $('#labId').val();
	var position = $('#position').val();
	var status = $('#status').val();
	var createBy = $('#createBy').val();
	$.post(
		'shebei!update.action',
		{
	'deviceInfo.deviceId':deviceId,
	'deviceInfo.deviceName':deviceName,
	'deviceInfo.deviceType':deviceType,
	'deviceInfo.deviceIp':deviceIp,
	'deviceInfo.port':port,
	'deviceInfo.labId':labId,
	'deviceInfo.position':position,
	'deviceInfo.status':status,
	'deviceInfo.createBy':createBy
		},
		function(msg)
		{
		if(msg==1)
		{
			alert("修改成功!");
				$('#deviceId').val("");
				$('#deviceName').val("");
				$('#deviceType').val("");
				$('#deviceIp').val("");
				$('#port').val("");
				$('#position').val("");
				$('#createBy').val("");
		document.getElementById('xiugai').disabled=true;
		document.getElementById('insert').disabled=false;
		}
		}
	);
}
 function fun6()
 {
 	var r = /^[0-9]*[1-9][0-9]*$/;
	var str = $('#port').val();
	if(r.test(str)==false)
	{
		alert("格式有误！请输入数字！");
	}
 }
 function fun7(page)
 {
 
 	$.post(
 		'shebei!mohuchaxun.action',
 		{
 		'page':page,
 		'name':$('#name').val(),
 		'labId':$('#labId1').val()
 		},
 		function (msg)
 		{
 			$('#d1').html(msg);
 			var yeshu = $('#yeshu').val();
 			if(page==yeshu)
 			{
 				document.getElementById('xia').disabled=true;
 				document.getElementById('last').disabled=true;
 				document.getElementById('frist').disabled=false;
 				document.getElementById('shang').disabled=false;
 			}
 			if(page<yeshu)
 			{
 				document.getElementById('xia').disabled=false;
 				document.getElementById('last').disabled=false;
 				document.getElementById('frist').disabled=true;
 				document.getElementById('shang').disabled=true;
 			}
 		}
 	);
 }
  function fun8()
 {
 
 
 var name=$('#name').val();
 var labId=$('#labId1').val();
 	$.post(
 	
 		'shebei!mohuchaxun.action',
 		{
 		'page':1,
 		'name':name,
 		'labId':labId
 		},
 		function (msg)
 		{
 			$('#d1').html(msg);
 			var page = $('#page').val();
 			var yeshu = $('#yeshu').val();
 			if(page==1&&yeshu==1)
 			{
 				document.getElementById('frist').disabled=true;
 				document.getElementById('shang').disabled=true;
 				document.getElementById('xia').disabled=true;
 				document.getElementById('last').disabled=true;
 			}
 			if(page==1&&yeshu>1){
 			 	document.getElementById('frist').disabled=true;
 				document.getElementById('shang').disabled=true;
 				document.getElementById('xia').disabled=false;
 				document.getElementById('last').disabled=false;
 			}
 		}
 	);
 	
 }
 function fun9(id)
 {
 	$.post(
 		'shebei!Delete.action',
 		{
 			'deviceId':id
 		},
 		function(msg)
 		{
 			if(msg==1)
 			{
 				alert("删除失败！该设备下有传感器数据！不可删除！");
 			}else
 			
 			{	
 			alert("删除成功 ！");
 			 var pa=$('#page').val();
 					fun7(pa);
					
 				
 			}
 		}
 	);
 }
 
 </script>
  <link rel="stylesheet" href="css/page.css" type="text/css"></link>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加设备</title>
	

  </head>
  
  <body>
  <br/>
  <font size="3">添加设备</font><br/>
  
  <table width="90%" border="1" cellspacing="0">
  <tr>
  	<td>
  	<s:form action="shebei!addShebei.action?page=1" method="post">
  			 <input type="hidden" name="deviceInfo.deviceId" id="deviceId">
   	设备名称：<input type="text" name="deviceInfo.deviceName" id="deviceName"><br/>
   	设备类别：<input type="text" name="deviceInfo.deviceType" id="deviceType"><br/>
   	IP　地址：<input type="text" name="deviceInfo.deviceIp" id="deviceIp"><br/>
   	端  口  号：<input type="text" name="deviceInfo.port" onblur="fun6()" id="port"><br/>
   	实  验  室：<select name="deviceInfo.labId" style="width:155px" id="labId">
   				<s:iterator value="laList" var="l">
   					  <option value="${l.labId }" >${l.labDesc }</option>
   				</s:iterator>
   			</select><br/>
   	位　　置：<input type="text" name="deviceInfo.position" id="position"><br/>
   	设备状态：<select name="deviceInfo.status" style="width:155px" id="status">
   					  <option value="Y" >可用</option>
   					  <option value="N" >禁用</option>
   			</select><br/>
   	创  建  人：<input type="text" name="deviceInfo.createBy" id="createBy"><br/>
   	<input type="button" value="添加" onclick="fun2()" id="insert">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   	<input type="button" id="xiugai" value="确定修改" onclick="fun5()" disabled="true"/>
   </s:form>	
   	  	</td>
  </tr>
   	</table><br/><br/>
   	<font size="3">设备信息</font><br/>
   	<table width="90%" border="1" cellspacing="0">
   		<tr>
   			<td colspan="10">设备名称：<input type="text" id="name" />
   			实验室：<select id="labId1">
   			<option  value="">请选择</option>
   				<s:iterator value="LaList" var="l">
   					<option  value="${l.labId}">${l.labDesc}</option>
   				</s:iterator>
   					</select>
   			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查找" onclick="fun8()"  />
   			</td>
   		</tr>
   		
</table>
<div id="d1"></div>
  </body>
</html>
