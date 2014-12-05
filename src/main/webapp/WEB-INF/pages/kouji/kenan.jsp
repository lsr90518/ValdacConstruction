<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 12/4/14
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../htmlframe/headFrame.jsp" />
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
            <c:choose>
                <c:when test="${kouji.status == '未完成'}">
                    <span class="label label-warning">${kouji.status}</span>
                </c:when>
                <c:when test="${kouji.status == '完成'}">
                    <span class="label label-success">${kouji.status}</span>
                </c:when>

            </c:choose>

        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-dashboard"></i> Index/${kouji.kjMeisyo}</li>
        </ol>
    </section>
    <hr/>

    <section class="content">

        <div class="row">
            <div class="col-md-11">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-md-10">
                                <h4>懸案リスト</h4>
                            </div>
                            <div class="col-md-2">
                                <input type="text" placeholder="keyword" onkeyup="searchDataTd(this)" class="pull-right form-control" />
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-hover" id="kenan-table">
                            <thead>
                                <tr>
                                    <th>弁番号</th>
                                    <th>機器名</th>
                                    <th>事象</th>
                                    <th>部品</th>
                                    <th>発見状況</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${kenanFormList}" var="kenanForm">
                                    <tr class="data-tr" id="${kenanForm.id}">
                                        <td class="data-td">${kenanForm.valve.vNo}</td>
                                        <td class="data-td">${kenanForm.kiki.kikiMei}</td>
                                        <td class="data-td">${kenanForm.gensyo}</td>
                                        <td class="data-td">${kenanForm.buhin}</td>
                                        <td class="data-td">${kenanForm.hakkenJyokyo}</td>
                                        <td>
                                            <button onclick="editKenan(this)" class="btn btn-xs btn-default bg-red-gradient"><i class="fa fa-edit"> </i></button>
                                            <a href="/kenan/${kenanForm.id}/delete" class="btn btn-xs btn-default bg-blue-gradient"><i class="glyphicon glyphicon-trash"> </i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div><!-- information tab -->
            <div class="col-md-1">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-pills nav-stacked bookmarkUl">
                            <li role="presentation" ><a href="/kouji/${kouji.id}"><i class="glyphicon glyphicon-cog"> </i></a></li>
                            <li role="presentation"><a href="/kouji/${kouji.id}/instruct"><i class="glyphicon glyphicon-indent-left"> </i></a></li>
                            <li role="presentation" class="currentBookmark"><a href="/kouji/${kouji.id}/kenan"><i class="glyphicon glyphicon-floppy-save"> 懸案</i></a></li>
                            <li role="presentation"><a href="/kouji/${kouji.id}/history"><i class="glyphicon glyphicon-time"> </i></a></li>
                            <li role="presentation"><a href="/kouji/${kouji.id}/image"><i class="glyphicon glyphicon-picture"> </i></a></li>
                        </ul>
                    </div>
                </div>
            </div><!-- tab button tab -->
        </div>
    </section>
</div>
</body>

