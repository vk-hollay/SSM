<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/1/25
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="user/hello">入门程序</a><br/>

    <a href="user/testRequestMapping?username=heihei">RequestMapping注解</a><br/>

    <%--请求参数绑定--%>
    <a href="user/testParam?username=hehe&password=123">请求参数绑定</a>

    <hr/>

    <h4>把数据封装到Account类中，类中存在另一个JavaBean的类和类中存在list和map集合</h4>
    <form action="user/saveAccount" method="post">
        姓名:<input type="text" name="username"/><br/>
        密码:<input type="password" name="password"><br/>
        金额:<input type="text" name="money"><br/>

        用户姓名:<input type="text" name="user.uname"><br/>
        用户年龄:<input type="text" name="user.age"><br/>

        用户姓名:<input type="text" name="list[0].uname"><br/>
        用户年龄:<input type="text" name="list[0].age"><br/>

        用户姓名:<input type="text" name="map['one'].uname"><br/>
        用户年龄:<input type="text" name="map['one'].age"><br/>
        <input type="submit" value="提交"><br/>
    </form>

    <hr/>

    <h4>自定义类型转换器</h4>
    <form action="user/saveUser" method="post">

        用户姓名:<input type="text" name="uname"><br/>
        用户年龄:<input type="text" name="age"><br/>
        用户生日:<input type="date" name="date"><br/>
        <%--date类型得到的日期字符串是xxxx-xx-xx，后端如果用Date接收，
        接收的字符串必须是xxxx/xx/xx，所以需要自定义类型转换器--%>
        <input type="submit" value="提交"><br/>
    </form>

    <hr/>

    <%--如何使用Servlet原生API--%>
    <a href="user/testServlet?aaa=123">Servlet原生的API</a>

    <hr/>

    <h4>常用的注解：</h4>
    <%--@RequestParam注解--%>
    <a href="anno/testRequestParam?username=哈哈哈">@RequestParam注解</a><br/><br/>

    @RequestBody注解
    <form action="anno/testRequestBody" method="post">
        用户姓名:<input type="text" name="name"><br/>
        用户年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交"><br/>
    </form>

    <%--@PathVariable注解--%>
    <a href="anno/testPathVariable/10">@PathVariable注解</a><br/>

    <%--@RequestHeader--%>
    <a href="anno/testRequestHeader">@RequestHeader注解</a><br/>

    <%--@CookieValue--%>
    <a href="anno/testCookieValue">@CookieValue注解</a><br/><br/>

    @ModelAttribute注解，写法一
    <form action="anno/testModelAttribute1" method="post">
        用户姓名:<input type="text" name="uname"><br/>
        用户年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交"><br/>
    </form>

    @ModelAttribute注解，写法二
    <form action="anno/testModelAttribute2" method="post">
        用户姓名:<input type="text" name="uname"><br/>
        用户年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交"><br/>
    </form>

    @SessionAttributes注解<br/>
    <a href="anno/testSessionAttributes">testSessionAttributes，向session域中存入值</a><br/>

    <a href="anno/getSessionAttributes">getSessionAttributes， 从session域中获取值</a><br/>

    <a href="anno/delSessionAttributes">delSessionAttributes， 删除session</a><br/><br/>
</body>
</html>
