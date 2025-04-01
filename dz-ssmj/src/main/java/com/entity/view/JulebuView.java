package com.entity.view;

import com.entity.JulebuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 俱乐部表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("julebu")
public class JulebuView extends JulebuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public JulebuView() {

	}

	public JulebuView(JulebuEntity julebuEntity) {
		try {
			BeanUtils.copyProperties(this, julebuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
