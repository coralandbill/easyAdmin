<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> 基本表单</title>
    <meta name="keywords" content="">
    <meta name="description" content="，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="/css/animate.min.css" rel="stylesheet">
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <link href="/css/simditor.css" rel="stylesheet">
    <link href="/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>
                        编辑执法
                        <small>
                            <button type="button"
                                    onclick="javascript:location.href='/admin/enforce/index.do';"
                                    class="btn btn-outline btn-success btn-xs">返回上一步
                            </button>
                        </small>
                    </h5>
                </div>
                <div class="ibox-content">
                    <form method="post" id="newsForm" action="/admin/enforce/saveNews.do" class="form-horizontal" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${id}"/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">标题</label>
                            <div class="col-sm-10">
                                <input type="text" maxlength="100" id="title" name="title" value="${enforce.title}" class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">执法日期</label>
                            <div class="col-sm-10">
                                <div class="input-group date">
                                    <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                    <input type="text" class="form-control" id="enforceDate" name="enforceDate" value="${initDate}">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="hidden" id="enforceDesc" name="enforceDesc"/>
                            <label class="col-sm-2 control-label">内容</label>
                            <div class="col-sm-10">
                                <textarea id="editor" placeholder="请输入内容" autofocus>${enforce.enforceDesc}</textarea>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                                <button class="btn btn-white" type="button" onclick="javascript:location.href='/admin/enforce/index.do';">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/scripts/jquery.min.js?v=2.1.4"></script>
<script src="/scripts/bootstrap.min.js?v=3.3.6"></script>
<script src="/scripts/content.min.js?v=1.0.0"></script>
<script src="/scripts/plugins/jquery-validate/jquery.validate.min.js"></script>
<script src="/scripts/plugins/jquery-validate/messages_zh.min.js"></script>
<script src="/scripts/plugins/layer/layer.min.js"></script>
<!--simditor-->
<script src="/scripts/module.js"></script>
<script src="/scripts/hotkeys.js"></script>
<script src="/scripts/uploader.js"></script>
<script src="/scripts/simditor.js"></script>
<!--simditor-->
<script src="/scripts/bootstrap-prettyfile.js"></script>
<script src="/scripts/bootstrap-datetimepicker.min.js"></script>
<script>
    var toolbar = [
        'title',
        'bold',
        'italic',
        'underline',
        'strikethrough',
        'fontScale',
        'color',
        'ol',
        'ul',
        'blockquote',
        'table',
        'link',
        'image',
        'hr',
        'indent',
        'outdent',
        'alignment',
    ];
    var editor = new Simditor({
        textarea: $('#editor'),
        toolbar: toolbar,  //工具栏
        upload: {
            url: "/admin/newsAjax/uploadImg.do", //文件上传的接口地址
            params: {xx: ""}, //键值对,指定文件上传接口的额外参数,上传的时候随文件一起提交
            fileKey: 'file', //服务器端获取文件数据的参数名
            connectionCount: 3,
            leaveConfirm: '正在上传文件'
        }
        //optional options
    });
    $(document).ready(function () {
        $.fn.datetimepicker.dates['zh-CN'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["周日", "周一", "周二", "周三", "周四", "周五", "周六", "周日"],
            daysMin:  ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            today: "今天",
            suffix: [],
            meridiem: ["上午", "下午"]
        };
        $('input[type="file"][name="imgFile"]').prettyFile({
            text: "选择图片"
        });

        $( '#enforceDate' ).datetimepicker(
            {
                startDate:new Date(),
                minView: "month",
                autoclose: true,
                format: "yyyy-mm-dd",
                language: 'zh-CN'
            }
        );
    });
    $("#newsForm").validate({
        rules: {
            title: "required",
            enforceDate:"required"
        },
        messages: {
            title: "请输入名称",
            enforceDate:"请选择执法日期"
        },
        submitHandler: function () {
            var content = editor.getValue();
            if(content.length == 0)
            {
                layer.msg("请输入内容信息",{time:10000});
            }
            else
            {
                $("#enforceDesc").val(content);
                $("#newsForm").submit();
            }
        }
    });
</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
</html>

