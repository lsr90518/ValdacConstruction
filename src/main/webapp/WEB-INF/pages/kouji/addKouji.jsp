<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 11/18/14
  Time: 10:23 AM
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
            <i class="glyphicon glyphicon-wrench"> 新規工事</i>
        </h1>
        <ol class="breadcrumb">
            <li><i class="fa fa-dashboard"></i> Index/新規工事</li>
        </ol>
    </section>
    <hr/>

    <section class="content">
        <div class="row" id="step-row">
            <div class="col-md-4 step-div">
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
                    <div class="panel-heading">
                        <h3 class="panel-title">工事情報</h3>
                    </div>

                    <div class="panel-body">
                        <form id="koujiForm" action="/kouji/add" method="post">
                            <div class="row form-group">
                                <div class="col-md-3">
                                    <input type="text" class="form-control" name="kjNo" value="" placeholder="工事番号"/>
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" name="kjMeisyo" value="" placeholder="工事名称"/>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-3">
                                    <select class="form-control" name="responsibility">
                                        <option>1</option>
                                        <option>zui</option>
                                    </select>
                                </div>
                                <div class="col-md-8" id="sandbox-container">
                                    <div class="input-daterange input-group" id="datepicker" style="width:100%">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control" name="bgnYmd" id="bgnYmd" placeholder="開始日付">
                                        <span class="input-group-addon">〜</span>
                                        <input type="text" class="form-control" name="endYmd" placeholder="終了日付">
                                    </div>
                                </div>
                                <%--<div class="col-md-4">--%>
                                    <%--<input type="text" class="form-control" name="endYmd" value="" placeholder="終了日付"/>--%>
                                <%--</div>--%>
                                <div class="col-md-1">
                                    <input type="text" class="form-control" name="nendo" value="" id="nendo" placeholder="年度"/>
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-10">
                                    <input type="text" class="form-control location-master-toggle" name="location" id="location" value="" placeholder="場所"/>
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
                                    <select name="kjKbn" class="form-control">
                                        <option>定期検査</option>
                                        <option>非定期検査</option>
                                        <option>その他</option>
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
                                    <input type="text" class="form-control" name="nextYmd" value="" placeholder="今度"/>
                                </div>

                            </div>

                            <div class="row form-group">
                                <div class="col-md-10">
                                    <input type="submit" class="btn btn-success" value="保存"/>
                                    <input type="button" class="btn btn-default" onclick="koujiForm.clear();return false" value="リセット"/>
                                </div>
                            </div>
                        </form>
                    </div>
                    <!-- information penal -->
                </div>

            </div>
            <!-- information tab -->
        </div>
    </section>
</div>
<script type="text/javascript">
    $(document).ready(function(){
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

</script>
</body>
</html>
