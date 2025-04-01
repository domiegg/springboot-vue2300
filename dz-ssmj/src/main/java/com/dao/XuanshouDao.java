package com.dao;

import com.entity.XuanshouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XuanshouView;

/**
 * 人员表 Dao 接口
 *
 * @author 
 * @since 2021-03-02
 */
public interface XuanshouDao extends BaseMapper<XuanshouEntity> {

   List<XuanshouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
