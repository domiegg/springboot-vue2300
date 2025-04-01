<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["修改", "删除", "退役"],
			"menu": "人员信息",
			"menuJump": "列表",
			"tableName": "xuanshou"
		}],
		"menu": "人员管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "经理信息",
			"menuJump": "列表",
			"tableName": "jingli"
		}],
		"menu": "经理管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "俱乐部信息",
			"menuJump": "列表",
			"tableName": "julebu"
		}],
		"menu": "俱乐部管理"
	}, {
		"child": [{
			"buttons": ["新增", "删除"],
			"menu": "奖惩信息",
			"menuJump": "列表",
			"tableName": "jiangcheng"
		}],
		"menu": "奖惩管理"
	}, {
		"child": [{
			"buttons": ["删除", "同意"],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenshu"
		}],
		"menu": "申请管理"
	}],
	"frontMenu": [],
	"roleName": "管理员",
	"tableName": "users"
},{
	"backMenu": [{
		"child": [{
			"buttons": ["修改", "删除", "退役"],
			"menu": "人员信息",
			"menuJump": "列表",
			"tableName": "xuanshou"
		}],
		"menu": "人员管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "俱乐部信息",
			"menuJump": "列表",
			"tableName": "julebu"
		}],
		"menu": "俱乐部管理"
	}, {
		"child": [{
			"buttons": ["新增", "删除"],
			"menu": "奖惩信息",
			"menuJump": "列表",
			"tableName": "jiangcheng"
		}],
		"menu": "奖惩管理"
	}, {
		"child": [{
			"buttons": ["删除", "同意"],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenshu"
		}],
		"menu": "申请管理"
	}],
	"frontMenu": [],
	"roleName": "经理",
	"tableName": "jingli"
},{
	"backMenu": [{
		"child": [{
			"buttons": ["申请"],
			"menu": "奖惩信息",
			"menuJump": "列表",
			"tableName": "jiangcheng"
		}],
		"menu": "奖惩管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenshu"
		}],
		"menu": "申请管理"
	}],
	"frontMenu": [],
	"roleName": "教练",
	"tableName": "xuanshou"
},{
	"backMenu": [{
		"child": [{
			"buttons": ["申请"],
			"menu": "奖惩信息",
			"menuJump": "列表",
			"tableName": "jiangcheng"
		}],
		"menu": "奖惩管理"
	}, {
		"child": [{
			"buttons": [],
			"menu": "申请信息",
			"menuJump": "列表",
			"tableName": "shenshu"
		}],
		"menu": "申请管理"
	}],
	"frontMenu": [],
	"roleName": "选手",
	"tableName": "xuanshou"
}];
var hasMessage = '';
