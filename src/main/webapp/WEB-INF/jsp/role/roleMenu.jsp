<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<!-- Mirrored from www.zi-han.net/theme/hplus/jstree.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:56 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>菜单设置</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/css/ztree/bootstrapStyle/bootstrapStyle.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <input type="hidden" id="roleId" value="${roleId}"/>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>菜单配置
                        <small>配置角色权限菜单</small>
                    </h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div id="treeDemo" class="ztree">
                    </div>
                </div>
                <div class="ibox-content">
                    <button type="button" onclick="saveMenu();" class="btn btn-outline btn-primary edit">保存配置</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/ztree/jquery.ztree.core.min.js"></script>
<script src="/scripts/ztree/jquery.ztree.excheck.min.js"></script>
<script src="/scripts/plugins/layer/layer.min.js"></script>
<script>
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        view: {
            dblClickExpand: false
        },
        check: {
            enable: true
        }
    };

    var zTree;
    $(document).ready(function () {
        $.fn.zTree.init($("#treeDemo"), setting, ${menu});
        zTree = $.fn.zTree.getZTreeObj("treeDemo");
    });

    function saveMenu() {
        var nodes = zTree.getCheckedNodes(true);
        var _idArr = [];
        for (var i = 0; i < nodes.length; i++) {
            _idArr.push(nodes[i].id);
        }
        _idArr.push(1);
        _idArr.push(2);

        $.ajax({
            url: "/admin/roleAjax/saveRoleMenu.do",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",
            type: "POST",
            data: {
                roleId: ${roleId},
                menuId: _idArr.toString()
            },
            success: function (data) {
                if (data.success) {
                    layer.msg('操作成功', {
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        location.reload();
                    });
                }
            }
        });
    }
</script>
</body>
</html>

