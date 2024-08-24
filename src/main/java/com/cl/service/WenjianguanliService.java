package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenjianguanliEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenjianguanliView;


/**
 * 文件管理
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface WenjianguanliService extends IService<WenjianguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenjianguanliView> selectListView(Wrapper<WenjianguanliEntity> wrapper);
   	
   	WenjianguanliView selectView(@Param("ew") Wrapper<WenjianguanliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenjianguanliEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<WenjianguanliEntity> wrapper);

}

