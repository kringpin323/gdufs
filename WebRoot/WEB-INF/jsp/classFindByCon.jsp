<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="100%" border="1" cellspacing="0" cellpadding="0" >
  <tr >
  <th >实验室名称</th><th >开始执行时间</th><th >时间段</th><th >是否循环</th><th >循环类型</th><th >运行时期</th><th >课程名称</th><th >老师</th> <th >专业</th> <th >班级</th><th >提前开门</th><th >延迟关门</th><th >操作 </th>
  </tr>
  
  
  <s:iterator value="css" var="cst">
  <tr align="center"><td>${cst.labId}</td><td>${cst.beginDate}</td><td>第 ${cst.classhourId} 节</td><td>${cst.isRepetitive}</td><td>${cst.cycleType}</td><td>${cst.cycle}</td><td>${cst.coursesName}</td><td>${cst.teacher}</td><td>${cst.major}</td><td>${cst.class_}</td><td>${cst.openDoorAdvance}</td><td>${cst.closeDoorDelay}</td><td><a  href="javascript:del('${cst.clsTimTbllD}')" style="text-decoration: none"> 删除 </a></td></tr>
  </s:iterator>
  
</table >
  <table border="1" width="100%" cellpadding="0" cellspacing="0"><tr><td align="center">总共${recodes }记录,当前是 ${currentPage}/${totalPage }页<a href=javascript:firsPage() style="text-decoration: none">首页 </a><a href=javascript:prevPage() id='prevPage' style="text-decoration: none">前一页 </a><a href="javascript:nextPage()" id='nextPage' style="text-decoration: none">后一页 </a><a href="javascript:lastPage()" style="text-decoration: none">尾页  <input type="hidden" value="${currentPage}" id='hid' ><input type='hidden' value="${totalPage}" id='hid1' ></a></td></tr></table>

   
