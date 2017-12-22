

<%--
User: x
Date: 2017/12/20
Time: 14:11
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--<%@include file="common/header.jsp"%>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>成本核算系统-登录</title>
    <meta name="keywords" content="华创软件成本核算系统">
    <meta name="description" content="华创软件成本核算系统">
    <link href="statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="statics/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="statics/css/animate.min.css" rel="stylesheet">
    <link href="statics/css/style.min.css" rel="stylesheet">
    <link href="statics/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>华创软件</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>成本核算系统</strong></h4>
                    <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                    </ul>
                    <strong>还没有账号？ <a href="javascript:alert('暂不支持注册！')">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="${pageContext.request.contextPath }/user/dologin.do">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到成本核算系统</p>
                    <input type="text" class="form-control uname" placeholder="用户账号" name="userCode" />
                    <input type="password" class="form-control pword m-b" placeholder="密码" name="passWord" />
                    <a href="javascript:alert('暂不支持找回密码！')">忘记密码了？</a>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2017 All Rights Reserved. 华创软件
            </div>
        </div>
    </div>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Mar 2016 12:30:01 GMT -->
</html>
