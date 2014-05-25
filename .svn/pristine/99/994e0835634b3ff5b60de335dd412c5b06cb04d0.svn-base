<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  <head>
    <base href="<%=basePath%>">
    
    <title>实验室排课</title>
    <link href="css/wu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.min.js"></script> 
<script type="text/javascript" src="js/Calendar2.js"></script> 
 <script type="text/javascript">
$(function(){


$('#allChoose').toggle(function(){
 $("input[name='checkbo']:checkbox").each(function(){
            
                $(this).attr("checked",true);
                 $('#allChoose').attr("checked",true);  
                
            })

},
function(){
 $("input[name='checkbo']:checkbox").each(function(){
            
                $(this).attr("checked",false);
                 $('#allChoose').attr("checked",false);    
                
            })}

);





$('#addClass').click(function(){

if($('#startDate').val()==""){

alert("开始执行时间不能为空!");
return;
}

	var LabID=$('#LabID').val();
	var ClasshourID=$('#ClasshourID').val();
	var CoursesName=$('#CoursesName').val();
	var Teacher=$('#Teacher').val();
	var useType;

	var sexObject=document.getElementsByName("UseType");
	for(var i=0;i<sexObject.length;i++){
	
	if(sexObject[i].checked){
	useType=sexObject[i].value;
	break;
	
	}
	
	}
	var cycle="";
	var cycleType=$('#cycleType').val();
	if(cycleType=='W'){
            $("input[name='checkbox']:checkbox").each(function(){
            
                if($(this).attr("checked")){
                    cycle += $(this).val()+","
                }
            })
 	cycle=cycle.substring(0,cycle.length-1)
	}else if(cycleType=='M'){
	 $("input[name='checkbo']:checkbox").each(function(){
            
                if($(this).attr("checked")){
                    cycle += $(this).val()+","
                }
            })
		cycle=cycle.substring(0,cycle.length-1)
	}else{
	cycle="";
	}


	$.post('paike!ad',
	{'labID':LabID,
	'c.classhourId':ClasshourID,
	'c.coursesName':CoursesName,
	'c.teacher':Teacher,
	'c.useType':useType,
	'c.isRepetitive':$('#isRepetitive').val(),
	'c.cycleType':$('#cycleType').val(),
	'c.cycle':cycle,
	'c.beginDate':$('#startDate').val(),
	'c.endDate':$('#endDate').val(),
	'c.userId':$('#userId').val(),
	'c.class_':$('#class').val(),
	'c.major':$('#major').val()
	},
        function(data){
        if(data=='Y'){
       alert(" 添加成功");
       $('#LabID').val('');
		$('#ClasshourID').val('');
		$('#CoursesName').val('');
		$('#Teacher').val('');
		$('#aa').val('');
		$('#cycle').val('');
		$('#endDate').val('');
		$('#startDate').val('');
		$('#userId').val('');
        }else{
		
		alert("课程ID="+data+"的记录已经存在！");
		
		}
		},'text');
		
	});
	
	$('#major').change(function(){
	$('#opt').siblings().remove();
	$('#opt').remove();
	var major=$('#major').val();
	$.post('paike!getClaByMajor.action',{'major':major},function(data){
	

	var arr=data.split(',');
	for(var i=0;i<arr.length;i++){
	
	if(arr[i]!=""){
		$('#class').append('<option id="opt" value='+arr[i]+'>'+arr[i]+'</option>');
	}
    	}
	
	
	},'text')
	
	
	});
	
	});
	
	
	
		function fun2()
	{
		if($('#isRepetitive').val()=='N')
		{
			document.getElementById('cycleType').disabled=true;
			$('#week').hide();
		}
		else
		{
			document.getElementById('cycleType').disabled=false;
			$('#week').show();
		}
	}
	function fun3()
	{
		if($('#cycleType').val()=='D')
		{
			$('#week').hide();
			$('#month').hide();
			
		}
		else if($('#cycleType').val()=='W'){
			$('#week').show();
			$('#month').hide();
		}else if($('#cycleType').val()=='M'){
			$('#month').show();
			$('#week').hide();
		}
	}
	
	function onRadio(userType){
	if(userType==1){
	$('#userId').removeAttr('disabled');
	$('#major').attr('disabled','disabled');
	$('#class').attr('disabled','disabled');;
	}else if(userType==2){
	$('#major').removeAttr('disabled');
	$('#class').removeAttr('disabled');
	$('#userId').attr('disabled','disabled');
	}else{
	$('#major').removeAttr('disabled');
	$('#class').removeAttr('disabled');
	$('#userId').removeAttr('disabled');
	
	}
	
	
	}
	
	function changWeeks(){
		var week=$('#changWeeks').val();
		var startD=$('#startD').val();
		var days=(week-1)*7;
	var sureDate=doit(startD,days);
	$('#startDate').val(sureDate);
}
	
	function changWeeksEnd(){
	var week=$('#changWeeksEnd').val();
		var startD=$('#startD').val();
		var days=(week-1)*7;
	var sureDate=doit(startD,days);
	$('#endDate').val(sureDate);
	
	
	}
	
	function doit(dtstr,n) {
            var v = dtstr;
            if (v == "") return false;
            var dt = new Date(v.replace(/\-/g, "\/"));
            dt.setDate(dt.getDate() + n);
            
            var day=dt.getDate();
            if(day<10){
            day="0"+day;
            }
            
            var month=(dt.getMonth() + 1);
            if(month<10){
            month="0"+month;
            }
            var newdt = dt.getFullYear() + "-" +month+ "-" +day;
            return newdt;
              
        }
	

