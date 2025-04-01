package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShenshuDao;
import com.entity.ShenshuEntity;
import com.service.ShenshuService;
import com.entity.view.ShenshuView;

/**
 * 申请表 服务实现类
 * @author 
 * @since 2021-03-02
 */
@Service("shenshuService")
@Transactional
public class ShenshuServiceImpl extends ServiceImpl<ShenshuDao, ShenshuEntity> implements ShenshuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShenshuView> page =new Query<ShenshuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
