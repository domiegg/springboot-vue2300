package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.annotation.IgnoreAuth;
import com.entity.JingliEntity;
import com.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JingliEntity;

import com.service.JingliService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-03-02
*/
@RestController
@Controller
@RequestMapping("/jingli")
public class JingliController {
    private static final Logger logger = LoggerFactory.getLogger(JingliController.class);

    @Autowired
    private JingliService jingliService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping(value = "/login")
    public R login(String username, String password, String role, HttpServletRequest request) {
        JingliEntity user = jingliService.selectOne(new EntityWrapper<JingliEntity>().eq("account", username));
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
        JingliEntity user = jingliService.selectById(id);
        return R.ok().put("data", user);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JingliEntity user){
//    	ValidatorUtils.validateEntity(user);
        if(jingliService.selectOne(new EntityWrapper<JingliEntity>().eq("account", user.getAccount())) !=null) {
            return R.error("经理已存在");
        }
        jingliService.insert(user);
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
        JingliEntity user = jingliService.selectOne(new EntityWrapper<JingliEntity>().eq("account", username));
        if(user==null) {
            return R.error("账号不存在");
        }
        user.setPassword("123456");
        jingliService.update(user,null);
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
        if(role.equals("经理")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = jingliService.queryPage(params);
        }else{
            page = jingliService.queryPage(params);
        }
        return R.ok().put("data", page);
    }


    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JingliEntity jingli = jingliService.selectById(id);
        if(jingli!=null){
            return R.ok().put("data", jingli);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JingliEntity jingli, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<JingliEntity> queryWrapper = new EntityWrapper<JingliEntity>()
            .eq("name", jingli.getName())
            .eq("account", jingli.getAccount())
            .eq("password", jingli.getPassword())
            .eq("sex_types", jingli.getSexTypes())
            .eq("jlb_types", jingli.getJlbTypes())
            .eq("role", jingli.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingliEntity jingliEntity = jingliService.selectOne(queryWrapper);
        if("".equals(jingli.getImgPhoto()) || "null".equals(jingli.getImgPhoto())){
            jingli.setImgPhoto(null);
        }
        if(jingliEntity==null){
            jingli.setRole("经理");
            jingliService.insert(jingli);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingliEntity jingli, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JingliEntity> queryWrapper = new EntityWrapper<JingliEntity>()
            .notIn("id",jingli.getId())
            .eq("name", jingli.getName())
            .eq("account", jingli.getAccount())
            .eq("password", jingli.getPassword())
            .eq("sex_types", jingli.getSexTypes())
            .eq("jlb_types", jingli.getJlbTypes())
            .eq("role", jingli.getRole())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingliEntity jingliEntity = jingliService.selectOne(queryWrapper);
        if("".equals(jingli.getImgPhoto()) || "null".equals(jingli.getImgPhoto())){
                jingli.setImgPhoto(null);
        }
        if(jingliEntity==null){
            jingliService.updateById(jingli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        jingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

