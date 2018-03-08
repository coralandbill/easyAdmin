<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from www.zi-han.net/theme/hplus/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:23 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name">M+</h1>
        </div>
        <h3>欢迎使用后台管理系统</h3>

        <form class="m-t" role="form" action="/admin/login.do" method="post">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="用户名" name="name" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="密码" name="pass" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

            <c:if test="${not empty error}">
                <p class="text-muted text-center" style="color: red;">${error}</p>
            </c:if>
            <%--<p class="text-muted text-center"><a href="login.html#">
                <small>忘记密码了？</small>
            </a> | <a href="register.html">注册一个新账号</a>
            </p>--%>

        </form>
    </div>
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:18:23 GMT -->
</html>
