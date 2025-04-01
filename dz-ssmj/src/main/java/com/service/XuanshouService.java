package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuanshouEntity;
import java.util.Map;

/**
 * 人员表 服务类
 * @author 
 * @since 2021-03-02
 */
public interface XuanshouService extends IService<XuanshouEntity> {

     PageUtils queryPage(Map<String, Object> params);

}