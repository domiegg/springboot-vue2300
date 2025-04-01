package com.dao;

import com.entity.JulebuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JulebuView;

/**
 * 俱乐部表 Dao 接口
 *
 * @author 
 * @since 2021-03-02
 */
public interface JulebuDao extends BaseMapper<JulebuEntity> {

   List<JulebuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
