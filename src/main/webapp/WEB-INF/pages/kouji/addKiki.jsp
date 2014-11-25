<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/19/14
  Time: 2:53 PM
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

    <input type="hidden" id="syukan" value="${kouji.syukan}"/>
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
            <div class="col-md-4 step-div middle-step-complete">
                <span class="glyphicon glyphicon-list"> 2. 点検バルブ選択</span>
            </div>
            <div class="col-md-4 step-div">
                <span class="glyphicon glyphicon-indent-left"> 3. 点検機器選択</span>
            </div>
        </div>
        <input type="hidden" id="currentKoujiId" value="${kouji.id}"/>
        <input type="hidden" id="currentKikiSysId" value=""/>
        <div class="row" id="content-row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-body">
                        <div class="row filter-panel">
                            <div class="col-md-2"><input type="checkbox" value="全部" > 全部</div>
                            <div class="col-md-2"><input type="checkbox" value="弁本体" > 弁本体</div>
                            <div class="col-md-2"><input type="checkbox" value="付属品" > 付属品</div>
                            <div class="col-md-6"><a href="/kouji/${kouji.id}/saveValveKikiRelation" class="btn btn-success btn-sm pull-right">確定</a></div>
                        </div>
                        <div class="kiki-content-panel">
                            <div class="col-md-3" style="padding-right: 0px">
                                <ul class="list-group tab-list">
                                    <c:forEach items="${valveList}" var="valve">
                                        <li onclick="chooseThisValve(this)" class="list-group-item tab-item">
                                            ${valve.vNo} ${valve.benMeisyo}
                                            <input type="hidden" class="kikiSysId" value="${valve.kikiSysId}"/>
                                        </li>
                                    </c:forEach>
                                </ul><!-- 弁 list -->
                            </div>
                            <div class="col-md-9" style="padding-left: 0px">
                                <div class="kikiList-div">
                                    <div class="row filter-div">
                                        <div class="col-md-12"><input type="text" onkeyup="searchKikiList(this)" class="form-control input-sm pull-right" style="width: 60%" placeholder="検索"></div>
                                    </div>
                                    <ul class="list-group item-list" id="kikiList">
                                    </ul>
                                </div>
                            </div>
                        </div>
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

    function chooseThisValve(obj){
        $('.tab-item').removeClass("active");
        $(obj).addClass("active");
        var koujiId = $("#currentKoujiId").val();
        var id = $(obj).find(".kikiSysId")[0];
        var syukanValve = document.getElementById("syukan");
        $.post("/item/getKikiByKikiSysId",{"koujiId":koujiId,"kikiSysId":id.value,"syukan":syukanValve.value},
                function(data){
                    var kikiDatas = JSON.parse(data);
                    $("#kikiList").html("");
                    var tmpHTML = "";
                    for(var i = 0; i < kikiDatas.length;i++){
                        tmpHTML = '<li class="list-group-item kiki-item '+kikiDatas[i].status+'" onmouseup="selectKiki(this)" id="'+kikiDatas[i].kiki.kikiId+'">'+
                                '<div class="row">'+
                        '<div class="col-md-12">'+
                        '<span class="data-span">'+kikiDatas[i].kiki.kikiNo+'</span><span class="data-span">'+kikiDatas[i].kiki.kikiBunrui+'</span><span class="data-span">'+kikiDatas[i].kiki.kikiMei+'</span><span class="data-span">'+kikiDatas[i].kiki.serialNo+'</span><span class="data-span">'+kikiDatas[i].kiki.katasikiNo+'</span>'+
                        '</div>'+
                        '</div>'+
                        '</li>';
                    }
                    $('#kikiList').html(tmpHTML);
                    $('#currentKikiSysId').val(id.value);
                }
        );
    }

    function selectKiki(obj){
        $(obj).toggleClass("active");
        var koujiId = $("#currentKoujiId").val();
        if($(obj).hasClass("active")) {
            $.post("/item/saveStatusToSession", {"koujiId":koujiId,"kikiSysId": $('#currentKikiSysId').val(), "kikiId": obj.id, "status": "active"},function(data){
            });
        } else {
            $.post("/item/saveStatusToSession", {"koujiId":koujiId,"kikiSysId": $('#currentKikiSysId').val(), "kikiId": obj.id, "status": ""},function(data){

            });
        }
    }

    function searchKikiList(obj){
        if(obj.value.length < 1){
            $('.kiki-item').show();
        } else {
            var keyword = obj.value;
            var datas = $('.data-span');
            for(var i = 0;i<datas.length;i++){
                var tmpHtml = new String(datas[i].innerHTML);
                if(tmpHtml.indexOf(keyword) > -1){
                    var li = $(datas[i]).parent().parent().parent();
                    console.log(li);
                    $(li).show();
                } else {
                    var li = $(datas[i]).parent().parent().parent();
                    console.log(li);
                    $(li).hide();
                }
            }
        }
    }

</script>
</body>
</html>
