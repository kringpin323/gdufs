<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="63%" border="1" cellspacing="0" cellpadding="0" id="tableId">
  
  <tr><td>
  <s:iterator value="groupInfos" var="gi">
  <input type="checkbox" name="cbs" value="${gi.groupId}" />${gi.groupName}&nbsp&nbsp
  </s:iterator>
  <a  href="javascript:sureModiyGroup()">确定修改</a>
  </td></tr>
</table >
 

   
