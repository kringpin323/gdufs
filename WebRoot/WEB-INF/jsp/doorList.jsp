<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="sessionParameter!=null">
<table style="margin-top: -9px;">
<tr>
 <td width="130px" align="center">
 <table>
		<tr height="65px"><td></td></tr>
		<tr><td align="center" width="50px">
		<input  name="openD" type="button" id="openD" onclick="doorControl('on','${sessionParameter.sessionParameterPK.sessionValue}',${sessionParameter.sessionParameterPK.deviceId})" style=" cursor:pointer; height: 39px;width: 125px;background:url(image/doorIMG/km.png);margin: 0px;padding: 0px;border: none;"/>
		</td>
		</tr>
	<tr><td><input  name="openD" type="button" id="openD" onclick="doorControl('off','${sessionParameter.sessionParameterPK.sessionValue}',${sessionParameter.sessionParameterPK.deviceId})" style="cursor:pointer; height: 39px;width: 125px;background:url(image/doorIMG/gm.png);margin: 0px;padding: 0px;border: none;"/></td></tr>
		<tr><td>
		 <input type="button" name="close1"  id="chaxun" onclick="doorControl('chaxun','${sessionParameter.sessionParameterPK.sessionValue}',${sessionParameter.sessionParameterPK.deviceId})" style=" cursor:pointer;height: 39px;width: 125px;background:url(image/safe1/button4.png);margin: 0px;padding: 0px;border: none; "/>
		</td></tr>
		<tr height="10px"><td></td></tr>
</table>	
		</td>
		</tr>
</table>
</s:if>