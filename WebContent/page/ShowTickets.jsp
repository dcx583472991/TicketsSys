<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta name="viewport" content="width=device-width" />
		<title>订票信息</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script type="text/javascript" src="js/js.js" charset="UTF-8"></script>
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
			
			h2{
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
			
			.span1{
				font-size: 16px;
				font-family: ”微软雅黑”;
				font-weight: bold;
				color: rgb(0,0,190);
			}
			
			#querryPageForm{
				float: left;
				margin-right: 150px;
			}
			
			#choosePage{
				float: left;
			}
			
		</style>
	</head>
  
  <body>
 
  	<div>
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">					
				<a href="#" class="navbar-brand"><strong>主页</strong></a>
				<ul class="nav navbar-nav">
					<li><a href="./resetPwd.jsp">修改密码</a></li>
					<li><a href="./Book.jsp">机票预订</a></li>
					<li class="active"><a href="QuerryAllByUserNameAction">预订信息</a></li>
					<li><a href="LogOutAction">退出系统</a></li>
				</ul>
			</div>
		</nav>
	</div>
  	<h2>您的机票预订信息</h2>
  	<div class="table-responsive">
	  	<table id="table1" class="table table-striped .table-hover .table-condensed .table-bordered col-md-offset-2" cellpadding="0" cellspacing="0" border="1" width="70%" >
				<tr >
					<th>姓名</th>
					<th>始发城市</th>
					<th>目的城市</th>
					<th>出发日期</th>
					<th>操作</th>
					<!-- <th>ID号</th> -->
				</tr>
				<!-- 使用OGNL表达式 -->
				<%--<s:iterator value="#session.bookList" status="bk" var="book"> --%>
				<s:iterator value="#session.bookList" status="bk" var="book">
				
					<tr>
						<td><s:property value="#book.name"/></td>
						<td><s:property value="#book.startCity"/></td>
						<td><s:property value="#book.endCity"/></td>
						<td><s:property value="#book.date"/></td>
						
						<td>
							<a role="button" class="btn btn-primary" href="javascript:queryBookDetails('<s:property value="#book.id"/>')">修改</a>
							<a role="button" class="btn btn-info" href="javascript:DeleteBookInfo('<s:property value="#book.id"/>')">删除</a>
						</td>
						<%-- <td><s:property value="#book.id"/></td> --%>
					</tr>
				</s:iterator>			
		</table>
		
		
		<div class="col-md-offset-2">
			<div id="querryPageForm" class="col-md-offset-3">
				<form method="post" action="QueryInPageAction">
					<input  class="btn btn-success col-md-offset-6 span1" type="submit" value="分页显示订票信息"/>
				</form>
			</div>
			<a id="choosePage" href="QueryInPageAction?pageNo=1"><span class="span1">首页</span></a>
				
				<c:choose>
					<c:when test="${currentPage>1}">
						[<a href="QueryInPageAction?pageNo=${currentPage-1}">上一页</a>]
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${currentPage<totalPage}">
						[<a href="QueryInPageAction?pageNo=${currentPage+1}">下一页</a>]
					</c:when>
				</c:choose>
			<a href="QueryInPageAction?pageNo=${totalPage}"><span class="span1">尾页</span></a>
		</div>
	<br/><br/>
  	</div>
  </body>
</html>
