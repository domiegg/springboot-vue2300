package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiangchengEntity;
import java.util.Map;

/**
 * 奖惩表 服务类
 * @author 
 * @since 2021-03-02
 */
public interface JiangchengService extends IService<JiangchengEntity> {

     PageUtils queryPage(Map<String, Object> params);

}