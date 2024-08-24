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
 * 反馈意见
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("fankuiyijian")
public class FankuiyijianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FankuiyijianEntity() {
		
	}
	
	public FankuiyijianEntity(T t) {
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
	 * 反馈内容
	 */
					
	private String fankuineirong;
	
	/**
	 * 反馈时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fankuishijian;
	
	/**
	 * 家长账号
	 */
					
	private String jiazhangzhanghao;
	
	/**
	 * 家长姓名
	 */
					
	private String jiazhangxingming;
	
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	
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
	 * 设置：反馈内容
	 */
	public void setFankuineirong(String fankuineirong) {
		this.fankuineirong = fankuineirong;
	}
	/**
	 * 获取：反馈内容
	 */
	public String getFankuineirong() {
		return fankuineirong;
	}
	/**
	 * 设置：反馈时间
	 */
	public void setFankuishijian(Date fankuishijian) {
		this.fankuishijian = fankuishijian;
	}
	/**
	 * 获取：反馈时间
	 */
	public Date getFankuishijian() {
		return fankuishijian;
	}
	/**
	 * 设置：家长账号
	 */
	public void setJiazhangzhanghao(String jiazhangzhanghao) {
		this.jiazhangzhanghao = jiazhangzhanghao;
	}
	/**
	 * 获取：家长账号
	 */
	public String getJiazhangzhanghao() {
		return jiazhangzhanghao;
	}
	/**
	 * 设置：家长姓名
	 */
	public void setJiazhangxingming(String jiazhangxingming) {
		this.jiazhangxingming = jiazhangxingming;
	}
	/**
	 * 获取：家长姓名
	 */
	public String getJiazhangxingming() {
		return jiazhangxingming;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}

}
