<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="/WEB-INF/jpager.tld"%>
<table width="90%" border="1" cellspacing="0" style="border-top: none" id="t1">
<tr align="center" id="ccc">
   			<th>设备名称</th>
   			<th>设备类别</th>
   			<th>IP　地址</th>
   			<th>端口号</th>
   			<th>实验室</th>
   			<th>位置</th>
   			<th>设备状态</th>
   			<th>创建时间</th>
   			<th>创建人</th>
   			<th>操作</th>
   		</tr>
   		
		<s:iterator value="Dlist" var="d" status="st">
		
   			<tr align="center">
   				<td>${d.deviceName}</td>
   				<td>${d.deviceType}</td>
   				<td>${d.deviceIp}</td>
   				<td>${d.port}</td>
   				<td>${d.shiyan.labDesc}</td>
   				<td>${d.position}</td>
   				<td><s:if test='status=="Y"'>可用</s:if>
   				<s:else>禁用</s:else></td>
   				<td><s:date name="createDate" format="yyyy-MM-dd" /></td>
   				<td>${d.createBy}</td>
   				<td>
   					<input type="button" value="删除" onclick="fun9(${d.deviceId})"/>&nbsp;&nbsp;&nbsp;&nbsp;
   					<input type="button" value="修改" onclick="fun4(${d.deviceId})"/>
   				</td>
   			</tr>	
  		</s:iterator>
		<tr align="right">
			<td colspan="10">第<font color="red">${page}</font>页|共<font color="red">${yeshu}</font>页|共<font color="red">${jilu}</font>条记录|<input type="button" id="frist" onclick="fun7(${1})" value="首页" />|<input type="button" id="shang" onclick="fun7(${page-1})" value="上一页" />|<input type="button" id="xia" onclick="fun7(${page+1})" value="下一页" />|<input type="button" onclick="fun7(${yeshu})" id="last" value="尾页" />
							<input type="hidden" id="page" value="${page}">
							<input type="hidden" id="yeshu" value="${yeshu}">
			</td>
		</tr>
</table>