<!-- Modal -->
<div class="modal fade" id="kenanModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">懸案追加</h4>
            </div>
            <div class="modal-body">
                <form id="kenanForm" action="/kenan/updateKenan" name="kenanForm" method="post">

                    <div class="row form-group">
                        <div class="col-md-12">
                            <h3>
                                <i class="glyphicon glyphicon-wrench"> <span class="kenanForm-span" id="koujiInfo"></span></i>
                            </h3>
                        </div>
                    </div>

                    <div class="row form-group">
                        <div class="col-md-2"></div>
                        <div class="col-md-10">
                            <span class="kenanForm-span" id="kikisysInfo"></span>
                        </div>
                    </div>
                    <input type="hidden" id="kenanId" class="kenanForm-input" name="id" value="" />
                    <input type="hidden" id="kenanKoujiId" class="kenanForm-input" name="koujiId" value="" />
                    <input type="hidden" id="kenanKoujirelationId" class="kenanForm-input" name="koujirelationId" value="" />
                    <input type="hidden" id="kenanKikiId" class="kenanForm-input" name="kikiId" value="" />

                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <h3 class="panel-title">懸案状況</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row form-group">
                                <div class="col-md-3">
                                    <input type="text" name="jisyo" id="jisyo" class="form-control kenanForm-input" value="" placeholder="事象" />
                                </div>
                                <div class="col-md-3">
                                    <input type="text" name="buhin" id="buhin" class="form-control kenanForm-input" value="" placeholder="部品" />
                                </div>
                                <div class="col-md-3">
                                    <input type="text" name="gensyo" id="gensyo" class="form-control kenanForm-input" value="" placeholder="現象" />
                                </div>
                                <div class="col-md-3">
                                    <input type="text" name="taisaku" id="taisaku" class="form-control kenanForm-input" value="" placeholder="対策" />
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-4">
                                    <input type="text" name="hakkenJyokyo" id="hakkenJyokyo" class="form-control kenanForm-input" value="" placeholder="発見状況" />
                                </div>
                                <div class="col-md-4">
                                    <input type="text" name="youin" id="youin" class="form-control kenanForm-input" value="" placeholder="要因" />
                                </div>
                                <div class="col-md-4">
                                    <input type="text" name="syotiNaiyou" id="syotiNaiyou" class="form-control kenanForm-input" value="" placeholder="処置内容" />
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-4">
                                    <input type="text" name="hakkenDate" id="hakkenDate" class="form-control kenanForm-input" value="" placeholder="発見日付" />
                                </div>
                                <div class="col-md-4">
                                    <input type="text" name="taisakuDate" id="taisakuDate" class="form-control kenanForm-input" value="" placeholder="対策日付" />
                                </div>
                                <div class="col-md-4">
                                    <input type="text" name="taiouFlg" id="taiouFlg" class="form-control kenanForm-input" value="" placeholder="対応" />
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="updateKenan()" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function editKenan(obj){
        var kenanTr = $(obj).parent().parent();
        var kenanId = kenanTr[0].id;
        console.log(kenanId);
        $.get("/kenan/getKenanByIdInSession",{"id":kenanId},function(data){
            var koujiFormData = JSON.parse(data);
            $(".kenanForm-input").val("");
            var koujiInfo = koujiFormData.kouji.kjNo + "/" + koujiFormData.kouji.kjMeisyo;
            $("#koujiInfo").html(koujiInfo);
            var kikisysInfo = koujiFormData.valve.vNo + " ( " + koujiFormData.valve.benMeisyo + " ) / " + koujiFormData.kiki.kikiMei;
            $("#kikisysInfo").html(kikisysInfo);
            $("#kenanId").val(kenanId);
            $("#kenanKoujiId").val(koujiFormData.koujiId);
            $("#kenanKoujirelationId").val(koujiFormData.koujirelationId);
            $("#kenanKikiId").val(koujiFormData.kikiId);
            $("#jisyo").val(koujiFormData.jisyo);
            $("#buhin").val(koujiFormData.buhin);
            $("#gensyo").val(koujiFormData.gensyo);
            $("#taisaku").val(koujiFormData.taisaku);
            $("#hakkenJyokyo").val(koujiFormData.hakkenJyokyo);
            $("#youin").val(koujiFormData.youin);
            $("#syotiNaiyou").val(koujiFormData.syotiNaiyou);
            $("#hakkenDate").val(koujiFormData.hakkenDate);
            $("#taisakuDate").val(koujiFormData.taisakuDate);
            $("#taiouFlg").val(koujiFormData.taiouFlg);
            $("#kenanModal").modal();
        })
    }

    function searchDataTd(obj){
        if(obj.value.length < 1){
            $(".data-tr").show();
        }
        var dataTr = $(".data-tr");
        var keyword = new String(obj.value);
        for(var i = 0;i<dataTr.length;i++){
            $(dataTr[i]).hide();
            var dataTd = $(dataTr[i]).find(".data-td");
            for(var j = 0;j<dataTd.length;j++){
                var htmlData = new String(dataTd[j].innerHTML);
                if(htmlData.indexOf(keyword) > -1){
                    $(dataTr[i]).show();
                    break;
                }
            }
        }
    }

    function updateKenan(){
        $("#kenanForm").submit();
    }

</script>
</html>