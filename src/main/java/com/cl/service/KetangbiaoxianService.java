package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KetangbiaoxianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KetangbiaoxianView;


/**
 * 课堂表现
 *
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface KetangbiaoxianService extends IService<KetangbiaoxianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KetangbiaoxianView> selectListView(Wrapper<KetangbiaoxianEntity> wrapper);
   	
   	KetangbiaoxianView selectView(@Param("ew") Wrapper<KetangbiaoxianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KetangbiaoxianEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KetangbiaoxianEntity> wrapper);

}

