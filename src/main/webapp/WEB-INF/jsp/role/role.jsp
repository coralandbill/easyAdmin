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
        <div class="ibox-title">
            <h5>其他</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <i class="fa fa-wrench"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href="#">选项1</a>
                    </li>
                    <li><a href="#">选项2</a>
                    </li>
                </ul>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <!-- Example Events -->
                    <div class="example-wrap">
                        <h4 class="example-title">事件</h4>
                        <div class="example">
                            <div class="alert alert-success" id="examplebtTableEventsResult" role="alert">
                                事件结果
                            </div>
                            <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                <button type="button" class="btn btn-outline btn-default" data-toggle="modal"
                                        data-target="#exampleModal">
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true">添加</i>
                                </button>
                                <button type="button" class="btn btn-outline btn-default">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true">删除</i>
                                </button>
                            </div>
                            <table id="exampleTableEvents" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="state" data-checkbox="true"></th>
                                    <th data-field="id">ID</th>
                                    <th data-field="name">名称</th>
                                    <th data-field="description">描述</th>
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
<div class="modal fade" id="exampleModal" style="z-index: 999" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">添加角色</h4>
            </div>
            <div class="modal-body">
                <form id="commentForm">
                    <input type="hidden" id="roleId"/>
                    <div class="form-group">
                        <label for="roleName" class="control-label">名称:</label>
                        <input type="text" class="form-control" id="roleName" name="roleName">
                    </div>
                    <div class="form-group">
                        <label for="roleDesc" class="control-label">描述:</label>
                        <textarea class="form-control" id="roleDesc" name="roleDesc"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="$('#commentForm').submit();">确定</button>
            </div>
        </div>
    </div>
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/scripts/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/scripts/plugins/jquery-validate/jquery.validate.min.js"></script>
<script src="/scripts/plugins/jquery-validate/messages_zh.min.js"></script>
<script src="/scripts/plugins/layer/layer.min.js"></script>
<script>

    $("#commentForm").validate({
        rules: {
            roleName: "required"
        },
        messages: {
            roleName: "请输入名称"
        },
        submitHandler: function () {
            $.ajax({
                url: "/admin/roleAjax/saveRole.do",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json",
                type: "POST",
                data: {
                    name: $("#roleName").val(),
                    desc: $("#roleDesc").val(),
                    roleId: $("#roleId").val()
                },
                success: function (data) {
                    if (data.success) {
                        layer.msg('操作成功', {
                            time: 1000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                            $("#exampleModal").modal('hide');
                            $('#exampleTableEvents').bootstrapTable(
                                "refresh",
                                {
                                    url: "/admin/roleAjax/listRole.do",
                                }
                            );
                        });
                    }
                    else {
                        layer.msg("操作失败");
                    }
                }
            });
        }
    });

    function editRole(id) {
        $("#roleId").val(id);
        $.ajax({
            url: "/admin/roleAjax/getById.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            type: "POST",
            data: {
                id: id
            },
            success: function (data) {
                if(data.success)
                {
                    $("#roleName").val(data.role.name);
                    $("#roleDesc").val(data.role.description);
                    $("#exampleModal").modal('show');
                }
            }
        });
    }

    function czFun(value) {
        return '<button type="button" onclick="editRole(' + value + ');" class="btn btn-outline btn-primary edit">编辑</button>' +
            '<button type="button" style="margin-left: 10px;" class="btn btn-outline btn-success delete">配置</button>';
    }

    $("#exampleTableEvents").bootstrapTable({
        url: "/admin/roleAjax/listRole.do",
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

