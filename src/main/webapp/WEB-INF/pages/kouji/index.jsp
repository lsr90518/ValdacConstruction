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
                <i class="glyphicon glyphicon-wrench"> ${kouji.kjMeisyo}test</i>
                <span class="label label-warning">status</span>
            </h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard"></i> Index/${kouji.kjMeisyo}test</li>
            </ol>
        </section>
        <hr/>

        <section class="content">

            <div class="row">
                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">工事情報</h3>
                        </div>

                        <div class="panel-body">
                            <div class="row form-group">
                                <div class="col-md-3">
                                    <input type="text" class="form-control" value="kjNo" />
                                </div>
                                <div class="col-md-9">
                                    <input type="text" class="form-control" value="kjMeisyo" />
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-3">
                                    <input type="text" class="form-control" value="responsibility" />
                                </div>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" value="bgnYmd" />
                                </div>
                                <div class="col-md-4">
                                    <input type="text" class="form-control" value="endYmd" />
                                </div>
                            </div>

                            <div class="row form-group">
                                <div class="col-md-10">
                                    <input type="text" class="form-control" value="location" />
                                </div>
                                <div class="col-md-2">
                                    <select class="form-control">
                                        <option>区分</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row form-group">
                                <div class="col-md-10">
                                    <input type="submit" class="btn btn-success" value="変更"/>
                                    <input type="button" class="btn btn-default" value="リセット"/>
                                </div>
                            </div>
                        </div><!-- information penal -->
                    </div>

                        <div class="panel panel-default progress-panel">
                            <div class="panel-body">
                                <div class="row progress-data-div">
                                    <div class="col-md-4">
                                        <i class="glyphicon glyphicon-inbox"> 未完成:80</i>
                                    </div>
                                    <div class="col-md-4">
                                        <i class="glyphicon glyphicon-gift"> 完成: 20</i>
                                    </div>
                                    <div class="col-md-4">
                                        <i class="glyphicon glyphicon-saved"> 全部: 100</i>
                                    </div>
                                </div>
                                <div class="progress">
                                    <div class="progress-bar bg-middle-green progress-bar-striped active" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="width: 20%;">
                                        20%
                                    </div>
                                </div>
                            </div>

                            <table class="table table-hover kiki-table">
                                <tr class="bg-gray">
                                    <th>弁番号</th>
                                    <th>弁名称</th>
                                    <th>機器番号</th>
                                    <th>機器名称</th>
                                    <th>点検結果</th>
                                    <th>懸案</th>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                    <td>
                                        <input type="button" class="btn btn-sm btn-danger" value="懸案"/>
                                    </td>
                                </tr>
                                <tr class="success">
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                    <td>
                                        <input type="button" class="btn btn-sm btn-danger" value="懸案"/>
                                    </td>
                                </tr>
                                <tr class="success">
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                    <td>
                                        <input type="button" class="btn btn-sm btn-danger" value="懸案"/>
                                    </td>
                                </tr>
                                <tr class="success">
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                    <td>
                                        <input type="button" class="btn btn-sm btn-danger" value="懸案"/>
                                    </td>
                                </tr>
                                <tr class="success">
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                    <td>
                                        <input type="button" class="btn btn-sm btn-danger" value="懸案"/>
                                    </td>
                                </tr>
                                <tr class="success">
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td><select class="form-control tenken-select">                                             <option>A</option>                                         </select></td>
                                </tr>
                                <tr>
                                    <td>弁番号</td>
                                    <td>弁名称</td>
                                    <td>機器番号</td>
                                    <td>機器名称</td>
                                    <td>
                                        <select class="form-control tenken-select">
                                            <option></option>
                                            <option>A</option>
                                            <option>B</option>
                                            <option>C</option>
                                            <option>D</option>
                                            <option>E</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="button" class="btn btn-sm btn-danger" value="懸案"/>
                                    </td>
                                </tr>
                            </table>

                        </div>
                </div><!-- information tab -->
                <div class="col-md-2">
                    <div class="row">
                        <div class="col-md-12">
                            <ul class="nav nav-pills nav-stacked bookmarkUl">
                                <li role="presentation" class="currentBookmark"><a href="/kouji/${kouji.id}">情報</a></li>
                                <li role="presentation" ><a href="/kouji/${kouji.id}/instruct">点検指示</a></li>
                                <li role="presentation"><a href="/kouji/${kouji.id}/history">履歴</a></li>
                            </ul>
                        </div>
                    </div>
                </div><!-- tab button tab -->
            </div>
        </section>
    </div>
</body>
</html>
