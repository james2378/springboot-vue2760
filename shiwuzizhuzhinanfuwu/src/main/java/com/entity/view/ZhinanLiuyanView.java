package com.entity.view;

import com.entity.ZhinanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 信息留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhinan_liuyan")
public class ZhinanLiuyanView extends ZhinanLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 照片
			*/
			private String yonghuPhoto;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

		//级联表 zhinan
			/**
			* 信息标题
			*/
			private String zhinanName;
			/**
			* 信息类型
			*/
			private Integer zhinanTypes;
				/**
				* 信息类型的值
				*/
				private String zhinanValue;
			/**
			* 信息封面
			*/
			private String zhinanPhoto;
			/**
			* 审核结果
			*/
			private Integer zhinanYesnoTypes;
				/**
				* 审核结果的值
				*/
				private String zhinanYesnoValue;
			/**
			* 详情
			*/
			private String zhinanContent;
			/**
			* 假删
			*/
			private Integer zhinanDelete;

	public ZhinanLiuyanView() {

	}

	public ZhinanLiuyanView(ZhinanLiuyanEntity zhinanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zhinanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}


				//级联表的get和set zhinan
					/**
					* 获取： 信息标题
					*/
					public String getZhinanName() {
						return zhinanName;
					}
					/**
					* 设置： 信息标题
					*/
					public void setZhinanName(String zhinanName) {
						this.zhinanName = zhinanName;
					}
					/**
					* 获取： 信息类型
					*/
					public Integer getZhinanTypes() {
						return zhinanTypes;
					}
					/**
					* 设置： 信息类型
					*/
					public void setZhinanTypes(Integer zhinanTypes) {
						this.zhinanTypes = zhinanTypes;
					}


						/**
						* 获取： 信息类型的值
						*/
						public String getZhinanValue() {
							return zhinanValue;
						}
						/**
						* 设置： 信息类型的值
						*/
						public void setZhinanValue(String zhinanValue) {
							this.zhinanValue = zhinanValue;
						}
					/**
					* 获取： 信息封面
					*/
					public String getZhinanPhoto() {
						return zhinanPhoto;
					}
					/**
					* 设置： 信息封面
					*/
					public void setZhinanPhoto(String zhinanPhoto) {
						this.zhinanPhoto = zhinanPhoto;
					}
					/**
					* 获取： 审核结果
					*/
					public Integer getZhinanYesnoTypes() {
						return zhinanYesnoTypes;
					}
					/**
					* 设置： 审核结果
					*/
					public void setZhinanYesnoTypes(Integer zhinanYesnoTypes) {
						this.zhinanYesnoTypes = zhinanYesnoTypes;
					}


						/**
						* 获取： 审核结果的值
						*/
						public String getZhinanYesnoValue() {
							return zhinanYesnoValue;
						}
						/**
						* 设置： 审核结果的值
						*/
						public void setZhinanYesnoValue(String zhinanYesnoValue) {
							this.zhinanYesnoValue = zhinanYesnoValue;
						}
					/**
					* 获取： 详情
					*/
					public String getZhinanContent() {
						return zhinanContent;
					}
					/**
					* 设置： 详情
					*/
					public void setZhinanContent(String zhinanContent) {
						this.zhinanContent = zhinanContent;
					}
					/**
					* 获取： 假删
					*/
					public Integer getZhinanDelete() {
						return zhinanDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setZhinanDelete(Integer zhinanDelete) {
						this.zhinanDelete = zhinanDelete;
					}







}
