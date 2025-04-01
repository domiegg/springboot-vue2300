<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <link href="http://www.bootcss.com/p/bootstrap-datetimepicker/bootstrap-datetimepicker/css/datetimepicker.css"
          rel="stylesheet">
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<style>
    .error {
        color: red;
    }
</style>
<body>
<!-- Pre Loader -->
<div class="loading">
    <div class="spinner">
        <div class="double-bounce1"></div>
        <div class="double-bounce2"></div>
    </div>
</div>
<!--/Pre Loader -->
<div class="wrapper">
    <!-- Page Content -->
    <div id="content">
        <!-- Top Navigation -->
        <%@ include file="../../static/topNav.jsp" %>
        <!-- Menu -->
        <div class="container menu-nav">
            <nav class="navbar navbar-expand-lg lochana-bg text-white">
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="ti-menu text-white"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul id="navUl" class="navbar-nav mr-auto">

                    </ul>
                </div>
            </nav>
        </div>
        <!-- /Menu -->
        <!-- Breadcrumb -->
        <!-- Page Title -->
        <div class="container mt-0">
            <div class="row breadcrumb-bar">
                <div class="col-md-6">
                    <h3 class="block-title">转会申请提交</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">转会申请提交</li>
                        <li class="breadcrumb-item active">转会申请提交</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container">

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">转会申请提交</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                                    <input id="updateId" name="id" type="hidden">
                                   <div class="form-group col-md-6">
                                       <label>现俱乐部</label>
                                       <select id="jlbTypesSelect" name="jlbTypes" class="form-control" disabled>
                                       </select>
                                   </div>
                                    <div class="form-group col-md-6">
                                        <label>转俱乐部</label>
                                        <select id="jlbTypesSelect1" name="temporary" class="form-control">
                                        </select>
                                    </div>
                                <div class="form-group col-md-12 mb-3">
                                    <button id="exitBtn" type="button" class="btn btn-primary btn-lg">返回</button>
                                    <button id="submitBtn" type="button" class="btn btn-primary btn-lg">提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /Widget Item -->
            </div>
        </div>
        <!-- /Main Content -->
    </div>
    <!-- /Page Content -->
</div>
<!-- Back to Top -->
<a id="back-to-top" href="#" class="back-to-top">
    <span class="ti-angle-up"></span>
