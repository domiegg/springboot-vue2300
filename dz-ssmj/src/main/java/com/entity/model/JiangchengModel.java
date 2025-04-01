package com.entity.model;

import com.entity.JiangchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 奖惩表
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-02
 */
public class JiangchengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题 Search
     */
    private String headline;


    /**
     * 俱乐部 Search
     */
    private Integer jlbTypes;


    /**
     * 奖惩人 Search
     */
    private Integer xsTypes;


    /**
     * 奖惩状态 Search
     */
    private Integer jcTypes;


    /**
     * 奖惩等级 Search
     */
    private Integer djTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
     * 内容信息
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
	 * 设置：标题 Search
	 */
    public String getHeadline() {
        return headline;
    }


    /**
	 * 获取：标题 Search
	 */

    public void setHeadline(String headline) {
        this.headline = headline;
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
	 * 设置：奖惩人 Search
	 */
    public Integer getXsTypes() {
        return xsTypes;
    }


    /**
	 * 获取：奖惩人 Search
	 */

    public void setXsTypes(Integer xsTypes) {
        this.xsTypes = xsTypes;
    }
    /**
	 * 设置：奖惩状态 Search
	 */
    public Integer getJcTypes() {
        return jcTypes;
    }


    /**
	 * 获取：奖惩状态 Search
	 */

    public void setJcTypes(Integer jcTypes) {
        this.jcTypes = jcTypes;
    }
    /**
	 * 设置：奖惩等级 Search
	 */
    public Integer getDjTypes() {
        return djTypes;
    }


    /**
	 * 获取：奖惩等级 Search
	 */

    public void setDjTypes(Integer djTypes) {
        this.djTypes = djTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
	 * 设置：内容信息
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：内容信息
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    }
