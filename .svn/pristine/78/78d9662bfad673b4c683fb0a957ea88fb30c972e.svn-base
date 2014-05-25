<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="63%" border="1" cellspacing="0" cellpadding="0" id="tableId">
  <tr id="find" >
   <th >帐号</th><th >用户名字</th><th >用户组编号</th><th >用户组名字</th><th >操作 </th>
  </tr>
  
 
  <s:iterator value="userObject" var="ui" status="st">

  <tr align="center"><td>${ui[2]}</td><td>${ui[3]}</td><td>${ui[0]}</td><td>${ui[1]}</td><td><a  href="javascript:modiyGroup('${ui[2]}','${ui[0]}')" style="text-decoration: none"> 修改用户组 </a></td></tr>

  </s:iterator>

</table >
 

   
