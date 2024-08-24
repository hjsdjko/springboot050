package com.cl.entity.view;

import com.cl.entity.TongzhigonggaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 通知公告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@TableName("tongzhigonggao")
public class TongzhigonggaoView  extends TongzhigonggaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TongzhigonggaoView(){
	}
 
 	public TongzhigonggaoView(TongzhigonggaoEntity tongzhigonggaoEntity){
 	try {
			BeanUtils.copyProperties(this, tongzhigonggaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
