<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/19/14
  Time: 10:15 AM
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
            <i class="glyphicon glyphicon-wrench"> ${kouji.kjMeisyo}</i>
            <span class="label label-warning">未完成</span>
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-dashboard"></i> Index/${kouji.kjMeisyo}</li>
        </ol>
    </section>
    <hr/>

    <section class="content">
        <div class="row" id="step-row">
            <div class="col-md-4 step-div first-step-complete">
                <span class="glyphicon glyphicon-calendar"> 1. 工事情報追加</span>
            </div>
            <div class="col-md-4 step-div">
                <span class="glyphicon glyphicon-list"> 2. 点検バルブ選択</span>
            </div>
            <div class="col-md-4 step-div">
                <span class="glyphicon glyphicon-indent-left"> 3. 点検機器選択</span>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover table-striped">
                    <tr>
                        <th><input type="checkbox"></th>
                        <th>弁番号</th>
                        <th>弁名称</th>
                        <th>形式</th>
                        <th>操作</th>
                        <th>クラス</th>
                        <th>呼び径</th>
                        <th>圧力</th>
                        <th>流体</th>
                    </tr>

                <c:forEach items="${valveList}" var="valve">
                    <tr>
                        <td><input type="checkbox" value="${valve.kikiSysId}"></td>
                        <td>${valve.vNo}</td>
                        <td>${valve.benMeisyo}</td>
                        <td>${valve.keisiki}</td>
                        <td>${valve.sousa}</td>
                        <td>${valve.classType}</td>
                        <td>${valve.yobikei}</td>
                        <td>${valve.aturyokuMax}${valve.tani}</td>
                        <td>${valve.ryutai}</td>
                    </tr>
                    ${valve.kikiSysId}
                </c:forEach>
                </table>
            </div>
            <!-- information tab -->
        </div>
    </section>
</div>
<script type="text/javascript">
    $(document).ready(function(){

    });


</script>
</body>
</html>
