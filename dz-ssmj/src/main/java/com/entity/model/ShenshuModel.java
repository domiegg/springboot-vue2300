package com.entity.model;

import com.entity.ShenshuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 申请表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-02
 */
public class ShenshuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 俱乐部 Search
     */
    private Integer jlbTypes;


    /**
     * 申请人 Search
     */
    private Integer xsTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
     * 申请内容
     */
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
