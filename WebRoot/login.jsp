<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
   <title>登录</title>
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<link href="css/style1.css" rel="stylesheet" type="text/css">
	
	<style type="text/css">
	#Layer1 {
	position:relative;
	width:732px;
	height:572px;
	border:0px solid;
	float:right;
}

    </style>
	
	<script  src="js/jquery-1.4.min.js"></script>
	<script type="text/javascript">
	
		function login(type) {
			var userid = $('#userid').val();
			var password = $('#password').val();
			if (userid == '' || password == '') {

				alert('用户名或密码不能为空');
				return;
			}
			if (type == 1) {
				var ob = $('#form1');
				ob.submit();
			} else {

				document.getElementById('form1').action = 'login!schoolLogin';
				$('#form1').submit();
			}

		}

		function cacel() {
			$('#userid').val('');
			$('#password').val('');

		}

		function chg(objID1, objID2) {
			document.getElementById(objID2).src = objID1;
		}
	</script>
	
	
</head>
<body>
	<div id="container">
		<div id="header">
			<img src="image/header.png" width="1002" height="80" />
		</div>


		<div class="clearfloat"></div>
		<div id="nav">
			<div class="clearfloat"></div>
			<div id="nav_l"></div>
			<div class="clearfloat"></div>
			<div id="nav_r"></div>
			<div class="clearfloat"></div>
			<div class="nav_main">
				<ul>
					<li><a href="javascript:chg('waite.html','ifrm1')"><span>智慧实验室</span>
					</a>
					</li>
					<li><a href="javascript:chg('waite.html','ifrm1')"><span>Quanta技术中心</span>
					</a>
					</li>
					<li><a href="javascript:chg('waite.html','ifrm1')"><span>&nbsp;&nbsp;&nbsp;最新公告</span>
					</a>
					</li>
					<li><a href="javascript:chg('waite.html','ifrm1')"><span>&nbsp;&nbsp;&nbsp;关于我们</span>
					</a>
					</li>
				</ul>
			</div>

		</div>

		<div class="clearfloat"></div>
		<div id="maincontent">
			<div id="side">
				<img src="image/side.png" />
				<div id=earth>
					<img src="image/earth_play.gif" />

				</div>
				<form action="login!login" method="post" id="form1">
					<div id=user_login>
						<UL>
							<LI class=user_main_text>用户名:</LI>
							<LI class=user_main_input><INPUT class=TxtUserNameCssClass
								id="userid" maxLength=20 name="userid"
								style='border-left:0px;border-top:0px;border-right:0px;border-bottom:0px '>
							</LI>
						</UL>
						<UL>
							<LI class=user_main_text>密 码:</LI>
							<LI class=user_main_input><INPUT class=TxtPasswordCssClass
								id="password" type=password name="password"></LI>
						</UL>

					</div>

					<div id=button1>
						<UL>
							<li><input type="submit" style="width: 165px;"
								onclick="login(1)" value="普通入口 "
								onMouseMove="src='image/login_button_on.png'"
								onMouseOut="src='image/login_button.png'" />
							</li>
						</UL>
					</div>

					<div id=button1>
						<UL>
							<li><input type="button" style="width: 165px;"
								onclick="login(2)" value="数字广外 "
								onMouseMove="src='image/login_button_on.png'"
								onMouseOut="src='image/login_button.png'" />
							</li>
						</UL>
					</div>

					<div id=button2>
						<UL>
							<li><input type="image" onclick="cacel()"
								src="image/cancel_button.png"
								onMouseMove="src='image/cancel_button_on.png'"
								onMouseOut="src='image/cancel_button.png'" />
							</li>
						</UL>
					</div>
				</form>
				<div id=password_modify>
					<UL>
						<li><a href="#"><span>修改密码</span>
						</a>
						</li>
					</UL>
				</div>
				<div align="center">
					<span style="color:red">${Msg_error}</span>
				</div>
			</div>
			<div id="main"></div>

			<div id="Layer1">
				<iframe id="ifrm1" name="ifrm1" width="100%" height="100%"
					src="MyHtml.html"></iframe>
			</div>
		</div>

	</div>
</body>
</html>
