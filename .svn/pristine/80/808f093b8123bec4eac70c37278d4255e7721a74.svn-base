<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户信息文本输入</title>
<link href="css/wu.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css"></link>
<script  src="js/jquery-1.7.min.js"></script>
 <script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript">

function del(e){

	if(confirm('确定停止此用户登录权限?')){
	}else{
	return;
	}

	 var url = "systemManger_deleteByUserId?userId="+e;
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
	
	function toDoorRight(userName,userId,rfid)
	{
	if(rfid==''){
	alert('该用户rfid号为空,不能执行门襟权限设置!');
	return;
	}else{
		
	$('#doorUserName').val(userName);
	$('#doorUserName').attr('disabled','disabled');
	$('#doorRFID').val(rfid);	
	$('#doorUserId').val(userId);	
	$('#dialog').dialog({
		title:'门襟权限设置',
    	autoOpen:true,
        modal:true
       });
       $('#dialog').dialog('open');
	}
	
	
	}
	
	
	function addDoorNum(){
		//添加门襟权限
		var doorRFID=$('#doorRFID').val();
		var doorNum=$('#doorNum').val();
		var userId=$('#doorUserId').val();
		$.post('systemManger_addDoorNum',{'doorRFID':doorRFID,'doorNum':doorNum,'userId':userId},function(data){
			alert(data);
			 $('#dialog').dialog('close');
			
		},'text')
		
	}
	
	function deleteDoorNum(){
		//删除门襟权限
		var doorRFID=$('#doorRFID').val();
		var doorNum=$('#doorNum').val();
		$.post('systemManger_deleteDoorNum',{'doorRFID':doorRFID,'doorNum':doorNum},function(data){
			alert(data);
			 $('#dialog').dialog('close');
		},'text')
		
	}
	
	
	
	function open(e){
	
	if(confirm('确定开启此用户登录权限?')){
	}else{
	return;
	}
	
	$.post('systemManger_openByUserId',{'userId':e},function(data){
	
	 var currentPage=parseInt($('#hid').val());
	 f(currentPage);
	alert('开启成功!')
	
	},'text')
	
	
	}
	
	
	
	function upd(e){
	
	if(confirm('确定修改此用户信息?')){
	}else{
	return;
	}
	
	$('#addUserInfo').attr('disabled','disabled');
	$('#updUserInfo').removeAttr('disabled');
	
		$('#userId').val('');
		$('#password').val('');
		$('#userName').val('');
		$('#sex').val('');
		$('#mobile').val('');
		$('#RFID').val('');
		$.post('systemManger_findByUserId',{'userId':e},function(data){
		
		
		$('#userId').val(data.userId);
		$('#userId').attr('disabled','disabled');
		$('#password').val(data.password);
		$('#userName').val(data.userName);
		$('#mobile').val(data.mobile);
		$('#RFID').val(data.rfid);
		if(data.sex=='男'){
		
		$('#man').attr('checked','checked');
		}else{
		
		$('#woman').attr('checked','checked');
		}
		
		var department=document.getElementById('department');
		var options=department.options;
		for(var i=0;i<options.length;i++){
		if(data.department==options[i].value){
		options[i].selected=true;
		}
		}
		
		var major=document.getElementById('major');
		var op=major.options;
		for(var i=0;i<op.length;i++){
		if(data.major==op[i].value){
		op[i].selected=true;
		}
		}
		
		var className=document.getElementById('className');
		var ops=className.options;
		for(var i=0;i<ops.length;i++){
		if(data.class_==ops[i].value){
		ops[i].selected=true;
		}
		}
		$('#ddd').hide();
		},'json')

}



function gotmessage(){
  if (req.readyState == 4) { 
    if (req.status == 200) { 
      var str=req.responseText;
      alert("操作成功!!");
      var currentPage=parseInt($('#hid').val());
	 f(currentPage);
     
    }
  } 
}


	function firsPage(){
	var	currentPage=1;
	f(currentPage);
 }
	
	function nextPage(){
	var currentPage=parseInt($('#hid').val());
	currentPage=currentPage+1;
	f(currentPage);
	
}
	function prevPage(){
	var currentPage=parseInt($('#hid').val());
	currentPage=currentPage-1;
	f(currentPage);
}
	
	function lastPage(){
	var currentPage=parseInt($('#hid1').val());
	f(currentPage);
	
}
	function toExcel(){

	var ch=$("input:checkbox:checked");
	var str='';
	ch.each(function(i){      
    str=str+$(this).val()+",";
   });
	
	if(str==''){
	alert('未选中导出的对象');
	return;
	}
		
		var IP=$('#IP').val();
		window.top.location = encodeURI("http://"+IP+"/<%=request.getContextPath()%>/systemManger_toExcel?str="+str);
		
		}

	
	function f(e){
	
	$('#findByCondition').disabled=false;
		var department=$('#department2').val();
		var major=$('#major2').val();
		var rightId=$('#rightId2').val();
		var userName=$('#userName2').val();
		var userId=$('#grade').val();
		$.post('systemManger_findByCondition',
		{'currentPage':e,'userInfo.department':department,'userInfo.major':major,'userInfo.userName':userName,'userInfo.rfid':rightId,'userInfo.userId':userId},
		
		function(data){
		$('#recodes').html(data);
		
			$('#findByCondition').disabled=true;
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
	
	
	



$(function(){

	var arr=[false,false];
$('#addUserInfo').click(function(){
	if(arr[0]==false||arr[1]==false){
	alert("姓名或用户名填写不正确 ");
	return;
	}
	var userId=$('#userId').val();
	var password=$('#password').val();
	var userName=$('#userName').val();
	var sexObject=document.getElementsByName("sex");
	var sex;
	for(var i=0;i<sexObject.length;i++){
	
	if(sexObject[i].checked){
	sex=sexObject[i].value;
	break;
	
	}
	
	}
	
	
	var mobile=$('#mobile').val();
	var department=$('#department').val();
	var major=$('#major').val();
	var className=$('#className').val();
	var groupId=$('#rightId').val();
	var RFID=$('#RFID').val();
	
	
	$.post('systemManger_addUserInfo.action',{'userInfo.rfid':RFID,'userInfo.userId':userId,'userInfo.password':password,'userInfo.userName':userName,'userInfo.sex':sex,'userInfo.mobile':mobile,
	'userInfo.department':department,'userInfo.major':major,'userInfo.class_':className,'groupId':groupId},function(data){
		if(data=='exception'){
		var IP=$('#IP').val();
		 window.location.href='http://'+IP+'/<%=request.getContextPath()%>/systemManger_exception';
		}else{
		alert("添加用户成功!");
		}
		
		$('#userId').val('');
		$('#password').val('');
		$('#userName').val('');
		$('#sex').val('');
		$('#mobile').val('');
		$('#u_Msg').text('');
		$('#RFID').val('');
		arr[0]=false;
		arr[1]=false;
		},'text')
	

});

$('#userId').blur(function(){
$('#u_Msg').text('');
	var userId=$('#userId').val();
	if(userId==""){
	alert("帐号不能为空!");
	return;
	}
	
	$.post('systemManger_checkUserId',{'userId':userId},function(data){
	if(data=='0'){
	$('#u_Msg').text('*帐号可用');
	arr[0]=true;
	}else{
	$('#u_Msg').text('*帐号不可用');
	}
	
	},'text')

});

$('#userName').blur(function(){
var userName=$('#userName').val();
if(userName==""){
alert("姓名不能为空");
return;
}
arr[1]=true;

});

$('#updUserInfo').click(function(){
	var userId=$('#userId').val();
	var password=$('#password').val();
	var userName=$('#userName').val();
	var sexObject=document.getElementsByName("sex");
	var sex;
	for(var i=0;i<sexObject.length;i++){
	
	if(sexObject[i].checked){
	sex=sexObject[i].value;
	break;
	
	}
	
	}
	
	
	var mobile=$('#mobile').val();
	var department=$('#department').val();
	var major=$('#major').val();
	var className=$('#className').val();
	var rightId=$('#RFID').val();
	
	
	$.post('systemManger_updUserInfo',{'userInfo.userId':userId,'userInfo.password':password,'userInfo.userName':userName,'userInfo.sex':sex,'userInfo.mobile':mobile,
	'userInfo.department':department,'userInfo.major':major,'userInfo.class_':className,'userInfo.rfid':rightId},function(data){
		
		
		$('#userId').val('');
		$('#password').val('');
		$('#userName').val('');
		$('#mobile').val('');
		$('#RFID').val('');
		$('#ddd').show();
		
	$('#updUserInfo').attr('disabled','disabled');
	$('#addUserInfo').removeAttr('disabled');
	$('#userId').removeAttr('disabled');
		
		alert(data);
		
		
		},'text')
	

});




	$('#fresh').click(function(){
	var currentPage=1;
		f(currentPage);
	});
	
	

	
	$('#findByCondition').click(function (){
		var currentPage=1;
		f(currentPage);
		
	});
	
	$('#choose').click(function (){
	
	if(confirm('确定删除选中用户信息?')){
	}else{
	return;
	}
	var ch=$("input:checkbox:checked");
	var str='';
	ch.each(function(i){      
    str=str+$(this).val()+",";
   });
	
	if(str==''){
	alert('未选中删除的对象');
	return;
	}
	
	
	$.post('systemManger_deleteByChoose',{'str':str},function(data){
		
		 alert("成功删除"+data+"记录");
    		 var currentPage=parseInt($('#hid').val());
	 	f(currentPage);
		
		},'text')
	

	});
	
	$('#major').change(function(){
	$('#opt').siblings().remove();
	$('#opt').remove();
	var major=$('#major').val();
	$.post('paike!getClaByMajor.action',{'major':major},function(data){
	

	var arr=data.split(',');
	for(var i=0;i<arr.length;i++){
	
	if(arr[i]!=""){
		$('#className').append('<option id="opt" value='+arr[i]+'>'+arr[i]+'</option>');
	}
    	}
	
	
	},'text')
	
	
	});
	
	
	
	});


</script>

</head>



<body>
用户信息操作
<form action="systemManger_updUserInfo" id="form1" method="post">
<table border="1" width="95%" cellpadding="0" cellspacing="0">
<tr>
<td width="586" >


  帐号：
    <input type="text" id="userId" name="userInfo.userId"/>   
    <label></label> 
  （包括学号 .工号）<span style="color:red" id="u_Msg"></span>
  <br />
   密码：
  
  <label>
  <input type="text" id="password" name="userInfo.password" />
  </label>
  <br />
  姓名：
  <label>
  <input type="text" id="userName" name="userInfo.userName"/>
  </label>
  性别：

  <input type="radio"  name="sex" value="男"  id="man"/>
  
  男
  <input type="radio" name="sex" value="女" id="woman"/>
 
  女
  <br />
  手机：
  <label>
  <input type="text" id="mobile" name="userInfo.mobile" />
  </label>
  <br />
卡号： <input type="text" id="RFID"/> <br>
  院系：
  <label>
  <select name="userInfo.department" id="department" >
  <s:iterator value="departmentInfos" var="d">
    <option value="${d.department}" >${d.department}</option>
  </s:iterator>
  </select>
  </label>
  <br />
  专业： 
  <select name="userInfo.major" id="major">
  <s:iterator value="majorInfos" var="m">
    <option value="${m.major}">${m.major}</option>
  
   </s:iterator>
  </select>
  <br />
  班级：   
  <select name="userInfo.class_" id="className" >
  </select>
  <br />
 <div id="ddd" > 权限：
  <select name="userInfo.right.rightId" id="rightId">
  
  <s:iterator value="rightInfos" var="r">
    <option value="${r.groupId }">${r.groupName }</option>
  </s:iterator>
  
  </select>
  </div>
  <br>
  <input type="button" value="添加用户" id="addUserInfo">
	<input type="button" value="更新用户" id="updUserInfo" disabled="disabled">
</td>
</tr>
</table>
</form>
<br/>
用户列表
<table border="1" width="95%" cellpadding="0" cellspacing="0"><tr><td >
院系:<select  id="department2" >
	<option value=""> 全部 </option>
  <s:iterator value="departmentInfos" var="d">
    <option value="${d.department}">${d.department}</option>
  </s:iterator>
  </select>
专业：<select  id="major2">
	<option value=""> 全部 </option>
  <s:iterator value="majorInfos" var="m">
    <option value="${m.major}">${m.major}</option>
  </s:iterator>
  </select>
姓名：<input type="text" size="10" id="userName2"/> 
卡号：<input type="text" size="10" id="rightId2"/> 
年级：<input type="text" size="4" id="grade">
<input value="查找" type="button" id="findByCondition"/>
<br/>
</td>
</tr>
<tr><td><input value="删除选中用户" type="button" id="choose"/><input value="刷新" type="button" id="fresh"  />
<br/>


<div id="recodes" align="center"></div>
</td></tr>


</table>

<div id="pop" style="border:1px solid #CCC;display:none;">test<br /><a href="javascript:hidePop();">hide</a></div>


<div id="dialog" style="display: none;">
	姓名：<input id="doorUserName"/> <input id="doorRFID" type="hidden"/> <input id="doorUserId" type="hidden"/><br/>
	
	选择实验室：<select id="doorNum">
					<s:iterator value="labInfos" var="v_lab">
						<option value="${v_lab.labId}">${v_lab.labDesc}</option>
					</s:iterator>
				</select>
				<br/>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button"  onclick="addDoorNum()" value="添加"/> &nbsp &nbsp <input type="button"  onclick="deleteDoorNum()" value="删除"/>

</div>


<input value="${IP}" id="IP" type="hidden">
</body>

</html>



