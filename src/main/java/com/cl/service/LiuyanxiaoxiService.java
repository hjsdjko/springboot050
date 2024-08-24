package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.LiuyanxiaoxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LiuyanxiaoxiView;


/**
 * 留言消息
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface LiuyanxiaoxiService extends IService<LiuyanxiaoxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LiuyanxiaoxiView> selectListView(Wrapper<LiuyanxiaoxiEntity> wrapper);
   	
   	LiuyanxiaoxiView selectView(@Param("ew") Wrapper<LiuyanxiaoxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LiuyanxiaoxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<LiuyanxiaoxiEntity> wrapper);

}

