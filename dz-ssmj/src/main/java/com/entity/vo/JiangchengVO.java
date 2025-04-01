package com.entity.vo;

import com.entity.JiangchengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 奖惩表
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("jiangcheng")
public class JiangchengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 标题 Search
     */

    @TableField(value = "headline")
    private String headline;


    /**
     * 俱乐部 Search
     */

    @TableField(value = "jlb_types")
    private Integer jlbTypes;


    /**
     * 奖惩人 Search
     */

    @TableField(value = "xs_types")
    private Integer xsTypes;


    /**
     * 奖惩状态 Search
     */

    @TableField(value = "jc_types")
    private Integer jcTypes;


    /**
     * 奖惩等级 Search
     */

    @TableField(value = "dj_types")
    private Integer djTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
     * 内容信息
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
