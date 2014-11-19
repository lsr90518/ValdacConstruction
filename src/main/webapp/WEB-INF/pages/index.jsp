<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/14/14
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="htmlframe/headFrame.jsp" />
<html>
<body class="skin-black">
<!-- header logo: style can be found in header.less -->
<c:import url="htmlframe/headerFrame.jsp"/>
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
                <div class="col-md-8">

                    <div class="nav-tabs-custom">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab_1" data-toggle="tab">最新バルブ</a></li>
                            <li class=""><a href="#tab_2" data-toggle="tab">編集履歴</a></li>

                            <div class="box-tools">
                                <div class="input-group">
                                    <input type="text" name="table_search" id="table_search" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search">
                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-default" id="table_search_btn"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <table class="table table-hover kouji-table">
                                    <thead>
                                        <tr>
                                            <th>工事番号</th>
                                            <th>工事名</th>
                                            <th>開始日付</th>
                                            <th>責任者</th>
                                            <th>状態</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${lastedKoujiList}" var="kouji">
                                        <tr>
                                            <td>${kouji.kjNo}</td>
                                            <td>${kouji.kjMeisyo}</td>
                                            <td>${kouji.bgnYmd}</td>
                                            <td>${kouji.responsibility}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${kouji.status == '1'}">
                                                        <span class="label label-success">完成</span>
                                                    </c:when>
                                                    <c:when test="${kouji.status == '0'}">
                                                        <span class="label label-warning">未完成</span>
                                                    </c:when>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <div class="operation-button">
                                                    <a class="btn btn-primary btn-sm operation-button-btn" href="/kouji/${kouji.id}"><i class="glyphicon glyphicon-pencil"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.tab-pane -->
                            <div class="tab-pane" id="tab_2">
                                <table class="table table-hover kouji-table">
                                    <thead>
                                        <tr>
                                            <th>工事番号</th>
                                            <th>工事名</th>
                                            <th>開始日付</th>
                                            <th>責任者</th>
                                            <th>状態</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${updatedKoujiList}" var="kouji">
                                        <tr>
                                            <td>${kouji.kjNo}</td>
                                            <td>${kouji.kjMeisyo}</td>
                                            <td>${kouji.bgnYmd}</td>
                                            <td>${kouji.responsibility}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${kouji.status == '1'}">
                                                        <span class="label label-success">完成</span>
                                                    </c:when>
                                                    <c:when test="${kouji.status == '0'}">
                                                        <span class="label label-warning">未完成</span>
                                                    </c:when>
                                                </c:choose>
                                            </td>

                                            <td>
                                                <div class="operation-button">
                                                    <a class="btn btn-primary btn-sm operation-button-btn" href="/kouji/${kouji.id}"><i class="glyphicon glyphicon-pencil"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <h3 class="panel-title">機器点検履歴</h3>
                        </div>
                        <div class="panel-body">

                            <div class="row well-sm">
                                <div class="col-md-12">
                                    <input type="text" class="form-control input-sm" placeholder="履歴から検索" />
                                </div>
                            </div>

                            <ul class="timeline">

                                <!-- timeline item -->
                                <li>
                                    <!-- timeline icon -->
                                    <i class="glyphicon glyphicon-check bg-green"></i>
                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 10 Feb. 2014</span>

                                        <%--<h3 class="timeline-header"><a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案) </h3>--%>

                                        <div class="timeline-body">
                                            <a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案)
                                        </div>

                                        <%--<div class='timeline-footer'>--%>
                                            <%--<a class="btn btn-primary btn-xs">...</a>--%>
                                        <%--</div>--%>
                                    </div>
                                </li>
                                <li>
                                    <!-- timeline icon -->
                                    <i class="glyphicon glyphicon-check bg-green"></i>
                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 10 Feb. 2014</span>

                                        <div class="timeline-body">
                                            <a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案)
                                        </div>

                                        <%--<div class='timeline-footer'>--%>
                                        <%--<a class="btn btn-primary btn-xs">...</a>--%>
                                        <%--</div>--%>
                                    </div>
                                </li>
                                <li>
                                    <!-- timeline icon -->
                                    <i class="glyphicon glyphicon-floppy-save bg-red"></i>
                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 10 Feb. 2014</span>

                                        <%--<h3 class="timeline-header"><a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案) </h3>--%>

                                        <div class="timeline-body">
                                            <a href="#">A</a> 機器番号(機器名称) -> (懸案)
                                        </div>

                                        <%--<div class='timeline-footer'>--%>
                                        <%--<a class="btn btn-primary btn-xs">...</a>--%>
                                        <%--</div>--%>
                                    </div>
                                </li>
                                <li>
                                    <!-- timeline icon -->
                                    <i class="glyphicon glyphicon-check bg-green"></i>
                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 10 Feb. 2014</span>

                                        <%--<h3 class="timeline-header"><a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案) </h3>--%>

                                        <div class="timeline-body">
                                            <a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案)
                                        </div>

                                        <%--<div class='timeline-footer'>--%>
                                        <%--<a class="btn btn-primary btn-xs">...</a>--%>
                                        <%--</div>--%>
                                    </div>
                                </li>
                                <li>
                                    <!-- timeline icon -->
                                    <i class="glyphicon glyphicon-check bg-green"></i>
                                    <div class="timeline-item">
                                        <span class="time"><i class="fa fa-clock-o"></i> 10 Feb. 2014</span>

                                        <%--<h3 class="timeline-header"><a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案) </h3>--%>

                                        <div class="timeline-body">
                                            <a href="#">A</a> 機器番号(機器名称) -> 点検ランク(懸案)
                                        </div>

                                        <%--<div class='timeline-footer'>--%>
                                        <%--<a class="btn btn-primary btn-xs">...</a>--%>
                                        <%--</div>--%>
                                    </div>
                                </li>
                                <!-- END timeline item -->

                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section><!-- /.content -->
</div><!-- ./wrapper -->

<!-- add new calendar event modal -->

<script type="text/javascript">
    $(document).ready(function(){

        $(".kouji-table tr").mouseover(function(obj){
            var tr = $(obj.currentTarget)[0];
            $(tr).find(".operation-button").css("opacity","1");
        });
        $(".kouji-table tr").mouseout(function(obj){
            var tr = $(obj.currentTarget)[0];
            $(tr).find(".operation-button").css("opacity","0");
        });

        $("#table_search").keyup(function(){
            var keyword = $("#table_search").val();
            if(keyword.length > 0) {
                var trs = $(".active .kouji-table tbody tr");
                for (var i = 0; i < trs.length; i++) {
                    $(trs[i]).hide();
                    //是否是头
                    var ths = $(trs[i]).find("th");
                    if(ths.length > 0){
                        $(trs[i]).show();
                        continue;
                    }
                    //不是头的行
                    var tds = $(trs[i]).find("td");

                    for (var j = 0; j < tds.length; j++) {
                        var tmpHtml = new String(tds[j].innerHTML);
                        if (tmpHtml.match(keyword)) {
                            $(trs[i]).show();
                            break;
                        }
                    }
                }
            } else {
                var trs = $(".active .kouji-table tbody tr");
                for (var i = 0; i < trs.length; i++) {
                    $(trs[i]).show();
                }
            }
        });

    });
</script>

<c:import url="htmlframe/footerFrame.jsp" />

</body>
</html>
