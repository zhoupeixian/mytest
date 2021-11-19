<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>登录页</title>
<h1 align="center">欢迎登陆</h1>
<body>
<div id="Lawyer_bg">
    <form action="/admins/loginDo"  class="Lawyer_bg" align="center">
        <table align="center">
            <tr>
                <td align="right">姓名:</td>
                <td><input type="text" id="eName" placeholder="请输入姓名:" name="username" size="20" onblur="username()" /></td>
                <td>
                    <div id="user_eName"></div>
                </td>
            </tr>
            <td align="right">密码:</td>
            <td><input type="password" id="ePass" placeholder="请输入密码：" name="password" size="20" onblur="userePass()" /></td>
            <td>
                <div id="user_ePass"></div>
            </td>
            </tr>
            <tr>

            <tr>
                <td>
                    <button id="Log_in" onclick="validate()">登录</button>
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
    function username() {
        var name = document.getElementById("eName").value;
        var text = document.getElementById("user_eName");
        if(name.length > 1 && name.length < 21) {
            text.style.color = "green";
            text.innerHTML = "输入正确";
        } else {
            text.style.color = "red";
            text.innerHTML = "不在2到20之间";
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
            } else {
                text.style.color = "red";
                text.innerHTML = "不在2到20之间";
            }
        } else {
            text.style.color = "red";
            text.innerHTML = "必须是数字和字母";
        }
    };
</script>

</body>
</html>
