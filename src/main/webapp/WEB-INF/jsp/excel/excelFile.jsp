<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/table_bootstrap.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:20:03 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>企业文件中心</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/css/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/css/iconfont.css" rel="stylesheet">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
                        <h4 class="example-title" style="color: red;">《${orgCompany.companyName}》文件管理</h4>
                        <div class="example">
                            <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                <c:if test="${hasUploadFlag}">
                                    <span><a href="javascript:doUpload();">上传<svg class="icon" aria-hidden="true"><use
                                            xlink:href="#icon-shangchuan3"></use></svg></span></a>
                                </c:if>
                                <small>
                                    <c:choose>
                                        <c:when test="${flag == 1}">
                                            <button type="button" style="margin-left: 20px;"
                                                    onclick="javascript:location.href='/admin/orgCompany/index.do';"
                                                    class="btn btn-outline btn-success btn-xs">返回上一步
                                            </button>
                                        </c:when>
                                        <c:otherwise>
                                            <button type="button" style="margin-left: 20px;"
                                                    onclick="javascript:location.href='/admin/orgCompany/file.do';"
                                                    class="btn btn-outline btn-success btn-xs">返回上一步
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </small>
                            </div>
                            <table id="exampleTableEvents" data-mobile-responsive="true">
                                <thead>
                                <tr>
                                    <%--<th data-field="state" data-checkbox="true"></th>--%>
                                    <th data-field="id">ID</th>
                                    <th data-field="fileName">文件名称</th>
                                    <th data-field="fileDateStr">文件日期</th>
                                    <th data-field="state" data-formatter="ztFun">是否已处理</th>
                                    <th data-field="createTimeStr">上传日期</th>
                                    <th data-field="updateTimeStr">更新日期</th>
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
                <form id="commentForm" class="form-horizontal" enctype="multipart/form-data">
                    <input type="hidden" id="roleId"/>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">日期</label>
                        <div class="col-sm-9 input-group date">
                            <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                            <input type="text" class="form-control" id="fileDate" name="fileDate" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Excel</label>
                        <div class="col-sm-9 input-group date">
                            <input type="file" class="form-control" id="excelFile" name="excelFile" accept=".xls,.xlsx">
                            <span class="help-block m-b-none">请勿重复上传同一个Excel</span>
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
<div class="modal inmodal fade" id="myModal5" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">窗口标题</h4>
                <small class="font-bold">这里可以显示副标题。
            </div>
            <div class="modal-body">
                <p><strong>H+</strong> 是一个完全响应式，基于Bootstrap3.3.6最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术，她提供了诸多的强大的可以重新组合的UI组件，并集成了最新的jQuery版本(v2.1.1)，当然，也集成了很多功能强大，用途广泛的jQuery插件，她可以用于所有的Web应用程序，如网站管理后台，网站会员中心，CMS，CRM，OA等等，当然，您也可以对她进行深度定制，以做出更强系统。</p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/plugins/jquery-validate/jquery.validate.min.js"></script>
<script src="/scripts/plugins/jquery-validate/messages_zh.min.js"></script>
<script src="/scripts/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="/scripts/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="/scripts/plugins/layer/layer.min.js"></script>
<script src="/scripts/iconfont.js"></script>
<script src="/scripts/bootstrap-prettyfile.js"></script>
<script src="/scripts/bootstrap-datetimepicker.min.js"></script>
<script src="/scripts/ajaxfileupload.js"></script>
<script>

    $("#commentForm").validate({
        rules: {
            fileDate: "required"
        },
        messages: {
            fileDate: "请选择文件日期",
        },
        submitHandler: function () {
            if ($("#excelFile").val().length == 0) {
                layer.msg("请选择需要上传的文件", {time: 1000});
                return;
            }
            $.ajaxFileUpload({
                    url: '/admin/excelFileAjax/saveExcelFile.do',
                    fileElementId: "excelFile",
                    method: 'post',
                    dataType: 'json',
                    data: {
                        'fileDate': $("#fileDate").val(),
                        companyId:${companyId}
                    },
                    success: function (data) {
                        if (data.success) {
                            layer.msg('操作成功', {
                                time: 1000 //2秒关闭（如果不配置，默认是3秒）
                            }, function () {
                                location.reload();
                                /*$("#exampleModal").modal('hide');
                                $('#exampleTableEvents').bootstrapTable(
                                    "refresh",
                                    {
                                        url: "/admin/excelFileAjax/listCompanyFile.do?companyId=${companyId}",
                                    }
                                );*/
                            });
                        }
                        else {
                            layer.msg("操作失败");
                        }
                    },
                    error: function (data, status) {
                        alert("error");
                    }
                }
            );
        }
    });

    $(document).ready(function () {
        $.fn.datetimepicker.dates['zh-CN'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            suffix: [],
            meridiem: ["上午", "下午"]
        };
        $('#fileDate').datetimepicker(
            {
                startDate: new Date(),
                minView: "month",
                autoclose: true,
                format: "yyyy-mm-dd",
                language: 'zh-CN'
            }
        );
        $('input[type="file"][name="excelFile"]').prettyFile({
            text: "选择Excel"
        });
    });

    function ztFun(value) {
        if(value == 0)
        {
            return "未处理";
        }
        else
        {
            return "已处理";
        }
    }

    function updateData() {
        //加载数据

        $("#myModal5").modal("show");
    }
    
    function czFun(value) {
        var _html = '';
        <c:if test="${hasUpdateFlag}">
        _html += '<button type="button" onclick="updateData(' + value + ');" class="btn btn-outline btn-primary edit">更新数据</button>';
        </c:if>
        _html += '<svg style="margin-left: 10px;" class="icon" onclick="doUpload();" aria-hidden="true"><use xlink:href="#icon-xiazai"></use></svg>';
        return _html;
    }

    function doUpload() {
        $("#exampleModal").modal("show");
    }

    $("#exampleTableEvents").bootstrapTable({
        url: "/admin/excelFileAjax/listCompanyFile.do?companyId=${companyId}",
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

