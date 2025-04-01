<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
</head>
<style>

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
                    <h3 class="block-title">奖惩表管理</h3>
                </div>
                <div class="col-md-6">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="${pageContext.request.contextPath}/index.jsp">
                                <span class="ti-home"></span>
                            </a>
                        </li>
                        <li class="breadcrumb-item">奖惩表管理</li>
                        <li class="breadcrumb-item active">奖惩表列表</li>
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
                        <h3 class="widget-title">奖惩表列表</h3>
                        <div class="table-responsive mb-3">
                            <div class="col-sm-12">
                                                                 
                                        <label>
                                            <input type="text" id="headlineSearch" class="form-control form-control-sm"
                                                   placeholder="标题" aria-controls="tableId">
                                        </label>
                                 
                                            <label>
                                                俱乐部
                                                <select name="jlbTypesSelectSearch" id="jlbTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                            <label>
                                                奖惩人
                                                <select name="xsTypesSelectSearch" id="xsTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                            <label>
                                                奖惩状态
                                                <select name="jcTypesSelectSearch" id="jcTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                 
                                            <label>
                                                奖惩等级
                                                <select name="djTypesSelectSearch" id="djTypesSelectSearch" class="form-control form-control-sm"
                                                        aria-controls="tableId">
                                                </select>
                                            </label>
                                                                
                                <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                </br>
                                <button onclick="add()" type="button" class="btn btn-success 新增">添加奖惩数据</button>
                                <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                                <button onclick="graph()" type="button" class="btn btn-danger 报表">报表</button>
                            </div>
                            <table id="tableId" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th class="no-sort" style="min-width: 35px;">
                                        <div class="custom-control custom-checkbox">
                                            <input class="custom-control-input" type="checkbox" id="select-all"
                                                   onclick="chooseAll()">
                                            <label class="custom-control-label" for="select-all"></label>
                                        </div>
                                    </th>
                                    <th onclick="sort('headline')">标题</th>
                                    <th onclick="sort('jlbTypes')">俱乐部</th>
                                    <th onclick="sort('xsTypes')">奖惩人</th>
                                    <th onclick="sort('jcTypes')">奖惩状态</th>
                                    <th onclick="sort('djTypes')">奖惩等级</th>
                                    <th onclick="sort('createTime')">录入时间</th>
                                    <th onclick="sort('noticeContent')">内容信息</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                            <div class="col-md-6 col-sm-3">
                                <div class="dataTables_length" id="tableId_length">

                                    <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                            onchange="changePageSize()">
                                        <option value="10">10</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="100">100</option>
                                    </select>
                                    条 每页

                                </div>
                            </div>
                            <nav aria-label="Page navigation example">
                                <ul class="pagination justify-content-end">
                                    <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                        <a class="page-link" href="#" tabindex="-1">上一页</a>
                                    </li>

                                    <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                        <a class="page-link" href="#">下一页</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
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
<script language="javascript" type="text/javascript"
        src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>

