<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>传感器参数管理</title>
    <link href="css/wu.css" rel="stylesheet" type="text/css" />
</head>
  <script type="text/javascript" src="js/jquery-1.4.min.js"></script>

  <script type="text/javascript">

  function fun1()
  {
  		var d =$('#deviceId').val();
  		
  		if($('#sessionValue').val()==""){
  		alert("参数值不能为空!");
  		return;
  		
  		}
  		
  	$.post(
  		'can!addCanshu.action',
  		{
  			'sp.sessionParameterPK.deviceId':d,
  			'sp.sessionParameterPK.sessionValue':$('#sessionValue').val(),
  			'sp.sessionName':$('#sessionName').val(),
  			'sp.sessionType':$('#sessionType').val(),
  			'sp.labId':$('#labId').val(),
  			'sp.position':$('#position').val(),
  			'sp.status':$('#status').val(),
  			'sp.createBy':$('#createBy').val()
  		},
  		function(msg)
  		{
  			if(msg==1)
  			{
  			alert("添加成功！");
  			$('#deviceId').val("");
  			$('#sessionValue').val("");
  			$('#sessionName').val("");
  			$('#sessionType').val("");
  			$('#position').val("");
  			$('#createBy').val("");
  			}else{
  			alert("传感器参数相同！添加失败！");
  			}
  			
  		}
  	);
  }
  function fun2(page)
  {
 
  	$.post(
  		'can!mohuchaxun.action',
  		{
  			'page':page,
  			'id':$('#DeviceId').val()
  		},
  		function(msg)
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

  function fun3(id,name)
  {
  	$.post(
  		'can!Updateselect.action',
  		{
  			'id':id,
  			'name':name
  		},
  		function(msg)
  		{
  			var aa = msg.split(",");
  			$('#deviceId').val(aa[0]);
  			$('#sessionValue').val(aa[1]);
  			$('#sessionName').val(aa[2]);
  			$('#sessionType').val(aa[3]);
  			$('#labId').val(aa[4]);
  			$('#position').val(aa[5]);
  			$('#status').val(aa[6]);
  			$('#createBy').val(aa[7]);
  		}
  	);
  			document.getElementById('xiugai').disabled=false;
  }
  function fun4()
  {
  		var d =$('#deviceId').val();
  		
  	$.post(
  		'can!Update.action',
  		{
  			'sp.sessionParameterPK.deviceId':d,
  			'sp.sessionParameterPK.sessionValue':$('#sessionValue').val(),
  			'sp.sessionName':$('#sessionName').val(),
  			'sp.sessionType':$('#sessionType').val(),
  			'sp.labId':$('#labId').val(),
  			'sp.position':$('#position').val(),
  			'sp.status':$('#status').val(),
  			'sp.createBy':$('#createBy').val()
  		},
  		function(msg)
  		{
  			if(msg==1)
  			{
  			alert("修改成功！");
  			
  			$('#sessionValue').val("");
  			$('#sessionName').val("");
  			$('#sessionType').val("");  		
  			$('#position').val("");
  			$('#createBy').val("");
  			}else{
  			alert("修改失败！");
  			}
  			
  		}
  	);
  }
   function fun7(page)
 {
 	$.post(
 		'can!mohuchaxun.action',
 		{
 		'page':page,
 		'id':$('#id').val()
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
 function delete1(id,name)
 {
 	$.post(
 		'can!DeleteCan.action',
 		{
 			'id':id,
 			'name':name
 		},
 		function(msg)
 		{
 			alert("删除成功！");
 			fun7($('#page').val());
 		}
 	);
 }
  
  </script> 
  <body>
  <br/>
      <font size="3">添加传感器参数</font><br/>
  <table width="90%" border="1" cellspacing="0">
  <tr>
  	<td>
	设备　名称：<select id="deviceId" style="width:155px">
   				<s:iterator value="ccList" var="c">
   					  <option value="${c.deviceId }" >${c.deviceName }</option>
   				</s:iterator>
   			</select><br/>
   	参　数　值：<input type="text" id="sessionValue"><br/>
   	传感器名称：<input type="text" id="sessionName"><br/>
   	传感器类别：<input type="text" id="sessionType"><br/>
   	实　验　室：<select id="labId" style="width:155px">
   				<s:iterator value="laList" var="l">
   					  <option value="${l.labId }" >${l.labDesc }</option>
   				</s:iterator>
   			</select><br/>
   	传感器位置：<input type="text" id="position"><br/>
   	传感器状态：<select id="status" style="width:155px" >
   					  <option value="Y" >可用</option>
   					  <option value="N" >禁用</option>
   			</select><br/>
   	创　建　人：<input type="text" id="createBy"><br/>
   	<input type="button" value="添加" onclick="fun1()">
   	  	</td>
  </tr>
   	</table>
   	<br/>
   	<font size="3">传感器参数列表</font><br/>
   	<table width="90%" border="1" cellspacing="0">
   		<tr>
   			<td>设备名称：<select id="DeviceId" style="width:155px">
   					<option value="0">--请选择--</option>
   				<s:iterator value="ccList" var="c">
   					<option value="${c.deviceId }" >${c.deviceName }</option>
   				</s:iterator>
   				</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="查找" onclick="fun2(1)"/></td>
   		</tr>
   	</table>
   	<div id="d1"></div>
  </body>
</html>
