<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
      <table width="100%" border="1" cellspacing="0" cellpadding="0">
        <tr>
          <th scope="col">实验室:${labID }<div style="border-top:1px dashed #000000;height: 2px;overflow:hidden;"></div> ${cdate}<div style="border-top:1px dashed #000000;height: 2px;overflow:hidden;"></div>第${week}周<div style="border-top:1px dashed #000000;height: 2px;overflow:hidden;"></div></th>
          <th width="12%" scope="col">日</th>
          <th width="12%" scope="col">一</th>
          <th width="12%" scope="col">二</th>
          <th width="12%" scope="col">三</th>
          <th width="12%" scope="col">四</th>
          <th width="12%" scope="col">五</th>
          <th width="12%" scope="col">六</th>
        </tr>
       <%
       String[][]  courses=(String[][])request.getAttribute("courses");  
        	for(int n=0;n<courses.length;n++){
        	String[] course=courses[n];
        %>
        <tr>
          <% for(int i=0;i<course.length;i++){
          %>
          <td align="center"><%=course[i]==null?"　":course[i]%></td>
          <%} %>
        </tr>
        
      <%}
      Date d=(Date)request.getAttribute("cdate");
      Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DATE,-7);
        java.util.Date t=c.getTime();
     java.sql.Date  dq=new java.sql.Date(t.getTime());
      
     c.add(Calendar.DATE,14);
     java.util.Date th=c.getTime();
     java.sql.Date  dh=new java.sql.Date(th.getTime());
      
       %>
      <tr><td colspan="3" align="center">
      <s:if test="week==1">	前一周</s:if>
      <s:else>
      <a href="javascript:labTable('${labID}','<%=dq%>')" style="text-decoration: none">前一周</a> </s:else><input type="hidden" value="${labID}" id="everyLabId"/></td >
      <td colspan="3" align="center"><a href="javascript:labTable('${labID }','<%=dh%>')" style="text-decoration: none">后一周</a></td >
       <td colspan="2" align="center">转到第    
  		 <select  id="toChangWeeks" onchange="toChangWeeks()">
  		<s:iterator value="weeks" status="st" >
  		<option value="${st.count}" >${st.count}</option>
  		</s:iterator>    
       </select>
       周</td >
      
      </tr>
      
      
      <tr><td colspan="8" align="center"><input type="button" value="导出当前课程表"  onclick="toExcel('${labID}','${cdate}',${week})"/></td></tr>
      </table>      <p>&nbsp;<input value="${IP}" id="IP" type="hidden"></p></td>
  </tr>
</table>

   
