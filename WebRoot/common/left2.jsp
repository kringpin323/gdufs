<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>物联网智能管理实验室</title>
<style type="text/css">
#container {
	width: 1002px;
	margin: 0 auto;
	margin-bottom: 0px;
	background-position: center;
	background-color: #A0A0A4;
}

#menu {
	width: 201px;
	margin-bottom: 0px;
	float: left;
}

a {
	text-decoration: none;
}

.has_children {
	text-align: left;
	margin: 0px;
	padding: 0px;
	padding-left: 4px;
	line-height: 30px;
	margin-top: 0px;
	font-weight: bold;
	font-size: 12px;
	background-image: url(images/tittle22.png);
	color: #FFF;
	cursor: pointer;
}

.highlight {
	text-align: left;
	margin: 0px;
	padding: 0px;
	padding-left: 0px;
	line-height: 30px;
	margin-top: 0px;
	font-weight: bold;
	font-size: 12px;
	color: #225271;
	background-image: url(images/tittle11.png);
}

.darken {
	text-align: left;
	margin: 0px;
	padding: 0px;
	padding-left: 0px;
	line-height: 30px;
	margin-top: 0px;
	font-weight: bold;
	font-size: 12px;
	color: #fff;
	background-image: url(images/tittle33.png);
}

div a {
	text-align: left;
	padding-left: 24px;
	border-bottom: 0px;
	overflow: hidden;
	height: auto;
	margin-left: 0px;
	background-image: url(images/textbg2.png);
	display: none;
	font-weight: 100;
	color: #2A3F55;
	float: left;
	width: 201px;
}

a:hover {
	color: #F00;
	font-family: Verdana, Geneva, sans-serif;
}

a:now {
	color: #F00;
}

.exit {
	text-align: center;;
	margin: 0px;
	padding: 0px;
	line-height: 30px;
	margin-top: 0px;
	font-weight: bold;
	font-size: 12px;
	color: #FFF;
}
</style>
<!-- 引入 jQuery -->
<script src="js/test.js" type="text/javascript"></script>
<script src="js/chang.js"></script>
<script type="text/javascript">
	//等待dom元素加载完毕.
	$(document).ready(
			function() {
				$(".has_children").click(
						function() {
							if (($(this).find("a").length) > 0) {
								change_bg();
								$(this).addClass("highlight").children("a")
										.show().end().siblings().removeClass(
												"highlight").children("a")
										.hide();
							}

						});

				$(".has_children").each(function() {

					if (($(this).find("a").length) == 0) {
						$(this).addClass("darken");
					}
				});

				$("#labUse").trigger("click");

			});
