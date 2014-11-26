<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/26/14
  Time: 10:20 AM
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
            <div class="col-md-4 step-div last-step-complete">
                <span class="glyphicon glyphicon-indent-left"> 3. 点検機器選択</span>
            </div>
        </div>
        <input type="hidden" id="currentKoujiId" value="${kouji.id}"/>
        <input type="hidden" id="currentKikiSysId" value=""/>

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">工事情報</h3>
                    </div>

                    <div class="panel-body">
                        <form id="KoujiForm" name="KoujiForm" action="/kouji/add" method="post">
                            <div class="row form-group">
                                <div class="col-md-3">
                                    <input type="text" class="form-control" name="kjNo" value="${kouji.kjNo}" placeholder="工事番号"/>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="kjMeisyo" value="${kouji.kjMeisyo}" placeholder="工事名称"/>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-3">
                                    <select class="form-control" name="person" id="person">
                                        <option>1</option>
                                        <option>zui</option>
                                    </select>
                                </div>
                                <div class="col-md-8" id="sandbox-container">
                                    <div class="input-daterange input-group" id="datepicker" style="width:100%">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control" name="bgnYmd" id="bgnYmd" value="${kouji.bgnYmd}" placeholder="開始日付">
                                        <span class="input-group-addon">〜</span>
                                        <input type="text" class="form-control" name="endYmd" value="${kouji.endYmd}" placeholder="終了日付">
                                    </div>
                                </div>
                                <div class="col-md-1">
                                    <input type="text" class="form-control" name="nendo" value="${kouji.nendo}" id="nendo" placeholder="年度"/>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-10">
                                    <input type="text" class="form-control location-master-toggle" name="location" id="location" value="${kouji.location}" placeholder="場所"/>
                                    <div class="panel panel-default dropdown-panel" id="location-master">
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <input type="text" id="kCodeL-input" class="form-control" placeholder="会社名" />
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input type="text" id="kCodeM-input" class="form-control" placeholder="発電所" />
                                                    </div>
                                                    <div class="col-md-4">
                                                        <input type="text" id="kCodeS-input" class="form-control" placeholder="機器名" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="row">
                                                    <div class="col-md-4">
                                                        <select class="form-control" id="kCodeL-select">
                                                            <option></option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <select class="form-control" id="kCodeM-select">
                                                            <option></option>
                                                        </select>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <select class="form-control" id="kCodeS-select">
                                                            <option></option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-2"><input type="button" id="master-location-confirm" class="btn btn-block btn-success" value="確定"></div>
                                                <div class="col-md-2"><input type="button" id="master-location-cancel" class="btn btn-block btn-default" value="取消"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <select name="kjKbn" id="kjKbn" class="form-control">
                                        <option>--工事区分--</option>
                                        <%--<option>定期検査</option>--%>
                                        <%--<option>定期自主検査</option>--%>
                                        <%--<option>その他</option>--%>
                                    </select>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-4">
                                    <input type="text" class="form-control" name="syukan" value="" placeholder="主管係"/>
                                </div>
                                <div class="col-md-4">
                                    <select name="gyosyaRyakuA" class="form-control">
                                        <option>東洋バルブ製造所</option>
                                        <option>不明</option>
                                    </select>
                                </div>
                                <div class="col-md-4" id="nextYmdDiv">
                                    <input type="text" class="form-control" name="nextYmd" value="${kouji.nextYmd}" placeholder="今度"/>
                                </div>

                            </div>

                            <div class="row form-group">
                                <div class="col-md-10">
                                    <input type="submit" class="btn btn-default btn-sm" value="変更"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- information penal -->
                </div>

            </div>
            <!-- information tab -->
        </div>

        <div class="row" id="content-row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-body">
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

        <div class="row">
            <div class="col-md-12">
                <div class="panel">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-4"></div>
                            <div class="col-md-2"><a href="/kouji/${kouji.id}/saveResult" class="btn btn-sm btn-success btn-block"><i class="fa fa-save"> 確定</i></a></div>
                            <div class="col-md-2"><a href="/kouji/${kouji.id}/valve" class="btn btn-sm btn-default btn-block"><i class="fa fa-backward"> 戻す</i></a></div>
                            <div class="col-md-4"></div>
                        </div>
                    </div>
                </div>
            </div>
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

        //工事区分 Master を呼ぶ
        $.post("/master/getMasterByTypeJson",{"type":'工事区分'},function(data){
            var masters = JSON.parse(data);
            $('#kjKbn').html("");
            var tmpHTML = "<option>${kouji.kjKbn}</option>";
            for(var i = 0 ; i < masters.length ; i++){
                tmpHTML = tmpHTML+"<option>" + masters[i].name + "</option>";
            }
            $('#kjKbn').html(tmpHTML);
        });

        //The Calender
        $('#sandbox-container .input-daterange').datepicker({
            format: 'yyyy/mm/dd',
            language: 'ja'
        });
        $('#nextYmdDiv input').datepicker({
            format: 'yyyy/mm/dd',
            language: 'ja'
        });

        $('#bgnYmd').change(function(){
            var dateStr = new String($('#bgnYmd').val());
            var nendo = dateStr.split('/');
            $('#nendo').val(nendo[0]);
        });
        $(".location-master-toggle").focus(function(obj){
            var toggleInput = obj.currentTarget;

            var dropdownPanel = $(toggleInput).next(".dropdown-panel");

            $.get("/location/getKCodeLJson",function(data){
                $("#kCodeL-select").html("");
                var tmpHTML = "<option></option>";
                var masters = JSON.parse(data);
                for(var i = 0;i<masters.length;i++){
                    tmpHTML = tmpHTML+ "<option>" + masters[i] + "</option>";
                }
                $("#kCodeL-select").html(tmpHTML);
                $(dropdownPanel).show();
            });
        });

        $("#master-location-confirm").click(function(){
            var locationValue = $("#kCodeL-input").val()+$("#kCodeM-input").val();
            locationValue = locationValue+$("#kCodeS-input").val();
            $("#location").val(locationValue);
            $(".dropdown-panel").hide();
        });

        $("#master-location-cancel").click(function(){
            $(".dropdown-panel").hide();
        });

        $("#kCodeL-select").change(function(){
            $("#kCodeL-input").val($("#kCodeL-select").val());
            $.post("/location/getKcodeMJsonBykCodeL",{"kCodeL":$("#kCodeL-select").val()},function(data){
                $("#kCodeM-select").html("");
                var tmpHTML = "<option></option>";
                var masters = JSON.parse(data);
                for(var i = 0;i<masters.length;i++){
                    tmpHTML = tmpHTML+ "<option>" + masters[i] + "</option>";
                }
                $("#kCodeM-select").html(tmpHTML);
            });
        });

        $("#kCodeM-select").change(function(){
            $("#kCodeM-input").val($("#kCodeM-select").val());
            $.post("/location/getKcodeSJsonBykCodeLkCodeM",{"kCodeL":$("#kCodeL-select").val(),"kCodeM":$("#kCodeM-select").val()},function(data){
                $("#kCodeS-select").html("");
                var tmpHTML = "<option></option>";
                var masters = JSON.parse(data);
                for(var i = 0;i<masters.length;i++){
                    tmpHTML = tmpHTML+ "<option>" + masters[i] + "</option>";
                }
                $("#kCodeS-select").html(tmpHTML);
            });
        });
        $("#kCodeS-select").change(function(){
            $("#kCodeS-input").val($("#kCodeS-select").val());
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
                        tmpHTML = '<li class="list-group-item kiki-item '+kikiDatas[i].status+'" id="'+kikiDatas[i].kiki.kikiId+'">'+
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

