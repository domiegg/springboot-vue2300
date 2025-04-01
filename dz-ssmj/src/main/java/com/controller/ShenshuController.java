package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.JiangchengEntity;
import com.entity.JingliEntity;
import com.service.JiangchengService;
import com.service.JingliService;
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

import com.entity.ShenshuEntity;

import com.service.ShenshuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 申请表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-02
*/
@RestController
@Controller
@RequestMapping("/shenshu")
public class ShenshuController {
    private static final Logger logger = LoggerFactory.getLogger(ShenshuController.class);

    @Autowired
    private ShenshuService shenshuService;

    @Autowired
    private JingliService jingliService;

    @Autowired
    private JiangchengService jiangchengService;


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
            page = shenshuService.queryPage(params);
        }else if(role.equals("经理")) {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            JingliEntity jingliEntity = jingliService.selectById(userId);
            if(jingliEntity == null){
                return R.error();
            }
            params.put("jlbTypes", jingliEntity.getJlbTypes());
            page = shenshuService.queryPage(params);
        }else{
            page = shenshuService.queryPage(params);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShenshuEntity shenshu = shenshuService.selectById(id);
        if(shenshu!=null){
            return R.ok().put("data", shenshu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShenshuEntity shenshu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShenshuEntity> queryWrapper = new EntityWrapper<ShenshuEntity>()
                .eq("jlb_types", shenshu.getJlbTypes())
                .eq("xs_types", shenshu.getXsTypes())
                .like("notice_content", shenshu.getNoticeContent()+"%")
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenshuEntity shenshuEntity = shenshuService.selectOne(queryWrapper);
        if(shenshu.getTemporary() == shenshu.getJlbTypes()){
            return R.error("要转的俱乐部不能和现在所在的俱乐部相同");
        }

        if(shenshu.getJlbTypes() == 1){
            if(shenshu.getTemporary()==2){
                shenshu.setNoticeContent("俱乐部1 转 俱乐部2");
            }
            if(shenshu.getTemporary()==3){
                shenshu.setNoticeContent("俱乐部1 转 俱乐部3");
            }
        }
        if(shenshu.getJlbTypes() == 2){
            if(shenshu.getTemporary()==1){
                shenshu.setNoticeContent("俱乐部2 转 俱乐部1");
            }
            if(shenshu.getTemporary()==3){
                shenshu.setNoticeContent("俱乐部2 转 俱乐部3");
            }
        }
        if(shenshu.getJlbTypes() == 3){
            if(shenshu.getTemporary()==2){
                shenshu.setNoticeContent("俱乐部3 转 俱乐部2");
            }
            if(shenshu.getTemporary()==1){
                shenshu.setNoticeContent("俱乐部3 转 俱乐部1");
            }
        }

        if(shenshuEntity==null){
            shenshuService.insert(shenshu);
            return R.ok();
        }else {
            return R.error(511,"你已经申请过了，请不要重复申请");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShenshuEntity shenshu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ShenshuEntity> queryWrapper = new EntityWrapper<ShenshuEntity>()
            .notIn("id",shenshu.getId())
            .eq("jlb_types", shenshu.getJlbTypes())
            .eq("xs_types", shenshu.getXsTypes())
            .eq("notice_content", shenshu.getNoticeContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenshuEntity shenshuEntity = shenshuService.selectOne(queryWrapper);
        if(shenshuEntity==null){
            shenshuService.updateById(shenshu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
     * 申请
     */
    @RequestMapping("/apply")
    public R apply(@RequestBody Integer ids){
        JiangchengEntity jiangcheng = jiangchengService.selectById(ids);
        if(jiangcheng == null){
            return R.error();
        }
        ShenshuEntity shenshu = new ShenshuEntity();
        shenshu.setCreateTime(new Date());
        shenshu.setJlbTypes(jiangcheng.getJlbTypes());
        shenshu.setXsTypes(jiangcheng.getXsTypes());
        shenshu.setNoticeContent(jiangcheng.getNoticeContent());
        Wrapper<ShenshuEntity> queryWrapper = new EntityWrapper<ShenshuEntity>()
                .eq("jlb_types", shenshu.getJlbTypes())
                .eq("xs_types", shenshu.getXsTypes())
                .like("notice_content", shenshu.getNoticeContent()+"%")
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShenshuEntity shenshuEntity = shenshuService.selectOne(queryWrapper);
        if(shenshuEntity==null){
            shenshuService.insert(shenshu);
            return R.ok();
        }else {
            return R.error(511,"你已经申请过了，请不要重复申请");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        shenshuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

