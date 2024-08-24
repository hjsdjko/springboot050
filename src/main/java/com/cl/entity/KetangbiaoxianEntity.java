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
 * 课堂表现
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("ketangbiaoxian")
public class KetangbiaoxianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KetangbiaoxianEntity() {
		
	}
	
	public KetangbiaoxianEntity(T t) {
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
	 * 家长账号
	 */
					
	private String jiazhangzhanghao;
	
	/**
	 * 家长姓名
	 */
					
	private String jiazhangxingming;
	
	/**
	 * 参与度
	 */
					
	private String canyudu;
	
	/**
	 * 注意力
	 */
					
	private String zhuyili;
	
	/**
	 * 学习态度
	 */
					
	private String xuexitaidu;
	
	/**
	 * 课堂纪律
	 */
					
	private String ketangjilv;
	
	/**
	 * 表达能力
	 */
					
	private String biaodanengli;
	
	/**
	 * 进步情况
	 */
					
	private String jinbuqingkuang;
	
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
	 * 设置：参与度
	 */
	public void setCanyudu(String canyudu) {
		this.canyudu = canyudu;
	}
	/**
	 * 获取：参与度
	 */
	public String getCanyudu() {
		return canyudu;
	}
	/**
	 * 设置：注意力
	 */
	public void setZhuyili(String zhuyili) {
		this.zhuyili = zhuyili;
	}
	/**
	 * 获取：注意力
	 */
	public String getZhuyili() {
		return zhuyili;
	}
	/**
	 * 设置：学习态度
	 */
	public void setXuexitaidu(String xuexitaidu) {
		this.xuexitaidu = xuexitaidu;
	}
	/**
	 * 获取：学习态度
	 */
	public String getXuexitaidu() {
		return xuexitaidu;
	}
	/**
	 * 设置：课堂纪律
	 */
	public void setKetangjilv(String ketangjilv) {
		this.ketangjilv = ketangjilv;
	}
	/**
	 * 获取：课堂纪律
	 */
	public String getKetangjilv() {
		return ketangjilv;
	}
	/**
	 * 设置：表达能力
	 */
	public void setBiaodanengli(String biaodanengli) {
		this.biaodanengli = biaodanengli;
	}
	/**
	 * 获取：表达能力
	 */
	public String getBiaodanengli() {
		return biaodanengli;
	}
	/**
	 * 设置：进步情况
	 */
	public void setJinbuqingkuang(String jinbuqingkuang) {
		this.jinbuqingkuang = jinbuqingkuang;
	}
	/**
	 * 获取：进步情况
	 */
	public String getJinbuqingkuang() {
		return jinbuqingkuang;
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
