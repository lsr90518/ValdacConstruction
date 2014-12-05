<%--
  Created by IntelliJ IDEA.
  User: Lsr
  Date: 12/4/14
  Time: 11:40 PM
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
    <input type="hidden" id="koujiId" value="${kouji.id}" />
    <section class="content">

        <div class="row">
            <div class="col-md-11">

                <!--                  -->
                <div class="box box-solid">
                    <div class="box-body">
                        <div class="form-group">

                            <div class="row">
                                <div class="col-md-3" style="text-align: center">
                                    <!-- left frame -->
                                    <div class="row">
                                        <div class="col-md-12">
                                            <!-- new image -->
                                            <div class="btn btn-block btn-warning btn-file-block">
                                                <span class="glyphicon glyphicon-picture"></span>
                                                <span class="glyphicon-class">図面アップロード</span>
                                                <input type="file" id="filePicker" name="attachment" style="height: 40px !important;">
                                            </div>
                                            <!--Add a button for the user to click to initiate auth sequence -->
                                            <button id="authorize-button" style="visibility: hidden">Authorize</button>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12" id="previewImageDiv">
                                            <hr/>
                                            <div class="row" id="imageList">

                                                <c:forEach items="${imageList}" var="image">
                                                    <div id="${image.imagename}" class="col-md-12 image-div"onMouseOver="showDelete(this)" onmouseout="hideDelete(this)">
                                                        <div class="row thumbnail-object">
                                                            <div class="col-md-4 thumbnail-img">
                                                                <img src="http://storage.googleapis.com/valdacconstruction/${image.imagename}" onclick="changeImage(this)" alt="..." style="cursor:pointer;height: 100px">
                                                            </div>
                                                            <div class="col-md-8 thumbnail-content">
                                                                <select class="form-control input-sm imagesyu" onchange="saveChangeToDatabase(this)"><option>${image.imagesyu}</option><option>画像種別1</option><option>画像種別2</option><option>画像種別3</option></select>
                                                                <input type="hidden" value="${image.imagename}" >
                                                                <input type="button" class="btn btn-danger btn-xs thumbnail-delete-btn pull-right" value="X" onclick="removeImage(this)">
                                                                <input type="hidden" class="currentObject" value="${image.imagename}" >
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-9">
                                    <div class="progress xs progress-striped active">
                                        <div id="progressbar" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                                            <span class="sr-only">60% Complete</span>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <input type="hidden" id="currentImageObject" value="">
                                        <div class="col-md-2"><a href="#" id="original-link" class="btn btn-sm btn-default" target="_blank"><i class="fa fa-fw fa-desktop"></i> 原図</a></div>

                                    </div>
                                    <div class="row previewDiv">
                                        <!-- image -->
                                        <img id="previewImage" class="previewImage" src="" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--                -->

            </div><!-- information tab -->
            <div class="col-md-1">
                <div class="row">
                    <div class="col-md-12">
                        <ul class="nav nav-pills nav-stacked bookmarkUl">
                            <li role="presentation" ><a href="/kouji/${kouji.id}"><i class="glyphicon glyphicon-cog"> </i></a></li>
                            <li role="presentation"><a href="/kouji/${kouji.id}/instruct"><i class="glyphicon glyphicon-indent-left"> </i></a></li>
                            <li role="presentation"><a href="/kouji/${kouji.id}/kenan"><i class="glyphicon glyphicon-floppy-save"> </i></a></li>
                            <li role="presentation"><a href="/kouji/${kouji.id}/history"><i class="glyphicon glyphicon-time"> </i></a></li>
                            <li role="presentation" class="currentBookmark"><a href="/kouji/${kouji.id}/image"><i class="glyphicon glyphicon-picture"> 図面</i></a></li>
                        </ul>
                    </div>
                </div>
            </div><!-- tab button tab -->
        </div>
    </section>
</div>
</body>

