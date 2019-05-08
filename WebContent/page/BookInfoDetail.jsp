<%@ page language="java" import="java.util.*,bean.Book" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta name="viewport" content="width=device-width" />
		<title>修改密码</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<style type="text/css">
			body{
				/*background-image: url(../bg2.jpg);*/
			}
			
			#id1{
				margin-top: 50px;
				
			}
			
			.form-group{
				width: 35%;
			}
			
			h3{
				text-align: center;
				margin-top: 80px;
			}
			
			#span1{
				font-weight:bold;
				font-size:16px;
			}
			
			#table1{
				width:70%
			}
			
		</style>
	</head>
  
  <body>
  	<div>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">					
				<a href="#" class="navbar-brand"><strong>主页</strong></a>
				<ul class="nav navbar-nav">
					<li><a href="">修改密码</a></li>
					<li><a href="">机票预订</a></li>
					<li><a href="">预订信息</a></li>
					<li><a href="LogOutAction">退出系统</a></li>
				</ul>
			</div>
		</nav>
		</div>
		<h3>修改订票信息</h3>
		<!-- hidden="hidden" -->
		<div id="id1" class="col-md-offset-5">
			<form action="UpdataBookInfoAction" method="post">
				<%
					Book book=(Book)(request.getSession().getAttribute("book"));
				 %>
				<div  class="form-group" style="display:none;">
					<label>Id号</label>
					<input name="book.id" value="<s:property value="book.id"/>" type="text" class="form-control" readonly />
				</div>
				<div  class="form-group" style="display:none;">
					<label>用户名</label>
					<input value="<%=book.getUserName() %>" name="book.userName" type="text" class="form-control" readonly/>
				</div>
				<div  class="form-group" style="display:none;">
					<label>真实姓名</label>
					<input value="<%= book.getName() %>" name="book.name" type="text" class="form-control" readonly/>
				</div>
				<div class="form-group">
					<label>始发城市</label>
					<input name="book.StartCity" type="text" class="form-control" placeholder="StartCity" />
				</div>
				<div class="form-group">
					<label>目的城市</label>
					<input name="book.EndCity" type="text" class="form-control" placeholder="EndCity" />
				</div>
				<div class="form-group">
					<label>出发日期</label>
					<input name="book.Date" type="date" class="form-control" />
				</div>
				<input  class="btn btn-group-vertical col-md-offset-3" type="submit" value="提交"/>
			</form>		
		</div>
	
	</body>
</html>