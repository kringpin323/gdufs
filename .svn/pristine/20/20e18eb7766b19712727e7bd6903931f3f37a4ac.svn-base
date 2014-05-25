<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<table width="750" border="1" cellpadding="0" cellspacing="0"> 
		<thead>
		<tr><th>传感器名称</th><th>传感器编号</th><th>参数值</th><th>报警时间</th></tr>
		</thead>
<s:iterator value="alarmLists" var="alar">
<tr>
<s:iterator value="alar" status="st">
  <td align="center">${alar[st.count-1]}</td>
  </s:iterator>
  </tr>
</s:iterator>
 <tr><td colspan="4" align="center">总共${recodes }记录,当前是 ${currentPage}/${totalPage }页<a href=javascript:firsPage() style="text-decoration: none">首页 </a><a href=javascript:prevPage() id='prevPage' style="text-decoration: none">前一页 </a><a href="javascript:nextPage()" id='nextPage' style="text-decoration: none">后一页 </a><a href="javascript:lastPage()" style="text-decoration: none">尾页  <input type="hidden" value="${currentPage}" id='hid' ><input type="hidden" value="${totalPage}" id='hid1' ></a></td></tr> 
 

</table>



