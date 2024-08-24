package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.QingjiashenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QingjiashenqingView;


/**
 * 请假申请
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface QingjiashenqingService extends IService<QingjiashenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QingjiashenqingView> selectListView(Wrapper<QingjiashenqingEntity> wrapper);
   	
   	QingjiashenqingView selectView(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QingjiashenqingEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<QingjiashenqingEntity> wrapper);

}

