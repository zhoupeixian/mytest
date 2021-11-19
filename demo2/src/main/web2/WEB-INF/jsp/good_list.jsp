<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>商品列表</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/static/css/bootstrap.css"/>
    <link rel="stylesheet" href="/static/css/admin.css"/>
    <link rel="stylesheet" href="/static/css/amazeui.min.css"/>
    <script type="text/javascript" src="/static/js/jquery-2.1.0.js"></script>
    <script type="text/javascript" src="/static/js/right.js"></script>
</head>
<body>
<div style="height: 770px; overflow-y: auto; overflow-x:hidden;">
<div class="container">

    <%@include file="../../header.jsp" %>

    <div class="text-right"><a class="btn btn-warning" href="goodAdd">添加商品</a></div>

    <br>

    <ul role="tablist" class="nav nav-tabs">
        <li
                <c:if test='${type==0}'>class="active"</c:if> role="presentation"><a href="goodList?type=0&page=1&length=4&begin=1&end=4">全部商品</a></li>
        <li
                <c:if test='${type==1}'>class="active"</c:if> role="presentation"><a href="goodList?type=1&page=1&length=4&begin=1&end=4">今日推荐</a>
        </li>
    </ul>


    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="3%">ID</th>
            <th width="5%">图片</th>
            <th width="10%">名称</th>
            <th width="10%">介绍</th>
            <th width="5%">规格</th>
            <th width="3%">价格</th>
            <th width="5%">类目</th>
            <th width="3%">库存</th>
            <th width="3%">销量</th>
            <th width="5%">操作</th>
        </tr>
        <c:if test="${pageInfo.total!=0}">
        <c:forEach var="good" items="${pageInfo.list}">
            <tr>
                <td><p>${good.id}</p></td>
                <td><p><a href="../index/detail?id=${good.id}" target="_blank"><img src="${good.cover}"
                                                                                    width="100px"></a></p></td>
                <td><p><a href="../index/detail?id=${good.id}" target="_blank">${good.name}</a></p></td>
                <td><p>${good.intro}</p></td>
                <td><p>${good.spec}</p></td>
                <td><p>${good.price}</p></td>
                <td><p>${good.typename}</p></td>
                <td><p>${good.stock}</p></td>
                <td><p>${good.sales}</p></td>
                <td>
                    <p>
                        <c:if test="${good.top}"><a class="btn btn-success topDelete" href="topsDelete?gid=${good.id}" type="1"
                                                    goodId="${good.id}" text="加入今日推荐">移出今日推荐</a></c:if>
                        <c:if test="${!good.top}"><a class="btn btn-primary topSave" href="/topsInsert?tid=${good.type_id}&gid=${good.id}" type="1"
                                                     goodId="${good.id}" text="移出今日推荐">加入今日推荐</a></c:if>
                    </p>
                    <a class="btn btn-info" href="goodEdit?cover=${good.cover}&id=${good.id}&name=${good.name}&intro=${good.intro}&spec=${good.spec}&price=${good.price}&typename=${good.typename}&stock=${good.stock}&sales=${good.sales}">修改</a>
                    <a class="btn btn-danger" href="goodDelete?id=${good.id}">删除</a>
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
                            <a href="#" onclick="findByPage(${pageInfo.pageNum - 1},4,0,${begin},${end},'goodList')">«</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum == 1}">
                        <li class="am-disabled">
                            <a href="#" onclick="findByPage(${pageInfo.pageNum - 1},4,0,${begin},${end},'goodList')">«</a>
                        </li>
                    </c:if>
                    <li>
                        <a id="left" href="#" onclick="return right(0,${begin},1,${pageInfo.pageNum - 1},${begin},${end},'goodList');">上一页</a>
                    </li>
                    <c:forEach begin="${begin}" end="${end}" step="1" var="i">
                        <c:if test="${pageInfo.pageNum == i}">
                            <li class="am-active">
                                <a href="goodList?page=${i}&length=4">${i}</a>
                            </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum != i}">
                            <li>
                                <a href="goodList?page=${i}&length=4">${i}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <a id="right" href="#" onclick="return right(1,${end},${pageInfo.pages},${pageInfo.pageNum + 1},${begin},${end},'goodList');">下一页</a>
                    </li>
                    <c:if test="${pageInfo.pageNum < pageInfo.pages}">
                        <li>
                            <a href="#" onclick="findByPage(${pageInfo.pageNum + 1},4,1,${begin},${end},'goodList')">»</a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.pageNum == pageInfo.pages}">
                        <li class="am-disabled">
                            <a href="#" onclick="findByPage(${pageInfo.pageNum + 1},4,1,${begin},${end},'goodList')">»</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </c:if>
</div>
</div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(function () {
        $(document).on("click", ".topSave", function () {
            var type = $(this).attr("type");
            var goodId = $(this).attr("goodId");
            var text = $(this).attr("text");
            var old = $(this).text();
            var obj = this;
            $.post("topSave", {"goodId": goodId, "type": type}, function (data) {
                if (data == "ok") {
                    $(obj).text(text).attr("class", "btn btn-success topDelete").attr("text", old);
                } else {
                    alert("操作失败!");
                }
            }, "text");
        });
        $(document).on("click", ".topDelete", function () {
            var type = $(this).attr("type");
            var goodId = $(this).attr("goodId");
            var text = $(this).attr("text");
            var old = $(this).text();
            var obj = this;
            $.post("topDelete", {"goodId": goodId, "type": type}, function (data) {
                if (data == "ok") {
                    $(obj).text(text).attr("class", "btn btn-primary topSave").attr("text", old);
                } else {
                    alert("操作失败!");
                }
            }, "text");
        });
    });
</script>
</body>
</html>