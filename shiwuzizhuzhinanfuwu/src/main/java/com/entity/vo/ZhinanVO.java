package com.entity.vo;

import com.entity.ZhinanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 指南信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhinan")
public class ZhinanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
