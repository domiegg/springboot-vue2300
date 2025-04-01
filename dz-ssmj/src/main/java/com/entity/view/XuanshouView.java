package com.entity.view;

import com.entity.XuanshouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 人员表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("xuanshou")
public class XuanshouView extends XuanshouEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public XuanshouView() {

	}

	public XuanshouView(XuanshouEntity xuanshouEntity) {
		try {
			BeanUtils.copyProperties(this, xuanshouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
