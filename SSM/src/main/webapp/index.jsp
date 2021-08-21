<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/2/8
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询所有</a><br/>

    <hr/>

    <form action="account/saveAccount" method="get">
        name:<input type="text" name="name"> <br/>
        money:<input type="text" name="money"> <br/>
        <input type="submit" value="提交">
    </form>

</body>
</html>
