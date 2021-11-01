<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>登录</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/admins/css/bootstrap.css">
    <script src="/static/admins/js/jquery-2.1.0.js"></script>
</head>
<body style="background:#fbf8ef;background-size:100%;">
<div id="Lawyer_bg">
    <div class="alert alert-danger text-center">${msg}</div>
    <form class="form-horizontal Lawyer_bg" action="/loginDo" align="center">
        <table align="center">
            <tr>
                <td align="right">姓名:</td>
                <td><input class="form-control" type="text" id="eName" placeholder="请输入姓名:" name="username" size="20" onblur="userName()" /></td>
                <td>
                    <div id="user_eName"></div>
                </td>
            </tr>
            <td align="right">密码:</td>
            <td><input class="form-control" type="password" id="ePass" placeholder="请输入密码：" name="password" size="20" onblur="userePass()" /></td>
            <td>
                <div id="user_ePass"></div>
            </td>
            </tr>
            <tr>
                <td>
                    <button class="btn btn-lg btn-success btn-block" id="Log_in" onclick="return check()">登录</button>
                </td>
                <td><button type="reset">重置</button></td>
                <td><button>
                    <a href="InsertLawyerUse.jsp">注册</a>
                </button></td>
            </tr>
        </table>
    </form>
</div>

<script type="text/javascript">
    var a,b;
    function check() {
        return a&&b;
    }
    
    function userName() {
        var name = document.getElementById("eName").value;
        var text = document.getElementById("user_eName");
        if(name.length > 1 && name.length < 21) {
            text.style.color = "green";
            text.innerHTML = "输入正确";
            a=true;
        } else {
            text.style.color = "red";
            text.innerHTML = "不在2到20之间";
            a=false;
        }
    };

    function userePass() {
        var ePass = document.getElementById("ePass").value;
        var text = document.getElementById("user_ePass");
        var telpatterm = /^[A-z0-9]*$/;
        if(telpatterm.test(ePass)) {
            if(ePass.length > 1 && ePass.length < 21) {
                text.style.color = "green";
                text.innerHTML = "输入正确";
                b=true;
            } else {
                text.style.color = "red";
                text.innerHTML = "不在2到20之间";
                b=false;
            }
        } else {
            text.style.color = "red";
            text.innerHTML = "必须是数字和字母";
            b=false;
        }
    };
</script>
</body>
</html>