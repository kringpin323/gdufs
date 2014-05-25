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
$(function(){
$("#stas").trigger("click");	


$('#stas').click(function(){
var userId=$('#userId').val();

$.post('systemManger_chaxunStas',{'userId':userId},function(data){
	for(var i=0;i<30 ;i++){
	for(var j=0;j<data.length;j++){
		if($('#checkbox'+i).val()==data[j]){
		$('#checkbox'+i).attr('checked','checked');
		}
	
	}
	
	}	
		
		
		},'json')

});

$('#allchoose').toggle(function(){
 $("input[name='checkbox']:checkbox").each(function(){
            
                $(this).attr("checked",true);  
                
            })

},
function(){
 $("input[name='checkbox']:checkbox").each(function(){
            
                $(this).attr("checked",false);   
                
            })}

);



});


</SCRIPT>


</head>

<body>
<form id="form1" name="form1" method="post" action="systemManger_RightSet?userId=${userId}">
  <table width="95%" border="1" cellspacing="0" cellpadding="0">
    <tr>
      <td height="20" colspan="3" align="center">帐号：
    <input type="text" id="userId" value="${userId}" disabled="disabled"/>
        <input type="button" value="查询权限" id="stas">
        <input type="checkbox"  id="allchoose" />全选
      	</td>
    </tr>
    <tr>
      <td width="34%"><label>
        <input type="checkbox" name="checkbox" value="sys01" id="checkbox0" />
        设备维护申请</label></td>
      <td width="33%"><label>
        <input type="checkbox" name="checkbox" value="sys02" id="checkbox1"/>
        实验室使用申请 </label></td>  
      <td width="33%"><label>
        <input type="checkbox" name="checkbox" value="sys03" id="checkbox2"/>
        信息查询</label></td>
    </tr>
    <tr>
      <td><label>
        <input type="checkbox" name="checkbox" value="sys04" id="checkbox3"/>
        视频监控</label></td>
      <td><label>
        <input type="checkbox" name="checkbox" value="sys05" id="checkbox4"/>
        灯光监控</label></td>
      <td><label>
        <input type="checkbox" name="checkbox" value="sys06" id="checkbox5"/>
        空调监控</label></td>
    </tr>
    <tr>
      <td><label>
        <input type="checkbox" name="checkbox" value="sys08" id="checkbox7"/>
        电源监控</label></td>
      <td><label>
        <input type="checkbox" name="checkbox" value="sys09" id="checkbox8"/>
        安防监控</label></td>
        <td><label>
        <input type="checkbox" name="checkbox" value="sys10" id="checkbox9"/>
        设备维护确认</label></td>
    </tr>
    <tr>
      <td><label>
        <input type="checkbox" name="checkbox" value="sys11" id="checkbox10"/>
        实验室申请确认</label></td>
        
          <td><label>
        <input type="checkbox" name="checkbox" value="sys07" id="checkbox6"/>
        实验室值班登记</label></td>
         
           <td><label>
        <input type="checkbox" name="checkbox" value="sys12" id="checkbox12"/>
        设备管理</label></td>   
             
    </tr>
    
  
 
  
  
    
    <tr>

      <td><label>
        <input type="checkbox" name="checkbox" value="sys13" id="checkbox13"/>
       家俱管理</label></td>
     
      <td><label>
        <input type="checkbox" name="checkbox" value="sys14" id="checkbox14"/>
       耗材管理</label></td>
     
        <td><label>
        <input type="checkbox" name="checkbox" value="sys16" id="checkbox16"/>
        导航表查看</label></td> 
    </tr>
    
      <tr>
      
        
      
       
        <td width="33%"><label>
        <input type="checkbox" name="checkbox" value="sys24" id="checkbox11"/>
        导航表管理 </label></td> 
      
       <td><label>
        <input type="checkbox" name="checkbox" value="sys25" id="checkbox24"/>
        时间段管理</label></td>
       
       
           <td><label>
        <input type="checkbox" name="checkbox" value="sys18" id="checkbox18"/>
      文本框输入</label></td> 
        
    </tr>
    
    <tr>
     
      
        
        
        <td><label>
        <input type="checkbox" name="checkbox" value="sys19" id="checkbox19"/>
      智能卡录入</label></td>
        
         <td><label>
        <input type="checkbox" name="checkbox" value="sys28" id="checkbox17"/>
       用户组管理</label></td>
          
          
    
       <td width="33%"><label>
        <input type="checkbox" name="checkbox" value="sys29" id="checkbox28"/>
        安全门 </label></td> 
    </tr>
    <tr>
    
    
      <td><label>
        <input type="checkbox" name="checkbox" value="sys20" id="checkbox20"/>
        运行模式</label></td>
           <td><label>
        <input type="checkbox" name="checkbox" value="sys21" id="checkbox21"/>
        参数设定</label></td>
        
         <td><label>
        <input type="checkbox" name="checkbox" value="sys23" id="checkbox23"/>
        增加实验室</label></td>
    </tr>
    <tr>
     <td width="33%"><label>
        <input type="checkbox" name="checkbox" value="sys27" id="checkbox25"/>
       智能设备管理 </label></td> 
  <td width="33%"><label>
        <input type="checkbox" name="checkbox" value="sys26" id="checkbox26"/>
        智能设备设置 </label></td>
     
          <td><label>
        <input type="checkbox" name="checkbox" value="sys22" id="checkbox22"/>
        使用记录查询</label></td>
    </tr>
    
       <tr>
     <td width="33%" ><label>
        <input type="checkbox" name="checkbox" value="sys29" id="checkbox29"/>
      门襟密码修改 </label></td> 
  <td width="33%"><label>
  <td>&nbsp</td>
  <td>&nbsp</td>
    </tr>
    
    <tr>
      <td colspan="3" align="center"><label>
     <input type="submit"  value="提交" /></label></td>
    </tr>
  </table>
</form>
</body>
</html>
