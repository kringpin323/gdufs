<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags"  prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户组管理</title>
<link href="css/wu.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.4.min.js"></script>
<SCRIPT type="text/javascript">
$(function(){
	$('#allChoose').toggle(function(){
 	$("input[name='checkbox']:checkbox").each(function(){
            
                $(this).attr("checked",true); 
            })

},function(){
 $("input[name='checkbox']:checkbox").each(function(){
            
                $(this).attr("checked",false);  
               
            })}

);



	$('#addUserGroup').click(function(){
	
	var groupId=$('#groupId').val();
	if(groupId==""){
	alert("用户组编号不能为空！")
	return;
	}
	
	var groupName=$('#groupName').val();
	
		$.post('systemManger_addUserGroup',{'groupInfo.groupId':groupId,'groupInfo.groupName':groupName},function(data){
		
		alert('用户组添加成功!');
		$('#groupId').val('');
		$('#groupName').val('');
		})
	
	
	});
	
	
	$('#preview').click(function(){
	$('#groupUserList').hide();
	$('#toModiyGroup').hide();
	$.post('systemManger_preview.action',{},function(data){
		$('#labInfo').html(data);
		$('#delete').attr("disabled",false);
		$('#modify').attr("disabled",false);
	})
	
	});
	
	
	$('#delete').click(function(){
	
	if(confirm('确定删除选中用户信息?')){
	}else{
	return;
	}
	var ch=$("input:checkbox:checked");
	var str='';
	ch.each(function(){      
    str=str+$(this).val()+",";
   });
	
	if(str==''){
	alert('未选中删除的对象');
	return;
	}
	$.post('systemManger_deleteByChoose2',{'str':str},function(data){
	
	alert(data);
	$("#preview").trigger("click");
	
	},'text')
	
	
	});



	$('#sureModify').click(function(){
	var groupId=$('#groupId').val();
	var groupName=$('#groupName').val();
	$.post('systemManger_sureModify.action',{'groupInfo.groupId':groupId,'groupInfo.groupName':groupName},function(date){
	
	alert('成功修改记录');
	$('#groupName').val('');
	$('#groupId').val('');
	$('#sureModify').attr("disabled",true);
	$('#addUserGroup').attr("disabled",false);
	$('#groupId').attr("disabled",false);
	$("#preview").trigger("click");
	},'text')
	
   });
	



});

function upd(e,m){

	if(confirm('确定更新此用户信息?')){
	}else{
	return;
	}
	$('#groupId').val(e);
	$('#groupId').attr("disabled",true);
	$('#groupName').val(m);
	$('#sureModify').attr("disabled",false);
	$('#addUserGroup').attr("disabled",true);
	
	var ch=$("input:checkbox");
	ch.each(function(){    
   	if($(this).val()==e){
   	$(this).attr("checked","checked");
   	}
   });
}

function GroupUserList(e){
$('#groupUserList').show();
$.post('systemManger_groupUserList.action',{'groupId':e},function(date){
	
	$('#groupUserList').html(date);
	
	})

}


function modiyGroup(u,g){
if(confirm('确定修改此用户信息?')){
	}else{
	return;
	}
	$('#toModiyGroup').show();
$('#hid2').val(u);
$('#hid3').val(g);
$.post('systemManger_toModiyGroup.action',{'groupId':g},function(date){
	
	$('#toModiyGroup').html(date);
	
	$("input[name='cbs']:checkbox").each(function(){
            if(g==$(this).val()){
                $(this).attr("checked",true); 
           }
            }
	)
	
	})
	

}


function sureModiyGroup(){
var UserID=$('#hid2').val();
var groupId=$('#hid3').val();
var ch=$("input[name='cbs']:checkbox:checked");
	var str='';
	ch.each(function(){      
    str=str+$(this).val()+",";
   });
$.post('systemManger_sureModiyGroup.action',{'groupId':groupId,"userId":UserID,"str":str},function(date){
	alert("修改成功!");
	
	},'text')
}

</SCRIPT>
</head>

<body>
<div align="center" >&nbsp; 
<form action="">
	增加用户组
	<fieldset >
			用户组编号:<input type="text" id="groupId"/><br>
			用户组名字:<input type="text" id="groupName"><br>
			<input type="button" id="addUserGroup"  value="确认添加">
<input type="button"  width="60%" id="sureModify" value="确认修改" disabled="disabled" />
	</fieldset>
	</form>
	</div>
	<br/>
	
	<div align="center">
	用户组管理<br/>
	<fieldset>
	<label>
	<input type="checkbox" id="allChoose" /> 全选
	</label>
  <label>
  <input type="button"  value="多项删除" id="delete" disabled="disabled" />
  </label>
  <label>
  <input type="button"  value="用户组预览" id="preview"/>
  </label>
  <div  id="labInfo"></div>
 
	</fieldset>
	</div>
		<div id="toModiyGroup" align="center"></div>
	<br/>
	<div id="groupUserList" align="center"></div>
	
<input type="hidden" id="hid" value="">
<input type="hidden" id="hid2" value="">
<input type="hidden" id="hid3" value="">
	
</body>

</html>



