package com.entity.view;

import com.entity.JiangchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 奖惩表
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("jiangcheng")
public class JiangchengView extends JiangchengEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public JiangchengView() {

	}
	private String xsname;

	private String jlbname;

	public String getXsname() {
		return xsname;
	}

	public void setXsname(String xsname) {
		this.xsname = xsname;
	}

	public String getJlbname() {
		return jlbname;
	}

	public void setJlbname(String jlbname) {
		this.jlbname = jlbname;
	}

	public JiangchengView(JiangchengEntity jiangchengEntity) {
		try {
			BeanUtils.copyProperties(this, jiangchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
