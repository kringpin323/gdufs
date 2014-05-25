<%@ page language="java" import="java.util.*" pageEncoding="GB18030" isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
 <base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>物联网智能管理实验室</title>
<link href="css/styleleft.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
        .current{
      
                }
    </style>

<script  src="js/jquery-1.4.min.js"></script>
    <script  src="js/chang.js"></script>

</head>
<body>
<div id="container">
 <div class="clearfloat"></div>
  

<div class="clearfloat"></div>a
<div id="maincontent">

</div>
<div id="side">
<div id="DoorP">

  
  
  <h2>&nbsp;<span style="cursor:hand"> <a href="lab_doorContorl" target="right">实验室使用</a></span></h2>
  <div class="content" id="menu">
  <ul>
  </ul>
  </div>
  
  <h2>&nbsp; <span style="cursor:hand">实验室申请</span></h2>
  <div class="content" id="menu">
  <ul>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys01'">
  <li><a href="lab_waite.action"  target="right">设备维护申请</a></li>
  		</s:if>
 </s:iterator>
 
 <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys02'">
  <li><a href="lab_waite.action" target="right">实验室使用申请</a></li>
  		</s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys03'">
  <li><a href="lab_waite.action" target="right">信息查询</a></li>
 		 </s:if>
 </s:iterator>
  </ul>
  </div>
  
 
  
  <h2>&nbsp; <span style="cursor:hand">实验室监控</span></h2>
  <div class="content">
  <ul>
  <s:if test='#session.userInfo.logMode=="1"'>
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys04'">
  <li><a href="lab_spControl" target="right" >视频监控</a></li>
 		 </s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys05'">
  <li><a href="lab_lightControl" target="right">灯光监控</a></li>
 		 </s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys06'">
  <li><a href="lab_airConditioner" target="right">空调监控</a></li>
  		</s:if>
 </s:iterator>
  
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys08'">
  <li><a href="lab_switchControl" target="right">电源监控</a></li>
  		</s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys09'">
  <li><a href="lab_safeControl" target="right">安防监控</a></li>
  		</s:if>
 </s:iterator>
 </s:if>
  </ul>
  </div>

  
  
  
  <h2>&nbsp; <span style="cursor:hand">实验室管理</span></h2>
  <div class="content">
  <ul>
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys10'">
  <li><a href="lab_waite.action" target="right">设备维护申请确认</a></li>
		  </s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys11'">
  <li><a href="lab_waite.action" target="right">实验室申请确认</a></li>
		  </s:if>
 </s:iterator>
 
 <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys07'">
  <li><a href="lab_waite.action" target="right">实验室值班登记</a></li>
		  </s:if>
 </s:iterator>
  
   		<s:if test='#session.userInfo.logMode=="1"'>
   		
   	<s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys27'">	
  <li><a href="shebei!addLabinfo.action" target="right">智能设备管理</a></li>
  	  </s:if>
 </s:iterator>
  
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys26'">	
  <li><a href="can!listshiyanshi.action" target="right">智能设备设置</a></li>
   </s:if>
 </s:iterator>
  
  		</s:if>


  </ul>
  </div>
  <h2>&nbsp; <span style="cursor:hand">物资管理</span></h2>
  <div class="content">
  <ul>
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys12'">
  <li><a href="lab_waite.action" target="right">设备管理</a></li>
  		 </s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys13'">
  <li><a href="lab_waite.action" target="right">家俱管理</a></li>
  		 </s:if>
 </s:iterator>
  
  <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys14'">
  <li><a href="lab_waite.action" target="right">耗材管理</a></li>
  		 </s:if>
 </s:iterator>
  
 
  </ul> 
  </div>
  <h2>&nbsp; <span style="cursor:hand">导航管理</span></h2>
  <div class="content">
  <ul>
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys16'">
  <li><a href="paike!toPaiKe.action" target="right" >导航表查看</a></li>
  		</s:if>
 </s:iterator>
  
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys17'">
  <li><a href="paike!listClass.action" target="right">导航表编辑</a></li>
  		</s:if>
 </s:iterator>
 
 <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys24'">
  <li><a href="paike!classManager.action" target="right">导航表管理</a></li>
  		</s:if>
 </s:iterator>

 <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys25'">
  <li><a href="paike!toAddClasshour.action" target="right">时间段管理</a></li>
  		</s:if>
 </s:iterator>
 
  </ul>  
  </div>
  <h2>&nbsp; <span style="cursor:hand">用户管理</span></h2>
  <div class="content">
  <ul>
  
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys18'">
  <li><a href="systemManger_toUserInfo" target="right">文本框输入</a></li>
  </s:if>
 </s:iterator>
  
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys19'">
  <li><a href="systemManger_toImportUserInfo" target="right">智能卡录入</a></li>
  </s:if>
 </s:iterator>
    
  </ul>
  </div>
  <h2>&nbsp; <span style="cursor:hand">系统管理</span></h2>
  <div class="content">
  <ul>
  
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys20'">
  <li><a href="systemManger_toLabStauSet"target="right">运行模式</a></li>
  		</s:if>
 </s:iterator>
  
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys21'">
  <li><a href="systemManger_toAutoSet"target="right">参数设定</a></li>
 		 </s:if>
 </s:iterator>
  
  
    <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys23'">
  <li><a href="lab_toLabManager.action" target="right">增加实验室</a></li>  
  		</s:if>
 </s:iterator> 
  
   <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys22'">
  <li><a href="systemManger_toLabRecode" target="right">使用记录查询</a></li>
  		</s:if>
 </s:iterator>
  
  
  </ul>
  </div>
</div>
<div id="exit">
      <ul>
      <li><input type="image" src="images/exit.png"  onclick="window.location.href='sysOut'" onMouseMove="src='images/exit_on.png'" onMouseOut="src='images/exit.png'" />
     </li></ul>
</div>
</div>

<div class="clearfloat"></div>

</div>

<script type="text/javascript">
//列表
var onum=0;
var closeState=new Array();
var ch=document.body.clientHeight-360;
function test(id){if(document.getElementById(id)){return document.getElementById(id);}else{alert("没有找到!")}}
function tag(id,tagName){return test(id).getElementsByTagName(tagName)}
var Ds=tag("DoorP","div");
var Ts=tag("DoorP","h2");
if(Ds.length != Ts.length){alert("初始化失败!");}

function showMe(Cid,Oid){
var h=parseInt(Ds[Cid].style.height);
var h2=parseInt(Ds[Oid].style.height);
var dH=ch;
if(h>0){
h=h-Math.ceil(h/3);
Ds[Cid].style.height=h+"px";
};
if(h2<dH){
h2=h2+Math.ceil((dH-h2)/3);
Ds[Oid].style.height=h2+"px";
};
if(h<=0&&h2>=dH){

clearTimeout(closeState[Cid]);
return false;
};
closeState[Cid] = setTimeout("showMe("+Cid+","+Oid+")");
}

for(var i=0;i<Ds.length;i++){
if(i==onum){Ds[i].style.height=ch+"px";Ts[i].className="title01";}else{Ds[i].style.height="0px";Ts[i].className="title02";}
Ts[i].value=i;
Ts[i].onclick=function(){
if(onum==this.value){ return false;};
Ts[onum].className="title02";
Ts[this.value].className="title01";

for(var i=0;i<closeState.length;i++){  clearTimeout(closeState[i]);}


	change_bg();
   showMe(onum,this.value);
   onum=this.value;
   
     
  }
}




</script>
</body>
</html>
