package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.JingliDao;
import com.entity.JingliEntity;
import com.service.JingliService;
import com.entity.view.JingliView;

/**
 *  服务实现类
 * @author 
 * @since 2021-03-02
 */
@Service("jingliService")
@Transactional
public class JingliServiceImpl extends ServiceImpl<JingliDao, JingliEntity> implements JingliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JingliView> page =new Query<JingliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
