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
 * 指南信息
 *
 * @author 
 * @email
 */
@TableName("zhinan")
public class ZhinanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhinanEntity() {

	}

	public ZhinanEntity(T t) {
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
     * 信息标题
     */
    @TableField(value = "zhinan_name")

    private String zhinanName;


    /**
     * 信息类型
     */
    @TableField(value = "zhinan_types")

    private Integer zhinanTypes;


    /**
     * 信息封面
     */
    @TableField(value = "zhinan_photo")

    private String zhinanPhoto;


    /**
     * 教师
     */
    @TableField(value = "jiaoshi_id")

    private Integer jiaoshiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 审核结果
     */
    @TableField(value = "zhinan_yesno_types")

    private Integer zhinanYesnoTypes;


    /**
     * 详情
     */
    @TableField(value = "zhinan_content")

    private String zhinanContent;


    /**
     * 假删
     */
    @TableField(value = "zhinan_delete")

    private Integer zhinanDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


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
	 * 设置：信息标题
	 */
    public String getZhinanName() {
        return zhinanName;
    }


    /**
	 * 获取：信息标题
	 */

    public void setZhinanName(String zhinanName) {
        this.zhinanName = zhinanName;
    }
    /**
	 * 设置：信息类型
	 */
    public Integer getZhinanTypes() {
        return zhinanTypes;
    }


    /**
	 * 获取：信息类型
	 */

    public void setZhinanTypes(Integer zhinanTypes) {
        this.zhinanTypes = zhinanTypes;
    }
    /**
	 * 设置：信息封面
	 */
    public String getZhinanPhoto() {
        return zhinanPhoto;
    }


    /**
	 * 获取：信息封面
	 */

    public void setZhinanPhoto(String zhinanPhoto) {
        this.zhinanPhoto = zhinanPhoto;
    }
    /**
	 * 设置：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 获取：教师
	 */

    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：审核结果
	 */
    public Integer getZhinanYesnoTypes() {
        return zhinanYesnoTypes;
    }


    /**
	 * 获取：审核结果
	 */

    public void setZhinanYesnoTypes(Integer zhinanYesnoTypes) {
        this.zhinanYesnoTypes = zhinanYesnoTypes;
    }
    /**
	 * 设置：详情
	 */
    public String getZhinanContent() {
        return zhinanContent;
    }


    /**
	 * 获取：详情
	 */

    public void setZhinanContent(String zhinanContent) {
        this.zhinanContent = zhinanContent;
    }
    /**
	 * 设置：假删
	 */
    public Integer getZhinanDelete() {
        return zhinanDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setZhinanDelete(Integer zhinanDelete) {
        this.zhinanDelete = zhinanDelete;
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

    @Override
    public String toString() {
        return "Zhinan{" +
            "id=" + id +
            ", zhinanName=" + zhinanName +
            ", zhinanTypes=" + zhinanTypes +
            ", zhinanPhoto=" + zhinanPhoto +
            ", jiaoshiId=" + jiaoshiId +
            ", yonghuId=" + yonghuId +
            ", zhinanYesnoTypes=" + zhinanYesnoTypes +
            ", zhinanContent=" + zhinanContent +
            ", zhinanDelete=" + zhinanDelete +
            ", createTime=" + createTime +
        "}";
    }
}