<script type="text/javascript">
    $(document).ready(function(){

        $("#left-menu-new").addClass("active");

        $(".box-panel").click(function(){
            $(this).next().toggle();
        });

    });

    function removeImage(obj){
        $(obj).attr({"disabled":"true"});
        var currentObject = $(obj).next();
        $.post("/image/deleteByImagename",
                {"object":currentObject.val()},
                function(data){
                    var div = document.getElementById(currentObject.val());
                    $(div).hide(500,function(){
                        $(div).remove();
                    });
                    object = currentObject.val();
                    var request = gapi.client.storage.objects.delete({
                        'bucket': BUCKET,
                        'object': object
                    });
                    request.execute(function(resp) {
                        document.getElementById('previewImage').src="";
                        object = "";
                    });
                });
    }

    function progressBarController(num){
        $("#progressbar").attr({"aria-valuenow":num});
        $("#progressbar").css({"width":num+"%"});
    }

    function saveChangeToDatabase(obj){
        $(obj).attr({"disabled":"true"});
        var currentObject = $(obj).next();
        $.post("/image/updateSyuByImagename",
                {"imagesyu":$(obj).val(),"object":currentObject.val()},
                function(data){
                    $(obj).removeAttr("disabled");
                });
    }

    function changeImage(obj){
        document.getElementById("previewImage").src=obj.src;
        document.getElementById("original-link").href=obj.src;
        var link = new String(obj.src);
        var currentObject = link.split("http://storage.googleapis.com/valdacconstruction/")[1];
        object = currentObject;
        var imageHeight = $("#previewImage").css("height");
        if(imageHeight < "600"){
            $("#imageList").css("height","600");
        } else {
            $("#imageList").css("height",$("#previewImage").css("height"));
        }

        $.get("/image/getBikouByObject",{"object":object},function(data){
            $("#buhinzubikou").val(data);
            $("#buhinzubikou").css("border-color","#ccc");
        });


    }

    function showDelete(obj){
        var content = $(obj).find(".thumbnail-content")[0];
        var btn = $(content).find(".thumbnail-delete-btn").css("opacity","1");
    }
    function hideDelete(obj){
        var content = $(obj).find(".thumbnail-content")[0];
        var btn = $(content).find(".thumbnail-delete-btn").css("opacity","0");
    }

    function submitBikou(){
        if(object.length > 0){
            $("#buhinzubikou").css("border-color","#ccc");
            $("#bikouSubmitButton").css("disabled","true");
            $.post("/image/submitBikouById",{"bikou":$("#buhinzubikou").val(),"object":object},function(data){
                $("#bikouSubmitButton").removeClass("disabled");
                $("#buhinzubikou").css("border-color","#00a65a");
            });
        }
    }
</script>

<!-- Google Sotrage -->
<script type="text/javascript">
var PROJECT = 'power-science-20140719001';
var clientId = '13771198627-bpo57i2unf6dkbna2jo7ehljin6aseoa.apps.googleusercontent.com';
var apiKey = 'AIzaSyAh3tkkQ0VXgG6-parVdtv2ARDtfl5Xs38';
var scopes = 'https://www.googleapis.com/auth/devstorage.full_control';
var API_VERSION = 'v1';
var BUCKET = 'valdacconstruction';
var object = "";

var GROUP =
        'group-00b4903a9744bffac3b0196718449ddbaf5cbc5a1ebfff7783546ad6f13e63f6';
var ENTITY = 'allUsers';
var ROLE = 'OWNER';
var ROLE_OBJECT = 'OWNER';
function insertObject(event) {
    progressBarController(0);
    try{
        var fileData = event.target.files[0];
    }
    catch(e) {
        return;
    }

    // progressbar
    progressBarController(10);
    const boundary = '-------314159265358979323846';
    const delimiter = "\r\n--" + boundary + "\r\n";
    const close_delim = "\r\n--" + boundary + "--";
    var reader = new FileReader();
    reader.readAsBinaryString(fileData);
    reader.onload = function(e) {
        var fileTypeOld = new String(fileData.name);
        var fileType = fileTypeOld.split('.');

        //make file name
        var d = new Date();
        var vYear = d.getFullYear();
        var vMon = d.getMonth() + 1;
        var vDay = d.getDate();
        if(vDay < 10){
            vDay = "0"+vDay;
        }
        var todayDate = vYear+""+vMon+""+vDay;
        var objectAndName = todayDate + "/" + d.getTime()+"."+fileType[fileType.length-1];

        //make parameters
        progressBarController(30);
        var contentType = fileData.type || 'application/octet-stream';
        var metadata = {
            'name': objectAndName,
            'mimeType': contentType
        };
        var base64Data = btoa(reader.result);
        var multipartRequestBody =
                delimiter +
                'Content-Type: application/json\r\n\r\n' +
                JSON.stringify(metadata) +
                delimiter +
                'Content-Type: ' + contentType + '\r\n' +
                'Content-Transfer-Encoding: base64\r\n' +
                '\r\n' +
                base64Data +
                close_delim;
        //Note: gapi.client.storage.objects.insert() can only insert
        //small objects (under 64k) so to support larger file sizes
        //we're using the generic HTTP request method gapi.client.request()
        var request = gapi.client.request({
            'path': '/upload/storage/v1/b/' + BUCKET + '/o',
            'method': 'POST',
            'params': {'uploadType': 'multipart'},
            'headers': {
                'Content-Type': 'multipart/mixed; boundary="' + boundary + '"'
            },
            'body': multipartRequestBody});
        progressBarController(60);
        try{
            //Execute the insert object request
            executeRequest(request, 'insertObject');
            //Store the name of the inserted object
            object = objectAndName;
        }
        catch(e) {
            alert('An error has occurred: ' + e.message);
        }
    }
}
/**
 * Google Cloud Storage API request to insert an Access Control List into
 * your Google Cloud Storage object.
 */
