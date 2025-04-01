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
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">注册</li>
                    </ol>
                </div>
            </div>
        </div>
        <!-- /Page Title -->

        <!-- /Breadcrumb -->
        <!-- Main Content -->
        <div class="container" style="width: 600px" center>

            <div class="row">
                <!-- Widget Item -->
                <div class="col-md-12">
                    <div class="widget-area-2 lochana-box-shadow">
                        <h3 class="widget-title">注册</h3>
                        <form id="addOrUpdateForm">
                            <div class="form-row">
                                    <input id="updateId" name="id" type="hidden">
                                    <div class="form-group col-md-6">
                                        <label>比赛名称</label>
                                        <input id="name" name="name" class="form-control"
                                               placeholder="比赛名称">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>账号</label>
                                        <input id="account" name="account" class="form-control"
                                               placeholder="账号">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>密码</label>
                                        <input id="password" name="password" class="form-control"
                                               placeholder="密码">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>出生年月</label>
                                        <input id="dateofbirthTime" name="dateofbirthTime" class="form-control layui-input"
                                               placeholder="出生年月">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>家庭住址</label>
                                        <input id="address" name="address" class="form-control"
                                               placeholder="家庭住址">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>家庭联系方式</label>
                                        <input id="information" name="information" class="form-control"
                                               placeholder="家庭联系方式">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>个人联系方式</label>
                                        <input id="grinformation" name="grinformation" class="form-control"
                                               placeholder="个人联系方式">
                                    </div>
                                   <div class="form-group col-md-6">
                                       <label>性别</label>
                                       <select id="sexTypesSelect" name="sexTypes" class="form-control">
                                       </select>
                                   </div>
                                   <div class="form-group col-md-6">
                                       <label>俱乐部</label>
                                       <select id="jlbTypesSelect" name="jlbTypes" class="form-control">
                                       </select>
                                   </div>
                                    <div class="form-group col-md-6">
                                        <label>身份</label>
                                        <select id="role" name="role" class="form-control">
                                            <option value="教练">教练</option>
                                            <option value="选手">选手</option>
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
<script src="${pageContext.request.contextPath}/resources/laydate/laydate.js"></script>
<script>
    <%@ include file="../../utils/baseUrl.jsp"%>
    var sexTypesOptions = [];
    var jlbTypesOptions = [];

    var ruleForm = {};
    var vm = new Vue({
        el: '#addOrUpdateForm',
        data: {
            ruleForm: {},
        },
        beforeCreate: function () {
            var id = window.sessionStorage.getItem("updateId");
            if (id != null && id != "" && id != "null") {
                $.ajax({
                    type: "GET",
                    url: baseUrl + "xuanshou/info/" + id,
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
            let json = JSON.stringify(data);
            httpJson("xuanshou/save", "POST", data, (res) => {
                if(res.code == 0
        )
            {
                window.sessionStorage.removeItem('id');
                let flag = true;
                if (flag) {
                    window.location.href = "../../login.jsp";
                    alert("注册成功,请登录");
                }

            }
        })
            ;
        } else {
            alert("表单未填完整或有错误");
        }
    }

    //查询当前页面下所有列表
        function sexTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types", "GET", {}, (res) => {
                if(res.code == 0){
                    sexTypesOptions = res.data.list;
            }
        });
        }
        function jlbTypesSelect() {
            //填充下拉框选项
            http("julebu/page?page=1&limit=100&sort=&order=&dicCode=jlb_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jlbTypesOptions = res.data.list;
            }
        });
        }

    //初始化下拉框
    function initializationSextypesSelect(){
        var sexTypesSelect = document.getElementById('sexTypesSelect');
            for (var i = 0; i < sexTypesOptions.length; i++) {
                sexTypesSelect.add(new Option(sexTypesOptions[i].indexName,sexTypesOptions[i].codeIndex));
            }
    }
    function initializationJlbtypesSelect(){
        var jlbTypesSelect = document.getElementById('jlbTypesSelect');
            for (var i = 0; i < jlbTypesOptions.length; i++) {
                jlbTypesSelect.add(new Option(jlbTypesOptions[i].name,jlbTypesOptions[i].id));
            }
    }
    // 下拉框选项回显
    function setSelectOption() {
        for (var i = 0; i < sexTypesOptions.length; i++) {
            if(sexTypesOptions[i].codeIndex == ruleForm.sexTypes){//下拉框value对比,如果一致就赋值汉字
                document.getElementById("sexTypesSelect").options[i].selected = true;
            }
        }
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
        window.location.href = "../../login.jsp";
    }
    // 表单校验
    function validform() {
        return $("#addOrUpdateForm").validate({
            rules: {
                name: {required: true},
                account: {required: true},
                password: {required: true},
                dateofbirthTime: {required: true},
                address: {required: true},
                information: {required: true},
                grinformation: {required: true},
            },
            messages: {
                name: {required: "名称不能为空"},
                account: {required: "账号不能为空"},
                password: {required: "密码不能为空"},
                dateofbirthTime: {required: "出生年月不能为空"},
                address: {required: "家庭地址不能为空"},
                information: {required: "家庭联系方式不能为空"},
                grinformation: {required: "个人联系方式不能为空"},
            }
        }).form();
    }

    // 添加表单校验方法
    function addValidation() {
        jQuery.validator.addMethod("isPhone", function (value, element) {
            var length = value.length;
            var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "请填写正确的手机号码");
        jQuery.validator.addMethod("isIdCardNo", function (value, element) {
            return this.optional(element) || idCardNoUtil.checkIdCardNo(value);
        }, "请正确输入您的身份证号码");
    }


    function dateTimePick() {
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
    }


    $(document).ready(function () {
        laydate.render({
            elem: '#dateofbirthTime'
            ,format: 'yyyy年MM月dd日'
        });
        $('#exitBtn').on('click', function (e) {
            e.preventDefault();
            exit();
        });
        //初始化时间插件
        dateTimePick();
        //添加表单校验信息文本
        addValidation();
        //查询当前页面所有下拉框
        sexTypesSelect();
        jlbTypesSelect();

        // 初始化下拉框
        initializationSextypesSelect();
        initializationJlbtypesSelect();
        //初始化上传按钮
    <%@ include file="../../static/myInfo.js"%>
                $('#submitBtn').on('click', function (e) {
                    e.preventDefault();
                    //console.log("点击了...提交按钮");
                    submit();
                });
    });


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


</script>
</body>

</html>