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
 * 文件管理
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("wenjianguanli")
public class WenjianguanliEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WenjianguanliEntity() {
		
	}
	
	public WenjianguanliEntity(T t) {
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
	 * 文件编号
	 */
					
	private String wenjianbianhao;
	
	/**
	 * 文件名称
	 */
					
	private String wenjianmingcheng;
	
	/**
	 * 文件
	 */
					
	private String wenjian;
	
	
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
	 * 设置：文件编号
	 */
	public void setWenjianbianhao(String wenjianbianhao) {
		this.wenjianbianhao = wenjianbianhao;
	}
	/**
	 * 获取：文件编号
	 */
	public String getWenjianbianhao() {
		return wenjianbianhao;
	}
	/**
	 * 设置：文件名称
	 */
	public void setWenjianmingcheng(String wenjianmingcheng) {
		this.wenjianmingcheng = wenjianmingcheng;
	}
	/**
	 * 获取：文件名称
	 */
	public String getWenjianmingcheng() {
		return wenjianmingcheng;
	}
	/**
	 * 设置：文件
	 */
	public void setWenjian(String wenjian) {
		this.wenjian = wenjian;
	}
	/**
	 * 获取：文件
	 */
	public String getWenjian() {
		return wenjian;
	}

}