//判断导入文件
function checkFile() {
 //obj是你那个file框
 var obj = document.getElementById('file');
 if(obj.value == ''){
  alert('请选择需要导入的excel文档');
  
 }
 var suffix = obj.value.match(/^(.*)(\.)(.{1,8})$/)[3]; 
 if(suffix != 'xls'){
  alert('文件格式不正确！请使用excel文档');
 }else{
 var form= document.getElementById('form1');
 form.submit();

 }
}


 </script>
  
  </head>

  <body>
   手动添加课表：
  <fieldset>
  <table  border="0" cellspacing="0">
  	<tr>
  		<td>实验室名称：</td>
  		<td>
  		<select id="LabID" style="width:155px">
  		 <s:iterator value="laList" var="l">
              <option value="${l.labId}" >${l.labDesc}</option>
         </s:iterator>
        </select>  
        </td>
  	</tr>
  	<tr>
  		<td>时　间　段：</td>
  		<td>
  			   <select id="ClasshourID" style="width:155px">
                    <s:iterator value="ccList" var="c">
                    <option value="${c.classhourId}">${c.classhourName }</option> 
                    </s:iterator>
               </select>
  		</td>
  	</tr>
  
  	<tr>
  		<td>是否重复执行：</td>
  		<td>
  			<select id="isRepetitive" style="width:155px" onchange="fun2()">
  				<option value="Y">是</option>
  				<option value="N">否</option>
  			</select>
  		</td>
  	</tr>
  	<tr>
  		<td>循环类型：</td>
  		<td>
  			<select id="cycleType" style="width:155px" onchange="fun3()">
  				<option ></option>
  				<option value="W">每周</option>
  				<option value="D">每日</option>
  				<option value="M">每月</option>
  			</select>
  		</td>
  	</tr>
  	
  	<tr>
  		<td>循环周期：</td>
  		<td>
  		
<div  id="week" ><table border="1" cellpadding="0" cellspacing="0"><tr><td>
<input type="checkbox" name="checkbox" value="1" />
星期天
<input type="checkbox" name="checkbox" value="2" />
星期一 
<input type="checkbox" name="checkbox" value="3" />
星期二
<input type="checkbox" name="checkbox" value="4" />
星期三
<input type="checkbox" name="checkbox" value="5" />
星期四
<input type="checkbox" name="checkbox" value="6" />
星期五
<input type="checkbox" name="checkbox" value="7" />
星期六
</td>
</tr>
</table>
</div>
  	
  	<div style="display: none" id="month">
  	<table cellpadding="0" cellspacing="0" border="1">
  	<tr>
  	<td>
  <input type="checkbox" name="checkbo" value="1" />
  1
