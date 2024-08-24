package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.HuifuxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuifuxinxiView;


/**
 * 回复信息
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:27
 */
public interface HuifuxinxiService extends IService<HuifuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuifuxinxiView> selectListView(Wrapper<HuifuxinxiEntity> wrapper);
   	
   	HuifuxinxiView selectView(@Param("ew") Wrapper<HuifuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuifuxinxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<HuifuxinxiEntity> wrapper);

}