function insertObjectAccessControls() {
    resource = {
        'entity': ENTITY,
        'role': ROLE_OBJECT
    };
    var request = gapi.client.storage.objectAccessControls.insert({
        'bucket': BUCKET,
        'object': object,
        'resource': resource
    });
    executeRequest(request, 'insertObjectAccessControls');
}
/**
 * Google Cloud Storage API request to delete a Google Cloud Storage object.
 */
function deleteObject() {
    var request = gapi.client.storage.objects.delete({
        'bucket': BUCKET,
        'object': object
    });
    executeRequest(request, 'deleteObject');
}
function updateApiResultEntry(apiRequestName) {
    listChildren = document.getElementById('main-content')
            .childNodes;
    if (listChildren.length > 1) {
        listChildren[1].parentNode.removeChild(listChildren[1]);
    }
    if (apiRequestName != 'null') {
        window[apiRequestName].apply(this);
    }
}
function executeRequest(request, apiRequestName) {
    request.execute(function(resp) {
        if (apiRequestName != 'insertObject') {
            console.log(resp)
            document.getElementById('previewImage').src="http://storage.googleapis.com/valdacconstruction/"+resp.object;
            document.getElementById("original-link").href="http://storage.googleapis.com/valdacconstruction/"+resp.object;
            var imageListObj = '<div id="'+resp.object+'" class="col-md-12 image-div" onMouseOver="showDelete(this)" onmouseout="hideDelete(this)">'+
                    '<div class="row thumbnail-object">'+
                    '<div class="col-md-4 thumbnail-img">'+
                    '<img src="http://storage.googleapis.com/valdacconstruction/'+resp.object+'" onclick="changeImage(this)" alt="..." style="cursor:pointer;height: 100px">'+
                    '</div>'+
                    '<div class="col-md-8 thumbnail-content">'+
                    '<select class="form-control input-sm imagesyu" onchange="saveChangeToDatabase(this)"><option></option><option>画像種別1</option><option>画像種別2</option><option>画像種別3</option></select>'+
                    '<input type="hidden" value="'+resp.object+'" >'+
                    '<input type="button" class="btn btn-danger btn-xs thumbnail-delete-btn pull-right" value="X" onclick="removeImage(this)">'+
                    '<input type="hidden" class="currentObject" value="'+resp.object+'" >'+
                    '</div>'+
                    '</div>'+
                    '</div>';

            document.getElementById("imageList").innerHTML = document.getElementById("imageList").innerHTML+imageListObj;

            progressBarController(100);
            //update database
            var koujiId = document.getElementById("koujiId").value;
            $.post("/image/saveImageByImagePath",{"object":resp.object,"koujiId":koujiId},function(data){
                progressBarController(0);
            });
        } else {
            progressBarController(80);
            insertObjectAccessControls();
        }
    });
}
/**
 * Set required API keys and check authentication status.
 */
function handleClientLoad() {
    gapi.client.setApiKey(apiKey);
    window.setTimeout(checkAuth, 1);
}
/**
 * Authorize Google Cloud Storage API.
 */
function checkAuth() {
    gapi.auth.authorize({
        client_id: clientId,
        scope: scopes,
        immediate: true
    }, handleAuthResult);
}
/**
 * Handle authorization.
 */
function handleAuthResult(authResult) {
    var authorizeButton = document.getElementById('authorize-button');
    if (authResult && !authResult.error) {
        authorizeButton.style.visibility = 'hidden';
        initializeApi();
        filePicker.onchange = insertObject;
    } else {
        authorizeButton.style.visibility = '';
        authorizeButton.onclick = handleAuthClick;
    }
}
/**
 * Handle authorization click event.
 */
function handleAuthClick(event) {
    gapi.auth.authorize({
        client_id: clientId,
        scope: scopes,
        immediate: false
    }, handleAuthResult);
    return false;
}
/**
 * Load Google Cloud Storage API v1beta12.
 */
function initializeApi() {
    gapi.client.load('storage', API_VERSION);
}
/**
 * Driver for sample application.
 */
$(window)
        .bind('load', function() {
//            addSelectionSwitchingListeners();
            handleClientLoad();
        });

</script>

</html>