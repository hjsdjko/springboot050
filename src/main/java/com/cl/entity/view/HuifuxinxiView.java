package com.cl.entity.view;

import com.cl.entity.HuifuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 回复信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:27
 */
@TableName("huifuxinxi")
public class HuifuxinxiView  extends HuifuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuifuxinxiView(){
	}
 
 	public HuifuxinxiView(HuifuxinxiEntity huifuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, huifuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