</a>
<!-- /Back to Top -->
<%@ include file="../../static/foot.jsp" %>
<script src="${pageContext.request.contextPath}/resources/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.form.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/jquery.validate.min.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/messages_zh.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/validate/card.js"></script>
<script type="text/javascript" charset="utf-8"
        src="${pageContext.request.contextPath}/resources/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script>
    <%@ include file="../../utils/menu.jsp"%>
    <%@ include file="../../static/setMenu.js"%>
    <%@ include file="../../utils/baseUrl.jsp"%>

    var tableName = "xuanshou";
    var pageType = "add-or-update";
    var updateId = "";
    var crossTableId = -1;
    var crossTableName = '';
    var ruleForm = {};
    var crossRuleForm = {};
    var xsTypes = null;
    var jlbTypesOptions = [];

    var ruleForm = {};
    var vm = new Vue({
        el: '#addOrUpdateForm',
        data: {
            ruleForm: {},
        },
        beforeCreate: function () {
            xsTypes = window.sessionStorage.getItem("updateId");
            if (xsTypes != null && xsTypes != "" && xsTypes != "null") {
                $.ajax({
                    type: "GET",
                    url: baseUrl + "xuanshou/info/" + xsTypes,
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("token", window.sessionStorage.getItem('token'));
                    },
                    success: function (res) {
                        if (res.code == 0) {
                            vm.ruleForm = res.data;
                        } else if (res.code == 401) {
                        <%@ include file="../../static/toLogin.jsp"%>
                        } else {
                            alert(res.msg)
                        }
                    },
                });
            }
        },
        methods: {}
    });


    // 表单提交
    function submit() {
        if (validform() == true && compare() == true) {
            let data = {};
            let value = $('#addOrUpdateForm').serializeArray();
            $.each(value, function (index, item) {
                data[item.name] = item.value;
            });
            data.jlbTypes=ruleForm.jlbTypes;
            debugger
            data.xsTypes = xsTypes;
            let json = JSON.stringify(data);
            httpJson("shenshu/save", "POST", data, (res) => {
                if(res.code == 0
        )
            {
                window.sessionStorage.removeItem('updateId');
                let flag = true;
                if (flag) {
                    alert("申请添加成功");
                    window.location.href = "list.jsp"
                }
            }
        })
            ;
        } else {
            alert("表单未填完整或有错误");
        }
    }

    //查询当前页面下所有列表
        function jlbTypesSelect() {
            //填充下拉框选项
            http("julebu/page?page=1&limit=100&sort=&order=&dicCode=jlb_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jlbTypesOptions = res.data.list;
            }
        });
        }

    function initializationJlbtypesSelect(){
        var jlbTypesSelect = document.getElementById('jlbTypesSelect');
        var jlbTypesSelect1 = document.getElementById('jlbTypesSelect1');
            for (var i = 0; i < jlbTypesOptions.length; i++) {
                jlbTypesSelect.add(new Option(jlbTypesOptions[i].name,jlbTypesOptions[i].id));
                jlbTypesSelect1.add(new Option(jlbTypesOptions[i].name,jlbTypesOptions[i].id));
            }
    }
    // 下拉框选项回显
    function setSelectOption() {
        for (var i = 0; i < jlbTypesOptions.length; i++) {
            if(jlbTypesOptions[i].id == ruleForm.jlbTypes){//下拉框value对比,如果一致就赋值汉字
                document.getElementById("jlbTypesSelect").options[i].selected = true;
            }
        }
    }


    //搜素输入检查
            function idChickValue(e){
                var this_val = e.value || 0;
                var reg=/^[0-9]*$/;
                if(!reg.test(this_val)){
                    e.value = "";
                    alert("输入不合法");
                    return false;
                }
            }

    function exit() {
        window.sessionStorage.removeItem("updateId");
        window.location.href = "list.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                temporary: {required: true},
            },
            messages: {
                temporary: {required: "转俱乐部不能为空"},
            }
        }).form();
    }

    // 获取当前详情
    function getDetails() {
        var id = window.sessionStorage.getItem("updateId");
        if (id != null && id != "" && id != "null") {
            updateId = id;
            window.sessionStorage.removeItem('updateId');
            http("xuanshou/info/" + id, "GET", {}, (res) => {
                if(res.code == 0
        )
            {
                ruleForm = res.data
                // 是/否下拉框回显
                setSelectOption();
                //注册表单验证
                $(validform());
            }
        });
        } else {
            //注册表单验证
            $(validform());
        }
    }

    // 关联下拉框改变
    function lvSelectChange(level) {
        let data = {};
        let value = $('#addOrUpdateForm').serializeArray();
        $.each(value, function (index, item) {
            data[item.name] = item.value;
        });

    }

    // 清除可能会重复渲染的selection
    function clear(className) {
        var elements = document.getElementsByClassName(className);
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }


    function calculationSE(colName) {
        //单列求和接口
        http("zhiburizhi" + colName, "GET", {
            tableName: "zhiburizhi",
            columnName: colName
        }, (res) => {
            if(res.code == 0
    )
        {
            $("#" + colName).attr("value", res.data);
        }
    })
        ;
    }




    $(document).ready(function () {
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        //设置导航栏菜单
        setMenu();
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //查询当前页面所有下拉框
        jlbTypesSelect();

        // 初始化下拉框
        initializationJlbtypesSelect();
        getDetails();
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
        readonly();
    });

    function readonly() {
        if (window.sessionStorage.getItem('role') != '管理员') {
            $('#jifen').attr('readonly', 'readonly');
            //$('#money').attr('readonly', 'readonly');
        }
    }

    //比较大小
    function compare() {
        var largerVal = null;
        var smallerVal = null;
        if (largerVal != null && smallerVal != null) {
            if (largerVal <= smallerVal) {
                alert(smallerName + '不能大于等于' + largerName);
                return false;
            }
        }
        return true;
    }


    // 用户登出
    <%@ include file="../../static/logout.jsp"%>
</script>
</body>

</html>