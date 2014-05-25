<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>自定义课时</title>
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



	$('#addClasshour').click(function(){
	var q=$('#q').val()+'';
	var b=$('#b').val()+'';
	var s=$('#s').val()+'';
	var g=$('#g').val()+'';
	var q2=$('#q2').val()+'';
	var b2=$('#b2').val()+'';
	var s2=$('#s2').val()+'';
	var g2=$('#g2').val()+'';
	
	
		var startTime=q+b+":"+s+g;
		
		
		var endTime=q2+b2+":"+s2+g2;
		$.post('paike!addClasshour',{'startTime':startTime,'endTime':endTime},function(data){
		
		alert('自定义课时成功!');
		
		})
	
	
	});
	
	
	$('#preview').click(function(){
	
	$.post('paike!preview.action',function(data){
		$('#classhourInfo').html(data);
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
	$.post('paike!deleteByChoose',{'str':str},function(data){
	
	alert("成功删除"+data+"条记录");
	$("#preview").trigger("click");
	
	},'text')
	
	
	});



	$('#sureModify').click(function(){
	var classhourID=$('#hid').val();
	var beginDate=$('#beginDate'+classhourID).val();
	var endDate=$('#endDate'+classhourID).val();
	
	$.post('paike!sureModify.action',{'ch.classhourId':classhourID,'ch.beginDate':beginDate,'ch.endDate':endDate},function(date){
	
	alert('成功修改'+date+'条记录');
	$("#preview").trigger("click");
	},'text')
	
   });
	



});

function upd(e){

	if(confirm('确定更新选中用户信息?')){
	}else{
	return;
	}
	$('#hid').val(e);
	$('#sureModify').attr("disabled",false);
	$('#beginDate'+e).removeAttr('readonly');
	$('#endDate'+e).removeAttr('readonly');
	
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
<div align="center">
自定义课时
	<fieldset >
			开始时间：<select id="q">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
					</select>
			<select id="b">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>
			：<select id="s">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<select id="g">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select><br>
			结束时间：<select id="q2">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
					</select>
			<select id="b2">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>
			：<select id="s2">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			<select id="g2">
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
			</select>
			<br>
			<input type="button" id="addClasshour"  value="确认">
	</fieldset>
	</div>
	<p>&nbsp</p>
	
	
	
	<div align="center">
	课时管理<br/>
	<fieldset>
	<label>
	<input type="checkbox" id="allChoose" /> 全选
	</label>
  <label>
  <input type="button"  value="多项删除" id="delete" disabled="disabled" />
  </label>
  <label>
  <input type="button"  value="课时预览" id="preview"/>
  </label>
  <div  id="classhourInfo"></div>
  <div align="center" id="yc" style="display: none"><input type="button"  width="34%" id="sureModify" value="确认修改" disabled="disabled" /></div>
	</fieldset>
	</div>
<input type="hidden" id="hid" value="">
	
	
</body>

</html>



