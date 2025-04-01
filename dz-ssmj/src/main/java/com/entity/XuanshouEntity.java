package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 人员表
 *
 * @author 
 * @email
 * @date 2021-03-02
 */
@TableName("xuanshou")
public class XuanshouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XuanshouEntity() {

	}

	public XuanshouEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 比赛名称 Search
     */
    @TableField(value = "name")
    private String name;


    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;


    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;


    /**
     * 头像
     */
    @TableField(value = "img_photo")
    private String imgPhoto;


    /**
     * 出生年月
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy年MM月dd日")
	@DateTimeFormat
    @TableField(value = "dateofbirth_time")
    private Date dateofbirthTime;


    /**
     * 家庭住址
     */
    @TableField(value = "address")
    private String address;


    /**
     * 家庭联系方式
     */
    @TableField(value = "information")
    private String information;


    /**
     * 个人联系方式
     */
    @TableField(value = "grinformation")
    private String grinformation;


    /**
     * 性别 Search
     */
    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 状态 Search
     */
    @TableField(value = "zt_types")
    private Integer ztTypes;


    /**
     * 俱乐部 Search
     */
    @TableField(value = "jlb_types")
    private Integer jlbTypes;


    /**
     * 身份
     */
    @TableField(value = "role")
    private String role;


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
	 * 设置：比赛名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：比赛名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：账号
	 */
    public String getAccount() {
        return account;
    }


    /**
	 * 获取：账号
	 */

    public void setAccount(String account) {
        this.account = account;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：头像
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：出生年月
	 */
    public Date getDateofbirthTime() {
        return dateofbirthTime;
    }


    /**
	 * 获取：出生年月
	 */

    public void setDateofbirthTime(Date dateofbirthTime) {
        this.dateofbirthTime = dateofbirthTime;
    }
    /**
	 * 设置：家庭住址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 获取：家庭住址
	 */

    public void setAddress(String address) {
        this.address = address;
    }
    /**
	 * 设置：家庭联系方式
	 */
    public String getInformation() {
        return information;
    }


    /**
	 * 获取：家庭联系方式
	 */

    public void setInformation(String information) {
        this.information = information;
    }
    /**
	 * 设置：个人联系方式
	 */
    public String getGrinformation() {
        return grinformation;
    }


    /**
	 * 获取：个人联系方式
	 */

    public void setGrinformation(String grinformation) {
        this.grinformation = grinformation;
    }
    /**
	 * 设置：性别 Search
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别 Search
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }

    public Integer getZtTypes() {
        return ztTypes;
    }

    public void setZtTypes(Integer ztTypes) {
        this.ztTypes = ztTypes;
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
	 * 设置：身份
	 */
    public String getRole() {
        return role;
    }


    /**
	 * 获取：身份
	 */

    public void setRole(String role) {
        this.role = role;
    }

}
