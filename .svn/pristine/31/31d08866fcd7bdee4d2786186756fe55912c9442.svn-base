<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/jpager.tld"%>
<table width="90%" border="1" cellspacing="0" style="border-top: none" id="t1">
   		<tr align="center" id="ccc">
   			<th>设备名称</th>
   			<th>参数值</th>
   			<th>传感器名称</th>
   			<th>传感器类别</th>
   			<th>实验室</th>
   			<th>传感器位置</th>
   			<th>传感器状态</th>
   			<th>创建时间</th>
   			<th>创建人</th>
   			<th>操作</th>
   		</tr>
		
		<s:iterator value="ssList" var="s" status="st">
		
   			<tr align="center">
   				<td>${s.canshu.deviceName}</td>
   				<td>${s.sessionParameterPK.sessionValue}</td>
   				<td>${s.sessionName}</td>
   				<td>${s.sessionType}</td>
   				<td>${s.canshu.shiyan.labDesc}</td>
   				<td>${s.position}</td>
   				<td><s:if test='status=="Y"'>可用</s:if>
   				<s:else>禁用</s:else></td>
   				<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
   				<td>${s.createBy}</td>
   				<td>
   						<input type="button" value="删除" onclick="delete1(${s.canshu.deviceId },'${s.sessionParameterPK.sessionValue}')"/>
   					</td>
   			</tr>
  		</s:iterator>
	
</table>
<table border="0" width="90%">
			<tr align="right">
			<td colspan="9">第<font color="red">${page}</font>页|共<font color="red">${yeshu}</font>页|共<font color="red">${jilu}</font>条记录|<input type="button" id="frist" onclick="fun7(${1})" value="首页" />|<input type="button" id="shang" onclick="fun7(${page-1})" value="上一页" />|<input type="button" id="xia" onclick="fun7(${page+1})" value="下一页" />|<input type="button" onclick="fun7(${yeshu})" id="last" value="尾页" />
							<input type="hidden" id="page" value="${page}">
							<input type="hidden" id="yeshu" value="${yeshu}"></td>
		</tr>
</table>