package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingliEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-03-02
 */
public interface JingliService extends IService<JingliEntity> {

     PageUtils queryPage(Map<String, Object> params);

}