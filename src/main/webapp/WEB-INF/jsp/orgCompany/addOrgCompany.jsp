<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>编辑企业</title>
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
                        编辑企业
                        <small>
                            <button type="button"
                                    onclick="javascript:location.href='/admin/orgCompany/index.do';"
                                    class="btn btn-outline btn-success btn-xs">返回上一步
                            </button>
                        </small>
                    </h5>
                </div>
                <div class="ibox-content">
                    <form method="post" id="newsForm" action="/admin/orgCompany/saveOrgCompany.do"
                          class="form-horizontal"
                          enctype="multipart/form-data">
                        <input type="hidden" name="orgCompanyId" value="${orgCompanyId}"/>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">登录账号</label>
                            <div class="col-sm-8">
                                <input type="text" maxlength="20" id="logonId" name="logonId"
                                       value="${orgCompany.logonId}"
                                       <c:if test="${not empty orgCompanyId}">readonly</c:if> class="form-control">
                                <span class="help-block m-b-none">请使用字母+数字方式创建账号</span>
                            </div>
                            <c:if test="${empty orgCompanyId}">
                                <div class="col-sm-2">
                                    <button class="btn btn-primary" type="button" onclick="getLogonId();">系统自动生成
                                    </button>
                                </div>
                            </c:if>
                        </div>
                        <c:if test="${empty orgCompanyId}">
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">登录密码</label>
                                <div class="col-sm-8">
                                    <input type="text" maxlength="20" id="logonPsd" name="logonPsd" value=""
                                           class="form-control">
                                </div>
                                <div class="col-sm-2">
                                    <button class="btn btn-primary" type="button" onclick="getPwd();">系统自动生成
                                    </button>
                                </div>
                            </div>
                        </c:if>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">公司名称</label>
                            <div class="col-sm-10">
                                <input type="text" maxlength="100" id="companyName" name="companyName"
                                       value="${orgCompany.companyName}"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">街道</label>
                            <div class="col-sm-10">
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
                                <span class="help-block m-b-none">街道名称需要与EXCEL文件一致</span>
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">组织代码</label>
                            <div class="col-sm-10">
                                <input type="text" maxlength="50" id="code" name="code" value="${orgCompany.code}"
                                       class="form-control">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-2">
                                <button class="btn btn-primary" type="submit">保存内容</button>
                                <button class="btn btn-white" type="button"
                                        onclick="javascript:location.href='/admin/orgCompany/index.do';">
                                    取消
                                </button>
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
<script>

    <c:if test="${not empty orgCompany}">
        $("#street").val("${orgCompany.street}");
    </c:if>

    function getLogonId() {
        var date = new Date();
        var logonId = date.getFullYear().toString() + (date.getMonth() + 1).toString() + date.getDate().toString() +
            date.getHours().toString() + date.getMinutes().toString() + date.getSeconds().toString() +
            (Math.random().toFixed(3) * 1000).toString();
        $("#logonId").val(logonId);
    }
    
    function getPwd() {
        var pwd = randomWord(true,6,8);
        $("#logonPsd").val(pwd);
    }

    function randomWord(randomFlag, min, max) {
        var str = "",
            range = min,
            arr = [ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                    'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                    'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z'];

        // 随机产生
        if (randomFlag) {
            range = Math.round(Math.random() * (max - min)) + min;
        }
        for (var i = 0; i < range; i++) {
            var pos = Math.round(Math.random() * (arr.length - 1));
            str += arr[pos];
        }
        return str;
    }

    $("#newsForm").validate({
        rules: {
            logonId: "required",
            companyName: "required",
            code: "required",
            street: "required",
        },
        messages: {
            logonId: "请输入登录账号",
            companyName: "请输入公司名称",
            code: "请输入公司组织代码/社会统一信用代码",
            street: "请输入街道",
        },
        submitHandler: function () {
            $("#newsForm").submit();
        }
    });
</script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/form_basic.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:15 GMT -->
</html>

