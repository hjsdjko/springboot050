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
 * 留言消息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("liuyanxiaoxi")
public class LiuyanxiaoxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LiuyanxiaoxiEntity() {
		
	}
	
	public LiuyanxiaoxiEntity(T t) {
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
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 班级
	 */
					
	private String banji;
	
	/**
	 * 家长账号
	 */
					
	private String jiazhangzhanghao;
	
	/**
	 * 学业情况
	 */
					
	private String xueyeqingkuang;
	
	/**
	 * 行为表现
	 */
					
	private String xingweibiaoxian;
	
	/**
	 * 兴趣爱好
	 */
					
	private String xingquaihao;
	
	/**
	 * 身心健康
	 */
					
	private String shenxinjiankang;
	
	/**
	 * 留言内容
	 */
					
	private String liuyanneirong;
	
	/**
	 * 留言时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date liuyanshijian;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	
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
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：班级
	 */
	public void setBanji(String banji) {
		this.banji = banji;
	}
	/**
	 * 获取：班级
	 */
	public String getBanji() {
		return banji;
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
	 * 设置：学业情况
	 */
	public void setXueyeqingkuang(String xueyeqingkuang) {
		this.xueyeqingkuang = xueyeqingkuang;
	}
	/**
	 * 获取：学业情况
	 */
	public String getXueyeqingkuang() {
		return xueyeqingkuang;
	}
	/**
	 * 设置：行为表现
	 */
	public void setXingweibiaoxian(String xingweibiaoxian) {
		this.xingweibiaoxian = xingweibiaoxian;
	}
	/**
	 * 获取：行为表现
	 */
	public String getXingweibiaoxian() {
		return xingweibiaoxian;
	}
	/**
	 * 设置：兴趣爱好
	 */
	public void setXingquaihao(String xingquaihao) {
		this.xingquaihao = xingquaihao;
	}
	/**
	 * 获取：兴趣爱好
	 */
	public String getXingquaihao() {
		return xingquaihao;
	}
	/**
	 * 设置：身心健康
	 */
	public void setShenxinjiankang(String shenxinjiankang) {
		this.shenxinjiankang = shenxinjiankang;
	}
	/**
	 * 获取：身心健康
	 */
	public String getShenxinjiankang() {
		return shenxinjiankang;
	}
	/**
	 * 设置：留言内容
	 */
	public void setLiuyanneirong(String liuyanneirong) {
		this.liuyanneirong = liuyanneirong;
	}
	/**
	 * 获取：留言内容
	 */
	public String getLiuyanneirong() {
		return liuyanneirong;
	}
	/**
	 * 设置：留言时间
	 */
	public void setLiuyanshijian(Date liuyanshijian) {
		this.liuyanshijian = liuyanshijian;
	}
	/**
	 * 获取：留言时间
	 */
	public Date getLiuyanshijian() {
		return liuyanshijian;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}

}
