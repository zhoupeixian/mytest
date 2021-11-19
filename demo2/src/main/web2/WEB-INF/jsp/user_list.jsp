<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>客户列表</title>
<meta charset="utf-8"/>
	<link rel="stylesheet" href="/static/css/bootstrap.css"/>
	<link rel="stylesheet" href="/static/css/admin.css"/>
	<link rel="stylesheet" href="/static/css/amazeui.min.css"/>
	<script type="text/javascript" src="/static/js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="/static/js/right.js"></script>
</head>
<body>
<div class="container">

	<%@include file="../../header.jsp"%>
	
	<div class="text-right"><a class="btn btn-warning" href="user_add">添加客户</a></div>
		
	<br>
	
	<table class="table table-bordered table-hover" id="shua0">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">用户</th>
		<th width="10%">姓名</th>
		<th width="10%">电话</th>
		<th width="10%">地址</th>
		<th width="15%">操作</th>
	</tr>
	<c:if test="${pageInfo.total!=0}">
	<c:forEach var="user" items="${pageInfo.list}">
         <tr>
         	<td><p>${user.id}</p></td>
         	<td><p>${user.username}</p></td>
         	<td><p>${user.name}</p></td>
         	<td><p>${user.phone}</p></td>
         	<td><p>${user.address}</p></td>
			<td>
				<a class="btn btn-info" href="user_reset?id=${user.id}&username=${user.username}&password=${user.password}">重置密码</a>
				<a class="btn btn-primary" href="userEdit?id=${user.id}">修改</a>
				<a class="btn btn-danger" href="userDelete?id=${user.id}">删除</a>
			</td>
       	</tr>
	</c:forEach>
	</c:if>
	<c:if test="${pageInfo.total == 0}">
		<tr>
			<td colspan="12" style="text-align: center;">暂无数据！</td>
		</tr>
	</c:if>
	</table>
	<c:if test="${pageInfo.total!=0}">
		<div class="am-cf" id="shua">
			共 ${pageInfo.total} 条记录
			<div class="am-fr">
				<ul class="am-pagination">
					<c:if test="${pageInfo.pageNum>1}">
						<li>
							<a href="#" onclick="findByPage(${pageInfo.pageNum - 1},4,0,${begin},${end},'userList')">«</a>
						</li>
					</c:if>
					<c:if test="${pageInfo.pageNum == 1}">
						<li class="am-disabled">
							<a href="#" onclick="findByPage(${pageInfo.pageNum - 1},4,0,${begin},${end},'userList')">«</a>
						</li>
					</c:if>
					<li>
						<a id="left" href="#" onclick="return right(0,${begin},1,${pageInfo.pageNum - 1},${begin},${end},'userList');">上一页</a>
					</li>
					<c:forEach begin="${begin}" end="${end}" step="1" var="i">
						<c:if test="${pageInfo.pageNum == i}">
							<li class="am-active">
								<a href="userList?page=${i}&length=4">${i}</a>
							</li>
						</c:if>
						<c:if test="${pageInfo.pageNum != i}">
							<li>
								<a href="userList?page=${i}&length=4">${i}</a>
							</li>
						</c:if>
					</c:forEach>
					<li>
						<a id="right" href="#" onclick="return right(1,${end},${pageInfo.pages},${pageInfo.pageNum + 1},${begin},${end},'userList');">下一页</a>
					</li>
					<c:if test="${pageInfo.pageNum < pageInfo.pages}">
						<li>
							<a href="#" onclick="findByPage(${pageInfo.pageNum + 1},4,1,${begin},${end},'userList')">»</a>
						</li>
					</c:if>
					<c:if test="${pageInfo.pageNum == pageInfo.pages}">
						<li class="am-disabled">
							<a href="#" onclick="findByPage(${pageInfo.pageNum + 1},4,1,${begin},${end},'userList')">»</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</c:if>
</div>
<script type="text/javascript">
</script>
</body>
</html>