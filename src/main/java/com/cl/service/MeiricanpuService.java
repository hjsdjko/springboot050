package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MeiricanpuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MeiricanpuView;


/**
 * 每日餐谱
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface MeiricanpuService extends IService<MeiricanpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeiricanpuView> selectListView(Wrapper<MeiricanpuEntity> wrapper);
   	
   	MeiricanpuView selectView(@Param("ew") Wrapper<MeiricanpuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeiricanpuEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<MeiricanpuEntity> wrapper);

}