<input type="checkbox" name="checkbo" value="2" />
2 
<input type="checkbox" name="checkbo" value="3" />
3
<input type="checkbox" name="checkbo" value="4" />
4
<input type="checkbox" name="checkbo" value="5" />
5
<input type="checkbox" name="checkbo" value="6" />
6
<input type="checkbox" name="checkbo" value="c7" />
7
<input type="checkbox" name="checkbo" value="8" />
8
<input type="checkbox" name="checkbo" value="9" />
9
<input type="checkbox" name="checkbo" value="10" />
10<br/>
<input type="checkbox" name="checkbo" value="11" />
11
<input type="checkbox" name="checkbo" value="12" />
12
<input type="checkbox" name="checkbo" value="13" />
13
<input type="checkbox" name="checkbo" value="14" />
14
<input type="checkbox" name="checkbo" value="15" />
15
<input type="checkbox" name="checkbo" value="16" />
16
<input type="checkbox" name="checkbo" value="17" />
17
<input type="checkbox" name="checkbo" value="18" />
18
<input type="checkbox" name="checkbo" value="19" />
19
<input type="checkbox" name="checkbo" value="c20" />
20<br/>
<input type="checkbox" name="checkbo" value="21" />
21
<input type="checkbox" name="checkbo" value="22" />
22
<input type="checkbox" name="checkbo" value="23" />
23
<input type="checkbox" name="checkbo" value="24" />
24
<input type="checkbox" name="checkbo" value="25" />
25
<input type="checkbox" name="checkbo" value="26" />
26
<input type="checkbox" name="checkbo" value="27" />
27
<input type="checkbox" name="checkbo" value="28" />
28
<input type="checkbox" name="checkbo" value="29" />
29
<input type="checkbox" name="checkbo" value="30" />
30
<input type="checkbox" name="checkbo" value="31" />
31
全选<input type="checkbox" name="checkboxxx" id="allChoose" />
  	</td>
  	</tr>
  	</table>
  	</div>
  		
  		
  		</td>
  	</tr>
  		<tr><td>开始执行时间：</td><td><input onfocus="setday(this)"  type="text" id="startDate"/>
  		<select  id="changWeeks" onchange="changWeeks()">
  		<s:iterator value="weeks" status="st" >
  		<option value="${st.count-1}" >第${st.count}周</option>
  		</s:iterator>
	</select>
  		<input type="hidden" value="${startD}" id="startD"/>
  		
  		


  		
  		
  		
  		</td>
  		</tr>
  		<tr><td>结束执行时间：</td><td><input onfocus="setday(this)"   type="text" id="endDate"/>
  		
  		<select  id="changWeeksEnd" onchange="changWeeksEnd()">
  		<s:iterator value="weeks" status="st" >
  		<option value="${st.count-1}" >第${st.count}周</option>
  		</s:iterator>
	</select>
  		
  		</td></tr>
  	<tr>
  		<td>课程名称:</td><td><input type="text" id="CoursesName"></td>
  	</tr>
  	<tr><td>授课老师:</td><td><input type="text" id="Teacher"></td></tr>
  	<tr>
  		<td colspan="2">使用属性：<input type="radio" id="aa" name="UseType" value="1" onclick="onRadio(this.value)">个人&nbsp;&nbsp;&nbsp; <input type="radio" name="UseType" value="2" id="aa" onclick="onRadio(this.value)">组 &nbsp;&nbsp;&nbsp;<input type="radio" name="UseType" value="3" id="aa" onclick="onRadio(this.value)">不限<br/></td>
  	</tr>
  	
  	<tr><td>用户名：</td><td><input type="text" id="userId"/></td></tr>
  	
  	<tr>
  		<td>专业:</td>
  		<td>
  			<select id="major" style="width:155px" >
  			<s:iterator value="majorInfos" var="m">
  				<option value="${m.major}">${m.major}</option>
  			</s:iterator>
  			</select>
  		</td>
  	</tr>
  	
  		<tr>
  		<td>班级:</td>
  		<td>
  			<select id="class" style="width:155px" >
  			</select>
  		</td>
  	</tr>
  	
  	<tr>
  		<td colspan="2"><input type="button" value="提交" id="addClass"> </td>
  	</tr>
  </table>
  
  </fieldset>
  
  导入课表信息：
  <fieldset>
	<form action="paike!importTable" method="post" id="form1"
							enctype="multipart/form-data">
							上传文件:
							<input type="file" id="file" name="file" />
							<input type="button" value="上传生成课表" onclick="checkFile()"/> &nbsp&nbsp&nbsp<span style="color: red">*上传文件类型必须为.xls(并按要求上传信息)</span>
						</form>
						<br>
						<div style="color:red" align="center">${msg_row}</div> 
</fieldset>
  
     样表如下：
   <table width="100%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <th scope="col">实验室名称</th>
    <th scope="col">开始日期</th>
    <th scope="col"><div align="center">结束日期</div></th>
    <th scope="col"><div align="center">是否循环执行</div></th>
    <th scope="col"><div align="center">循环类型</div></th>
    <th scope="col"><div align="center">循环周期</div></th>
    <th scope="col"><div align="center">循环执行时间段</div></th>
    <th scope="col"><div align="center">课程名称</div></th>
    <th scope="col"><div align="center">授课教师</div></th>
    <th scope="col"><div align="center">使用类型</div></th>
    <th scope="col"><div align="center">状态</div></th>
    <th scope="col"><div align="center">创建时间</div></th>
    <th scope="col"><div align="center">创建人</div></th>
    <th scope="col"><div align="center">专业</div></th>
    <th scope="col"><div align="center">班级</div></th>
    <th scope="col"><div align="center">用户名</div></th>
  </tr>
  <tr>
    <td><div align="center">C507<span style="color:red">*</span></div></td>
    <td><div align="center">2013-04-05<span style="color:red">*</span></div></td>
    <td><div align="center">2014-01-10</div></td>
    <td><div align="center">（Y/N）</div></td>
    <td><div align="center">(M/W/D)</div></td>
    <td><div align="center">1,2,3</div></td>
    <td><div align="center">(1/2/3/4/5/6/7)<span style="color:red">*</span></div></td>
    <td><div align="center">Java编程<span style="color:red">*</span></div></td>
    <td><div align="center">小刘</div></td>
    <td><div align="center">（1/2/3)<span style="color:red">*</span></div></td>
    <td><div align="center">(1/2)<span style="color:red">*</span></div></td>
    <td><div align="center">2013-02-01</div></td>
    <td><div align="center">admin</div></td>
    <td><div align="center">网络工程</div></td>
    <td><div align="center">3</div></td>
    <td><div align="center">admin</div></td>
    
  </tr>
  <tr>
    <td colspan="16"><div align="center" style="color:red">*代表必须填写,( )代表选择的值。</div></td>
  </tr>
  <tr>
    <td colspan="16" align="center"><a href="excel/classSchedule.xls">导出样表</a></td>
  </tr>
</table>
  
  
  </body>
</html>
