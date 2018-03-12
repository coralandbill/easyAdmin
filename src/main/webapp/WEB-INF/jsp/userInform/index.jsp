<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> Bootstrap Table</title>
    <meta name="keywords" content="">
    <meta name="description" content="，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

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
                        <h4 class="example-title">举报管理</h4>
                        <div class="example">
                            <table id="exampleTableEvents" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="id">ID</th>
                                    <th data-field="title">举报标题</th>
                                    <th data-field="nickName">微信昵称</th>
                                    <th data-field="logoUrl" data-formatter="showLogo">微信头像</th>
                                    <th data-field="state" data-formatter="stateFun">状态</th>
                                    <th data-field="createTimeStr">举报时间</th>
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
<div class="modal fade" id="exampleModal" style="z-index: 999" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <input type="hidden" id="replayId"/>
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">举报信息</h4>
            </div>
            <div class="modal-body">
                <form id="commentForm">
                    <input type="hidden" id="roleId"/>
                    <div class="form-group" id="contentDiv">
                    </div>
                    <div class="form-group" id="imgDiv">
                    </div>
                    <div class="form-group">
                        <label for="replayContent" class="control-label">回复内容:</label>
                        <textarea class="form-control" id="replayContent" name="replayContent"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" id="saveBtn" class="btn btn-primary" onclick="replay();">回复
                </button>
            </div>
        </div>
    </div>
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/scripts/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/scripts/plugins/layer/layer.min.js"></script>
<script>

    function stateFun(value) {
        return value == 0 ? "未处理" : "已处理";
    }

    function showLogo(value) {
        return '<img src="' + value + '" width="50px;" height="50px;"/>';
    }

    function czFun(value, row, index) {
        if (row.state == 0) {
            return '<button type="button" onclick="showInfo(' + value + ',' + row.state + ');" class="btn btn-outline btn-primary edit">处理</button>';
        }
        else {
            return '<button type="button" onclick="showInfo(' + value + ',' + row.state + ');" class="btn btn-outline btn-primary edit">查看</button>';
        }
    }

    function showInfo(id, state) {
        if (state == 1) {
            $("#saveBtn").hide();
        }
        else {
            $("#saveBtn").show();
        }
        $.ajax({
            url: "/admin/userInformAjax/getById.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            type: "POST",
            data: {
                id: id
            },
            success: function (data) {
                if (data.success) {
                    $("#replayId").val(data.userInform.id);
                    //userInform
                    var html = '<label class="control-label" id="contentLabel">举报内容:</label>';
                    html += data.userInform.content;
                    $("#contentDiv").html(html);

                    var imgHtml = '<label class="control-label">举报图片:</label>';
                    var _imgUrl = data.userInform.imgUrl;
                    if (_imgUrl != undefined && _imgUrl.length > 0) {
                        var _imgArr = _imgUrl.split("|");
                        for (var i = 0; i < _imgArr.length; i++) {
                            imgHtml += '<img src="' + _imgArr[i] + '" width="100px;" height="100px;"/>';
                        }
                    }
                    $("#imgDiv").html(imgHtml);

                    $("#replayContent").val(data.userInform.replayContent == undefined ? "" : data.userInform.replayContent);
                }
                else {
                    layer.msg("操作失败");
                }
            }
        });
        $("#exampleModal").modal("show");
    }
    
    function replay() {
        var _replayId = $("#replayId").val();
        $.ajax({
            url: "/admin/userInformAjax/update.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            type: "POST",
            data: {
                id: _replayId,
                replayContent: $("#replayContent").val()
            },
            success: function (data) {
                if (data.success) {
                    $("#exampleModal").modal("hide");
                    $('#exampleTableEvents').bootstrapTable(
                        "refresh",
                        {
                            url: "/admin/userInformAjax/listUserInform.do",
                        }
                    );
                }
                else {
                    layer.msg("操作失败");
                }
            }
        });
    }

    $("#exampleTableEvents").bootstrapTable({
        url: "/admin/userInformAjax/listUserInform.do",
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

