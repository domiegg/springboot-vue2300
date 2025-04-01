package com.entity.vo;

import com.entity.ShenshuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 申请表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("shenshu")
public class ShenshuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 俱乐部 Search
     */

    @TableField(value = "jlb_types")
    private Integer jlbTypes;


    /**
     * 申请人 Search
     */

    @TableField(value = "xs_types")
    private Integer xsTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
     * 申请内容
     */

    @TableField(value = "notice_content")
    private String noticeContent;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：俱乐部 Search
	 */
    public Integer getJlbTypes() {
        return jlbTypes;
    }


    /**
	 * 获取：俱乐部 Search
	 */

    public void setJlbTypes(Integer jlbTypes) {
        this.jlbTypes = jlbTypes;
    }
    /**
	 * 设置：申请人 Search
	 */
    public Integer getXsTypes() {
        return xsTypes;
    }


    /**
	 * 获取：申请人 Search
	 */

    public void setXsTypes(Integer xsTypes) {
        this.xsTypes = xsTypes;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：申请内容
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：申请内容
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

}
