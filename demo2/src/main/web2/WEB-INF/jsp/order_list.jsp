<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>订单列表</title>
	<link rel="stylesheet" href="static/css/bootstrap.css"/>
	<link rel="stylesheet" href="/static/css/admin.css"/>
	<link rel="stylesheet" href="/static/css/amazeui.min.css"/>
	<script type="text/javascript" src="/static/js/jquery-2.1.0.js"></script>
	<script type="text/javascript" src="/static/js/right.js"></script>
</head>
<body>
<div style="height: 770px; overflow-y: auto; overflow-x:hidden;">
<div class="container">

	<%@include file="../../header.jsp" %>
	
	<br>
	
	<ul role="tablist" class="nav nav-tabs">
        <li <c:if test='${status==0}'>class="active"</c:if> role="presentation"><a href="orderList?page=1&length=4&begin=1&end=4&status=0">全部订单</a></li>
        <li <c:if test='${status==1}'>class="active"</c:if> role="presentation"><a href="orderList?page=1&length=4&begin=1&end=4&status=1">未付款</a></li>
        <li <c:if test='${status==2}'>class="active"</c:if> role="presentation"><a href="orderList?page=1&length=4&begin=1&end=4&status=2">已付款</a></li>
        <li <c:if test='${status==3}'>class="active"</c:if> role="presentation"><a href="orderList?page=1&length=4&begin=1&end=4&status=3">配送中</a></li>
        <li <c:if test='${status==4}'>class="active"</c:if> role="presentation"><a href="orderList?page=1&length=4&begin=1&end=4&status=4">已完成</a></li>
    </ul>
    
    <br>
	<table class="table table-bordered table-hover">

	<tr>
		<th width="5%">ID</th>
		<th width="5%">总价</th>
		<th width="15%">订单详情</th>
		<th width="20%">收货信息</th>
		<th width="10%">订单状态</th>
		<th width="10%">支付方式</th>
		<th width="10%">下单用户</th>
		<th width="10%">下单时间</th>
		<th width="10%">操作</th>
	</tr>
	<c:if test="${pageInfo.total!=0}">
	<c:forEach var="order" items="${pageInfo.list}">
         <tr>
         	<td><p>${order.id}</p></td>
         	<td><p>${order.total}</p></td>
         	<td>
	         	<c:forEach var ="item" items="${order.itemsList}">
		         	<a target="_blank" href="../index/detail?id=${item.good.id}"><p>${item.good.name}</p></a>
		         	<p>¥${item.price} x ${item.amount}</p>
	         	</c:forEach>
         	</td>
         	<td>
         		<p>${order.name}</p>
         		<p>${order.phone}</p>
         		<p>${order.address}</p>
         	</td>
			<td>
				<p>
					<c:if test="${order.status==1}">未付款</c:if>
					<c:if test="${order.status==2}"><span style="color:red;">已付款</span></c:if>
					<c:if test="${order.status==3}">配送中</c:if>
					<c:if test="${order.status==4}">已完成</c:if>
				</p>
			</td>
			<td>
				<p>
					<c:if test="${order.paytype==1}">微信</c:if>
					<c:if test="${order.paytype==2}">支付宝</c:if>
					<c:if test="${order.paytype==3}">货到付款</c:if>
				</p>
			</td>
			<td><p>${order.user.username}</p></td>
			<td><p><fmt:formatDate value="${order.systime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
			<td>
				<c:if test="${order.status==2}">
					<a class="btn btn-success" href="orderUpdate?id=${order.id}&status=3">发货</a>
				</c:if>
				<c:if test="${order.status==3}">
					<a class="btn btn-warning" href="orderUpdate?id=${order.id}&status=4">完成</a>
				</c:if>
				<a class="btn btn-danger" href="orderDelete?id=${order.id}">删除</a>
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
							<a href="#" onclick="findByPage(${pageInfo.pageNum - 1},4,0,${begin},${end},'orderList')">«</a>
						</li>
					</c:if>
					<c:if test="${pageInfo.pageNum == 1}">
						<li class="am-disabled">
							<a href="#" onclick="findByPage(${pageInfo.pageNum - 1},4,0,${begin},${end},'orderList')">«</a>
						</li>
					</c:if>
					<li>
						<a id="left" href="#" onclick="return right(0,${begin},1,${pageInfo.pageNum - 1},${begin},${end},'orderList');">上一页</a>
					</li>
					<c:forEach begin="${begin}" end="${end}" step="1" var="i">
						<c:if test="${pageInfo.pageNum == i}">
							<li class="am-active">
								<a href="orderList?page=${i}&length=4">${i}</a>
							</li>
						</c:if>
						<c:if test="${pageInfo.pageNum != i}">
							<li>
								<a href="orderList?page=${i}&length=4">${i}</a>
							</li>
						</c:if>
					</c:forEach>
					<li>
						<a id="right" href="#" onclick="return right(1,${end},${pageInfo.pages},${pageInfo.pageNum + 1},${begin},${end},'orderList');">下一页</a>
					</li>
					<c:if test="${pageInfo.pageNum < pageInfo.pages}">
						<li>
							<a href="#" onclick="findByPage(${pageInfo.pageNum + 1},4,1,${begin},${end},'orderList')">»</a>
						</li>
					</c:if>
					<c:if test="${pageInfo.pageNum == pageInfo.pages}">
						<li class="am-disabled">
							<a href="#" onclick="findByPage(${pageInfo.pageNum + 1},4,1,${begin},${end},'orderList')">»</a>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</c:if>
</div>
</div>
<script type="text/javascript">
</script>
</body>
</html>