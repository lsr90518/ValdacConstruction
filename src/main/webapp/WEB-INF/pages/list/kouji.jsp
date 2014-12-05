<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 12/4/14
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../htmlframe/headFrame.jsp" />
<html>
<body class="skin-black">
<!-- header logo: style can be found in header.less -->
<c:import url="../htmlframe/headerFrame.jsp"/>
<div class="container">
    <!-- Left side column. contains the logo and sidebar -->

    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            工事支援
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-dashboard"></i> Index</li>
        </ol>
    </section>
    <hr/>
    <!-- Main content -->
    <section class="content">

        <div class="row">
            <!-- collection -->
            <div class="col-md-4">
                <div class="btn-group" role="group">
                    <a href="/list" class="btn btn-default bg-yellow active">工事</a>
                    <a href="/list/kenan" class="btn btn-default">懸案</a>
                    <a href="/list/tenken" class="btn btn-default">点検履歴</a>
                </div>
            </div>
            <div class="col-md-2">
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="keyword">
                      <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><i class="glyphicon glyphicon-search"> </i></button>
                      </span>
                </div><!-- /input-group -->
            </div>
        </div>

        <hr/>

        <div class="row">
            <!-- collection -->
            <div class="col-md-12">
            </div>
        </div>

    </section><!-- /.content -->
</div><!-- ./wrapper -->

<c:import url="../htmlframe/footerFrame.jsp" />

</body>
</html>

