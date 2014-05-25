<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ClassManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/wu.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.4.min.js"></script>
<script type="text/javascript" src="js/Calendar1.js"></script> 
<SCRIPT type="text/javascript">

function f(e){
	
	$('#findByCondition').disabled=false;
		var LabID=$('#LabID').val();
		var ClasshourID=$('#ClasshourID').val();
		var beginDate=$('#startDate').val();
		var CoursesName=$('#CoursesName').val();
		$.post('paike!findByCondition.action',
		{'currentPage':e,'c.labId':LabID,'c.classhourId':ClasshourID,'c.beginDate':beginDate,'c.coursesName':CoursesName},
		
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

function del(e){

	if(confirm('确定删除课程表?')){
	}else{
	return;
	}
	$.post('paike!del',{'clsTimTbllD':e},function(data){
	alert('删除成功!');
	var c=$('#hid').val();
	f(c);
	})

}


$(function(){

	$('#findByCondition').click(function (){
		var currentPage=1;
		f(currentPage);
		
	});


});


	function changWeeks(){
		var week=$('#changWeeks').val();
		var startD=$('#startD').val();
		var days=(week-1)*7;
	var sureDate=doit(startD,days);

	$('#startDate').val(sureDate);
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

</SCRIPT>

  </head>
  
  <body>

   <table  border="1" cellspacing="0" cellpadding="0" width="100%">
  	<tr>
  		<td>实验室名称:<select id="LabID" ><option value="">全部</option>
  		 <s:iterator value="laList" var="l">
              <option value="${l.labId}" >${l.labDesc}</option>
         </s:iterator>
        </select>  
        </td>
        
  		<td >时间段:<select id="ClasshourID" >
  					<option value="">全部</option>
                    <s:iterator value="ccList" var="c" status="st">
                    <option value="${c.classhourId}">(第${st.count }节课)</option> 
                    </s:iterator>
               </select>
        </td>
         <td> 执行时间:<input onfocus="calendar()" size="10" type="text" id="startDate" />
      
         <select id="changWeeks" onchange="changWeeks()">
  		<s:iterator value="weeks" status="st" >
  		<option value="${st.count-1}" >第${st.count}周</option>
  		</s:iterator>
         </select>
         <input type="hidden" value="${startD}" id="startD"/>
        </td>
        <td >课程名称:<input type="text" id="CoursesName" size="5"></td>
        <td ><input type="button" value="查找"  id="findByCondition" /></td>
        </tr>
     
  	</table>
 
  	<div id="recodes"></div>
  </body>
</html>
