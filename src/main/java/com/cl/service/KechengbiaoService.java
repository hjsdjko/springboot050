package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengbiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengbiaoView;


/**
 * 课程表
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface KechengbiaoService extends IService<KechengbiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengbiaoView> selectListView(Wrapper<KechengbiaoEntity> wrapper);
   	
   	KechengbiaoView selectView(@Param("ew") Wrapper<KechengbiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengbiaoEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KechengbiaoEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<KechengbiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<KechengbiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<KechengbiaoEntity> wrapper);



}