<script>
    <%@ include file="../../utils/menu.jsp"%>
            <%@ include file="../../static/setMenu.js"%>
            <%@ include file="../../utils/baseUrl.jsp"%>
            <%@ include file="../../static/getRoleButtons.js"%>
            <%@ include file="../../static/crossBtnControl.js"%>
    var tableName = "jiangcheng";
    var pageType = "list";
    var searchForm = {key: ""};
    var pageIndex = 1;
    var pageSize = 10;
    var totalPage = 0;
    var dataList = [];
    var sortColumn = '';
    var sortOrder = '';
    var ids = [];
    var checkAll = false;

            var jlbTypesOptions = [];
            var xsTypesOptions = [];
            var jcTypesOptions = [];
            var djTypesOptions = [];

    function init() {
        // 满足条件渲染提醒接口
    }

    // 改变每页记录条数
    function changePageSize() {
        var selection = document.getElementById('selectPageSize');
        var index = selection.selectedIndex;
        pageSize = selection.options[index].value;
        getDataList();
    }



    // 查询
    function search() {
        searchForm = {key: ""};
         
        if ($('#headlineSearch').val() != null && $('headlineSearch').val() != '') {
            searchForm.headline = $('#headlineSearch').val();

        }
     
        var jlbTypesIndex = document.getElementById("jlbTypesSelectSearch").selectedIndex;
        var jlbTypesValue;
        if( jlbTypesIndex  == 0){
                jlbTypesValue='';
        }else{
                jlbTypesValue= document.getElementById("jlbTypesSelectSearch").options[jlbTypesIndex].value;
        }

        searchForm.jlbTypes = jlbTypesValue;

     
        var xsTypesIndex = document.getElementById("xsTypesSelectSearch").selectedIndex;
        var xsTypesValue;
        if( xsTypesIndex  == 0){
                xsTypesValue='';
        }else{
                xsTypesValue= document.getElementById("xsTypesSelectSearch").options[xsTypesIndex].value;
        }

        searchForm.xsTypes = xsTypesValue;

     
        var jcTypesIndex = document.getElementById("jcTypesSelectSearch").selectedIndex;
        var jcTypesValue;
        if( jcTypesIndex  == 0){
                jcTypesValue='';
        }else{
                jcTypesValue= document.getElementById("jcTypesSelectSearch").options[jcTypesIndex].value;
        }

        searchForm.jcTypes = jcTypesValue;

     
        var djTypesIndex = document.getElementById("djTypesSelectSearch").selectedIndex;
        var djTypesValue;
        if( djTypesIndex  == 0){
                djTypesValue='';
        }else{
                djTypesValue= document.getElementById("djTypesSelectSearch").options[djTypesIndex].value;
        }

        searchForm.djTypes = djTypesValue;

                getDataList();
    }

    // 获取数据列表
    function getDataList() {
        http("jiangcheng/page", "GET", {
            page: pageIndex,
            limit: pageSize,
            sort: sortColumn,
            order: sortOrder,
                    headline: searchForm.headline,
                    jlbTypes: searchForm.jlbTypes,
                    xsTypes: searchForm.xsTypes,
                    jcTypes: searchForm.jcTypes,
                    djTypes: searchForm.djTypes,
    }, (res) => {
            if(res.code == 0
            )
            {
                clear();
                dataList = res.data.list;
                totalPage = res.data.totalPage;
                //var tbody = document.getElementById('tbMain');
                for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                    var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                    $('tbody').append(trow);
                }
                pagination(); //渲染翻页组件
                getRoleButtons();// 权限按钮控制
            }
        })
        ;
    }

    // 渲染表格数据
    function setDataRow(item, number) {
        //创建行 
        var row = document.createElement('tr');
        row.setAttribute('class', 'useOnce');
        //创建勾选框
        var checkbox = document.createElement('td');
        var checkboxDiv = document.createElement('div');
        checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
        var checkboxInput = document.createElement('input');
        checkboxInput.setAttribute("class", "custom-control-input");
        checkboxInput.setAttribute("type", "checkbox");
        checkboxInput.setAttribute('name', 'chk');
        checkboxInput.setAttribute('value', item.id);
        checkboxInput.setAttribute("id", number);
        checkboxDiv.appendChild(checkboxInput);
        var checkboxLabel = document.createElement('label');
        checkboxLabel.setAttribute("class", "custom-control-label");
        checkboxLabel.setAttribute("for", number);
        checkboxDiv.appendChild(checkboxLabel);
        checkbox.appendChild(checkboxDiv);
        row.appendChild(checkbox)

        var headlineCell = document.createElement('td');
        headlineCell.innerHTML = item.headline;
        row.appendChild(headlineCell);

        var headlineCell = document.createElement('td');
        headlineCell.innerHTML = item.jlbname;
        row.appendChild(headlineCell);

        var headlineCell = document.createElement('td');
        headlineCell.innerHTML = item.xsname;
        row.appendChild(headlineCell);


        var jcTypesCell = document.createElement('td');
        for (var i = 0; i < jcTypesOptions.length; i++) {
            if(jcTypesOptions[i].codeIndex == item.jcTypes){//下拉框value对比,如果一致就赋值汉字
                    jcTypesCell.innerHTML = jcTypesOptions[i].indexName;
            }
        }
        row.appendChild(jcTypesCell);

        var djTypesCell = document.createElement('td');
        for (var i = 0; i < djTypesOptions.length; i++) {
            if(djTypesOptions[i].codeIndex == item.djTypes){//下拉框value对比,如果一致就赋值汉字
                    djTypesCell.innerHTML = djTypesOptions[i].indexName;
            }
        }
        row.appendChild(djTypesCell);


        var headlineCell = document.createElement('td');
        headlineCell.innerHTML = item.createTime;
        row.appendChild(headlineCell);


        var noticeContentCell = document.createElement('td');

        //如果图文详情包含图片
        if (item.noticeContent && item.noticeContent.indexOf('img') != -1) {
            //暂时只考虑图片+文字 和 文字+图片的情况
            var beginIndex = item.noticeContent.indexOf('<img');
            var endIndex = item.noticeContent.indexOf('>');
                noticeContentCell.innerHTML = item.noticeContent.substring(beginIndex, endIndex + 1).replace("img", "img width='100' height='100'");
        } else {
            if (item.noticeContent != null && item.noticeContent != "" && item.noticeContent.length >= 21) {
                    noticeContentCell.innerHTML = item.noticeContent.substring(0, 20) + "...";
            } else {
                    noticeContentCell.innerHTML = item.noticeContent;
            }
        }

        row.appendChild(noticeContentCell);

        //每行按钮
        var btnGroup = document.createElement('td');

        //修改按钮
        var editBtn = document.createElement('button');
        var editAttr = 'edit(' + item.id + ')';
        editBtn.setAttribute("type", "button");
        editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
        editBtn.setAttribute("onclick", editAttr);
        editBtn.innerHTML = "修改"
        btnGroup.appendChild(editBtn)
        //删除按钮
        var deleteBtn = document.createElement('button');
        var deleteAttr = 'remove(' + item.id + ')';
        deleteBtn.setAttribute("type", "button");
        deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
        deleteBtn.setAttribute("onclick", deleteAttr);
        deleteBtn.innerHTML = "删除"
        btnGroup.appendChild(deleteBtn)

        if(item.jcTypes == 2 && item.djTypes >=2){
            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "apply(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 申请");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "申请"
            btnGroup.appendChild(detailBtn)
        }

        row.appendChild(btnGroup)
        return row;
    }

    //搜素输入检查

    // 翻页
    function pageNumChange(val) {
        if (val == 'pre') {
            pageIndex--;
        } else if (val == 'next') {
            pageIndex++;
        } else {
            pageIndex = val;
        }
        getDataList();
    }

    // 下载
    function download(url) {
        window.open(url);
    }

    // 打开新窗口播放媒体
    function mediaPlay(url) {
        window.open(url);
    }

    // 渲染翻页组件
    function pagination() {
        var beginIndex = pageIndex;
        var endIndex = pageIndex;
        var point = 4;
        //计算页码
        for (var i = 0; i < 3; i++) {
            if (endIndex == totalPage) {
                break;
            }
            endIndex++;
            point--;
        }
        for (var i = 0; i < 3; i++) {
            if (beginIndex == 1) {
                break;
            }
            beginIndex--;
            point--;
        }
        if (point > 0) {
            while (point > 0) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            while (point > 0) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--
            }
        }
        // 是否显示 前一页 按钮
        if (pageIndex > 1) {
            $('#tableId_previous').show();
        } else {
            $('#tableId_previous').hide();
        }
        // 渲染页码按钮
        for (var i = beginIndex; i <= endIndex; i++) {
            var pageNum = document.createElement('li');
            pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
            if (pageIndex == i) {
                pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
            } else {
                pageNum.setAttribute('class', 'paginate_button page-item useOnce');
            }
            var pageHref = document.createElement('a');
            pageHref.setAttribute('class', 'page-link');
            pageHref.setAttribute('href', '#');
            pageHref.setAttribute('aria-controls', 'tableId');
            pageHref.setAttribute('data-dt-idx', i);
            pageHref.setAttribute('tabindex', 0);
            pageHref.innerHTML = i;
            pageNum.appendChild(pageHref);
            $('#tableId_next').before(pageNum);
        }
        // 是否显示 下一页 按钮
        if (pageIndex < totalPage) {
            $('#tableId_next').show();
            $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
        } else {
            $('#tableId_next').hide();
        }
        var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
        $('#tableId_info').html(pageNumInfo);
    }

    // 跳转到指定页
    function toThatPage() {
        //var index = document.getElementById('pageIndexInput').value;
        if (index < 0 || index > totalPage) {
            alert('请输入正确的页码');
        } else {
            pageNumChange(index);
        }
    }

    // 全选/全不选
    function chooseAll() {
        checkAll = !checkAll;
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].checked = checkAll;
        }
    }

    // 批量删除
    function deleteMore() {
        ids = []
        var boxs = document.getElementsByName("chk");
        for (var i = 0; i < boxs.length; i++) {
            if (boxs[i].checked) {
                ids.push(boxs[i].value)
            }
        }
        if (ids.length == 0) {
            alert('请勾选要删除的记录');
        } else {
            remove(ids);
        }
    }

    // 申请
    function apply(id) {
        var mymessage = confirm("真的要申请吗？");
        if (mymessage == true) {
                paramArray = id;
            httpJson("shenshu/apply", "POST", paramArray, (res) => {
                if(res.code == 0
        )
            {
                getDataList();
                alert('申请成功');
            }
        })
            ;
        }
        else {
            alert("已取消操作");
        }
    }

    // 删除
    function remove(id) {
        var mymessage = confirm("真的要删除吗？");
        if (mymessage == true) {
            var paramArray = [];
            if (id == ids) {
                paramArray = id;
            } else {
                paramArray.push(id);
            }
            httpJson("jiangcheng/delete", "POST", paramArray, (res) => {
                if(res.code == 0
        )
            {
                getDataList();
                alert('删除成功');
            }
        })
            ;
        }
        else {
            alert("已取消操作");
        }
    }

    // 用户登出
    <%@ include file="../../static/logout.jsp"%>

            //修改
            function edit(id) {
                window.sessionStorage.setItem('updateId', id)
                window.location.href = "add-or-update.jsp"
            }

    //清除会重复渲染的节点
    function clear() {
        var elements = document.getElementsByClassName('useOnce');
        for (var i = elements.length - 1; i >= 0; i--) {
            elements[i].parentNode.removeChild(elements[i]);
        }
    }

    //添加
    function add() {
        window.location.href = "add-or-update.jsp"
    }

    //报表
    function graph() {
        window.location.href = "graph.jsp"
    }

    //单列求和
    function getSum(colName) {
        http("jiangcheng" + colName, "GET", {
            tableName: "jiangcheng",
            columnName: colName
        }, (res) => {
            if(res.code == 0
    )
        {
            return res.data.sum;
        }
    })
        ;
    }

    // 查看详情
    function detail(id) {
        window.sessionStorage.setItem("id", id);
        //window.sessionStorage.setItem("ifView", true);
        window.location.href = "info.jsp";
    }

    //填充搜索下拉框
         
     
            function jlbTypesSelectSearch() {
                var jlbTypesSelectSearch = document.getElementById('jlbTypesSelectSearch');
                    jlbTypesSelectSearch.add(new Option('请选择',''));
                for (var i = 0; i < jlbTypesOptions.length; i++) {
                        jlbTypesSelectSearch.add(new Option(jlbTypesOptions[i].name,jlbTypesOptions[i].id));
                }
            }

            function xsTypesSelectSearch() {
                var xsTypesSelectSearch = document.getElementById('xsTypesSelectSearch');
                    xsTypesSelectSearch.add(new Option('请选择',''));
                for (var i = 0; i < xsTypesOptions.length; i++) {
                        xsTypesSelectSearch.add(new Option(xsTypesOptions[i].name,xsTypesOptions[i].id));
                }
            }

            function jcTypesSelectSearch() {
                var jcTypesSelectSearch = document.getElementById('jcTypesSelectSearch');
                    jcTypesSelectSearch.add(new Option('请选择',''));
                for (var i = 0; i < jcTypesOptions.length; i++) {
                        jcTypesSelectSearch.add(new Option(jcTypesOptions[i].indexName,jcTypesOptions[i].codeIndex));
                }
            }
     
            function djTypesSelectSearch() {
                var djTypesSelectSearch = document.getElementById('djTypesSelectSearch');
                    djTypesSelectSearch.add(new Option('请选择',''));
                for (var i = 0; i < djTypesOptions.length; i++) {
                        djTypesSelectSearch.add(new Option(djTypesOptions[i].indexName,djTypesOptions[i].codeIndex));
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
        function xsTypesSelect() {
            //填充下拉框选项
            http("xuanshou/page?page=1&limit=100", "GET", {}, (res) => {
                if(res.code == 0){
                    xsTypesOptions = res.data.list;
            }
        });
        }
        function jcTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=jc_types", "GET", {}, (res) => {
                if(res.code == 0){
                    jcTypesOptions = res.data.list;
            }
        });
        }
        function djTypesSelect() {
            //填充下拉框选项
            http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=dj_types", "GET", {}, (res) => {
                if(res.code == 0){
                    djTypesOptions = res.data.list;
            }
        });
        }
    //跨表
    function crossTable(id, crossTableName) {
        window.sessionStorage.setItem('crossTableId', id);
        window.sessionStorage.setItem('crossTableName', "jiangcheng");
        var url = "../" + crossTableName + "/add-or-update.jsp";
        window.location.href = url;
    }


    $(document).ready(function () {
        //激活翻页按钮
        $('#tableId_previous').attr('class', 'paginate_button page-item previous')
        $('#tableId_next').attr('class', 'paginate_button page-item next')
        //隐藏原生搜索框
        $('#tableId_filter').hide()
        //设置右上角用户名
        $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
        //设置项目名
        $('.sidebar-header h3 a').html(projectName)
        setMenu();
        init();

        //查询当前页面所有下拉框
        jlbTypesSelect();
        xsTypesSelect();
        jcTypesSelect();
        djTypesSelect();
        getDataList();


        //下拉框赋值
                         
             
            jlbTypesSelectSearch();
             
            xsTypesSelectSearch();
             
            jcTypesSelectSearch();
             
            djTypesSelectSearch();
                        
    <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>