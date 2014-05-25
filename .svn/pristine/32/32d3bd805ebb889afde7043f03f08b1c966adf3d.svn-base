<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="750" border="1">
<thead><tr><th align="center">名称</th><th align="center">状态</th><th align="center">操作</th></tr></thead>

<s:iterator value="sps" var="ps">

<s:iterator value="ps" var="p">

  <tr>
    <td width="200" height="32" align="center"><font color="blue">${p.sessionName}</font></td>
    <td id="light${p.sessionParameterPK.sessionValue}" width="200" align="center">*</td>
    <td width="300"><div align="center">
 
      <input name="open1"  type="button" onclick="lightControl('on',${p.sessionParameterPK.sessionValue},${p.sessionParameterPK.deviceId})" style=" cursor:pointer; height: 30px;width: 96px;background:url(image/openL.png);margin: 0px;padding: 0px;border: none; "/>&nbsp;
	  <input type="button"  name="close1" onclick="lightControl('off',${p.sessionParameterPK.sessionValue},${p.sessionParameterPK.deviceId})" style="cursor:pointer; height: 30px;width: 96px;background:url(image/closeL.png);margin: 0px;padding: 0px;border: none;"/>
    </div></td>
  </tr>
  </s:iterator>
</s:iterator>
  <tr><td colspan="3" align="center">
  
  <s:if test="sps!=null">
  <input type="button" name="close1"  id="chaxun" onclick="lightControl('chaxun',${ps[0].sessionParameterPK.sessionValue},${ps[0].sessionParameterPK.deviceId})" style=" cursor:pointer;height: 30px;width: 96px;background:url(image/safe1/button3.png);margin: 0px;padding: 0px;border: none;"/>
</s:if>
</td></tr>
</table>
