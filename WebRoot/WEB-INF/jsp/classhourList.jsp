<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="34%" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <th width="17%" scope="col">

    </th>
    <th width="21%" scope="col">开始时间</th>
    <th width="25%" scope="col">结束时间</th>
  	<th width="25%" scope="col">操作</th>
  </tr>
  
  <s:iterator value="ccList" var="chi">
  <tr>
    <td align="center"><input type="checkbox" name="checkbox" value="${chi.classhourId }" /></td>
    <td align="center"><input type="text" value="${chi.beginDate }" size="5" readonly="readonly" name="beginDate" id="beginDate${chi.classhourId}"/></td>
    <td align="center"><input type="text" value="${chi.endDate }"  size="5" readonly="readonly" name="endDate"/ id="endDate${chi.classhourId}"></td>
  	<td align="center"> <a href="javascript:upd(${chi.classhourId})">课时修改</a></td>
  
  </tr>
  </s:iterator>
 
</table>