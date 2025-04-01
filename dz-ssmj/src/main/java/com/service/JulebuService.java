package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JulebuEntity;
import java.util.Map;

/**
 * 俱乐部表 服务类
 * @author 
 * @since 2021-03-02
 */
public interface JulebuService extends IService<JulebuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}