<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>主页面</title>
<body>
<div id="Lawyer_bg">
    <a href="../../../resources/static/login.jsp">退出</a>
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
