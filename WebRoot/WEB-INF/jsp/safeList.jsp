<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<s:if test="sps!=null">
<s:iterator value="sps" var="ps">
<s:iterator value="ps" var="p">
</s:iterator>
</s:iterator>
<table width="750" border="1" cellpadding="0" cellspacing="0"> 
 <tr>
  <td height="57" colspan="4"><div align="center">
    <input  type="button" name="openAll"  id="open" onclick="safeControl('on',${ps[0].sessionParameterPK.deviceId})"   style="cursor:pointer; height: 30px;width: 96px;background:url(image/safe1/button1.png);margin: 0px;padding: 0px;border: none;"/>&nbsp;
	<input type="button" name="closeAll" id="close"  onclick="safeControl('off',${ps[0].sessionParameterPK.deviceId})" style="cursor:pointer; height: 30px;width: 96px;background:url(image/safe1/button2.png);margin: 0px;padding: 0px;border: none;"/>
 	<input  type="button" name="closeAll" id="chaxun" onclick="safeControl('chaxun',${ps[0].sessionParameterPK.deviceId})" style="cursor:pointer; height: 30px;width: 96px;background:url(image/safe1/button3.png);margin: 0px;padding: 0px;border: none;"/>
  <span id="alarm" style="color :red"></span>
  </div></td>
</tr>
</table>
<br/>
<div> 传感器名称：<select id="sessionN">
<option value="">请选择……</option>
<s:iterator value="sps" var="ps">
<s:iterator value="ps" var="p">
	<option value="${p.sessionName}">${p.sessionName}</option>
</s:iterator>
</s:iterator>
</select>  报警时间：<input type="text" id="alarmTime" onfocus="setday(this)"/>到<input type="text" id="alarmTime2" onfocus="setday(this)"/><input type="button" value="报警详情" onclick="alarmControls(${ps[0].sessionParameterPK.deviceId})"/><input type="hidden" id="sPK" value="${ps[0].sessionParameterPK.deviceId}"/></div>
</s:if>
