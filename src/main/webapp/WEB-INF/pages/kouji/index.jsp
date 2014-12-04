<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/14/14
  Time: 4:09 PM
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
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">工事情報</h3>
                        </div>
                        <form action="/kouji/updateKouji" method="post">
                            <input type="hidden" name="id" value="${kouji.id}"/>
                            <div class="panel-body">
                                <div class="row form-group">
                                    <div class="col-md-3">
                                        <input type="text" name="kjNo" class="form-control" value="${kouji.kjNo}" placeholder="工事番号" />
                                    </div>
                                    <div class="col-md-9">
                                        <input type="text" name="kjMeisyo" class="form-control" value="${kouji.kjMeisyo}" placeholder="工事名" />
                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-md-3">
                                        <input type="text" name="person" class="form-control" value="${kouji.person}" placeholder="責任者" />
                                    </div>
                                    <div class="col-md-2">
                                        <input type="text" name="bgnYmd" class="form-control" value="${kouji.bgnYmd}" placeholder="開始時間" />
                                    </div>
                                    <div class="col-md-2">
                                        <input type="text" name="endYmd" class="form-control" value="${kouji.endYmd}" placeholder="終了時間" />
                                    </div>
                                    <div class="col-md-2">
                                        <input type="text" name="nendo" class="form-control" value="${kouji.nendo}" placeholder="年度" />
                                    </div>

                                    <div class="col-md-2">
                                        <input type="text" name="nextYmd" class="form-control" value="${kouji.nextYmd}" placeholder="今度" />

                                    </div>
                                </div>

                                <div class="row form-group">
                                    <div class="col-md-4">
                                        <input type="text" name="location" class="form-control" value="${kouji.location}" />
                                    </div>
                                    <div class="col-md-4">
                                        <input type="text" name="syukan" class="form-control" value="${kouji.syukan}" placeholder="主管係" />
                                    </div>
                                    <div class="col-md-2">
                                        <select name="kjKbn" class="form-control">
                                            <option>${kouji.kjKbn}</option>

                                        </select>
                                    </div>
                                    <div class="col-md-2">
                                        <select name="status" class="form-control">
                                            <option>
                                                ${kouji.status}
                                            </option>
                                            <option>未完成</option>
                                            <option>完成</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="row form-group">
                                    <div class="col-md-10">
                                        <input type="hidden" name="trkDate" value="${kouji.trkDate}" />
                                        <input type="submit" class="btn btn-success" value="変更"/>
                                        <input type="button" class="btn btn-default" value="リセット"/>
                                    </div>
                                </div>
                            </div><!-- information penal -->
                        </form>
                    </div>

                        <div class="panel panel-default progress-panel" id="tenkenRireki-content">
                            <div class="panel-body">
                                <div class="row progress-data-div">
                                    <div class="col-md-4">
                                        <i class="glyphicon glyphicon-inbox"> 未完成: <span id="incompleteNum"></span></i>
                                    </div>
                                    <div class="col-md-4">
                                        <i class="glyphicon glyphicon-gift"> 完成: <span id="completeNum"></span></i>
                                    </div>
                                    <div class="col-md-4">
                                        <i class="glyphicon glyphicon-saved"> 全部: <span id="totalNum"></span></i>
                                    </div>
                                </div>
                                <div class="progress">
                                    <div id="percentProgress" class="progress-bar bg-middle-green progress-bar-striped active" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="width: 20%;">
                                        20%
                                    </div>
                                </div>
                            </div>
                            <table class="table table-hover kiki-table" id="kiki-table">
                            </table>
                                <div class="row">
                                    <input type="hidden" id="currentPage" value="0" />
                                    <div class="col-md-6">
                                        <nav>
                                            <ul id="pager" class="pagination">
                                            </ul>
                                        </nav>
                                    </div>

                                    <div class="col-md-6"></div>
                                </div>
                        </div>
                </div><!-- information tab -->
                <div class="col-md-1">
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="nav nav-pills nav-stacked bookmarkUl">
                                <li role="presentation" class="currentBookmark"><a href="/kouji/${kouji.id}">情報</a></li>
                                <li role="presentation" ><a href="/kouji/${kouji.id}/instruct">指示</a></li>
                                <li role="presentation"><a href="/kouji/${kouji.id}/kenan">懸案</a></li>
                                <li role="presentation"><a href="/kouji/${kouji.id}/history">履歴</a></li>
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
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">懸案追加</h4>
            </div>
            <div class="modal-body">
                <form id="kenanForm" name="kenanForm">
                    <input type="hidden" id="rirekiId" name="rirekiId" value="" />
                <div class="row form-group">

                    <div class="col-md-3">
                        <input type="text" name="jisyo" class="form-control kenanForm-input" value="" placeholder="事象" />
                    </div>
                    <div class="col-md-3">
                        <input type="text" name="buhin" class="form-control kenanForm-input" value="" placeholder="部品" />
                    </div>
                    <div class="col-md-3">
                        <input type="text" name="gensyo" class="form-control kenanForm-input" value="" placeholder="現象" />
                    </div>
                    <div class="col-md-3">
                        <input type="text" name="taisaku" class="form-control kenanForm-input" value="" placeholder="対策" />
                    </div>
                </div>

                <div class="row form-group">
                    <div class="col-md-3">
                        <input type="text" name="hakkenJyokyo" class="form-control kenanForm-input" value="" placeholder="発見状況" />
                    </div>
                    <div class="col-md-9">
                        <input type="text" name="syotiNaiyo" class="form-control kenanForm-input" value="" placeholder="処置内容" />
                    </div>
                </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(document).ready(function(){

        updateListNumbers();

        var currentPage = $("#currentPage").val();
        $.get("/tenken/getTenkenrirekiByPage",{"currentPage":currentPage},function(data){
            var datas = JSON.parse(data);
            $("#kiki-table").html("");
            var tmpHtml = '<tr class="bg-gray">'+
                    '<th>弁番号</th>'+
                    '<th>弁名称</th>'+
                    '<th>機器分類</th>'+
                    '<th>機器名称</th>'+
                    '<th>型式番号</th>'+
                    '<th>点検ランク</th>'+
                    '<th></th><th></th>'+
                    '</tr>';
            for(var i = 0;i<datas.tenkenRirekiList.length;i++){
                var kikiStatus = "";
                if(datas.tenkenRirekiList[i].kanryoFlg == '完成'){
                    kikiStatus = "success";
                }
                tmpHtml = tmpHtml + '<tr id="'+datas.tenkenRirekiList[i].id+'" class="'+kikiStatus+'">'+
                        '<td>'+datas.tenkenRirekiList[i].valve.vNo+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].valve.benMeisyo+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].kikiBunrui+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].kikiMei+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].katasikiNo+'</td>'+
                        '<td>'+
                        '<select class="form-control tenken-select" onchange="saveTenkenrank(this)">'+
                        '<option>'+datas.tenkenRirekiList[i].tenkenRank+'</option>'+
                        '<option>A</option>'+
                        '<option>B</option>'+
                        '<option>C</option>'+
                        '<option>D</option>'+
                        '<option>E</option>'+
                        '<option>F</option>'+
                        '</select>'+
                        '</td>'+
                        '<td>'+
                        '<input type="text" class="form-control input-xs" style="height:25px" placeholder="点検結果" onblur="saveTenkenkekka(this)" value="'+datas.tenkenRirekiList[i].tenkenkekka+'" />'+
                        '</td>'+
                        '<td><button class="btn btn-xs bg-red" onclick="openKenan(this)"><i class="glyphicon glyphicon-floppy-save"></i></button></td>'+
                        '</tr>'
            }
            $("#kiki-table").html(tmpHtml);

            $("#currentPage").val(datas.currentPage+1);
            $("#pager").html("");
            var pageHtml = "";
            for(var i = 0;i < datas.pageCount;i++){
                var tmpPage = i+1;
                if(datas.currentPage == i){
                    pageHtml = pageHtml + '<li class="active"><a href="#tenkenRireki-content" onclick="changePage(this)">' + tmpPage + '</a></li>';

                } else {
                    pageHtml = pageHtml + '<li><a href="#tenkenRireki-content" onclick="changePage(this)">' + tmpPage + '</a></li>';
                }
            }
            $("#pager").html(pageHtml);

        });
    });

    function saveTenkenrank(obj){
        var rireki = $(obj).parent().parent();
        var rirekiId = rireki[0].id;
        $.post("/tenken/saveTenkenrank",{"id":rirekiId,"tenkenrank":obj.value},function(data){
            if(data == '完成'){
                if(!$(rireki).hasClass("success")) {
                    $(rireki).addClass("success");
                }
            } else {
                if($(rireki).hasClass("success")) {
                    $(rireki).removeClass("success");
                }
            }
            updateListNumbers();
        })
    }

    function saveTenkenkekka(obj){
        var rireki = $(obj).parent().parent();
        var rirekiId = rireki[0].id;
        $.post("/tenken/saveTenkenkekka",{"id":rirekiId,"tenkenkekka":obj.value},function(data){
            if(data == '0'){
                if($(obj).hasClass("input-success")) {
                    $(obj).removeClass("input-success");
                }
            } else {
                if(!$(obj).hasClass("input-success")) {
                    $(obj).addClass("input-success");
                }
            }
        })
    }

    function updateListNumbers(){
        $.get("/tenken/getListNumber",function(data){
            var datas = JSON.parse(data);
            $("#totalNum").html(datas.total);
            $("#incompleteNum").html(datas.incomplete);
            $("#completeNum").html(datas.complete);

            var percent = datas.complete / datas.total;
            percent = percent*100;
            $("#percentProgress").css({"width":percent+"%"});
            $("#percentProgress").html(percent+"%");
        })
    }

    function changePage(obj){
        var currentPage = parseInt(obj.innerHTML);
        currentPage = currentPage-1;
        $.get("/tenken/getTenkenrirekiByPage",{"currentPage":currentPage},function(data){
            var datas = JSON.parse(data);
            $("#kiki-table").html("");
            var tmpHtml = '<tr class="bg-gray">'+
                    '<th>弁番号</th>'+
                    '<th>弁名称</th>'+
                    '<th>機器分類</th>'+
                    '<th>機器名称</th>'+
                    '<th>型式番号</th>'+
                    '<th>点検ランク</th>'+
                    '<th></th><th></th>'+
                    '</tr>';
            for(var i = 0;i<datas.tenkenRirekiList.length;i++){
                var kikiStatus = "";
                if(datas.tenkenRirekiList[i].kanryoFlg == '完成'){
                    kikiStatus = "success";
                }
                tmpHtml = tmpHtml + '<tr id="'+datas.tenkenRirekiList[i].id+' "class='+kikiStatus+'>'+
                        '<td>'+datas.tenkenRirekiList[i].valve.vNo+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].valve.benMeisyo+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].kikiBunrui+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].kikiMei+'</td>'+
                        '<td>'+datas.tenkenRirekiList[i].katasikiNo+'</td>'+
                        '<td>'+
                        '<select class="form-control tenken-select" onchange="saveTenkenrank(this)">'+
                        '<option>'+datas.tenkenRirekiList[i].tenkenRank+'</option>'+
                        '<option>A</option>'+
                        '<option>B</option>'+
                        '<option>C</option>'+
                        '<option>D</option>'+
                        '<option>E</option>'+
                        '<option>F</option>'+
                        '</select>'+
                        '</td>'+
                        '<td>'+
                        '<input type="text" class="form-control input-xs" style="height:25px" placeholder="点検結果" onblur="saveTenkenkekka(this)" value="'+datas.tenkenRirekiList[i].tenkenkekka+'" />'+
                        '</td>'+
                        '<td><button class="btn btn-xs bg-red" onclick="openKenan(this)"><i class="glyphicon glyphicon-floppy-save"></i></button></td>'+
                        '</tr>'
            }
            $("#kiki-table").html(tmpHtml);

            $("#currentPage").val(datas.currentPage+1);
            $("#pager").html("");
            var pageHtml = "";
            for(var i = 0;i < datas.pageCount;i++){
                var tmpPage = i+1;
                if(datas.currentPage == i){
                    pageHtml = pageHtml + '<li class="active"><a href="#tenkenRireki-content" onclick="changePage(this)">' + tmpPage + '</a></li>';

                } else {
                    pageHtml = pageHtml + '<li><a href="#tenkenRireki-content" onclick="changePage(this)">' + tmpPage + '</a></li>';
                }
            }
            $("#pager").html(pageHtml);

        });
    }

    function openKenan(obj){
        var rireki = $(obj).parent().parent();
        var rirekiId = rireki[0].id;
        $("#rirekiId").val(rirekiId);
        $(".kenanForm-input").val("");
        $("#kenanModal").modal();
    }
</script>
</html>
