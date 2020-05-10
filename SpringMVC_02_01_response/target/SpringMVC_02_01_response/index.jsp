<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/5/4
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
               // alert("inter");
                $.ajax({
                    url:"user/toAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"userName":"邓爽","password":"7733","age":"1"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.userName);
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="user/toString">toString</a><br/><br/>
    <a href="user/toVoid">toVoid</a><br/><br/>
    <a href="user/toStringForward">toStringForward</a><br/><br/>
    <a href="user/toModelAndView">toModelAndView</a><br/><br/>
    <button id="btn">点击发送Ajax</button><br/><br/>
</body>
</html>
