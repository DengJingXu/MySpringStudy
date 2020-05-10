<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/5/4
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统文件上传</h3>
    <form action="user/fileupload" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="fileupload"/>
        <input type="submit" value="上传">
    </form>
    <h3>springmvc文件上传</h3>
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件:<input type="file" name="upload"/>
        <input type="submit" value="上传">
    </form>
</body>

</html>
