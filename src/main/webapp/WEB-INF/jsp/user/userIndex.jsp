<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>后台管理系统</title>
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
                        <h4 class="example-title">系统用户管理</h4>
                        <div class="example">
                            <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                <button type="button" class="btn btn-outline btn-default" onclick="doAdd();">
                                    <i class="glyphicon glyphicon-plus" aria-hidden="true">添加</i>
                                </button>
                                <button type="button" class="btn btn-outline btn-default" onclick="removeUser();">
                                    <i class="glyphicon glyphicon-trash" aria-hidden="true">批量删除</i>
                                </button>
                            </div>
                            <table id="exampleTableEvents" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <th data-field="state" data-checkbox="true"></th>
                                    <th data-field="id">ID</th>
                                    <th data-field="name">名称</th>
                                    <th data-field="email">邮箱</th>
                                    <th data-field="updateTimeStr">创建时间</th>
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
                <h4 class="modal-title" id="exampleModalLabel">添加系统用户</h4>
            </div>
            <div class="modal-body">
                <form id="commentForm">
                    <input type="hidden" id="userId"/>
                    <div class="form-group">
                        <label for="roleName" class="control-label">名称:</label>
                        <input type="text" class="form-control" id="roleName" name="roleName">
                    </div>
                    <div class="form-group" id="pdwDiv">
                        <label for="psw" class="control-label">密码:</label>
                        <input type="text" class="form-control" id="psw" name="psw">
                    </div>
                    <div class="form-group" id="streetDiv">
                        <label for="psw" class="control-label">街道:</label>
                        <select class="form-control m-b" name="street" id="street">
                            <option value="元和街道">元和街道</option>
                            <option value="黄桥街道">黄桥街道</option>
                            <option value="太平街道">太平街道</option>
                            <option value="北桥街道">北桥街道</option>
                            <option value="阳澄湖镇">阳澄湖镇</option>
                            <option value="渭塘镇">渭塘镇</option>
                            <option value="黄埭镇">黄埭镇</option>
                            <option value="望亭镇">望亭镇</option>
                            <option value="开发区">开发区</option>
                            <option value="高铁新城">高铁新城</option>
                            <option value="度假区">度假区</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="psw" class="control-label">邮箱:</label>
                        <input type="email" class="form-control" id="email" name="email">
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否禁用</label>
                        <div class="col-sm-10">
                            <label class="checkbox-inline">
                                <input type="radio" value="1" name="flag" id="flagChk1" checked="true">否</label>
                            <label class="checkbox-inline">
                                <input type="radio" value="0" name="flag" id="flagChk0">是</label>
                        </div>
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
<div class="modal fade" id="pwdExampleModal" style="z-index: 999" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" userId="">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">重置密码</h4>
            </div>
            <div class="modal-body">
                <form id="pwdForm">
                    <div class="form-group">
                        <label for="roleName" class="control-label">新密码:</label>
                        <input type="text" class="form-control" id="pwd_new" name="pwd_new">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="$('#pwdForm').submit();">确定</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="userExampleModal" style="z-index: 999" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" userId="">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">配置角色</h4>
            </div>
            <div class="modal-body">
                <form id="userForm">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">选择角色</label>
                        <div class="col-sm-10">
                            <select class="form-control m-b" id="roleSelect" name="roleSelect">
                                <option value="99999">请选择</option>
                                <c:forEach items="${roleList}" var="role">
                                    <option value="${role.id}">${role.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="$('#userForm').submit();">确定</button>
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
    var table;

    function removeUser() {
        var selectObj = table.bootstrapTable('getSelections');
        if (selectObj.length == 0) {
            layer.msg("请选择需要删除的角色", {time: 1000});
        }
        else {
            layer.confirm('确定删除角色？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                var _idArr = [];
                for (var i = 0; i < selectObj.length; i++) {
                   _idArr.push(selectObj[i].id);
                }
                $.ajax({
                    url: "/admin/userAjax/deleteUserRole.do",
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    dataType: "json",
                    type: "POST",
                    data: {
                        ids: _idArr.toString()
                    },
                    success: function (data) {
                        if (data.success) {
                            layer.msg('操作成功', {
                                time: 1000 //2秒关闭（如果不配置，默认是3秒）
                            }, function () {
                                $('#exampleTableEvents').bootstrapTable(
                                    "refresh",
                                    {
                                        url: "/admin/userAjax/listUser.do",
                                    }
                                );
                            });
                        }
                        else {
                            if(data.errMsg != undefined){
                                layer.msg(data.errMsg);
                            }else{
                                layer.msg("操作失败");
                            }
                        }
                    }
                });
            }, function () {

            });
        }
    }

    $("#userForm").validate({
        rules: {
            roleSelect: "required"
        },
        messages: {
            roleSelect: "请选择角色",
        },
        submitHandler: function () {
            $.ajax({
                url: "/admin/userAjax/saveUserRole.do",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json",
                type: "POST",
                data: {
                    roleId: $("#roleSelect").val(),
                    userId: $("#userExampleModal").attr("userId")
                },
                success: function (data) {
                    if (data.success) {
                        layer.msg('操作成功', {
                            time: 1000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                            $("#userExampleModal").modal('hide');
                            $('#exampleTableEvents').bootstrapTable(
                                "refresh",
                                {
                                    url: "/admin/userAjax/listUser.do",
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

    $("#commentForm").validate({
        rules: {
            roleName: "required",
            psw: "required"
        },
        messages: {
            roleName: "请输入名称",
            psw: "请输入密码"
        },
        submitHandler: function () {
            $.ajax({
                url: "/admin/userAjax/saveUser.do",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json",
                type: "POST",
                data: {
                    name: $("#roleName").val(),
                    psw: $("#psw").val(),
                    email: $("#email").val(),
                    userId: $("#userId").val(),
                    street: $("#street").val(),
                    flag: $("input[name='flag']:checked").val()
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
                                    url: "/admin/userAjax/listUser.do",
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

    function doAdd() {
        $("#userId").val("");
        $("#roleName").val("");
        $("#psw").val("");
        $("#email").val("");
        $(":radio[name='flag'][value='1']").prop("checked", "checked");
        $("#pdwDiv").show();
        $("#exampleModal").modal('show');
    }

    function editRole(id) {
        $("#userId").val(id);
        $.ajax({
            url: "/admin/userAjax/getById.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            type: "POST",
            data: {
                id: id
            },
            success: function (data) {
                if (data.success) {
                    $("#roleName").val(data.adminUser.name);
                    $("#email").val(data.adminUser.email);
                    $("#street").val(data.adminUser.street);
                    $(":radio[name='flag'][value='" + data.adminUser.flag + "']").prop("checked", "checked");
                    $("#pdwDiv").hide();
                    $("#exampleModal").modal('show');
                }
            }
        });
    }

    function czFun(value) {
        return '<button type="button" onclick="editRole(' + value + ');" style="text-align: center" class="btn btn-outline btn-primary edit">编辑</button>' +
            '<button type="button" onclick="selectRole(' + value + ');" style="text-align: center;margin-left: 20px;" class="btn btn-outline btn-success delete">配置</button>' +
            '<button type="button" onclick="resetPwd(' + value + ');" style="text-align: center;margin-left: 20px;" class="btn btn-outline btn-success delete">重置密码</button>';
    }

    function selectRole(id) {
        $("#userExampleModal").attr("userId", id);
        $('#roleSelect').prop('selectedIndex', 0);
        $.ajax({
            url: "/admin/userAjax/getUserRoleId.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            type: "POST",
            data: {
                userId: id
            },
            success: function (data) {
                if (data.success) {
                    $("#roleSelect option[value='" + data.roleId + "']").attr("selected", true);
                }
                $("#userExampleModal").modal('show');
            }
        });
    }

    function resetPwd(id) {
        $("#pwd_new").val("");
        $("#pwdExampleModal").attr("userId", id);
        $("#pwdExampleModal").modal("show");
    }

    $("#pwdForm").validate({
        rules: {
            pwd_new: "required"
        },
        messages: {
            pwd_new: "请输入密码"
        },
        submitHandler: function () {
            $.ajax({
                url: "/admin/userAjax/resetPwd.do",
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                dataType: "json",
                type: "POST",
                data: {
                    userId: $("#pwdExampleModal").attr("userId"),
                    pwd: $("#pwd_new").val()
                },
                success: function (data) {
                    if (data.success) {
                        layer.msg('操作成功', {
                            time: 1000 //2秒关闭（如果不配置，默认是3秒）
                        }, function () {
                            $("#pwdExampleModal").modal('hide');
                        });
                    }
                    else {
                        layer.msg("操作失败");
                    }
                }
            });
        }
    });

    table = $("#exampleTableEvents").bootstrapTable({
        url: "/admin/userAjax/listUser.do",
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