</script>
</head>
<body background="images/tt.jpg">
	<div id="menu">

		<div class="has_children" id="labUse">
			<span>实验室使用</span> <a href="lab_doorContorl" target="right">门禁监控</a>

		</div>


		<div class="has_children">
			<span>实验室申请</span>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys01'">
					<a href="lab_waite.action" target="right">设备维护申请</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys02'">
					<a href="lab_waite.action" target="right">实验室使用申请</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys03'">
					<a href="lab_waite.action" target="right">信息查询</a>
				</s:if>
			</s:iterator>

		</div>

		<div class="has_children">
			<span>实验室监控</span>
			<s:if test='#session.userInfo.logMode=="1"'>
				<s:iterator value="#session.rightids" status="status">
					<s:if test="#session.rightids[#status.index]=='sys04'">
						<a href="lab_spControl" target="right">视频监控</a>
					</s:if>
				</s:iterator>

				<s:iterator value="#session.rightids" status="status">
					<s:if test="#session.rightids[#status.index]=='sys05'">
						<a href="lab_lightControl" target="right">灯光监控</a>
					</s:if>
				</s:iterator>


				<s:iterator value="#session.rightids" status="status">
					<s:if test="#session.rightids[#status.index]=='sys06'">
						<a href="lab_airConditioner" target="right">空调监控</a>
					</s:if>
				</s:iterator>




				<s:iterator value="#session.rightids" status="status">
					<s:if test="#session.rightids[#status.index]=='sys08'">
						<a href="lab_switchControl" target="right">电源监控</a>
					</s:if>
				</s:iterator>

				<s:iterator value="#session.rightids" status="status">
					<s:if test="#session.rightids[#status.index]=='sys09'">
						<a href="lab_safeControl" target="right">安防监控</a>
					</s:if>
				</s:iterator>
			</s:if>
		</div>

		<div class="has_children">
			<span>实验室管理</span>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys10'">
					<a href="lab_waite.action" target="right">设备维护确认</a>
				</s:if>
			</s:iterator>


			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys11'">
					<a href="lab_waite.action" target="right">实验室申请确认</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys07'">
					<a href="lab_waite.action" target="right">实验室值班登记</a>
				</s:if>
			</s:iterator>


		</div>

		<div class="has_children">
			<span>物资管理</span>
			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys12'">
					<a href="lab_waite.action" target="right">设备管理</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys13'">
					<a href="lab_waite.action" target="right">家俱管理</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys14'">
					<a>耗材管理</a>
				</s:if>
			</s:iterator>


		</div>
		<div class="has_children">
			<span>导航管理</span>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys16'">
					<a href="paike!toPaiKe.action" target="right">导航表查看</a>
				</s:if>
			</s:iterator>

			<!--     <s:iterator value="#session.rightids" status="status">
    	<s:if test="#session.rightids[#status.index]=='sys17'">
  <a href="paike!listClass.action" target="right">导航表编辑</a>
  		</s:if>
 </s:iterator> 
 -->

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys24'">
					<a href="paike!classManager.action" target="right">导航表管理</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys25'">
					<a href="paike!toAddClasshour.action" target="right">时间段管理</a>
				</s:if>
			</s:iterator>

		</div>
		<div class="has_children">
			<span>用户管理</span>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys18'">
					<a href="systemManger_toUserInfo" target="right">文本框输入</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys19'">
					<a href="systemManger_toImportUserInfo" target="right">智能卡录入</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys28'">
					<a href="systemManger_UserGroup" target="right">用户组管理</a>
				</s:if>
			</s:iterator>
		</div>
		<div class="has_children">
			<span>系统管理</span>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys29'">
					<a href="lab_toSafeDoor" target="right">安全门</a>
				</s:if>
			</s:iterator>





			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys20'">
					<a href="systemManger_toLabStauSet" target="right">运行模式</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys21'">
					<a href="systemManger_toAutoSet" target="right">参数设定</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys23'">
					<a href="lab_toLabManager.action" target="right">增加实验室</a>
				</s:if>
			</s:iterator>




			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys27'">
					<a href="shebei!addLabinfo.action" target="right">智能设备管理</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys26'">
					<a href="can!listshiyanshi.action" target="right">智能设备设置</a>
				</s:if>
			</s:iterator>



			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys22'">
					<a href="systemManger_toLabRecode" target="right">使用记录查询</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys29'">
					<a href="lab_toUpdDoorPwd.action" target="right">门襟密码修改</a>
				</s:if>
			</s:iterator>




		</div>

		<div class="has_children">
			<span>通告管理</span>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys01'">
					<a href="announce!toAddAnnounce.action" target="right">新增通告</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys01'">
					<a href="announce!toCheckAnnounce.action" target="right">查看通告</a>
				</s:if>
			</s:iterator>

			<s:iterator value="#session.rightids" status="status">
				<s:if test="#session.rightids[#status.index]=='sys01'">
					<a href="announce!toDelAnnounce.action" target="right">删除通告</a>
				</s:if>
			</s:iterator>

		</div>

		<div class="exit">
			<span><input type="image" src="images/exit2.png"
				onclick="window.location.href='sysOut'"
				onMouseMove="src='images/exit2_on.png'"
				onMouseOut="src='images/exit2.png'" /> </span>
		</div>

	</div>
</body>
</html>