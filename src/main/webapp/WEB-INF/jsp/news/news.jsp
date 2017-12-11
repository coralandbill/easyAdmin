<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - Bootstrap Table</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Other -->
    <div class="ibox float-e-margins">
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <!-- Example Events -->
                    <div class="example-wrap">
                        <h4 class="example-title">活动管理</h4>
                        <div class="example">
                            <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                <button type="button" onclick="javascript:location.href='/admin/news/addNews.do?newsType=${newsType}';" class="btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true">添加</i>
                                </button>
                                <%--<button type="button" class="btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true">删除</i>
                                </button>--%>
                            </div>
                            <table id="exampleTableEvents" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <%--<th data-field="state" data-checkbox="true"></th>--%>
                                    <th data-field="id">ID</th>
                                    <th data-field="title">标题</th>
                                    <th data-field="source">来源</th>
                                    <th data-field="imgUrl">封面图片</th>
                                    <th data-field="newsDate">新闻日期</th>
                                    <th data-field="createTimeStr">创建时间</th>
                                    <th data-field="id" data-formatter="czFun" data-events="actionEvents">操作</th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                    <!-- End Example Events -->
                </div>
            </div>
        </div>
    </div>
    <!-- End Panel Other -->
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/scripts/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/scripts/plugins/layer/layer.min.js"></script>
<script>

    function setMenu(roleId) {
        location.href = '/admin/role/menu.do?roleId=' + roleId;
    }

    function czFun(value) {
        return '<button type="button" onclick="editRole(' + value + ');" class="btn btn-outline btn-primary edit">编辑</button>' +
            '<button type="button" onclick="setMenu(' + value + ');" style="margin-left: 10px;" class="btn btn-outline btn-success delete">配置</button>';
    }

    $("#exampleTableEvents").bootstrapTable({
        url: "/admin/newsAjax/listNews.do",
        dataType: "json",
        search: !0,
        pagination: !0,
        showRefresh: !0,
        showToggle: false,
        showColumns: false,
        iconSize: "outline",
        toolbar: "#exampleTableEventsToolbar",
        sidePagination: "server", //服务端处理分页
        icons: {
            refresh: "glyphicon-repeat",
            toggle: "glyphicon-list-alt",
            columns: "glyphicon-list"
        },
        //每页的记录行数（*）
        pageSize: 10,
        //可供选择的每页的行数（*）
        pageList: [10, 25, 50, 100]
    });
    var e = $("#examplebtTableEventsResult");
    $("#exampleTableEvents").on("all.bs.table", function (e, t, o) {
        console.log("Event:", t, ", data:", o)
    }).on("click-row.bs.table", function () {
        e.text("Event: click-row.bs.table")
    }).on("dbl-click-row.bs.table", function () {
        e.text("Event: dbl-click-row.bs.table")
    }).on("sort.bs.table", function () {
        e.text("Event: sort.bs.table")
    }).on("check.bs.table", function () {
        e.text("Event: check.bs.table")
    }).on("uncheck.bs.table", function () {
        e.text("Event: uncheck.bs.table")
    }).on("check-all.bs.table", function () {
        e.text("Event: check-all.bs.table")
    }).on("uncheck-all.bs.table", function () {
        e.text("Event: uncheck-all.bs.table")
    }).on("load-success.bs.table", function () {
        e.text("Event: load-success.bs.table")
    }).on("load-error.bs.table", function () {
        e.text("Event: load-error.bs.table")
    }).on("column-switch.bs.table", function () {
        e.text("Event: column-switch.bs.table")
    }).on("page-change.bs.table", function () {
        e.text("Event: page-change.bs.table")
    }).on("search.bs.table", function () {
        e.text("Event: search.bs.table")
    })
</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:06 GMT -->
</html>

