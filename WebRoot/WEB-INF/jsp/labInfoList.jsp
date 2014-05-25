<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="70%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <th width="15%" scope="col">
    </th>
    <th width="15%" scope="col">实验室名称</th>
    <th width="20%" scope="col">实验室描述</th>
     <th width="10%" scope="col">实验室状态</th>
  	<th  scope="col">操作</th>
  </tr>
  
  <s:iterator value="labInfos" var="lab">
  <tr>
    <td align="center"><input type="checkbox" name="checkbox" value="${lab.labId }" /></td>
    <td align="center"><input type="text" value="${lab.labId }" size="10" readonly="readonly"  id="labId${lab.labId}"/></td>
    <td align="center"><input type="text" value="${lab.labDesc }"  size="10" readonly="readonly"  id="labDesc${lab.labId}"/></td>
  	
  	<td align="center"><input type="text" value="${lab.status}"  size="10" readonly="readonly"  id="status${lab.labId}"/></td>
  	<td align="center"> <a href="javascript:upd('${lab.labId}')">实验室修改</a>  &nbsp<a href="systemManger_toRight?labId=${lab.labId}">权限设置</a></td>
  
  </tr>
  </s:iterator>
 
</table>