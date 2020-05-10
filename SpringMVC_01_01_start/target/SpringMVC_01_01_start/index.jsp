<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/5/2
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
    <a href="mvc/hello">入门程序</a><br/><br/>
    <a href="mvc/hello2?username=djx&password=666">入门程序(@RequestMapping属性值测试)</a><br/><br/>
    <a href="mvc/hello3?username=djx&password=666">入门程序参数基本类型String类型绑定</a><br/><br/>
    <div style="border: 2px black solid">
        <h3>入门程序参数类类型绑定</h3>
        <form action="mvc/hello4" method="post">
            账户：<input type="text" name="accountName"/><br/>
            密码：<input type="password" name="accountPassword"/><br/>
            姓名：<input type="text" name="user.userName"/><br/>
            年龄：<input type="text" name="user.userAge"/><br/>
            <input type="submit" value="提交"/>
        </form>
    </div>
    <a href="mvc/hello5?date=1997-10-20">入门程序参数测试String转Date</a><br/><br/>
    <a href="mvc/hello6">入门程序servlet原生request和response对象</a><br/><br/>
    <a href="mvc/hello7?username=444">入门程序注解@RequestParam</a><br/><br/>
    <div style="border: 2px black solid">
        <h3>入门程序注解@RequestBody</h3>
        <form action="mvc/hello8" method="post">
            账户：<input type="text" name="accountName"/><br/>
            密码：<input type="password" name="accountPassword"/><br/>
            姓名：<input type="text" name="user.userName"/><br/>
            年龄：<input type="text" name="user.userAge"/><br/>
            <input type="submit" value="提交"/>
        </form>
    </div>
    <a href="mvc/hello9/4444">入门程序注解@PathVariable</a><br/><br/>
    <a href="mvc/hello10">入门程序注解@CookieValue</a><br/><br/>
</body>
</html>
