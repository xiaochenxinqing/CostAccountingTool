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
    <title>成本核算系统-登录</title>
    <meta charset="utf-8">
    <meta http-equiv="Cache-Control" content="no-cache"/>
    <meta http-equiv="expires" content="0">
    <meta name="keywords" content="华创软件成本核算系统">
    <meta name="description" content="华创软件成本核算系统">
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/statics/css/login.min.css" rel="stylesheet">


</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <img style="border-radius: 20px" src="http://www.whcsoft.com/templets/default/images/diy/logo.png"
                         alt="">

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
                <strong>还没有账号？ <a style="color: inherit" href="javascript:alert('暂不支持注册！')">立即注册&raquo;</a></strong>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" action="${pageContext.request.contextPath }/user/dologin.do">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">成本核算系统<span style="color: red">${error}</span></p>
                <input type="text" class="form-control uname" placeholder="用户账号" name="userCode"/>
                <input type="password" class="form-control pword m-b" placeholder="密码" name="passWord"/>
                <a style="color: inherit" href="javascript:alert('暂不支持找回密码！')">忘记密码了？</a>
                <button class="btn btn-success btn-block">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2017 All Rights Reserved. <strong> <a style="color: inherit" href="http://www.whcsoft.com">华创软件&raquo;</a></strong>
        </div>
    </div>
</div>


<script type="text/javascript">
    if (window.top !== window.self) {
        window.top.location = window.location
    }

</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login_v2.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Mar 2016 12:30:01 GMT -->
</html>
