package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.JingliEntity;
import com.entity.ShenshuEntity;
import com.service.JingliService;
import com.service.ShenshuService;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XuanshouEntity;

import com.service.XuanshouService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 人员表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-02
*/
@RestController
@Controller
@RequestMapping("/xuanshou")
public class XuanshouController {
    private static final Logger logger = LoggerFactory.getLogger(XuanshouController.class);

    @Autowired
    private XuanshouService xuanshouService;

    @Autowired
    private JingliService jingliService;

    @Autowired
    private ShenshuService shenshuService;

    @Autowired
    private TokenService tokenService;


    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        XuanshouEntity user = xuanshouService.selectOne(new EntityWrapper<XuanshouEntity>().eq("account", username));
        if(user != null){
            if(!user.getRole().equals(role)){
                return R.error("权限不正常");
            }
            if(user==null || !user.getPassword().equals(password)) {
                return R.error("账号或密码不正确");
            }
            String token = tokenService.generateToken(user.getId(),user.getName(), "users", user.getRole());
            return R.ok().put("token", token);
        }else{
            return R.error("账号或密码或权限不对");
        }

    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XuanshouEntity user = xuanshouService.selectById(id);
        return R.ok().put("data", user);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XuanshouEntity user){
//    	ValidatorUtils.validateEntity(user);
        if(xuanshouService.selectOne(new EntityWrapper<XuanshouEntity>().eq("account", user.getAccount())) !=null) {
            return R.error("选手或教练已存在");
        }
        xuanshouService.insert(user);
        return R.ok();
    }

    /**
     * 退出
     */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
        XuanshouEntity user = xuanshouService.selectOne(new EntityWrapper<XuanshouEntity>().eq("account", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        xuanshouService.update(user,null);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("选手") || role.equals("教练")){
            params.put("yh",request.getSession().getAttribute("userId"));
            params.put("qx",role);
            page = xuanshouService.queryPage(params);
        }else if(role.equals("经理")) {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            JingliEntity jingliEntity = jingliService.selectById(userId);
            if(jingliEntity == null){
                return R.error();
            }
            params.put("jlbTypes", jingliEntity.getJlbTypes());
            page = xuanshouService.queryPage(params);
        }else{
            page = xuanshouService.queryPage(params);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        XuanshouEntity xuanshou = xuanshouService.selectById(id);
        if(xuanshou!=null){
            return R.ok().put("data", xuanshou);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @IgnoreAuth
    @RequestMapping("/save")
    public R save(@RequestBody XuanshouEntity xuanshou, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<XuanshouEntity> queryWrapper = new EntityWrapper<XuanshouEntity>()
            .eq("name", xuanshou.getName())
            .eq("account", xuanshou.getAccount())
            .eq("jlb_types", xuanshou.getJlbTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanshouEntity xuanshouEntity = xuanshouService.selectOne(queryWrapper);
        if("".equals(xuanshou.getImgPhoto()) || "null".equals(xuanshou.getImgPhoto())){
            xuanshou.setImgPhoto(null);
        }
        if(xuanshouEntity==null){
            xuanshou.setZtTypes(1);
            xuanshouService.insert(xuanshou);
            return R.ok();
        }else {
            return R.error(511,"数据重复，请从新输入");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuanshouEntity xuanshou, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<XuanshouEntity> queryWrapper = new EntityWrapper<XuanshouEntity>()
            .notIn("id",xuanshou.getId())
            .eq("name", xuanshou.getName())
            .eq("account", xuanshou.getAccount())
            .eq("jlb_types", xuanshou.getJlbTypes())
            .eq("role", xuanshou.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuanshouEntity xuanshouEntity = xuanshouService.selectOne(queryWrapper);
        if("".equals(xuanshou.getImgPhoto()) || "null".equals(xuanshou.getImgPhoto())){
                xuanshou.setImgPhoto(null);
        }
        if(xuanshouEntity==null){
            xuanshouService.updateById(xuanshou);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
     * 同意
     */
    @RequestMapping("/consent")
    public R consent(@RequestBody Integer ids){
        ShenshuEntity shenshu = shenshuService.selectById(ids);
        if(shenshu==null){
           return R.error();
        }
        XuanshouEntity xuanshou = xuanshouService.selectById(shenshu.getXsTypes());
        if(xuanshou == null){
            return R.error();
        }
        if(xuanshou.getZtTypes() == 1){
            return R.error("您已经同意过了，请不要重复按同意按钮");
        }
        xuanshou.setZtTypes(1);
        xuanshouService.updateById(xuanshou);
        return R.ok();
    }

    /**
     * 同意转会
     */
    @RequestMapping("/consentTransfer")
    public R consentTransfer(@RequestBody Integer ids){
        ShenshuEntity shenshu = shenshuService.selectById(ids);
        if(shenshu==null){
            return R.error();
        }
        XuanshouEntity xuanshou = xuanshouService.selectById(shenshu.getXsTypes());
        if(xuanshou == null){
            return R.error();
        }
        if(xuanshou.getJlbTypes() == shenshu.getTemporary()){
            return R.error("您已经同意过了，请不要重复按同意按钮");
        }
        xuanshou.setJlbTypes(shenshu.getTemporary());
        xuanshouService.updateById(xuanshou);
        return R.ok();
    }

    /**
     * 退役
     */
    @RequestMapping("/retirement")
    public R retirement(@RequestBody Integer ids){
        XuanshouEntity xuanshou = xuanshouService.selectById(ids);
        if(xuanshou == null){
            return R.error();
        }
        if(xuanshou.getZtTypes() == 3){
            return R.error("已经退役了，请不要重复点击按钮");
        }
        xuanshou.setZtTypes(3);
        xuanshouService.updateById(xuanshou);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        xuanshouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

