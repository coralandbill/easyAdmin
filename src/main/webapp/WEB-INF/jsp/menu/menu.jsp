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
    <style type="text/css">
        div#rMenu {position:absolute; visibility:hidden; top:0; background-color: #555;text-align: left;padding: 2px;z-index: 9999}
        div#rMenu ul li{
            margin: 1px 0;
            padding: 0 5px;
            cursor: pointer;
            list-style: none outside none;
            background-color: #DFDFDF;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <strong>jsTree</strong>是一个基于jQuery的Tree控件。支持
                    XML，JSON，Html三种数据源。提供创建，重命名，移动，删除，拖放节点操作。可以自己自定义创建，删除，嵌套，重命名，选择节点的规则。在这些操作上可以添加多种监听事件。
                    <br>更多信息请访问： <a href="http://www.jstree.com/" target="_blank">http://www.jstree.com/</a>
                </div>
            </div>
        </div>
    </div>
    <div id="rMenu">
        <ul>
            <li id="m_add" onclick="addTreeNode();">增加节点</li>
            <li id="m_del" onclick="removeTreeNode();">删除节点</li>
            <li id="m_check" onclick="checkTreeNode(true);">Check节点</li>
            <li id="m_unCheck" onclick="checkTreeNode(false);">unCheck节点</li>
            <li id="m_reset" onclick="resetTree();">恢复zTree</li>
        </ul>
    </div>
    <div class="row">
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>基本示例
                        <small>使用Font Awesome图标</small>
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
            </div>
        </div>
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>JSON示例</h5>
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
                    <div id="using_json">
                        ${menu}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/ztree/jquery.ztree.core.min.js"></script>
<script src="/scripts/ztree/jquery.ztree.excheck.min.js"></script>
<script src="/scripts/ztree/jquery.ztree.exedit.min.js"></script>
<script>
    var rMenu = $("#rMenu");
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        view: {
            dblClickExpand: false
        },
        check: {
            enable: true
        },
        callback: {
            onRightClick: OnRightClick
        }
    };
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    function OnRightClick(event, treeId, treeNode) {
        if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
            zTree.cancelSelectedNode();
            showRMenu("root", event.clientX, event.clientY);
        } else if (treeNode && !treeNode.noR) {
            zTree.selectNode(treeNode);
            showRMenu("node", event.clientX, event.clientY);
        }
    }

    function showRMenu(type, x, y) {
        $("#rMenu ul").show();
        if (type == "root") {
            $("#m_del").hide();
            $("#m_check").hide();
            $("#m_unCheck").hide();
        } else {
            $("#m_del").show();
            $("#m_check").show();
            $("#m_unCheck").show();
        }

        y += document.body.scrollTop;
        x += document.body.scrollLeft;
        rMenu.css({"top": y + "px", "left": x + "px", "visibility": "visible"});

        $("body").bind("mousedown", onBodyMouseDown);
    }
    function hideRMenu() {
        if (rMenu) rMenu.css({"visibility": "hidden"});
        $("body").unbind("mousedown", onBodyMouseDown);
    }
    function onBodyMouseDown(event) {
        if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
            rMenu.css({"visibility": "hidden"});
        }
    }
    var addCount = 1;
    function addTreeNode() {
        hideRMenu();
        var newNode = {name: "增加" + (addCount++)};
        if (zTree.getSelectedNodes()[0]) {
            newNode.checked = zTree.getSelectedNodes()[0].checked;
            zTree.addNodes(zTree.getSelectedNodes()[0], newNode);
        } else {
            zTree.addNodes(null, newNode);
        }
    }
    function removeTreeNode() {
        hideRMenu();
        var nodes = zTree.getSelectedNodes();
        if (nodes && nodes.length > 0) {
            if (nodes[0].children && nodes[0].children.length > 0) {
                var msg = "要删除的节点是父节点，如果删除将连同子节点一起删掉。\n\n请确认！";
                if (confirm(msg) == true) {
                    zTree.removeNode(nodes[0]);
                }
            } else {
                zTree.removeNode(nodes[0]);
            }
        }
    }
    function checkTreeNode(checked) {
        var nodes = zTree.getSelectedNodes();
        if (nodes && nodes.length > 0) {
            zTree.checkNode(nodes[0], checked, true);
        }
        hideRMenu();
    }
    function resetTree() {
        hideRMenu();
        $.fn.zTree.init($("#treeDemo"), setting, ${menu});
    }

    var zTree, rMenu;
    $(document).ready(function () {
        $.fn.zTree.init($("#treeDemo"), setting, ${menu});
        zTree = $.fn.zTree.getZTreeObj("treeDemo");
        rMenu = $("#rMenu");
    });
</script>
</body>
</html>

