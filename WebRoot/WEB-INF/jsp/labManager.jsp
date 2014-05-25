<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>实验室管理</title>
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



	$('#addLabInfo').click(function(){
	
	var labId=$('#labId').val();
	if(labId==""){
	alert("实验室名称不能为空！")
	return;
	}
	
	var labDesc=$('#labDesc').val();
	var status=$('#status').val();
	
		$.post('lab_addLabInfo',{'labInfo.labId':labId,'labInfo.labDesc':labDesc,'labInfo.status':status},function(data){
		
		alert('实验室添加成功!');
		
		})
	
	
	});
	
	
	$('#preview').click(function(){
	
	$.post('lab_preview.action',function(data){
		$('#labInfo').html(data);
		$('#delete').attr("disabled",false);
		$('#modify').attr("disabled",false);
		$('#yc').removeAttr("style");
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
	$.post('lab_deleteByChoose',{'str':str},function(data){
	
	alert("成功删除"+data+"条记录");
	$("#preview").trigger("click");
	
	},'text')
	
	
	});



	$('#sureModify').click(function(){
	var labId=$('#hid').val();
	var labDesc=$('#labDesc'+labId).val();
	var status=$('#status'+labId).val();
	
	$.post('lab_sureModify.action',{'labInfo.labId':labId,'labInfo.labDesc':labDesc,'labInfo.status':status},function(date){
	
	alert('成功修改'+date+'条记录');
	$("#preview").trigger("click");
	},'text')
	
   });
	



});


function rightSet(labId){
	if(confirm('确定设置权限?')){
	}else{
	return;
	}



}



function upd(e){

	if(confirm('确定更新此用户信息?')){
	}else{
	return;
	}
	$('#hid').val(e);
	$('#sureModify').attr("disabled",false);
	$('#labDesc'+e).removeAttr('readonly');
	$('#status'+e).removeAttr('readonly');
	
	var ch=$("input:checkbox");
	ch.each(function(){    
   	if($(this).val()==e){
   	$(this).attr("checked","checked");
   	}
   });
}

</SCRIPT>
</head>

<body>
<div align="center" >&nbsp; 
<form action="">
	增加实验室 
	<fieldset >
			实验室名称: <input type="text" id="labId"/><br>
			实验室描述:<input type="text" id="labDesc"><br>
			实验室状态:<SELECT id="status">
				<option value="1"> 实验室可用</option>
							<option value="0"> 实验室停用</option>
						</SELECT>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<br>
			<input type="button" id="addLabInfo"  value="确认">
	</fieldset>
	</form>
	</div>
	<p>&nbsp</p>
	
	
	
	<div align="center">
	实验室管理<br/>
	<fieldset>
	<label>
	<input type="checkbox" id="allChoose" /> 全选
	</label>
  <label>
  <input type="button"  value="多项删除" id="delete" disabled="disabled" />
  </label>
  <label>
  <input type="button"  value="实验室预览" id="preview"/>
  </label>
  <div  id="labInfo"></div>
  <div align="center" id="yc" style="display: none"><input type="button"  width="60%" id="sureModify" value="确认修改" disabled="disabled" /></div>
	</fieldset>
	</div>
<input type="hidden" id="hid" value="">
	
	
</body>

</html>



