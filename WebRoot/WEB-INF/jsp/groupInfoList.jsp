<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="65%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <th width="16%" scope="col">多选框</th>
    <th width="12%" scope="col">用户组编号</th>
    <th width="12%" scope="col">用户组名称</th>
  	<th  scope="col">操作</th>
  </tr>
  
  <s:iterator value="groupInfos" var="gis">
  <tr>
    <td align="center"><input type="checkbox" name="checkbox" value="${gis.groupId}" /></td>
    <td align="center"><input type="text" value="${gis.groupId}" size="10" readonly="readonly" /></td>
    <td align="center"><input type="text" value="${gis.groupName}"  size="15" readonly="readonly" /></td>
  	<td align="center"> <a href="javascript:upd('${gis.groupId}','${gis.groupName}')">修改</a>
  	 <a href="systemManger_toGroupRightSet?groupId=${gis.groupId}">权限设置</a>
  	 <a href="javascript:GroupUserList('${gis.groupId}')">组成员查看</a>
  	</td>
  
  </tr>
  </s:iterator>
 
</table>