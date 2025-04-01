package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.JingliEntity;
import com.entity.XuanshouEntity;
import com.service.JingliService;
import com.service.XuanshouService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiangchengEntity;

import com.service.JiangchengService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 奖惩表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-02
*/
@RestController
@Controller
@RequestMapping("/jiangcheng")
public class JiangchengController {
    private static final Logger logger = LoggerFactory.getLogger(JiangchengController.class);

    @Autowired
    private JiangchengService jiangchengService;

    @Autowired
    private JingliService jingliService;

    @Autowired
    private XuanshouService xuanshouService;

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
            page = jiangchengService.queryPage(params);
        }else if(role.equals("经理")) {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            JingliEntity jingliEntity = jingliService.selectById(userId);
            if(jingliEntity == null){
                return R.error();
            }
            params.put("jlbTypes", jingliEntity.getJlbTypes());
            page = jiangchengService.queryPage(params);
        }else{
            page = jiangchengService.queryPage(params);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JiangchengEntity jiangcheng = jiangchengService.selectById(id);
        if(jiangcheng!=null){
            return R.ok().put("data", jiangcheng);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiangchengEntity jiangcheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<JiangchengEntity> queryWrapper = new EntityWrapper<JiangchengEntity>()
            .eq("jlb_types", jiangcheng.getJlbTypes())
            .eq("xs_types", jiangcheng.getXsTypes())
            .eq("jc_types", jiangcheng.getJcTypes())
            .eq("dj_types", jiangcheng.getDjTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiangchengEntity jiangchengEntity = jiangchengService.selectOne(queryWrapper);
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        XuanshouEntity xuanshou = xuanshouService.selectById(jiangcheng.getXsTypes());
        if (xuanshou == null){
            return R.error();
        }
        jiangcheng.setJlbTypes(xuanshou.getJlbTypes());
        if(jiangcheng.getJcTypes()==2){
            if(jiangcheng.getDjTypes()==2){
                jiangcheng.setNoticeContent("本次惩罚为2级,本次惩罚将个人禁赛;"+jiangcheng.getNoticeContent());
                xuanshou.setZtTypes(4);
                xuanshouService.updateById(xuanshou);
            }else if(jiangcheng.getDjTypes()==3){
                jiangcheng.setNoticeContent("本次惩罚为3级,本次惩罚将俱乐部禁赛;"+jiangcheng.getNoticeContent());
                xuanshou.setZtTypes(5);
                xuanshouService.updateById(xuanshou);
            }else{
                jiangcheng.setNoticeContent("本次惩罚为1级，本次惩罚将通报批评;"+jiangcheng.getNoticeContent());
            }
        }
        if(jiangchengEntity==null){
            jiangchengService.insert(jiangcheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiangchengEntity jiangcheng, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JiangchengEntity> queryWrapper = new EntityWrapper<JiangchengEntity>()
            .notIn("id",jiangcheng.getId())
            .eq("jlb_types", jiangcheng.getJlbTypes())
            .eq("xs_types", jiangcheng.getXsTypes())
            .eq("jc_types", jiangcheng.getJcTypes())
            .eq("dj_types", jiangcheng.getDjTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiangchengEntity jiangchengEntity = jiangchengService.selectOne(queryWrapper);
        if(jiangchengEntity==null){
            jiangchengService.updateById(jiangcheng);//根据id更新
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
        jiangchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

