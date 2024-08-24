package com.cl.entity;

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
 * 问卷调查
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("wenjuandiaocha")
public class WenjuandiaochaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WenjuandiaochaEntity() {
		
	}
	
	public WenjuandiaochaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 问卷主题
	 */
					
	private String wenjuanzhuti;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 调查内容
	 */
					
	private String diaochaneirong;
	
	/**
	 * 调查描述
	 */
					
	private String diaochamiaoshu;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：问卷主题
	 */
	public void setWenjuanzhuti(String wenjuanzhuti) {
		this.wenjuanzhuti = wenjuanzhuti;
	}
	/**
	 * 获取：问卷主题
	 */
	public String getWenjuanzhuti() {
		return wenjuanzhuti;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：调查内容
	 */
	public void setDiaochaneirong(String diaochaneirong) {
		this.diaochaneirong = diaochaneirong;
	}
	/**
	 * 获取：调查内容
	 */
	public String getDiaochaneirong() {
		return diaochaneirong;
	}
	/**
	 * 设置：调查描述
	 */
	public void setDiaochamiaoshu(String diaochamiaoshu) {
		this.diaochamiaoshu = diaochamiaoshu;
	}
	/**
	 * 获取：调查描述
	 */
	public String getDiaochamiaoshu() {
		return diaochamiaoshu;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}

}
