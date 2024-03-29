<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>商品添加</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="/static/css/bootstrap.css" />
</head>
<body>
<div class="container">
	<%@include file="../../header.jsp"%>

	<br><br>
	<form class="form-horizontal" action="goodSave" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">封面</label> 
			<div class="col-sm-6">
				<input type="file" name="file"  id="input_file" required="required" style="display:inline;"> ( 推荐尺寸: 500 * 500 )
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="name" required="required" placeholder="请输入文本">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">介绍</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="intro" required="required" placeholder="请输入文本">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">规格</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="spec" required="required" placeholder="请输入文本">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">价格</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="price" required="required" placeholder="请输入数字" onkeyup="this.value=this.value.replace(/[^\d]+/g,'')">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">库存</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" name="stock" required="required" placeholder="请输入数字" onkeyup="this.value=this.value.replace(/[^\d]+/g,'')">
			</div>
		</div>
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">类目</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="type_id">
					<c:forEach var="type" items="${typeList}">
						<option value="${type.id}">${type.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">详情</label>
			<div class="col-sm-6">
				<textarea id="editor" name="content" style="width:800px;height:600px;"></textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交保存</button>
			</div>
		</div>
	</form>
</div>

<script charset="utf-8" src="../editor/kindeditor-all.js"></script>
<script charset="utf-8" src="../editor/lang/zh-CN.js"></script>
<script charset="utf-8" src="../editor/editor.js"></script>
</body>
</html>