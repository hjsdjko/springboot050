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
 * 课程表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("kechengbiao")
public class KechengbiaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KechengbiaoEntity() {
		
	}
	
	public KechengbiaoEntity(T t) {
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
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 课程简介
	 */
					
	private String kechengjianjie;
	
	/**
	 * 上课时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shangkeshijian;
	
	/**
	 * 上课地点
	 */
					
	private String shangkedidian;
	
	
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
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：课程简介
	 */
	public void setKechengjianjie(String kechengjianjie) {
		this.kechengjianjie = kechengjianjie;
	}
	/**
	 * 获取：课程简介
	 */
	public String getKechengjianjie() {
		return kechengjianjie;
	}
	/**
	 * 设置：上课时间
	 */
	public void setShangkeshijian(Date shangkeshijian) {
		this.shangkeshijian = shangkeshijian;
	}
	/**
	 * 获取：上课时间
	 */
	public Date getShangkeshijian() {
		return shangkeshijian;
	}
	/**
	 * 设置：上课地点
	 */
	public void setShangkedidian(String shangkedidian) {
		this.shangkedidian = shangkedidian;
	}
	/**
	 * 获取：上课地点
	 */
	public String getShangkedidian() {
		return shangkedidian;
	}

}
