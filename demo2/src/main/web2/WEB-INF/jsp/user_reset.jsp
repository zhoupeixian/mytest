<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>重置密码</title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="/static/css/bootstrap.css"/>
	<script type="text/javascript" src="/static/js/jquery-2.1.0.js"></script>
</head>
<body>
<div class="container">

	<%@include file="../../header.jsp"%>

	<br><br>
		
	<c:if test="${msg != null}">
		<div class="alert alert-success" role="alert">${msg}</div>
	</c:if>
	
	<form class="form-horizontal" action="userReset" method="post">
		<input type="hidden" name="id" value="${id}">
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">用户名</label>
			<div class="col-sm-5">${username}</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">密码</label>
			<div class="col-sm-6">
				<input type="text" onblur="passCheck(${password})" class="form-control" id="input_name" name="password" value="" required="required">
			</div>
			<div id="text1"></div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">重复输入密码</label>
			<div class="col-sm-6">
				<input type="text" onblur="passCheck(${password})" class="form-control" id="input_name1" name="password1" value="" required="required">
			</div>
			<div id="text2"></div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" onclick="return checks()" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
	<script type="text/javascript">
		var check1=false,check2=false;
		function passCheck(pass) {
			var password = $("#input_name").val();
			var password1 = $("#input_name1").val();
			if (password != "") {
				if (password == pass) {
					document.getElementById("text1").innerHTML = "新密码不能与原密码一致！"
					check1=false;
				}else {
					document.getElementById("text1").innerHTML = ""
					check1=true;
				}
				if (password1 != "" && password1 != password) {
					document.getElementById("text2").innerHTML = "前后密码不一致！"
					check2=false;
				}else {
					document.getElementById("text2").innerHTML = ""
					check2=true;
				}
			}else {
				document.getElementById("text1").innerHTML = ""
				document.getElementById("text2").innerHTML = ""
				check1=false;
				check2=false;
			}
		}
		
		function checks() {
			if (check1 && check2){
				return true;
			}else {
				return false;
			}
		}

	</script>
</div>	
</body>
</html>