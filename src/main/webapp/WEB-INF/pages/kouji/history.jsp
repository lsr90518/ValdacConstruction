<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/18/14
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../htmlframe/headFrame.jsp"/>
<html>
<head>
    <title>工事支援</title>
</head>
<body class="skin-black">
<!-- header logo: style can be found in header.less -->
<c:import url="../htmlframe/headerFrame.jsp"/>
<div class="container">
    <!-- Left side column. contains the logo and sidebar -->

    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            <i class="glyphicon glyphicon-wrench"> ${kouji.kjMeisyo}test</i>
            <span class="label label-warning">status</span>
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-dashboard"></i> Index/${kouji.kjMeisyo}test</li>
        </ol>
    </section>
    <hr/>

    <section class="content">
        <div class="row">
            <div class="col-md-10">
                <ul class="timeline">

                    <!-- timeline time label -->
                    <li class="time-label">
                        <span class="bg-red">
                            10 Feb. 2014
                        </span>
                    </li>
                    <!-- /.timeline-label -->

                    <!-- timeline item -->
                    <li>
                        <!-- timeline icon -->
                        <i class="fa fa-envelope bg-blue"></i>
                        <div class="timeline-item">
                            <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                            <h3 class="timeline-header"><a href="#">Support Team</a> ...</h3>

                            <div class="timeline-body">
                                ...
                                Content goes here
                            </div>

                            <div class='timeline-footer'>
                                <a class="btn btn-primary btn-xs">...</a>
                            </div>
                        </div>
                    </li>
                    <!-- END timeline item -->

                    ...

                </ul>
            </div>
            <!-- information tab -->
            <div class="col-md-2">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-pills nav-stacked bookmarkUl">
                            <li role="presentation"><a href="/kouji/index">情報</a></li>
                            <li role="presentation" class="currentBookmark"><a href="/kouji/history">履歴</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- tab button tab -->
        </div>
    </section>
</div>
</body>
</html>
