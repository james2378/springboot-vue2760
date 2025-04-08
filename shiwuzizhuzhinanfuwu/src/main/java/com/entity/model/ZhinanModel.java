package com.entity.model;

import com.entity.ZhinanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 指南信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhinanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 信息标题
     */
    private String zhinanName;


    /**
     * 信息类型
     */
    private Integer zhinanTypes;


    /**
     * 信息封面
     */
    private String zhinanPhoto;


    /**
     * 教师
     */
    private Integer jiaoshiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 审核结果
     */
    private Integer zhinanYesnoTypes;


    /**
     * 详情
     */
    private String zhinanContent;


    /**
     * 假删
     */
    private Integer zhinanDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：信息标题
	 */
    public String getZhinanName() {
        return zhinanName;
    }


    /**
	 * 设置：信息标题
	 */
    public void setZhinanName(String zhinanName) {
        this.zhinanName = zhinanName;
    }
    /**
	 * 获取：信息类型
	 */
    public Integer getZhinanTypes() {
        return zhinanTypes;
    }


    /**
	 * 设置：信息类型
	 */
    public void setZhinanTypes(Integer zhinanTypes) {
        this.zhinanTypes = zhinanTypes;
    }
    /**
	 * 获取：信息封面
	 */
    public String getZhinanPhoto() {
        return zhinanPhoto;
    }


    /**
	 * 设置：信息封面
	 */
    public void setZhinanPhoto(String zhinanPhoto) {
        this.zhinanPhoto = zhinanPhoto;
    }
    /**
	 * 获取：教师
	 */
    public Integer getJiaoshiId() {
        return jiaoshiId;
    }


    /**
	 * 设置：教师
	 */
    public void setJiaoshiId(Integer jiaoshiId) {
        this.jiaoshiId = jiaoshiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：审核结果
	 */
    public Integer getZhinanYesnoTypes() {
        return zhinanYesnoTypes;
    }


    /**
	 * 设置：审核结果
	 */
    public void setZhinanYesnoTypes(Integer zhinanYesnoTypes) {
        this.zhinanYesnoTypes = zhinanYesnoTypes;
    }
    /**
	 * 获取：详情
	 */
    public String getZhinanContent() {
        return zhinanContent;
    }


    /**
	 * 设置：详情
	 */
    public void setZhinanContent(String zhinanContent) {
        this.zhinanContent = zhinanContent;
    }
    /**
	 * 获取：假删
	 */
    public Integer getZhinanDelete() {
        return zhinanDelete;
    }


    /**
	 * 设置：假删
	 */
    public void setZhinanDelete(Integer zhinanDelete) {
        this.zhinanDelete = zhinanDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
