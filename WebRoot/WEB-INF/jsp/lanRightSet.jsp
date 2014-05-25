<%@ page language="java" pageEncoding="GBK"%>
<%@taglib uri="/struts-tags"  prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户权限设置</title>
<link href="css/wu.css" rel="stylesheet" type="text/css" />
<script  src="js/jquery-1.4.min.js"></script>
<SCRIPT type="text/javascript">

function add(){


var strUserId='';
var ch1=$("input[name='user']:checkbox:checked");
	
	ch1.each(function(i){      
    strUserId=strUserId+$(this).val()+",";
   });

var strGroupId='';
var ch=$("input[name='group']:checkbox:checked");
	
	ch.each(function(i){      
    strGroupId=strGroupId+$(this).val()+",";
   });

$.post('systemManger_labRightSet',{'strUserId':strUserId,'strGroupId':strGroupId,'labId':$('#labId2').val()},function(data){

alert('权限设置成功');
})


}


function chaxun(){

$.post('systemManger_getRightByLabId',{'labId':$('#labId2').val()},function(data){

var ch=$("input:checkbox");
	

	
	ch.each(function(i){       
    var da=data.split(",");

    for(var i=0;i<da.length-1;i++){
    var left =($(this).val().replace(/(^\s*)|(\s*$)/g,""));
    var right=da[i].replace(/(^\s*)|(\s*$)/g,"");
  			if(left==right){
	$(this).attr("checked",true);
}
    
    }
    
    
   });


})


}



</SCRIPT>


</head>

<body>

 <div align="center" style="margin-top: 20px;">
  <div align="center"><input type="text"  value="实验室${labId}" id="labId" disabled="disabled"/><input type="hidden"  value="${labId}" id="labId2" disabled="disabled"/></div>
  <br/>
 <div>
 用户组<br/>
   <s:iterator value="groupInfos" var="group_info"  status="st">

   	<input type="checkbox" name="group" value="${group_info.groupId}"  />${group_info.groupName} &nbsp

   <s:else>
   <br/>
   </s:else>
   </s:iterator>
</div>
 
<br/>
 
 <div>
 用户<br/>
   <s:iterator value="userInfos" var="user_info"  status="st">
   	<s:if test="#st.count % 8!=0">
  <span style="width:80px;"> <input type="checkbox" name="user" value="${user_info.userId}" />${user_info.userName} </span>
   	</s:if>
   <s:else>
  
  <span style="width:100px;"> <input type="checkbox" name="user" value="${user_info.userId}" />${user_info.userName} </span>
    <br/>
   </s:else>
   </s:iterator>
</div>
<br/>
  <input type="button" onclick="add()" value="提交"/>&nbsp&nbsp<input type="button" onclick="chaxun()" value="查询"/>
 </div>
  
  

</body>
</html>
