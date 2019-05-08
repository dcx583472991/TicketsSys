<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width" />
		<title>修改密码</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.min.js"></script>
		<style type="text/css">
			/**/body{
				background-image: url(bg2.jpg);
			}
			
			#id1{
				margin-top: 50px;
				
			}
			
			.form-group{
				width: 35%;
			}
			
			h3{
				text-align: center;
				margin-top: 120px;
			}
			
			#span1{
				font-weight:bold;
				font-size:16px;
			}
		</style>
	</head>
	<body>
		<div>
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				
				<a href="#" class="navbar-brand"><strong>主页</strong></a>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">修改密码</a></li>
					<li><a href="Book.jsp">机票预订</a></li>
					<li><a href="QuerryAllByUserNameAction">预订信息</a></li>
					<li><a href="">退出系统</a></li>
				</ul>
			</div>
			</nav>
		</div>
		
		<!-- 修改密码 -->
		<h3>修改密码</h3>
		<div id="id1" class="col-md-offset-5">
			<div class="col-md-offset-3">
				<span id="span1">用户名：<%=request.getSession().getAttribute("UserName") %></span>
			</div>
			<form action="resetPwdAction" method="post">
				<div class="form-group">
					<label>旧密码</label>
					<input name="oldPwd" type="password" class="form-control" placeholder="oldPassword" />
				</div>
				<div class="form-group">
					<label>新密码</label>
					<input name="newPwd" type="password" class="form-control" placeholder="newPassword" />
				</div>
				<div class="form-group">
					<label>新密码确认</label>
					<input name="newPwd2" type="password" class="form-control" placeholder="password" />
				</div>
				<input  class="btn btn-group-vertical col-md-offset-3" type="submit" value="确认"/>
			</form>
		</div>
		
	</body>
</html>
