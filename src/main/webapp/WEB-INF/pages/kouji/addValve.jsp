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
                <div class="panel panel-default">
                    <div class="panel-body table-panel">
                        <table class="table table-hover table-striped select-table">
                            <tr>
                                <th><input type="checkbox" class="headCheckbox" onclick="selectAllItem()"></th>
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
                            <tr class="valve-item">
                                <td><input type="checkbox" class="checkbox" style="opacity: 0" value="${valve.kikiSysId}"></td>
                                <td>${valve.vNo}</td>
                                <td>${valve.benMeisyo}</td>
                                <td>${valve.keisiki}</td>
                                <td>${valve.sousa}</td>
                                <td>${valve.classType}</td>
                                <td>${valve.yobikei}</td>
                                <td>${valve.aturyokuMax}${valve.tani}</td>
                                <td>${valve.ryutai}</td>
                            </tr>
                        </c:forEach>
                        </table>
                    </div>
                    <div class="panel-footer">
                        <form action="/kouji/${kouji.id}/valve" id="valveListForm" method="post">
                            <input type="hidden" name="idList" id="idList" value="" />
                            <button class="btn btn-success btn-sm" onclick="submitForm()">確定</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- information tab -->
        </div>
    </section>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $('.valve-item').mouseup(function(obj){
            var tr = obj.currentTarget;
            var selected = $(tr).find('.checkbox');
            var checkbox = selected[0];
            if($(checkbox).prop("checked") == true){
                $(checkbox).prop('checked', false);
                $(tr).removeClass("bg-light-blue-gradient");
            } else {
                $(checkbox).prop('checked', true);
                $(tr).addClass("bg-light-blue-gradient");
            }
        });
    });

    function selectAllItem(){
        if(!$('.headCheckbox').prop('checked')){
            $('.select-table').find('.checkbox').each(function(){
                var checkbox = $(this)[0];
                if($(checkbox).prop('checked')== true) {
                    $(checkbox).prop('checked', false);
                }
            });
            $('.select-table').find('.valve-item').each(function(){
                var tr = $(this)[0];
                if($(tr).hasClass('bg-light-blue-gradient')){
                    $(tr).removeClass("bg-light-blue-gradient");
                }
            });
        } else {
            $('.select-table').find('.checkbox').each(function(){
                var checkbox = $(this)[0];
                if($(checkbox).prop('checked')== true) {
                }
                else {
                    $(checkbox).prop('checked', true);
                }
            });
            $('.select-table').find('.valve-item').each(function(){
                var tr = $(this)[0];
                if($(tr).hasClass('bg-light-blue-gradient')){
                }
                else {
                    $(tr).addClass("bg-light-blue-gradient");
                }
            });
        }
    }

    function submitForm(){
        var idList = "";
        $('.checkbox:checked').each(function(){
            idList = idList + $(this)[0].value + ',';
        });
        $('#idList').val(idList);
//        return false;
    }

</script>
</body>
</html>
