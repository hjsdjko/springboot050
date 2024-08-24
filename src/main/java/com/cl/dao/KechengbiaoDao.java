package com.cl.dao;

import com.cl.entity.KechengbiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengbiaoView;


/**
 * 课程表
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface KechengbiaoDao extends BaseMapper<KechengbiaoEntity> {
	
	List<KechengbiaoView> selectListView(@Param("ew") Wrapper<KechengbiaoEntity> wrapper);

	List<KechengbiaoView> selectListView(Pagination page,@Param("ew") Wrapper<KechengbiaoEntity> wrapper);
	
	KechengbiaoView selectView(@Param("ew") Wrapper<KechengbiaoEntity> wrapper);
	
	List<KechengbiaoView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KechengbiaoEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengbiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengbiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengbiaoEntity> wrapper);



}
