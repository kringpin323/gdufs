<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<table width="100%" border="1" cellspacing="0" cellpadding="0" id="tableId">
  <tr id="find" >
    <th >&nbsp;</th><th >帐号</th><th >姓名</th><th >手机</th><th >院系</th><th >专业</th> <th >班级</th> <th >卡号</th><<th>状态<th >操作 </th>
  </tr>
  
  
  <s:iterator value="userInfos" var="ui">
  <tr align="center"><td><input type="checkbox" value="${ui.userId}"></td><td>${ui.userId}</td><td>${ui.userName}</td><td>${ui.mobile}</td><td>${ui.department}</td><td>${ui.major}</td><td>${ui.class_}</td><td>${ui.rfid}</td>
  
  <s:if test='status=="1"'>
  <td>可用</td>
  </s:if>
  <s:else>
  <td>停用</td>
  </s:else>
  
  <td>
  <s:if test='status=="1"'>
  <a  href="javascript:del('${ui.userId}')" style="text-decoration: none"> 停用 </a>
  </s:if>
  <s:else>
    <a  href="javascript:open('${ui.userId}')" style="text-decoration: none"> 启用 </a>
  </s:else>
  <a  href="javascript:upd('${ui.userId}')" style="text-decoration: none"> 修改  </a><a href='systemManger_toRightSet?userId=${ui.userId}' style="text-decoration: none">设置权限</a>
  <a href="javascript:toDoorRight('${ui.userName}','${ui.userId}','${ui.rfid}')" style="text-decoration: none;cursor: pointer;" >门襟权限</a></td></tr>
  </s:iterator>
  
</table >
  <table border="1"  cellpadding="0" cellspacing="0"><tr><td><input type="button" value="下载数据 "  onClick='toExcel()'/></td><td> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td><td>总共${recodes }记录,当前是 ${currentPage}/${totalPage }页<a href=javascript:firsPage() style="text-decoration: none">首页 </a><a href=javascript:prevPage() id='prevPage' style="text-decoration: none">前一页 </a><a href="javascript:nextPage()" id='nextPage' style="text-decoration: none">后一页 </a><a href="javascript:lastPage()" style="text-decoration: none">尾页  <input type='hidden' value="${currentPage}" id='hid' ><input type='hidden' value="${totalPage}" id='hid1' ></a></td></tr></table>

   
