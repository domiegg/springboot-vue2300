package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenshuEntity;
import java.util.Map;

/**
 * 申请表 服务类
 * @author 
 * @since 2021-03-02
 */
public interface ShenshuService extends IService<ShenshuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}